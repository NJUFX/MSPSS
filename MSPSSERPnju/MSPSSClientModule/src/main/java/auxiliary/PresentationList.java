package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class PresentationList {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Number = new SimpleStringProperty("");

    public PresentationList() {
        this("", "");
    }

    public PresentationList(String na, String nu) {
        setName(na);
        setNumber(nu);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }

    public String getNumber() {
        return Number.get();
    }

    public void setNumber(String fName) {
        Number.set(fName);
    }
}
