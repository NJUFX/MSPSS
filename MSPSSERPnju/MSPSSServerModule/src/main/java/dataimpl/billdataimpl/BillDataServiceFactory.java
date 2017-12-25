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
            billDataService = new BillDataServiceImpl(new HibernateHelper<StockBillPO>(),new HibernateHelper<CashCostBillPO>(),new HibernateHelper<FinanceBillPO>(),new HibernateHelper<SalesInBillPO>(),new HibernateHelper<SalesOutBillPO>());
        }
        return billDataService;
    }
}
