package blimpl.userblimpl;

import util.Kind_Of_Power;
import util.ResultMessage;
import vo.UserVO;

public class MockUserManage extends UserManage {

    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    @Override
    public ResultMessage givePower(UserVO user, Kind_Of_Power power) {
        user.setPower(power);
        return ResultMessage.SUCCESS;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public ResultMessage addUser(UserVO user) {
        UserList.add(user);
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    @Override
    public ResultMessage delUser(String userid) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getIsValid() == true && UserList.get(i).getID().equals(userid)) {
                UserList.get(i).setIsValid(false);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.NOT_EXIST;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public ResultMessage modifyUser(UserVO user) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getIsValid() == true && UserList.get(i).getID().equals(user.getID())) {
                UserList.remove(i);
                UserList.add(user);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.FAILED;
    }
}
