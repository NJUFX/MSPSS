package datahelper;

import po.CashCostBillPO;
import po.CashCostItemPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2017/12/4.
 */
public class Test {
    DataHelper<CashCostBillPO> datahelper = new HibernateHelper<CashCostBillPO>(CashCostBillPO.class);

    public static void main(String[] args){
        Test t = new Test();
        CashCostBillPO c = new CashCostBillPO();
        List<CashCostItemPO> list = new ArrayList<CashCostItemPO>();
        CashCostItemPO ci = new CashCostItemPO();
        ci.setPs("as");
        ci.setName("wewe");
        ci.setMoney(11);

        list.add(ci);

        c.setList(list);
        c.setSum(122);
        c.setStatus(1);
        c.setOperatorID("11111");
        c.setManagerID("123131");
        c.setInit_time("1213131");
        c.setID("12121");
        c.setApproval_time("12131");
        c.setCommit_time("131313");
        t.datahelper.save(c);

    }
}
