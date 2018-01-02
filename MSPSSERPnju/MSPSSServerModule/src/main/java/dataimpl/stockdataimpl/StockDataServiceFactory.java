package dataimpl.stockdataimpl;

import datahelper.HibernateHelper;
import dataimpl.stockdataimpl.StockDataServiceImpl;
import dataservice.StockDataService;
import po.StockPO;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class StockDataServiceFactory {
    private static StockDataServiceImpl stockDataService;

    public static synchronized StockDataService getStockDataService(){
        if(stockDataService==null){
            stockDataService = new StockDataServiceImpl(new HibernateHelper<StockPO>(StockPO.class));
        }
        return stockDataService;
    }
}
