package auxiliary.stockmanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Breakage {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty SystemNumber = new SimpleStringProperty("");
    private final SimpleStringProperty RealNumber = new SimpleStringProperty("");
    private final SimpleStringProperty Remark = new SimpleStringProperty("");
    private final CheckBox IsSelected = new CheckBox();

    public Breakage() {
        this("", "", "", "", "");
    }

    public Breakage(String Id, String Name, String SystemNumber, String RealNumber, String Remark) {
        setName(Name);
        setId(Id);
        setSystemNumber(SystemNumber);
        setRealNumber(RealNumber);
        setRemark(Remark);
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

    public String getRealNumber() {
        return RealNumber.get();
    }

    public void setRealNumber(String fName) {
        RealNumber.set(fName);
    }

    public String getSystemNumber() {
        return SystemNumber.get();
    }

    public void setSystemNumber(String fName) {
        SystemNumber.set(fName);
    }

    public String getRemark() {
        return Remark.get();
    }

    public void setRemark(String fName) {
        Remark.set(fName);
    }
}
