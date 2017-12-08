package blimpl.accountblimpl;

import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;

/**
 * Description:
 * Created by Hanxinhu at 16:30 2017/12/8/008
 */
public class AccountFactory {
    private static Account account = new Account();
    private static AccountBLBLServiceImpl impl;

    public static synchronized AccountBLService getAccountBLService(){
        if (impl==null){
            impl = new AccountBLBLServiceImpl(account);
        }
        return impl;
    }
    public static synchronized AccountBLInfo getAccountInfo(){
        if (impl==null){
            impl = new AccountBLBLServiceImpl(account);
        }
        return impl;
    }
}
