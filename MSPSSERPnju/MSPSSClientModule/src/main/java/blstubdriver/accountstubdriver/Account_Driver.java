package blstubdriver.accountstubdriver;

/**
 * Created by thinkpad on 2017/11/11.
 */

import blservice.accountblservice.AccountBLService;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;

import java.util.ArrayList;

public class Account_Driver {
    AccountVO account = new AccountVO("苏果超市", 1000, new Time(2017, 11, 11, 11, 11, 11));

    private AccountBLService service = new AccountStub();

    @Test
    public void drive() {
        ResultMessage result = ResultMessage.FAILED;
        //1
        try {
            result = service.addAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == ResultMessage.SUCCESS) System.out.println("Success add account");
        else System.out.println("fail");

        //2
        result = service.deleteAccount(account.getName());
        if (result == ResultMessage.SUCCESS) System.out.println("Success delete account");
        else System.out.println("fail");

        //3
        result = service.modifyAccount(account.getName(), "苏果江苏总店");
        if (result == ResultMessage.SUCCESS) System.out.println("Success modify account");
        else System.out.println("fail");

        //4
        AccountVO list;
        list = service.exactlySearchAccountByName("江苏");
        if (list != null) System.out.println("no account match your flags");
        else System.out.println("fail");

        //5
        ArrayList<AccountVO> vos = service.AccountMoneyAscendingSort(new ArrayList<>());
        if (vos.isEmpty()) System.out.println("no account wait for comparing");
        else System.out.println("fail");

        //6

        if (list != null) System.out.println("no account wait for comparing");
        else System.out.println("fail");
    }

}
