package po;


//销售类单据PO,变量不完整

public class SalesBillPO extends BillPO {
    String commodityName;
    String customerName;
    String salesmanName;
    String warehouseName;
    String modelId;
    int amount;
    double unitPrice;



    public SalesBillPO( String a,String b, String c, String d, String e,String f,int i,double k) {
        super(a);
        commodityName = b;
        customerName = c;
        salesmanName = d;
        warehouseName = e;
        modelId = f;
        amount = i;
        unitPrice = k;

    }
    public String getBillId() {
        return billId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }
    public String getModelId(){
        return modelId;
    }
    public int getAmount(){
        return amount;
    }
    public double getUnitPrice(){
        return unitPrice;
    }

}

