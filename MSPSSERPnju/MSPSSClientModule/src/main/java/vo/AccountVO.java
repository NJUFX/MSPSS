package vo;

import util.Time;

public class AccountVO {
   private String name;
    private int money;
    private Time createtime;

    public AccountVO(String name,int money,Time createtime){
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
