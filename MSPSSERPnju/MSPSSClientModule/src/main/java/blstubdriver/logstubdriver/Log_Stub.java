
package blstubdriver.logstubdriver;

/**
 * Created by Harper on 17/11/12
 */

import blservice.logblservice.LogBLService;
import po.LogPO;
import util.Time;
import vo.LogFilterVO;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

public class Log_Stub implements LogBLService {
    /**
     * 搜索日志记录
     *
     * @param start
     * @param end
     * @return ArrayList<LogVO>
     */
    @Override
    public ArrayList<LogVO> timeSearchLog(Time start, Time end) {
        return null;
    }

    /**
     * 通过多个条件来查询 时间 操作员 操作
     *
     * @param filterVO
     * @return
     */
    @Override
    public ArrayList<LogVO> multiSearch(LogFilterVO filterVO) {
        return null;
    }

    /**
     * 通过产生日志的操作员id来查询
     *
     * @param operator
     * @return
     */
    @Override
    public ArrayList<LogVO> operatorSearchLog(String operator) {
        return null;
    }

    /**
     * 查询特定的操作
     *
     * @param operate
     * @return
     */
    @Override
    public ArrayList<LogVO> operateSearchLog(String operate) {
        return null;
    }

    //constant
    ArrayList<LogPO> Test_LogPOList = new ArrayList<LogPO>();
    LogPO Test_LogPO = new LogPO("000001", "jiangchen", "17/11/20", "222231");
    LogListVO Test_LogListVO = new LogListVO(1, Test_LogPOList);
    LogVO Test_LogVO = new LogVO("000001", "jiangchen", new Time(), "21");


    /**
     * 搜索日志记录
     *
     * @param date
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search(Time date) {
        Test_LogPOList.add(Test_LogPO);
        return Test_LogPOList;
    }

    /**
     * 显示日志列表
     *
     * @param logList
     * @return LogListVO
     */
    public LogListVO showLogList(ArrayList<LogPO> logList) {
        return Test_LogListVO;

    }

    /**
     * 显示日志详情
     *
     * @param id
     * @return LogVO
     */
    public LogVO showLogDetail(String id) {

        return Test_LogVO;
    }

}

