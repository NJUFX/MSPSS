package blimpl.customerblimpl;

import blservice.customerblservice.CustomerBLService;

public class CustomerBLFactory {
    private Customer customer;
    private CustomerBLServiceImpl impl;
    public synchronized CustomerBLService getCustomerBLService(){
        if (impl!=null){
            impl = new CustomerBLServiceImpl(customer);
        }
        return impl;
    }
}
