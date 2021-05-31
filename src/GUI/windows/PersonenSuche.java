package GUI.windows;

import Controller.ConfirmController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PersonenSuche {

    private final Stage window = new Stage();

    public void personSearchScene() throws IOException {
        //First Scene
        FXMLLoader person_search_main = new FXMLLoader(ConfirmController.class.getResource("/GUI/fxml/PersonSearch__Input__Scene.fxml"));
        Parent person_search_loaded = person_search_main.load();
        Scene person_search = new Scene(person_search_loaded, 1035, 690);


        //Window
        window.setTitle("MyCharacterBase - Personensuche");
        window.setScene(person_search);
        window.getIcons().add(new Image("/GUI/css/images/profil.png"));
        window.setX(400);
        window.setY(200);
        window.showAndWait();
    }
}