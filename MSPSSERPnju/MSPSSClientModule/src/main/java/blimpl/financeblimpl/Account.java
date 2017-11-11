package blimpl.financeblimpl;
import vo.*;
import util.*;
import java.util.*;
/**
 * Created by thinkpad on 2017/11/6.
 */
public class Account {

    public ResultMessage addAccount(AccountVO account){
        return ResultMessage.SUCCESS;
    }

    public ResultMessage deleteAccount(String id){
        return ResultMessage.SUCCESS;
    }

    public ResultMessage modifyAccount(String id,AccountVO newaccount){
        return ResultMessage.SUCCESS;
    }

    public ArrayList<AccountVO> checkAccount(AccountFilterFlagsVO flags){
        return new ArrayList<AccountVO>();
    }


}
