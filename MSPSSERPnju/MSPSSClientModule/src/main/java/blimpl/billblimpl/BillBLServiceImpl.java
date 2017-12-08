package blimpl.billblimpl;

import blimpl.stockblimpl.Stock;
import blservice.billblservice.BillBLInfo;
import blservice.billblservice.BillBLService;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:21 2017/11/21/021
 */
public class BillBLServiceImpl{
    private StockBill stockBill;
    private FinanceBill financeBill;
    public ResultMessage addStockBill(StockBillVO stockBillVO){
        return stockBill.addStockBill(stockBillVO);
    }
    public ResultMessage updateStockBill(StockBillVO stockBillVO){
        return stockBill.updateStockBill(stockBillVO);
    }
    public ResultMessage checkStockBill(StockBillVO stockBillVO){
        return  stockBill.check(stockBillVO);
    }


}
