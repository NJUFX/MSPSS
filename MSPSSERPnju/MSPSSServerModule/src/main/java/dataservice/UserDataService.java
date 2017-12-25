package dataservice;

import util.Kind_Of_Power;
import util.ResultMessage;
import po.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserDataService {
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
    public ResultMessage deleteUser(String userid) ;


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
    public UserPO searchUserByID(String ID) ;

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
