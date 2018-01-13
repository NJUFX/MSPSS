package blstubdriver.generalaccountstubdriver;

import blservice.generalaccountblservice.GeneralAccountBLService;
import util.ResultMessage;
import util.Time;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class GeneralAccount_Stub implements GeneralAccountBLService {
    /**
     * 添加期初账户
     *
     * @param generalAccountPO@return ResultMessage
     */
    @Override
    public ResultMessage addGeneralAcocunt(GeneralAccountVO generalAccountPO) {
        return null;
    }

    /**
     * 精确查找账户，按账户的名称
     *
     * @param name
     * @return
     */
    @Override
    public GeneralAccountVO exactlySearchGeneralAccountByName(String name) {
        return null;
    }

    /**
     * 输出一个时间里的所有账户
     *
     * @param time
     * @return
     */
    @Override
    public ArrayList<GeneralAccountVO> fullSearchGeneralAccountByTime(Time time) {
        return null;
    }

    /**
     * 模糊查找，按账户名称查找，如“2017第一季度总账”可以输入value为“2017”来查找
     *
     * @param value
     * @return
     */
    @Override
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccountByName(String value) {
        return null;
    }

    /**
     * 范围搜索，按时间区间来搜索账户
     *
     * @param min
     * @param max
     * @return
     */
    @Override
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccountByTime(Time min, Time max) {
        return null;
    }

    /**
     * 在已有数据库中搜索客户
     *
     * @param name
     * @return
     */
    @Override
    public CustomerVO searchCustomer(String name) {
        return null;
    }

    /**
     * 在已有数据库中搜索商品
     *
     * @param name
     * @return
     */
    @Override
    public CommodityVO searchCommodity(String name) {
        return null;
    }
}
