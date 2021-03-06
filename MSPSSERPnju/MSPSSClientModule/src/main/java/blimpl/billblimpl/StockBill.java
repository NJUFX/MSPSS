package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.StockBillInfo;
import blservice.commodityblservice.CommodityInfoService;
import blservice.stockbl.StockBLInfo;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import po.StockBillItemPO;
import po.StockBillPO;
import util.*;
import vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 13:22 2017/11/21/021
 */
public class StockBill implements StockBillInfo {
    private BillClientNetworkService networkService = new BillClientNetworkImpl();
    private CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    private UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private StockBLInfo stockBLInfo = new BLFactoryImpl().getStockBLInfo();

    @Override
    public ResultMessage addStockPresentationBill(List<PresentationCommodityItemVO> list, String ps) {
        ArrayList<StockBillItemVO> itemVOS = new ArrayList<>();
        if (list==null)
            return ResultMessage.FAILED;
        for (PresentationCommodityItemVO pre : list) {
            CommodityVO commodityVO = commodityInfoService.getCommodity(pre.getCommodityID());
            itemVOS.add(new StockBillItemVO(commodityVO, pre.getNumber()));
        }
        StockBillVO vo = new StockBillVO(StockBillType.Presentation, itemVOS, "由销售策略产生赠送单而产生" + ps, userInfo.getStockManager());

        saveStockBill(vo);

        return commitStockBill(vo);
    }


    public ResultMessage HongChong(StockBillVO stockBillVO) {
        String ID = stockBillVO.getId() + "HC";
        stockBillVO.setInit_time(new Time());
        stockBillVO.setCommit_time(new Time());
        stockBillVO.setApproval_time(new Time());
        for (StockBillItemVO item : stockBillVO.getItemVOS()) {
            int number = item.getNumber() * -1;
        }
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
        return networkService.addStockBill(vo_to_po(stockBillVO));
    }

    public ResultMessage HongChongAndCopy(StockBillVO stockBillVO) {
        String ID = stockBillVO.getId() + "HCCopy";
        stockBillVO.setInit_time(new Time());
        stockBillVO.setCommit_time(new Time());
        stockBillVO.setApproval_time(new Time());

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
        return networkService.addStockBill(vo_to_po(stockBillVO));
    }

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
        if (isSaved) {
            BillLogHelper.update(userInfo.getCurrentUser(), vo.getId());
            return networkService.updateStockBill(po);
        } else {
            BillLogHelper.init(userInfo.getCurrentUser(), vo.getId());
            return networkService.addStockBill(po);
        }
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
        BillSendMessage.commit(userInfo.getCurrentUser(), vo.getId());
        BillLogHelper.commit(userInfo.getCurrentUser(), vo.getId());
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
        BillSendMessage.withdraw(userInfo.getCurrentUser(), vo.getId());
        BillLogHelper.withdraw(userInfo.getCurrentUser(), vo.getId());
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
        ArrayList<StockBillPO> pos = networkService.fullSearchStockBill("initID", operatorID);

        return pos_to_vos(pos);
    }

    public ArrayList<StockBillVO> getWaitingStockBill() {
        ArrayList<StockBillPO> pos = networkService.fullSearchStockBill("status", BillStatus.commit.ordinal());

        return pos_to_vos(pos);
    }


    public ResultMessage deleteStockBill(StockBillVO vo) {
        return networkService.deleteStockBill(vo.id);
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
        BillSendMessage.approve(stockBillVO.getStockManager(), stockBillVO.getManager(), stockBillVO.getId());
        BillLogHelper.approval(userInfo.getCurrentUser(), stockBillVO.getId());
        return networkService.updateStockBill(vo_to_po(stockBillVO));
    }

    public ResultMessage rejectStockBill(StockBillVO stockBillVO) {
        stockBillVO.setApproval_time(new Time());
        stockBillVO.setStatus(BillStatus.rejected);
        //设置审批时间
        //设置审批状态为拒绝
        BillSendMessage.reject(stockBillVO.getStockManager(), stockBillVO.getManager(), stockBillVO.getId());
        BillLogHelper.reject(userInfo.getCurrentUser(), stockBillVO.getId());
        return networkService.updateStockBill(vo_to_po(stockBillVO));
    }

    public String getID(StockBillType type) {
        return networkService.getStockBillID(type);
    }

    public StockBillVO po_to_vo(StockBillPO po) {
        ArrayList<StockBillItemVO> itemVOS = new ArrayList<>();
        for (int i = 0; i < po.getItemPOS().size(); i++) {
            StockBillItemPO itemPO = po.getItemPOS().get(i);
            System.out.println(itemPO.getCommodityID());
            StockBillItemVO itemVO = new StockBillItemVO(commodityInfoService.getCommodity(itemPO.getCommodityID()), itemPO.getNumber());
            itemVOS.add(itemVO);
        }
        UserVO operator = po.getInitID()!=null ?  userInfo.getUser(po.getInitID()) : null;
        UserVO approval = po.getApprovalID() != null ? userInfo.getUser(po.getApprovalID()) : null;
        Time commitTime = po.getCommit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getApproval_time() != null ? new Time(po.getApproval_time()) : null;

        StockBillVO stockBillVO = new StockBillVO(po.getID(), StockBillType.values()[po.getType()],
                BillStatus.values()[po.getStatus()], itemVOS, new Time(po.getInit_time()),
                commitTime, approvalTime, po.getCommentByStockManager(), po.getCommentByManager()
                , operator, approval);
        return stockBillVO;
    }

    private StockBillPO vo_to_po(StockBillVO vo) {
        ArrayList<StockBillItemPO> itemPOS = new ArrayList<>();
        for (int i = 0; i < vo.getItemVOS().size(); i++) {
            StockBillItemVO itemVO = vo.getItemVOS().get(i);
            System.out.println("1"+itemVO.getCommodityVO().getID());
            StockBillItemPO itemPO = new StockBillItemPO(itemVO.commodityVO.getID(), itemVO.number);
            System.out.println("2"+itemPO.getCommodityID());
            itemPOS.add(itemPO);
        }
        String stockmanagerID = vo.getStockManager() != null ? vo.getStockManager().getID() : null;
        String managerID = vo.getManager() !=null ? vo.getManager().getID() : null;
        String initTime = vo.getInit_time()!=null ? vo.getInit_time().toString() : null;
        String commitTime = vo.getCommit_time() !=null ? vo.getCommit_time().toString() :null;
        String approvalTime = vo.getApproval_time() != null ? vo.getApproval_time().toString() : null;
        StockBillPO po = new StockBillPO(vo.getId(), vo.getType().ordinal(), vo.getStatus().ordinal(), itemPOS, initTime, commitTime, approvalTime
                , vo.commentByStockManager, vo.commentByManager, stockmanagerID, managerID);
        for (int i = 0; i < itemPOS.size() ; i++) {
            itemPOS.get(i).setStockBillPO(po);
        }
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
