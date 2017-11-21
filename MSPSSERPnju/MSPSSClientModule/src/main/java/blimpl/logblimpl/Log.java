package blimpl.logblimpl;

import po.LogPO;
import util.ResultMessage;
import util.Time;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/21
 */
public class Log {

    /**
     *增加一条日志记录
     *
     * @param logPO
     * @return ResultMessage
     */
    public ResultMessage add(LogPO logPO){
        return ResultMessage.SUCCESS;
    }

    /**
     * 搜索日志记录
     *
     * @param date
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search(Time date){
        return null;
    }

    /**
     * 显示日志列表
     *
     * @param logList
     * @return LogListVO
     */
    public LogListVO showLogList(ArrayList<LogPO> logList){
        return null;
    }

    /**
     * 显示日志详情
     *
     * @param id
     * @return LogVO
     */
    public LogVO showLogDetail(String id){
        return null;
    }

}
