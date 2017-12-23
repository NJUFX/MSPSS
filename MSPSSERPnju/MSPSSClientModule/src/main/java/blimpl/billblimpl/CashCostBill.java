package blimpl.billblimpl;

import util.ResultMessage;
import vo.CashCostBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 11:33 2017/12/19/019
 */
public class CashCostBill {
    /**
     * 添加现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage saveCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage commitCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID) {
        return new ArrayList<>();
    }

    ;

    /**
     * 撤回已经提交的现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage withdrawCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到待审批的现金费用单
     *
     * @return
     */
    public ArrayList<CashCostBillVO> getWaitingCashCostBill() {
        return new ArrayList<>();
    }

    /**
     * 通过单据
     *
     * @param vo
     * @return
     */
    public ResultMessage approveCashCostBill(CashCostBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    public ResultMessage rejectCashCostBill(CashCostBillVO vo) {
        return ResultMessage.SUCCESS;
    }

}
