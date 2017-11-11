package blimpl.stocksellerblimpl;

import vo.*;

import java.util.*;

public class Customer {
    public static ArrayList<CustomerVO> CustomerList = new ArrayList<CustomerVO>();

    /**
     * 通过关键词搜索客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
        return CustomerList;
    }

    /**
     * 增加客户
     *
     * @param newCustomer
     * @return
     */
    public boolean addCustomer(CustomerVO newCustomer) {
        return true;
    }

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    public boolean delCustomer(String ID) {
        return true;
    }

    /**
     * 修改客户属性
     *
     * @param modCustomer
     * @return
     */
    public boolean modifyCustomer(CustomerVO modCustomer) {
        return true;
    }
}
