package dataservice;

import po.CommodityPO;
import po.CustomerPO;
import po.GeneralAccountPO;
import util.ResultMessage;
import util.Time;


import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public interface GeneralAccountDataService {

    /**
     * 新建期初建账
     *
     * @param generalaccount
     * @return 新建成功与否
     */
    public ResultMessage newGeneralAccount(GeneralAccountPO generalaccount);
    /**
     * 查询建账信息
     *
     * @param field,min,max
     * @return 建账信息列表
     */
    public ArrayList<GeneralAccountPO> checkGeneralAccount(String field,Object min,Object max);

    /**
     * 精确查询
     * @param field,value
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,Object value);



    /**
     * 多个匹配
     * @param field value
     */
    public ArrayList<GeneralAccountPO> fullSearchGeneralAccount(String field,Object value);
    /**
     * 模糊查找
     * @param field,value
     */
    public ArrayList<GeneralAccountPO> fuzzySearchGeneralAccount(String field,String value);

    /**
     * 范围查找
     * @param field,min,max
     */
    public ArrayList<GeneralAccountPO> rangeSearchGeneralAccount(String field,Object min,Object max);

    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerPO searchCustomer(String name);

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityPO searchCommodity(String name);
}
