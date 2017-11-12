package blservice.billblservice;

import util.ResultMessage;
import vo.AlarmBillVO;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 16:56 2017/11/11/011
 */
public interface BillBLInfo {
    public ResultMessage  makeAlarmBill(AlarmBillVO alarmBillVO);
}
