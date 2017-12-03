package network;

import po.AccountPO;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 10:26 2017/11/30/030
 */
public interface AccountClientNetworkService {
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
    public ArrayList<AccountPO> checkAccount(String name);
    /**
     * 账户收款
     *
     * @param name,money
     * @return void
     */
    public void income(String name,int money);
    /**
     * 账户付款
     *
     * @param name,money
     * @return void
     */
    public void pay(String name,int money);

}