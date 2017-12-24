package network;

import network.usernetworkservice.UserServerNetworkService;
import po.UserPO;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/15.
 */
public class UserClientNetworkImpl implements UserClientNetworkService {
    private UserServerNetworkService userServerNetworkService;

    public UserClientNetworkImpl(){
        try {
            userServerNetworkService = (UserServerNetworkService) Naming.lookup("UserServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.UserServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage modifyPower(UserPO user, String power){
        try{
            userServerNetworkService.modifyPower(user, power);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserPO user){
        try{
           userServerNetworkService.addUser(user);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage deleteUser(String userid){
        try{
            userServerNetworkService.deleteUser(userid);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage updateUser(UserPO user){
        try{
            userServerNetworkService.updateUser(user);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID){
        try{
          userServerNetworkService.searchUserByID(ID);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 精确查找
     *
     * @param field
     * @param val
     * @return
     */
    public UserPO exactlySearchUser(String field, Object val){
        try{
            userServerNetworkService.exactlySearchUser(field,val);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 完全匹配一定类型的用户
     *
     * @param field
     * @param val
     * @return
     */
    public ArrayList<UserPO> fullSearchUser(String field, Object val){
        try{
            userServerNetworkService.fullSearchUser(field,val);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }


}
