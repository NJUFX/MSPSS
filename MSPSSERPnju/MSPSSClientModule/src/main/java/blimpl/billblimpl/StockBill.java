package blimpl.billblimpl;

import blservice.commodityblservice.CommodityInfoService;
import blservice.stockbl.StockBLInfo;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkService;
import po.StockBillItemPO;
import po.StockBillPO;
import util.*;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:22 2017/11/21/021
 */
public class StockBill {
    private BillClientNetworkService networkService;
    private CommodityInfoService commodityInfoService;
    private UserInfo userInfo;
    private StockBLInfo stockBLInfo;

    /**
     * 添加库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage saveStockBill(StockBillVO vo) {
        //赋值单据的状态
        vo.setStatus(BillStatus.init);
        //如果是第一次保存 记录下保存时间
        if (vo.init_time == null) {
            vo.setInit_time(new Time());
        }
        //判断是否是第一次保存 是的话赋值ID,并在数据层添加po
        //否则在数据层 更新po
        boolean isSaved = vo.getId() != null;
        if (vo.getId() == null) {
            String id = getID(vo.type);
            vo.setId(id);
        }

        StockBillPO po = vo_to_po(vo);
        if (isSaved)
            return networkService.updateStockBill(po);
        else
            return networkService.addStockBill(po);
    }

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage commitStockBill(StockBillVO vo) {
        vo.setStatus(BillStatus.commit);
        vo.setCommit_time(new Time());
        StockBillPO po = vo_to_po(vo);
        return networkService.updateStockBill(po);
    }


    /**
     * 撤回库存类单据 （status为commit)
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawStockBill(StockBillVO vo) {
        vo.setStatus(BillStatus.init);
        vo.setCommit_time(null);
        StockBillPO po = vo_to_po(vo);
        return networkService.updateStockBill(po);
    }

    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */

    public ArrayList<StockBillVO> getMyStockBill(String operatorID) {
        ArrayList<StockBillPO> pos = networkService.fullSearchStockBill("operatorID", operatorID);

        return pos_to_vos(pos);
    }

    public ArrayList<StockBillVO> getWaitingStockBill() {
        ArrayList<StockBillPO> pos = networkService.fullSearchStockBill("status", BillStatus.commit);

        return pos_to_vos(pos);
    }


    public ResultMessage deleteStockBill(StockBillVO vo) {
        return networkService.deleteStockBill(vo.id);
    }

    /**
     * 存疑 有需要时再写
     *
     * @param flagVO
     * @return
     */
    public ArrayList<StockBillVO> searchStockBill(FilterFlagVO flagVO) {

        return new ArrayList<>();
    }


    public ResultMessage approveStockBill(StockBillVO stockBillVO) {
        stockBillVO.setStatus(BillStatus.approval);
        stockBillVO.setApproval_time(new Time());
        //更新单据信息

        ArrayList<StockBillItemVO> itemVOS = stockBillVO.getItemVOS();
        ArrayList<ChangeInfoVO> changeInfoVOS = new ArrayList<>();
        StockInfo info = (stockBillVO.type == StockBillType.More) ? StockInfo.Out : StockInfo.In;
        for (int i = 0; i < itemVOS.size(); i++) {
            StockBillItemVO itemVO = itemVOS.get(i);
            ChangeInfoVO changeInfoVO;
            if (info == StockInfo.In) {
                changeInfoVO = new ChangeInfoVO(itemVO.commodityVO.ID, itemVO.number, info, stockBillVO.approval_time.toString(), itemVO.commodityVO.importCost * itemVO.number);
            } else {
                changeInfoVO = new ChangeInfoVO(itemVO.commodityVO.ID, itemVO.number, info, stockBillVO.approval_time.toString(), itemVO.commodityVO.exportCost * itemVO.number);
            }
            changeInfoVOS.add(changeInfoVO);
        }
        stockBLInfo.updateStock(changeInfoVOS);
        //更新每一个商品的库存
        for (int i = 0; i < itemVOS.size(); i++) {
            CommodityVO commodityVO = itemVOS.get(i).commodityVO;
            commodityVO.setNumberInStock(commodityVO.getNumberInStock() - itemVOS.get(i).getNumber());
            commodityInfoService.updateCommodity(commodityVO);
        }

        return networkService.updateStockBill(vo_to_po(stockBillVO));
    }

    public ResultMessage rejectStockBill(StockBillVO stockBillVO) {
        stockBillVO.setApproval_time(new Time());
        stockBillVO.setStatus(BillStatus.rejected);
        //设置审批时间
        //设置审批状态为拒绝

        return networkService.updateStockBill(vo_to_po(stockBillVO));
    }

    public String getID(StockBillType type) {
        return networkService.getStockBillID(type);
    }
    private StockBillVO po_to_vo(StockBillPO po){
        ArrayList<StockBillItemVO> itemVOS = new ArrayList<>();
        for (int i = 0; i <  po.getItemPOS().size(); i++) {
            StockBillItemPO itemPO = po.getItemPOS().get(i);
            StockBillItemVO itemVO = new StockBillItemVO(commodityInfoService.getCommodity(itemPO.getCommodityID()),itemPO.getNumber());
            itemVOS.add(itemVO);
        }
        UserVO operator = userInfo.getUser(po.getInitID());
        UserVO approval = po.getApprovalID() != null ? userInfo.getUser(po.getApprovalID()) : null;
        Time commitTime = po.getCommit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getApproval_time() != null ? new Time(po.getApproval_time()) : null;

        StockBillVO stockBillVO = new StockBillVO(po.getID(), StockBillType.values()[po.getType()],
                BillStatus.values()[po.getStatus()], itemVOS, new Time(po.getInit_time()),
                commitTime, approvalTime, po.getCommentByStockManager(), po.getCommentByManager()
                , operator, approval);
        return  stockBillVO;
    }
    private StockBillPO vo_to_po(StockBillVO vo){
        ArrayList<StockBillItemPO> itemPOS = new ArrayList<>();
        for (int i = 0; i < vo.getItemVOS().size() ; i++) {
            StockBillItemVO itemVO = vo.getItemVOS().get(i);
            StockBillItemPO itemPO = new StockBillItemPO(itemVO.commodityVO.ID,itemVO.number);
            itemPOS.add(itemPO);
        }

        StockBillPO po = new StockBillPO(vo.getId(), vo.getType().ordinal(), vo.getStatus().ordinal(), itemPOS, vo.init_time.toString(), vo.commit_time.toString(), vo.approval_time.toString()
                , vo.commentByStockManager, vo.commentByManager, vo.stockManager.getID(), vo.getManager().getID());
        return po;
    }

    private ArrayList<StockBillVO> pos_to_vos(ArrayList<StockBillPO> pos) {
        ArrayList<StockBillVO> vos = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++) {
            StockBillPO po = pos.get(i);
            vos.add(po_to_vo(po));
        }
        return vos;
    }
}
