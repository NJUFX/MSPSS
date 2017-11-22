package blimpl.billblimpl;

import util.ResultMessage;
import vo.FilterFlagVO;
import vo.FinanceBillVO;
import vo.StockBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:51 2017/11/21/021
 */
public class MockStockBill extends StockBill {
    @Override
    public ResultMessage addStockBill(StockBillVO stockBillVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateStockBill(StockBillVO stockBillVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<FinanceBillVO> searchStockBill(FilterFlagVO flagVO) {
        return new ArrayList<>();
    }
}
