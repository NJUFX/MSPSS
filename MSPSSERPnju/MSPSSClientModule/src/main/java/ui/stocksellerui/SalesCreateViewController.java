package ui.stocksellerui;

import auxiliary.*;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.SalesmanBillBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserInfo;
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
import util.BillStatus;
import util.Kind_Of_Users;
import util.ResultMessage;
import util.SalesOutBillType;
import vo.CustomerVO;
import vo.SalesItemVO;
import vo.SalesOutBillVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class SalesCreateViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();
    CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
    SalesmanBillBLService salesmanBillBLService = new BLFactoryImpl().getSalesmanBillBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    CustomerVO customerVO;
    static ArrayList<PromotionBySales> promotionBySalesList;
    ArrayList<SalesItemVO> commodityVOArrayList = new ArrayList<>();

    SalesOutBillVO salesOutBillVO = new SalesOutBillVO(null, SalesOutBillType.OUT, BillStatus.commit);

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
    TextField nameField, idField, typeField, numberField, remarkField, SalesDiscountField, VoucherField, customerField, stockField;
    @FXML
    Label rowtotalLabel, priceLabel, TotalBeforeLabel, PromotionDiscountLabel, TotalAfterLabel, DAELabel;
    @FXML
    TableView<SalesBill> commodityListView;
    @FXML
    TableColumn<SalesBill, String> NameCol, IdCol, NumberCol, RemarkCol, RowTotalCol, PriceCol, TypeCol;
    @FXML
    TableColumn<SalesBill, CheckBox> IsSelectedCol;
    @FXML
    TableView<PromotionBySales> promotionBySalesTableView;
    @FXML
    TableColumn<PromotionBySales, String> promotionTypeCol, promotionInfoCol, promotionOperCol;
    @FXML
    TextArea billRemarkArea;

    public SalesOutBillVO saveBill() {
        if (stockField.getText() == null || stockField.getText().trim().equals("") ||
                customerField.getText() == null || customerField.getText().trim().equals("")) {
            dialog.errorInfoDialog("Something null, please check your input.");
            return null;
        }

        if (commodityVOArrayList != null) {
            commodityVOArrayList.clear();
            ObservableList<SalesBill> data = commodityListView.getItems();
            for (int i = 0; i < data.size(); i++) {
                SalesItemVO salesItemVO = new SalesItemVO(commodityInfoService.getCommodity(data.get(i).getId()), Integer.parseInt(data.get(i).getNumber()), Double.parseDouble(data.get(i).getPrice()));
                commodityVOArrayList.add(salesItemVO);
            }
            salesOutBillVO.setDAE(customerVO.getDAE());
            salesOutBillVO.setStorage(stockField.getText());
            salesOutBillVO.setCustomerVO(customerVO);
            salesOutBillVO.setSumBeforeDiscount(Double.parseDouble(TotalBeforeLabel.getText()));
            salesOutBillVO.setOperator(userInfo.getUser(LoginController.getCurrentUser().getID()));
            salesOutBillVO.setSumAfterDiscount(Double.parseDouble(TotalAfterLabel.getText()));
            salesOutBillVO.setItemVOS(commodityVOArrayList);

            if (billRemarkArea.getText() != null && !billRemarkArea.getText().trim().equals("")) {
                salesOutBillVO.setPs(billRemarkArea.getText().trim());
            } else {
                salesOutBillVO.setPs("无");
            }
            return salesOutBillVO;
        } else {
            dialog.errorInfoDialog("You haven't input the commodity list.");
            return null;
        }
    }

    public void sureButtonAction(ActionEvent e) {
        if (saveBill() != null) {
            SalesOutBillVO salesOutBillVO = saveBill();
            ResultMessage re = salesmanBillBLService.saveSalesOutBill(salesOutBillVO);
            ResultMessage resultMessage = salesmanBillBLService.commitSalesOutBill(salesOutBillVO);
            if (re == ResultMessage.SUCCESS && resultMessage == ResultMessage.SUCCESS) {
                try {
                    BillCreateViewController controller = (BillCreateViewController) replaceSceneContent2(
                            "/view/stockseller/BillCreate.fxml");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                dialog.infoDialog("Commit list successfully.");
            } else {
                dialog.errorInfoDialog("Fail to commit the list.");
            }
        }
    }

    public void customerFieldAction(ActionEvent e) {
        if (customerField.getText() != null && !customerField.getText().trim().equals("")) {
            if (customerBLService.getCustomerInfo(customerField.getText().trim()) != null) {
                customerVO = customerBLInfo.getCustomerByID(customerField.getText().trim());
                DAELabel.setText(customerVO.getDAE());
            } else {
                dialog.errorInfoDialog("Supplier not exist!");
            }
        }
    }


    public boolean isNumber(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void VoucherDiscountFieldAction(ActionEvent e) {
        if (isNumber(VoucherField.getText().trim()) == false) {
            dialog.errorInfoDialog("Voucher is not correct");
            return;
        }
        TotalAfterLabel.setText(TotalBeforeLabel.getText());
        boolean b1 = false, b2 = false, b3 = false;
        if (SalesDiscountField.getText() != null && isNumber(SalesDiscountField.getText().trim()) == true) {
            b1 = true;
        }
        if (PromotionDiscountLabel.getText() != null && isNumber(PromotionDiscountLabel.getText().trim())) {
            b2 = true;
        }
        if (VoucherField.getText() != null && isNumber(VoucherField.getText().trim())) {
            b3 = true;
        }
        if (b1 == true) {
            if (LoginController.getCurrentUser().getCategory() == Kind_Of_Users.StockSellerManager) {
                if (Double.parseDouble(SalesDiscountField.getText().trim()) > 5000) {
                    dialog.errorInfoDialog("Discount beyond operator's limit.");
                } else {
                    TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(SalesDiscountField.getText().trim()))));
                }
            } else {
                if (Double.parseDouble(SalesDiscountField.getText().trim()) > 1000) {
                    dialog.errorInfoDialog("Discount beyond operator's limit.");
                } else {
                    TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(SalesDiscountField.getText().trim()))));
                }
            }
        }
        if (b2 == true) {
            TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(PromotionDiscountLabel.getText().trim()))));
        }
        if (b3 == true) {
            TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(VoucherField.getText().trim()))));
        }
    }

    public void SalesDiscountFieldAction(ActionEvent e) {
        if (isNumber(SalesDiscountField.getText().trim()) == false) {
            dialog.errorInfoDialog("Sales discount is not correct");
            return;
        }
        boolean b1 = false, b2 = false, b3 = false;
        TotalAfterLabel.setText(TotalBeforeLabel.getText());
        if (SalesDiscountField.getText() != null && isNumber(SalesDiscountField.getText().trim()) == true) {
            b1 = true;
        }
        if (PromotionDiscountLabel.getText() != null && isNumber(PromotionDiscountLabel.getText().trim())) {
            b2 = true;
        }
        if (VoucherField.getText() != null && isNumber(VoucherField.getText().trim())) {
            b3 = true;
        }
        if (b1 == true) {
            if (LoginController.getCurrentUser().getCategory() == Kind_Of_Users.StockSellerManager) {
                if (Double.parseDouble(SalesDiscountField.getText().trim()) > 5000) {
                    dialog.errorInfoDialog("Discount beyond operator's limit.");
                } else {
                    TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(SalesDiscountField.getText().trim()))));
                }
            } else {
                if (Double.parseDouble(SalesDiscountField.getText().trim()) > 1000) {
                    dialog.errorInfoDialog("Discount beyond operator's limit.");
                } else {
                    TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(SalesDiscountField.getText().trim()))));
                }
            }
        }
        if (b2 == true) {
            TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(PromotionDiscountLabel.getText().trim()))));
        }
        if (b3 == true) {
            TotalAfterLabel.setText(String.valueOf(Math.max(0, Double.parseDouble(TotalAfterLabel.getText().trim()) - Double.parseDouble(VoucherField.getText().trim()))));
        }
    }


    public void showPromotionTable() {
        promotionTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        promotionInfoCol.setCellValueFactory(new PropertyValueFactory<>("Information"));
        promotionOperCol.setCellFactory((col) -> {
            TableCell<PromotionBySales, String> cell = new TableCell<PromotionBySales, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button Btn = new Button("删除");
                        Btn.setPrefSize(80, 10);
                        Btn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(Btn);
                        Btn.setOnMouseClicked((me) -> {
                            if (this.getTableView().getItems().get(this.getIndex()).customerPromotionVO != null) {
                                salesmanBillBLService.unSetCustomerPromotion(this.getTableView().getItems().get(this.getIndex()).customerPromotionVO, salesOutBillVO);
                                PromotionDiscountLabel.setText(String.valueOf(Double.parseDouble(PromotionDiscountLabel.getText()) - this.getTableView().getItems().get(this.getIndex()).DiscountMoney));
                                this.getTableView().getItems().remove(this.getIndex());
                                dialog.infoDialog("Remove a promotion successfully.");
                            } else if (this.getTableView().getItems().get(this.getIndex()).grossPromotionVO != null) {
                                salesmanBillBLService.unSetGrossPromotion(this.getTableView().getItems().get(this.getIndex()).grossPromotionVO, salesOutBillVO);
                                PromotionDiscountLabel.setText(String.valueOf(Double.parseDouble(PromotionDiscountLabel.getText()) - this.getTableView().getItems().get(this.getIndex()).DiscountMoney));
                                this.getTableView().getItems().remove(this.getIndex());
                                dialog.infoDialog("Remove a promotion successfully.");
                            } else if (this.getTableView().getItems().get(this.getIndex()).groupPromotionVO != null) {
                                salesmanBillBLService.unSetGroupPromotion(this.getTableView().getItems().get(this.getIndex()).groupPromotionVO, salesOutBillVO);
                                PromotionDiscountLabel.setText(String.valueOf(Double.parseDouble(PromotionDiscountLabel.getText()) - this.getTableView().getItems().get(this.getIndex()).DiscountMoney));
                                this.getTableView().getItems().remove(this.getIndex());
                                dialog.infoDialog("Remove a promotion successfully.");
                            }
                        });
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });
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
            if (!customerField.getText().trim().equals("") && customerBLInfo.getCustomerByID(customerField.getText().trim()) != null) {
                salesOutBillVO.setCustomerVO(customerBLInfo.getCustomerByID(customerField.getText().trim()));
                salesOutBillVO.setItemVOS(commodityVOArrayList);
                salesmanBillBLService.saveSalesOutBill(salesOutBillVO);

                SelectPromotionViewController.salesOutBillVO = salesOutBillVO;
                SelectPromotionViewController.level = salesOutBillVO.getCustomerVO().getLevel();
                SelectPromotionViewController controller = (SelectPromotionViewController) replaceAnotherSceneContent("/view/stockseller/SelectPromotion.fxml", 544, 541);
                PromotionDiscountLabel.setText("0");
                controller.PromotionDiscountLabel = PromotionDiscountLabel;
                controller.TotalAfterLabel = TotalAfterLabel;

                controller.tableView = promotionBySalesTableView;
            } else {
                dialog.errorInfoDialog("Customer id is wrong.");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void numberFieldAction(ActionEvent e) {
        if (numberField.getText() != null && !numberField.getText().trim().equals("")) {
            if (isNumber(numberField.getText().trim()) == false) {
                dialog.errorInfoDialog("The number of commodity you input is not correct.");
                return;
            }
            rowtotalLabel.setText(String.valueOf(Double.parseDouble(priceLabel.getText()) * Integer.parseInt(numberField.getText().trim())));
        }
    }

    public void chooseButtonAction(ActionEvent e) {
        try {
            SelectClassOrCommodityViewController controller = (SelectClassOrCommodityViewController) replaceAnotherSceneContent(
                    "/view/stockmanager/SelectClassOrCommodity.fxml", 491, 376);
            controller.isSelectClass = false;
            controller.commodityNameField = nameField;
            controller.commodityIdField = idField;
            controller.commodityPriceLabel = priceLabel;
            controller.useType = true;
            controller.commodityTypeField = typeField;
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
            if (isNumber(numberField.getText().trim()) == false) {
                dialog.errorInfoDialog("The number of commodity you input is not correct.");
                return;
            }
            if (Integer.parseInt(numberField.getText().trim()) > commodityInfoService.getCommodity(idField.getText().trim()).getNumberInStock()) {
                dialog.errorInfoDialog("该商品系统库存为" + commodityInfoService.getCommodity(idField.getText().trim()).getNumberInStock() + '\n' + "所输入商品数量超出系统库存，请核对您的输入");
                return;
            }
            data.add(new SalesBill(nameField.getText().trim(), idField.getText().trim(), typeField.getText().trim(), priceLabel.getText().trim(), numberField.getText().trim(), rowtotalLabel.getText().trim(), re));
            if (TotalBeforeLabel.getText() != null && !TotalBeforeLabel.getText().trim().equals("")) {
                TotalBeforeLabel.setText(String.valueOf(Double.parseDouble(TotalBeforeLabel.getText().trim()) + Double.parseDouble(rowtotalLabel.getText().trim())));
            } else {
                TotalBeforeLabel.setText(rowtotalLabel.getText().trim());
            }
            if (TotalAfterLabel.getText() != null && !TotalAfterLabel.getText().trim().equals("")) {
                TotalAfterLabel.setText(String.valueOf(Double.parseDouble(TotalBeforeLabel.getText().trim()) + Double.parseDouble(rowtotalLabel.getText().trim())));
            } else {
                TotalAfterLabel.setText(rowtotalLabel.getText().trim());
            }
            nameField.setText("");
            idField.setText("");
            typeField.setText("");
            numberField.setText("");
            remarkField.setText("");
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
            SalesRetCreateViewController controller = (SalesRetCreateViewController) replaceSceneContent2("/view/stockseller/SalesRetCreate.fxml");
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
        Scene scene = new Scene(page, width, height);
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

}

