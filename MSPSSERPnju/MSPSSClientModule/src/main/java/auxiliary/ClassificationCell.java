package auxiliary;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * author:Jiang_Chen
 * date:2017/12/14
 */
public class ClassificationCell {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Parent = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleBooleanProperty IsClass = new SimpleBooleanProperty(true);


    public ClassificationCell() {
        this("", "", "", true);
    }

    public ClassificationCell(String name, String father, String id, boolean isclass) {
        setName(name);
        setParent(father);
        setId(id);
        setIsClass(isclass);
    }

    public boolean getIsClass() {
        return IsClass.get();
    }

    public void setIsClass(boolean fName) {
        IsClass.set(fName);
    }

    public String getId() {
        return Id.get();
    }

    public void setId(String fName) {
        Id.set(fName);
    }

    public String getParent() {
        return Parent.get();
    }

    public void setParent(String fName) {
        Parent.set(fName);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }

}
