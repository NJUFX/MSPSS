package blimpl.billblimpl;

import util.ResultMessage;
import vo.FilterFlagVO;
import vo.FinanceBillVO;
import vo.StockBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:22 2017/11/21/021
 */
public class StockBill {
    public ResultMessage addStockBill(StockBillVO stockBillVO){
        return ResultMessage.FAILED;
    }
    public ResultMessage updateStockBill(StockBillVO stockBillVO){
        return ResultMessage.FAILED;
    }
    public ArrayList<FinanceBillVO> searchStockBill(FilterFlagVO flagVO){
        return null;
    }
}
