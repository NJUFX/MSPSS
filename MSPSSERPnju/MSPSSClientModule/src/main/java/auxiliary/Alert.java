package auxiliary;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Alert {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty AlertNumber = new SimpleStringProperty("");
    private final SimpleStringProperty StockNumber = new SimpleStringProperty("");
    private final CheckBox IsSelected = new CheckBox();

    public Alert() {
        this("", "", "", "");
    }

    public Alert(String Id, String Name, String AlertNumber, String StockNumber) {
        setName(Name);
        setId(Id);
        setAlertNumber(AlertNumber);
        setStockNumber(StockNumber);
    }

    public CheckBox getIsSelected() {
        return IsSelected;
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

    public String getStockNumber() {
        return StockNumber.get();
    }

    public void setStockNumber(String fName) {
        StockNumber.set(fName);
    }

    public String getAlertNumber() {
        return AlertNumber.get();
    }

    public void setAlertNumber(String fName) {
        AlertNumber.set(fName);
    }
}
