package blservice.userblservice;

import vo.UserVO;

import java.util.ArrayList;

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

    /**
     * 得到当前的使用者
     *
     * @return
     */
    public UserVO getCurrentUser();

    /**
     * 得到库存管理人员的邮箱地址
     * 便与通知库存报警信息
     */
    public ArrayList<String> getStockManagerMails();

    /**
     * 得到总经理的邮箱
     * 以提醒总经理审批
     */
    public ArrayList<String> getChiefManagerMails();
}
