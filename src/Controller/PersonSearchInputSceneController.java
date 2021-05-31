package Controller;

import Actions.Elements.DisplayPerson;
import Actions.Elements.Person;
import Actions.PersonSearch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class PersonSearchInputSceneController implements Initializable {

    public static Person[] persons;
    private final ObservableList<DisplayPerson> displayPeople = FXCollections.observableArrayList();
    public TextField uidField;
    public TextField prenameField;
    public TextField sirnameField;
    public TextField dayField;
    public TextField monthField;
    public TextField yearField;
    public Label warning;
    public Button searchButton;
    @FXML
    private TableView<DisplayPerson> tableView;
    @FXML
    private TableColumn<DisplayPerson, String> Content;
    @FXML
    private TableColumn<DisplayPerson, Button> Buttons;

    public void back(ActionEvent actionEvent) {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void search_person() {
        warning.setText("");
        if (!uidField.getText().equals("") || !prenameField.getText().equals("") || !sirnameField.getText().equals("") || (!dayField.getText().equals("") && !monthField.getText().equals("") && !yearField.getText().equals(""))) {
            Person[] search_result = PersonSearch.fileSearcher(prenameField.getText(), sirnameField.getText(), uidField.getText(), dayField.getText(), monthField.getText(), yearField.getText());
            persons = search_result;
            if (search_result.length == 0) {
                warning.setText("*No such person found ...");
            } else {
                setPersons(search_result);
            }
        } else {
            warning.setText("*You need to add at least one information");
        }
    }

    public void initCol() {
        Content.setCellValueFactory(new PropertyValueFactory<>("information"));
        Buttons.setCellValueFactory(new PropertyValueFactory<>("select"));

        tableView.getColumns().forEach(e -> e.impl_setReorderable(false));
    }

    public void populateTabel() {
        tableView.getItems().setAll(displayPeople);
    }

    public void setPersons(Person[] array) {
        displayPeople.clear();
        int i = 0;
        for (Person person : array) {
            DisplayPerson item = new DisplayPerson(i, person.getPrename(), person.getSirname(), person.getBirthday(), person.getNotes(), new Button("select"));
            displayPeople.add(item);
            i++;
        }
        initCol();
        populateTabel();
    }

    //Not working
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                if (k.getCode().equals(KeyCode.ENTER)) {
                    search_person();
                }
            }
        });
    }
}
