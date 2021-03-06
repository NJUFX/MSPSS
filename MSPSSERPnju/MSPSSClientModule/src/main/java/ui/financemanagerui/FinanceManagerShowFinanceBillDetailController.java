package ui.financemanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliary.Bill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.accountblservice.AccountBLService;
import blservice.billblservice.FinanceBillBLService;
import blservice.commodityblservice.CommodityBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.AccountFilterFlagsVO;
import vo.CashCostBillVO;
import vo.FilterFlagVO;
import vo.FinanceBillVO;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;
import vo.UserVO;

public class FinanceManagerShowFinanceBillDetailController implements Initializable{
	@FXML
	Button SearchList;
	@FXML
	Button ExamineBill;
	@FXML
	Button ReadLog;
	@FXML
	Button SetPromotion;
	@FXML
	Label NameTag;
	@FXML
	Label RoleTag;
	@FXML
	Label IdTag;
	@FXML
	Button BackToLogin;
	
	@FXML
	Pane FinanceBillPane;
	
	@FXML
	Label FinanceBillId;
	@FXML
	Label FinanceBillOperator;
	@FXML
	Label FinanceBillCustomer;
	
	@FXML
	Label FinanceBillInitTime;
	@FXML
	Label FinanceBillCommitTime;
	
	@FXML
	Label FinanceBillType;
	@FXML
	Label FinanceBillSum;
	@FXML
	Label FinanceBillStatus;
	@FXML
	TextArea FinanceBillItem;
	@FXML
	Button BackToExamineBill;
	
	
	
	
	
	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	LoginController loginController = new LoginController();
	UserVO currentUser = loginController.getCurrentUser();
	FinanceBillBLService financeBillBLService = new BLFactoryImpl().getFinanceBillBLService();


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
	 * 显示财务单据详情
	 * @param vo
	 */
	public void ShowFinanceBillDetail(FinanceBillVO vo) {
		
		
		FinanceBillId.setText(vo.getID());
		FinanceBillOperator.setText(vo.getOperator().getName());
		FinanceBillCustomer.setText(vo.getCustomerVO().getName());
		//FinanceBillExamineManager.setText("");
		FinanceBillInitTime.setText(vo.getInit_time().toString());
		FinanceBillCommitTime.setText(vo.getCommit_time().toString());
		//FinanceBillExamineTime.setText("");
		FinanceBillType.setText(vo.getType().toString());
		FinanceBillSum.setText(Double.toString(vo.getSum()));
		FinanceBillStatus.setText(vo.getStatus().toString());
		
		String BillItem = "";
		for(int i=0;i<vo.getList().size();i++) {
			BillItem = BillItem + vo.getList().get(i).accountVO.getName()+" "+Double.toString(vo.getList().get(i).money)+" "+vo.getList().get(i).ps+"\n";
		}
		FinanceBillItem.setText(BillItem);
	}
	
	/**
	 * 红冲并复制
	 * @param vo
	 */
	public void HongChongAndCopy(FinanceBillVO vo) {
		String[] items = FinanceBillItem.getText().split("\n");
		AccountBLService accountBLService = new BLFactoryImpl().getAccountBLService();
		for(int i=0;i<items.length;i++) {
			String[] temp= items[i].split(" ");
			AccountFilterFlagsVO flag = new AccountFilterFlagsVO(temp[0],null,null);
			//默认只能搜到一个
			vo.getList().get(i).setAccountVO(accountBLService.searchAccount(flag).get(0));
		}
		financeBillBLService.HongChongAndCopy(vo);
		
	}
	

}