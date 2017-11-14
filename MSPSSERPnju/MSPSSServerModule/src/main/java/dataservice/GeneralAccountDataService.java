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
     * @param begin,end
     * @return 建账信息列表
     */
    public ArrayList<GeneralAccountPO> checkGeneralAccount(Time begin, Time end);
}
