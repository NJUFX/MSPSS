package blimpl.billblimpl;

import blservice.billblservice.FinanceBillBLService;
import blservice.billblservice.ManagerBillBLService;
import blservice.billblservice.SalesmanBillBLService;
import blservice.billblservice.StockManagerBillBLService;
import blstubdriver.billstubdriver.ManagerBLServiceStub;

/**
 * Description:
 * Created by Hanxinhu at 16:38 2017/12/8/008
 */
public class BillFactory {
    private static BillBLServiceImpl impl;
    private static StockBill stockBill = new StockBill();
    private static FinanceBill financeBill  = new FinanceBill();
    private static SalesInBill salesInBill = new SalesInBill();
    private static SalesOutBill salesOutBill = new SalesOutBill();
    private static CashCostBill cashCostBill = new CashCostBill();
    private static AlarmBill alarmBill = new AlarmBill();
    public synchronized static ManagerBillBLService getManagerBillBLService(){
        if (impl==null){
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static SalesmanBillBLService getSalesmanBillBLService() {
        if (impl == null) {
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static StockManagerBillBLService getStockManagerBillBLService() {
        if (impl == null) {
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    public synchronized static FinanceBillBLService getFinanceBillBLService() {
        if (impl == null) {
            impl = new BillBLServiceImpl(stockBill, salesOutBill, salesInBill, financeBill, cashCostBill, alarmBill);
        }
        return impl;
    }

    //桩
    public synchronized static ManagerBillBLService getManagerBillBLServiceStub(){
        return new ManagerBLServiceStub();
    }


}
