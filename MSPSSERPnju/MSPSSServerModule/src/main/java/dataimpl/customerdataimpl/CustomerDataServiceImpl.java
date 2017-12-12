package dataimpl.customerdataimpl;

import datahelper.DataHelper;
import dataservice.CustomerDataService;
import po.CustomerPO;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class CustomerDataServiceImpl implements CustomerDataService{

    private DataHelper<CustomerPO> customerHelper;

    protected CustomerDataServiceImpl(DataHelper<CustomerPO> customerHelper){
        this.customerHelper = customerHelper;
    }

    /**
     * 增加客户
     * @param po
     * @return
     */
    public ResultMessage addCustomer(CustomerPO po){
        try{
            customerHelper.save(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("add customer fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 更新
     * @param po
     * @return
     */
    public ResultMessage updateCustomer(CustomerPO po){
        try{
            customerHelper.update(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("update customer fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public ResultMessage deleteCustomer(String id){
        try{
            customerHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("delete customer fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 完全匹配
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CustomerPO> fullSearchCustomer(String field, Object value){
        return customerHelper.fullMatchQuery(field,value);
    }

    /**
     * 模糊查询
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CustomerPO> fuzzSearchCustomer(String field,String value){
        return customerHelper.fuzzyMatchQuery(field,value);
    }

    /**
     * 范围查找
     * @param field,min,max
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CustomerPO> rangeSearchCustomer(String field,Object min,Object max){
        return customerHelper.rangeQuery(field,min,max);
    }

    /**
     * 精确搜索id
     * @param ID
     * @return
     */
    public CustomerPO searchCustomerByID(String ID){
        return customerHelper.exactlyQuery("id",ID);
    }
}
