package finance;
import blimpl.financeblimpl.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;
import util.ResultMessage;
import vo.*;
/**
 * Created by thinkpad on 2017/11/6.
 */
public class FinanceMockTest {
       private Account account;
        AccountVO account1 = new AccountVO("dd",12,"ww","2017-11-06");
        AccountFilterFlagsVO flags = new AccountFilterFlagsVO("ee","ww",new String[]{"2017-08-09","2017-09-12"});
        public FinanceMockTest(){account = new MockAccount();}

        @Test
    public void testaddAccount(){
            ResultMessage result = account.addAccount(account1);
            assertEquals(ResultMessage.SUCCESS, result);
        }

        @Test
    public void testdeleteAccount(){
            ResultMessage result = account.deleteAccount(account1.name);
            assertEquals(ResultMessage.SUCCESS, result);
        }

    @Test
    public void testmodifyAccount(){
        ResultMessage result = account.modifyAccount(account1.name,account1);
        assertEquals(ResultMessage.SUCCESS, result);

    }

    @Test
    public void testcheckAccount(){
       ArrayList<AccountVO> list = account.checkAccount(flags);
       assertTrue(!list.isEmpty());
    }
}
