package ui.stocksellerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    public void backButtonAction(ActionEvent e) throws IOException {
        System.out.println("Sucess");
        try {
            CustomerManageViewController controller = (CustomerManageViewController) replaceSceneContent(
                    "/view/stocksellerBillCreate.fxml");
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
    }

}
