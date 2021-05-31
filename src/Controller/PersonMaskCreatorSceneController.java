package Controller;

import Actions.Elements.Person;
import Actions.Handler.FileHandler;
import Actions.Handler.PasswordHashing;
import GUI.windows.ConfirmWindow;
import GUI.windows.PasswordWindow;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonMaskCreatorSceneController {

    public TextField prenameField;
    public TextField sirnameField;
    public TextField dayField;
    public TextField monthField;
    public TextField yearField;
    public TextField religionField;
    public TextField notesField;
    public TextField password;
    public Button backButton;
    public Button addButton;

    public void add_person() throws IOException, NoSuchAlgorithmException, NoSuchProviderException {
        String bday = dayField.getText() + "." + monthField.getText() + "." + yearField.getText();

        //Validate Inputs
        boolean confirm_pw = true;
        if(!password.getText().equals("")){
            confirm_pw = confirm_password(password.getText());
        }
        boolean prename_validation = nameValidation(prenameField);
        boolean sirname_validation = nameValidation(sirnameField);
        boolean day_validation = dateValidation(dayField, 31, 1);
        boolean month_validation = dateValidation(monthField, 12, 1);
        boolean year_validation = dateValidation(yearField, 9999, 1000);
        boolean bday_validation = false;
        try {
            formatTime(bday);
            if (day_validation && month_validation && year_validation) {
                bday_validation = true;
            }
        } catch (Exception e) {
            if (day_validation && month_validation && year_validation) {
                dayField.getStyleClass().add("error");
                bday_validation = false;
            }
        }

        // Generate Hashed Password
        String hashedPassword = "";
        byte[] salt = null;
        if(!password.getText().equals("")){
            salt = PasswordHashing.getSalt();
            hashedPassword = PasswordHashing.hashPassword(password.getText(), salt);
        }


        if (prename_validation && sirname_validation && bday_validation && confirm_pw) {
            Person newperson = new Person(genRandom(), prenameField.getText(), sirnameField.getText(),
                    formatTime(bday), null, null, religionField.getText(), notesField.getText(), hashedPassword, salt);

            ConfirmWindow.display("create Person", "Do you want to save the person?");
            if (ConfirmController.action) {
                FileHandler.SavePerson(newperson);
            }
            prenameField.clear();
            sirnameField.clear();
            dayField.clear();
            monthField.clear();
            yearField.clear();
            religionField.clear();
            notesField.clear();
            password.clear();
        }
    }

    public void back(ActionEvent actionEvent) {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    //Move to seperat Class
    private boolean nameValidation(TextField field) {
        field.getStyleClass().remove("error");
        for (char letter : field.getText().toCharArray()) {
            if (Character.isDigit(letter)) {
                field.getStyleClass().add("error");
                return false;
            }
        }
        if (field.getText().equals("")) {
            field.getStyleClass().add("error");
            return false;
        }
        return true;
    }

    private boolean dateValidation(TextField field, int max, int min) {
        field.getStyleClass().remove("error");
        try {
            int number = Integer.parseInt(field.getText());
            if (number < min || number > max) {
                field.getStyleClass().add("error");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            field.getStyleClass().add("error");
            return false;
        }
    }

    private boolean confirm_password(String password) throws IOException {
        return PasswordWindow.display("Confirm Password", "Please repeat the password", password, null);

    }

    private int genRandom() {
        int number;
        do {
            number = (int) (Math.random() * (100000 - 1 + 1) + 1);
        } while (is_already_existing(number));
        return number;
    }

    private boolean is_already_existing(int number) {
        File f = new File("bin/persons");
        String[] filenames = f.list();
        assert filenames != null;
        for (String file : filenames) {
            if (file.contains(String.valueOf(number))) {
                System.out.println("Number already existed ...");
                return true;
            }
        }
        return false;
    }

    private LocalDate formatTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");  //exp. 18.04.2004
        return LocalDate.parse(date, formatter);
    }
}