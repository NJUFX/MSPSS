package vo;

import po.CommodityPO;
import util.Time;

import java.util.ArrayList;
import java.util.List;

public class GeneralAccountVO {
    private String name;
    private Time time;
    private List<CommodityVO> commoditylist= new ArrayList<CommodityVO>();
    private List<CustomerVO> Customerlist = new ArrayList<CustomerVO>();
    private List<AccountVO> accountlist = new ArrayList<AccountVO>() ;

    public GeneralAccountVO() {
    }

    public GeneralAccountVO(String name, Time time, List<CommodityVO> commoditylist, List<CustomerVO> customerlist, List<AccountVO> accountlist) {
        this.name = name;
        this.time = time;
        this.commoditylist = commoditylist;
        Customerlist = customerlist;
        this.accountlist = accountlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<CommodityVO> getCommoditylist() {
        return commoditylist;
    }

    public void setCommoditylist(List<CommodityVO> commoditylist) {
        this.commoditylist = commoditylist;
    }

    public List<CustomerVO> getCustomerlist() {
        return Customerlist;
    }

    public void setCustomerlist(List<CustomerVO> customerlist) {
        Customerlist = customerlist;
    }

    public List<AccountVO> getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(List<AccountVO> accountlist) {
        this.accountlist = accountlist;
    }
}
