package network;

import po.AccountPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 10:26 2017/11/30/030
 */
public interface AccountClientNetworkService extends Remote {
    /**
     * 添加账户
     * @param account
     * @return
     */
    public ResultMessage addAccount(AccountPO account);
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
     * @param po
     * @return 修改成功与否
     */
    public ResultMessage updateAccount(AccountPO po);

    /**
     * 在范围内查找账户
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<AccountPO> rangeSearchAccount(String field,Object min,Object max);

    /**
     * 完全匹配查找账号
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fullSearchAccount(String field,Object value);

    /**
     * 模糊查找账号
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fuzzSearchAccount(String field,Object value);

    /**
     * 根据账户名精确查找账户
     * @param name
     * @return
     */
    public AccountPO searchAccountByName(String name);

    /**
     * 多重条件查找
     * @param criteriaClauses
     * @return
     */
    public ArrayList<AccountPO>  multiSearchLog(ArrayList<CriteriaClause> criteriaClauses);



}
