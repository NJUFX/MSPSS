package ui.stockmanagerui;

import auxiliary.StockInventory;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.StockInventoryVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class StockInventoryViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    StockBLService stockBLService = new BLFactoryImpl().getStockBLService();

    @FXML
    Button BackToLogin;

    @FXML
    Button billCreateButton;

    @FXML
    Button commodityManageButton;

    @FXML
    Button commodityClassifyButton;

    @FXML
    Button stockCheckButton;

    @FXML
    Button ExportToExcelButton;

    @FXML
    public void exportToExcelButtonAction(ActionEvent e) {
        dialog.infoDialog("Export to excel successfully.");
    }

    @FXML
    TableView<StockInventory> stockInventoryTable;
    @FXML
    TableColumn<StockInventory, String> LineIdCol, NameCol, StockNumberCol, AveragePriceCol;

    public void showTableView() {
        LineIdCol.setCellFactory((col) -> {
            TableCell<StockInventory, String> cell = new TableCell<StockInventory, String>() {
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
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        StockNumberCol.setCellValueFactory(new PropertyValueFactory<>("StockNumber"));
        AveragePriceCol.setCellValueFactory(new PropertyValueFactory<>("AveragePrice"));

        addRow();
    }

    /**
     * 添加信息
     */
    public void addRow() {
        ObservableList<StockInventory> data = stockInventoryTable.getItems();
        ArrayList<StockInventoryVO> list = stockBLService.viewInventory();
        for (int i = 0; i < list.size(); i++) {
            StockInventory stockInventory = new StockInventory(list.get(i).getName(), String.valueOf(list.get(i).getNumber()), String.valueOf(list.get(i).getPrice()));
            data.add(stockInventory);
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
                    "/view/stockmanager/commodityManage.fxml");
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
                    "/view/stockmanager/commodityClassify.fxml");
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
