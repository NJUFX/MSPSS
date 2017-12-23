package network;

import network.usernetworkservice.UserServerNetworkService;
import po.UserPO;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
    public ResultMessage delUser(String userid){
        try{
          userServerNetworkService.delUser(userid);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage modifyUser(UserPO user){
        try{
             userServerNetworkService.modifyUser(user);
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
}
