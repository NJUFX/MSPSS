package vo;

import java.util.ArrayList;

public class GeneralAccountVO {
    ArrayList<CommodityVO> commoditylist = new ArrayList<CommodityVO>();
    ArrayList<CustomerVO> Customerlist = new ArrayList<CustomerVO>();
    ArrayList<AccountVO> accountlist = new ArrayList<AccountVO>();

    public void addAccount(AccountVO account){
        accountlist.add(account);
    }

    public ArrayList<AccountVO> getaccountlist(){
        return accountlist;
    }
}
