package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddPeopleController {

    DataSource dataSource;

    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<JuryType> juryTypeComboBox;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ListView<Person> personListView;
    @FXML
    RadioButton juryRadioButton;
    @FXML
    RadioButton skiJumperRadioButton;
    @FXML
    TextField birthdayTextField;
    @FXML
    TextField firstNameTextField;
    @FXML
    TextField lastNameTextField;
    @FXML
    TextField searchTextField;

    public void initialize() {
        dataSource = new DataSource();

        personListView.setItems(dataSource.getPeople());

    }

}
