package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class Account {
	private SimpleStringProperty name = new SimpleStringProperty("");
	private SimpleStringProperty money = new SimpleStringProperty("");
	

	public Account() {
		this("", "");
	}

	public Account(String n, String m) {
		setName(n);
		setMoney(m);
		
	}

	public void setName(String n) {
		// TODO Auto-generated method stub
		name.set(n);

	}

	public void setMoney(String m) {
		// TODO Auto-generated method stub
		money.set(m);
	}

	
	public String getName() {
		return name.get();
	}

	public String getMoney() {
		return money.get();
	}



}
