package datastubdriver.userdataservice;

import dataservice.UserDataService;
import po.UserPO;
import util.ResultMessage;

import java.util.ArrayList;

public class UserDataService_Stub implements UserDataService {
    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage modifyPower(UserPO user, String power) {
        return ResultMessage.SUCCESS;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserPO user) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage delUser(String userid) {
        return ResultMessage.SUCCESS;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage modifyUser(UserPO user) {
        return ResultMessage.SUCCESS;
    }

    public UserPO findUserByID(String ID){
        return new UserPO();
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    @Override
    public ResultMessage deleteUser(String userid) {
        return null;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public ResultMessage updateUser(UserPO user) {
        return null;
    }

    /**
     * 通过登录账号返回ID
     *
     * @param ID
     * @return
     */
    @Override
    public UserPO searchUserByID(String ID) {
        return null;
    }

    /**
     * 完全匹配一定类型的用户
     *
     * @param filed
     * @param val
     * @return
     */
    @Override
    public ArrayList<UserPO> fullSearchUser(String filed, Object val) {
        return null;
    }

    /**
     * 精确查找
     *
     * @param field
     * @param val
     * @return
     */
    @Override
    public UserPO exactlySearchUser(String field, Object val) {
        return null;
    }
}
