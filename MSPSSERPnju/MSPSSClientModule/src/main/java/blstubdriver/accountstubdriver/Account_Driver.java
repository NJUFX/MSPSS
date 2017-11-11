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
    AccountVO account = new AccountVO("苏果超市",1000,new Time(2017,11,11,11,11,11));

    private AccountBLService service = new Account_Stub();
    @Test
    public void drive(){
        ResultMessage result;
        //1
        result = service.addAccount(account);
        if(result==ResultMessage.SUCCESS) System.out.println("Success add account");
        else System.out.println("fail");

        //2
        result = service.deleteAccount(account.getname());
        if(result==ResultMessage.SUCCESS) System.out.println("Success delete account");
        else System.out.println("fail");

        //3
        result = service.modifyAccount(account.getname(),"苏果江苏总店");
        if(result==ResultMessage.SUCCESS) System.out.println("Success modify account");
        else System.out.println("fail");

        //4
        ArrayList<AccountVO> list = new ArrayList<AccountVO>();
        list = service.checkAccount("江苏");
        if(list.isEmpty()) System.out.println("no account match your flags");
        else System.out.println("fail");

        //5
        list = service.compareByMoney(list);
        if(list.isEmpty()) System.out.println("no account wait for comparing");
        else System.out.println("fail");

        //6
        list = service.compareByName(list);
        if(list.isEmpty()) System.out.println("no account wait for comparing");
        else System.out.println("fail");
    }

}
