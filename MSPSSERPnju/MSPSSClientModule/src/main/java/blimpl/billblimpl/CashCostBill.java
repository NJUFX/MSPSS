package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLInfo;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkService;
import po.CashCostBillPO;
import po.CashCostItemPO;
import util.BillStatus;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;
import vo.CashCostBillVO;
import vo.CashCostItemVO;
import vo.UserVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 11:33 2017/12/19/019
 */
public class CashCostBill {
    private BillClientNetworkService networkService;
    private AccountBLInfo accountBLInfo = new BLFactoryImpl().getAccountBLInfo();
    private UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    /**
     * 保存现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage saveCashCostBill(CashCostBillVO cashCostBillVO) {
        //save
        //String id = vo.getID();
        cashCostBillVO.setStatus(BillStatus.init);
        if (cashCostBillVO.getInit_time() == null) {
            cashCostBillVO.setInit_time(new Time());
        }
        if (cashCostBillVO.getID() == null) {
            String ID = networkService.getCashCostBillID();
            cashCostBillVO.setID(ID);
            return networkService.addCashCostBill(vo_to_po(cashCostBillVO));
        } else
            return networkService.updateCashCostBill(vo_to_po(cashCostBillVO));
    }



    /**
     * 提交现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage commitCashCostBill(CashCostBillVO cashCostBillVO) {
        cashCostBillVO.setStatus(BillStatus.commit);
        cashCostBillVO.setCommit_time(new Time());
        return networkService.updateCashCostBill(vo_to_po(cashCostBillVO));
    }

    ;

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO) {
        return networkService.deleteCashCostBill(cashCostBillVO.getID());
    }

    ;

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID) {
        ArrayList<CashCostBillPO> pos = networkService.fullSearchCashCostBill("operatorID", operatorID);
        return pos_to_vos(pos);
    }

    ;

    /**
     * 撤回已经提交的现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage withdrawCashCostBill(CashCostBillVO cashCostBillVO) {
        cashCostBillVO.setStatus(BillStatus.init);
        cashCostBillVO.setCommit_time(null);

        return networkService.updateCashCostBill(vo_to_po(cashCostBillVO));
    }

    /**
     * 得到待审批的现金费用单
     *
     * @return
     */
    public ArrayList<CashCostBillVO> getWaitingCashCostBill() {
        ArrayList<CashCostBillPO> pos = networkService.fullSearchCashCostBill("status", BillStatus.commit.ordinal());
        return pos_to_vos(pos);
    }

    /**
     * 通过单据
     *
     * @param vo
     * @return
     */
    public ResultMessage approveCashCostBill(CashCostBillVO vo) {
        vo.setApproval_time(new Time());
        vo.setStatus(BillStatus.approval);
        //完成账户余额的改变
        accountBLInfo.pay(vo.accountVO.getName(), vo.getSum());
        return networkService.updateCashCostBill(vo_to_po(vo));
    }

    public ResultMessage rejectCashCostBill(CashCostBillVO vo) {
        vo.setApproval_time(new Time());
        vo.setStatus(BillStatus.rejected);

        return networkService.updateCashCostBill(vo_to_po(vo));
    }

    private CashCostBillPO vo_to_po(CashCostBillVO vo) {
        ArrayList<CashCostItemPO> itemPOS = new ArrayList<>();
        for (int i = 0; i < vo.getList().size(); i++) {
            itemPOS.add(vo_to_po(vo.getList().get(i)));
        }
        //防止出现null报错
        String commitTime = vo.getCommit_time() != null ? vo.getCommit_time().toString() : null;
        String approvalTime = vo.getApproval_time() != null ? vo.getApproval_time().toString() : null;
        String managerID = vo.getManager() != null ? vo.getManager().getID() : null;


        CashCostBillPO po = new CashCostBillPO(vo.getID(), vo.getOperator().getID(), managerID, vo.getStatus().ordinal()
                , itemPOS, vo.sum, vo.getInit_time().toString(), commitTime, approvalTime, vo.accountVO.getName());

        return po;
    }

    public CashCostBillVO po_to_vo(CashCostBillPO po) {
        //谨慎 谨慎 再谨慎
        Time commitTime = po.getCommit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getApproval_time() != null ? new Time(po.getApproval_time()) : null;
        UserVO managerVO = po.getManagerID() != null ? userInfo.getUser(po.getManagerID()) : null;
        UserVO operatorVO = userInfo.getUser(po.getOperatorID());
        BillStatus status = BillStatus.values()[po.getStatus()];
        AccountVO accountVO = accountBLInfo.getAccountVO(po.getAccountName());
        ArrayList<CashCostItemVO> itemVOS = new ArrayList<>();
        List<CashCostItemPO> list = po.getList();
        for (CashCostItemPO itemPO : list) {
            itemVOS.add(po_to_vo(itemPO));
        }


        CashCostBillVO vo = new CashCostBillVO(po.getID(), operatorVO, managerVO, status, accountVO, itemVOS, po.getSum(),
                new Time(po.getInit_time()), commitTime, approvalTime);
        return vo;
    }

    private CashCostItemPO vo_to_po(CashCostItemVO vo) {
        return new CashCostItemPO(vo.getName(), vo.getPs(), vo.getMoney());
    }

    private CashCostItemVO po_to_vo(CashCostItemPO po) {
        return new CashCostItemVO(po.getName(), po.getMoney(), po.getPs());
    }

    private ArrayList<CashCostBillVO> pos_to_vos(ArrayList<CashCostBillPO> pos) {
        ArrayList<CashCostBillVO> vos = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++) {
            vos.add(po_to_vo(pos.get(i)));
        }
        return vos;
    }

}
