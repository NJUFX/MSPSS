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
    public static PurchaseBillVO purchaesList;

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
    public CustomerVO getCustomer(String ID) {
        for (int i = 0; i < customerList.size(); i++) {
            if (String.valueOf(customerList.get(i).getID()).equals(ID) && customerList.get(i).getExist() == true) {
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean addCustomer(String ID, Kind_Of_Customers kind, int level, String name, String tele, String address, String postcode, String email, double InValue, double in, double out, String DAE) {
        CustomerVO newcustomer = new CustomerVO(ID, kind, level, name, tele,
                address, postcode, email, InValue, in, out, DAE);
        customerList.add(newcustomer);
        return true;
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
    public boolean ModifyCustomer(String ID, Kind_Of_Customers kind, int level, String name, String tele, String address, String postcode, String email, double InValue) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getID().equals(ID)) {
                customerList.get(i).setKind(kind);
                customerList.get(i).setLevel(level);
                customerList.get(i).setName(name);
                customerList.get(i).setPhonenumber(tele);
                customerList.get(i).setAddress(address);
                customerList.get(i).setPostcode(postcode);
                customerList.get(i).setEmail(email);
                customerList.get(i).setInvalue(InValue);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createPurchaseList(CustomerVO supplier, String store, String worker, ArrayList<CommodityVO> prolist, double sum, String remark) {
        String ID = createID(++purchaseIdNumber, 1);
        PurchaseBillVO purchaseList = new PurchaseBillVO(ID, supplier, store, worker, prolist, sum, remark);
        supplier.paymoney = sum;//修改进货商的应收（向进货商支付货款）
        return true;
    }

    @Override
    public boolean createSalesList(CustomerVO saler, String DAE, String worker, String store, ArrayList<CommodityVO> prolist, double befSum, double discount, double vocher, double aftSum, String remark) {
        String ID = createID(++salesIdNumber, 3);
        SalesBillVO salesList = new SalesBillVO(ID, saler, DAE, worker, store, prolist, befSum, discount, vocher, aftSum, remark);
        saler.paymoney = aftSum;//修改销售商的应付（销售商收购货物，付款）
        return true;
    }

    @Override
    public boolean createPurchaseReturnList(CustomerVO supplier, String store, String worker, ArrayList<CommodityVO> prolist, double sum, String remark) {
        String ID = createID(++purchaseReturnIdNumber, 2);
        PurchaseBillVO purchaseReturnList = new PurchaseBillVO(ID, supplier, store, worker, prolist, sum, remark);
        supplier.incomemoney = sum;//修改进货商的应付（退货给进货商，进货商归还货款）
        return true;
    }

    @Override
    public boolean createSalesReturnList(CustomerVO saler, String DAE, String worker, String store, ArrayList<CommodityVO> prolist, double befSum, double discount, double vocher, double aftSum, String remark) {
        String ID = createID(++salesReturnIdNumber, 4);
        SalesBillVO salesReturnList = new SalesBillVO(ID, saler, DAE, worker, store, prolist, befSum, discount, vocher, aftSum, remark);
        saler.incomemoney = aftSum;//修改销售商的应收（销售商退货，向销售商归还货款）
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
