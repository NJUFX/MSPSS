package blservice.logblservice;

import po.LogPO;
import util.Time;
import vo.LogFilterVO;
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
     * @param start,end
     * @return ArrayList<LogVO>
     */
    public ArrayList<LogVO> timeSearchLog(Time start, Time end);

    /**
     * 通过多个条件来查询 时间 操作员 操作
     * @param filterVO
     * @return
     */
    public ArrayList<LogVO> multiSearch(LogFilterVO filterVO);

    /**
     * 通过产生日志的操作员id来查询
     * @param operator
     * @return
     */
    public ArrayList<LogVO> operatorSearchLog(String operator);

    /**
     * 查询特定的操作
     * @param operate
     * @return
     */
    public ArrayList<LogVO> operateSearchLog(String operate);

}
