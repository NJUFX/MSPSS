package auxiliary.stockmanager;

import javafx.beans.property.SimpleStringProperty;

public class Presentation {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty Number = new SimpleStringProperty("");
    private final SimpleStringProperty Price = new SimpleStringProperty("");
    private final SimpleStringProperty Total = new SimpleStringProperty("");
    private final SimpleStringProperty Remark = new SimpleStringProperty("");

    public Presentation() {
        this("", "", "", "", "", "");
    }

    public Presentation(String Name, String Id, String Price, String Number, String Total, String Remark) {
        setName(Name);
        setId(Id);
        setPrice(Price);
        setNumber(Number);
        setTotal(Total);
        setRemark(Remark);
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

    public String getNumber() {
        return Number.get();
    }

    public void setNumber(String fName) {
        Number.set(fName);
    }

    public String getPrice() {
        return Price.get();
    }

    public void setPrice(String fName) {
        Price.set(fName);
    }

    public String getTotal() {
        return Total.get();
    }

    public void setTotal(String fName) {
        Total.set(fName);
    }

    public String getRemark() {
        return Remark.get();
    }

    public void setRemark(String fName) {
        Remark.set(fName);
    }
}
