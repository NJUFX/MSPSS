package dataservice.custmoerdataservice;

import po.*;
import util.*;
public interface CustomerDataService {

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    public CustomerPO getCustomerInfo(String ID);

    /**
     * 增加客户
     *
     * @param ID       客户编号
     * @param kind 分类
     * @param level
     * @param name
     * @param tele
     * @param address
     * @param postcode 邮编
     * @param email
     * @param InValue  应收额度
     * @param in       应收
     * @param out      应付
     * @param DAE      默认业务员
     * @return
     */
    public boolean addCustomer(String ID, Kind_Of_Customers kind, int level, String name, String tele, String address, String postcode, String email, double InValue, double in, double out, String DAE);

    /**
     * 增加客户
     *
     * @param customer
     * @return
     */
    public boolean addCustomer(CustomerPO customer);

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    public boolean delCustomer(String ID);

    /**
     * 修改客户属性
     *
     * @param kind
     * @param level
     * @param name
     * @param tele
     * @param address
     * @param postcode
     * @param email
     * @param InValue
     * @return
     */
    public boolean modifyCustomer(String ID, Kind_Of_Customers kind, int level, String name, String tele, String address, String postcode, String email, double InValue);

}
