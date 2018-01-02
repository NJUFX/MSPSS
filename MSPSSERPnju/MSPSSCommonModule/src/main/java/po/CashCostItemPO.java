package po;

import java.io.Serializable;
import po.CashCostBillPO;
/**
 * Description:
 * Created by Hanxinhu at 19:31 2017/11/28/028
 */
public class CashCostItemPO implements Serializable {
    /**
     * 主键，切勿自己赋值！！！数据库会自动赋值，无需初始化
     */
    private int id;
    /**
     * 条目名
     */
    private String name;
    /**
     * 备注
     */
    private String ps;
    /**
     * 金额
     */
    private double money;

    /**
     *所属的cashcostbill
     */
    private CashCostBillPO cashcostbill;

    public CashCostItemPO() {
    }

    public CashCostItemPO(String name, String ps, double money) {
        this.name = name;
        this.ps = ps;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CashCostBillPO getCashcostbill() {
        return cashcostbill;
    }

    public void setCashcostbill(CashCostBillPO cashcostbill) {
        this.cashcostbill = cashcostbill;
    }
}
