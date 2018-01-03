package ui.stocksellerui;

import auxiliary.BillCheckTable;
import auxiliary.SalesInBill;
import auxiliary.SalesOutBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.SalesmanBillBLService;
import blservice.mainblservice.MainBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.BillStatus;
import util.SalesInBillType;
import util.SalesOutBillType;
import util.SalesInBillType;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillStatusCheckViewController implements Initializable {

    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    SalesmanBillBLService salesmanBillBLService = new BLFactoryImpl().getSalesmanBillBLService();
    @FXML
    Button customerManageButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button backButton;
    //@FXML
    @FXML
    ComboBox<String> statusScreenBox, typeScreenBox;

    @FXML
    TableView<BillCheckTable> tableTableView;
    @FXML
    TableColumn<BillCheckTable, String> SerialCol, IdCol, NameCol, StatusCol, OperationCol;

    @FXML
    public void screenBoxAction(ActionEvent e) {
        tableTableView.getItems().clear();
        addPurchaseBillRow();
        addPurcRetBillRow();
        addSalesBillRow();
        addSalesRetBill();

        typeScreen();
        statusScreen();

    }

    public void typeScreen() {
        ObservableList<BillCheckTable> data = tableTableView.getItems();
        if (typeScreenBox.getValue() != null && !typeScreenBox.getValue().equals("全部单据")) {
            int size = data.size();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < data.size(); j++) {
                    if (!data.get(j).getName().equals(typeScreenBox.getValue())) {
                        data.remove(j);
                    }
                }
            }
        }
    }

    public void statusScreen() {
        ObservableList<BillCheckTable> data = tableTableView.getItems();
        int size = data.size();
        if (statusScreenBox.getValue() == null || statusScreenBox.getValue().equals("全部状态")) {
            return;
        } else if (statusScreenBox.getValue().equals("已保存")) {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < data.size(); i++) {
                    if (!data.get(i).getStatus().equals("已保存")) {
                        data.remove(i);
                    }
                }
            }
        } else if (statusScreenBox.getValue().equals("已提交")) {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < data.size(); i++) {
                    if (!data.get(i).getStatus().equals("已提交")) {
                        data.remove(i);
                    }
                }
            }
        } else if (statusScreenBox.getValue().equals("已审批")) {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < data.size(); i++) {
                    if (!(data.get(i).getStatus().equals("审批通过") || data.get(i).getStatus().equals("审批未通过"))) {
                        data.remove(i);
                    }
                }
            }
        } else if (statusScreenBox.getValue().equals("审批通过")) {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < data.size(); i++) {
                    if (!(data.get(i).getStatus().equals("审批通过"))) {
                        data.remove(i);
                    }
                }
            }
        } else if (statusScreenBox.getValue().equals("审批未通过")) {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < data.size(); i++) {
                    if (!(data.get(i).getStatus().equals("审批未通过"))) {
                        data.remove(i);
                    }
                }
            }
        }
    }


    public void showTableView() {

        SerialCol.setCellFactory((col) -> {
            TableCell<BillCheckTable, String> cell = new TableCell<BillCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        int rowIndex = this.getIndex() + 1;
                        this.setText(String.valueOf(rowIndex));
                    }
                }
            };
            return cell;
        });

        IdCol.setCellFactory(col -> {
            TableCell<BillCheckTable, String> cell = new TableCell<BillCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        String id = this.getTableView().getItems().get(this.getIndex()).getId();
                        this.setText(String.valueOf(id));
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });

        NameCol.setCellFactory(col -> {
            TableCell<BillCheckTable, String> cell = new TableCell<BillCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        String name = this.getTableView().getItems().get(this.getIndex()).getName();
                        this.setText(String.valueOf(name));
                        if (name.equals("进货单")) {
                            this.setTextFill(Color.rgb(0, 102, 153));
                        } else if (name.equals("进货退货单")) {
                            this.setTextFill(Color.rgb(255, 204, 0));
                        } else if (name.equals("销售单")) {
                            this.setTextFill(Color.rgb(204, 51, 51));
                        } else if (name.equals("销售退货单")) {
                            this.setTextFill(Color.rgb(204, 111, 180));
                        }
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });

        StatusCol.setCellFactory(col -> {
            TableCell<BillCheckTable, String> cell = new TableCell<BillCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        String name = this.getTableView().getItems().get(this.getIndex()).getStatus();
                        this.setText(String.valueOf(name));
                        if (name.equals("已提交")) {
                            this.setTextFill(Color.rgb(0, 102, 153));
                        } else if (name.equals("审批通过")) {
                            this.setTextFill(Color.rgb(51, 200, 51));
                        } else if (name.equals("审批未通过")) {
                            this.setTextFill(Color.rgb(230, 18, 6));
                        }
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });

        OperationCol.setCellFactory((col) -> {
            TableCell<BillCheckTable, String> cell = new TableCell<BillCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button Btn = new Button("打开");
                        Btn.setPrefSize(80, 10);
                        Btn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(Btn);
                        Btn.setOnMouseClicked((me) -> {
                            try {
                                /**
                                 CommodityInfoShowViewController controller = (CommodityInfoShowViewController) replaceSceneContent(
                                 "/view/stockmanager/CommodityInfoShow.fxml");
                                 controller.id_to_modify = this.getTableView().getItems().get(this.getIndex()).getId();
                                 //controller.setCommodityTable(OperateCommodity);
                                 */
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        });
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });
        addPurchaseBillRow();
        addPurcRetBillRow();
        addSalesBillRow();
        addSalesRetBill();
    }

    public void addPurchaseBillRow() {
        ArrayList<SalesInBillVO> list = salesmanBillBLService.getMySalesInBill(LoginController.getCurrentUser().getID());
        //ArrayList<SalesInBillVO> list = new ArrayList<>();

        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            SalesInBillType salesInBillType = list.get(i).getType();
            String name = "", status = "";
            if (SalesInBillType.IN == salesInBillType) {
                name = "进货单";
                BillStatus billStatus = list.get(i).getStatus();
                if (BillStatus.init == billStatus) {
                    status = "已保存";//黑
                } else if (BillStatus.commit == billStatus) {
                    status = "已提交";//蓝
                } else if (BillStatus.approval == billStatus) {
                    status = "审批通过";//绿
                } else if (BillStatus.rejected == billStatus) {
                    status = "审批未通过";//红
                }
                BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getID(), name, status);
                data.add(billCheckTable);
            }
        }
    }

    public void addPurcRetBillRow() {
        ArrayList<SalesInBillVO> list = salesmanBillBLService.getMySalesInBill(LoginController.getCurrentUser().getID());

        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            SalesInBillType salesInBillType = list.get(i).getType();
            String name = "", status = "";
            if (SalesInBillType.OUT == salesInBillType) {
                name = "进货退货单";
                BillStatus billStatus = list.get(i).getStatus();
                if (BillStatus.init == billStatus) {
                    status = "已保存";//黑
                } else if (BillStatus.commit == billStatus) {
                    status = "已提交";//蓝
                } else if (BillStatus.approval == billStatus) {
                    status = "审批通过";//绿
                } else if (BillStatus.rejected == billStatus) {
                    status = "审批未通过";//红
                }
                BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getID(), name, status);
                data.add(billCheckTable);
            }
        }
    }

    public void addSalesBillRow() {
        ArrayList<SalesOutBillVO> list = salesmanBillBLService.getMySalesOutBill(LoginController.getCurrentUser().getID());

        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            SalesOutBillType salesOutBillType = list.get(i).getType();
            String name = "", status = "";
            if (SalesOutBillType.OUT == salesOutBillType) {
                name = "销售单";
                BillStatus billStatus = list.get(i).getStatus();
                if (BillStatus.init == billStatus) {
                    status = "已保存";//黑
                } else if (BillStatus.commit == billStatus) {
                    status = "已提交";//蓝
                } else if (BillStatus.approval == billStatus) {
                    status = "审批通过";//绿
                } else if (BillStatus.rejected == billStatus) {
                    status = "审批未通过";//红
                }
                BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getID(), name, status);
                data.add(billCheckTable);
            }
        }
    }

    public void addSalesRetBill() {
        ArrayList<SalesOutBillVO> list = salesmanBillBLService.getMySalesOutBill(LoginController.getCurrentUser().getID());

        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            SalesOutBillType salesOutBillType = list.get(i).getType();
            String name = "", status = "";
            if (SalesOutBillType.RETURN == salesOutBillType) {
                name = "销售退货单";
                BillStatus billStatus = list.get(i).getStatus();
                if (BillStatus.init == billStatus) {
                    status = "已保存";//黑
                } else if (BillStatus.commit == billStatus) {
                    status = "已提交";//蓝
                } else if (BillStatus.approval == billStatus) {
                    status = "审批通过";//绿
                } else if (BillStatus.rejected == billStatus) {
                    status = "审批未通过";//红
                }
                BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getID(), name, status);
                data.add(billCheckTable);
            }
        }
    }

    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        System.out.println("Sucess");
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
                    "/view/stockseller/BillCreate.fxml");
            // replaceSceneContent("/view/stockseller/CustomerManage.fxml");
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
                LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
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
     * 客户管理
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void customerManageButtonAction(ActionEvent e) throws IOException {
        try {
            CustomerManageViewController controller = (CustomerManageViewController) replaceSceneContent(
                    "/view/stockseller/CustomerManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    private Initializable replaceSceneContent(String fxml) throws Exception {
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
        Scene scene = new Scene(page, 900, 560);
        stage.setScene(scene);
        stage.sizeToScene();
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


