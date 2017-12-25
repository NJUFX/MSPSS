package blimpl.generalaccountblimpl;

import blservice.generalaccountblservice.GeneralAccountBLService;
import po.GeneralAccountPO;
import util.ResultMessage;
import util.Time;
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
     * 精确查找商品
     * @param id
     * @return
     */
    public GeneralAccountVO exactlySearchGeneralAccount(String field,String id){
        return generalAccount.exactlySearchGeneralAccount(field, id);
    }

    public ArrayList<GeneralAccountVO> fullSearchGeneralAccount(String field, Object value){
        return generalAccount.fullSearchGeneralAccount(field, value);
    }
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccount(String filed,String value){
        return generalAccount.fuzzySearchGeneralAccount(filed, value);
    }


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccount(String field, Object min, Object max){
        return generalAccount.rangeSearchGeneralAccount(field, min, max);
    }

}
