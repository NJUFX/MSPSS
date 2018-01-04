package auxiliary;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import vo.GrossPromotionVO;
import vo.PresentationCommodityItemVO;

import java.util.ArrayList;

/**
 * date:20171/2
 * author:Jiang_Chen
 * info: used by stockseller in create SalesBill(use promotion)
 */
public class GrossBySales {
    private final SimpleDoubleProperty Voucher = new SimpleDoubleProperty(0);
    private final SimpleStringProperty ManJianInfo = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private RadioButton IsSelected = new RadioButton();
    private ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS = new ArrayList<>();
    private GrossPromotionVO grossPromotionVO = new GrossPromotionVO(0, 0, null, null);

    public GrossBySales() {
        this("", "", 0);
    }

    public GrossBySales(String id, String str, double Voucher) {
        setVoucher(Voucher);
        setId(id);
        setManJianInfo(str);
    }

    public void setGrossPromotionVO(GrossPromotionVO g) {
        this.grossPromotionVO = g;
    }

    public GrossPromotionVO getGrossPromotionVO() {
        return grossPromotionVO;
    }

    public void setPresentationCommodityItemVOS(ArrayList<PresentationCommodityItemVO> list) {
        presentationCommodityItemVOS = list;
    }

    public ArrayList<PresentationCommodityItemVO> getPresentationCommodityItemVOS() {
        return presentationCommodityItemVOS;
    }

    public RadioButton getIsSelected() {
        return IsSelected;
    }

    public String getManJianInfo() {
        return ManJianInfo.get();
    }

    public void setManJianInfo(String fName) {
        ManJianInfo.set(fName);
    }

    public String getId() {
        return Id.get();
    }

    public void setId(String fName) {
        Id.set(fName);
    }

    public Double getVoucher() {
        return Voucher.get();
    }

    public void setVoucher(double fName) {
        Voucher.set(fName);
    }
}
