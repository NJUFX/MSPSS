package blstubdriver.userstubdriver;

import blservice.userblservice.UserBLService;
import status.Log_In_Out_Status;
import util.Kind_Of_Power;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

public class UserBLService_Stub implements UserBLService {
    public static ArrayList<UserVO> UserList = new ArrayList<UserVO>();

    /**
     * 修改权限
     * @param user
     * @param po
     * @param i:表示对权限的操作是增加还是减少，i为1是增加，i为0是减小
     * @return
     */
    @Override
    public ResultMessage modifyPower(UserVO user, Kind_Of_Power po, int i) {
        String power = modPower(user.getPower(), po, i);
        user.setPower(power);
        return ResultMessage.SUCCESS;
    }

    private String modPower(String power, Kind_Of_Power po, int i) {
        if (po == Kind_Of_Power.CheckListLimit) {
            power = String.valueOf(i) + power.substring(i);
        }
        return power;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public ResultMessage addUser(UserVO user) {
        UserList.add(user);
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    @Override
    public ResultMessage delUser(String userid) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getIsValid() == true && UserList.get(i).getID().equals(userid)) {
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
    public ResultMessage modifyUser(UserVO user) {
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
