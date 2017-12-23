package blstubdriver.customerstubdriver;

import blservice.customerblservice.CustomerBLService;
import filterflags.CustomerSearchFlag;
import util.Kind_Of_Customers;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public class CustomerBLService_Stub implements CustomerBLService {
    public static ArrayList<CustomerVO> customerList = new ArrayList<>();
    public static CustomerVO customer = new CustomerVO("0000000", Kind_Of_Customers.SALER, 5, "songtuan", "88488888", "南京市栖霞区仙林街道168号", "222243", "songtuan@163.com", 5000, 3400, 0, "001");

    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keyType
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<CustomerVO> searchCustomer(CustomerSearchFlag keyType, String keyword) {
        return null;
    }

    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
        ArrayList<CustomerVO> searchlist = new ArrayList<>();
        if (keytype.equals("level")) {
            for (int i = 0; i < customerList.size(); i++) {
                if (String.valueOf(customerList.get(i).getLevel()).equals(keyword) && customerList.get(i).getExist() == true) {
                    searchlist.add(customerList.get(i));
                }
            }
        }
        return searchlist;

    }

    @Override
    public CustomerVO getCustomerInfo(String ID) {
        for (int i = 0; i < customerList.size(); i++) {
            if (String.valueOf(customerList.get(i).getID()).equals(ID) && customerList.get(i).getExist() == true) {
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public ResultMessage addCustomer(CustomerVO newcustomer) {
        customerList.add(newcustomer);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage delCustomer(String ID) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getID().equals(ID)) {
                customerList.get(i).setExist(false);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage modifyCustomer(CustomerVO customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getID().equals(customer.getID())) {
                customerList.remove(i);
                customerList.add(customer);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.FAILED;
    }
}
