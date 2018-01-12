package blstubdriver.accountstubdriver;

import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import util.ResultMessage;
import util.Time;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:39 2018/1/7/007
 */
public class AccountStub implements AccountBLService, AccountBLInfo {
    public static final AccountVO accountVO = new AccountVO("NJU", 1000, new Time());

    /**
     * 账户收款
     *
     * @param name
     * @param money
     * @return void
     */
    @Override
    public void income(String name, double money) {
        return;
    }

    /**
     * 账户付款
     *
     * @param name
     * @param money
     * @return void
     */
    @Override
    public void pay(String name, double money) {
        return;
    }

    @Override
    public AccountVO getAccountVO(String name) {

        return accountVO;
    }

    /**
     * 添加账户
     *
     * @param account
     * @return 添加成功与否
     */
    @Override
    public ResultMessage addAccount(AccountVO account) {
        return null;
    }

    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    @Override
    public ResultMessage deleteAccount(String name) {
        return null;
    }

    /**
     * 修改账户
     *
     * @param oldname
     * @param newname
     * @return 修改成功与否
     */
    @Override
    public ResultMessage modifyAccount(String oldname, String newname) {
        return null;
    }

    /**
     * 查找账户
     *
     * @param name
     * @return 符合条件的List
     */
    @Override
    public AccountVO exactlySearchAccountByName(String name) {
        return null;
    }

    /**
     * 根据账户名模糊查找
     *
     * @param name
     * @return
     */
    @Override
    public ArrayList<AccountVO> fuzzSearchAccountByName(String name) {
        return null;
    }

    /**
     * 根据账户创建时间进行范围查找
     *
     * @param min
     * @param max
     * @return
     */
    @Override
    public ArrayList<AccountVO> rangeSearchAccountByTime(Time min, Time max) {
        return null;
    }

    /**
     * 根据搜索条件搜索
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<AccountVO> searchAccount(AccountFilterFlagsVO vo) {
        return null;
    }

    /**
     * 名称按字典序排序
     *
     * @param accountList
     * @return 排序后的账户
     */
    @Override
    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList) {
        return null;
    }

    /**
     * 根据账户名称按字典序倒着排 从Z到A
     *
     * @param accountList
     * @return
     */
    @Override
    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList) {
        return null;
    }

    /**
     * 根据账户余额升序排列
     *
     * @param accountList
     * @return 排序后的账户
     */
    @Override
    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList) {
        return null;
    }

    /***
     * 根据余额降序排列
     * @param accountList
     * @return
     */
    @Override
    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList) {
        return null;
    }
}
