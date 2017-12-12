package auxiliary.stockmanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class StockInventory {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty StockNumber = new SimpleStringProperty("");
    private final SimpleStringProperty AveragePrice = new SimpleStringProperty("");
    private final SimpleStringProperty DateOfProduction = new SimpleStringProperty("");//出厂日期

    public StockInventory() {
        this("", "", "", "");
    }

    public StockInventory(String Name, String StockNumber, String Price,String Date) {
        setName(Name);
        setStockNumber(StockNumber);
        setAveragePrice(Price);
        setDateOfProduction(Date);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }

    public String getAveragePrice() {
        return AveragePrice.get();
    }

    public void setAveragePrice(String fName) {
        AveragePrice.set(fName);
    }

    public String getStockNumber() {
        return StockNumber.get();
    }

    public void setStockNumber(String fName) {
        StockNumber.set(fName);
    }

    public String getDateOfProduction() {
        return DateOfProduction.get();
    }

    public void setDateOfProduction(String fName) {
        DateOfProduction.set(fName);
    }
}
