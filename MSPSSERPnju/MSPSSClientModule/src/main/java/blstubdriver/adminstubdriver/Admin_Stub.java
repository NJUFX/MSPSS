package blstubdriver.adminstubdriver;
import po.PowerPO;
import po.UserPO;
import util.ResultMessage;
import blservice.userblservice.*;
/**
 * Created by thinkpad on 2017/10/23.
 */
public class Admin_Stub implements UserBLService {


    @Override
    public ResultMessage givePower(PowerPO power){
        return ResultMessage.SUCCESS;
    }
    @Override
    public ResultMessage addUser(UserPO user){
        return ResultMessage.SUCCESS;
    }
    @Override
    public ResultMessage deleteUser(String userid){
        return ResultMessage.SUCCESS;
    }

}
