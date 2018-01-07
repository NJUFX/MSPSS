package ui.chiefmanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import auxiliary.Bill;
import auxiliary.CashCostBill;
import auxiliary.FinanceBill;
import auxiliary.SalesInBill;
import auxiliary.SalesOutBill;
import auxiliary.StockBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.ManagerBillBLService;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.CashCostBillVO;
import vo.FinanceBillVO;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;
import vo.UserVO;

public class ChiefManagerExamineBillController implements Initializable {
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
	ComboBox BillType;
	@FXML
	TableView<Bill> BillTable;
	@FXML
	TableColumn<Bill, String> ShowDetail;
	@FXML
	TableColumn<Bill, String> ApproveBill;
	@FXML
	TableColumn<Bill, String> RejectBill;
	

	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	LoginController loginController = new LoginController();
	UserVO currentUser = loginController.getCurrentUser();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		this.InitTable();
		NameTag.setText(currentUser.getName());
		RoleTag.setText(currentUser.getCategory().toString());
		IdTag.setText(currentUser.getID());
	}

	public void setApp(MainApp application) {
		this.application = application;
	}

	/*
	 * public void SetTags(String name,String Role,String id) {
	 * NameTag.setText(name); RoleTag.setText(Role); IdTag.setText(id); }
	 */

	/**
	 * 监听查看报表按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSearchListButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerSearchListController controller = (ChiefManagerSearchListController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerSearchList.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听审批单据按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleExamineBillButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerExamineBillController controller = (ChiefManagerExamineBillController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerExamineBill.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听查询日志按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleReadLogButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerReadLogController controller = (ChiefManagerReadLogController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerReadLog.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 监听促销策略按钮
	 * 
	 * @param e
	 * @throws IOException
	 */
	public void handleSetPromotionButtonAction(ActionEvent e) throws IOException {
		try {
			ChiefManagerSetPromotionController controller = (ChiefManagerSetPromotionController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerSetPromotion.fxml");
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
	 * 选择审批单据类型
	 * 
	 * @param e
	 * @throws Exception
	 */
	public void ChooseBillType(ActionEvent e) throws Exception {
		String billType = BillType.getValue().toString();
		ObservableList<Bill> data = BillTable.getItems();
		data.clear();
		// data.add(new Bill("1","1","1","1","1"));
		ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
		switch (billType) {
		case "库存类": {
			ArrayList<StockBillVO> list = managerBillService.getWaitingStockBill();
			for (int i = 0; i < list.size(); i++) {
				StockBillVO temp = list.get(i);
				data.add(new StockBill(temp.getId(), temp.init_time.toString(), temp.commit_time.toString(),
						temp.getStockManager().getID(), temp.getType().toString(), temp));
			}
			break;
		}
		case "销售类": {
			ArrayList<SalesOutBillVO> list = managerBillService.getWaitingSalesOutBill();
			for (int i = 0; i < list.size(); i++) {
				SalesOutBillVO temp = list.get(i);
				data.add(new SalesOutBill(temp.getID(), temp.getInit_time().toString(),
						temp.getCommit_time().toString(), temp.getOperator().getID(), temp.getType().toString(), temp));
			}
			break;
		}
		case "进货类": {
			ArrayList<SalesInBillVO> list = managerBillService.getWaitingSalesInBill();
			for (int i = 0; i < list.size(); i++) {
				SalesInBillVO temp = list.get(i);
				data.add(new SalesInBill(temp.getID(), temp.getInit_time().toString(), temp.getCommit_time().toString(),
						temp.getOperator().getID(), temp.getType().toString(), temp));
			}
			break;
		}
		case "财务类": {
			ArrayList<FinanceBillVO> list = managerBillService.getWaitingFinanceBill();
			for (int i = 0; i < list.size(); i++) {
				FinanceBillVO temp = list.get(i);
				data.add(new FinanceBill(temp.getID(), temp.getInit_time().toString(), temp.getCommit_time().toString(),
						temp.getOperator().getID(), temp.getType().toString(), temp));
			}
			break;
		}
		
		case "现金费用类": {
			ArrayList<CashCostBillVO> list = managerBillService.getWaitingCashCostBillVO();
			for (int i = 0; i < list.size(); i++) {
				CashCostBillVO temp = list.get(i);
				data.add(new CashCostBill(temp.getID(), temp.getInit_time().toString(), temp.getCommit_time().toString(),
						temp.getOperator().getID(), "现金费用单", temp));
			}
			break;
		}

		}

	}

	/**
	 * 初始化表单
	 * 
	 */
	public void InitTable() {
		ShowDetail.setCellFactory((col) -> {
			TableCell<Bill, String> cell = new TableCell<Bill, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty) {
						Button delBtn = new Button("详情");
						delBtn.setPrefSize(50, 5);
					
						 //delBtn.getStylesheets().add("/css/chiefmanager/ChiefManagerExamineBillButton.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								String billType = BillType.getValue().toString();
								switch (billType) {
								case "库存类": {
									StockBill currentBill = (StockBill) this.getTableView().getItems().get(getIndex());
									StockBillVO vo = currentBill.myself;
									ChiefManagerShowStockBillDetailController controller = (ChiefManagerShowStockBillDetailController) replaceSceneContent(
											"/view/chiefmanager/ChiefManagerShowStockBillDetail.fxml");
									controller.ShowStockBillDetail(vo);
									break;
								}
								case "进货类": {
									SalesInBill currentBill = (SalesInBill) this.getTableView().getItems().get(getIndex());
									SalesInBillVO vo = currentBill.myself;
									ChiefManagerShowSalesInBillDetailController controller = (ChiefManagerShowSalesInBillDetailController) replaceSceneContent(
											"/view/chiefmanager/ChiefManagerShowSalesInBillDetail.fxml");
									controller.ShowSalesInBillDetail(vo);
									break;
								}
								case "销售类": {
									SalesOutBill currentBill = (SalesOutBill) this.getTableView().getItems().get(getIndex());
									SalesOutBillVO vo = currentBill.myself;
									ChiefManagerShowSalesOutBillDetailController controller = (ChiefManagerShowSalesOutBillDetailController) replaceSceneContent(
											"/view/chiefmanager/ChiefManagerShowSalesOutBillDetail.fxml");
									controller.ShowSalesOutBillDetail(vo);
									break;
								}
								case "财务类": {
									FinanceBill currentBill = (FinanceBill) this.getTableView().getItems().get(getIndex());
									FinanceBillVO vo = currentBill.myself;
									ChiefManagerShowFinanceBillDetailController controller = (ChiefManagerShowFinanceBillDetailController) replaceSceneContent(
											"/view/chiefmanager/ChiefManagerShowFinanceBillDetail.fxml");
									controller.ShowFinanceBillDetail(vo);
									break;
								}
								case "现金费用类": {
									CashCostBill currentBill = (CashCostBill) this.getTableView().getItems().get(getIndex());
									CashCostBillVO vo = currentBill.myself;
									ChiefManagerShowCashCostBillDetailController controller = (ChiefManagerShowCashCostBillDetailController) replaceSceneContent(
											"/view/chiefmanager/ChiefManagerShowCashCostBillDetail.fxml");
									controller.ShowCashCostBillDetail(vo);
									break;
								}
								}
								
								//ChiefManagerShowStockBillDetailController controller = (ChiefManagerShowStockBillDetailController) replaceSceneContent(
										//"/view/chiefmanager/ChiefManagerShowBillDetail.fxml");
								
								// controller.setCommodityTable(OperateCommodity);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						});
					}
				}
			};
			return cell;
		});
		
		ApproveBill.setCellFactory((col) -> {
			TableCell<Bill, String> cell = new TableCell<Bill, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty) {
						Button delBtn = new Button("批准");
						delBtn.setPrefSize(50, 10);
						// delBtn.getStylesheets().add("/css/stockseller/buttonInTable.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								String billType = BillType.getValue().toString();
								switch(billType) {
								case"库存类":{
									StockBill Approve = (StockBill) this.getTableView().getItems().get(getIndex());
						            StockBillVO vo = Approve.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
						             managerBillService.approveStockBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Approve);
						            break;
								}
								case"进货类":{
									SalesInBill Approve = (SalesInBill) this.getTableView().getItems().get(getIndex());
						            SalesInBillVO vo = Approve.myself;
									ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
									managerBillService.approveSalesInBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Approve);
						            break;
								}
								case"销售类":{
									SalesOutBill Approve = (SalesOutBill) this.getTableView().getItems().get(getIndex());
						            SalesOutBillVO vo = Approve.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
						            vo.setManager(currentUser);
						             managerBillService.approveSalesOutBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Approve);
						            break;
								}
								case"财务类":{
									FinanceBill Approve = (FinanceBill) this.getTableView().getItems().get(getIndex());
						            FinanceBillVO vo = Approve.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
						            vo.setManagerVO(currentUser);
						            managerBillService.approveFinanceBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Approve);
						            break;
								}
								case"现金费用类":{
									CashCostBill Approve = (CashCostBill) this.getTableView().getItems().get(getIndex());
						            CashCostBillVO vo = Approve.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
						            managerBillService.approveCashCostBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Approve);
						            break;
								}
								}
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						});
					}
				}
			};
			return cell;
		});
		
		RejectBill.setCellFactory((col) -> {
			TableCell<Bill, String> cell = new TableCell<Bill, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty) {
						Button delBtn = new Button("否决");
						delBtn.setPrefSize(50, 10);
						// delBtn.getStylesheets().add("/css/stockseller/buttonInTable.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								String billType = BillType.getValue().toString();
								switch(billType) {
								case"库存类":{
									StockBill Reject = (StockBill) this.getTableView().getItems().get(getIndex());
						            StockBillVO vo = Reject.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
						            managerBillService.rejectStockBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Reject);
						            break;
								}
								case"进货类":{
									SalesInBill Reject = (SalesInBill) this.getTableView().getItems().get(getIndex());
						            SalesInBillVO vo = Reject.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
						            managerBillService.rejectSalesInBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Reject);
						            break;
								}
								case"销售类":{
									SalesOutBill Reject = (SalesOutBill) this.getTableView().getItems().get(getIndex());
						            SalesOutBillVO vo = Reject.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
						            managerBillService.rejectSalesOutBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Reject);
						            break;
								}
								case"财务类":{
									FinanceBill Reject = (FinanceBill) this.getTableView().getItems().get(getIndex());
						            FinanceBillVO vo = Reject.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManagerVO(currentUser);
						            managerBillService.rejectFinanceBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Reject);
						            break;
								}
								case"现金费用类":{
									CashCostBill Reject = (CashCostBill) this.getTableView().getItems().get(getIndex());
						            CashCostBillVO vo = Reject.myself;
						            ManagerBillBLService managerBillService = new BLFactoryImpl().getManagerBillBLService();
									vo.setManager(currentUser);
						            managerBillService.rejectCashCostBill(vo);
						            //删除已被审批的行
						            ObservableList<Bill> data = BillTable.getItems();
						            data.remove(Reject);
						            break;
								}
								}
								
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

}
