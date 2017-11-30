package DataHelper;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.AccountPO;
import po.GeneralAccountPO;
import util.ResultMessage;

import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/28.
 */
public class DataHelper<T> {

    private SessionFactory sessionFactory;
    private Session session;
    private Class<T> type;

    public DataHelper() {

    }

    public DataHelper(Class<T> type) {
        this.type = type;
        Configuration configuration = new Configuration();
        sessionFactory = configuration.configure().buildSessionFactory();
    }


    /**
     * 初始化Session
     */
    private void setUpSession() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    /**
     * 提交事务及关闭session
     */
    private void commitAndClose() {
        session.getTransaction().commit();
        session.close();
    }



    public ResultMessage save(Object o) {
        try {
            setUpSession();
            System.out.println("lll");
            session.save(type.getName(), o);
            System.out.println("oooo");
            commitAndClose();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return ResultMessage.EXIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMessage.FAILED;
        }
        return ResultMessage.SUCCESS;
    }



    public ResultMessage update(Object o) {
        try {
            setUpSession();
            session.update(type.getName(), o);
            commitAndClose();
        } catch (OptimisticLockException e) {
            e.printStackTrace();
            return ResultMessage.NOT_EXIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMessage.FAILED;
        }
        return ResultMessage.SUCCESS;
    }










public static void main(String[] args){

        //AccountPO a = new AccountPO("23",2,"2017-11-11-11-11-11-11");
   // AccountPO b = new AccountPO("21",2000,"2017-11-11-11-11-11-11");
        DataHelper<GeneralAccountPO> helper = new DataHelper<GeneralAccountPO>(GeneralAccountPO.class);
       // helper.save(a);
       // helper.save(b);

    GeneralAccountPO g1 = new GeneralAccountPO();

    g1.getAccountlist().add(new AccountPO("23",2,"2017-11-11-11-11-11-11"));
    helper.save(g1);
}

}
