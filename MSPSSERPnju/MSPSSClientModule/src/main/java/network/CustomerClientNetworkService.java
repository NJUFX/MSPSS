package network;

import blimpl.customerblimpl.Customer;
import po.CustomerPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 14:06 2017/11/30/030
 */
public interface CustomerClientNetworkService extends Remote {
    public ResultMessage addCustomer(CustomerPO po);

    public ResultMessage updateCustomer(CustomerPO po);

    public ResultMessage deleteCustomer(String id);

    public ArrayList<CustomerPO> fullSearchCustomer(String field,Object value);

    public ArrayList<CustomerPO> fuzzSearchCustomer(String field,String value);

    public ArrayList<CustomerPO> rangeSearchCustomer(String filed,Object min,Object max);

    public CustomerPO searchCustomerByID(String ID);

}
