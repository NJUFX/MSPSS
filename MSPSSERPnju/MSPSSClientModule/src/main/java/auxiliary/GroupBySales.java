package auxiliary;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import jdk.nashorn.internal.objects.annotations.Setter;
import vo.GroupPromotionVO;

/**
 * date:20171/2
 * author:Jiang_Chen
 * info: used by stockseller in create SalesBill(use promotion)
 */
public class GroupBySales {
    private final SimpleDoubleProperty Discount = new SimpleDoubleProperty(1);
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private GroupPromotionVO groupPromotionVO = new GroupPromotionVO(0,null,null,null);
    private CheckBox IsSelected = new CheckBox();

    public GroupBySales() {
        this("", 1);
    }

    public GroupBySales(String id, double discount) {
        setDiscount(discount);
        setId(id);
    }

    public GroupPromotionVO getGroupPromotionVO() {
        return groupPromotionVO;
    }
    public void setGroupPromotionVO(GroupPromotionVO g){
        this.groupPromotionVO = g;
    }

    public CheckBox getIsSelected() {
        return IsSelected;
    }

    public String getId() {
        return Id.get();
    }

    public void setId(String fName) {
        Id.set(fName);
    }

    public Double getDiscount() {
        return Discount.get();
    }

    public void setDiscount(double fName) {
        Discount.set(fName);
    }
}
