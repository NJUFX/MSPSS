package blimpl.billblimpl;

import util.ResultMessage;
import vo.SalesOutBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:51 2017/11/21/021
 */
public class MockSalesOutBill extends SalesOutBill {
    /**
     * 添加销售单
     * 保存
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo) {
        return super.saveSalesOutBill(vo);
    }

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo) {
        return super.commitSalesOutBill(vo);
    }

    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo) {
        return super.deleteSalesOutBill(vo);
    }

    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID) {
        return super.getMySalesOutBill(operatorID);
    }

    /**
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo) {
        return super.withdrawSalesOutBill(vo);
    }

    @Override
    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        return super.getWaitingSalesOutBill();
    }

    @Override
    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return super.approveSalesOutBill(salesOutBillVO);
    }

    @Override
    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return super.rejectSalesOutBill(salesOutBillVO);
    }

    @Override
    public ResultMessage HongChong(SalesOutBillVO salesOutBillVO) {
        return super.HongChong(salesOutBillVO);
    }

    @Override
    public ResultMessage HongChongAndCopy(SalesOutBillVO salesOutBillVO) {
        return super.HongChongAndCopy(salesOutBillVO);
    }
}
