package ui.stockmanagerui;

import auxiliary.Alert;
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
import ui.adminui.LoginController;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/12
 */
public class AlertCreateViewController implements Initializable {
    Stage stage = StageSingleton.getStage();
    Dialog dialog = new Dialog();
    @FXML
    Button overflowCreateButton;
    @FXML
    Button breakageCreateButton;
    @FXML
    Button presentationCreateButton;
    @FXML
    Button BackToLogin;
    @FXML
    Button cancelButton;
    @FXML
    TableView<Alert> alertTable;
    @FXML
    TableColumn<Alert, String> IdCol, NameCol, AlertNumberCol, StockNumberCol;
    @FXML
    TableColumn<Alert, CheckBox> SelectCol;// 删除一行的按钮
    @FXML
    Button dealAllButton;// 一键处理全部的按钮
    @FXML
    Button dealSelectedButton;// 处理选中行

    public void showTableView() {
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AlertNumberCol.setCellValueFactory(new PropertyValueFactory<>("AlertNumber"));
        StockNumberCol.setCellValueFactory(new PropertyValueFactory<>("StockNumber"));
        SelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
    }

    /**
     * 处理选中行
     *
     * @param e
     */
    @FXML
    public void dealSelectedButtonAction(ActionEvent e) {
        if (alertTable != null) {
            ObservableList<Alert> data = alertTable.getItems();
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
                        data.remove(j);
                    }
                }
            }
            dialog.infoDialog("Delete all selected successfully!");
        } else {
            dialog.errorInfoDialog("Nothing need dealing.");
        }
    }

    /**
     * 处理全部报警单
     *
     * @param e
     */
    @FXML
    public void dealAllButtonAction(ActionEvent e) {
        if (alertTable != null) {
            ObservableList<Alert> data = alertTable.getItems();
            data.clear();
            dialog.infoDialog("Delete all successfully!");
        } else {
            dialog.errorInfoDialog("Nothing need dealing.");
        }
    }

    /**
     * 返回上一界面（处理单据界面）
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void cancelButtonAction(ActionEvent e) throws IOException {
        try {
            BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BillCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 库存报溢单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void overflowCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            OverflowCreateViewController controller = (OverflowCreateViewController) replaceSceneContent(
                    "/view/stockmanager/OverflowCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 库存报损单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void breakageCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            BreakageCreateViewController controller = (BreakageCreateViewController) replaceSceneContent(
                    "/view/stockmanager/BreakageCreate.fxml");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
     * 库存赠送单
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void presentationCreateButtonAction(ActionEvent e) throws IOException {
        // System.out.println("SUSS");
        try {
            PresentationCreateViewController controller = (PresentationCreateViewController) replaceSceneContent(
                    "/view/stockmanager/PresentationCreate.fxml");
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
            LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
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
