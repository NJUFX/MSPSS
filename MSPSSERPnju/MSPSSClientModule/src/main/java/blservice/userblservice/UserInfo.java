package blservice.userblservice;

import vo.UserVO;

/**
 * Description:
 * Created by Hanxinhu at 15:59 2017/12/4/004
 */
public interface UserInfo {
    /**
     * 根据用户的id返回用户的VO
     * @param id
     * @return
     */
    public UserVO getUser(String id);
}
