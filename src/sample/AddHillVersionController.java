package sample;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class AddHillVersionController {
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ListView<Hill> hillListView;

    public void initialize() {
        DataSource dataSource = new DataSource();

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.valueProperty().addListener(((observableValue, country, t1) -> hillListView.setItems(dataSource.getHillByCountry(t1))));
    }
}
