package ui.financemanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;

public class FinanceManagerCreateGeneralAccountController implements Initializable {

	@FXML
	Button SearchList;
	@FXML
	Button MakeBill;
	@FXML
	Button SuperviseAccount;
	@FXML
	Button CreateGeneralAccount;
	@FXML
	Label NameTag;
	@FXML
	Label RoleTag;
	@FXML
	Label IdTag;
	@FXML
	Button BackToLogin;
	@FXML
	Button CheckCurrentList;
	@FXML
	Button ClearInformation;
	@FXML
	TextField GeneralAccountName;
	@FXML
	TextField CreaterName;
	@FXML
	TextField ProductName;
	@FXML
	TextField ProductType;
	@FXML
	TextField ProductId;
	@FXML
	TextField ProductImportCost;
	@FXML
	TextField ProductExportCost;
	@FXML
	TextField CustomerName;
	@FXML
	TextField CustomerContact;
	@FXML
	TextField CustomerIncomeMoney;
	@FXML
	TextField CustomerPayMoney;
	@FXML
	TextField CustomerType;
	@FXML
	TextField AccountName;
	@FXML
	TextField AccountMoney;
	@FXML
	Button AddCommodity;
	@FXML
	Button AddCustomer;
	@FXML
	Button AddAccount;
	@FXML
	Button CommitGeneralAccount;
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		
	}

	public void setApp(MainApp application) {
		this.application = application;
	}
	
	/*
	public void SetTags(String name,String Role,String id) {
		NameTag.setText(name);
		RoleTag.setText(Role);
		IdTag.setText(id);
	}
	*/

	
	/**
	 * 监听查看报表按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSearchListButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerSearchListController controller = (FinanceManagerSearchListController) replaceSceneContent(
					"/view/financemanager/FinanceManagerSearchList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听制定单据按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleMakeBillButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerMakeBillMainController controller = (FinanceManagerMakeBillMainController) replaceSceneContent(
					"/view/financemanager/FinanceManagerMakeBillMain.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听账户管理按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSuperviseAccountButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerSuperviseAccountController controller = (FinanceManagerSuperviseAccountController) replaceSceneContent(
					"/view/financemanager/FinanceManagerSuperviseAccount.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听期初建账按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleCreateGeneralAccountButtonAction(ActionEvent e) throws IOException {
		try {
			FinanceManagerCreateGeneralAccountController controller = (FinanceManagerCreateGeneralAccountController) replaceSceneContent(
					"/view/financemanager/FinanceManagerCreateGeneralAccount.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 返回登录界面
	 * @param e
	 * @throws IOException
	 */
	public void handleBackToLoginButtonAction(ActionEvent e) throws IOException {
		try {
			LoginController controller = (LoginController) replaceSceneContent(
					"/view/admin/Login.fxml");
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
	 * 监听当前列表按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleCheckCurrentListButtonAction(ActionEvent e) throws Exception{
		try {
			FinanceManagerCurrentGeneralAccountListController controller = (FinanceManagerCurrentGeneralAccountListController) replaceSceneContent(
					"/view/financemanager/FinanceManagerCurrentGeneralAccountList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 监听清空条件按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleClearInfomationButtonAction(ActionEvent e) throws Exception{
		
	}
	
	/**
	 * 监听增加商品按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddCommodityButtonAction(ActionEvent e) throws Exception{
		
	}
	
	/**
	 * 监听增加账户按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddAccountButtonAction(ActionEvent e) throws Exception{
		
	}
	
	/**
	 * 监听提交账目按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleCommitGeneralAccountButtonAction(ActionEvent e)throws Exception{
		
	}


}