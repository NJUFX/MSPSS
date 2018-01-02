package ui.stocksellerui;

import auxiliary.Presentation;
import auxiliary.PromotionBySales;
import auxiliary.SalesBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
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
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import ui.stockmanagerui.SelectClassOrCommodityViewController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class SalesCreateViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();
    @FXML
    Button purchaseCreateButton;
    @FXML
    Button purcRetCreateButton;
    @FXML
    Button salesRetCreateButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button cancelButton, sureButton, chooseButton, choosePromotionButton;
    @FXML
    TextField nameField, idField, typeField, numberField, remarkField, SalesDiscountField, VoucherField;
    @FXML
    TextArea salesRemarkArea;
    @FXML
    Label rowtotalLabel, priceLabel, TotalBeforeLabel, PromotionDiscountLabel, TotalAfterLabel;
    @FXML
    TableView<SalesBill> commodityListView;
    @FXML
    TableColumn<SalesBill, String> NameCol, IdCol, NumberCol, RemarkCol, RowTotalCol, PriceCol, TypeCol;
    @FXML
    TableColumn<SalesBill, CheckBox> IsSelectedCol;
    @FXML
    TableView<PromotionBySales> promotionBySalesTableView;
    @FXML
    TableColumn<PromotionBySales, String> promotionTypeCol, promotionInfoCol;
    /*
    @FXML
    TableView<Information> informationTableView;
    @FXML
    TableColumn<Information, Double> TotalBeforeCol, TotalAfterCol, TotalVoucherCol, DiscountBySalesCol, DiscountByPromotionCol;

    public void showInformationTable() {
        TotalBeforeCol.setCellValueFactory(new PropertyValueFactory<>("TotalBefore"));
        TotalAfterCol.setCellValueFactory(new PropertyValueFactory<>("TotalAfter"));
        TotalVoucherCol.setCellValueFactory(new PropertyValueFactory<>("TotalVoucher"));
        DiscountBySalesCol.setCellValueFactory(new PropertyValueFactory<>("DiscountBySales"));
        DiscountByPromotionCol.setCellValueFactory(new PropertyValueFactory<>("DiscountByPromotion"));
    }
    */

    public void showPromotionTable() {
        promotionTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        promotionInfoCol.setCellValueFactory(new PropertyValueFactory<>("Information"));
    }

    public void showCommodityTable() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        RowTotalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));
        IsSelectedCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
    }


    public void choosePromotionButtonAction(ActionEvent e) {
        try {
            SelectPromotionViewController controller = (SelectPromotionViewController) replaceAnotherSceneContent("/view/stockseller/SelectPromotion.fxml", 544, 541);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void numberFieldAction(ActionEvent e) {
        if (numberField.getText() != null && !numberField.getText().trim().equals("")) {
            for (int i = 0; i < numberField.getText().trim().length(); i++) {
                if (!Character.isDigit(numberField.getText().trim().charAt(i))) {
                    dialog.errorInfoDialog("Number's format is not correct.");
                    return;
                }
            }
          rowtotalLabel.setText(String.valueOf(Double.parseDouble(priceLabel.getText()) * Integer.parseInt(numberField.getText().trim())));
        }
    }

    public void chooseButtonAction(ActionEvent e) {
        try {
            SelectClassOrCommodityViewController controller = (SelectClassOrCommodityViewController) replaceAnotherSceneContent(
                    "/view/stockmanager/SelectClassOrCommodity.fxml", 491, 376);
            controller.isSelectClass = true;
            controller.commodityNameField = nameField;
            controller.commodityIdField = idField;
            controller.commodityPriceLabel = priceLabel;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    public void delRowButtonAction(ActionEvent e) {
        ObservableList<SalesBill> data = commodityListView.getItems();
        if (data.size() == 0) {
            dialog.errorInfoDialog("Nothing in the table.");
            return;
        }
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIsSelected().isSelected()) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getIsSelected().isSelected()) {
                    data.remove(j);
                }
                if (TotalBeforeLabel.getText() != null && !TotalBeforeLabel.getText().trim().equals("")) {
                    TotalBeforeLabel.setText(String.valueOf(Double.parseDouble(TotalBeforeLabel.getText().trim()) - Double.parseDouble(data.get(i).getTotal())));
                } else {
                    TotalBeforeLabel.setText("");
                }
            }
        }
        dialog.infoDialog("Delete all selected successfully!");
    }

    public void addRowButtonAction(ActionEvent e) {
        if (nameField.getText() != null && !nameField.getText().trim().equals("") &&
                idField.getText() != null && !idField.getText().trim().equals("") &&
                typeField.getText() != null && !typeField.getText().trim().equals("") &&
                numberField.getText() != null && !numberField.getText().trim().equals("")) {
            ObservableList<SalesBill> data = commodityListView.getItems();
            String re = "";
            if (remarkField.getText() == null || remarkField.getText().trim().equals("")) {
                re = "无";
            }
            data.add(new SalesBill(nameField.getText().trim(), idField.getText().trim(), typeField.getText().trim(), priceLabel.getText().trim(), numberField.getText().trim(), rowtotalLabel.getText().trim(), re));
            if (TotalBeforeLabel.getText() != null && !TotalBeforeLabel.getText().trim().equals("")) {
                TotalBeforeLabel.setText(String.valueOf(Double.parseDouble(TotalBeforeLabel.getText().trim()) + Double.parseDouble(rowtotalLabel.getText().trim())));
            } else {
                TotalBeforeLabel.setText(rowtotalLabel.getText().trim());
            }
        } else {
            dialog.errorInfoDialog("Something null, please check your input.");
        }
    }

    /**
     * 返回上一界面
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void cancelButtonAction(ActionEvent e) throws IOException {
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent2(
                    "/view/stockseller/BillCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 返回登录界面
     *
     * @param e
     * @throws IOException
     */
    public void handleBackToLoginButtonAction(ActionEvent e) throws IOException {
        try {
            MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
            boolean b = dialog.confirmDialog("Do you want to logout?");
            if (b == true) {
                LoginController controller = (LoginController) replaceSceneContent2("/view/admin/Login.fxml");
                Log_In_Out_Status log_in_out_status = mainBLService.logout(idOfCurrentUser.getText());
                if (Log_In_Out_Status.Logout_Sucess == log_in_out_status) {
                    dialog.infoDialog("Logout successfully");
                }
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 进货单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void purchaseCreateButtonAction(ActionEvent e) throws IOException {
        try {
            PurchaseCreateViewController controller = (PurchaseCreateViewController) replaceSceneContent2("/view/stockseller/PurchaseCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 进货退货单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void purcRetCreateButtonAction(ActionEvent e) throws IOException {
        try {
            PurcRetCreateViewController controller = (PurcRetCreateViewController) replaceSceneContent2("/view/stockseller/PurcRetCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    /**
     * 销售退货单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void salesRetCreateButtonAction(ActionEvent e) throws IOException {
        try {
            SalesRetCreateViewController controller = (SalesRetCreateViewController) replaceSceneContent("/view/stockseller/SalesRetCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 用来打开fxml文件
     *
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // InputStream in =
        // Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);

        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 900.0, 700);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    private Initializable replaceSceneContent2(String fxml) throws Exception {
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
        Scene scene = new Scene(page, 900, 560.0);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
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
        Scene scene = new Scene(page, width , height);
        newStage.setTitle("MSPSS");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        showPromotionTable();
        showCommodityTable();
        //showInformationTable();
    }

    public class Information {
        private final SimpleDoubleProperty TotalBefore = new SimpleDoubleProperty(0);
        private final SimpleDoubleProperty DiscountBySales = new SimpleDoubleProperty(0);
        private final SimpleDoubleProperty TotalVoucher = new SimpleDoubleProperty(0);
        private final SimpleDoubleProperty TotalAfter = new SimpleDoubleProperty(0);
        private final SimpleDoubleProperty DiscountByPromotion = new SimpleDoubleProperty(0);

        public Information(double be, double dis, double dis2, double vou, double aft) {
            setTotalBefore(be);
            setDiscountBySales(dis);
            setDiscountByPromotion(dis);
            setTotalVoucher(vou);
            setTotalAfter(aft);
        }

        public void setTotalBefore(double f) {
            TotalBefore.set(f);
        }

        public void setTotalAfter(double f) {
            TotalAfter.set(f);
        }

        public void setTotalVoucher(double f) {
            TotalVoucher.set(f);
        }

        public void setDiscountBySales(double f) {
            DiscountBySales.set(f);
        }

        public void setDiscountByPromotion(double f) {
            DiscountByPromotion.set(f);
        }

    }
}

