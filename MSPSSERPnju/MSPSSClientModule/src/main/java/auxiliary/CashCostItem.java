package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class CashCostItem {
	private SimpleStringProperty name = new SimpleStringProperty("");
	private SimpleStringProperty sum = new SimpleStringProperty("");
	private SimpleStringProperty ps = new SimpleStringProperty("");
	

	public CashCostItem() {
		this("", "", "");
	}

	public CashCostItem(String n, String s, String p) {
		setName(n);
		setSum(s);
		setPs(p);
		
	}

	public void setName(String n) {
		// TODO Auto-generated method stub
		name.set(n);

	}

	public void setSum(String s) {
		// TODO Auto-generated method stub
		sum.set(s);
	}

	public void setPs(String p) {
		// TODO Auto-generated method stub
		ps.set(p);
	}

	public String getName() {
		return name.get();
	}

	public String getSum() {
		return sum.get();
	}

	public String getPs() {
		return ps.get();
	}

	
}
