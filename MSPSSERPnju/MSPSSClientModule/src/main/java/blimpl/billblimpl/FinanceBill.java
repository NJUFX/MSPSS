package blimpl.billblimpl;

import util.ResultMessage;
import vo.FinanceBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class FinanceBill {

    /**
     * 添加应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 更新应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到某操作员创建的应收应付单据
     *
     * @param operatorID
     * @return
     */
    public ArrayList<FinanceBillVO> getMyFinanceBill(String operatorID) {
        return new ArrayList<>();
    }

    /**
     * 撤回已经提交的单据
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到待审批的应付应收单
     *
     * @return
     */
    public ArrayList<FinanceBillVO> getFinanceBill() {
        return new ArrayList<>();
    }

    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO) {
        return ResultMessage.SUCCESS;
    }

    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO) {
        return ResultMessage.SUCCESS;
    }
}
