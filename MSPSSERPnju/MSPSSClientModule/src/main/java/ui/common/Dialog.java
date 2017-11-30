package ui.common;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Dialog {
    /**
     * 提示框,选择确认后进行下一步操作，否则返回原界面
     *
     * @param p_message
     * @return
     */
    public boolean confirmDialog(String p_message) {
//        按钮部分可以使用预设的也可以像这样自己 new 一个
        ButtonType sure = new ButtonType("确定", ButtonBar.ButtonData.YES);
        ButtonType cancel = new ButtonType("取消", ButtonBar.ButtonData.NO);
        Alert _alert = new Alert(Alert.AlertType.CONFIRMATION, p_message, cancel,sure);
        _alert.setTitle("Check");
        _alert.setHeaderText("Check operation");
//        showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> _buttonType = _alert.showAndWait();
//        根据点击结果返回
        if (_buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 提示框 成功完成操作后弹出，选择确认后消失
     *
     * @param p_message
     * @return
     */
    public boolean infoDialog(String p_message) {
//        按钮部分可以使用预设的也可以像这样自己 new 一个
        Alert _alert = new Alert(Alert.AlertType.INFORMATION, p_message);
        _alert.setTitle("Info");
        _alert.setHeaderText("Information");
//        showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> _buttonType = _alert.showAndWait();
//        根据点击结果返回
        if (_buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;
        } else {
            return false;
        }
    }
}

