package dataimpl.generalaccountdataimpl;

import datahelper.HibernateHelper;
import dataservice.GeneralAccountDataService;
import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.GeneralAccountPO;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class GeneralAccountDataServiceFactory {

    private static GeneralAccountDataServiceImpl generalAccountDataService;

    public static synchronized GeneralAccountDataService getGeneralAccountDataService(){
        if(generalAccountDataService==null) {
            generalAccountDataService = new GeneralAccountDataServiceImpl(new HibernateHelper<AccountPO>(), new HibernateHelper<CustomerPO>(), new HibernateHelper<CommodityPO>(), new HibernateHelper<GeneralAccountPO>());
             }
             return generalAccountDataService;
         }
    }

