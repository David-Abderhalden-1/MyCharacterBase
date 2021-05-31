package GUI.windows;

import Controller.ConfirmController;
import Controller.MyCharacterBasePersonchoiceSceneController;
import Controller.MyCharacterBaseStartseiteMainController;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MyCharacterBaseMain extends Application {

    public Stage window;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;

        //Methods
        window.setOnCloseRequest(event -> {
            try {
                closeProgram(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //Startscene
        FXMLLoader startwindow_main = new FXMLLoader(getClass().getResource("/GUI/fxml/Startwindow__Startseite__Scene.fxml"));
        Parent startwindow_loaded = startwindow_main.load();
        Scene startseite = new Scene(startwindow_loaded, 1035, 690);


        //ChooseActionScene
        FXMLLoader sceneloader_main = new FXMLLoader(getClass().getResource("/GUI/fxml/Startwindow__Sceneloader__Scene.fxml"));
        Parent scenenloader_loaded = sceneloader_main.load();
        Scene sceneloader = new Scene(scenenloader_loaded, 1035, 690);


        // injecting second scene into the controller of the first scene
        MyCharacterBaseStartseiteMainController startseite_controller = startwindow_main.getController();
        startseite_controller.setChoosingScene(sceneloader);

        // injecting first scene into the controller of the second scene
        MyCharacterBasePersonchoiceSceneController sceneloader_controller = sceneloader_main.getController();
        sceneloader_controller.setChoosingScene(startseite);

        //Primary Window
        window.setTitle("MyCharacterBase - Startseite");
        window.getIcons().add(new Image("/GUI/css/images/freunde.png"));
        window.setScene(startseite);
        window.show();
    }


    private void closeProgram(Event e) throws IOException {
        ConfirmWindow.display("Close Program", "Do you want to close the Program?");
        boolean answer = ConfirmController.action;
        if (answer) {
            window.close();
        } else {
            e.consume();
        }
    }
}