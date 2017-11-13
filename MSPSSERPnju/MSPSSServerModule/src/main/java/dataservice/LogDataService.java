package dataservice;

import po.LogPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */
public interface LogDataService {

    /**
     * 增加一条日志
     *
     * @param logPO
     * @return ResultMessage
     */
    public ResultMessage add(LogPO logPO);

    /**
     * 搜索符合日期的日志
     *
     * @param
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search (Time date);
}
