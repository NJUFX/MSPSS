package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityInfoService;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkService;
import po.SalesInBillPO;
import po.SalesItemPO;
import util.BillStatus;
import util.ResultMessage;
import util.SalesInBillType;
import util.Time;
import vo.CommodityVO;
import vo.SalesInBillVO;
import vo.SalesItemVO;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class SalesInBill {
    private static CommodityInfoService commodityInfo = new BLFactoryImpl().getCommodityInfoService();
    private static UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private static BillClientNetworkService networkService;
    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesInBill(SalesInBillVO vo) {
        vo.setStatus(BillStatus.init);
        if (vo.getInit_time() == null) {
            vo.setInit_time(new Time());
        }
        if (vo.getID() == null) {
            String salesInBillID = networkService.getSalesInBillID(vo.getType());
            vo.setID(salesInBillID);
            return networkService.addSalesInBill(vo_to_po(vo));
        }
        return networkService.updateSalesInBill(vo_to_po(vo));
    }

    ;

    /**
     * 提交进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesInBill(SalesInBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesInBill(SalesInBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 撤回已经提交的进货单
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesInBill(SalesInBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID) {
        return new ArrayList<>();
    }

    /**
     * 得到等待审批的单据
     *
     * @return
     */
    public ArrayList<SalesInBillVO> getWaitingSalesInBill() {
        return new ArrayList<>();
    }

    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO) {
        return ResultMessage.SUCCESS;
    }

    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO) {
        return ResultMessage.SUCCESS;
    }


    private SalesInBillVO po_to_vo(SalesInBillPO po) {
        Time initTime = po.getInit_time() != null ? new Time(po.getInit_time()) : null;
        Time commitTime = po.getCommit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getApproval_time() != null ? new Time(po.getApproval_time()) : null;
        UserVO operatorVO = po.getOperatorID() != null ? userInfo.getUser(po.getOperatorID()) : null;
        UserVO managerVO = po.getManagerID() != null ? userInfo.getUser(po.getManagerID()) : null;

        ArrayList<SalesItemVO> itemVOS = new ArrayList<>();
        for (SalesItemPO itemPO : po.getItemPOS()
                ) {
            itemVOS.add(po_to_vo(itemPO));
        }

        SalesInBillVO vo = new SalesInBillVO(po.getID(), po.getDAE(), po.getProvider(), po.getStorage(),
                SalesInBillType.values()[po.getType()], operatorVO, po.getPs(), po.getSumMoney()
                , itemVOS, BillStatus.values()[po.getStatus()],
                initTime, commitTime, approvalTime, po.getCommentByManager(), managerVO);

        return vo;
    }

    private SalesInBillPO vo_to_po(SalesInBillVO vo) {
        String initTime = vo.getInit_time() != null ? vo.getInit_time().toString() : null;
        String commitTime = vo.getCommit_time() != null ? vo.getCommit_time().toString() : null;
        String approvalTime = vo.getApproval_time() != null ? vo.getApproval_time().toString() : null;
        String operatorID = vo.getOperator() != null ? vo.getOperator().getID() : null;
        String managerID = vo.getManager() != null ? vo.getManager().getID() : null;
        ArrayList<SalesItemPO> itemPOS = new ArrayList<>();
        for (SalesItemVO itemVO : vo.getItemVOS()
                ) {
            itemPOS.add(vo_to_po(itemVO));
        }
        SalesInBillPO po = new SalesInBillPO(vo.getID(), vo.getDAE(), vo.getProvider(), vo.getStorage(),
                vo.getType().ordinal(), operatorID, vo.getPs(), vo.getSumMoney(), itemPOS, vo.getStatus().ordinal()
                , initTime, commitTime, approvalTime, vo.getCommentByManager(), managerID);
        return po;
    }

    private SalesItemPO vo_to_po(SalesItemVO vo) {
        return new SalesItemPO(vo.getId(), vo.getNumber(), vo.getPrice(), vo.getPs());
    }

    private SalesItemVO po_to_vo(SalesItemPO po) {
        CommodityVO commodityVO = commodityInfo.getCommodity(po.getId());
        SalesItemVO vo = new SalesItemVO(commodityVO, po.getNumber(), po.getPrice());
        return vo;
    }

}
