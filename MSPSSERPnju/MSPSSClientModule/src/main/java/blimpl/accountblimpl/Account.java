package blimpl.accountblimpl;

import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class Account {


    public ResultMessage addAccount(AccountVO account){
        return ResultMessage.SUCCESS;
    }

    public ResultMessage deleteAccount(String name){
        return ResultMessage.SUCCESS;
    }

    public ResultMessage modifyAccount(String oldname,String newname){
        return ResultMessage.SUCCESS;
    }

    public ArrayList<AccountVO> checkAccount(String name){
        ArrayList<AccountVO> list = new ArrayList<AccountVO>();

        return list;
    }

    public void income(String name,int money){

    }

    public void pay(String name,int money){

    }

    public ArrayList<AccountVO> compareByName(ArrayList<AccountVO> accountlist){
        return accountlist;
    }

    public ArrayList<AccountVO> compareByMoney(ArrayList<AccountVO> accountlist){
        return accountlist;
    }
}
