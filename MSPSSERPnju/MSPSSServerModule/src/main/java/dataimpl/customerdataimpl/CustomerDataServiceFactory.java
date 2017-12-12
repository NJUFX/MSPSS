package dataimpl.customerdataimpl;

import datahelper.HibernateHelper;
import po.CustomerPO;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class CustomerDataServiceFactory {
    private static CustomerDataServiceImpl customerDataService;

    public static synchronized CustomerDataServiceImpl getCustomerDataService(){
        if(customerDataService==null){
            customerDataService = new CustomerDataServiceImpl(new HibernateHelper<CustomerPO>());
        }
        return customerDataService;
    }
}
