package network;

import po.UserPO;
import util.ResultMessage;

import java.rmi.Remote;

/**
 * Description:
 * Created by Hanxinhu at 10:27 2017/11/30/030
 */
public interface UserClientNetworkService extends Remote {
    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage modifyPower(UserPO user, String power);

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserPO user);

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
    public ResultMessage modifyUser(UserPO user);

    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID);

}
