package dataservice;
import po.*;
import status.*;
/*
 * Created by thinkpad on 2017/10/24.
 */
public interface SystemDataService {
    public Log_Status login(String id, String password);

    public Log_Status logout();

    public boolean initializeFinalAccount(FinalAccountPO account);


    public FinalAccountPO checkFinalAccount(String name);


    public User_Oper_Status adjustPower(PowerPO power, UserPO user);


    public User_Oper_Status addUser(UserPO newuser);


    public User_Oper_Status deleteUser(UserPO user);
}
