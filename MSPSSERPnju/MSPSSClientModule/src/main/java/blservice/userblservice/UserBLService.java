package blservice.userblservice;

import status.*;
import vo.*;
import util.ResultMessage;

/**
 * Created by thinkpad on 2017/10/23.
 */
public interface UserBLService {
    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage givePower(PowerVO power);

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
