package auxiliary;

import javafx.beans.property.SimpleStringProperty;

public class PromotionBySales {
    private final SimpleStringProperty Type = new SimpleStringProperty("");
    private final SimpleStringProperty Information = new SimpleStringProperty("");
    
    public String getType() {
        return Type.get();
    }

    public void setType(String fType) {
        Type.set(fType);
    }

    public String getInformation() {
        return Information.get();
    }

    public void setInformation(String fType) {
        Information.set(fType);
    }
}