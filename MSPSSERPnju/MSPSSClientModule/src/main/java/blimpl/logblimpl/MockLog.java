package blimpl.logblimpl;

import util.ResultMessage;
import util.Time;
import vo.LogFilterVO;
import vo.LogVO;

import java.util.ArrayList;

public class MockLog extends Log {
    @Override
    public ResultMessage add(LogVO logVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<LogVO> operatorSearchLog(String operator) {
        return super.operatorSearchLog(operator);
    }

    @Override
    public ArrayList<LogVO> operateSearchLog(String operate) {
        return super.operateSearchLog(operate);
    }

    @Override
    public ArrayList<LogVO> timeSearchLog(Time start, Time end) {
        return super.timeSearchLog(start, end);
    }

    @Override
    public ArrayList<LogVO> multiSearchLog(LogFilterVO filterVO) {
        return super.multiSearchLog(filterVO);
    }
}