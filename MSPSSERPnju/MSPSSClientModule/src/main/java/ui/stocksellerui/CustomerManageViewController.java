package ui.stocksellerui;

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
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * 
 * @author 伏家兴
 *
 */
public class CustomerManageViewController implements Initializable {

	Stage stage = StageSingleton.getStage();
	Dialog dialog = new Dialog();

	@FXML
	Button BillCreateButton;

	@FXML
	Button CustomerAddButton;
	
	@FXML
	Button CustomerDelButton;
	
	@FXML
	Button CustomerModButton;
	
	@FXML
	Button CustomerSearchButton;

	/**
	 * 制定单据
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void billCreateButtonAction(ActionEvent e) throws IOException {
		try {
			BillCreateViewController controller = (BillCreateViewController) replaceSceneContent(
					"/view/stockseller/BillCreate.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 增加客户
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void customerAddButtonAction(ActionEvent e) throws IOException {
		try {
			CustomerAddViewController controller = (CustomerAddViewController) replaceSceneContent(
					"/view/stockseller/CustomerAdd.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 删除客户
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void customerDelButtonAction(ActionEvent e) throws IOException {
		try {
			CustomerDelViewController controller = (CustomerDelViewController) replaceSceneContent(
					"/view/stockseller/CustomerDel.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 修改客户属性
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void customerModifyButtonAction(ActionEvent e) throws IOException {
		try {
			CustomerModifyFirstViewController controller = (CustomerModifyFirstViewController) replaceSceneContent(
					"/view/stockseller/CustomerModifyFirst.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 查找客户的结果显示
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void customerSearchShowButtonAction(ActionEvent e) throws IOException {
		
		try {
			CustomerSearchShowViewController controller = (CustomerSearchShowViewController) replaceSceneContent(
					"/view/stockseller/CustomerSearchShow.fxml");
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
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
