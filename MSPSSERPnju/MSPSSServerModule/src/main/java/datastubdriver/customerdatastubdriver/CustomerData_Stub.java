package datastubdriver.customerdatastubdriver;

import java.util.*;

import dataservice.CustomerDataService;
import po.CustomerPO;
import util.*;

public class CustomerData_Stub implements CustomerDataService {
    public static ArrayList<CustomerPO> customerList = new ArrayList<>();

    @Override
    public boolean addCustomer(String ID, String category, int level, String name, String tele, String address, String postcode, String email, double InValue, double in, double out, String DAE) {
        CustomerPO newcustomer = new CustomerPO();
        customerList.add(newcustomer);
        return true;
    }

    @Override
    public boolean addCustomer(CustomerPO customer) {
        boolean b = false;
        for (CustomerPO lang : customerList) {
            if (!lang.getID().equals(customer.getID())) {
                b = true;
            } else {
                b = false;
            }
        }
        if (b == true) {
            customerList.add(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean delCustomer(String ID) {
        for (CustomerPO lang : customerList) {
            if (lang.getID().equals(ID)) {
                lang.setExist(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public CustomerPO getCustomerInfo(String ID) {
        for (CustomerPO lang : customerList) {
            if (lang.getID().equals(ID) && lang.isExist() != false) {
                return lang;
            }
        }
        return null;
    }

    @Override
    public boolean modifyCustomer(String ID, String category, int level, String name, String tele, String address, String postcode, String email, double InValue) {
        for (CustomerPO lang : customerList) {
            if (lang.getID().equals(ID) && lang.isExist() != false) {
                lang.setCategory(1);
                lang.setLevel(level);
                lang.setName(name);
                lang.setPhonenumber(tele);
                lang.setAddress(address);
                lang.setPostcode(postcode);
                lang.setEmail(email);
                lang.setInvalue(InValue);
                return true;
            }
        }
        return false;
    }
}
