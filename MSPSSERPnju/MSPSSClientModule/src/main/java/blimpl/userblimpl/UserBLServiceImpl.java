package blimpl.userblimpl;

import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserBLService;
import blservice.userblservice.UserInfo;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

/**
 * updated by Han Xin Hu at 16:15 2017/12/21/021
 */
public class UserBLServiceImpl implements UserBLService, UserInfo, MainBLService {
    private User user;

    public UserBLServiceImpl(User user) {
        this.user = user;
    }

    /**
     * @param userVO
     * @return
     */
    @Override
    public ResultMessage addUser(UserVO userVO) {
        return user.addUser(userVO);
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
        return user.searchUserByKind(kind);
    }

    /**
     * 根据用户的ID来查找
     *
     * @param ID
     * @return
     */
    @Override
    public UserVO searchUserByID(String ID) {
        return user.searchUserByID(ID);
    }

    /**
     * 删除用户
     *
     * @param userID 用户id
     * @return 删除用户的运行结果
     */
    @Override
    public ResultMessage deleteUser(String userID) {
        return user.deleteUser(userID);
    }

    /**
     * @param userVO
     * @return
     */
    @Override
    public ResultMessage updateUser(UserVO userVO) {
        return user.updateUser(userVO);
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
        return user.login(ID, password);
    }


    @Override
    public Log_In_Out_Status logout(String ID) {
        return user.logout(ID);
    }

    /**
     * 根据用户的id返回用户的VO
     *
     * @param id
     * @return
     */
    @Override
    public UserVO getUser(String id) {
        if (id==null)
            return null;

        return user.searchUserByID(id);

    }

    /**
     * 得到当前的使用者
     *
     * @return
     */
    @Override
    public UserVO getCurrentUser() {
        return user.getCurrentUser();
    }

    /**
     * 得到库存管理人员的邮箱地址
     * 便与通知库存报警信息
     */
    @Override
    public ArrayList<String> getStockManagerMails() {
        return user.getStockManagerMails();
    }

    /**
     * 得到总经理的邮箱
     * 以提醒总经理审批
     */
    @Override
    public ArrayList<String> getChiefManagerMails() {
        return user.getChiefManagerMails();
    }
}
