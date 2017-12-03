package DataHelper;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.*;
import util.ResultMessage;
import java.util.List;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * Created by thinkpad on 2017/11/28.
 */
public class DataHelper<T> {

 private static SessionFactory sessionFactory ;
 static {
     try{
         sessionFactory = new Configuration().configure().buildSessionFactory();

     }catch(Exception e){
         e.printStackTrace();
     }
 }








public static void main(String[] args) {

    //AccountPO a = new AccountPO("23",2,"2017-11-11-11-11-11-11");
    // AccountPO b = new AccountPO("21",2000,"2017-11-11-11-11-11-11");

    // helper.save(a);
    // helper.save(b);

    Session session = sessionFactory.openSession();
    Transaction tx=null;



     GeneralAccountPO g = new GeneralAccountPO();
     /*
     g.getAccountlist().add(new GeneralAccount_AccountList_PO("2017第一季度账户",1000,g));
     g.getCommoditylist().add(new GeneralAccount_CommodityList_PO("水晶吊灯","挂灯/吊灯","吊灯","21-34-51",300,400,200,g));
     g.getCustomerlist().add(new GeneralAccount_CustomerList_PO(true,"161250164","SUPPLIY",1,"王二","17726712121","江苏省南京市总统府","222300","123@163.com",1000,200,30,g));
    */

     GeneralAccount_AccountList_PO a = new GeneralAccount_AccountList_PO();

     a.setMoney(1000);
     g.getAccountlist().add(a);
     g.setName("苏果超市");
    tx = session.beginTransaction();
    session.save(g);
    tx.commit();
    session.close();


}

}
