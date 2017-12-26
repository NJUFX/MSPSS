package blimpl.generalaccountblimpl;

import blservice.generalaccountblservice.GeneralAccountBLService;
import po.CommodityPO;
import po.GeneralAccountPO;
import util.ResultMessage;
import util.Time;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class GeneralAccountBLServiceImpl implements GeneralAccountBLService {

    GeneralAccount generalAccount ;

    protected GeneralAccountBLServiceImpl(GeneralAccount generalAccount){
        this.generalAccount = generalAccount;
    }

    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountVO generalAccountVO){
        return generalAccount.addGeneralAcocunt(generalAccountVO);
    }


    /**
     * 按名字精确查找账户
     * @param name
     * @return
     */
    public GeneralAccountVO exactlySearchGeneralAccountByName(String name){
        return generalAccount.exactlySearchGeneralAccount("name", name);
    }

    public ArrayList<GeneralAccountVO> fullSearchGeneralAccountByTime(Time time){
        return generalAccount.fullSearchGeneralAccount("time", time.toString());
    }
    /**
     *按名称模糊查找
     *
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccountByName(String value){
        return generalAccount.fuzzySearchGeneralAccount("name", value);
    }


    /**
     *
     *按时间范围查找
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccountByTime(Time min, Time max){
        return generalAccount.rangeSearchGeneralAccount("time", min.toString(), max.toString());
    }

    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerVO searchCustomer(String name){
        return generalAccount.searchCustomer(name);
    }

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityVO searchCommodity(String name){
        return generalAccount.searchCommodity(name);
    }

}
