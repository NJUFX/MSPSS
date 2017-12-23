package blimpl.billblimpl;

import util.ResultMessage;
import vo.AlarmBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 22:16 2017/12/21/021
 */
public class AlarmBill {
    public ResultMessage addAlarmBill(AlarmBillVO vo) {

        return ResultMessage.SUCCESS;
    }

    public ArrayList<AlarmBillVO> getAllAlarmBills() {
        return new ArrayList<>();
    }

}
