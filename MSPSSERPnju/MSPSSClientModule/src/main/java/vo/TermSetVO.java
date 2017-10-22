package vo;

/**
 * Created by thinkpad on 2017/10/20.
 */
//条目清单VO
public class TermSetVO {
    String termname;
    long money;
    String remarks;

    public TermSetVO(String termname,long money,String remarks){
        this.termname = termname;
        this.money = money;
        this.remarks = remarks;
    }
}
