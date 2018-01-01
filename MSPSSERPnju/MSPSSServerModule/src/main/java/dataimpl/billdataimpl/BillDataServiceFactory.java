package dataimpl.billdataimpl;

import datahelper.HibernateHelper;
import dataimpl.billdataimpl.BillDataServiceImpl;
import po.*;


/**
 * Created by thinkpad on 2017/12/24.
 */
public class BillDataServiceFactory {
    private static BillDataServiceImpl billDataService;

    public static synchronized BillDataServiceImpl getBillDataService(){
        if(billDataService==null){
            billDataService = new BillDataServiceImpl(new HibernateHelper<StockBillPO>(StockBillPO.class),new HibernateHelper<CashCostBillPO>(CashCostBillPO.class),new HibernateHelper<FinanceBillPO>(FinanceBillPO.class),new HibernateHelper<SalesInBillPO>(SalesInBillPO.class),new HibernateHelper<SalesOutBillPO>(SalesOutBillPO.class),new HibernateHelper<AlarmBillPO>(AlarmBillPO.class));
        }
        return billDataService;
    }
}
