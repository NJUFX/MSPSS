package blservice.logblservice;

import blimpl.logblimpl.Log;
import po.LogPO;
import util.ResultMessage;
import vo.LogVO;

/**
 * Created by Harper on 17/11/21
 */
public interface LogBLInfo {


    /**
     *增加一条日志记录
     *
     * @param logVO
     * @return ResultMessage
     */
    public ResultMessage add(LogVO logVO);

}
