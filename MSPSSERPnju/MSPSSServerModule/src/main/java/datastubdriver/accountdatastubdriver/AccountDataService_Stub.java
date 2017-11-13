package datastubdriver.accountdatastubdriver;

import dataservice.AccountDataService;
import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public class AccountDataService_Stub implements AccountDataService {
    @Override
    public ResultMessage addAccount(AccountVO account){

        return ResultMessage.SUCCESS;
    }
    @Override
    public ResultMessage deleteAccount(String name){

        return ResultMessage.SUCCESS;
    }
    @Override
    public ResultMessage modifyAccount(String oldname,String newname){


        return ResultMessage.SUCCESS;
    }
    @Override
    public ArrayList<AccountVO> checkAccount(String name){

        ArrayList<AccountVO> list = new ArrayList<AccountVO>();

        return list;
    }
    @Override
    public void income(String name,int money){

    }
    @Override
    public void pay(String name,int money){

    }
}
