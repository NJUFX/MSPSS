package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class CommodityTable {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty Category = new SimpleStringProperty("");

    public CommodityTable() {
        this("", "", "");
    }

    public CommodityTable(String Name, String Id, String Category) {
        setName(Name);
        setId(Id);
        setCategory(Category);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }

    public String getCategory() {
        return Category.get();
    }

    public void setCategory(String fName) {
        Category.set(fName);
    }

    public String getId() {
        return Id.get();
    }

    public void setId(String fName) {
        Id.set(fName);
    }
}
