package po;

import util.Time;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class AccountPO {
    private String name;
    private int money;
    private Time createtime;

    public AccountPO(String name,int money,Time createtime){
        this.name = name;
        this.money = money;

        this.createtime = createtime;
    }

    public void setname(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public int getmoney(){
        return money;
    }

    public Time getcreattime(){
        return createtime;
    }
}
