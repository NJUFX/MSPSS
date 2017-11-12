package datastubdriver.systemstubdriver;

/**
 * Created by thinkpad on 2017/10/21.
 */
import status.*;
import po.*;
public class SystemDataService_Stub implements SystemDataService {
    @Override
    public Log_Status login(String id,String password){
        return Log_Status.SUCCESS;
    }
    @Override
    public Log_Status logout(){
        return Log_Status.SUCCESS;
    }
    @Override
    public boolean initializeFinalAccount(FinalAccountPO account){
        return true;
    }
    @Override
    public FinalAccountPO checkFinalAccount(String name){
        return new FinalAccountPO();
    }
    @Override
    public User_Oper_Status adjustPower(PowerPO power,UserPO user){
        return User_Oper_Status.SUCCESS;
    }
    @Override
    public User_Oper_Status addUser(UserPO newuser){
        return User_Oper_Status.SUCCESS;
    }
    @Override
    public User_Oper_Status deleteUser(UserPO user){
        return User_Oper_Status.SUCCESS;
    }



}
