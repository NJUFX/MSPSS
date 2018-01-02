package ui.stocksellerui;

import auxiliary.GrossBySales;
import auxiliary.GroupBySales;
import blimpl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import vo.CustomerPromotionVO;
import vo.GrossPromotionVO;
import vo.GroupPromotionVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectPromotionViewController implements Initializable {
    PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
    PromotionBLInfo promotionBLInfo = new BLFactoryImpl().getPromotionBLInfo();
    int level = 4;
    double total = 0;

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
    TableColumn<GrossBySales, String> GrossIdCol, GrossOperationCol, GrossVoucherCol, GrossManJianCol;
    @FXML
    TableColumn<GroupBySales, RadioButton> GrossSelectCol;
    @FXML
    TableColumn<GroupBySales, String> GroupIdCol, GroupOperationCol, GroupDiscountCol;
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
        GrossManJianCol.setCellValueFactory(new PropertyValueFactory<>("ManJian"));
        GrossIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        GrossSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
        GrossVoucherCol.setCellValueFactory(new PropertyValueFactory<>("Voucher"));
        GrossSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
        GrossOperationCol.setCellFactory((col) -> {
            TableCell<GrossBySales, String> cell = new TableCell<GrossBySales, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button Btn = new Button("查看");
                        Btn.setPrefSize(80, 10);
                        Btn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(Btn);
                        Btn.setOnMouseClicked((me) -> {
                            try {

                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        });
                    }
                }
            };
            return cell;
        });
        ObservableList<GrossBySales> data = grossView.getItems();
        if (promotionBLInfo.getAvailableGrossPromotion() != null && promotionBLInfo.getAvailableGrossPromotion().size() != 0) {
            ArrayList<GrossPromotionVO> list = promotionBLInfo.getAvailableGrossPromotion();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTotal() <= total) {
                    String id = list.get(i).getId();
                    double voucher = list.get(i).getVoucher();
                    String manJian = "";
                    GrossBySales grossBySales = new GrossBySales(id, manJian, voucher);
                    data.add(grossBySales);
                }
            }
        }
        System.out.println("Gross");
    }

    /**
     * 特价包
     */
    void showGroupPromotion() {
        GroupDiscountCol.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        GroupIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        GroupOperationCol.setCellFactory((col) -> {
            TableCell<GroupBySales, String> cell = new TableCell<GroupBySales, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button Btn = new Button("查看");
                        Btn.setPrefSize(80, 10);
                        Btn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(Btn);
                        Btn.setOnMouseClicked((me) -> {
                            try {
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        });
                    }
                }
            };
            return cell;
        });
        GroupSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
        ObservableList<GroupBySales> data = groupView.getItems();
        if (promotionBLInfo.getAvailableGroupPromotion() != null && promotionBLInfo.getAvailableGroupPromotion().size() != 0) {
            ArrayList<GroupPromotionVO> list = promotionBLInfo.getAvailableGroupPromotion();
            for (int i = 0; i < list.size(); i++) {
                String id = list.get(i).getId();
                double discount = list.get(i).getDiscountRate();
                GroupBySales groupBySales = new GroupBySales(id, discount);
                data.add(groupBySales);
            }
        }
        System.out.println("Group");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCustomerPromotion();
        showGrossPromotion();
        showGroupPromotion();
    }
}
