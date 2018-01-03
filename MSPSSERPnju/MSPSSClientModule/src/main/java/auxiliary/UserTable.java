package auxiliary;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioButton;

public class UserTable {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty Category = new SimpleStringProperty("");
    private final SimpleStringProperty Power = new SimpleStringProperty("");
    private final RadioButton radioButton = new RadioButton();

    public UserTable() {
        this("", "", "", "");
    }

    public UserTable(String Id, String Name, String Category, String power) {
        setName(Name);
        setId(Id);
        setCategory(Category);
        setPower(power);
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public String getPower() {
        return Power.get();
    }

    public void setPower(String fName) {
        Power.set(fName);
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

    public String getCategory() {
        return Category.get();
    }

    public void setCategory(String fName) {
        Category.set(fName);
    }
}
