package blstubdriver.mainstubdriver;

import blservice.mainblservice.MainBLService;
import status.Log_In_Out_Status;

/**
 * Created by thinkpad on 2017/10/24.
 */
public class MainBLService_Stub implements MainBLService{

    /**
     * 登出
     *
     * @param ID
     * @return 登出的运行结果
     */
    @Override
    public Log_In_Out_Status logout(String ID) {
        return null;
    }


    /**
     * 登陆
     *
     * @param id       用户id
     * @param password 用户密码
     * @return 登陆的运行结果
     */

    public Log_In_Out_Status login(String id, String password) {
        return null;
    }


}
