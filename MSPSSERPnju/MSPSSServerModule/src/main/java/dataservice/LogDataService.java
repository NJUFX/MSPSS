package dataservice;

import po.LogPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */
public interface LogDataService {

    public ResultMessage addLog(LogPO logPO);

    public ArrayList<LogPO> rangeSearch(String field,Object min,Object max);

    public ArrayList<LogPO> fullSearch(String field,Object value);
}
