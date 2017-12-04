package DataHelper;

import po.CashCostBillPO;
import po.CashCostItemPO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/4.
 */
public class Test {
    DataHelper<CashCostBillPO> datahelper = new HibernateHelper<CashCostBillPO>();

    public static void main(String[] args){
        Test t = new Test();
        CashCostBillPO c = new CashCostBillPO();
        c.setID("161250164");
        c.setInit_time("2017-12-12-11-11-11");
        c.setManagerID("161250164");
        c.setOperatorID("161250164");
        c.setStatus(1);
        c.setSum(1000);
        ArrayList<CashCostItemPO> list = new ArrayList<CashCostItemPO>();
        CashCostItemPO cci = new CashCostItemPO();
        cci.setMoney(1000);
        cci.setName("wewrw");
        cci.setPs("weqeqe");
        list.add(cci);

        c.setList(list);
        t.datahelper.save(c);
    }
}
