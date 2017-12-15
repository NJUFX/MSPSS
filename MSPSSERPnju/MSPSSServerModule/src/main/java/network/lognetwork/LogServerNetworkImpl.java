package network.lognetwork;
import dataimpl.logdataimpl.LogDataServiceFactory;
import dataservice.LogDataService;
import network.lognetworkservice.LogServerNetworkService;
import po.LogPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/12/14.
 */
public class LogServerNetworkImpl extends UnicastRemoteObject implements LogServerNetworkService {
    private LogDataService logDataService;

    public LogServerNetworkImpl() throws RemoteException{
        logDataService = LogDataServiceFactory.getLogDataService();
    }

    public ResultMessage addLog(LogPO logPO) throws RemoteException{
        return logDataService.addLog(logPO);
    }

    public ArrayList<LogPO> rangeSearch(String field, Object min, Object max) throws RemoteException{
        return  logDataService.rangeSearch(field,min,max);
    }

    public ArrayList<LogPO> fullSearch(String field,Object value) throws RemoteException{
        return logDataService.fullSearch(field,value);
    }

    public ArrayList<LogPO> multiSearchLog(ArrayList<CriteriaClause> criteriaClauses) throws RemoteException{
        return logDataService.multiSearchLog(criteriaClauses);
    }
}
