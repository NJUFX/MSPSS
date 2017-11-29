package po;

import util.Time;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class AccountPO implements Serializable {
    private int id;
    private String name;
    private int money;
    private Time createtime;
    private ArrayList<TestPO> list;
    public AccountPO(){

    }


    public AccountPO(String name,int money,Time createtime){
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Time getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Time createtime) {
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
