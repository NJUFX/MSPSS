package blimpl.billblimpl;

import util.ResultMessage;
import vo.FinanceBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:50 2017/11/21/021
 */
public class MockFinanceBill extends FinanceBill {
    /**
     * 添加应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 提交应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteFinanceBill(FinanceBillVO vo) {
        return ResultMessage.SUCCESS;

    }

    /**
     * 得到某操作员创建的应收应付单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<FinanceBillVO> getMyFinanceBill(String operatorID) {
        return super.getMyFinanceBill(operatorID);
    }

    /**
     * 撤回已经提交的单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawFinanceBill(FinanceBillVO vo) {
        return super.withdrawFinanceBill(vo);
    }

    /**
     * 得到待审批的应付应收单
     *
     * @return
     */
    @Override
    public ArrayList<FinanceBillVO> getWaitingFinanceBill() {
        return super.getWaitingFinanceBill();
    }

    @Override
    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO) {
        return super.approveFinanceBill(financeBillVO);
    }

    @Override
    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO) {
        return super.rejectFinanceBill(financeBillVO);
    }

    @Override
    public ResultMessage HongChong(FinanceBillVO financeBillVO) {
        return super.HongChong(financeBillVO);
    }

    @Override
    public ResultMessage HongChongAndCopy(FinanceBillVO financeBillVO) {
        return super.HongChongAndCopy(financeBillVO);
    }
}
