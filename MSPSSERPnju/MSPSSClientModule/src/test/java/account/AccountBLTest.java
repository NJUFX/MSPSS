package account;

import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import org.junit.Test;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;

/**
 * Description:
 * Created by Hanxinhu at 11:35 2017/12/31/031
 */
public class AccountBLTest {
    AccountBLService blService = new BLFactoryImpl().getAccountBLService();
    AccountBLInfo blInfo = new BLFactoryImpl().getAccountBLInfo();
    @Test
    public void test1(){
        AccountFilterFlagsVO filterFlagsVO = new AccountFilterFlagsVO("NJU", null, null);
        //AccountFilterFlagsVO filterFlagsVO = new AccountFilterFlagsVO("",null,null);
        ArrayList<AccountVO> accountVOS = blService.searchAccount(filterFlagsVO);
        assertNotNull(accountVOS);
    }
    @Test
    public void test2(){


        try {
            blService.addAccount(new AccountVO("NJU", 100000));
            AccountVO accountVO = blInfo.getAccountVO("NJU");
            assertNotNull(accountVO);
        } catch (Exception e) {
            blService.deleteAccount("NJU");
        }

    }

    @Test
    public void test3() {
        try {
            blService.addAccount(new AccountVO("NJU", 100000));
            AccountVO accountVO = blService.exactlySearchAccountByName("NJU");
            assertNotNull(accountVO);
        } catch (Exception e) {
            blService.deleteAccount("NJU");
        }

    }

    @Test
    public void test4() {
        try {
            blService.addAccount(new AccountVO("NJU", 100000));
            ArrayList<AccountVO> accountVO = blService.fuzzSearchAccountByName("NJ");
            assertNotNull(accountVO);
        } catch (Exception e) {
            blService.deleteAccount("NJU");
        }

    }


}
