package main;

import ui.adminui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        toAddUserInfer();
    }

    /**
     * 跳转登陆界面
     */
    public void toLoginInfer() {
        try {
            LoginController login = (LoginController) replaceSceneContent("/view/stockmanager/StockCheckShow.fxml");
            //LoginController login = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
            login.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 跳转addUser界面
     */
    public void toAddUserInfer() {
        try {
            UserAddViewController userAdd = (UserAddViewController) replaceSceneContent("/view/admin/UserAddView.fxml");
            userAdd.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 跳转delUser界面
     */
    public void toDelUserInfer() {
        try {
            UserDelViewController userDel = (UserDelViewController) replaceSceneContent("/view/admin/UserDelView.fxml");
            userDel.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 跳转modUser界面
     */
    public void toModUserInfer() {
        try {
            UserModifyViewController userMod = (UserModifyViewController) replaceSceneContent("/view/admin/UserModifyView.fxml");
            userMod.setApp(this);
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
