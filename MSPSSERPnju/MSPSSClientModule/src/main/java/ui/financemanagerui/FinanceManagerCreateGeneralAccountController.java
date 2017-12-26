package ui.financemanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import auxiliary.GeneralAccount;
import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLService;
import blservice.generalaccountblservice.GeneralAccountBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.Kind_Of_Customers;
import util.Time;
import vo.AccountVO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.GeneralAccountVO;

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
	TextField GeneralAccountName;
	@FXML
	DatePicker CreateTime;
	@FXML
	TextField CommodityName;
	@FXML
	TextField CustomerName;
	@FXML
	TextField AccountName;
	
	@FXML
	Button AddCommodity;
	@FXML
	Button AddCustomer;
	@FXML
	Button AddAccount;
	@FXML
	Button CommitGeneralAccount;
	@FXML
	Button ClearInformation;
	
	@FXML
	TableView CurrentCommodity;
	@FXML
	TableView CurrentCustomer;
	@FXML
	TableView CurrentAccount;
	
	
	
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	static ArrayList<CommodityVO> commodityList = new ArrayList<CommodityVO>();
	static ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();
	static ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
	GeneralAccountBLService generalAccountBLService = new BLFactoryImpl().getGeneralAccountBLService();
	AccountBLService accountBLService = new BLFactoryImpl().getAccountBLService();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		CommodityVO commodity1 = new CommodityVO("LED灯","12138","IEEE-0001",10,10,100);
		commodityList.add(commodity1) ;
		 CustomerVO customer = new CustomerVO("1",Kind_Of_Customers.SUPPLIER,2,"hanqi",
			        "10086","NJ","210046","hxh@foxmail.com",100,1000,100,"hemusheng");
		 customerList.add(customer);
		  AccountVO accountVO1 = new AccountVO("HuaQi",111,new Time());
		  accountList.add(accountVO1);
	}

	public void setApp(MainApp application) {
		this.application = application;
	}
	
	

	
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
	 * 监听清空条件按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleClearInfomationButtonAction(ActionEvent e) throws Exception{
		 GeneralAccountName.setText("");
		 CommodityName.setText("");
		 CustomerName.setText("");
		 AccountName.setText("");
		ObservableList<GeneralAccount> commodityData = CurrentCommodity.getItems();
		ObservableList<GeneralAccount> customerData = CurrentCustomer.getItems();
		ObservableList<GeneralAccount> accountData = CurrentAccount.getItems();
		commodityData.clear();
		customerData.clear();
		accountData.clear();
	}
	
	/**
	 * 监听增加商品按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddCommodityButtonAction(ActionEvent e) throws Exception{
		ObservableList<GeneralAccount> data = CurrentCommodity.getItems();
		data.add(new GeneralAccount(CommodityName.getText()));
		CommodityVO temp = generalAccountBLService.searchCommodity(CommodityName.getText());
		//CommodityVO temp = new CommodityVO("LED灯","12138","IEEE-0003",10,12,120);
		commodityList.add(temp);
		CommodityName.setText("");
		 
	}
	
	/**
	 * 监听增加客户按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddCustomerButtonAction(ActionEvent e) throws Exception{
		ObservableList<GeneralAccount> data = CurrentCustomer.getItems();
		data.add(new GeneralAccount(CustomerName.getText()));
		CustomerVO temp = generalAccountBLService.searchCustomer(CustomerName.getText());
		//CustomerVO temp = new CustomerVO("2",Kind_Of_Customers.SUPPLIER,2,"hanqi",
		       // "10086","NJ","210046","hxh@foxmail.com",100,1000,100,"hemusheng");
		customerList.add(temp);
		 CustomerName.setText("");
	}
	
	/**
	 * 监听增加账户按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddAccountButtonAction(ActionEvent e) throws Exception{
		ObservableList<GeneralAccount> data = CurrentAccount.getItems();
		data.add(new GeneralAccount(AccountName.getText()));
		AccountVO temp = accountBLService.exactlySearchAccountByName(AccountName.getText());
		//AccountVO temp = new AccountVO("zhaoshang",1111111,new Time());
		accountList.add(temp);
		 AccountName.setText("");
	}
	
	/**
	 * 监听提交账目按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleCommitGeneralAccountButtonAction(ActionEvent e)throws Exception{
		String name = GeneralAccountName.getText();
		LocalDate Time = CreateTime.getValue();
		Time createTime = new Time(Time.getYear(),Time.getMonthValue(),Time.getDayOfMonth(),0,0,0);
		GeneralAccountVO generalAccountVO = new GeneralAccountVO(name,createTime,commodityList,customerList,accountList);
		commodityList.clear();
		customerList.clear();
		accountList.clear();
		
	}


}