package ui.stocksellerui;

import auxiliary.GrossBySales;
import auxiliary.GroupBySales;
import blimpl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import vo.CustomerPromotionVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectPromotionViewController implements Initializable {
    PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
    PromotionBLInfo promotionBLInfo = new BLFactoryImpl().getPromotionBLInfo();
    int level = 4;

    @FXML
    Button returnButton, sureButton;
    @FXML
    Label noCustomerPromotionLabel, customerPromotionInfoLabel;
    @FXML
    Pane customerPromotionSelectPane;
    @FXML
    TableView<GrossBySales> grossView;
    @FXML
    TableView<GroupBySales> groupView;

    @FXML
    TableColumn<GrossBySales, String> GrossIdCol, GrossOperationCol;
    @FXML
    TableColumn<GroupBySales, RadioButton> GrossSelectCol;
    @FXML
    TableColumn<GroupBySales, String> GroupIdCol, GroupOperationCol;
    @FXML
    TableColumn<GroupBySales, CheckBox> GroupSelectCol;

    @FXML
    RadioButton selectRadio;

    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    public void sureButtonAction(ActionEvent e) {
        sureButton.getScene().getWindow().hide();
    }

    /**
     * 客户等级折让
     */
    void showCustomerPromotion() {

        if (promotionBLInfo.getAvailableCustomerPromotion() != null && promotionBLInfo.getAvailableCustomerPromotion().size() != 0) {
            ArrayList<CustomerPromotionVO> list = promotionBLInfo.getAvailableCustomerPromotion();
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (level >= list.get(i).getLevel())
                    sum = Math.max(sum, list.get(i).getDiscount());
            }
            customerPromotionSelectPane.setVisible(true);
            customerPromotionInfoLabel.setText("用户等级 " + level + "，可折让金额 " + sum);
            noCustomerPromotionLabel.setVisible(false);
        } else {
            noCustomerPromotionLabel.setVisible(true);
            customerPromotionSelectPane.setVisible(false);
        }
    }

    /**
     * 满减
     */
    void showGrossPromotion() {

    }

    /**
     * 特价包
     */
    void showGroupPromotion() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCustomerPromotion();
        showGrossPromotion();
        showGroupPromotion();
    }
}
