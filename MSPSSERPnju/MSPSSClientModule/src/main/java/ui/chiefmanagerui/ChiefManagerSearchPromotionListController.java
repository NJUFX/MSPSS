package ui.chiefmanagerui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import auxiliary.Bill;
import auxiliary.CashCostBill;
import auxiliary.CustomerPromotion;
import auxiliary.FinanceBill;
import auxiliary.GrossPromotion;
import auxiliary.GroupPromotion;
import auxiliary.Log;
import auxiliary.SalesInBill;
import auxiliary.SalesOutBill;
import auxiliary.StockBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;
import ui.common.Dialog;
import vo.CashCostBillVO;
import vo.CustomerPromotionVO;
import vo.FinanceBillVO;
import vo.GrossPromotionVO;
import vo.GroupPromotionVO;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;
import vo.UserVO;

public class ChiefManagerSearchPromotionListController implements Initializable {
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
	ComboBox PromotionType;
	@FXML
	TableView<CustomerPromotion> CustomerTable;
	@FXML
	TableView<GrossPromotion> GrossTable;
	@FXML
	TableView<GroupPromotion> GroupTable;
	@FXML
	TableColumn<CustomerPromotion, String> CustomerTableDelete;
	@FXML
	TableColumn<GrossPromotion, String> GrossTableDelete;
	@FXML
	TableColumn<GroupPromotion, String> GroupTableDelete;

