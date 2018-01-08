package blimpl.accountblimpl;

import util.ResultMessage;
import util.Time;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 23:45 2017/11/27/007
 */
public class MockAccount extends Account {
    @Override
    public ResultMessage addAccount(AccountVO accountVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteAccount(String name) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyAccount(String oldName, String newName) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public AccountVO searchAccountByName(String name) {
        return null;
    }

    @Override
    public ArrayList<AccountVO> searchAccount(AccountFilterFlagsVO vo) {
        return new ArrayList<>();
    }

    @Override
    public void income(String name, double money) {
        return;
    }

    @Override
    public void pay(String name, double money) {
        return;
    }

    @Override
    public ArrayList<AccountVO> fuzzSearchAccountByName(String name) {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<AccountVO> rangeSearchAccountByTime(Time min, Time max) {
        return new ArrayList<>();

    }

    @Override
    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList) {
        return new ArrayList<>();

    }

    @Override
    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList) {
        return new ArrayList<>();

    }

    @Override
    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList) {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList) {
        return new ArrayList<>();
    }
}
