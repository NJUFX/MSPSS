package dataimpl.userdataimpl;

import datahelper.HibernateHelper;
import dataservice.UserDataService;
import po.UserPO;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class UserDataServiceFactory {
    private static  UserDataServiceImpl userDataService;

    public static synchronized UserDataService getUserDataService(){
        if(userDataService==null){
            userDataService = new UserDataServiceImpl(new HibernateHelper<UserPO>());
        }
        return userDataService;
    }
}
