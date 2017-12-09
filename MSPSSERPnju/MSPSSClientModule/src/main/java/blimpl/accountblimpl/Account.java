package blimpl.accountblimpl;

import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class Account {


    public ResultMessage addAccount(AccountVO accountVO){
        return ResultMessage.SUCCESS;
    }

    public ResultMessage deleteAccount(String name){
        return ResultMessage.SUCCESS;
    }

    public ResultMessage modifyAccount(String oldName,String newName){
        return ResultMessage.SUCCESS;
    }

    public ArrayList<AccountVO> checkAccount(String name){
        ArrayList<AccountVO> list = new ArrayList<AccountVO>();

        return list;
    }

    public void income(String name,double money){

    }

    public void pay(String name,double money){

    }


    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList){
        accountList.sort(new AccountMoneyAscendingComparator());
        return accountList;
    }


    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList) {
        accountList.sort(new AccountNameAscendingComparator());
        return accountList;
    }


    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList) {
        accountList.sort(new AccountNameDescendingComparator());
        return accountList;
    }


    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList) {
        accountList.sort(new AccountNameDescendingComparator());
        return accountList;
    }
}
