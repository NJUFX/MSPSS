package vo;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class BusinessTableVO {
    //销售类收入
    double salesIncome;
    //商品类收入
    double commodityIncome;
    //销售成本
    double salesCost;
    //商品类成本
    double commodityCost;

    public double getSalesIncome() {
        return salesIncome;
    }

    public void setSalesIncome(double salesIncome) {
        this.salesIncome = salesIncome;
    }

    public double getCommodityIncome() {
        return commodityIncome;
    }

    public void setCommodityIncome(double commodityIncome) {
        this.commodityIncome = commodityIncome;
    }

    public double getSalesCost() {
        return salesCost;
    }

    public void setSalesCost(double salesCost) {
        this.salesCost = salesCost;
    }

    public double getCommodityCost() {
        return commodityCost;
    }

    public void setCommodityCost(double commodityCost) {
        this.commodityCost = commodityCost;
    }
}
