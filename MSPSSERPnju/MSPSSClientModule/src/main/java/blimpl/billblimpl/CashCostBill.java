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
    public ResultMessage addCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID) {
        return new ArrayList<>();
    }
}
