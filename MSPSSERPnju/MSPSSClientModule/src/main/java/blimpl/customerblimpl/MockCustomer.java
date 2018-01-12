package blimpl.customerblimpl;


import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public class MockCustomer extends Customer {

    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
        return super.searchCustomer(keytype, keyword);
    }

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    @Override
    public CustomerVO getCustomerInfo(String ID) {
        return super.getCustomerInfo(ID);
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public ResultMessage addCustomer(CustomerVO customer) {
        return super.addCustomer(customer);
    }

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    @Override
    public ResultMessage delCustomer(String ID) {
        return super.delCustomer(ID);
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public ResultMessage modifyCustomer(CustomerVO customer) {
        return super.modifyCustomer(customer);
    }

    /**
     * 改变用户的应收额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */
    @Override
    public ResultMessage changeYingShou(String customerID, double money) {
        return super.changeYingShou(customerID, money);
    }

    /**
     * 改变客户的应付额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */
    @Override
    public ResultMessage changeYingFu(String customerID, double money) {
        return super.changeYingFu(customerID, money);
    }
}