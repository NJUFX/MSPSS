package network.accountnetwork;


import dataimpl.accountdataimpl.AccountDataServiceFactory;
import dataservice.AccountDataService;
import network.accountnetworkservice.AccountServerNetworkService;
import po.AccountPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/12/14.
 */


public class AccountServerNetworkImpl extends UnicastRemoteObject implements AccountServerNetworkService {

    private AccountDataService accountDataService;

    public AccountServerNetworkImpl()throws RemoteException{
        accountDataService = AccountDataServiceFactory.getAccountDataService();
    }

    /**
     * 添加账户
     * @param account
     * @return
     */
    public ResultMessage addAccount(AccountPO account) throws RemoteException{

        return accountDataService.addAccount(account);
    }
    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    public ResultMessage deleteAccount(String name) throws RemoteException{
        return accountDataService.deleteAccount(name);
    }
    /**
     * 修改账户
     *
     * @param po
     * @return 修改成功与否
     */
    public ResultMessage updateAccount(AccountPO po) throws RemoteException{
        accountDataService.deleteAccount(po.getName());
        return accountDataService.addAccount(po);
    }

    /**
     * 在范围内查找账户
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<AccountPO> rangeSearchAccount(String field, Object min, Object max) throws RemoteException{
        return accountDataService.rangeSearchAccount(field, min, max);
    }

    /**
     * 完全匹配查找账号
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fullSearchAccount(String field,Object value) throws RemoteException{
        return accountDataService.fullSearchAccount(field, value);
    }

    /**
     * 模糊查找账号
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fuzzSearchAccount(String field,Object value) throws RemoteException{
        return accountDataService.fuzzSearchAccount(field,value);
    }

    /**
     * 根据账户名精确查找账户
     * @param name
     * @return
     */
    public AccountPO searchAccountByName(String name) throws RemoteException{
        return accountDataService.searchAccountByName(name);
    }

    /**
     * 多重条件查找
     * @param criteriaClauses
     * @return
     */
    public ArrayList<AccountPO>  multiSearchAccount(ArrayList<CriteriaClause> criteriaClauses) throws RemoteException{
        return accountDataService.multiSearchAccount(criteriaClauses);
    }


}
