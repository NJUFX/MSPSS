package network;

import network.customernetworkservice.CustomerServerNetworkService;
import po.CustomerPO;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/15.
 */
public class CustomerClientNetworkImpl implements CustomerClientNetworkService {

    private CustomerServerNetworkService customerServerNetworkService;

    public CustomerClientNetworkImpl(){
        try {
            customerServerNetworkService = (CustomerServerNetworkService) Naming.lookup("CustomerServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.CustomerServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ResultMessage addCustomer(CustomerPO po){
        try{
            return customerServerNetworkService.addCustomer(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultMessage updateCustomer(CustomerPO po){
        try{
         return customerServerNetworkService.updateCustomer(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultMessage deleteCustomer(String id){
        try{
         return customerServerNetworkService.deleteCustomer(id);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CustomerPO> fullSearchCustomer(String field, Object value){
        try{
          return customerServerNetworkService.fullSearchCustomer(field, value);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CustomerPO> fuzzSearchCustomer(String field,String value){
        try{
          return customerServerNetworkService.fuzzSearchCustomer(field, value);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CustomerPO> rangeSearchCustomer(String filed,Object min,Object max){
        try{
           return customerServerNetworkService.rangeSearchCustomer(filed, min, max);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public CustomerPO searchCustomerByID(String ID){
        try{
          return customerServerNetworkService.searchCustomerByID(ID);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
}
