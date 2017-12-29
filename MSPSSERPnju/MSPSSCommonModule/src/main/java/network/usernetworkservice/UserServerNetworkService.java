package network.usernetworkservice;

import po.UserPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface UserServerNetworkService extends Remote{
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
    public ResultMessage deleteUser(String userid) throws RemoteException;


    /**
     * @param user
     * @return
     */
    public ResultMessage updateUser(UserPO user)throws RemoteException;

    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID) throws RemoteException;

    /**
     * 完全匹配一定类型的用户
     *
     * @param filed
     * @param val
     * @return
     */
    public ArrayList<UserPO> fullSearchUser(String filed, Object val)throws RemoteException;

    /**
     * 精确查找
     *
     * @param field
     * @param val
     * @return
     */
    public UserPO exactlySearchUser(String field, Object val)throws RemoteException;
}
