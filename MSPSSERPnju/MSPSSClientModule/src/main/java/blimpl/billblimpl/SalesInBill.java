package blimpl.billblimpl;

import util.ResultMessage;
import vo.SalesInBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class SalesInBill {
    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesInBill(SalesInBillVO vo) {
        return ResultMessage.SUCCESS;
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
}
