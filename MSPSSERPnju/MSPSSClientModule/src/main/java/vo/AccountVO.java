package vo;

import util.Time;

public class AccountVO {
   private String name;
    private int money;
    private Time createTime;

    public AccountVO(String name,int money,Time createTime){
        this.name = name;
        this.money = money;

        this.createTime = createTime;
    }
    public AccountVO(String name,int money){
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

    public int getMoney(){
        return money;
    }

    public Time getCreatTime(){
        return createTime;
    }



}
