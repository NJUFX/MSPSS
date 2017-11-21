package log;

import blimpl.logblimpl.Log;
import blimpl.logblimpl.MockLog;
import org.junit.Test;
import po.LogPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Harper on 17/11/21
 */

public class LogMockTest {

    LogPO testLog = new LogPO("000001","jiangchen","2017/11/20","sell","Bulb",100,10000);
    Log log = new MockLog();

    @Test
    public void testAddLog(){
        ResultMessage test1 = log.add(testLog);
        assertEquals(test1,ResultMessage.SUCCESS);
    }

    @Test
    public void testSearchLog(){
        ArrayList<LogPO> test2 = log.search(new Time(2017,11,20,22,12,34));
        assertNotNull(test2);
    }

    @Test
    public void testShowLogList(){
        ArrayList<LogPO> test3 = new ArrayList<LogPO>();
        test3.add(testLog);
        assertNotNull(log.showLogList(test3));
    }

    @Test
    public void testShowLogDetail(){
        assertNotNull(log.showLogDetail(testLog.getId()));
    }

}
