package datastubdriver.logdatastubdriver;

/**
 * Created by Harper on 17/11/13
 */

import dataservice.LogDataService;
import po.LogPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

public class LogData_Stub implements LogDataService{

    /**
     * 增加一条日志
     *
     * @param logPO
     * @return ResultMessage
     */
    public ResultMessage add(LogPO logPO){
        return ResultMessage.SUCCESS;
    }

    /**
     * 搜索符合日期的日志
     *
     * @param
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search (Time date){
        ArrayList<LogPO> Test_LogPOList = new ArrayList<LogPO>();
        LogPO Test_LogPO = new LogPO();
        Test_LogPOList.add(Test_LogPO);
        return Test_LogPOList;
    }
}
