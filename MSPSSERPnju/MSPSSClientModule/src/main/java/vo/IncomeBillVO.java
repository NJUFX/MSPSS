package vo;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/10/20.
 */
public class IncomeBillVO {
    String id;
    String time;
    String customer;
    String operator;
    ArrayList<VirementVO> virementvolist;
    long total;

    public IncomeBillVO(String id,String time,String customer,String operator,ArrayList<VirementVO> virementvolist,long total){
        this.id = id;
        this.time = time;
        this.customer = customer;
        this.operator = operator;
        this.virementvolist = virementvolist;
        this.total = total;
    }
}
