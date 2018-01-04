package ui.stocksellerui;

import auxiliary.PurchaseBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.SalesmanBillBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserInfo;
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
import util.ResultMessage;
import util.SalesInBillType;
import util.SalesOutBillType;
import vo.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class SalesRetCreateViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    SalesmanBillBLService salesmanBillBLService = new BLFactoryImpl().getSalesmanBillBLService();
    CommodityInfoService commodityInfoService = new BLFactoryImpl().getCommodityInfoService();
    CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    Stage newStage = new Stage();
    CustomerVO customerVO;
    ArrayList<SalesItemVO> commodityVOArrayList = new ArrayList<>();
    @FXML
    Button purchaseCreateButton;
    @FXML
    Button salesCreateButton;
    @FXML
    Button purcRetCreateButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button cancelButton;
    @FXML
    Button delRowButton, addRowButton, sureButton, chooseButton, saveButton;
    @FXML
    TableView<PurchaseBill> purchaseBillTableView;
    @FXML
    TableColumn<PurchaseBill, String> IdCol, NameCol, TypeCol, PriceCol, NumberCol, RemarkCol, TotalCol;
    @FXML
    TableColumn<PurchaseBill, ComboBox> IsSelectCol;
    @FXML
    TextField nameField, idField, remarkField, numberField, billSupplierField, stockField;
    @FXML
    Label priceLabel, totalLabel, billTotalMoney, billIdLabel, DAELabel;
    @FXML
    TextField typeField;
    @FXML
    TextArea billRemarkArea;

    public SalesOutBillVO saveBill() {
        if (stockField.getText() == null || stockField.getText().trim().equals("") ||
                billSupplierField.getText() == null || billSupplierField.getText().trim().equals("")) {
            dialog.errorInfoDialog("Something null, please check your input.");
            return null;
        }
        if (commodityVOArrayList != null) {
            ObservableList<PurchaseBill> data = purchaseBillTableView.getItems();
            for (int i = 0; i < data.size(); i++) {
                SalesItemVO salesItemVO = new SalesItemVO(commodityInfoService.getCommodity(data.get(i).getId()), Integer.parseInt(data.get(i).getNumber()), Double.parseDouble(data.get(i).getPrice()));
                commodityVOArrayList.add(salesItemVO);
            }

            SalesOutBillVO SalesOutBillVO = new SalesOutBillVO(null, SalesOutBillType.RETURN, BillStatus.commit);

            SalesOutBillVO.setDAE(DAELabel.getText());
            SalesOutBillVO.setStorage(stockField.getText());
            SalesOutBillVO.setCustomerVO(customerBLInfo.getCustomerByID(billSupplierField.getText()));
            System.out.println(customerVO.getID()+"bill");
            SalesOutBillVO.setOperator(userInfo.getUser(LoginController.getCurrentUser().getID()));
            SalesOutBillVO.setSumAfterDiscount(Double.parseDouble(billTotalMoney.getText()));
            SalesOutBillVO.setItemVOS(commodityVOArrayList);
            if (billRemarkArea.getText() != null && !billRemarkArea.getText().trim().equals("")) {
                SalesOutBillVO.setPs(billRemarkArea.getText().trim());
            } else {
                SalesOutBillVO.setPs("无");
            }
            return SalesOutBillVO;
        } else {
            dialog.errorInfoDialog("You haven't input the commodity list.");
            return null;
        }
    }

    public void saveButtonAction(ActionEvent e) {
        if (saveBill() != null) {
            SalesOutBillVO salesOutBillVO = saveBill();
            ResultMessage resultMessage = salesmanBillBLService.saveSalesOutBill(salesOutBillVO);
            ResultMessage re2 = salesmanBillBLService.commitSalesOutBill(salesOutBillVO);
            if (resultMessage == ResultMessage.SUCCESS&&re2==ResultMessage.SUCCESS) {
                dialog.infoDialog("Commit list successfully.");
                try {
                    BillCreateViewController controller = (BillCreateViewController) replaceSceneContent2(
                            "/view/stockseller/BillCreate.fxml");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                dialog.errorInfoDialog("Fail to commit the list.");
            }
        }
    }

    public void sureButtonAction(ActionEvent e) {
        if (saveBill() != null) {
            SalesOutBillVO salesOutBillVO = saveBill();
            ResultMessage resultMessage = salesmanBillBLService.saveSalesOutBill(salesOutBillVO);
            ResultMessage re2 = salesmanBillBLService.commitSalesOutBill(salesOutBillVO);
            if (resultMessage == ResultMessage.SUCCESS&&re2==ResultMessage.SUCCESS) {
                dialog.infoDialog("Commit list successfully.");
                try {
                    BillCreateViewController controller = (BillCreateViewController) replaceSceneContent2(
                            "/view/stockseller/BillCreate.fxml");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                dialog.errorInfoDialog("Fail to commit the list.");
            }
        }
    }

    @FXML
    public void idFieldAction(ActionEvent e){
        CommodityVO commodityVO = commodityInfoService.getCommodity(idField.getText().trim());
        nameField.setText(commodityVO.getName());
        priceLabel.setText(String.valueOf(commodityVO.getImportCost()));
        typeField.setText(commodityVO.getType());

    }

    public void billSupplierFieldAction(ActionEvent e) {
        if (billSupplierField.getText() != null && !billSupplierField.getText().trim().equals("")) {
            customerVO = customerBLInfo.getCustomerByID(billSupplierField.getText().trim());
            if (customerVO != null) {
                DAELabel.setText(customerVO.getDAE());
            } else {
                dialog.errorInfoDialog("Supplier not exist!");
            }
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
            controller.useType = true;
            controller.commodityTypeField = typeField;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void showTableView() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        TotalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));
        RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));
        IsSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
    }

    @FXML
    public void numberFieldAction(ActionEvent e) {
        totalLabel.setText(
                String.valueOf(Double.parseDouble(priceLabel.getText()) * Double.parseDouble(numberField.getText())));
    }

    /**
     * 向库存赠送单列表添加一条信息
     *
     * @param e
     */
    @FXML
    public void addRowButtonAction(ActionEvent e) {
        ObservableList<PurchaseBill> data = purchaseBillTableView.getItems();
        if (nameField.getText() != null && !nameField.getText().trim().equals("") && idField.getText() != null && !idField.getText().trim().equals("0") && priceLabel.getText() != null
                && (numberField.getText().trim() != null && !numberField.getText().trim().equals("0"))) {
            data.add(new PurchaseBill(nameField.getText(), idField.getText(), typeField.getText().trim(),
                    priceLabel.getText(), numberField.getText(), totalLabel.getText(), remarkField.getText()));
            if (billTotalMoney.getText() != null) {
                billTotalMoney.setText(String.valueOf(
                        Double.parseDouble(billTotalMoney.getText()) + Double.parseDouble(totalLabel.getText())));
            } else {
                billTotalMoney.setText(totalLabel.getText());
            }
            nameField.setText("");
            idField.setText("");
            priceLabel.setText("");
            numberField.setText("");
            totalLabel.setText("");
            remarkField.setText("");
            typeField.setText("");

        } else {
            dialog.errorInfoDialog("Something null! Please check your input.");
        }
    }

    /**
     * 删除选中行元素
     *
     * @param e
     */
    @FXML
    public void delRowButtonAction(ActionEvent e) {
        ObservableList<PurchaseBill> data = purchaseBillTableView.getItems();
        // System.out.println("test");
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIsSelected().isSelected()) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getIsSelected().isSelected()) {
                    String totalOfRow = data.get(j).getTotal();
                    data.remove(j);
                    billTotalMoney.setText(String
                            .valueOf(Double.parseDouble(billTotalMoney.getText()) - Double.parseDouble(totalOfRow)));
                }
            }
        }
        dialog.infoDialog("Delete all selected successfully!");
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
     * 销售单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void salesCreateButtonAction(ActionEvent e) throws IOException {
        try {
            SalesCreateViewController controller = (SalesCreateViewController) replaceSceneContent("/view/stockseller/SalesCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
        Scene scene = new Scene(page, width + 0.0, height);
        newStage.setTitle("选择");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
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
        Scene scene = new Scene(page, 900, 700.00);

        stage.setScene(scene);
        stage.setResizable(false);
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
        Scene scene = new Scene(page, 900.0, 560.0);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    @FXML
    Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
        nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
        categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
        showTableView();
    }
}

