package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class AddVenueController {

    private DataSource dataSource;
    @FXML
    Button addCityButton;
    @FXML
    Button addVenueButton;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Region> regionComboBox;
    @FXML
    Label venueAddedLabel;
    @FXML
    TextField capacityTextField;
    @FXML
    TextField cityNameTextField;
    @FXML
    TextField venueNameTextField;
    @FXML
    TextField yearOfOpeningTextField;

    public void initialize() {
        dataSource = new DataSource();

        countryComboBox.setItems(FXCollections.observableArrayList(dataSource.getCountryList()));
        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            Country country1 = countryComboBox.getValue();
            ObservableList<City> cities = dataSource.getCityByCountry(country1);
            ObservableList<Region> regions = dataSource.getRegionsByCountry(country1);
            cityComboBox.setItems(cities);
            regionComboBox.setItems(regions);
        });

        //to prevent user from typing not digits
        capacityTextField.textProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    capacityTextField.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        //to prevent user from typing not digits
        yearOfOpeningTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                yearOfOpeningTextField.setText(t1.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    public void handleAddCityButton() {
        if ((regionComboBox.getValue() != null) && !cityNameTextField.getText().isEmpty()) {
            dataSource.addCity(regionComboBox.getValue(), cityNameTextField.getText());
            ObservableList<City> cities = dataSource.getCityByCountry(countryComboBox.getValue());
            cityComboBox.setItems(cities);
        }
    }

    @FXML
    public void handleAddVenueButton() {
        int capacity;
        if (capacityTextField.getText().isEmpty()) {
            capacity = 0;
        } else {
            capacity = parseInt(capacityTextField.getText());
        }
        if (!venueNameTextField.getText().isEmpty() && !yearOfOpeningTextField.getText().isEmpty() && (cityComboBox.getValue() != null)) {
            Venue venue = dataSource.addVenue(venueNameTextField.getText(), parseInt(yearOfOpeningTextField.getText()),
                    capacity, cityComboBox.getValue());
            venueAddedLabel.setText("Venue: " + venue.toString() + " added.");
        } else {
            venueAddedLabel.setText("Fields with * cannot be empty!");
        }
    }
}
