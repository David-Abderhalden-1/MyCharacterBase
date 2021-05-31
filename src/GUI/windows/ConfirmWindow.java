package GUI.windows;

import Controller.ConfirmController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmWindow {

    public static void display(String title, String message) throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image("/GUI/css/images/freunde.png"));
        window.setTitle(title);

        //Methods
        window.setOnCloseRequest(Event::consume);

        //Scene
        FXMLLoader confirm_box_main = new FXMLLoader(ConfirmController.class.getResource("/GUI/fxml/Confirmwindow__Scene.fxml"));
        Parent confirm_box_loaded = confirm_box_main.load();
        Scene confirm_box = new Scene(confirm_box_loaded, 250, 150);
        ConfirmController controller = confirm_box_main.getController();
        controller.setLabel(message);

        //Window
        window.setScene(confirm_box);
        window.showAndWait();
    }
}
