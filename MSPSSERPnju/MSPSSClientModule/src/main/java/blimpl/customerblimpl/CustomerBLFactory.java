package blimpl.customerblimpl;

import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;

public class CustomerBLFactory {

    private static CustomerBLServiceImpl impl;

    public synchronized static CustomerBLService getCustomerBLService() {
        if (impl == null) {
            impl = new CustomerBLServiceImpl(new Customer());
        }
        return impl;
    }

    public synchronized static CustomerBLInfo getCustomerBLInfo() {
        if (impl == null) {
            impl = new CustomerBLServiceImpl(new Customer());
        }
        return impl;
    }
}
