package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import po.AlarmBillPO;
import util.ResultMessage;
import util.SendMailImpl;
import util.Time;
import vo.AlarmBillVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 22:16 2017/12/21/021
 */
public class AlarmBill {
    BillClientNetworkService billClientNetworkService = new BillClientNetworkImpl();
    static final String prefix = "KCBJD";
    private static UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    public ResultMessage addAlarmBill(String commodityID, int number) {
        String ID = billClientNetworkService.getAlarmID();
        ResultMessage message = billClientNetworkService.addAlarmBill(new AlarmBillPO(ID, commodityID, number, new Time().toString()));
        if (message == ResultMessage.SUCCESS) {
            ArrayList<String> mails = userInfo.getStockManagerMails();
            for (int i = 0; i < mails.size(); i++) {
                SendMailImpl.getInstance().sendMail("库存管理人员", mails.get(i), "新增库存报警单",
                        "您好，商品" + commodityID + "仅有" + number + "急需您的查看");
            }
        }
        return message;
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
