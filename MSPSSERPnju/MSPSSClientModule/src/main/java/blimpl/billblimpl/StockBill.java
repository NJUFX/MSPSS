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
    BillClientNetworkService networkService;
    CommodityInfoService commodityInfoService;
    UserInfo userInfo;
    StockBLInfo stockBLInfo;

    public ResultMessage addStockBill(StockBillVO stockBillVO){
       return networkService.addStockBill(vo_to_po(stockBillVO));
    }

    public ResultMessage updateStockBill(StockBillVO stockBillVO){
        return networkService.updateStockBill(vo_to_po(stockBillVO));
    }

    public ResultMessage deleteStockBill(StockBillVO vo) {
        return networkService.deleteStockBill(vo.id);
    }

    public ResultMessage check(StockBillVO stockBillVO){
        if (stockBillVO.status== BillStatus.rejected)
        return     updateStockBill(stockBillVO);
        else
        {
            //更新单据信息
            updateStockBill(stockBillVO);
              ArrayList<StockBillItemVO> itemVOS  =  stockBillVO.getItemVOS();
            ArrayList<ChangeInfoVO> changeInfoVOS = new ArrayList<>();
            StockInfo info = (stockBillVO.type== StockBillType.More) ? StockInfo.Out:StockInfo.In;
            for (int i = 0; i < itemVOS.size() ; i++) {
                StockBillItemVO itemVO = itemVOS.get(i);
                ChangeInfoVO changeInfoVO;
                if (info==StockInfo.In)
                {
                     changeInfoVO = new ChangeInfoVO(itemVO.commodityVO.ID,itemVO.number,info,stockBillVO.approval_time.toString(),itemVO.commodityVO.importCost*itemVO.number);
                }
                else
                {
                     changeInfoVO = new ChangeInfoVO(itemVO.commodityVO.ID,itemVO.number,info,stockBillVO.approval_time.toString(),itemVO.commodityVO.exportCost*itemVO.number);
                }
                changeInfoVOS.add(changeInfoVO);
            }
            stockBLInfo.updateStock(changeInfoVOS);
            //更新每一个商品的库存
            for(int i = 0;i < itemVOS.size();i++){
                CommodityVO commodityVO = itemVOS.get(i).commodityVO;
                commodityVO.setNumberInStock(commodityVO.getNumberInStock()-itemVOS.get(i).getNumber());
                commodityInfoService.updateCommodity(commodityVO);
            }
        }
        return ResultMessage.SUCCESS;
    }
    public ArrayList<StockBillVO> searchStockBill(FilterFlagVO flagVO){
        return null;
    }
    private StockBillVO po_to_vo(StockBillPO po){
        ArrayList<StockBillItemVO> itemVOS = new ArrayList<>();
        for (int i = 0; i <  po.getItemPOS().size(); i++) {
            StockBillItemPO itemPO = po.getItemPOS().get(i);
            StockBillItemVO itemVO = new StockBillItemVO(commodityInfoService.getCommodity(itemPO.getCommodityID()),itemPO.getNumber());
            itemVOS.add(itemVO);
        }
        StockBillVO stockBillVO = new StockBillVO("1",po.getType(),po.getStatus(),itemVOS,new Time(po.getInit_time()),new Time(po.getCommit_time()),new Time(po.getApproval_time()),po.getCommentByStockManager(),po.getCommentByManager()

        ,userInfo.getUser(po.getInitID()),userInfo.getUser(po.getApprovalID()));
        return  stockBillVO;
    }
    private StockBillPO vo_to_po(StockBillVO vo){
        ArrayList<StockBillItemPO> itemPOS = new ArrayList<>();
        for (int i = 0; i < vo.getItemVOS().size() ; i++) {
            StockBillItemVO itemVO = vo.getItemVOS().get(i);
            StockBillItemPO itemPO = new StockBillItemPO(itemVO.commodityVO.ID,itemVO.number);
            itemPOS.add(itemPO);
        }
        StockBillPO po = new StockBillPO(vo.type,vo.status,itemPOS,vo.init_time.toString(),vo.commit_time.toString(),vo.approval_time.toString()
        ,vo.commentByStockManager,vo.commentByManager,vo.stockManager.getID(),vo.getManager().getID());
        return po;
    }


}
