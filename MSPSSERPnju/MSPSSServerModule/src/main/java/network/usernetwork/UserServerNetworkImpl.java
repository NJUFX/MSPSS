package network.usernetwork;
import dataimpl.userdataimpl.UserDataServiceFactory;
import dataservice.UserDataService;
import network.usernetworkservice.UserServerNetworkService;
import po.UserPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/12/14.
 */
public class UserServerNetworkImpl extends UnicastRemoteObject implements UserServerNetworkService {
    private UserDataService userDataService;

    public UserServerNetworkImpl() throws RemoteException{
        userDataService = UserDataServiceFactory.getUserDataService();
    }

    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage modifyPower(UserPO user, String power) throws RemoteException{
        return userDataService.modifyPower(user,power);
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserPO user) throws RemoteException{
        return userDataService.addUser(user);
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage deleteUser(String userid) throws RemoteException{
        return userDataService.deleteUser(userid);
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage updateUser(UserPO user){
        return userDataService.updateUser(user);
    }

    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID) throws RemoteException{
        return userDataService.searchUserByID(ID);
    }

    /**
     * 完全匹配一定类型的用户
     *
     * @param filed
     * @param val
     * @return
     */
    public ArrayList<UserPO> fullSearchUser(String filed, Object val){
        return userDataService.fullSearchUser(filed, val);
    }

    /**
     * 精确查找
     *
     * @param field
     * @param val
     * @return
     */
    public UserPO exactlySearchUser(String field, Object val){
        return userDataService.exactlySearchUser(field,val);
    }


}
