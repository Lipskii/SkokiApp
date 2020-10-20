package sample;

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
    Button addRegionButton;
    @FXML
    Button deleteRecordButton;
    @FXML
    CheckBox isActiveCheckBox;
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
    TextField regionNameTextField;
    @FXML
    TextField searchTextField;

    public void initialize() {
        dataSource = new DataSource();

        final ToggleGroup toggleGroup = new ToggleGroup();

        skiJumperNoButton.setToggleGroup(toggleGroup);
        skiJumperYesButton.setToggleGroup(toggleGroup);

        addCityButton.setDisable(true);


        skiJumperYesButton.setSelected(true);

        skiJumperYesButton.selectedProperty().addListener((observableValue, aBoolean, t1) -> isActiveCheckBox.setDisable(!skiJumperYesButton.isSelected()));
        birthdayDatePicker.getEditor().setText("2000-12-31");

        birthdayDatePicker.getEditor().textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                birthdayDatePicker.getEditor().setText(birthdayDatePicker.getEditor().getText().replaceAll("[^\\d-]", ""));
            }
        });

        personListView.setItems(dataSource.getPeople());

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(0);
        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            cityComboBox.setItems(dataSource.getCityByCountry(t1));
            cityComboBox.getSelectionModel().select(0);
            regionComboBox.setItems(dataSource.getRegionsByCountry(t1));
            regionComboBox.getSelectionModel().select(0);
        });

        cityTextField.textProperty().addListener((observableValue, s, t1) ->
                addCityButton.setDisable(cityTextField.getText().isEmpty()));


    }


    @FXML
    public void handleAddPersonButton() {
        boolean dateFlag = false;
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
            dateFlag = true;

        } catch (DateTimeParseException e) {
            System.out.println(e.getErrorIndex());
            System.out.println(e.getParsedString());
            System.out.println(e.getMessage());
            birthdayPickerLabel.setText("Incorrect Value! Date format: \"yyyy-mm-dd\"");
        }


        if (!lastNameTextField.getText().isEmpty() && !firstNameTextField.getText().isEmpty() && dateFlag) {
            Person person = dataSource.addPerson(firstNameTextField.getText(), lastNameTextField.getText(),
                    birthdayDatePicker.getValue(), countryComboBox.getValue(), cityComboBox.getValue());

            personListView.setItems(dataSource.getPeople());

            if (person != null && skiJumperYesButton.isSelected()) {
                dataSource.addSkiJumper(person, isActiveCheckBox.isSelected());
            }
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

    @FXML
    public void handleAddRegionButton() {
        dataSource.addRegion(regionNameTextField.getText(), countryComboBox.getValue());
        regionNameTextField.clear();
        int indexCountry = countryComboBox.getSelectionModel().getSelectedIndex();
        int indexCity = cityComboBox.getSelectionModel().getSelectedIndex();

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(indexCountry);

        cityComboBox.getSelectionModel().select(indexCity);
    }

    @FXML
    public void handleDeleteRecordButton() {
        if (personListView.getSelectionModel().getSelectedItem() != null) {
            dataSource.deleteRecord(personListView.getSelectionModel().getSelectedItem());
            personListView.setItems(dataSource.getPeople());
        }
    }

}
