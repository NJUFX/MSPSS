package generalaccount;

import blimpl.generalaccountblimpl.GeneralAccount;
import blimpl.generalaccountblimpl.MockGeneralAccount;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;
import vo.GeneralAccountVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class GeneralAccountMockTest {
    ArrayList<GeneralAccountVO> list = new ArrayList<GeneralAccountVO>();
    GeneralAccountVO g = new GeneralAccountVO();
    AccountVO a = new AccountVO("苏果超市", 1000, new Time(2017, 11, 11, 11, 11, 11));
    private GeneralAccount ga;

    public GeneralAccountMockTest() {
        ga = new MockGeneralAccount();
        list.add(g);
    }

    @Test
    public void testadd() {


        ResultMessage result = ResultMessage.SUCCESS;
        assertEquals(result, ResultMessage.SUCCESS);
    }

    @Test
    public void testcheck() {
        ArrayList<GeneralAccountVO> list = new ArrayList<>();

        assertFalse(list.isEmpty());
    }

    @Test
    public void testsort() {
        list.get(1);
    }
}
