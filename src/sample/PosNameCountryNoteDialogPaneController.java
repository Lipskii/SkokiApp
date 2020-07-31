package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;


public class PosNameCountryNoteDialogPaneController {

    @FXML
    ComboBox countryComboBox;
    @FXML
    ComboBox cityComboBox;
    @FXML
    ComboBox hillComboBox;
    @FXML
    ComboBox hillVersionComboBox;
    @FXML
    ComboBox seriesComboBox;
    @FXML
    ComboBox subseriesComboBox;
    @FXML
    ComboBox venueComboBox;
    @FXML
    DatePicker datePicker;  //SEASON będzie wyliczany na podstawie daty
    @FXML
    TextField seriesRoundTextField;
    @FXML
    TextField subSeriesRoundTextField;


    public void initialize() {
        DataSource dataSource = new DataSource();

        //set current date as default; more of a tip for a user
        datePicker.setValue(LocalDate.now());

        //To prevent user from typing anything else than numbers
        seriesRoundTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                if (!newValue.matches("\\d*")) {
                    seriesRoundTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        subSeriesRoundTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                if (!newValue.matches("\\d*")) {
                    subSeriesRoundTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        countryComboBox.setItems(FXCollections.observableArrayList(dataSource.getCountryList())); //TODO add listener to update venueComboBox
        countryComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Country country = (Country) countryComboBox.getValue();
                ObservableList<City> cities = dataSource.getCityByCountry(country);
                cityComboBox.setItems(cities);
            }
        });

        cityComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                City city = (City) cityComboBox.getValue();
                ObservableList<Venue> venues = dataSource.getVenueByCity(city);
                venueComboBox.setItems(venues);
            }
        });

        hillComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Venue venue = (Venue) venueComboBox.getValue();
                ObservableList<Hill> hills = dataSource.getHillByVenue(venue);
                hillComboBox.setItems(hills);
            }
        });

        hillVersionComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Hill hill = (Hill) hillComboBox.getValue();
                ObservableList<HillVersion> hillVersions = dataSource.getHillVersionByHill(hill);
                hillVersionComboBox.setItems(hillVersions);
            }
        });

        seriesComboBox.setItems(dataSource.getSeriesList());
        subseriesComboBox.setItems(dataSource.getSubSeriesList());

    }
}
//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)