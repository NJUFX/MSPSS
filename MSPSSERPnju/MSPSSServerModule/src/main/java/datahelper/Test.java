package datahelper;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.Target;
import org.hibernate.tool.schema.TargetType;
import po.AccountPO;
import po.CashCostBillPO;
import po.CashCostItemPO;
import po.UserPO;
import util.CriteriaClause;
import util.CriteriaClauseImpl;
import util.Kind_Of_Users;
import util.QueryMethod;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



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
    */
    	/*
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE),metadata);
        */
    	
    	 DataHelper<UserPO>  userPODataHelper = new HibernateHelper<>(UserPO.class);
         UserPO po1 = new UserPO("CM-1991","hxh", Kind_Of_Users.ChiefManager.ordinal(),"161250036");
         UserPO po2  = new UserPO("CM-1911","xgy",Kind_Of_Users.ChiefManager.ordinal(),"161250164");
         
     
             userPODataHelper.save(po1);
             userPODataHelper.save(po2);

    }
}
