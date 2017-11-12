package blimpl.userblimpl;

import status.Log_In_Out_Status;
import vo.UserVO;

public class MockUserLog extends UserLog {
    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */
    @Override
    public Log_In_Out_Status login(String ID, String password) {
        for (int i = 0; i < UserList.size(); i++) {
            UserVO user = UserList.get(i);
            if (user.getID().equals(ID)) {
                if (user.getIsValid() == false) {//该用户身份无效
                    return Log_In_Out_Status.Login_IdNotExist;
                } else {
                    if (user.getIsLogin() == true) {//该ID已登录
                        return Log_In_Out_Status.Login_islogin;
                    }
                    if (!user.getPassword().equals(password)) {//输入密码不正确
                        return Log_In_Out_Status.Login_PasswordWrong;
                    }
                    return Log_In_Out_Status.Login_Sucess;//登陆成功
                }
            }
        }
        return Log_In_Out_Status.Login_IdNotExist;
    }

    /**
     * 登出
     *
     * @param ID
     * @return
     */
    @Override
    public Log_In_Out_Status logout(String ID) {
        for (int i = 0; i < UserList.size(); i++) {
            UserVO user = UserList.get(i);
            if (user.getID().equals(ID) && user.getIsValid() == true) {
                if (user.getIsLogin()) {
                    user.setIsLogin(false);
                    return Log_In_Out_Status.Logout_Sucess;
                } else {
                    return Log_In_Out_Status.Logout_NotLogin;
                }
            }
        }
        return Log_In_Out_Status.Login_IdNotExist;
    }
}
