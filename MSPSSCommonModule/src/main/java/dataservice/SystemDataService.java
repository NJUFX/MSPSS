package dataservice;

import status.Log_Status;
import status.User_Oper_Status;
import po.*;
/**
 * Created by thinkpad on 2017/10/22.
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
