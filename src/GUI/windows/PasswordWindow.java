package GUI.windows;

import Controller.ConfirmController;
import Controller.PasswordController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordWindow {

    public static boolean display(String title, String message, String password, byte[] salt) throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image("/GUI/css/images/password.png"));
        window.setTitle(title);

        //Scene
        FXMLLoader confirm_box_main = new FXMLLoader(ConfirmController.class.getResource("/GUI/fxml/Passwordwindow__Scene.fxml"));
        Parent confirm_box_loaded = confirm_box_main.load();
        Scene confirm_box = new Scene(confirm_box_loaded, 250, 150);
        PasswordController controller = confirm_box_main.getController();
        controller.setLabel(message); controller.setPW(password); controller.setSalt(salt);


        //Window
        window.setScene(confirm_box);
        window.showAndWait();
        return controller.bool;
    }
}
