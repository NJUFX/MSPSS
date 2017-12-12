package dataservice;

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
}
