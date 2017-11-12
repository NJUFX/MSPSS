package blimpl.userblimpl;

import status.Log_In_Out_Status;
import vo.UserVO;

import java.util.ArrayList;

public class UserLog {
    public static ArrayList<UserVO> UserList = UserManage.UserList;

    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */
    public Log_In_Out_Status login(String ID, String password) {
        return Log_In_Out_Status.Login_Sucess;
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
