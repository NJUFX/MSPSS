package auxiliary;

import javafx.beans.property.SimpleStringProperty;

//销售明细表的数据类
public class SalesTableBill {
	private SimpleStringProperty time = new SimpleStringProperty("");
	private SimpleStringProperty commodity = new SimpleStringProperty("");
	private SimpleStringProperty type = new SimpleStringProperty();
	private SimpleStringProperty amount = new SimpleStringProperty();
	private SimpleStringProperty perPrice = new SimpleStringProperty();
	private SimpleStringProperty totalPrice = new SimpleStringProperty();
	
	
	

	public SalesTableBill() {
		this("", "", "", "","","");
	}

	public SalesTableBill(String time, String commodity, String type,String amount,String perPrice,String totalPrice) {
		setTime(time);
		setCommodity(commodity);
		setType(type);
		setAmount(amount);
		setPerPrice(perPrice);
		setTotalPrice(totalPrice);
	}


	public void setTime(String t) {
		// TODO Auto-generated method stub
		time.set(t);
	}

	public void setCommodity(String c) {
		// TODO Auto-generated method stub
		commodity.set(c);
	}

	public void setType(String i) {
		// TODO Auto-generated method stub
		type.set(i);
	}
	
	public void setAmount(String a) {
		amount.set(a);
	}
	
	public void setPerPrice(String pp) {
		perPrice.set(pp);
	}
	
	public void setTotalPrice(String tp) {
		totalPrice.set(tp);
	}
	
	public String getTime() {
		return time.get();
	}

	public String getCommodity() {
		return commodity.get();
	}
	
	
	public String getType() {
		return type.get();
	}

	public String getAmount() {
		return amount.get();
	}
	
	public String getPerPrice() {
		return perPrice.get();
	}
	
	public String getTotalPrice() {
		return totalPrice.get();
	}

}
