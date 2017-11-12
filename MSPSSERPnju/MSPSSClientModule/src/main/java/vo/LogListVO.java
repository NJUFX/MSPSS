package vo;

import po.LogPO;

import java.util.ArrayList;

public class LogListVO {
    int logAmount;
    ArrayList<LogPO> logList;

    public LogListVO(int i, ArrayList<LogPO> arr) {
        logAmount = i;
        logList = arr;
    }

    public int getLogAmount() {
        return logAmount;
    }

    public ArrayList<LogPO> getLogList() {
        return logList;
    }
}
