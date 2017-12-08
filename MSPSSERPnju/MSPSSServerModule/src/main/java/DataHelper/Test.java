package datahelper;

import po.AccountPO;
import po.CashCostBillPO;
import po.CashCostItemPO;
import util.CriteriaClause;
import util.CriteriaClauseImpl;
import util.QueryMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2017/12/4.
 */
public class Test {
    DataHelper<AccountPO> datahelper = new HibernateHelper<AccountPO>(AccountPO.class);

    public static void main(String[] args){
       /* Test t = new Test();
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
        t.datahelper.save(c);*/

       Test t = new Test();
        CriteriaClause c = CriteriaClauseImpl.createSingleValueQuery("name","23", QueryMethod.Full);
        CriteriaClause b = CriteriaClauseImpl.createRangeValueQuery("money",0,1500,QueryMethod.Range);
        CriteriaClause k = CriteriaClauseImpl.createRangeValueQuery("createtime","2017-11-11-01-01-01","2017-11-11-11-11-13",QueryMethod.Range);
         ArrayList<CriteriaClause> list = new ArrayList<>();
        list.add(k);

        List<AccountPO> pos =  t.datahelper.multiCriteriaQuery(list);
        for(AccountPO i:pos){
            System.out.println(i.getName());
    }


    }
}
