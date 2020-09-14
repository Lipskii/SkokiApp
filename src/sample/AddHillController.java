package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import javax.xml.crypto.Data;

public class AddHillController {

    private DataSource dataSource;

    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<Venue> venueComboBox;
    @FXML
    ListView<Hill> hillListView;

    public void initialize() {
        dataSource = new DataSource();

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            cityComboBox.setItems(dataSource.getCityByCountry(t1));
        });

        cityComboBox.valueProperty().addListener((observableValue, city, t1) -> {
            venueComboBox.setItems(dataSource.getVenueByCity(t1));
        });

        venueComboBox.valueProperty().addListener((observableValue, venue, t1) -> {
            System.out.println();
        });
    }
}
