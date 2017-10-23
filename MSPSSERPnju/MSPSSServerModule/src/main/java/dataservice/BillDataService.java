package dataservice;

import com.sun.org.apache.regexp.internal.RE;
import util.ResultMessage;

public interface BillDataService {
    public ResultMessage MakeLossAndOverflowReport();

    public ResultMessage MakePresentationReport();

    public ResultMessage DealAlarmReport();

}
