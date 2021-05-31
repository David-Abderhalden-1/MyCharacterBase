package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyCharacterBaseStartseiteMainController {

    @FXML
    public Button person_mask_button;
    @FXML
    public Label welcome_label;
    private Scene ChooseActionScene;

    public void setChoosingScene(Scene scene) {
        ChooseActionScene = scene;
    }

    public void chooseActionScene(ActionEvent actionEvent) {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(ChooseActionScene);
        window.setTitle("MyCharacterBase - Sceneloader");
    }
}
