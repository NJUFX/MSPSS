package network;

import network.stocknetworkservice.StockServerNetworkService;
import po.StockPO;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class StockClientNetworkImpl implements StockClientNetworkService {

    private StockServerNetworkService stockServerNetworkService;

    public StockClientNetworkImpl(){
        try {
            stockServerNetworkService = (StockServerNetworkService) Naming.lookup("StockServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.StockServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    /**
     * 得到需要时间范围内的进出库信息
     *
     * @return
     */
    public ArrayList<StockPO> rangeSearchStock(String filed, Object min, Object max){
        try{
            return stockServerNetworkService.rangeSearchStock(filed, min, max);
        }catch (RemoteException e){
            e.printStackTrace();

        }
        return null;
    }



    /**
     * 添加出入库信息信息
     * @param stockPO
     * @return
     */
    public ResultMessage addStock(StockPO stockPO){
        try{
            return stockServerNetworkService.addStock(stockPO);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
}
