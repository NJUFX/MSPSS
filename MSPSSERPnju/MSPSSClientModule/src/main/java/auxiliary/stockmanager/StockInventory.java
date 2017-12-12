package auxiliary.stockmanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class StockInventory {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty StockNumber = new SimpleStringProperty("");
    private final SimpleStringProperty AveragePrice = new SimpleStringProperty("");
    private final SimpleStringProperty Batch = new SimpleStringProperty("");//批次
    private final SimpleStringProperty BatchNumber = new SimpleStringProperty(""); //批号
    private final SimpleStringProperty DateOfProduction = new SimpleStringProperty("");//出厂日期

    public StockInventory() {
        this("", "", "", "", "", "");
    }

    public StockInventory(String Name, String StockNumber, String Price, String Batch, String BatchNumber, String Date) {
        setName(Name);
        setStockNumber(StockNumber);
        setAveragePrice(Price);
        setBatch(Batch);
        setBatchNumber(BatchNumber);
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

    public String getBatch() {
        return Batch.get();
    }

    public void setBatch(String fName) {
        Batch.set(fName);
    }

    public String getBatchNumber() {
        return BatchNumber.get();
    }

    public void setBatchNumber(String fName) {
        BatchNumber.set(fName);
    }

    public String getDateOfProduction() {
        return DateOfProduction.get();
    }

    public void setDateOfProduction(String fName) {
        DateOfProduction.set(fName);
    }
}
