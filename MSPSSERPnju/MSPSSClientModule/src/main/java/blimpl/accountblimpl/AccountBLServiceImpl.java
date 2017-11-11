package blimpl.accountblimpl;

import blservice.accountblservice.AccountBLService;
import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class AccountBLServiceImpl implements AccountBLService{
    Account MyAccount = new Account();

    @Override
    public ResultMessage addAccount(AccountVO account){
        return MyAccount.addAccount(account);
    }
    @Override
    public ResultMessage deleteAccount(String name){
        return MyAccount.deleteAccount(name);
    }
    @Override
    public ResultMessage modifyAccount(String oldname,String newname){
        return MyAccount.modifyAccount(oldname,newname);
    }
    @Override
    public ArrayList<AccountVO> checkAccount(String name){
        return MyAccount.checkAccount(name);
    }
    @Override
    public void income(String name,int money){
        MyAccount.income(name,money);
    }
    @Override
    public void pay(String name,int money){
        MyAccount.pay(name,money);
    }
    @Override
    public ArrayList<AccountVO> compareByName(ArrayList<AccountVO> accountlist){
        return MyAccount.compareByName(accountlist);
    }
    @Override
    public ArrayList<AccountVO> compareByMoney(ArrayList<AccountVO> accountlist){
        return MyAccount.compareByMoney(accountlist);
    }


}
