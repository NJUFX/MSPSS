package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private final SimpleStringProperty Name = new SimpleStringProperty("");
	private final SimpleStringProperty Id = new SimpleStringProperty("");
	private final SimpleStringProperty Type = new SimpleStringProperty("");
	private final SimpleStringProperty Category = new SimpleStringProperty("");
	private final SimpleStringProperty Level = new SimpleStringProperty("");
	private final SimpleStringProperty DAE = new SimpleStringProperty("");
	private final SimpleStringProperty ReceivableLimit = new SimpleStringProperty("");

	public Customer(String id, String Name, String category, String level, String receivableLimit, String DAE) {
		setName(Name);
		setId(id);
		setCategory(category);
		setLevel(level);
		setDAE(DAE);
		setReceivableLimit(receivableLimit);
	}

	public void setType(String fName) {
		Type.set(fName);
	}

	public Customer() {
		this("", "", "", "", "", "");
	}

	public String getName() {
		return Name.get();
	}

	public void setName(String fName) {
		Name.set(fName);
	}

	public String getId() {
		return Id.get();
	}

	public void setId(String fName) {
		Id.set(fName);
	}

	public String getCategroy() {
		return Category.get();
	}

	public void setCategory(String fName) {
		Category.set(fName);
	}

	public String getLevel() {
		return Level.get();
	}

	public void setLevel(String fName) {
		Level.set(fName);
	}

	public String getDAE() {
		return DAE.get();
	}

	public void setDAE(String fName) {
		DAE.set(fName);
	}

	public String getReceivableLimit() {
		return ReceivableLimit.get();
	}

	public void setReceivableLimit(String fName) {
		ReceivableLimit.set(fName);
	}
}
