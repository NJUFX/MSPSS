package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class GeneralAccountPO implements Serializable {
    private int  id;

    private List<GeneralAccount_CommodityList_PO> commoditylist;
    private List<GeneralAccount_CustomerList_PO> Customerlist ;
    private List<GeneralAccount_AccountList_PO> accountlist ;

    public GeneralAccountPO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<GeneralAccount_CommodityList_PO> getCommoditylist() {
        return commoditylist;
    }

    public void setCommoditylist(List<GeneralAccount_CommodityList_PO> commoditylist) {
        this.commoditylist = commoditylist;
    }

    public List<GeneralAccount_CustomerList_PO> getCustomerlist() {
        return Customerlist;
    }

    public void setCustomerlist(List<GeneralAccount_CustomerList_PO> customerlist) {
        Customerlist = customerlist;
    }

    public List<GeneralAccount_AccountList_PO> getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(List<GeneralAccount_AccountList_PO> accountlist) {
        this.accountlist = accountlist;
    }
}
