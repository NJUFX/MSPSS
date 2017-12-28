package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkService;
import po.SalesItemPO;
import po.SalesOutBillPO;
import util.BillStatus;
import util.ResultMessage;
import util.SalesOutBillType;
import util.Time;
import vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class SalesOutBill {
    private static BillClientNetworkService networkService;
    private static CommodityInfoService commodityinfoService = new BLFactoryImpl().getCommodityInfoService();
    private static UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private static CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();

    /**
     * 添加销售单
     * 保存
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo) {
        vo.setStatus(BillStatus.init);
        if (vo.getInit_time() == null) {
            vo.setInit_time(new Time());
        }
        if (vo.getID() == null) {
            String id = networkService.getSalesOutBillID(vo.getType());
            vo.setID(id);
            return networkService.addSalesOutBill(vo_to_po(vo));
        }
        return networkService.updateSalesOutBill(vo_to_po(vo));
    }

    ;

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo) {
        vo.setCommit_time(new Time());
        vo.setStatus(BillStatus.commit);
        ArrayList list = vo.getPresentations();
        //fixme 这里应该有一个调用接口直接产生库存赠送单 待定
        return networkService.updateSalesOutBill(vo_to_po(vo));
    }



    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo) {
        if (vo.getStatus() == BillStatus.init)
            return networkService.deleteSalesOutBill(vo.getID());
        return ResultMessage.FAILED;
    }



    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID) {
        List<SalesOutBillPO> pos = networkService.fullSearchSalesOutBill("operatorID", operatorID);
        return pos_to_vos(pos);
    }



    /**
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo) {
        vo.setStatus(BillStatus.init);
        vo.setCommit_time(null);
        return networkService.updateSalesOutBill(vo_to_po(vo));
    }

    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        List<SalesOutBillPO> pos = networkService.fullSearchSalesOutBill("status", BillStatus.commit.ordinal());

        return pos_to_vos(pos);
    }

    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        salesOutBillVO.setStatus(BillStatus.approval);
        salesOutBillVO.setApproval_time(new Time());
        return networkService.updateSalesOutBill(vo_to_po(salesOutBillVO));
    }

    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        salesOutBillVO.setApproval_time(new Time());
        salesOutBillVO.setStatus(BillStatus.rejected);
        return networkService.updateSalesOutBill(vo_to_po(salesOutBillVO));
    }

    public static SalesOutBillVO po_to_vo(SalesOutBillPO po) {
        Time initTime = po.getInit_time() != null ? new Time(po.getInit_time()) : null;
        Time commitTime = po.getInit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getInit_time() != null ? new Time(po.getApproval_time()) : null;
        UserVO operator = po.getOperatorID() != null ? userInfo.getUser(po.getOperatorID()) : null;
        UserVO manager = po.getManagerID() != null ? userInfo.getUser(po.getManagerID()) : null;
        SalesOutBillType type = SalesOutBillType.values()[po.getType()];
        BillStatus status = BillStatus.values()[po.getStatus()];
        CustomerVO customerVO = customerBLInfo.getCustomerByID(po.getCustomerID());
        List<SalesItemPO> salesItemPOS = po.getSalesItemPOS();
        ArrayList<SalesItemVO> salesItemVOS = new ArrayList<>();
        for (SalesItemPO itemPO :
                salesItemPOS) {
            salesItemVOS.add(po_to_vo(itemPO));
        }

        SalesOutBillVO vo = new SalesOutBillVO(po.getID(), type, status, customerVO, po.getDAE(), po.getStorage()
                , null, salesItemVOS, null, po.getAllowance(), po.getVoucher(), po.getPresent_vocher(), initTime
                , commitTime, approvalTime, manager, operator, po.getSumBeforeDiscount(), po.getSumAfterDiscount());
        return vo;
    }

    public static SalesOutBillPO vo_to_po(SalesOutBillVO vo) {
        String initTime = vo.getInit_time() != null ? vo.getInit_time().toString() : null;
        String commitTime = vo.getCommit_time() != null ? vo.getCommit_time().toString() : null;
        String approvalTime = vo.getApproval_time() != null ? vo.getApproval_time().toString() : null;
        String operatorID = vo.getOperator() != null ? vo.getOperator().getID() : null;
        String managerID = vo.getManager() != null ? vo.getManager().getID() : null;
        String customerID = vo.getCustomerVO() != null ? vo.getCustomerVO().getID() : null;

        ArrayList<SalesItemPO> itemPOS = new ArrayList<>();

        for (SalesItemVO itemVO : vo.getItemVOS()
                ) {
            itemPOS.add(vo_to_po(itemVO));
        }
        SalesOutBillPO po = new SalesOutBillPO(vo.getID(), vo.getType().ordinal(), customerID,
                vo.getDAE(), operatorID, managerID, vo.getStatus().ordinal(), vo.getStorage(), initTime, commitTime, approvalTime,
                vo.getPs(), vo.getAllowance(), vo.getVoucher(), vo.getPresentation_voucher(),
                vo.getSumBeforeDiscount(), vo.getSumAfterDiscount(), itemPOS);
        return po;
    }

    public static ArrayList<SalesOutBillVO> pos_to_vos(List<SalesOutBillPO> pos) {
        ArrayList<SalesOutBillVO> salesOutBillVOS = new ArrayList<>();
        for (SalesOutBillPO po :
                pos) {
            salesOutBillVOS.add(po_to_vo(po));
        }
        return salesOutBillVOS;
    }

    public static SalesItemPO vo_to_po(SalesItemVO vo) {
        return new SalesItemPO(vo.getId(), vo.getNumber(), vo.getPrice(), vo.getPs());
    }

    public static SalesItemVO po_to_vo(SalesItemPO po) {
        CommodityVO commodityVO = commodityinfoService.getCommodity(po.getId());
        SalesItemVO vo = new SalesItemVO(commodityVO, po.getNumber(), po.getPrice());
        return vo;
    }
}
