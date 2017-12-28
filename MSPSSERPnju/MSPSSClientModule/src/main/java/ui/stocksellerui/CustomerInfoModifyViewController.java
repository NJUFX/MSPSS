package ui.stocksellerui;

import blimpl.blfactory.BLFactoryImpl;
import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainApp;
import main.StageSingleton;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import ui.common.Dialog;
import util.Kind_Of_Customers;
import util.ResultMessage;
import vo.CustomerVO;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoModifyViewController implements Initializable {
    Dialog dialog = new Dialog();
    Stage stage = StageSingleton.getStage();
    CustomerBLService customerBLService = new BLFactoryImpl().getCustomerBLService();
    CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    CustomerVO customerVO;
    String id_to_show = customerVO.getID();

    @FXML
    Button sureButton;
    @FXML
    Button cancelButton;
    @FXML
    TextField nameField, phoneField, addressField, postcodeField, emailField, inValueField;
    @FXML
    Label idLabel, workerLabel;
    @FXML
    ComboBox<String> categoryBox, levelBox;

    @FXML
    public void cancelButtonAction(ActionEvent e) {
        cancelButton.getScene().getWindow().hide();
    }

    @FXML
    public void sureButtonAction(ActionEvent e) {
        //sureButton.getScene().getWindow().hide();
        Kind_Of_Customers kind_of_customers = Kind_Of_Customers.SUPPLIER;
        if (categoryBox.getValue().equals("销售商")) {
            kind_of_customers = Kind_Of_Customers.SALER;
        }
        if (levelBox.getValue() != null && !levelBox.getValue().trim().equals("") &&
                nameField.getText() != null && !nameField.getText().trim().equals("") &&
                phoneField.getText() != null && !phoneField.getText().trim().equals("") &&
                addressField.getText() != null && !addressField.getText().trim().equals("") &&
                postcodeField.getText() != null && !postcodeField.getText().trim().equals("") &&
                emailField.getText() != null && !emailField.getText().trim().equals("") &&
                inValueField.getText() != null && !inValueField.getText().trim().equals("")) {
            CustomerVO newCustomer = new CustomerVO(customerVO.getID(), kind_of_customers, Integer.valueOf(levelBox.getValue()), nameField.getText().trim(), phoneField.getText().trim(),
                    addressField.getText().trim(), postcodeField.getText().trim(), emailField.getText().trim(), Double.parseDouble(inValueField.getText().trim()), customerVO.getIncomemoney(),
                    customerVO.getPaymoney(), workerLabel.getText().trim());
            ResultMessage resultMessage = customerBLService.modifyCustomer(newCustomer);

            if (resultMessage == ResultMessage.SUCCESS) {
                dialog.infoDialog("Modify the customer successfully");
                sureButton.getScene().getWindow().hide();
                try {
                    CustomerInfoShowViewController controller = (CustomerInfoShowViewController) replaceSceneContent(
                            "/view/stockseller/CustomerInfoShow.fxml");
                    controller.id_to_show = id_to_show;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            dialog.errorInfoDialog("Something null, please check your input.");
        }

    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 900.0, 560.0);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (customerVO != null) {
            idLabel.setText(customerVO.getID());
            nameField.setText(customerVO.getName());
            phoneField.setText(customerVO.getPhonenumber());
            addressField.setText(customerVO.getAddress());
            postcodeField.setText(customerVO.getPostcode());
            emailField.setText(customerVO.getEmail());
            inValueField.setText(String.valueOf(customerVO.getInvalue()));
            String category = "进货商";
            if (customerVO.getCategory() == Kind_Of_Customers.SALER) {
                category = "销售商";
            }
            categoryBox.setValue(category);
            levelBox.setValue(String.valueOf(customerVO.getLevel()));
            workerLabel.setText(customerVO.getDAE());
        }
    }
}

