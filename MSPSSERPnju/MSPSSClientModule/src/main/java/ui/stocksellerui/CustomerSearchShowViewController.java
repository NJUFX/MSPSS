package ui.stocksellerui;

import auxiliary.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import ui.adminui.LoginController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class CustomerSearchShowViewController implements Initializable {
	Stage stage = StageSingleton.getStage();

	@FXML
	Button CustomerAddButton;
	@FXML
	Button CustomerDelButton;
	@FXML
	Button CustomerModButton;
	@FXML
	Button backButton;
	@FXML
	Button BackToLogin;

	@FXML
	TableView<Customer> customerTableView;
	@FXML
	TableColumn<Customer, String> NameCol, IdCol, CategoryCol, LevelCol, DAECol, ReceivableCol, OperationCol;
	// customer()顺序：id、name、category、level、DAE、receivable

	public void showTableView() {
		NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		CategoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
		LevelCol.setCellValueFactory(new PropertyValueFactory<>("Level"));
		DAECol.setCellValueFactory(new PropertyValueFactory<>("DAE"));
		ReceivableCol.setCellValueFactory(new PropertyValueFactory<>("ReceivableLimit"));

		OperationCol.setCellFactory((col) -> {
			TableCell<Customer, String> cell = new TableCell<Customer, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty) {
						Button delBtn = new Button("选择");
						delBtn.setPrefSize(100, 10);
						// delBtn.setFont(Font.font(12));
						delBtn.getStylesheets().add("/css/stockseller/buttonInTable.css");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							// OperateCommodity =
							// this.getTableView().getItems().get(this.getIndex());
							try {
								CustomerInfoShowViewController controller = (CustomerInfoShowViewController) replaceSceneContent(
										"/view/stockseller/CustomerInfoShow.fxml");
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
		addRow();
	}

	public void addRow() {
		ObservableList<Customer> data = customerTableView.getItems();
		data.add(new Customer("00001", "Jiang Chen", "进货商", "4", "50000", "SS001"));
		data.add(new Customer("1", "1", "1", "1", "1", "1"));
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
	 * 返回上一界面
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void backButtonAction(ActionEvent e) throws IOException {
		try {
			CustomerSearchViewController controller = (CustomerSearchViewController) replaceSceneContent(
					"/view/stockseller/CustomerSearch.fxml");
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
		stage.setResizable(false);
		return (Initializable) loader.getController();
	}

	@FXML
	Label idOfCurrentUser, nameOfCurrentUser, categoryOfCurrentUser;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		idOfCurrentUser.setText("编号：" + LoginController.getCurrentUser().getID());
		nameOfCurrentUser.setText("姓名：" + LoginController.getCurrentUser().getName());
		categoryOfCurrentUser.setText("身份" + LoginController.getCategory());
		showTableView();
	}

}
