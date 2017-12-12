package dataimpl.accountdataimpl;

import datahelper.HibernateHelper;
import dataservice.AccountDataService;
import po.AccountPO;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class AccountDataServiceFactory {
    private static AccountDataServiceImpl accountDataService;

    /**
     * 得到一个AccountDataService实例
     *
     * @return AccountDataService实例
     */
    public static synchronized AccountDataService getAccountDataService() {
        if (accountDataService == null) {
            accountDataService = new AccountDataServiceImpl(new HibernateHelper<AccountPO>(AccountPO.class));
        }
        return accountDataService;
    }
}
