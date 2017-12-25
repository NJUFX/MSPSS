package network.geberalaccountnetwork;
import dataimpl.generalaccountdataimpl.GeneralAccountDataServiceFactory;
import dataservice.GeneralAccountDataService;
import network.generalaccountnetworkservice.GeneralAccountServerNeworkService;
import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.GeneralAccountPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/12/14.
 */
public class GeneralAccountServerNetworkImpl implements GeneralAccountServerNeworkService{
    private GeneralAccountDataService generalAccountDataService;

    public GeneralAccountServerNetworkImpl()throws RemoteException{
        generalAccountDataService = GeneralAccountDataServiceFactory.getGeneralAccountDataService();
    }


    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountPO generalAccountPO)throws RemoteException{

        return generalAccountDataService.newGeneralAccount(generalAccountPO);
    }

    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,String id)throws RemoteException{
        return generalAccountDataService.exactlySearchGeneralAccount(field,id);
    }

    public ArrayList<GeneralAccountPO> fullSearchGeneralAccount(String field, Object value)throws RemoteException{
        return generalAccountDataService.fullSearchGeneralAccount(field, value);
    }
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountPO> fuzzySearchGeneralAccount(String filed,String value)throws RemoteException{
        return generalAccountDataService.fuzzySearchGeneralAccount(filed, value);
    }


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountPO> rangeSearchGeneralAccount(String field, Object min, Object max)throws RemoteException{
        return generalAccountDataService.rangeSearchGeneralAccount(field,min,max);
    }

    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerPO searchCustomer(String name)throws RemoteException{
        return generalAccountDataService.searchCustomer(name);
    }

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityPO searchCommodity(String name)throws RemoteException{
        return generalAccountDataService.searchCommodity(name);
    }

}
