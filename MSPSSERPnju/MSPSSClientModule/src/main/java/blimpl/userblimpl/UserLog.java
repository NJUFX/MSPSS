package blimpl.userblimpl;

import network.UserClientNetworkService;
import po.UserPO;
import status.Log_In_Out_Status;
import vo.UserVO;

import java.util.ArrayList;

public class UserLog {
    public static ArrayList<UserVO> UserList = UserManage.UserList;
    protected UserClientNetworkService userClientNetwork;

    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */
    public Log_In_Out_Status login(String ID, String password) {
        UserPO userPO =  userClientNetwork.searchUserByID(ID);
        if (userPO==null)
            return Log_In_Out_Status.Login_IdNotExist;
        if (userPO.getPassword().equals(password))
            return Log_In_Out_Status.Login_Sucess;
        else
            return Log_In_Out_Status.Login_PasswordWrong;
    }

    /**
     * 登出
     *
     * @param ID
     * @return
     */
    public Log_In_Out_Status logout(String ID) {

        return Log_In_Out_Status.Logout_Sucess;
    }

}
