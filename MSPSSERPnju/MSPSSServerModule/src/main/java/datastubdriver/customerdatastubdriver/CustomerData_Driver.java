//package datastubdriver.customerdatastubdriver;
//
//import org.junit.*;
//import po.*;
//import util.Kind_Of_Customers;
//
//public class CustomerData_Driver {
//    CustomerData_Stub customerData_stub = new CustomerData_Stub();
//    CustomerPO customer = new CustomerPO();
//
//    @Test
//    public void drive() {
//        boolean isAdd1 = customerData_stub.addCustomer("00000003", "SUPPLYER", 5, "Sansung", "36363636", "Korea", "123456", "sansung@sansung.com", 50000, 30000, 0, "004");
//        if (isAdd1 == true) {
//            System.out.println("Add customer successfully.");
//        } else {
//            System.out.println("Fail to add customer.");
//        }
//
//        boolean isAdd2 = customerData_stub.addCustomer(customer);
//        if (isAdd2 == true) {
//            System.out.println("Add customer successfully.");
//        } else {
//            System.out.println("Fail to add customer.");
//        }
//
//        boolean isDel = customerData_stub.delCustomer("00000001");
//        if (isDel == true) {
//            System.out.println("Delete customer successfully.");
//        } else {
//            System.out.println("Fail to delete customer.");
//        }
//
//        boolean isMod = customerData_stub.modifyCustomer("00000003", "SUPPLYER", 3, "Intel", "1529860", "nanjing", "222243", "intel@intel.com", 36000);
//        if (isMod) {
//            System.out.println("Modify customer successfully.");
//        } else {
//            System.out.println("Fail to modify customer.");
//        }
//
//        CustomerPO customerget = customerData_stub.getCustomerInfo("00000003");
//        if (customerget != null) {
//            System.out.println("Get customer information successfully.");
//        } else {
//            System.out.println("Fail to get customer information.");
//        }
//    }
//}
