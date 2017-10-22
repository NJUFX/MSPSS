package vo;
import java.util.ArrayList;
/**
 * Created by thinkpad on 2017/10/20.
 */
public class PayBillVO {
    String id;
    String time;
    String bankaccount;
    String operator;
    ArrayList<TermSetVO> termsetvo;
    long total;

    public PayBillVO(String id,String time,String bankaccount,String operator,ArrayList<TermSetVO> termsetvo,long total){
        this.id = id;
        this.time = time;
        this.bankaccount = bankaccount;
        this.operator = operator;
        this.termsetvo = termsetvo;
        this.total = total;
    }
}
