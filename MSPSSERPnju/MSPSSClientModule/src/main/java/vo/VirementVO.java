package vo;

/**
 * Created by thinkpad on 2017/10/20.
 */
//转账列表VO
public class VirementVO {
    String bankaccount;
    long money;
    String remarks;

    public VirementVO(String bankaccount,long money,String remarks){
        this.bankaccount = bankaccount;
        this.money = money;
        this.remarks = remarks;
    }
}
