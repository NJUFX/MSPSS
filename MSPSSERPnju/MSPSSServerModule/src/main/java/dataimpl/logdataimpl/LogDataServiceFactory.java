package dataimpl.logdataimpl;

import datahelper.HibernateHelper;
import dataservice.LogDataService;
import po.LogPO;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class LogDataServiceFactory {
    private static LogDataServiceImpl logDataService;

    public static synchronized LogDataService getLogDataService() {
        if (logDataService == null) {
            logDataService = new LogDataServiceImpl(new HibernateHelper<LogPO>(LogPO.class));
        }
        return logDataService;
    }
}
