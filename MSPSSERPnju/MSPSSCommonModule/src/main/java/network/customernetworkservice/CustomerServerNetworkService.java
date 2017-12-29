package network.customernetworkservice;

import po.CustomerPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface CustomerServerNetworkService extends Remote{
    public ResultMessage addCustomer(CustomerPO po) throws RemoteException;

    public ResultMessage updateCustomer(CustomerPO po) throws RemoteException;

    public ResultMessage deleteCustomer(String id) throws RemoteException;

    public ArrayList<CustomerPO> fullSearchCustomer(String field, Object value) throws RemoteException;

    public ArrayList<CustomerPO> fuzzSearchCustomer(String field,String value) throws RemoteException;

    public ArrayList<CustomerPO> rangeSearchCustomer(String filed,Object min,Object max) throws RemoteException;

    public CustomerPO searchCustomerByID(String ID) throws RemoteException;
}
