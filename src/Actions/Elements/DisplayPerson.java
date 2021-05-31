package Actions.Elements;

import Controller.ConfirmController;
import Controller.PasswordController;
import Controller.PersonSearchInputSceneController;
import GUI.windows.ConfirmWindow;
import GUI.windows.PasswordWindow;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DisplayPerson {

    public String information;

    public Button select;

    public DisplayPerson(int index, String prename, String lastname, LocalDate birthday, String notes, Button select) {
        this.information = prename + " " + lastname + "\n" +
                "(" + birthday + ")\n" + notes;

        this.select = select;

        select.setOnAction(e -> {
            Person p = PersonSearchInputSceneController.persons[index];
            try {
                ConfirmWindow.display("Confirm person", "Do you want to proceed?");
                boolean answer = ConfirmController.action;
                if (answer) {
                    if (!p.getPassword().equals("")){
                        boolean val = PasswordWindow.display("Authentication", "Enter the Password: ", p.getPassword(), p.getSalt());
                        if(val){
                            System.out.println("Opened Window ...");
                            // Open Person Window
                        }
                    }else {
                        System.out.println("Opened Window ... ");
                        // Open Person Window
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            // event ...
        });
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Button getSelect() {
        return select;
    }

    public void setSelect(Button select) {
        this.select = select;
    }


}
