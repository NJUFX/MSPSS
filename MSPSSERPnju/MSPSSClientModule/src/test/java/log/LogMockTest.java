package log;

import blimpl.logblimpl.Log;
import blimpl.logblimpl.MockLog;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.LogVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Harper on 17/11/21
 */

public class LogMockTest {

    LogVO testLog = new LogVO("jiangchen", new Time(), "1424");
    Log log = new MockLog();

    @Test
    public void testAddLog() {
        ResultMessage test1 = log.add(testLog);
        assertEquals(test1, ResultMessage.SUCCESS);
    }

    @Test
    public void testSearchLog() {
        ArrayList<LogVO> test2 = log.timeSearchLog(new Time(), new Time());
        assertNotNull(test2);
    }

    @Test
    public void testShowLogList() {
        ArrayList<LogVO> test3 = new ArrayList();
        test3.add(testLog);
        assertNotNull(test3);
    }

    @Test
    public void testShowLogDetail() {
        assertNotNull(log.operatorSearchLog(""));
    }

}
