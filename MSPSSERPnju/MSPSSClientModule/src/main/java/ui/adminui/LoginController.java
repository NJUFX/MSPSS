package ui.adminui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.StageSingleton;
import ui.chiefmanagerui.ChiefManagerMainViewController;
import ui.common.Dialog;
import ui.financemanagerui.FinanceManagerMainViewController;
import ui.stockmanagerui.StockManagerMainViewController;
import ui.stocksellerui.StockSellerMainViewController;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
	Dialog dialog = new Dialog();
	Stage stage = StageSingleton.getStage();
	//public MainApp application;

	//public void setApp(MainApp application) {
		//this.application = application;
	//}

	@FXML
	public Button loginButton;

	@FXML
	public TextField idText;
	@FXML
	public PasswordField passwordField;

	@FXML
	public void loginButtonAction(ActionEvent e) {

		String id = idText.getText();
		String password = passwordField.getText();
		userLogin(id, password);
		dialog.infoDialog("Login Successfully.");

	}
	/**
	 * 登陆
	 *
	 * @param id
	 * @param password
	 */
	public void userLogin(String id, String password) {
		// 判断id是否在系统里
		// 判断密码是否正确

		switch (id.substring(0, 2)) {
			case "SY":
				toAdminMain();
				break;
			case "SM":
				toStockManagerMain();
				break;
			case "FM":
				toFinanceManagerMain();
				break;
			case "SS":
				toStockSellerMain();
				break;
			case "CM":
				toChiefManagerMain();
				break;

		}

	}

	/**
	 * 跳转SY系统管理员主界面
	 */
	public void toAdminMain() {
		try {
			AdminMainViewController main = (AdminMainViewController) replaceSceneContent("/view/admin/Main.fxml");
			///main.setApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转SS进货销售主界面
	 */
	public void toStockSellerMain() {
		try {
			StockSellerMainViewController main = (StockSellerMainViewController) replaceSceneContent(
					"/view/stockseller/Main.fxml");
			//main.setApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转SM库存管理人员主界面
	 */
	public void toStockManagerMain() {
		try {
			StockManagerMainViewController main = (StockManagerMainViewController) replaceSceneContent(
					"/view/stockmanager/Main.fxml");
			//main.setApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转FM库存管理人员主界面
	 */
	public void toFinanceManagerMain() {
		try {
			FinanceManagerMainViewController main = (FinanceManagerMainViewController) replaceSceneContent(
					"/view/financemanager/FinanceManagerMainView.fxml");
			//main.setApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转CM总经理主界面
	 */
	public void toChiefManagerMain() {
		try {
			ChiefManagerMainViewController main = (ChiefManagerMainViewController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerMainView.fxml");
			//main.setApp(this);

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
		stage.setResizable(false);
		return (Initializable) loader.getController();
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
}
