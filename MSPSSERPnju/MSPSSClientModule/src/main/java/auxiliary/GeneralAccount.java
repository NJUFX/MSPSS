package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class GeneralAccount {
	 
	private SimpleStringProperty item = new SimpleStringProperty("");
	
	public GeneralAccount() {
		this("");
	}
	
	public GeneralAccount(String item) {
		setItem(item);
	}
	
	public void setItem(String it) {
		item.set(it);
	}
	
	public String getItem() {
		return item.get();
	}

}
