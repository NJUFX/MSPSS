package datastubdriver.generalaccountdatastubservice;


import dataservice.GeneralAccountDataService;
import po.GeneralAccountPO;
import util.ResultMessage;
import util.Time;


import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public class GeneralAccountDataService_Stub implements GeneralAccountDataService {

    @Override
    public ArrayList<GeneralAccountPO> checkGeneralAccount(Time begin, Time end) {

        return null;
    }

    @Override
    public ResultMessage newGeneralAccount(GeneralAccountPO generalaccount) {


        return ResultMessage.SUCCESS;
    }

}
