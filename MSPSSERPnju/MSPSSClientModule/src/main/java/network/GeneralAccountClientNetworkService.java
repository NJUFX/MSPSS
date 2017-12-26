package network;

import po.CommodityPO;
import po.CustomerPO;
import po.GeneralAccountPO;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;


/**
 * Description:
 * Created by Hanxinhu at 14:07 2017/11/30/030
 */
public interface GeneralAccountClientNetworkService {


    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountPO generalAccountPO);


    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,String id);

    public ArrayList<GeneralAccountPO> fullSearchGeneralAccount(String field, Object value);
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountPO> fuzzySearchGeneralAccount(String filed,String value);


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountPO> rangeSearchGeneralAccount(String field, Object min, Object max);


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
