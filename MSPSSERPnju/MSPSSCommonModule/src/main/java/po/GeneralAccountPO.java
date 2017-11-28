package po;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class GeneralAccountPO {
    ArrayList<CommodityPO> commoditylist = new ArrayList<CommodityPO>();
    ArrayList<CustomerPO> Customerlist = new ArrayList<CustomerPO>();
    ArrayList<AccountPO> accountlist = new ArrayList<AccountPO>();

    public GeneralAccountPO() {
    }

    public void addAccount(AccountPO account){
        accountlist.add(account);
    }

    public ArrayList<AccountPO> getaccountlist(){
        return accountlist;
    }

    public ArrayList<CommodityPO> getCommoditylist() {
        return commoditylist;
    }

    public void setCommoditylist(ArrayList<CommodityPO> commoditylist) {
        this.commoditylist = commoditylist;
    }

    public ArrayList<CustomerPO> getCustomerlist() {
        return Customerlist;
    }

    public void setCustomerlist(ArrayList<CustomerPO> customerlist) {
        Customerlist = customerlist;
    }

    public ArrayList<AccountPO> getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(ArrayList<AccountPO> accountlist) {
        this.accountlist = accountlist;
    }

}
