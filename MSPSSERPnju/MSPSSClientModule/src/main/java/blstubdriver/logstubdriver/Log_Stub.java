package blstubdriver.logstubdriver;

/**
 * Created by Harper on 17/11/12
 */

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
    LogListVO Test_LogListVO = new LogListVO(1,Test_LogPOList );
    LogVO Test_LogVO = new LogVO("000001","jiangchen","17/11/20","sell","Bulb",100,10000);


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
<<<<<<< HEAD
        return null;
=======
        return Test_LogListVO;
>>>>>>> 9c80da424553c51f7597566a5c9419f7da4fc9d3
    }

    /**
     * 显示日志详情
     *
     * @param id
     * @return LogVO
     */
    public LogVO showLogDetail(String id){
<<<<<<< HEAD
        return null;
    };
=======
        return Test_LogVO;
    }
>>>>>>> 9c80da424553c51f7597566a5c9419f7da4fc9d3
}
