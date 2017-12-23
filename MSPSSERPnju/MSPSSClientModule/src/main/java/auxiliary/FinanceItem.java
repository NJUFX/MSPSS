package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class FinanceItem {
	private SimpleStringProperty account = new SimpleStringProperty("");
	private SimpleStringProperty sum = new SimpleStringProperty("");
	private SimpleStringProperty ps = new SimpleStringProperty("");
	

	public FinanceItem() {
		this("", "", "");
	}

	public FinanceItem(String a, String s, String p) {
		setAccount(a);
		setSum(s);
		setPs(p);
		
	}

	public void setAccount(String a) {
		// TODO Auto-generated method stub
		account.set(a);

	}

	public void setSum(String s) {
		// TODO Auto-generated method stub
		sum.set(s);
	}

	public void setPs(String p) {
		// TODO Auto-generated method stub
		ps.set(p);
	}

	public String getAccount() {
		return account.get();
	}

	public String getSum() {
		return sum.get();
	}

	public String getPs() {
		return ps.get();
	}

	
}
