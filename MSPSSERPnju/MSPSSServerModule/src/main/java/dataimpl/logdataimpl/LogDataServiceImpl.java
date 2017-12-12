package dataimpl.logdataimpl;

import datahelper.DataHelper;
import datahelper.HibernateHelper;
import dataservice.LogDataService;
import po.LogPO;
import util.ResultMessage;

import java.util.ArrayList;


/**
 * Created by thinkpad on 2017/12/8.
 */
public class LogDataServiceImpl implements LogDataService {

    private HibernateHelper<LogPO> logHelper;

    protected LogDataServiceImpl(HibernateHelper<LogPO> logHelper){
        this.logHelper = logHelper;
    }

    /**
     * 增加日志
     * @param logPO
     * @return 增加日志的结果
     */
    public ResultMessage addLog(LogPO logPO){
        try{
            logHelper.save(logPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            return ResultMessage.FAILED;
        }
    }

    /**
     * 范围查找
     * @param field
     * @param min
     * @param max
     * @return 符合条件的list
     */
    public ArrayList<LogPO> rangeSearch(String field, Object min, Object max){
        return logHelper.rangeQuery(field,min,max);
    }

    /**
     * 精确查找
     * @param field
     * @param value
     * @return符合条件的list
     */
    public ArrayList<LogPO> fullSearch(String field,Object value){
        return logHelper.fullMatchQuery(field,value);
    }


}
