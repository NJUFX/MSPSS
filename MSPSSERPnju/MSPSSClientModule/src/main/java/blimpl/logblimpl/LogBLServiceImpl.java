package blimpl.logblimpl;

import blservice.logblservice.LogBLInfo;
import blservice.logblservice.LogBLService;
import util.ResultMessage;
import util.Time;
import vo.LogFilterVO;
import vo.LogVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/21
 */

public class LogBLServiceImpl implements LogBLService,LogBLInfo{
    public Log log;

    public LogBLServiceImpl(Log log) {
        this.log = log;
    }


    @Override
    public ArrayList<LogVO> operatorSearchLog(String operator) {
        return log.operatorSearchLog(operator);
    }

    @Override
    public ArrayList<LogVO> operateSearchLog(String operate) {
        return log.operateSearchLog(operate);
    }

    @Override
    public ResultMessage add(LogVO logVO) {
        return log.add(logVO);
    }

    @Override
    public ArrayList<LogVO> timeSearchLog(Time start, Time end) {
        return log.timeSearchLog(start, end);
    }

    @Override
    public ArrayList<LogVO> multiSearch(LogFilterVO filterVO) {
        return log.multiSearchLog(filterVO);
    }
}