	Dialog dialog = new Dialog();
	private MainApp application;
	Stage stage = StageSingleton.getStage();
	PromotionBLService promotionBLService= new BLFactoryImpl().getPromotionBLServiceStub();
	LoginController loginController = new LoginController();
	UserVO currentUser = loginController.getCurrentUser();


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		this.initTable();
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
	 * 选择查询的策略类型
	 * 
	 * @param e
	 * @throws Exception
	 */
	public void ChoosePromotionType(ActionEvent e) throws Exception {
		String promotionType = PromotionType.getValue().toString();
		CustomerTable.setVisible(false);
		GrossTable.setVisible(false);
		GroupTable.setVisible(false);
		switch (promotionType) {
		case "分级促销策略": {
			CustomerTable.setVisible(true);
			GrossTable.setVisible(false);
			GroupTable.setVisible(false);
			ObservableList<CustomerPromotion> data = CustomerTable.getItems();
			data.clear();
			//PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
			ArrayList<CustomerPromotionVO> list = promotionBLService.getAllCustomerPromotion();
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					CustomerPromotionVO temp = list.get(i);
					String giftItems = "";
					String giftNum = "";
					if (temp.getPresentationCommodityItemVOS().size() != 0) {
						for (int j = 0; j < temp.getPresentationCommodityItemVOS().size(); j++) {
							giftItems = giftItems + temp.getPresentationCommodityItemVOS().get(j).getCommodityID()+"\n";
							giftNum = giftNum + temp.getPresentationCommodityItemVOS().get(j).getNumber()+"\n";
						}
					}
					data.add(new CustomerPromotion(temp.getInitTime().toString(), temp.getEndTime().toString(),
							Integer.toString(temp.getLevel()), Double.toString(temp.getDiscount()),
							Integer.toString(temp.getVoucher()), giftItems, giftNum, temp));
				}
			}
			break;
		}
		case "总额促销策略": {
			CustomerTable.setVisible(false);
			GrossTable.setVisible(true);
			GroupTable.setVisible(false);
			ObservableList<GrossPromotion> data = GrossTable.getItems();
			data.clear();
			//PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
			ArrayList<GrossPromotionVO> list = promotionBLService.getAllGrossPromotion();
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					GrossPromotionVO temp = list.get(i);
					String giftItems = "";
					String giftNum = "";
					if (temp.getPresentationCommodityItemVOS().size() != 0) {
						for (int j = 0; j < temp.getPresentationCommodityItemVOS().size(); j++) {
							giftItems = giftItems + temp.getPresentationCommodityItemVOS().get(j).getCommodityID()+"\n";
							giftNum = giftNum + temp.getPresentationCommodityItemVOS().get(j).getNumber()+"\n";
						}
					}
					data.add(new GrossPromotion(temp.getInitTime().toString(), temp.getEndTime().toString(),
							 Double.toString(temp.getTotal()),
							Integer.toString(temp.getVoucher()), giftItems, giftNum, temp));
				}
			}
			
			break;
		}
		case "制定特价包": {
			CustomerTable.setVisible(false);
			GrossTable.setVisible(false);
			GroupTable.setVisible(true);
			ObservableList<GroupPromotion> data =  GroupTable.getItems();
			data.clear();
			//PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
			ArrayList<GroupPromotionVO> list = promotionBLService.getAllGroupPromotion();
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					GroupPromotionVO temp = list.get(i);
					String productItems = "";
					String productNum = "";
					if (temp.getCommodityIDs().size() != 0) {
						for (int j = 0; j < temp.getCommodityIDs().size(); j++) {
							productItems = productItems + temp.getCommodityIDs().get(j)+"\n";
							productNum = productNum + "1"+"\n";
						}
					}
					data.add(new GroupPromotion(temp.getInitTime().toString(), temp.getEndTime().toString(),
							 Double.toString(temp.getDiscountRate()),
							 productItems, productNum, temp));
				}
			}
			
			break;
		}
		}
	}

	/**
	 * 返回制定促销策略界面
	 * 
	 * @param e
	 * @throws Exception
	 */
	public void handleBackToPromotionButtonAction(ActionEvent e) throws Exception {
		try {
			ChiefManagerSetPromotionController controller = (ChiefManagerSetPromotionController) replaceSceneContent(
					"/view/chiefmanager/ChiefManagerSetPromotion.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void initTable() {
		CustomerTableDelete.setCellFactory((col) -> {
			TableCell<CustomerPromotion, String> cell = new TableCell<CustomerPromotion, String>() {
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
						delBtn.setPrefSize(25, 5);

						// delBtn.getStylesheets().add("/css/chiefmanager/ChiefManagerExamineBillButton.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								CustomerPromotion cp = this.getTableView().getItems().get(getIndex());
								CustomerPromotionVO deleteVO = cp.getCustomerPromotionVO();
								//PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
								promotionBLService.deleteCustomerPromotion(deleteVO);
								ObservableList<CustomerPromotion> data = CustomerTable.getItems();
								data.remove(cp);

							} catch (Exception e1) {
								e1.printStackTrace();
							}
						});
					}
				}
			};
			return cell;
		});

		GrossTableDelete.setCellFactory((col) -> {
			TableCell<GrossPromotion, String> cell = new TableCell<GrossPromotion, String>() {
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
						delBtn.setPrefSize(25, 5);

						// delBtn.getStylesheets().add("/css/chiefmanager/ChiefManagerExamineBillButton.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								GrossPromotion gp = this.getTableView().getItems().get(getIndex());
								GrossPromotionVO deleteVO = gp.getGrossPromotionVO();
								//PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
								promotionBLService.deleteGrossPromotion(deleteVO);
								ObservableList<GrossPromotion> data = GrossTable.getItems();
								data.remove(gp);

							} catch (Exception e1) {
								e1.printStackTrace();
							}
						});
					}
				}
			};
			return cell;
		});

		GroupTableDelete.setCellFactory((col) -> {
			TableCell<GroupPromotion, String> cell = new TableCell<GroupPromotion, String>() {
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
						delBtn.setPrefSize(25, 5);

						// delBtn.getStylesheets().add("/css/chiefmanager/ChiefManagerExamineBillButton.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							try {
								GroupPromotion gp = this.getTableView().getItems().get(getIndex());
								GroupPromotionVO deleteVO = gp.getGroupPromotionVO();
								//PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
								promotionBLService.deleteGroupPromotion(deleteVO);
								ObservableList<GroupPromotion> data = GroupTable.getItems();
								data.remove(gp);

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
