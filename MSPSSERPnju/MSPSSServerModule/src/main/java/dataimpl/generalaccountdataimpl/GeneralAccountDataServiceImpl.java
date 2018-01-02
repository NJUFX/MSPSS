package dataimpl.generalaccountdataimpl;

import datahelper.DataHelper;

import dataimpl.accountdataimpl.AccountDataServiceImpl;
import dataservice.AccountDataService;
import dataservice.GeneralAccountDataService;
import po.*;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class GeneralAccountDataServiceImpl implements GeneralAccountDataService {
    private DataHelper<AccountPO> accountHelper;
    private DataHelper<CustomerPO> customerHelper;
    private DataHelper<CommodityPO> commodityHelper;
    private DataHelper<GeneralAccountPO> generalAccountHelper;
    protected GeneralAccountDataServiceImpl(DataHelper<AccountPO> accountHelper,DataHelper<CustomerPO> customerHelper,DataHelper<CommodityPO> commodityHelper,DataHelper<GeneralAccountPO> generalAccountHelper ){
        this.accountHelper = accountHelper;
        this.customerHelper= customerHelper;
        this.commodityHelper = commodityHelper;
        this.generalAccountHelper = generalAccountHelper;
    }

    /**
     * 新建期初建账
     *
     * @param generalaccount
     * @return 新建成功与否
     */
    public ResultMessage newGeneralAccount(GeneralAccountPO generalaccount){

        //如果没有赋值list里的generalaccountr，因为是一对一，就会发生联级错误!!!!

            generalAccountHelper.save(generalaccount);

            //清空数据
            accountHelper.clear("accountpo");
            commodityHelper.clear("commoditypo");
            customerHelper.clear("customerpo");

            //添加新的期初建账的数据


            String time = generalaccount.getTime();

            //获取List
            List<GeneralAccount_AccountList_PO> accountList = generalaccount.getAccountlist();
            List<GeneralAccount_CommodityList_PO> commodityList = generalaccount.getCommoditylist();
            List<GeneralAccount_CustomerList_PO> customerList = generalaccount.getCustomerlist();


            //用来保存po的临时变量
            AccountPO account;
            CommodityPO commodity;
            CustomerPO customer;

            //添加PO到对应的表中
            for(int i=0;i<=accountList.size()-1;i++){
                account  = changeToAccountPO(accountList.get(i),time);

                accountHelper.save(account);
            }

            for(int i=0;i<=commodityList.size()-1;i++){
                commodity = changeToCommodity(commodityList.get(i));
                commodityHelper.save(commodity);
            }

            for(int i=0;i<=customerList.size()-1;i++){
                customer = changeToCustomer(customerList.get(i));
                customerHelper.save(customer);
            }


            return ResultMessage.SUCCESS;
    }
    /**
     * 查询建账信息
     *
     * @param field,min,max
     * @return 建账信息列表
     */
    public ArrayList<GeneralAccountPO> checkGeneralAccount(String field, Object min, Object max){
        return generalAccountHelper.rangeQuery(field,min,max);
    }


    /**
     * 精确查询
     * @param field,value
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,Object value){
        return generalAccountHelper.exactlyQuery(field,value);
    }

    /**
     * 多个匹配
     * @param field value
     */
    public ArrayList<GeneralAccountPO> fullSearchGeneralAccount(String field,Object value){
        return generalAccountHelper.fullMatchQuery(field, value);
    }

    /**
     * 模糊查找
     * @param field,value
     */
    public ArrayList<GeneralAccountPO> fuzzySearchGeneralAccount(String field,String value){
        return generalAccountHelper.fuzzyMatchQuery(field, value);
    }

    /**
     * 范围查找
     * @param field,min,max
     */
    public ArrayList<GeneralAccountPO> rangeSearchGeneralAccount(String field,Object min,Object max){
        return generalAccountHelper.rangeQuery(field,min,max);
    }

    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerPO searchCustomer(String name){
        return customerHelper.exactlyQuery("name",name);
    }

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityPO searchCommodity(String name){
        return commodityHelper.exactlyQuery("name",name);
    }

    //以下是实现功能的辅助私有类


    /**
     * 转化GeneralAccount_AccountList_PO到AccountPO
     * @param account
     * @return
     */
    private AccountPO changeToAccountPO(GeneralAccount_AccountList_PO account,String time){

        AccountPO result = new AccountPO();
        result.setMoney(account.getMoney());
        result.setName(account.getName());
        result.setCreatetime(time);

        return result;
    }

    /**
     * 转化GeneralAccount_CommodityList_PO到CommodityPO
     * @param commodity
     * @return
     */
    private CommodityPO changeToCommodity(GeneralAccount_CommodityList_PO commodity){

        CommodityPO result = new CommodityPO();
        result.setClassificationID(commodity.getClassificationID());
        result.setExportCost(commodity.getExportCost());
        result.setID(commodity.getID());
        result.setImportCost(commodity.getImportCost());
        result.setName(commodity.getName());
        result.setNumberInStock(commodity.getNumberInStock());
        result.setType(commodity.getType());
        result.setUsed(false);

        return result;

    }

    /**
     * 转化GeneralAccount_CustomerList_PO到CustomerPO
     * @param customer
     * @return
     */
    private CustomerPO changeToCustomer(GeneralAccount_CustomerList_PO customer){
        CustomerPO result = new CustomerPO();

        result.setAddress(customer.getAddress());
        result.setCategory(customer.getCategory());
        result.setDAE("期初建帐");
        result.setEmail(customer.getEmail());
        result.setExist(customer.isExist());
        result.setID(customer.getID());
        result.setIncomemoney(customer.getIncomemoney());
        result.setInvalue(customer.getInvalue());
        result.setLevel(customer.getLevel());
        result.setName(customer.getName());
        result.setPaymoney(customer.getPaymoney());
        result.setPhonenumber(customer.getPhonenumber());
        result.setPostcode(customer.getPostcode());

        return result;

    }

}
