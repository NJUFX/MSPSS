package account;

import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLService;
import org.junit.Test;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 11:35 2017/12/31/031
 */
public class AccountBLTest {
    AccountBLService service = new BLFactoryImpl().getAccountBLService();

    @Test
    public void test1() {
        AccountFilterFlagsVO accoutFilterFlagVO = new AccountFilterFlagsVO("12", null, null);
        ArrayList<AccountVO> list = service.searchAccount(accoutFilterFlagVO);
        assertEquals(1, list.size());
    }
}
