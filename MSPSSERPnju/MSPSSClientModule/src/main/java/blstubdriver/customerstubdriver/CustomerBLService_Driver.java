package blstubdriver.customerstubdriver;

import org.junit.Test;
import util.Kind_Of_Customers;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public class CustomerBLService_Driver {
    CustomerBLService_Stub customerBlServiceStub = new CustomerBLService_Stub();
    //进货商
    public static CustomerVO Intel = new CustomerVO("00000001", Kind_Of_Customers.SALER, 5, "Intel", "88484399", "Nanjing", "222243", "intel@intel.com", 50000, 43200, 0, "002");
    //销售商
    public static CustomerVO Xiaomi = new CustomerVO("00000002", Kind_Of_Customers.SALER, 4, "Xiaomi", "86868686", "Shanghai", "222231", "xiaomi@xiaomi.com", 50000, 0, 12000, "001");

    @Test
    public void drive() {
        //test addCustomer
        ResultMessage isAdded1 = customerBlServiceStub.addCustomer(Intel);
        if (isAdded1 == ResultMessage.SUCCESS) {
            System.out.println("Add customer successfully.");
        } else {
            System.out.println("Fail to add customer.");
        }

        //test getCustomer
        CustomerVO customerget = customerBlServiceStub.getCustomerInfo("00000001");
        if (customerget != null) {
            System.out.println(customerget.getName());
            System.out.println("Get customer successfully.");
        } else {
            System.out.println("Fail to get customer.");
        }

        //test searchCustomer
        customerBlServiceStub.addCustomer(Xiaomi);
        ArrayList<CustomerVO> list = customerBlServiceStub.searchCustomer("level", "5");
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).getName() + " ");
            }
            System.out.println();
            System.out.println("Search customers successfully.");
        } else {
            System.out.println("Fail to search customer.");
        }


        //test delCustomer
        ResultMessage isDel = customerBlServiceStub.delCustomer("00000003");
        if (isDel == ResultMessage.SUCCESS) {
            System.out.println("Delete customer successfully.");
        } else {
            System.out.println("Fail to delete customer.");
        }

        //test ModifyCustomer
        ResultMessage isMod = customerBlServiceStub.modifyCustomer(Intel);
        if (isMod == ResultMessage.SUCCESS) {
            System.out.println("Modify customer successfully.");
        } else {
            System.out.println("Fail to modify customer.");
        }

    }
}
