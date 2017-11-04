package blservice.stocksellerblservice;

import util.Kind_Of_Customers;
import vo.*;

import javax.xml.crypto.KeySelector;
import java.lang.reflect.Array;
import java.util.*;

public interface StockSellerBLService {
    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword);

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    public CustomerVO getCustomerInfo(String ID);

    /**
     *
     * @param customer
     * @return
     */
    public boolean addCustomer(CustomerVO customer);

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    public boolean delCustomer(String ID);

    /**
     *
     * @param customer
     * @return
     */
    public boolean modifyCustomer(CustomerVO customer);

    /**
     *
     * @param purchase
     * @return
     */
    public boolean createPurchase(PurchaseVO purchase);

    /**
     *
     * @param purRet
     * @return
     */
    public boolean createPurchaseRet(PurchaseVO purRet);

    /**
     *
     * @param sales
     * @return
     */
    public boolean createSales(SalesVO sales);

    /**
     *
     * @param salesRet
     * @return
     */
    public boolean createSalesRet(SalesVO salesRet);

    //public ArrayList<CommodityVO> createCommodityList();
}
