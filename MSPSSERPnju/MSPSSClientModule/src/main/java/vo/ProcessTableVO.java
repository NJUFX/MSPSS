package vo;



import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class ProcessTableVO {
    //进货退货单
    ArrayList<SalesInBillVO> salesInBillList;
    //销售单
    ArrayList<SalesOutBillVO> salesOutBillList;
    //现金费用单
    ArrayList<CashCostBillVO> cashCostBillList;
    //付款单与收款单
    ArrayList<FinanceBillVO> financeBillList;

    public ArrayList<SalesInBillVO> getSalesInBillList() {
        return salesInBillList;
    }

    public void setSalesInBillList(ArrayList<SalesInBillVO> salesInBillList) {
        this.salesInBillList = salesInBillList;
    }

    public ArrayList<SalesOutBillVO> getSalesOutBillList() {
        return salesOutBillList;
    }

    public void setSalesOutBillList(ArrayList<SalesOutBillVO> salesOutBillList) {
        this.salesOutBillList = salesOutBillList;
    }

    public ArrayList<CashCostBillVO> getCashCostBillList() {
        return cashCostBillList;
    }

    public void setCashCostBillList(ArrayList<CashCostBillVO> cashCostBillList) {
        this.cashCostBillList = cashCostBillList;
    }

    public ArrayList<FinanceBillVO> getFinanceBillList() {
        return financeBillList;
    }

    public void setFinanceBillList(ArrayList<FinanceBillVO> financeBillList) {
        this.financeBillList = financeBillList;
    }
}
