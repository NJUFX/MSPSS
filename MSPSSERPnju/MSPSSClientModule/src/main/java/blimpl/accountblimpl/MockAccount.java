package blimpl.accountblimpl;

import util.ResultMessage;
import vo.AccountVO;
import util.Time;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class MockAccount extends Account{
    Account MyAccount = new Account();

    @Override
    public ResultMessage addAccount(AccountVO account){
        if(account.getname().equals("苏果超市"))
        return ResultMessage.SUCCESS;
        else
        return ResultMessage.EXIST;
    }
    @Override
    public ResultMessage deleteAccount(String name){
        if(name.equals("苏果超市"))
            return ResultMessage.SUCCESS;
        else
            return ResultMessage.NOT_EXIST;
    }
    @Override
    public ResultMessage modifyAccount(String oldname,String newname){
        if(oldname.equals("苏果超市"))
            return ResultMessage.SUCCESS;
        else
            return ResultMessage.NOT_EXIST;
    }
    @Override
    public ArrayList<AccountVO> checkAccount(String name){
        AccountVO account1 = new AccountVO("苏果超市",1000,new Time(2017,11,11,11,11,11));
        ArrayList<AccountVO> account = new ArrayList<AccountVO>();
        account.add(account1);
        return account;
    }
    @Override
    public void income(String name,int money){
       //MyAccount.income(name,money);
    }
    @Override
    public void pay(String name,int money){
        //MyAccount.pay(name,money);
    }
    @Override
    public ArrayList<AccountVO> compareByName(ArrayList<AccountVO> accountlist){
        AccountVO account1 = new AccountVO("乐天玛特",1000,new Time(2017,11,11,11,11,11));
        ArrayList<AccountVO> account = new ArrayList<AccountVO>();
        account.add(account1);
        return account;
    }
    @Override
    public ArrayList<AccountVO> compareByMoney(ArrayList<AccountVO> accountlist){
        AccountVO account1 = new AccountVO("苏果超市",1000,new Time(2017,11,11,11,11,11));
        ArrayList<AccountVO> account = new ArrayList<AccountVO>();
        account.add(account1);
        return account;
    }
}
