package blservice.mainblservice;

import status.Log_In_Out_Status;
/**
 * Created by thinkpad on 2017/10/23.
 */
public interface MainBLService {
    /**
    * 登陆
    *
    * @param id 用户id
    *
    * @param password 用户密码
    *
    * @return 登陆的运行结果
    */
    public Log_In_Out_Status login(String id, String password);

    /**
    * 登出
    *
    * @return 登出的运行结果
    */
    public Log_In_Out_Status logout(String ID);



}
