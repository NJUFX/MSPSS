package account;

import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import org.junit.Test;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
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
    AccountFilterFlagsVO filterFlagsVO = new AccountFilterFlagsVO("121",null,null);
        //AccountFilterFlagsVO filterFlagsVO = new AccountFilterFlagsVO("",null,null);

        ArrayList<AccountVO> accountVOS = blService.searchAccount(filterFlagsVO);

        assertEquals(1,accountVOS.size());
    }
    @Test
    public void test2(){
       AccountVO accountVO = blInfo.getAccountVO("121");
        System.out.println(accountVO.getName()+""+accountVO.getMoney()+""+accountVO.getCreateTime().toString());
       assertNotNull(accountVO);
    }



}
