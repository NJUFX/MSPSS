package ui.financemanagerui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.tableblservice.TableBLService;
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
import vo.BusinessTableVO;
import vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class FinanceManagerSearchManageListController implements Initializable {

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
	TextField SalesIncome;
	@FXML
	TextField CommodityIncome;
	@FXML
	TextField SalesCost;
	@FXML
	TextField CommodityCost;
	@FXML
	TextField TotalCost;
	@FXML
	TextField Profit;
	@FXML
	Button ExportManageList;
	@FXML
	Button BackToSearchList;
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	static BusinessTableVO tableVO;
	TableBLService tableBLService = new BLFactoryImpl().getTableBLService();
	LoginController loginController = new LoginController();
	UserVO currentUser = loginController.getCurrentUser();


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
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
	 * 显示经营情况表
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void showManageTable(BusinessTableVO vo) throws Exception{
		tableVO = vo;//导入表单VO
		SalesIncome.setText(Double.toString(vo.getSalesIncome()));
		CommodityIncome.setText(Double.toString(vo.getCommodityIncome()));
		SalesCost.setText(Double.toString(vo.getSalesCost()));
		CommodityCost.setText(Double.toString(vo.getCommodityCost()));
		double totalCost = vo.getCommodityCost()+vo.getSalesCost();
		double profit = vo.getCommodityIncome()+vo.getSalesIncome()-totalCost;
		TotalCost.setText(Double.toString(totalCost));
		Profit.setText(Double.toString(profit));

	}
	
	
	/**
	 * 导出经营情况表
	 * @param e
	 * @throws Exception
	 */
	public void handleExportManageListButtonAction(ActionEvent e) throws Exception{
		tableBLService.exportBusinessTable(tableVO);
		Dialog d = new Dialog();
		d.confirmDialog("导出报表成功！");
	}
	
	/**
	 * 返回查看报表主界面
	 * @param e
	 * @throws Exception
	 */
	public void handleBackToSearchListButtonAction(ActionEvent e) throws Exception{
		try {
			FinanceManagerSearchListController controller = (FinanceManagerSearchListController) replaceSceneContent(
					"/view/financemanager/FinanceManagerSearchList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}