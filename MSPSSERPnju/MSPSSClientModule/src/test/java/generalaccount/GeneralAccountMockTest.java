package generalaccount;

import blimpl.generalaccountblimpl.GeneralAccount;
import blimpl.generalaccountblimpl.MockGeneralAccount;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;
import vo.GeneralAccountVO;

import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Created by thinkpad on 2017/11/14.
 */
public class GeneralAccountMockTest {
    ArrayList<GeneralAccountVO> list = new ArrayList<GeneralAccountVO>();
    GeneralAccountVO g = new GeneralAccountVO();
    AccountVO a = new AccountVO("苏果超市",1000,new Time(2017,11,11,11,11,11));
    private GeneralAccount ga;

    public GeneralAccountMockTest(){
        ga = new MockGeneralAccount();
        g.addAccount(a);
        list.add(g);
    }

    @Test
    public void testadd(){


        ResultMessage result = ga.newGeneralAccount(g);
        assertEquals(result,ResultMessage.SUCCESS);
    }

    @Test
    public void testcheck(){
        ArrayList<GeneralAccountVO> list = ga.checkGeneralAccount(new Time(2017,1,1,1,1,1),new Time(2017,11,11,11,11,11));

        assertFalse(list.isEmpty());
    }

    @Test
    public void testsort(){
        list = ga.ETLsort(list);
        assertFalse(list.isEmpty());
    }
}
