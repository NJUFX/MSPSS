package network.usernetworkservice;

import po.UserPO;
import util.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface UserServerNetworkService {
    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage modifyPower(UserPO user, String power) throws RemoteException;

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserPO user) throws RemoteException;

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage delUser(String userid) throws RemoteException;

    /**
     * @param user
     * @return
     */
    public ResultMessage modifyUser(UserPO user) throws RemoteException;

    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID) throws RemoteException;
}
