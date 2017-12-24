package ui.financemanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import auxiliary.FinanceItem;
import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLService;
import blservice.billblservice.FinanceBillBLService;
import blservice.customerblservice.CustomerBLService;
import filterflags.CustomerSearchFlag;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.FinanceBillType;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;
import vo.CustomerVO;
import vo.FinanceBillVO;
import vo.FinanceItemVO;
import vo.UserVO;

public class FinanceManagerAddReceiveBillController implements Initializable {

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
	TableView FinanceItemTable;
	@FXML
	ComboBox AccountField;
	@FXML
	TextField SumField;
	@FXML
	TextField PsField;
	@FXML
	TextField CustomerName;
	@FXML
	TextField SumAmount;
	@FXML 
	Button BackToMakeBillMain;
	@FXML
	Button ClearCondition;
	@FXML
	Button SaveReceiveBill;
	@FXML
	Button CommitReceiveBill;
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
	AccountBLService accountBLService = new BLFactoryImpl().getAccountBLService();
	FinanceBillBLService billBLService = new BLFactoryImpl().getFinanceBillBLService();
	LoginController loginController = new LoginController();
	UserVO currentUser = loginController.getCurrentUser();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		
		ArrayList<AccountVO> accountList = accountBLService.searchAccount(new AccountFilterFlagsVO("",null,null));
		ObservableList<String> account = AccountField.getItems();
		for(int i = 0;i<accountList.size();i++) {
			account.add(accountList.get(i).getName());
			//account.add(accountList.get(i));
		}
		
		NameTag.setText(currentUser.getName());
		RoleTag.setText(currentUser.getCategory().toString());
		IdTag.setText(currentUser.getID());
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
	 * 监听增加转账列表按钮
	 * 
	 * @param e
	 * @throws Exception
	 */
	public void handleAddFinanceItemButtonAction(ActionEvent e) throws Exception{
	   ObservableList<FinanceItem> data = FinanceItemTable.getItems();
	   data.add(new FinanceItem(AccountField.getValue().toString(),SumField.getText(),PsField.getText()));
		SumField.setText("");
		PsField.setText("");
	}
	
	
	/**
	 * 监听清空条件按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleClearConditionButtonAction(ActionEvent e) throws Exception {
		ObservableList<FinanceItem> data = FinanceItemTable.getItems();
		data.clear();
		SumField.setText("");
		PsField.setText("");
		CustomerName.setText("");
		SumAmount.setText("");
		
	}
	/**
	 * 监听返回增加单据主界面按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleBackToMakeBillMainButtonAction(ActionEvent e) throws Exception{
		try {
			FinanceManagerMakeBillMainController controller = (FinanceManagerMakeBillMainController) replaceSceneContent(
					"/view/financemanager/FinanceManagerMakeBillMain.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 监听保存单据按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleSaveReceiveBillButtonAction(ActionEvent e) throws Exception{
		String customerName = CustomerName.getText();
		ArrayList<CustomerVO> customerList = customerBLService.searchCustomer(CustomerSearchFlag.NAME, customerName);
		CustomerVO customerVO= customerList.get(0);
		Double sum = Double.parseDouble(SumField.getText());
		ArrayList<FinanceItemVO> financeItems = new ArrayList<FinanceItemVO>();
		ObservableList<FinanceItem> data = FinanceItemTable.getItems();
		for(int i=0;i<data.size();i++) {
			FinanceItem temp = data.get(i);
			AccountVO accountVO = accountBLService.searchAccount(new AccountFilterFlagsVO(temp.getAccount(),null,null)).get(0);
			financeItems.add(new FinanceItemVO(accountVO,temp.getPs(),Double.parseDouble(temp.getSum())));
	}
		billBLService.saveFinanceBill(new FinanceBillVO(currentUser,customerVO,FinanceBillType.IN,financeItems));
		
	}
	
	 /**
	  * 监听提交单据按钮
	  * @param e
	  * @throws Exception
	  */
    public void handleCommitReceiveBillButtonAction(ActionEvent e) throws Exception{
    	String customerName = CustomerName.getText();
		ArrayList<CustomerVO> customerList = customerBLService.searchCustomer(CustomerSearchFlag.NAME, customerName);
		CustomerVO customerVO= customerList.get(0);
		Double sum = Double.parseDouble(SumField.getText());
		ArrayList<FinanceItemVO> financeItems = new ArrayList<FinanceItemVO>();
		ObservableList<FinanceItem> data = FinanceItemTable.getItems();
		for(int i=0;i<data.size();i++) {
			FinanceItem temp = data.get(i);
			AccountVO accountVO = accountBLService.searchAccount(new AccountFilterFlagsVO(temp.getAccount(),null,null)).get(0);
			financeItems.add(new FinanceItemVO(accountVO,temp.getPs(),Double.parseDouble(temp.getSum())));
	}
		billBLService.commitFinanceBill(new FinanceBillVO(currentUser,customerVO,FinanceBillType.IN,financeItems));
		
	}


}
