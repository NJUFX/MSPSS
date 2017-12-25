package vo;

/**
 * Description:
 * Created by Hanxinhu at 19:18 2017/11/28/028
 */
public class CashCostItemVO {
    /**
     * 条目名
     */
    public String name;
    /**
     * 金额
     */
    public double money;
    /**
     * 备注
     *
     */
    public String ps;

    public CashCostItemVO(String name, double money, String ps) {
        this.name = name;
        this.money = money;
        this.ps = ps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
