package vo;

/**
 * Created by thinkpad on 2017/10/20.
 */
public class BusinessProcessTableFilterFlagsVO {
    String[] range_of_time = new String[2];
    String kind_of_bill;
    String customer;
    String operator;
    String stockid;

    public BusinessProcessTableFilterFlagsVO(String[] range_of_time,String kind_of_bill,String customer,
                                             String operator, String stockid ){
        this.range_of_time = range_of_time;
        this.kind_of_bill = kind_of_bill;
        this.customer = customer;
        this.operator = operator;
        this.stockid = stockid;


    }
}
