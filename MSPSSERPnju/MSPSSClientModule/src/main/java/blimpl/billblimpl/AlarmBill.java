package blimpl.billblimpl;

import network.BillClientNetworkService;
import po.AlarmBillPO;
import util.ResultMessage;
import util.Time;
import vo.AlarmBillVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 22:16 2017/12/21/021
 */
public class AlarmBill {
    BillClientNetworkService billClientNetworkService;
    static final String prefix = "KCBJD";

    public ResultMessage addAlarmBill(String commodityID, int number) {
        String ID = billClientNetworkService.getAlarmID();
        return billClientNetworkService.addAlarmBill(new AlarmBillPO(ID, commodityID, number, new Time().toString()));
    }

    public ArrayList<AlarmBillVO> getAlarmBill(Time time) {
        List<AlarmBillPO> pos = billClientNetworkService.prefixSearchAlarmBill("time", prefix + "-" + time.getTimeStringWithoutSplit());
        ArrayList<AlarmBillVO> vos = new ArrayList<>();
        for (AlarmBillPO po : pos) {
            vos.add(po_to_vo(po));
        }
        return vos;
    }

    private AlarmBillVO po_to_vo(AlarmBillPO po) {
        return new AlarmBillVO(po.getId(), po.getCommodityID(), po.getNumber(), new Time(po.getTime()));
    }

}
