package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddVenueController {

    @FXML
    Button addCityButton;
    @FXML
    Button addHillButton;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Region> regionComboBox;
    @FXML
    TextField capacityTextField;
    @FXML
    TextField cityNameTextField;
    @FXML
    TextField venueNameTextField;
    @FXML
    TextField yearOfOpeningTextField;

    public void initialize() {
        DataSource dataSource = new DataSource();

        countryComboBox.setItems(FXCollections.observableArrayList(dataSource.getCountryList()));
        countryComboBox.valueProperty().addListener(new ChangeListener<Country>() {
            @Override
            public void changed(ObservableValue<? extends Country> observableValue, Country country, Country t1) {
                Country country1 = countryComboBox.getValue();
                ObservableList<City> cities = dataSource.getCityByCountry(country1);
                ObservableList<Region> regions = dataSource.getRegionsByCountry(country1);
                cityComboBox.setItems(cities);
                regionComboBox.setItems(regions);
            }
        });

        //to prevent user from typing not digits
        capacityTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    capacityTextField.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        //to prevent user from typing not digits
        yearOfOpeningTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    yearOfOpeningTextField.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
