package blservice.adminblservice;

import po.PowerPO;
import po.UserPO;
import util.ResultMessage;

/**
 * Created by thinkpad on 2017/10/23.
 */
public interface AdminBLService {
    /*
	 * 增加权限
	 *
	 * @param PowerPO 权限数据
	 *
	 * @return 添加权限的运行结果
	 */
    public ResultMessage givePower(PowerPO power);

    /*
    * 增加用户
    *
    * @param UserPO 用户数据
    *
    * @return 添加用户的运行结果
    */
    public ResultMessage addUser(UserPO user);

    /*
    * 删除用户
    *
    * @param userid 用户id
    *
    * @return 删除用户的运行结果
    */
    public ResultMessage deleteUser(String userid);
}
