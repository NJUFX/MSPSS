package blservice.logblservice;

import po.LogPO;
import util.Time;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/12
 *
 */

public interface LogBLService {

    /**
     * 搜索日志记录
     *
     * @param date
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search(Time date);

    /**
     * 显示日志列表
     *
     * @param logList
     * @return LogListVO
     */
    public LogListVO showLogList(ArrayList<LogPO> logList);

    /**
     * 显示日志详情
     *
     * @param id
     * @return LogVO
     */
    public LogVO showLogDetail(String id);

}
