package blstubdriver.stocksellerstubdriver;

import util.Kind_Of_Customers;
import vo.*;
import org.junit.*;

import java.util.ArrayList;

public class StockSellerService_Driver {

    StockSellerService_Stub stockSellerServiceStub = new StockSellerService_Stub();
    //进货商
    public static CustomerVO Intel = new CustomerVO("00000001", Kind_Of_Customers.SALER, 5, "Intel", "88484399", "Nanjing", "222243", "intel@intel.com", 50000, 43200, 0, "002");
    //销售商
    public static CustomerVO Xiaomi = new CustomerVO("00000002", Kind_Of_Customers.SALER, 4, "Xiaomi", "86868686", "Shanghai", "222231", "xiaomi@xiaomi.com", 50000, 0, 12000, "001");

    @Test
    public void drive() {
        //test addCustomer
        boolean isAdded1 = stockSellerServiceStub.addCustomer(Intel);
        if (isAdded1 == true) {
            System.out.println("Add customer successfully.");
        } else {
            System.out.println("Fail to add customer.");
        }

        //test getCustomer
        CustomerVO customerget = stockSellerServiceStub.getCustomerInfo("00000001");
        if (customerget != null) {
            System.out.println(customerget.getName());
            System.out.println("Get customer successfully.");
        } else {
            System.out.println("Fail to get customer.");
        }

        //test searchCustomer
        stockSellerServiceStub.addCustomer(Xiaomi);
        ArrayList<CustomerVO> list = stockSellerServiceStub.searchCustomer("level", "5");
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
        boolean isDel = stockSellerServiceStub.delCustomer("00000003");
        if (isDel == true) {
            System.out.println("Delete customer successfully.");
        } else {
            System.out.println("Fail to delete customer.");
        }

        //test ModifyCustomer
        boolean isMod = stockSellerServiceStub.modifyCustomer(Intel);
        if (isMod) {
            System.out.println("Modify customer successfully.");
        } else {
            System.out.println("Fail to modify customer.");
        }

        //test createPurchaseList
        ArrayList<CommodityVO> purlist = new ArrayList<>();
        PurchaseVO purchaseVO = new PurchaseVO("", Intel, "024", "001", purlist, 12000, "null");
        boolean iscreateP = stockSellerServiceStub.createPurchase(purchaseVO);
        if (iscreateP == true) {
            System.out.println("Create purchase list successfully.");
        } else {
            System.out.println("Fail to create purchase list.");
        }

        //test createSalesList
        ArrayList<CommodityVO> saleslist = new ArrayList<>();
        SalesVO sales = new SalesVO("", Xiaomi, "001", "004", "024", saleslist, 12000, 0.8, 0, 9600, "出库手机芯片");
        boolean iscreateS = stockSellerServiceStub.createSales(sales);
        if (iscreateS == true) {
            System.out.println("Create sales list successfully.");
        } else {
            System.out.println("Fail to create sales list.");
        }

        //test createPurchaseReturnList
        ArrayList<CommodityVO> purchrtlist = new ArrayList<>();
        PurchaseVO purRet = new PurchaseVO("", Intel, "024", "001", purlist, 12000, "null");
        boolean iscreatePR = stockSellerServiceStub.createPurchaseRet(purRet);
        if (iscreatePR == true) {
            System.out.println("Create purchase-return list successfully.");
        } else {
            System.out.println("Fail to create purchase-return list.");
        }

        //test createSalesReturnList
        ArrayList<CommodityVO> salesrtlist = new ArrayList<>();
        SalesVO saleRet = new SalesVO("", Xiaomi, "001", "004", "024", saleslist, 12000, 0.8, 0, 9600, "出库手机芯片");
        boolean iscreateSR = stockSellerServiceStub.createSalesRet(saleRet);
        if (iscreateSR == true) {
            System.out.println("Create sales-return list successfully.");
        } else {
            System.out.println("Fail to create sales-return list.");
        }
    }
}
