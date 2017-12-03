package blimpl.userblimpl;

import blservice.userblservice.UserBLService;
import status.Log_In_Out_Status;
import util.Kind_Of_Power;
import util.ResultMessage;
import vo.UserVO;

public class UserBLServiceImpl implements UserBLService {
    UserManage manage = new UserManage();
    UserLog log = new UserLog();
    @Override
    public ResultMessage modifyPower(UserVO user, Kind_Of_Power power, int i) {

        return manage.modifyPower(user,"");
    }

    @Override
    public ResultMessage addUser(UserVO user) {

        return manage.addUser(user);
    }

    @Override
    public ResultMessage delUser(String userid) {
        return manage.delUser(userid);
    }

    @Override
    public ResultMessage modifyUser(UserVO user) {

        return manage.modifyUser(user);
    }

    @Override
    public Log_In_Out_Status login(String ID, String password) {

        return log.login(ID,password);
    }

    @Override
    public Log_In_Out_Status logout(String ID) {

        return log.logout(ID);
    }
}
