package blimpl.accountblimpl;

import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import util.ResultMessage;
import util.Time;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class AccountBLBLServiceImpl implements AccountBLService,AccountBLInfo {
    Account account;
    public AccountBLBLServiceImpl(){
     account = new Account();
    }

    public AccountBLBLServiceImpl(Account account){
        this.account = account;
    }

    @Override
    public ArrayList<AccountVO> fuzzSearchAccountByName(String name) {
        return account.fuzzSearchAccountByName(name);
    }

    @Override
    public ArrayList<AccountVO> rangeSearchAccountByTime(Time min, Time max) {
        return account.rangeSearchAccountByTime(min,max);
    }

    @Override
    public ArrayList<AccountVO> searchAccount(AccountFilterFlagsVO vo) {
        return account.searchAccount(vo);
    }

    @Override
    public ResultMessage addAccount(AccountVO account){
        return this.account.addAccount(account);
    }
    @Override
    public ResultMessage deleteAccount(String name){
        return account.deleteAccount(name);
    }
    @Override
    public ResultMessage modifyAccount(String oldName,String newName){
        return account.modifyAccount(oldName,newName);
    }
    @Override
    public AccountVO exactlySearchAccountByName(String name){
        return account.searchAccountByName(name);
    }
    @Override
    public void income(String name, double money) {
        account.income(name,money);
    }

    @Override
    public AccountVO getAccountVO(String name) {
        return account.searchAccountByName(name);
    }

    @Override
    public void pay(String name, double money) {
        account.pay(name,money);
    }


    @Override
    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList) {
        return account.AccountNameAscendingSort(accountList);
    }

    @Override
    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList) {
        return account.AccountNameDescendingSort(accountList);
    }
    @Override
    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList){
        return account.AccountMoneyAscendingSort(accountList);
    }

    @Override
    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList) {
        return account.AccountMoneyDescendingSort(accountList);
    }
}
