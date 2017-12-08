package network;

import po.LogPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 14:05 2017/11/30/030
 */
public interface LogClientNetworkService extends Remote {
    public ResultMessage addLog(LogPO logPO);

    public ArrayList<LogPO> rangeSearch(String field,Object min,Object max);

    public ArrayList<LogPO> fullSearch(String field,Object value);

    public ArrayList<LogPO> multiSearchLog(ArrayList<CriteriaClause> criteriaClauses);
}
