package auxiliary.stockmanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class StockInventory {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty StockNumber = new SimpleStringProperty("");
    private final SimpleStringProperty AveragePrice = new SimpleStringProperty("");

    public StockInventory() {
        this("", "","");
    }

    public StockInventory(String Name, String StockNumber, String Price) {
        setName(Name);
        setStockNumber(StockNumber);
        setAveragePrice(Price);
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

}
