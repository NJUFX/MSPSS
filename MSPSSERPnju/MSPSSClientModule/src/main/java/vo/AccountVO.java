package vo;

public class AccountVO {
   public String name;
    public long money;
    public String creator;
    public String creattime;

    public AccountVO(String name,long money,String creator,String creattime){
        this.name = name;
        this.money = money;
        this.creator = creator;
        this.creattime = creattime;
    }

}
