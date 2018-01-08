package blservice.accountblservice;

import blimpl.accountblimpl.Account;
import exception.dataexception.NegativeException;
import util.ResultMessage;
import util.Time;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public interface AccountBLService {
    /**
     * 添加账户
     *
     * @param account
     * @return 添加成功与否
     */
    public ResultMessage addAccount(AccountVO account) throws NegativeException;
    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    public ResultMessage deleteAccount(String name);
    /**
     * 修改账户
     *
     * @param oldname,newname
     * @return 修改成功与否
     */
    public ResultMessage modifyAccount(String oldname,String newname);
    /**
     * 查找账户
     *
     * @param name
     * @return 符合条件的List
     */
    public AccountVO exactlySearchAccountByName(String name);

    /**
     * 根据账户名模糊查找
     * @param name
     * @return
     */
    public ArrayList<AccountVO> fuzzSearchAccountByName(String name);

    /**
     * 根据账户创建时间进行范围查找
     * @param min
     * @param max
     * @return
     */
    public ArrayList<AccountVO> rangeSearchAccountByTime(Time min, Time max);


    /**
     * 根据搜索条件搜索
     * @param vo
     * @return
     */
    public ArrayList<AccountVO> searchAccount(AccountFilterFlagsVO vo);
    /**
     * 名称按字典序排序
     *
     * @param accountList
     * @return 排序后的账户
     */
    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList);

    /**
     * 根据账户名称按字典序倒着排 从Z到A
     * @param accountList
     * @return
     */
    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList);
    /**
     * 根据账户余额升序排列
     *
     * @param accountList
     * @return 排序后的账户
     */
    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList);

    /***
     * 根据余额降序排列
     * @param accountList
     * @return
     */
    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList);

}
