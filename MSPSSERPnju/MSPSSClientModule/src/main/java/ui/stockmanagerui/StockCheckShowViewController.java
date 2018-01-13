package ui.stockmanagerui;

import auxiliary.StockCheckTable;
import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import blservice.stockbl.StockBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.StockInfo;
import util.Time;
import vo.StockVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class StockCheckShowViewController implements Initializable {

    StockBLService stockBLService = new BLFactoryImpl().getStockBLService();
    Dialog dialog = new Dialog();
    Stage stage = StageSingleton.getStage();
    @FXML
    Button BackToLogin;

    @FXML
    Button billCreateButton;

    @FXML
    Button commodityManageButton, commodityClassifyButton, stockInventoryButton, backButton;
    @FXML
    TableView<StockCheckTable> stockCheckTableTableView;
    @FXML
    TableColumn<StockCheckTable, String> TypeCol, NumberCol, AccountCol;
    @FXML
    DatePicker startTime, endTime;


    public void showTableView() {
        TypeCol.setCellFactory(col -> {
            TableCell<StockCheckTable, String> cell = new TableCell<StockCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        String id = this.getTableView().getItems().get(this.getIndex()).getType();
                        this.setText(String.valueOf(id));
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });

        NumberCol.setCellFactory(col -> {
            TableCell<StockCheckTable, String> cell = new TableCell<StockCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        String id = this.getTableView().getItems().get(this.getIndex()).getNumber();
                        this.setText(String.valueOf(id));
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });

        AccountCol.setCellFactory(col -> {
            TableCell<StockCheckTable, String> cell = new TableCell<StockCheckTable, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        String id = this.getTableView().getItems().get(this.getIndex()).getAccount();
                        this.setText(String.valueOf(id));
                    }
                }
            };
            cell.setStyle("-fx-alignment:CENTER;");
            return cell;
        });

    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        ObservableList<StockCheckTable> data = stockCheckTableTableView.getItems();
        data.clear();
        if (startTime != null && endTime != null && startTime.getValue() != null && endTime.getValue() != null) {
            LocalDate start = startTime.getValue();
            LocalDate end = endTime.getValue();
            LocalDate tmp = start;
            if (start.isAfter(end)) {
                start = end;
                end = tmp;
            }
            Time startTime = new Time(start.getYear(), start.getMonthValue(), start.getDayOfMonth(), 0, 0, 0);
            Time endTime = new Time(start.getYear(), start.getMonthValue(), start.getDayOfMonth(), 0, 0, 0);
            List<StockVO> list = stockBLService.viewStock(startTime, endTime);
            for (int i = 0; i < list.size(); i++) {
                StockVO stockVO = list.get(i);
                String type = "入库";
                if (stockVO.stockType == StockInfo.Out) {
                    type = "出库";
                }
                StockCheckTable stockCheckTable = new StockCheckTable(type, String.valueOf(stockVO.number), String.valueOf(stockVO.price));
                data.add(stockCheckTable);
            }
        }else{
            dialog.errorInfoDialog("Something null, please check your input.");
        }
    }

    /**
     * 处理单据
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void billCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
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
     * 查看结果显示
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void backButtonAction(ActionEvent e) throws IOException {
        try {
            StockManagerMainViewController controller = (StockManagerMainViewController) replaceSceneContent(
                    "/view/stockmanager/Main.fxml");
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
        Scene scene = new Scene(page, 900, 560);
        stage.setScene(scene);
        stage.sizeToScene();
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
