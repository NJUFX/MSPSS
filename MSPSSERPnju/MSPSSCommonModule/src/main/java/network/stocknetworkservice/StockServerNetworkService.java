package network.stocknetworkservice;

import po.StockPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public interface StockServerNetworkService extends Remote {
    /**
     * 得到需要时间范围内的进出库信息
     *
     * @return
     */
    public ArrayList<StockPO> rangeSearchStock(String filed, Object min, Object max) throws RemoteException;



    /**
     * 添加出入库信息信息
     * @param stockPO
     * @return
     */
    public ResultMessage addStock(StockPO stockPO) throws RemoteException;
}
