package blservice.generalaccountblservice;

import po.CommodityPO;
import po.GeneralAccountPO;
import util.ResultMessage;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.GeneralAccountVO;
import util.Time;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public interface GeneralAccountBLService {

    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountVO generalAccountPO);


    /**
     * 精确查找账户，按账户的名称
     * @param name
     * @return
     */
    public GeneralAccountVO exactlySearchGeneralAccountByName(String name);

    /**
     *输出一个时间里的所有账户
     *
     * @param time
     * @return
     */
    public ArrayList<GeneralAccountVO> fullSearchGeneralAccountByTime(Time time);
    /**
     *模糊查找，按账户名称查找，如“2017第一季度总账”可以输入value为“2017”来查找
     *
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccountByName(String value);


    /**
     *范围搜索，按时间区间来搜索账户
     *
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccountByTime(Time min, Time max);



    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerVO searchCustomer(String name);

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityVO searchCommodity(String name);

}
