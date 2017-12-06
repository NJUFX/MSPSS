package main;

import ui.adminui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.chiefmanagerui.ChiefManagerMainViewController;
import ui.financemanagerui.FinanceManagerMainViewController;
import ui.stockmanagerui.StockManagerMainViewController;
import ui.stocksellerui.StockSellerMainViewController;

import java.io.InputStream;

public class MainApp extends Application {
    // MainApp application = new MainApp();
    private Stage stage;

    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("MSPSS");
        stage.setHeight(560);
        stage.setWidth(900);
        toLoginInfer();
        stage.show();
    }

    /**
     * 登陆
     *
     * @param id
     * @param password
     */
    public void userLogin(String id, String password) {
        //判断id是否在系统里
        //判断密码是否正确

        switch (id.substring(0, 2)) {
            case "SY":
                toAdminMain();
            case "SS":
                toStockSellerMain();
            case "CM":
                toChiefManagerMain();
            case "SM":
                toStockManagerMain();
            case "FM":
                toFinanceManagerMain();
            default:
        }
       
    }

    /**
     * 跳转登陆界面
     */
    public void toLoginInfer() {
        try {
            LoginController login = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
            //LoginController login = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
            login.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转SY系统管理员主界面
     */
    public void toAdminMain() {
        try {
            AdminMainViewController main = ( AdminMainViewController) replaceSceneContent("/view/admin/Main.fxml");
            main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转SS进货销售主界面
     */
    public void toStockSellerMain() {
        try {
            StockSellerMainViewController main = (StockSellerMainViewController) replaceSceneContent("/view/stockseller/Main.fxml");
            main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转SM库存管理人员主界面
     */
    public void toStockManagerMain() {
        try {
            StockManagerMainViewController main = (StockManagerMainViewController) replaceSceneContent("/view/stockmanager/main.fxml");
            main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 跳转FM库存管理人员主界面
     */
    public void toFinanceManagerMain() {
        try {
            FinanceManagerMainViewController main = (FinanceManagerMainViewController) replaceSceneContent("/view/financemanager/FinanceManagerMainView.fxml");
            main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 跳转CM总经理主界面
     */
    public void toChiefManagerMain() {
        try {
            ChiefManagerMainViewController main = (ChiefManagerMainViewController) replaceSceneContent("/view/financemanager/ChiefManagerMainView.fxml");
            main.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
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
        //InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
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

    public static void main(String[] args) {
        launch(args);
    }
}
