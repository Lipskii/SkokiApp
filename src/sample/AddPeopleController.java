package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class AddPeopleController {

    DataSource dataSource;

    @FXML
    Button addCityButton;
    @FXML
    Button addPersonButton;
    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<Region> regionComboBox;
    @FXML
    DatePicker birthdayDatePicker;
    @FXML
    Label birthdayPickerLabel;
    @FXML
    Label cityAddedLabel;
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
    TextField cityTextField;
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

        addCityButton.setDisable(true);

        skiJumperYesButton.setSelected(true);

        birthdayDatePicker.getEditor().setText("2000-12-31");
        //TODO(Add listener to prevent user from typing incorrect format)


        personListView.setItems(dataSource.getPeople());

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(0);
        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            cityComboBox.setItems(dataSource.getCityByCountry(t1));
            cityComboBox.getSelectionModel().select(0);
            regionComboBox.setItems(dataSource.getRegionsByCountry(t1));
            regionComboBox.getSelectionModel().select(0);
        });

        cityTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (cityTextField.getText().isEmpty()) {
                addCityButton.setDisable(true);
            } else
                addCityButton.setDisable(false);
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


        try {
            birthdayDatePicker.setValue(LocalDate.parse(birthdayDatePicker.getEditor().getText()));
            birthdayPickerLabel.setText("Date format: \"yyyy-mm-dd\"");

        } catch (DateTimeParseException e) {
            System.out.println(e.getErrorIndex());
            System.out.println(e.getParsedString());
            System.out.println(e.getMessage());
            birthdayPickerLabel.setText("Incorrect Value! Date format: \"yyyy-mm-dd\"");
        }


        if (!lastNameTextField.getText().isEmpty() && !firstNameTextField.getText().isEmpty()) {
            dataSource.addPerson(firstNameTextField.getText(), lastNameTextField.getText(),
                    birthdayDatePicker.getValue(), countryComboBox.getValue(), cityComboBox.getValue());

            personListView.setItems(dataSource.getPeople());

        }
    }

    @FXML
    public void handleAddCityButton() {
        if (regionComboBox.getValue() != null) {
            int index = countryComboBox.getSelectionModel().getSelectedIndex();
            City city = dataSource.addCityReturnCity(regionComboBox.getValue(), cityTextField.getText());
            countryComboBox.setItems(dataSource.getCountryList());
            countryComboBox.getSelectionModel().select(index);
            cityTextField.clear();
            cityAddedLabel.setText(city.toString() + " added!");
        }

    }

}
