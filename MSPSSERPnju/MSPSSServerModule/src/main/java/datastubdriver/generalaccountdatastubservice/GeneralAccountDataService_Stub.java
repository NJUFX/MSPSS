package datastubdriver.generalaccountdatastubservice;

import blservice.generalaccountblservice.GeneralAccountBLService;
import dataservice.GeneralAccountDataService;
import util.ResultMessage;
import util.Time;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public class GeneralAccountDataService_Stub implements GeneralAccountDataService {

    @Override
    public ArrayList<GeneralAccountVO> checkGeneralAccount(Time begin, Time end) {

        return null;
    }

    @Override
    public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) {


        return ResultMessage.SUCCESS;
    }

}
