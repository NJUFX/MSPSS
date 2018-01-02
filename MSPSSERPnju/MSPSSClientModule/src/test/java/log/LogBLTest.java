package log;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import blservice.logblservice.LogBLService;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.LogVO;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 8:18 2018/1/2/002
 */
public class LogBLTest {
    LogBLService logBLService = new BLFactoryImpl().getLogBLService();
    LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();

    @Test
    public void test1() {
        ResultMessage message = logBLInfo.add(new LogVO("121", "dawd", new Time(), ""));
        System.out.println(message);
        logBLInfo.add(new LogVO("韩新虎", new Time(), "批准了销售单"));

        assertEquals(null, message);
    }
}
