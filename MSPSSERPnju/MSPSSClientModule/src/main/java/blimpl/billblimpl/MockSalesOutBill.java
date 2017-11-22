package blimpl.billblimpl;

import util.ResultMessage;
import vo.FilterFlagVO;
import vo.FinanceBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:51 2017/11/21/021
 */
public class MockSalesOutBill extends SalesOutBill {
    @Override
    public ResultMessage addSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<SalesOutBillVO> searchSalesOutBill(FilterFlagVO flag) {
        return new ArrayList<>();
    }
}
