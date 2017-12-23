package blstubdriver.userstubdriver;

import blservice.userblservice.UserBLService;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

public class UserBLService_Stub implements UserBLService {
    public static ArrayList<UserVO> UserList = new ArrayList<UserVO>();

    /**
     * 根据用户类型查找用户
     * sale finance    同时返回经理
     *
     * @param kind
     * @return
     */
    @Override
    public ArrayList<UserVO> searchUserByKind(Kind_Of_Users kind) {
        return null;
    }

    /**
     * 根据用户的ID来查找
     *
     * @param ID
     * @return
     */
    @Override
    public UserVO searchUserByID(String ID) {
        return null;
    }

    /**
     * @param userVO
     * @return
     */
    @Override
    public ResultMessage addUser(UserVO userVO) {
        UserList.add(userVO);
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除用户
     *
     * @param userID 用户id
     * @return 删除用户的运行结果
     */
    @Override
    public ResultMessage deleteUser(String userID) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getIsValid() == true && UserList.get(i).getID().equals(userID)) {
                UserList.get(i).setIsValid(false);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.NOT_EXIST;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public ResultMessage updateUser(UserVO user) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getIsValid() == true && UserList.get(i).getID().equals(user.getID())) {
                UserList.remove(i);
                UserList.add(user);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.FAILED;
    }

    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */

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
