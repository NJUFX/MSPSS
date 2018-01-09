package network;

import network.accountnetworkservice.AccountServerNetworkService;
import po.AccountPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public class AccountClientNetworkImpl implements AccountClientNetworkService {

    private AccountServerNetworkService accountServerNetworkService;

    public AccountClientNetworkImpl() {
        try {
            accountServerNetworkService = (AccountServerNetworkService) Naming.lookup("rmi://106.14.188.84:8888/AccountServerNetworkService");

            System.out.println("arrive");
        } catch (NotBoundException e) {
            System.err.println("Client.network.AccountServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加账户
     *
     * @param account
     * @return
     */
    public ResultMessage addAccount(AccountPO account) {
        try {
           return accountServerNetworkService.addAccount(account);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    public ResultMessage deleteAccount(String name) {
        try {
          return   accountServerNetworkService.deleteAccount(name);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改账户
     *
     * @param po
     * @return 修改成功与否
     */
    public ResultMessage updateAccount(AccountPO po) {
        try {
           return accountServerNetworkService.updateAccount(po);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在范围内查找账户
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<AccountPO> rangeSearchAccount(String field, Object min, Object max) {
        try {
            return accountServerNetworkService.rangeSearchAccount(field, min, max);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 完全匹配查找账号
     *
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fullSearchAccount(String field, Object value) {
        try {
           return  accountServerNetworkService.fullSearchAccount(field, value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模糊查找账号
     *
     * @param field
     * @param value
     * @return
     */
    public ArrayList<AccountPO> fuzzSearchAccount(String field, Object value) {
        try {
            return accountServerNetworkService.fuzzSearchAccount(field, value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据账户名精确查找账户
     *
     * @param name
     * @return
     */
    public AccountPO searchAccountByName(String name) {
        try {
           return  accountServerNetworkService.searchAccountByName(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 多重条件查找
     *
     * @param criteriaClauses
     * @return
     */
    public ArrayList<AccountPO> multiSearchAccount(ArrayList<CriteriaClause> criteriaClauses) {
        try {
           return accountServerNetworkService.multiSearchAccount(criteriaClauses);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        AccountClientNetworkImpl accountClientNetwork = new AccountClientNetworkImpl();
        System.out.println(accountClientNetwork==null);
       ResultMessage message =  accountClientNetwork.addAccount(new AccountPO("hxh",999,new util.Time().toString()));
        System.out.println(message);
    }

}
