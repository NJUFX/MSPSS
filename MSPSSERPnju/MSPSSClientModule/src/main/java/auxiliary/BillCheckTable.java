package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class BillCheckTable {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty Status = new SimpleStringProperty("");

    public BillCheckTable() {
        this("", "", "");
    }

    public BillCheckTable(String id, String name, String status) {
        setId(id);
        setName(name);
        setStatus(status);
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

    public String getStatus() {
        return Status.get();
    }

    public void setStatus(String fName) {
        Status.set(fName);
    }

}
