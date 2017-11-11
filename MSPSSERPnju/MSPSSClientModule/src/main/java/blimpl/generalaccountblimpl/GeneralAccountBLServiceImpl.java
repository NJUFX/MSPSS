package blimpl.generalaccountblimpl;

import blservice.generalaccountblservice.GeneralAccountBLService;
import util.ResultMessage;
import util.Time;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class GeneralAccountBLServiceImpl implements GeneralAccountBLService {

    GeneralAccount MyGeneralAccount = new GeneralAccount();
    @Override
    public ArrayList<GeneralAccountVO> checkGeneralAccount(Time begin, Time end) {

        return MyGeneralAccount.checkGeneralAccount(begin,end);
    }

    @Override
    public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) {

        return MyGeneralAccount.newGeneralAccount(generalaccount);
    }

    @Override
    public ArrayList<GeneralAccountVO> ETLsort(ArrayList<GeneralAccountVO> accountlist) {
        return MyGeneralAccount.ETLsort(accountlist);
    }
}
