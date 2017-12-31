package ui.stocksellerui;

import auxiliary.PurchaseBill;
import blimpl.blfactory.BLFactoryImpl;
import blservice.mainblservice.MainBLService;
import javafx.collections.FXCollections;
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
import status.Log_In_Out_Status;
import ui.adminui.LoginController;
import ui.common.Dialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * author:Jiang_Chen date:2017/12/13
 */
public class PurchaseCreateViewController implements Initializable {
	Stage stage = StageSingleton.getStage();
	Dialog dialog = new Dialog();

	@FXML
	Button purcRetCreateButton;
	@FXML

	Button salesCreateButton;
	@FXML
	Button salesRetCreateButton;
	@FXML
	Button cancelButton, delRowButton, addRowButton, sureButton, chooseCommodityButton;

	@FXML
	TableView<PurchaseBill> purchaseBillTableView;
	@FXML
	TableColumn<PurchaseBill, String> IdCol, NameCol, TypeCol, PriceCol, NumberCol, RemarkCol, TotalCol;
	@FXML
	TableColumn<PurchaseBill, ComboBox> IsSelectCol;

	@FXML
	TextField nameField, remarkField, numberField;
	@FXML
	Label idLabel, priceLabel, totalLabel, billTotalMoney;
	@FXML
	ComboBox<String> typeBox;

	public void showTableView() {
		NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
		NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
		TypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
		TotalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));
		RemarkCol.setCellValueFactory(new PropertyValueFactory<>("Remark"));
		IsSelectCol.setCellValueFactory(new PropertyValueFactory<>("IsSelected"));
		// billTotalMoney.setText("0");
	}

	@FXML
	public void chooseCommodityButtonAction(ActionEvent e) {
		nameField.setText("Hot-dog");
		idLabel.setText("17-12-11-40");
		priceLabel.setText("21");
		ObservableList<String> options = FXCollections.observableArrayList();
		typeBox.setItems(options);
		for (int i = 0; i < 10; i++) {
			typeBox.getItems().add(String.valueOf(i));
		}
	}

	@FXML
	public void numberFieldAction(ActionEvent e) {
		totalLabel.setText(
				String.valueOf(Double.parseDouble(priceLabel.getText()) * Double.parseDouble(numberField.getText())));
	}

	/**
	 * 向库存赠送单列表添加一条信息
	 *
	 * @param e
	 */
	@FXML
	public void addRowButtonAction(ActionEvent e) {
		ObservableList<PurchaseBill> data = purchaseBillTableView.getItems();
		if (nameField.getText() != null && idLabel.getText() != null && priceLabel.getText() != null
				&& (numberField.getText() != null && !numberField.equals("0"))) {
			data.add(new PurchaseBill(numberField.getText(), idLabel.getText(), typeBox.getValue(),
					priceLabel.getText(), numberField.getText(), totalLabel.getText(), remarkField.getText()));
			if (billTotalMoney.getText() != null) {
				billTotalMoney.setText(String.valueOf(
						Double.parseDouble(billTotalMoney.getText()) + Double.parseDouble(totalLabel.getText())));
			} else {
				billTotalMoney.setText(totalLabel.getText());
			}
			nameField.setText("");
			idLabel.setText("");
			priceLabel.setText("");
			numberField.setText("");
			totalLabel.setText("");
			remarkField.setText("");

		} else {
			dialog.errorInfoDialog("Something null! Please check your input.");
		}
	}

	/**
	 * 删除选中行元素
	 *
	 * @param e
	 */
	@FXML
	public void delRowButtonAction(ActionEvent e) {
		ObservableList<PurchaseBill> data = purchaseBillTableView.getItems();
		// System.out.println("test");
		int count = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getIsSelected().isSelected()) {
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < data.size(); j++) {
				if (data.get(j).getIsSelected().isSelected()) {
					String totalOfRow = data.get(j).getTotal();
					data.remove(j);
					billTotalMoney.setText(String
							.valueOf(Double.parseDouble(billTotalMoney.getText()) - Double.parseDouble(totalOfRow)));
				}
			}
		}
		dialog.infoDialog("Delete all selected successfully!");
	}

	/**
	 * 返回上一界面
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void cancelButtonAction(ActionEvent e) throws IOException {
		try {
			BillCreateViewController controller = (BillCreateViewController) replaceSceneContent2(
					"/view/stockseller/BillCreate.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@FXML
	Button BackToLogin;

	/**
	 * 返回登录界面
	 *
	 * @param e
	 * @throws IOException
	 */
	public void handleBackToLoginButtonAction(ActionEvent e) throws IOException {
		try {
			MainBLService mainBLService = new BLFactoryImpl().getMainBLService();
			boolean b = dialog.confirmDialog("Do you want to logout?");
			if (b == true) {
				LoginController controller = (LoginController) replaceSceneContent2("/view/admin/Login.fxml");
				Log_In_Out_Status log_in_out_status = mainBLService.logout(idOfCurrentUser.getText());
				if (Log_In_Out_Status.Logout_Sucess == log_in_out_status) {
					dialog.infoDialog("Logout successfully");
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 进货退货单
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void purcRetCreateButtonAction(ActionEvent e) throws IOException {
		try {
			PurcRetCreateViewController controller = (PurcRetCreateViewController) replaceSceneContent2(
					"/view/stockseller/PurcRetCreate.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 销售单
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void salesCreateButtonAction(ActionEvent e) throws IOException {
		try {
			SalesCreateViewController controller = (SalesCreateViewController) replaceSceneContent(
					"/view/stockseller/SalesCreate.fxml");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 销售退货单
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void salesRetCreateButtonAction(ActionEvent e) throws IOException {
		try {
			SalesRetCreateViewController controller = (SalesRetCreateViewController) replaceSceneContent(
					"/view/stockseller/SalesRetCreate.fxml");
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
		Scene scene = new Scene(page, 900, 700);

		stage.setScene(scene);
		stage.setResizable(false);
		stage.sizeToScene();
		stage.setResizable(false);
		return (Initializable) loader.getController();
	}

	private Initializable replaceSceneContent2(String fxml) throws Exception {
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
		stage.setResizable(false);
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
		categoryOfCurrentUser.setText("身份：" + LoginController.getCategory());
		showTableView();
	}

}