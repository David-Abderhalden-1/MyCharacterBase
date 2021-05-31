package GUI.windows;

import Controller.ConfirmController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonenMaske {

    private final Stage window = new Stage();

    public void personMaskScene() throws IOException {
        //Scene
        FXMLLoader person_mask_main = new FXMLLoader(ConfirmController.class.getResource("/GUI/fxml/PersonMask__Creator__Scene.fxml"));
        Parent person_mask_loaded = person_mask_main.load();
        Scene person_mask = new Scene(person_mask_loaded, 1035, 690);

        //Window
        window.setTitle("MyCharacterBase - Personenmaske");
        window.setScene(person_mask);
        window.getIcons().add(new Image("/GUI/css/images/freunde.png"));
        window.setX(400);
        window.setY(200);
        window.showAndWait();

    }
}
