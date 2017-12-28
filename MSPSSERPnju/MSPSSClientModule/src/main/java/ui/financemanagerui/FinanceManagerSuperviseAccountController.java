package ui.financemanagerui;

import auxiliary.Account;
import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import util.Time;
import vo.AccountVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FinanceManagerSuperviseAccountController implements Initializable {

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
	TableView AccountTable;
	@FXML
	TableColumn<Account,String> DeleteAccount;
	@FXML
	TextField SearchCondition;
	@FXML
	Button SearchAccount;
	@FXML
	TextField AddAccountName;
	@FXML
	TextField AddAccountMoney;
	@FXML
	TextField CurrentAccountName;
	@FXML
	TextField NewAccountName;
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	AccountBLService accountBLService = new BLFactoryImpl().getAccountBLService();
	ArrayList<AccountVO> testStub = new ArrayList<AccountVO>();
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		this.initTable();
			testStub.add(new AccountVO("testName",100000.0,new Time(2017,12,25,15,40,23)));

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
	
	public void initTable() {
		DeleteAccount.setCellFactory((col) -> {
			TableCell<Account, String> cell = new TableCell<Account, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty) {
						Image btnImage = new Image(getClass().getResourceAsStream("/image/删除.png"));
						Button delBtn = new Button();
						ImageView iv = new ImageView(btnImage);
						iv.setFitWidth(15);
						iv.setFitHeight(15);
						delBtn.setGraphic(iv);
						delBtn.setPrefSize(100, 5);

						// delBtn.getStylesheets().add("/css/chiefmanager/ChiefManagerExamineBillButton.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								Account currentAccount = this.getTableView().getItems().get(getIndex());
								accountBLService.deleteAccount(currentAccount.getName());
								ObservableList<Account> data = AccountTable.getItems();
								data.remove(currentAccount);

							} catch (Exception e1) {
								e1.printStackTrace();
							}
						});
					}
				}
			};
			return cell;
		});

		
	}
	
	/**
	 * 监听查找账户按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleSearchAccountButtonAction(ActionEvent e) throws Exception{
		ObservableList<Account> data = AccountTable.getItems();
		data.clear();
		String condition = SearchCondition.getText();
		ArrayList<AccountVO> accountList = accountBLService.fuzzSearchAccountByName(condition);
		//ArrayList<AccountVO> accountList = testStub;
		for(int i=0;i<accountList.size();i++) {
			AccountVO temp = accountList.get(i);
			data.add(new Account(temp.getName(),Double.toString(temp.getMoney())));
		}
	}
	
	
	/**
	 * 监听增加账户按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleAddAccountButtonAction(ActionEvent e) throws Exception{
		String AccountName = AddAccountName.getText();
		String AccountMoney = AddAccountMoney.getText();
		ObservableList<Account> data = AccountTable.getItems();
		data.add(new Account(AccountName,AccountMoney));
		accountBLService.addAccount(new AccountVO(AccountName,Double.parseDouble(AccountName),null));
	}


	/**
	 * 监听修改账户按钮
	 * @param e
	 * @throws Exception
	 */
	public void handleUpdateAccountButtonAction(ActionEvent e) throws Exception{
		ObservableList<Account> data = AccountTable.getItems();
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getName().equals(CurrentAccountName.getText())) {
				Account temp = data.get(i);
				data.add(new Account(NewAccountName.getText(),temp.getMoney()));
				data.remove(temp);
				accountBLService.modifyAccount(CurrentAccountName.getText(), NewAccountName.getText());
			}
		}
	}

}