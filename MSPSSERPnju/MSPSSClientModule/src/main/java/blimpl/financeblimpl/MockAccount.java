package blimpl.financeblimpl;

import util.ResultMessage;
import vo.*;
import java.util.*;
/**
 * Created by thinkpad on 2017/11/6.
 */
public class MockAccount extends Account {

    @Override
    public ResultMessage addAccount(AccountVO account){
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteAccount(String id){
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyAccount(String id,AccountVO newaccount){
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<AccountVO> checkAccount(AccountFilterFlagsVO flags){
        ArrayList<AccountVO> list = new ArrayList<AccountVO>();
        list.add(new AccountVO("王二",12,"李白","2017-11-06"));
        return list;
    }
}
