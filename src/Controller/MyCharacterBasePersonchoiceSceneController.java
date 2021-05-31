package Controller;

import GUI.windows.PersonenMaske;
import GUI.windows.PersonenSuche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MyCharacterBasePersonchoiceSceneController {

    @FXML
    public Button AddPersonButton;
    @FXML
    public Button BackToMainButton;
    private Scene Startseite;

    public void back_to_main(ActionEvent actionEvent) {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(Startseite);
        window.setTitle("MyCharacterBase - Startseite");
    }

    public void add_person() throws IOException {
        System.out.println("Personen Maske openend");
        PersonenMaske mask = new PersonenMaske();
        mask.personMaskScene();
    }

    public void search_person() throws IOException {
        System.out.println("Personen Search openend");
        PersonenSuche suche = new PersonenSuche();
        suche.personSearchScene();
    }

    public void setChoosingScene(Scene scene) {
        Startseite = scene;
    }
}