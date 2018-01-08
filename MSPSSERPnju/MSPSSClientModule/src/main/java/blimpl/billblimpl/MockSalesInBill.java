package blimpl.billblimpl;

import po.SalesInBillPO;
import util.ResultMessage;
import vo.SalesInBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:51 2017/11/21/021
 */
public class MockSalesInBill extends SalesInBill {
    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveSalesInBill(SalesInBillVO vo) {
        return super.saveSalesInBill(vo);
    }

    /**
     * 提交进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitSalesInBill(SalesInBillVO vo) {
        return super.commitSalesInBill(vo);
    }

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteSalesInBill(SalesInBillVO vo) {
        return super.deleteSalesInBill(vo);
    }

    /**
     * 撤回已经提交的进货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawSalesInBill(SalesInBillVO vo) {
        return super.withdrawSalesInBill(vo);
    }

    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID) {
        return super.getMySalesInBill(operatorID);
    }

    /**
     * 得到等待审批的单据
     *
     * @return
     */
    @Override
    public ArrayList<SalesInBillVO> getWaitingSalesInBill() {
        return super.getWaitingSalesInBill();
    }

    @Override
    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO) {
        return super.approveSalesInBill(salesInBillVO);
    }

    @Override
    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO) {
        return super.rejectSalesInBill(salesInBillVO);
    }

    @Override
    public ResultMessage HongChong(SalesInBillVO salesInBillVO) {
        return super.HongChong(salesInBillVO);
    }

    @Override
    public ResultMessage HongChongAndCopy(SalesInBillVO salesInBillVO) {
        return super.HongChongAndCopy(salesInBillVO);
    }

    @Override
    public SalesInBillVO po_to_vo(SalesInBillPO po) {
        return super.po_to_vo(po);
    }
}
