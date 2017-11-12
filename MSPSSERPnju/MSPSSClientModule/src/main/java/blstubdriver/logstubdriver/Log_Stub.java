package blstubdriver.logstubdriver;

import blservice.logblservice.LogBLService;
import po.LogPO;
import util.Time;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

public class Log_Stub implements LogBLService {

    //constant
    ArrayList<LogPO> Test_LogPOList = new ArrayList<LogPO>();
    LogPO Test_LogPO = new LogPO("000001","jiangchen","17/11/20","sell","Bulb",100,10000);


    /**
     * 搜索日志记录
     *
     * @param date
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search(Time date){
        Test_LogPOList.add(Test_LogPO);
        return Test_LogPOList;
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
    };
}
