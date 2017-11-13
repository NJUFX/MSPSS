package datastubdriver.accountdatastubdriver;

import blservice.accountblservice.AccountBLService;
import blstubdriver.accountstubdriver.Account_Stub;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public class AccountDataService_Driver {
    AccountVO account = new AccountVO("苏果超市", 1000, new Time(2017, 11, 11, 11, 11, 11));

    private AccountBLService service = new Account_Stub();

    @Test
    public void drive() {
        ResultMessage result;
        //1
        result = service.addAccount(account);
        if (result == ResultMessage.SUCCESS) System.out.println("Success add account");
        else System.out.println("fail");

        //2
        result = service.deleteAccount(account.getname());
        if (result == ResultMessage.SUCCESS) System.out.println("Success delete account");
        else System.out.println("fail");

        //3
        result = service.modifyAccount(account.getname(), "苏果江苏总店");
        if (result == ResultMessage.SUCCESS) System.out.println("Success modify account");
        else System.out.println("fail");

        //4
        ArrayList<AccountVO> list = new ArrayList<AccountVO>();
        list = service.checkAccount("江苏");
        if (list.isEmpty()) System.out.println("no account match your flags");
        else System.out.println("fail");

    }
}