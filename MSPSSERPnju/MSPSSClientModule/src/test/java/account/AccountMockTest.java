package account;

import blimpl.accountblimpl.Account;
import blimpl.accountblimpl.MockAccount;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;

import static org.junit.Assert.assertEquals;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class AccountMockTest {
    AccountVO account1 = new AccountVO("苏果超市", 1000, new Time(2017, 11, 11, 11, 11, 11));
    private Account account;

    public AccountMockTest() {
        account = new MockAccount();
    }

    @Test
    public void testadd() {
        ResultMessage result = account.addAccount(account1);

        assertEquals(result, ResultMessage.SUCCESS);
    }

    @Test
    public void testdelete() {
        ResultMessage result = account.deleteAccount(account1.getName());

        assertEquals(result, ResultMessage.SUCCESS);

    }

    @Test
    public void testmodify() {
        ResultMessage result = account.modifyAccount(account1.getName(), "乐天玛特");

        assertEquals(result, ResultMessage.SUCCESS);
    }

    @Test
    public void testcheck() {
        AccountVO list = account.searchAccountByName("乐天玛特");
        assertEquals(list.getName(), "乐天玛特");
    }


}
