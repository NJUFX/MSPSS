package vo;

import util.Time;

public class AccountVO {
   private String name;
    private double money;
    private Time createTime;

    public AccountVO(String name,double money,Time createTime){
        this.name = name;
        this.money = money;

        this.createTime = createTime;
    }
    public AccountVO(String name,double money){
        this.name = name;
        this.money = money;
        this.createTime = new Time();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getMoney(){
        return money;
    }

    public Time getCreateTime(){
        return createTime;
    }



}
