package blservice.userblservice;

import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/10/23.
 */
public interface UserBLService {
    /**
     * @param userVO
     * @return
     */
    public ResultMessage addUser(UserVO userVO);

    /**
     * 根据用户类型查找用户
     * sale finance    同时返回经理
     *
     * @param kind
     * @return
     */
    public ArrayList<UserVO> searchUserByKind(Kind_Of_Users kind);

    /**
     * 根据用户的ID来查找
     *
     * @param ID
     * @return
     */
    public UserVO searchUserByID(String ID);


    /**
     * 删除用户
     *
     * @param userID 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage deleteUser(String userID);

    /**
     * @param user
     * @return
     */
    public ResultMessage updateUser(UserVO user);


}
