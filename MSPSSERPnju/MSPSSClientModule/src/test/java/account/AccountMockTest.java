//package account;
//
//import blimpl.accountblimpl.Account;
//import blimpl.accountblimpl.MockAccount;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import util.ResultMessage;
//import util.Time;
//import vo.AccountVO;
//
//import java.util.ArrayList;
//
///**
// * Created by thinkpad on 2017/11/14.
// */
//public class AccountMockTest {
//    AccountVO account1 = new AccountVO("苏果超市",1000,new Time(2017,11,11,11,11,11));
//    private Account account;
//
//    public AccountMockTest(){
//        account = new MockAccount();
//    }
//
//    @Test
//    public void testadd(){
//        ResultMessage result = account.addAccount(account1);
//
//        assertEquals(result,ResultMessage.SUCCESS);
//    }
//
//    @Test
//    public void testdelete(){
//        ResultMessage result = account.deleteAccount(account1.getname());
//
//        assertEquals(result,ResultMessage.SUCCESS);
//
//    }
//
//    @Test
//    public void testmodify(){
//        ResultMessage result = account.modifyAccount(account1.getname(),"乐天玛特");
//
//        assertEquals(result,ResultMessage.SUCCESS);
//    }
//
//    @Test
//    public void testcheck(){
//        ArrayList<AccountVO> list = account.checkAccount("乐天玛特");
//        assertEquals(list.get(0).getname(),"乐天玛特");
//    }
//
//
//}
