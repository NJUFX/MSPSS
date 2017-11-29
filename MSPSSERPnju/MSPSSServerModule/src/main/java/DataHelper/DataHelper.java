package DataHelper;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.AccountPO;
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









    public ArrayList<T> prefixMatchQuery(String field, String value) {
        value = value + "%";
        return likePatternQuery(field, value);
    }


    public ArrayList<T> suffixMatchQuery(String field, String value) {
        value = "%" + value;
        return likePatternQuery(field, value);
    }



    public ArrayList<T> fuzzyMatchQuery(String field, String value) {
        value = "%" + value + "%";
        return likePatternQuery(field, value);
    }



    public ArrayList<T> rangeQuery(String field, Object min, Object max) {
        try {
            Criteria criteria = SetUpCriteria();
            criteria.add(Restrictions.between(field, min, max));
            ArrayList<T> arrayList = (ArrayList<T>) criteria.list();
            session.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return new ArrayList<T>();
        }
    }

    /**
     * 生成一个新的匹配标准
     *
     * @return 新的匹配标准
     * @throws ClassNotFoundException 如果没有指定type，则抛出该异常
     */
    private Criteria SetUpCriteria() throws ClassNotFoundException {
        setUpSession();
        return session.createCriteria(type);
    }

    /**
     * 利用模糊查找返回符合条件的PO列表
     *
     * @param field 查询域
     * @param value 域值
     * @return PO列表
     */
    private ArrayList<T> likePatternQuery(String field, String value) {
        try {
            Criteria criteria = SetUpCriteria();
            criteria.add(Restrictions.like(field, value));
            ArrayList<T> arrayList = (ArrayList<T>) criteria.list();
            session.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return new ArrayList<T>();
        }
    }

public static void main(String[] args){

        AccountPO a = new AccountPO("23",2,"2017-11-11-11-11-11-11");
    AccountPO b = new AccountPO("21",2000,"2017-11-11-11-11-11-11");
        DataHelper<AccountPO> helper = new DataHelper<AccountPO>(AccountPO.class);
        helper.save(a);
        helper.save(b);

}

}
