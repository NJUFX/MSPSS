package blimpl.billblimpl;

import blservice.billblservice.*;
import blstubdriver.billstubdriver.ManagerBLServiceStub;

/**
 * Description:
 * Created by Hanxinhu at 16:38 2017/12/8/008
 */
public class BillFactory {
    private static BillBLServiceImpl impl;

    public synchronized static ManagerBillBLService getManagerBillBLService(){
        if (impl==null){
            StockBill stockBill = new StockBill();
            FinanceBill financeBill  = new FinanceBill();
            SalesInBill salesInBill = new SalesInBill();
            SalesOutBill salesOutBill = new SalesOutBill();
            CashCostBill cashCostBill = new CashCostBill();
            AlarmBill alarmBill = new AlarmBill();
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static SalesmanBillBLService getSalesmanBillBLService() {
        if (impl == null) {
            StockBill stockBill = new StockBill();
            FinanceBill financeBill  = new FinanceBill();
            SalesInBill salesInBill = new SalesInBill();
            SalesOutBill salesOutBill = new SalesOutBill();
            CashCostBill cashCostBill = new CashCostBill();
            AlarmBill alarmBill = new AlarmBill();
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static StockManagerBillBLService getStockManagerBillBLService() {
        if (impl == null) {
            StockBill stockBill = new StockBill();
            FinanceBill financeBill  = new FinanceBill();
            SalesInBill salesInBill = new SalesInBill();
            SalesOutBill salesOutBill = new SalesOutBill();
            CashCostBill cashCostBill = new CashCostBill();
            AlarmBill alarmBill = new AlarmBill();
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static FinanceBillBLService getFinanceBillBLService() {
        if (impl == null) {
            StockBill stockBill = new StockBill();
            FinanceBill financeBill  = new FinanceBill();
            SalesInBill salesInBill = new SalesInBill();
            SalesOutBill salesOutBill = new SalesOutBill();
            CashCostBill cashCostBill = new CashCostBill();
            AlarmBill alarmBill = new AlarmBill();
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static BillBLInfo getBillBLInfo() {
        if (impl == null) {
            StockBill stockBill = new StockBill();
            FinanceBill financeBill  = new FinanceBill();
            SalesInBill salesInBill = new SalesInBill();
            SalesOutBill salesOutBill = new SalesOutBill();
            CashCostBill cashCostBill = new CashCostBill();
            AlarmBill alarmBill = new AlarmBill();
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    //桩
    public synchronized static ManagerBillBLService getManagerBillBLServiceStub(){
        return new ManagerBLServiceStub();
    }


}
