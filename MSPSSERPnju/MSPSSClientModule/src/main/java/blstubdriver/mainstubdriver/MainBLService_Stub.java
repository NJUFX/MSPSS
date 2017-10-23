package blstubdriver.mainstubdriver;
import blservice.mainblservice.*;
import po.UserPO;
import util.ResultMessage;

/**
 * Created by thinkpad on 2017/10/24.
 */
public class MainBLService_Stub implements MainBLService{

    @Override
    public ResultMessage login(String id,String password){
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage logout(){
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage rigister(UserPO user){
        return ResultMessage.SUCCESS;
    }
}
