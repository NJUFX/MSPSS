package network.lognetworkservice;

import po.LogPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface LogServerNetworkService {
    public ResultMessage addLog(LogPO logPO) throws RemoteException;

    public ArrayList<LogPO> rangeSearch(String field, Object min, Object max) throws RemoteException;

    public ArrayList<LogPO> fullSearch(String field,Object value) throws RemoteException;

    public ArrayList<LogPO> multiSearchLog(ArrayList<CriteriaClause> criteriaClauses) throws RemoteException;
}
