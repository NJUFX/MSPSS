package blimpl.logblimpl;

import blservice.logblservice.LogBLInfo;
import blservice.logblservice.LogBLService;

/**
 * Description:
 * Created by Hanxinhu at 16:41 2017/12/8/008
 */
public class LogFactory {
    private static Log log = new Log();
    private static LogBLServiceImpl impl;

    public static synchronized LogBLInfo getLogBLInfo() {
        if (impl == null) {
            impl = new LogBLServiceImpl(log);
        }
        return impl;
    }

    public static synchronized LogBLService getLogBLService() {
        if (impl==null){
            impl = new LogBLServiceImpl(log);
        }
        return impl;
    }

}
