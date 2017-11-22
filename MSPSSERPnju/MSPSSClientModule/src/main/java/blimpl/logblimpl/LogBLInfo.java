package blimpl.logblimpl;

import po.LogPO;
import util.ResultMessage;

/**
 * Created by Harper on 17/11/21
 */
public class LogBLInfo {

    /**
     *增加一条日志记录
     *
     * @param logPO
     * @return ResultMessage
     */
    public ResultMessage add(LogPO logPO){
        return ResultMessage.SUCCESS;
    }

}
