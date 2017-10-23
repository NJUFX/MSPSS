package dataimpl.systemdataimpl;

import dataservice.SystemDataService;
import po.*;
import status.*;

/**
 * Created by thinkpad on 2017/10/22.
 */
public class SystemDataServiceImpl implements SystemDataService{

    @Override
    public Log_Status login(String id, String password){
        //具体实现.........
        return Log_Status.SUCCESS;
    }
    @Override
    public Log_Status logout(){
        //具体实现.........
        return Log_Status.SUCCESS;
    }
    @Override
    public boolean initializeFinalAccount(FinalAccountPO account){
        //具体实现.........
        return true;
    }
    @Override
    public FinalAccountPO checkFinalAccount(String name){
        //具体实现.........
        return new FinalAccountPO();
    }
    @Override
    public User_Oper_Status adjustPower(PowerPO power, UserPO user){
        //具体实现.........
        return User_Oper_Status.SUCCESS;
    }
    @Override
    public User_Oper_Status addUser(UserPO newuser){
        //具体实现.........
        return User_Oper_Status.SUCCESS;
    }
    @Override
    public User_Oper_Status deleteUser(UserPO user){
        //具体实现.........
        return User_Oper_Status.SUCCESS;
    }


}
