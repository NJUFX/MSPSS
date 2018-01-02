package network;

import blimpl.generalaccountblimpl.GeneralAccount;
import network.usernetworkservice.UserServerNetworkService;
import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.GeneralAccountPO;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import network.generalaccountnetworkservice.GeneralAccountServerNeworkService;
import vo.CustomerVO;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class GeneralAccountClientNetworkImpl implements GeneralAccountClientNetworkService {
    private GeneralAccountServerNeworkService generalAccountServerNeworkService;

    public GeneralAccountClientNetworkImpl(){
            try {
            generalAccountServerNeworkService = (GeneralAccountServerNeworkService) Naming.lookup("GeneralAccountServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.GeneralAccountServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountPO generalAccountPO){
        try{
           return generalAccountServerNeworkService.addGeneralAcocunt(generalAccountPO);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 精确查找商品
     * @param field,id
     * @return
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,String id){
        try{
          return  generalAccountServerNeworkService.exactlySearchGeneralAccount(field,id);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<GeneralAccountPO> fullSearchGeneralAccount(String field, Object value){
        try{
          return  generalAccountServerNeworkService.fullSearchGeneralAccount(field, value);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountPO> fuzzySearchGeneralAccount(String filed,String value){
        try{
           return generalAccountServerNeworkService.fuzzySearchGeneralAccount(filed, value);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountPO> rangeSearchGeneralAccount(String field, Object min, Object max){
        try{
           return generalAccountServerNeworkService.rangeSearchGeneralAccount(field, min, max);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerPO searchCustomer(String name){
        try{
          return   generalAccountServerNeworkService.searchCustomer(name);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityPO searchCommodity(String name){
        try{
           return generalAccountServerNeworkService.searchCommodity(name);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
}
