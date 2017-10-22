package vo;

public class GeneralAccountVO {
    String name;
    String operator;
    String creattime;
    long initmoney;

    public GeneralAccountVO(String name,String operator,String creattime,long initmoney){
        this.name =name;
        this.operator = operator;
        this.creattime = creattime;
        this.initmoney = initmoney;
    }

}
