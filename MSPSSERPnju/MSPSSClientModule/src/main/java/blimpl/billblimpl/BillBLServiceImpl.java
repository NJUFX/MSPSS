package blimpl.billblimpl;

import blimpl.stockblimpl.Stock;
import blservice.billblservice.BillBLInfo;
import blservice.billblservice.BillBLService;
import blservice.billblservice.ManagerBillBLService;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:21 2017/11/21/021
 */
public class BillBLServiceImpl implements ManagerBillBLService{
    private StockBill stockBill ;
    private SalesOutBill salesOutBill ;
    private SalesInBill salesInBill ;
    private FinanceBill financeBill ;

    public BillBLServiceImpl(StockBill stockBill, SalesOutBill salesOutBill, SalesInBill salesInBill, FinanceBill financeBill) {
        this.stockBill = stockBill;
        this.salesOutBill = salesOutBill;
        this.salesInBill = salesInBill;
        this.financeBill = financeBill;
    }

    @Override
    public ResultMessage approveStockBill(StockBillVO stockBillVO) {
        return null;
    }

    @Override
    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO) {
        return null;
    }

    @Override
    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return null;
    }

    @Override
    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO) {
        return null;
    }

    @Override
    public ResultMessage approveCashCostBill(CashCostBillVO cashCostBillVO) {
        return null;
    }

    @Override
    public ResultMessage rejectStockBill(StockBillVO stockBillVO) {
        return null;
    }

    @Override
    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO) {
        return null;
    }

    @Override
    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return null;
    }

    @Override
    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO) {
        return null;
    }

    @Override
    public ResultMessage rejectCashCostBill(CashCostBillVO cashCostBillVO) {
        return null;
    }

    @Override
    public ArrayList<StockBillVO> getWaitingStockBill() {
        return null;
    }

    @Override
    public ArrayList<SalesInBillVO> getWaitingSalesInBill() {
        return null;
    }

    @Override
    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        return null;
    }

    @Override
    public ArrayList<FinanceBillVO> getWaitingFinanceBill() {
        return null;
    }

    @Override
    public ArrayList<CashCostBillVO> getWaitingcashCostBillVO() {
        return null;
    }


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
