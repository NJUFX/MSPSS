package blimpl.generalaccountblimpl;

import util.ResultMessage;
import util.Time;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class GeneralAccount {

    public ArrayList<GeneralAccountVO> checkGeneralAccount(Time begin, Time end) {
        return null;
    }


    public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) {
        return ResultMessage.SUCCESS;
    }


    public ArrayList<GeneralAccountVO> ETLsort(ArrayList<GeneralAccountVO> accountlist) {
        return null;
    }
}
