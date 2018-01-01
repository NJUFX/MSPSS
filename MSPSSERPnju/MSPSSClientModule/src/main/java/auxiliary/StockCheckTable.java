package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class StockCheckTable {
    private final SimpleStringProperty Type = new SimpleStringProperty("");
    private final SimpleStringProperty Number = new SimpleStringProperty("");
    private final SimpleStringProperty Account = new SimpleStringProperty("");

    public StockCheckTable() {
        this("", "","");
    }

    public StockCheckTable(String Type, String Number, String Price) {
        setType(Type);
        setNumber(Number);
        setAccount(Price);
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String fType) {
        Type.set(fType);
    }

    public String getAccount() {
        return Account.get();
    }

    public void setAccount(String fType) {
        Account.set(fType);
    }

    public String getNumber() {
        return Number.get();
    }

    public void setNumber(String fType) {
        Number.set(fType);
    }
    

}
