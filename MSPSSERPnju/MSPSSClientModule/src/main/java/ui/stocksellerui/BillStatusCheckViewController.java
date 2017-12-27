package ui.stocksellerui;

import auxiliary.BillCheckTable;
import auxiliary.SalesInBill;
import auxiliary.SalesOutBill;
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
import ui.adminui.LoginController;
import util.BillStatus;
import util.SalesInBillType;
import util.SalesOutBillType;
import util.SalesInBillType;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillStatusCheckViewController implements Initializable {

    Stage stage = StageSingleton.getStage();

    @FXML
    Button customerManageButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button backButton;
    //@FXML

    @FXML
    TableView<BillCheckTable> tableTableView;
    @FXML
    TableColumn<BillCheckTable, String> SerialCol, IdCol, NameCol, StatusCol, OperationCol;

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
                            this.setTextFill(Color.RED);
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
        addSalesBillRow();
    }

    public void addPurchaseBillRow() {
        // ArrayList<StockBillVO> list = stockManagerBillBLService.getMyStockBill(LoginController.getCurrentUser().getID());
        ArrayList<SalesInBillVO> list = new ArrayList<>();

        list.add(new SalesInBillVO("JHTHD01", SalesInBillType.OUT, BillStatus.commit));
        list.add(new SalesInBillVO("JHD01", SalesInBillType.IN, BillStatus.approval));
        list.add(new SalesInBillVO("JHTHD01", SalesInBillType.OUT, BillStatus.init));

        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            SalesInBillType salesInBillType = list.get(i).getType();
            String name = "", status = "";
            if (SalesInBillType.IN == salesInBillType) {
                name = "进货退货单";
            } else if (SalesInBillType.OUT == salesInBillType) {
                name = "进货单";
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

            BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getID(), name, status);
            data.add(billCheckTable);
        }

    }

    public void addSalesBillRow() {
        ArrayList<SalesOutBillVO> list = new ArrayList<>();
        list.add(new SalesOutBillVO("XSD01", SalesOutBillType.OUT, BillStatus.rejected));
        list.add(new SalesOutBillVO("XSTHD01", SalesOutBillType.RETURN, BillStatus.rejected));

        ObservableList<BillCheckTable> data = tableTableView.getItems();
        for (int i = 0; i < list.size(); i++) {
            SalesOutBillType salesOutBillType = list.get(i).getType();
            String name = "", status = "";
            if (SalesOutBillType.RETURN == salesOutBillType) {
                name = "销售退货单";
            } else if (SalesOutBillType.OUT == salesOutBillType) {
                name = "销售单";
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

            BillCheckTable billCheckTable = new BillCheckTable(list.get(i).getID(), name, status);
            data.add(billCheckTable);
        }

    }

    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        System.out.println("Sucess");
        try {
            CustomerManageViewController controller = (CustomerManageViewController) replaceSceneContent(
                    "/view/stockseller/CustomerManage.fxml");
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
            LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
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
