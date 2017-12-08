package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 15:46 2017/11/28/028
 */
public class FinanceItemPO implements Serializable{
    /**
     * 数据库主键，切勿自行初始化这个变量！！！
     */
    private String id;
    /**
     * 银行账户号
     */
    private String accountID;
    /**
     * 备注
     */
    private String ps;
    /**
     * 金额
     */
    private double money;

    /**
     * 对应的FinanceBill
     */
    private FinanceBillPO financebill;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public FinanceBillPO getFinancebill() {
        return financebill;
    }

    public void setFinancebill(FinanceBillPO financebill) {
        this.financebill = financebill;
    }
}
