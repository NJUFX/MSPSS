package blservice.mainblservice;
import po.UserPO;
import util.*;
import po.UserPO;
/**
 * Created by thinkpad on 2017/10/23.
 */
public interface MainBLService {
    /*
    * 登陆
    *
    * @param id 用户id
    *
    * @param password 用户密码
    *
    * @return 登陆的运行结果
    */
    public ResultMessage login(String id,String password);
    /*
    * 登出
    *
    * @return 登出的运行结果
    */
    public ResultMessage logout();

    /*
    * 注册
    *
    * @param UserPO 用户信息
    *
    * @return 注册的运行结果
    */
    public ResultMessage rigister(UserPO user);

}
