package network;

import network.lognetworkservice.LogServerNetworkService;
import po.LogPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/15.
 */
public class LogClientNetworkImpl implements  LogClientNetworkService {

    private LogServerNetworkService logServerNetworkService;

    public LogClientNetworkImpl(){
        try {
            logServerNetworkService = (LogServerNetworkService) Naming.lookup("LogServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.LogServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ResultMessage addLog(LogPO logPO){
        try{
           return logServerNetworkService.addLog(logPO);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<LogPO> rangeSearch(String field, Object min, Object max){
        try{
          return logServerNetworkService.rangeSearch(field, min, max);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<LogPO> fullSearch(String field,Object value){
        try{
           return logServerNetworkService.fullSearch(field, value);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<LogPO> multiSearchLog(ArrayList<CriteriaClause> criteriaClauses){
        try{
           return   logServerNetworkService.multiSearchLog(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        LogClientNetworkService logClientNetworkService = new LogClientNetworkImpl();
        System.out.println(logClientNetworkService.toString());
        logClientNetworkService.addLog(new LogPO("89","21","12","13"));
    }
}
