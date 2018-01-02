package datahelper;

import antlr.collections.List;
import po.AccountPO;
import po.UserPO;
import util.Kind_Of_Users;


/**
 * Created by thinkpad on 2017/12/4.
 */
public class Test {
    DataHelper<AccountPO> datahelper = new HibernateHelper<AccountPO>(AccountPO.class);

    public static void main(String[] args) {
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
/*
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
<<<<<<< HEAD
    */
    	/*
=======

>>>>>>> b0241fc71180215d991b910a38b5a691e501c1c5
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE),metadata);
<<<<<<< HEAD
        */
<<<<<<< HEAD
    	
    	 DataHelper<UserPO>  userPODataHelper = new HibernateHelper<>(UserPO.class);
         UserPO po1 = new UserPO("CM-1991","hxh", Kind_Of_Users.ChiefManager.ordinal(),"161250036","hanxinhu521@163.com");
         UserPO po2  = new UserPO("CM-1911","xgy",Kind_Of_Users.ChiefManager.ordinal(),"161250164","hanxinhu521@163.com");
         
     
             userPODataHelper.save(po1);
             userPODataHelper.save(po2);
=======

        DataHelper<UserPO> userPODataHelper = new HibernateHelper<>(UserPO.class);
        UserPO po1 = new UserPO("CM-1991", "hxh", Kind_Of_Users.ChiefManager.ordinal(), "161250036");
        UserPO po2 = new UserPO("CM-1911", "xgy", Kind_Of_Users.ChiefManager.ordinal(), "161250164");
        UserPO po3 = new UserPO("SS-1991", "JiangChen", Kind_Of_Users.StockSeller.ordinal(), "123456");
        UserPO po4 = new UserPO("SM-1911", "xgy", Kind_Of_Users.StockManager.ordinal(), "123456");
        userPODataHelper.save(po1);
        userPODataHelper.save(po2);
        userPODataHelper.save(po3);
        userPODataHelper.save(po4);

        java.util.List<UserPO> pos = userPODataHelper.fullMatchQuery("id", "SS-1991");

        System.out.println(pos.isEmpty());


>>>>>>> 60432fce70e99761629a518ce3e1b13243a0f488
    }
}
