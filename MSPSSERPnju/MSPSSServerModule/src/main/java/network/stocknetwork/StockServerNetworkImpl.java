package network.stocknetwork;

import dataimpl.stockdataimpl.StockDataServiceFactory;
import dataservice.StockDataService;
import network.stocknetworkservice.StockServerNetworkService;
import po.StockPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class StockServerNetworkImpl implements StockServerNetworkService {
    private StockDataService stockDataService;

    public StockServerNetworkImpl() throws RemoteException {
        stockDataService = StockDataServiceFactory.getStockDataService();
    }
    /**
     * 得到需要时间范围内的进出库信息
     *
     * @return
     */
    public ArrayList<StockPO> rangeSearchStock(String filed, Object min, Object max) throws RemoteException{
        return stockDataService.rangeSearchStock(filed, min, max);
    }



    /**
     * 添加出入库信息信息
     * @param stockPO
     * @return
     */
    public ResultMessage addStock(StockPO stockPO)throws RemoteException{
        return stockDataService.addStock(stockPO);
    }

}
