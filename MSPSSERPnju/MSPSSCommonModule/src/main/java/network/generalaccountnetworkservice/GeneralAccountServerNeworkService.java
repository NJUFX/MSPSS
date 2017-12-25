package network.generalaccountnetworkservice;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.GeneralAccountPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface GeneralAccountServerNeworkService {


    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountPO generalAccountPO)throws RemoteException;

    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,String id)throws RemoteException;

    public ArrayList<GeneralAccountPO> fullSearchGeneralAccount(String field, Object value)throws RemoteException;
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountPO> fuzzySearchGeneralAccount(String filed,String value)throws RemoteException;


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountPO> rangeSearchGeneralAccount(String field, Object min, Object max)throws RemoteException;

    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerPO searchCustomer(String name)throws RemoteException;

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityPO searchCommodity(String name)throws  RemoteException;
}
