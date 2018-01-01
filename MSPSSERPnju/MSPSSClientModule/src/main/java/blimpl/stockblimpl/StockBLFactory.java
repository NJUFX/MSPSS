package blimpl.stockblimpl;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;

/**
 * Description:
 * Created by Hanxinhu at 11:47 2017/12/31/031
 */
public class StockBLFactory {
    private static Stock stock = new Stock();
    private static StockController impl;
    public static StockBLService getStockBLService(){
        if (impl==null){
            impl = new StockController(stock);
        }
        return impl;
    }
    public static StockBLInfo getStockBLInfo(){
        if (impl==null){
            impl = new StockController(stock);
        }
        return impl;
    }

}
