package Controller;

import Actions.Handler.PasswordHashing;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class PasswordController {

    @FXML
    private Label label;

    @FXML
    private TextField pw;

    public static String password;

    private byte[] salt;

    public boolean bool = false;

    public void setLabel(String text) {
        label.setText(text);
    }

    public void validate(ActionEvent actionEvent) throws NoSuchAlgorithmException, NoSuchProviderException {
        pw.getStyleClass().remove("error");
        String input;
        if(salt != null){
            input = PasswordHashing.hashPassword(pw.getText(), salt);
        }else {
            input = pw.getText();
        }

        if(input.equals(password)){
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.close();
            bool = true;
        }else {
            pw.clear();
            pw.getStyleClass().add("error");
            bool = false;
        }
    }

    public void setPW(String pw) {
        password = pw;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
