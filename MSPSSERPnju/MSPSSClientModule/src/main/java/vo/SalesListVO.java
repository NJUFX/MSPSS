package vo;

public class SalesListVO extends ListVO {
	String commodityName;
	String modelId;
	int amount;
	double unitPrice;
	double totalPrice;

	public SalesListVO(String t, String a, String b, int c, double d, double e) {
		super(t);
		commodityName = a;
		modelId = b;
		amount = c;
		unitPrice = d;
		totalPrice = e;
	}
    public String getCommodityName(){
    	return commodityName;
    }
    public String getModelId(){
    	return modelId;
    }
    public double getUnitPrice(){
    	return unitPrice;
    }
    public double getTotalPrice(){
    	return totalPrice;
    }
}
