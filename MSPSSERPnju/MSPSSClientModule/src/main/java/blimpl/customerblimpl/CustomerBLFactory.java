package blimpl.customerblimpl;

import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;

public class CustomerBLFactory {
<<<<<<< HEAD
    private static CustomerBLServiceImpl impl;

    public synchronized static CustomerBLService getCustomerBLService() {
        if (impl ==null){
=======

    private static CustomerBLServiceImpl impl;

    public synchronized static CustomerBLService getCustomerBLService() {
        if (impl == null) {
>>>>>>> 475901f884ab93fdef60a752065f43e7f1eaa7ca
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
