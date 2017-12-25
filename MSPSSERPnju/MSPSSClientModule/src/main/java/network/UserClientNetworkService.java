package network;

import po.UserPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 10:27 2017/11/30/030
 */
public interface UserClientNetworkService extends Remote {


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
    public ResultMessage deleteUser(String userid);

    /**
     * @param user
     * @return
     */
    public ResultMessage updateUser(UserPO user);

    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID);

    /**
     * 完全匹配一定类型的用户
     *
     * @param filed
     * @param val
     * @return
     */
    public ArrayList<UserPO> fullSearchUser(String filed, Object val);

    /**
     * 精确查找
     *
     * @param field
     * @param val
     * @return
     */
    public UserPO exactlySearchUser(String field, Object val);

}
