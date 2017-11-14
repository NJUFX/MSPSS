package po;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class GeneralAccountPO {
    ArrayList<CommodityPO> commoditylist = new ArrayList<CommodityPO>();
    ArrayList<CustomerPO> Customerlist = new ArrayList<CustomerPO>();
    ArrayList<AccountPO> accountlist = new ArrayList<AccountPO>();

    public void addAccount(AccountPO account){
        accountlist.add(account);
    }

    public ArrayList<AccountPO> getaccountlist(){
        return accountlist;
    }
}
