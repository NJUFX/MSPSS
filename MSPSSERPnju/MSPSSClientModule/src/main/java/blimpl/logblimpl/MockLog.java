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
public class MockLog extends Log{

    /**
     *增加一条日志记录
     *
     * @param logPO
     * @return ResultMessage
     */
    public ResultMessage add(LogPO logPO){
        loglist.add(logPO);
        return ResultMessage.SUCCESS;
    }

    /**
     * 搜索日志记录
     *
     * @param date
     * @return ArrayList<LogPO>
     */
    public ArrayList<LogPO> search(Time date){
        String time = date.getyear()+"/"+date.getmonth()+"/"+date.getday();
        ArrayList<LogPO> searchList = new ArrayList<LogPO>();
        for(int i=0;i<loglist.size();i++){
            if(time.equals(loglist.get(i).getTime())){
                searchList.add(loglist.get(i));
            }
        }
        return searchList;
    }

    /**
     * 显示日志列表
     *
     * @param logList
     * @return LogListVO
     */
    public LogListVO showLogList(ArrayList<LogPO> logList){
        LogListVO result = new LogListVO(0,logList);
        return result;
    }

    /**
     * 显示日志详情
     *
     * @param id
     * @return LogVO
     */
    public LogVO showLogDetail(String id){
        for(int i=0;i<loglist.size();i++){
            if(loglist.get(i).getId().equals(id)){
                LogPO temp =  loglist.get(i);
                LogVO result = new LogVO(temp.getId(),temp.getOperator(),temp.getTime(),temp.getKind(),temp.getCommodity(),temp.getMoney(),temp.getStock());
           return result;
            }

        }
        return null;
    }

}
