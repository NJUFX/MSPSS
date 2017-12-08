package blimpl.logblimpl;

/**
 * Description:
 * Created by Hanxinhu at 16:41 2017/12/8/008
 */
public class LogFactory {
    private static Log log = new Log();
    private static LogBLServiceImpl impl;
    public static synchronized LogBLServiceImpl getLogBLServiceImpl(){
        if (impl==null){
            impl = new LogBLServiceImpl(log);
        }
        return impl;
    }

}
