package blimpl.accountblimpl;

import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class AccountBLBLServiceImpl implements AccountBLService,AccountBLInfo {
    Account MyAccount;
    public AccountBLBLServiceImpl(){
     MyAccount = new Account();
    }

    public AccountBLBLServiceImpl(Account account){
        MyAccount = account;
    }

    @Override
    public ResultMessage addAccount(AccountVO account){
        return MyAccount.addAccount(account);
    }
    @Override
    public ResultMessage deleteAccount(String name){
        return MyAccount.deleteAccount(name);
    }
    @Override
    public ResultMessage modifyAccount(String oldName,String newName){
        return MyAccount.modifyAccount(oldName,newName);
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
    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList) {
        return MyAccount.AccountNameAscendingSort(accountList);
    }

    @Override
    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList) {
        return MyAccount.AccountNameDescendingSort(accountList);
    }
    @Override
    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList){
        return MyAccount.AccountMoneyAscendingSort(accountList);
    }

    @Override
    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList) {
        return MyAccount.AccountMoneyDescendingSort(accountList);
    }
}
