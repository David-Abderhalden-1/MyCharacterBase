package Controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConfirmController {

    public static boolean action;

    public Label label;

    public void setLabel(String text) {
        label.setText(text);
    }

    public void true_button(ActionEvent actionEvent) {
        action = true;
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.close();
    }


    public void false_button(ActionEvent actionEvent) {
        action = false;

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.close();
    }
}
