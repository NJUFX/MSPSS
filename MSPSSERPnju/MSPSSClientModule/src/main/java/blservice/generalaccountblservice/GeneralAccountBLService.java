package blservice.generalaccountblservice;

import po.GeneralAccountPO;
import util.ResultMessage;
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
     * 精确查找商品
     * @param field,id
     * @return
     */
    public GeneralAccountVO exactlySearchGeneralAccount(String field,String id);

    public ArrayList<GeneralAccountVO> fullSearchGeneralAccount(String field, Object value);
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccount(String filed,String value);


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccount(String field, Object min, Object max);


}
