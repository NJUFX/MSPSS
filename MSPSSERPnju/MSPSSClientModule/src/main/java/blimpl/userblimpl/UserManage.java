package blimpl.userblimpl;

import util.Kind_Of_Power;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

public class UserManage {
    public static ArrayList<UserVO> UserList = new ArrayList<UserVO>();

    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage givePower(UserVO user, Kind_Of_Power power) {
        return ResultMessage.SUCCESS;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserVO user) {
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
    public ResultMessage modifyUser(UserVO user) {
        return ResultMessage.SUCCESS;
    }
}
