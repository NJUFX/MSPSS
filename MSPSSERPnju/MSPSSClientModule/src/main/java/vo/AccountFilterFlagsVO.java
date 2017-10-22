package vo;

public class AccountFilterFlagsVO {
    String name;
    String creator;
    String[] range_of_time = new String[2];

    public AccountFilterFlagsVO(String name,String creator,String[] range_of_time){
        this.name = name;
        this.creator = creator;
        this.range_of_time = range_of_time;

    }

}
