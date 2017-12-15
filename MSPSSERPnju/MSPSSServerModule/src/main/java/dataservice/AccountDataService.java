package dataservice;

import po.AccountPO;
import util.CriteriaClause;
import util.ResultMessage;


import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public interface AccountDataService {
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
     * @param oldName,newName
     * @return 修改成功与否
     */
    public ResultMessage modifyAccount(String oldName,String newName);
    /**
     * 查找账户
     *
     * @param name
     * @return
     */
    public AccountPO checkAccount(String name);
    /**
     * 账户收款
     *
     * @param name,money
     * @return void
     */
    public void income(String name,double money);
    /**
     * 账户付款
     *
     * @param name,money
     * @return void
     */
    public void pay(String name,double money);

    public ArrayList<AccountPO> rangeSearchAccount(String field, Object min, Object max);

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
    public ArrayList<AccountPO>  multiSearchAccount(ArrayList<CriteriaClause> criteriaClauses);




}
