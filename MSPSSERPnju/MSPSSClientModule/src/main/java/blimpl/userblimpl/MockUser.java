package blimpl.userblimpl;

import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

public class MockUser extends User {
    /**
     * @param user
     * @return
     */
    @Override
    public ResultMessage addUser(UserVO user) {
        return super.addUser(user);
    }

    /**
     * 根据用户类型查找用户
     * sale finance    同时返回经理
     *
     * @param kind
     * @return
     */
    @Override
    public ArrayList<UserVO> searchUserByKind(Kind_Of_Users kind) {
        return super.searchUserByKind(kind);
    }

    /**
     * 删除用户
     *
     * @param userID 用户id
     * @return 删除用户的运行结果
     */
    @Override
    public ResultMessage deleteUser(String userID) {
        return super.deleteUser(userID);
    }

    /**
     * @param userVO
     * @return
     */
    @Override
    public ResultMessage updateUser(UserVO userVO) {
        return super.updateUser(userVO);
    }

    /**
     * 根据用户的ID来查找
     *
     * @param ID
     * @return
     */
    @Override
    public UserVO searchUserByID(String ID) {
        return super.searchUserByID(ID);
    }

    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */
    @Override
    public Log_In_Out_Status login(String ID, String password) {
        return super.login(ID, password);
    }

    /**
     * 登出
     *
     * @param ID
     * @return
     */
    @Override
    public Log_In_Out_Status logout(String ID) {
        return super.logout(ID);
    }

    @Override
    public UserVO getCurrentUser() {
        return super.getCurrentUser();
    }

    /**
     * 得到库存管理人员的邮箱地址
     * 便与通知库存报警信息
     */
    @Override
    public ArrayList<String> getStockManagerMails() {
        return super.getStockManagerMails();
    }

    /**
     * 得到总经理的邮箱
     * 以提醒总经理审批
     */
    @Override
    public ArrayList<String> getChiefManagerMails() {
        return super.getChiefManagerMails();
    }
}
