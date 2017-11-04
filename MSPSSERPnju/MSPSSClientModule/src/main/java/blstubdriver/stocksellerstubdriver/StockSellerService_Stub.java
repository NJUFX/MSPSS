package blstubdriver.stocksellerstubdriver;

import util.Kind_Of_Customers;
import vo.*;
import blservice.stocksellerblservice.*;

import java.util.ArrayList;

public class StockSellerService_Stub implements StockSellerBLService {
    public static int purchaseIdNumber = 0;//进货单编号的序号
    public static int purchaseReturnIdNumber = 0;//进货退货编号的序号
    public static int salesIdNumber = 0;//销售单编号的序号
    public static int salesReturnIdNumber = 0;//销售退货单编号的序号
    public static ArrayList<CustomerVO> customerList = new ArrayList<>();
    public static CustomerVO customer = new CustomerVO("0000000", Kind_Of_Customers.SALER, 5, "songtuan", "88488888", "南京市栖霞区仙林街道168号", "222243", "songtuan@163.com", 5000, 3400, 0, "001");
    public static PurchaseVO purchaesList;

    @Override
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
    public boolean addCustomer(CustomerVO newcustomer) {
        customerList.add(newcustomer);
        return true;
    }

    @Override
    public boolean delCustomer(String ID) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getID().equals(ID)) {
                customerList.get(i).setExist(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modifyCustomer(CustomerVO customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getID().equals(customer.getID())) {
                customerList.remove(i);
                customerList.add(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createPurchase(PurchaseVO purchaes) {
        return true;
    }

    @Override
    public boolean createSales(SalesVO sales) {
        return true;
    }

    @Override
    public boolean createPurchaseRet(PurchaseVO purRet) {
        return true;
    }

    @Override
    public boolean createSalesRet(SalesVO saleRet) {
        return true;
    }

    /**
     * 创建单据的ID
     *
     * @param number 单据的序号
     * @param type   type=1:进货单; type=2:进货退货单; type=3:销售单; type=4:销售退货单
     * @return
     */
    public String createID(int number, int type) {
        String str1 = "";
        if (type == 1) {
            str1 = "JHD-";
        }
        str1 += String.valueOf(number);
        return str1;
    }
}
