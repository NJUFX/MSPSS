package network.accountnetworkservice;

import po.AccountPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface AccountServerNetworkService  {
    /**
     * 添加账户
     * @param account
     * @return
     */
    public ResultMessage addAccount(AccountPO account) throws RemoteException;
    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    public ResultMessage deleteAccount(String name) throws RemoteException;
    /**
     * 修改账户
     *
     * @param po
     * @return 修改成功与否
     */
    public ResultMessage updateAccount(AccountPO po) throws RemoteException;

    /**
     * 在范围内查找账户
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<AccountPO> rangeSearchAccount(String field, Object min, Object max) throws RemoteException;

    /**
     * 完全匹配查找账号
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fullSearchAccount(String field,Object value) throws RemoteException;

    /**
     * 模糊查找账号
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fuzzSearchAccount(String field,Object value) throws RemoteException;

    /**
     * 根据账户名精确查找账户
     * @param name
     * @return
     */
    public AccountPO searchAccountByName(String name) throws RemoteException;

    /**
     * 多重条件查找
     * @param criteriaClauses
     * @return
             */
    public ArrayList<AccountPO>  multiSearchAccount(ArrayList<CriteriaClause> criteriaClauses) throws RemoteException;


}
