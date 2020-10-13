package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;


public class AddPeopleController {

    DataSource dataSource;

    @FXML
    Button addPersonButton;
    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    DatePicker birthdayDatePicker;
    @FXML
    Label firstNameNotEmptyLabel;
    @FXML
    Label lastNameNotEmptyLabel;
    @FXML
    ListView<Person> personListView;
    @FXML
    RadioButton skiJumperNoButton;
    @FXML
    RadioButton skiJumperYesButton;
    @FXML
    TextField firstNameTextField;
    @FXML
    TextField lastNameTextField;
    @FXML
    TextField searchTextField;

    public void initialize() {
        dataSource = new DataSource();

        final ToggleGroup toggleGroup = new ToggleGroup();

        skiJumperNoButton.setToggleGroup(toggleGroup);
        skiJumperYesButton.setToggleGroup(toggleGroup);

        skiJumperYesButton.setSelected(true);

        birthdayDatePicker.setValue(LocalDate.of(1999, 12, 31));

        personListView.setItems(dataSource.getPeople());

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(0);
        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            cityComboBox.setItems(dataSource.getCityByCountry(t1));
            cityComboBox.getSelectionModel().select(0);

        });


    }

    @FXML
    public void handleAddPersonButton() {
        if (firstNameTextField.getText().isEmpty())
            firstNameNotEmptyLabel.setText("Cannot be empty!");
        else
            firstNameNotEmptyLabel.setText("");

        if (lastNameTextField.getText().isEmpty())
            lastNameNotEmptyLabel.setText("Cannot be empty!");
        else
            lastNameNotEmptyLabel.setText("");


        dataSource.addPerson(firstNameTextField.getText(), lastNameTextField.getText(),
                birthdayDatePicker.getValue(), countryComboBox.getValue(), cityComboBox.getValue());

        //TODO(Refresh personListView after addition)

    }

}
