package blimpl.billblimpl;

import util.ResultMessage;
import vo.CashCostBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:02 2017/11/28/008
 */
public class MockCashCostBill extends CashCostBill {
    /**
     * 保存现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage saveCashCostBill(CashCostBillVO cashCostBillVO) {
        return super.saveCashCostBill(cashCostBillVO);
    }

    /**
     * 提交现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage commitCashCostBill(CashCostBillVO cashCostBillVO) {
        return super.commitCashCostBill(cashCostBillVO);
    }

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO) {
        return super.deleteCashCostBill(cashCostBillVO);
    }

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID) {
        return super.getMyCashCostBill(operatorID);
    }

    /**
     * 撤回已经提交的现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage withdrawCashCostBill(CashCostBillVO cashCostBillVO) {
        return super.withdrawCashCostBill(cashCostBillVO);
    }

    /**
     * 得到待审批的现金费用单
     *
     * @return
     */
    @Override
    public ArrayList<CashCostBillVO> getWaitingCashCostBill() {
        return super.getWaitingCashCostBill();
    }

    /**
     * 通过单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage approveCashCostBill(CashCostBillVO vo) {
        return super.approveCashCostBill(vo);
    }
}
