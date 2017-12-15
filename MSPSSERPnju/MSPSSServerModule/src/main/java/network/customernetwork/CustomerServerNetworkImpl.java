package network.customernetwork;
import com.sun.org.apache.regexp.internal.RE;
import dataimpl.customerdataimpl.CustomerDataServiceFactory;
import dataservice.CustomerDataService;
import network.customernetworkservice.CustomerServerNetworkService;
import po.CustomerPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/12/14.
 */
public class CustomerServerNetworkImpl extends UnicastRemoteObject implements CustomerServerNetworkService {
    private CustomerDataService customerDataService;

    public CustomerServerNetworkImpl() throws RemoteException{
        customerDataService = CustomerDataServiceFactory.getCustomerDataService();
    }

    /**
     * 增加客户
     * @param po
     * @return
     */
    public ResultMessage addCustomer(CustomerPO po) throws RemoteException{
        return customerDataService.addCustomer(po);
    }

    /**
     * 更新
     * @param po
     * @return
     */
    public ResultMessage updateCustomer(CustomerPO po) throws RemoteException{
        return customerDataService.updateCustomer(po);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public ResultMessage deleteCustomer(String id) throws RemoteException{
        return customerDataService.deleteCustomer(id);
    }

    /**
     * 完全匹配
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CustomerPO> fullSearchCustomer(String field, Object value) throws RemoteException{
        return customerDataService.fullSearchCustomer(field,value);
    }

    /**
     * 模糊查询
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CustomerPO> fuzzSearchCustomer(String field,String value) throws RemoteException{
        return customerDataService.fuzzSearchCustomer(field,value);
    }

    /**
     * 范围查找
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CustomerPO> rangeSearchCustomer(String field,Object min,Object max) throws RemoteException{
        return customerDataService.rangeSearchCustomer(field,min,max);
    }

    /**
     * 精确搜索id
     * @param ID
     * @return
     */
    public CustomerPO searchCustomerByID(String ID) throws RemoteException{
        return customerDataService.searchCustomerByID(ID);
    }


}
