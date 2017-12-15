package dataservice;

import po.LogPO;
import util.CriteriaClause;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */
public interface LogDataService {

    /**
     * 增加日志
     * @param logPO
     * @return 增加日志的结果
     */
    public ResultMessage addLog(LogPO logPO);

    /**
     * 范围查找
     * @param field
     * @param min
     * @param max
     * @return 符合条件的list
     */
    public ArrayList<LogPO> rangeSearch(String field,Object min,Object max);

    /**
     * 精确查找
     * @param field
     * @param value
     * @return符合条件的list
     */
    public ArrayList<LogPO> fullSearch(String field,Object value);

    /**
     * 多重条件搜索
     */
    public ArrayList<LogPO> multiSearchLog(ArrayList<CriteriaClause> criteriaClauses);
}
