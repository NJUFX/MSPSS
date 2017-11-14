package dataservice;

import util.Kind_Of_Power;
import util.ResultMessage;
import po.*;

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
    public ResultMessage delUser(String userid);

    /**
     * @param user
     * @return
     */
    public ResultMessage modifyUser(UserPO user);
}
