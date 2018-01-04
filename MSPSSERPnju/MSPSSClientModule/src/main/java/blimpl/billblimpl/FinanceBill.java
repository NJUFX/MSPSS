package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLInfo;
import blservice.customerblservice.CustomerBLInfo;
import blservice.logblservice.LogBLInfo;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import po.FinanceBillPO;
import po.FinanceItemPO;
import util.BillStatus;
import util.FinanceBillType;
import util.ResultMessage;
import util.Time;
import vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class FinanceBill {
    private static AccountBLInfo accountInfo = new BLFactoryImpl().getAccountBLInfo();
    public static BillClientNetworkService networkService = new BillClientNetworkImpl();
    private static UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private static CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    private static LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();
    /**
     * 添加应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveFinanceBill(FinanceBillVO vo) {
        vo.setStatus(BillStatus.init);
        if (vo.getInit_time() == null) {
            vo.setInit_time(new Time());
        }
        if (vo.getID() == null) {
            String ID = networkService.getFinanceBillID(vo.getType());
            System.out.println(ID);
            vo.setID(ID);

            FinanceBillPO po = vo_to_po(vo);
            if (userInfo.getCurrentUser() != null) {
                BillLogHelper.init(userInfo.getCurrentUser(), ID);
            }
            return networkService.addFinanceBill(po);
        } else
        {
            if (userInfo.getCurrentUser() != null) {
                BillLogHelper.update(userInfo.getCurrentUser(), vo.getID());
            }
            return networkService.updateFinanceBill(vo_to_po(vo));
        }
    }

    /**
     * 提交应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitFinanceBill(FinanceBillVO vo) {
        vo.setStatus(BillStatus.commit);
        vo.setCommit_time(new Time());

        BillLogHelper.commit(userInfo.getCurrentUser(), vo.getID());
        return networkService.updateFinanceBill(vo_to_po(vo));
    }

    /**
     * 删除应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteFinanceBill(FinanceBillVO vo) {
        BillLogHelper.delete(userInfo.getCurrentUser(), vo.getID());

        return networkService.deleteFinanceBill(vo.getID());
    }

    /**
     * 得到某操作员创建的应收应付单据
     *
     * @param operatorID
     * @return
     */
    public ArrayList<FinanceBillVO> getMyFinanceBill(String operatorID) {

        ArrayList<FinanceBillPO> pos = networkService.fullSearchFinanceBill("operatorID"
                , operatorID);
        return pos_to_vos(pos);
    }

    /**
     * 撤回已经提交的单据
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawFinanceBill(FinanceBillVO vo) {
        vo.setStatus(BillStatus.rejected);
        vo.setApproval_time(new Time());
        BillLogHelper.withdraw(userInfo.getCurrentUser(), vo.getID());
        BillSendMessage.withdraw(userInfo.getCurrentUser(), vo.getID());
        return networkService.updateFinanceBill(vo_to_po(vo));
    }

    /**
     * 得到待审批的应付应收单
     *
     * @return
     */
    public ArrayList<FinanceBillVO> getWaitingFinanceBill() {
        ArrayList<FinanceBillPO> pos = networkService.fullSearchFinanceBill("status", BillStatus.commit.ordinal());

        return pos_to_vos(pos);
    }

    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO) {
        financeBillVO.setStatus(BillStatus.approval);
        financeBillVO.setApproval_time(new Time());
        // 如果是应收单
        if (financeBillVO.getType() == FinanceBillType.IN) {
            for (FinanceItemVO itemVO : financeBillVO.getList()) {
                accountInfo.income(itemVO.getAccountVO().getName(), itemVO.getMoney());
            }
            //收款后 客户的应付就减少了
            customerBLInfo.changeYingFu(financeBillVO.getCustomerVO().getID(), financeBillVO.getSum());

        } else {
            //如果是应付单
            for (FinanceItemVO itemVO : financeBillVO.getList()) {
                accountInfo.pay(itemVO.getAccountVO().getName(), itemVO.getMoney());
            }
            //付款后 客户的应收减少
            customerBLInfo.changeYingShou(financeBillVO.getCustomerVO().getID(), financeBillVO.getSum());
        }
        BillLogHelper.approval(userInfo.getCurrentUser(), financeBillVO.getID());
        BillSendMessage.approve(financeBillVO.getOperator(), financeBillVO.getManagerVO(), financeBillVO.getID());
        return networkService.updateFinanceBill(vo_to_po(financeBillVO));
    }

    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO) {
        financeBillVO.setApproval_time(new Time());
        financeBillVO.setStatus(BillStatus.rejected);
        BillLogHelper.reject(userInfo.getCurrentUser(), financeBillVO.getID());
        BillSendMessage.reject(financeBillVO.getOperator(), financeBillVO.getManagerVO(), financeBillVO.getID());
        return networkService.updateFinanceBill(vo_to_po(financeBillVO));
    }

    public FinanceBillVO po_to_vo(FinanceBillPO po) {
        List<FinanceItemPO> itemPOS = po.getList();
        ArrayList<FinanceItemVO> vos = new ArrayList<>();
        for (FinanceItemPO itemPO : itemPOS) {
            vos.add(po_to_vo(itemPO));
        }
        Time initTime = new Time(po.getInit_time());
        Time commitTime = po.getCommit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getApproval_time() != null ? new Time(po.getApproval_time()) : null;
        UserVO operatorVO = userInfo.getUser(po.getOperatorID());
        UserVO managerVO = po.getManagerID() != null ? userInfo.getUser(po.getManagerID()) : null;
        CustomerVO customerVO = customerBLInfo.getCustomerByID(po.getCustomerID());
        FinanceBillVO vo = new FinanceBillVO(po.getID(), operatorVO, customerVO, managerVO, initTime, commitTime, approvalTime, FinanceBillType.values()[po.getType()],
                po.getSum(), BillStatus.values()[po.getStatus()], vos);
        return vo;
    }

    private FinanceBillPO vo_to_po(FinanceBillVO vo) {
        ArrayList<FinanceItemPO> itemPOS = new ArrayList<>();
        ArrayList<FinanceItemVO> itemVOS = vo.getList();
        for (FinanceItemVO i : itemVOS) {
            itemPOS.add(vo_to_po(i));
        }
        String init_time = vo.getInit_time().toString();
        String commit_time = vo.getCommit_time() != null ? vo.getCommit_time().toString() : null;
        String approval_time = vo.getApproval_time() != null ? vo.getApproval_time().toString() : null;
        String operatorID = vo.getOperator().getID();
        System.out.println(operatorID);
        String managerID = vo.getManagerVO() != null ? vo.getManagerVO().getID() : null;
        String customerID = vo.getCustomerVO().getID();
        int status = vo.getStatus().ordinal();
        int type = vo.getType().ordinal();
        FinanceBillPO po = new FinanceBillPO(vo.getID(), operatorID, customerID, managerID, init_time, commit_time, approval_time,
                type, vo.getSum(), status, itemPOS
        );
        return po;
    }

    public ResultMessage HongChong(FinanceBillVO financeBillVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage HongChongAndCopy(FinanceBillVO financeBillVO) {
        return ResultMessage.FAILED;
    }
    private FinanceItemPO vo_to_po(FinanceItemVO vo) {

        return new FinanceItemPO(vo.getAccountVO().getName(), vo.getPs(), vo.getMoney());
    }

    private FinanceItemVO po_to_vo(FinanceItemPO po) {
        System.out.println(po.getAccountID()+new Time().toString());
        AccountVO accountVO = accountInfo.getAccountVO(po.getAccountID());
        FinanceItemVO vo = new FinanceItemVO(accountVO, po.getPs(), po.getMoney());
        return vo;
    }

    private ArrayList<FinanceBillVO> pos_to_vos(ArrayList<FinanceBillPO> pos) {
        ArrayList<FinanceBillVO> vos = new ArrayList<>();
        for (FinanceBillPO po : pos) {
            vos.add(po_to_vo(po));
        }
        return vos;
    }

}
