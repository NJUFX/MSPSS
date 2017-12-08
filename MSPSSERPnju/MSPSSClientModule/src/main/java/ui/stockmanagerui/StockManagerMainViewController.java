package ui.stockmanagerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 * author: Jiang_Chen date:2017/12/07
 */
public class StockManagerMainViewController implements Initializable {

	Stage stage = StageSingleton.getStage();
	Dialog dialog = new Dialog();
	private MainApp application;

	public void setApp(MainApp application) {
		this.application = application;
	}

	@FXML
	Button BackToLogin;

	@FXML
	Button billCreateButton;

	@FXML
	Button commodityManageButton;

	@FXML
	Button commodityClassifyButton;

	@FXML
	Button stockInventoryButton;

	@FXML
	Button stockCheckButton;

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
			StockCheckViewController controller = (StockCheckViewController) replaceSceneContent(
					"/view/stockmanager/StockCheck.fxml");
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
			LoginController controller = (LoginController) replaceSceneContent("/view/admin/Login.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
