package blservice.userblservice;

import status.*;
import util.Kind_Of_Power;
import vo.*;
import util.ResultMessage;

/**
 * Created by thinkpad on 2017/10/23.
 */
public interface UserBLService {
    /**
     * @param user
     * @param power
     * @param i:表示对权限的操作是增加还是减少，i为1是增加，i为0是减小
     * @return
     */
    public ResultMessage modifyPower(UserVO user, Kind_Of_Power power, int i);

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserVO user);

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage delUser(String userid);

    /**
     * @param user
     * @return
     */
    public ResultMessage modifyUser(UserVO user);

    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */
    public Log_In_Out_Status login(String ID, String password);

    /**
     * 登出
     *
     * @param ID
     * @return
     */
    public Log_In_Out_Status logout(String ID);
}
