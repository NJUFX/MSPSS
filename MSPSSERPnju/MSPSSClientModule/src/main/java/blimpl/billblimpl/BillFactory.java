package blimpl.billblimpl;

import blservice.billblservice.ManagerBillBLService;
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
    public synchronized static ManagerBillBLService getManagerBillBLService(){
        if (impl==null){
            impl = new BillBLServiceImpl(stockBill,salesOutBill,salesInBill,financeBill);
        }
        return impl;
    }
    public synchronized static ManagerBillBLService getManagerBillBLServiceStub(){
        return new ManagerBLServiceStub();
    }
}
