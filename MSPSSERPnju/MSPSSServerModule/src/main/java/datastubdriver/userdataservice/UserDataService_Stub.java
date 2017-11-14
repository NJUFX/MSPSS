package datastubdriver.userdataservice;

import dataservice.UserDataService;
import po.UserPO;
import util.ResultMessage;

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
}
