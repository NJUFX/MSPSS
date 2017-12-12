package dataservice;

import po.*;
import util.*;

import java.util.ArrayList;

public interface CustomerDataService {

    /**
     * 增加客户
     * @param po
     * @return
     */
    public ResultMessage addCustomer(CustomerPO po);

    /**
     * 更新
     * @param po
     * @return
     */
    public ResultMessage updateCustomer(CustomerPO po);

    /**
     * 删除
     * @param id
     * @return
     */
    public ResultMessage deleteCustomer(String id);

    /**
     * 完全匹配
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CustomerPO> fullSearchCustomer(String field, Object value);

    /**
     * 模糊查询
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CustomerPO> fuzzSearchCustomer(String field,String value);

    /**
     * 范围查找
     * @param filed
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CustomerPO> rangeSearchCustomer(String filed,Object min,Object max);

    /**
     * 精确搜索id
     * @param ID
     * @return
     */
    public CustomerPO searchCustomerByID(String ID);


}
