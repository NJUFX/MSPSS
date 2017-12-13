package po;

import util.Time;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/14.
 */

public class AccountPO implements Serializable {
    /**
     * 编号
     */
    private int id;
    /**
     * 账户名
     */
    private String name;
    /**
     * 账户余额
     */
    private double money;
    /**
     * 账户创建时间
     */
    private String createtime;

    public AccountPO(){

    }


    public AccountPO(String name,double money,String createtime){
        this.name = name;
        this.money = money;

        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountPO accountPO = (AccountPO) o;

        return name.equals(accountPO.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}