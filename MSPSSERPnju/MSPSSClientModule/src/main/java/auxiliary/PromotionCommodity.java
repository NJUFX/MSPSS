package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class PromotionCommodity {
	private SimpleStringProperty commodity = new SimpleStringProperty("");
	private SimpleStringProperty sum = new SimpleStringProperty("");
	
	public PromotionCommodity() {
		this("","");
	}
	
	public PromotionCommodity(String com,String sum) {
		setCommodity(com);
		setSum(sum);
	}
	
	public void setCommodity(String com) {
		commodity.set(com);
	}
	
	public String getCommodity() {
		return commodity.get();
	}
	
	public void setSum(String s) {
		sum.set(s);
	}
	
	public String getSum() {
		return sum.get();
	}

}
