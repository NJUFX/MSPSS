package auxiliary;

import javafx.beans.property.SimpleStringProperty;

/**
 * author:Jiang_Chen
 * date:2017/12/14
 */
public class ClassificationCell {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Father = new SimpleStringProperty("");

    public ClassificationCell() {
        this("", "");
    }

    public ClassificationCell(String name, String father) {
        setName(name);
        setFather(father);
    }

    public String getFather() {
        return Father.get();
    }

    public void setFather(String fName) {
        Father.set(fName);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }

}
