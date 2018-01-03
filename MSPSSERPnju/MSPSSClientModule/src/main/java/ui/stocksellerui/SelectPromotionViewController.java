package ui.stocksellerui;

import auxiliary.GrossBySales;
import auxiliary.GroupBySales;
import auxiliary.PresentationList;
import auxiliary.PromotionBySales;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.SalesmanBillBLService;
import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import util.BillStatus;
import util.SalesOutBillType;
import vo.CustomerPromotionVO;
import vo.GrossPromotionVO;
import vo.GroupPromotionVO;
import vo.SalesOutBillVO;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.DoubleBinaryOperator;

public class SelectPromotionViewController implements Initializable {
    PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
    PromotionBLInfo promotionBLInfo = new BLFactoryImpl().getPromotionBLInfo();
    SalesmanBillBLService salesmanBillBLService = new BLFactoryImpl().getSalesmanBillBLService();
    SalesOutBillVO salesOutBillVO;
    CustomerPromotionVO customerPromotionVO;
    ArrayList<GrossPromotionVO> grossPromotionVOList;
    ArrayList<GroupPromotionVO> groupPromotionVOList;
    Stage newStage = new Stage();
    int level = 4;
    double total = 0;
    double sum = 0;

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

    Label PromotionDiscountLabel, TotalAfterLabel;

    public void returnButtonAction(ActionEvent e) {
        returnButton.getScene().getWindow().hide();
    }

    public void sureButtonAction(ActionEvent e) {
        ArrayList<PromotionBySales> list = new ArrayList<>();
        if (selectRadio.isSelected()) {
            PromotionBySales a = new PromotionBySales("等级促销", customerPromotionInfoLabel.getText());
            PromotionDiscountLabel.setText(String.valueOf(Double.parseDouble(PromotionDiscountLabel.getText()) + sum));
            salesmanBillBLService.setCustomerPromotion(customerPromotionVO, salesOutBillVO);
            list.add(a);
        }
        ObservableList<GroupBySales> groupData = groupView.getItems();
        for (int i = 0; i < groupData.size(); i++) {
            PromotionBySales b = new PromotionBySales("特价包", "编号" + groupData.get(i).getId() + " 折扣" + groupData.get(i).getDiscount());
            salesmanBillBLService.setGroupPromotion(groupData.get(i).getGroupPromotionVO(), salesOutBillVO);
            list.add(b);
        }
        ObservableList<GrossBySales> grossData = grossView.getItems();
        for (int i = 0; i < grossData.size(); i++) {
            PromotionBySales c = new PromotionBySales("满减", "编号" + grossData.get(i).getId() + " " + grossData.get(i).getManJianInfo() + " 赠送代金券" + grossData.get(i).getVoucher());
            PromotionDiscountLabel.setText(String.valueOf(Double.parseDouble(PromotionDiscountLabel.getText()) + grossData.get(i).getVoucher()));
            salesmanBillBLService.setGrossPromotion(grossData.get(i).getGrossPromotionVO(), salesOutBillVO);
            list.add(c);
        }
        SalesCreateViewController.promotionBySalesList = list;
        TotalAfterLabel.setText(String.valueOf(Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(PromotionDiscountLabel.getText().trim())));
        sureButton.getScene().getWindow().hide();
    }

    /**
     * 客户等级折让
     */
    void showCustomerPromotion() {
        if (promotionBLInfo.getAvailableCustomerPromotion() != null && promotionBLInfo.getAvailableCustomerPromotion().size() != 0) {
            ArrayList<CustomerPromotionVO> list = promotionBLInfo.getAvailableCustomerPromotion();
            for (int i = 0; i < list.size(); i++) {
                if (level >= list.get(i).getLevel()) {
                    sum = Math.max(sum, list.get(i).getDiscount());
                    customerPromotionVO = list.get(i);
                }
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
                                PresentationListShowViewController.presentationList = getTableView().getItems().get(this.getIndex()).getPresentationCommodityItemVOS();
                                PresentationListShowViewController controller = (PresentationListShowViewController) replaceAnotherSceneContent("/view/stockseller/PresentationListShow", 292, 326);
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
                    String manJian = "满" + list.get(i).getTotal() + "减" + list.get(i).getVoucher();
                    GrossBySales grossBySales = new GrossBySales(id, manJian, voucher);
                    grossBySales.setPresentationCommodityItemVOS(list.get(i).getPresentationCommodityItemVOS());
                    grossBySales.setGrossPromotionVO(list.get(i));
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
                groupBySales.setGroupPromotionVO(list.get(i));
                data.add(groupBySales);
            }
        }
        System.out.println("Group");
    }

    private Initializable replaceAnotherSceneContent(String fxml, double width, double height) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, width, height);
        newStage.setTitle("MSPSS");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCustomerPromotion();
        showGrossPromotion();
        showGroupPromotion();
    }
}
