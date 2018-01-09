package ui.stockmanagerui;

import auxiliary.Bill;
import auxiliary.BillCheckTable;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.StockManagerBillBLService;
import blservice.mainblservice.MainBLService;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.BillStatus;
import util.StockBillType;
import vo.StockBillVO;

import javax.naming.Name;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillStatusCheckViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    StockManagerBillBLService stockManagerBillBLService = new BLFactoryImpl().getStockManagerBillBLService();
    Dialog dialog = new Dialog();
    Stage newStage = new Stage();

    @FXML
    Button BackToLogin;
    @FXML
    ComboBox<String> statusScreenBox, typeScreenBox;
    @FXML
    Button commodityManageButton;

    @FXML
    Button commodityClassifyButton;

    @FXML
    Button stockInventoryButton;

    @FXML
    Button stockCheckButton, backButton;

    @FXML
    TableView<BillCheckTable> tableTableView;
    @FXML
    TableColumn<BillCheckTable, String> SerialCol, IdCol, NameCol, StatusCol, OperationCol;

    @FXML
    public void screenBoxAction(ActionEvent e) {
        tableTableView.getItems().clear();
        addRow();
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
                        if (name.equals("库存报损单")) {
                            this.setTextFill(Color.rgb(0, 102, 153));
                        } else if (name.equals("库存报溢单")) {
                            this.setTextFill(Color.rgb(255, 204, 0));
                        } else if (name.equals("库存赠送单")) {
                            this.setTextFill(Color.rgb(204, 51, 51));
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
                        if (name.equals("已保存")) {
                            this.setTextFill(Color.rgb(0, 0, 0));
                        } else if (name.equals("已提交")) {
                            this.setTextFill(Color.rgb(0, 153, 204));
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
                        Button delBtn = new Button("打开");
                        delBtn.setPrefSize(80, 10);
                        delBtn.getStylesheets().add("/css/stockseller/buttonInTable.css");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            try {
                                if (getTableView().getItems().get(this.getIndex()).getStatus().equals("已保存")) {
                                    if (getTableView().getItems().get(this.getIndex()).getId().substring(0, 5).equals("KCBYD")) {
                                        OverflowCreateViewController.isSaved = true;
                                        OverflowCreateViewController.savedStockBillVO = getTableView().getItems().get(this.getIndex()).getStockBillVO();
                                        OverflowCreateViewController controller = (OverflowCreateViewController) replaceSceneContent("/view/stockmanager/OverflowCreate.fxml");
                                    } else if (getTableView().getItems().get(this.getIndex()).getId().substring(0, 5).equals("KCBSD")) {
                                        BreakageCreateViewController.isSaved = true;
                                        BreakageCreateViewController.savedStockBillVO = getTableView().getItems().get(this.getIndex()).getStockBillVO();
                                        BreakageCreateViewController controller = (BreakageCreateViewController) replaceSceneContent("/view/stockmanager/OverflowCreate.fxml");
                                    }
                                } else {
                                    BillDetailsShowViewController.stockBillVO = getTableView().getItems().get(this.getIndex()).getStockBillVO();
                                    BillDetailsShowViewController controller = (BillDetailsShowViewController) replaceAnotherSceneContent("/view/stockmanager/BillDetailsShow.fxml", 729, 605);
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        });
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });
        addRow();
    }

    public void addRow() {
        ArrayList<StockBillVO> list = stockManagerBillBLService.getMyStockBill(LoginController.getCurrentUser().getID());
        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            StockBillType stockBillType = list.get(i).getType();
            String name = "", status = "";
            if (StockBillType.Less == stockBillType) {
                name = "库存报损单";
            } else if (StockBillType.More == stockBillType) {
                name = "库存报溢单";
            } else if (StockBillType.Presentation == stockBillType) {
                name = "库存赠送单";
            }
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
            BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getId(), name, status);
            billCheckTable.setStockBillVO(list.get(i));
            data.add(billCheckTable);
        }

    }

    @FXML
    public void backButtonAction(ActionEvent e) {
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BillCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 商品管理
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityManageButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityManageViewController controller = (CommodityManageViewController) replaceSceneContent(
                    "/view/stockmanager/CommodityManage.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 商品分类
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void commodityClassifyButtonAction(ActionEvent e) throws IOException {
        try {
            CommodityClassifyViewController controller = (CommodityClassifyViewController) replaceSceneContent(
                    "/view/stockmanager/CommodityClassify.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存查看
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void stockCheckButtonAction(ActionEvent e) throws IOException {
        try {
            StockCheckShowViewController controller = (StockCheckShowViewController) replaceSceneContent(
                    "/view/stockmanager/StockCheckShow.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存盘点
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void stockInventoryButtonAction(ActionEvent e) throws IOException {
        try {
            StockInventoryViewController controller = (StockInventoryViewController) replaceSceneContent(
                    "/view/stockmanager/StockInventory.fxml");
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
        newStage.setTitle("单据详情");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
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
