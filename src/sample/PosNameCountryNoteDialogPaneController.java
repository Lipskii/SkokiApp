package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PosNameCountryNoteDialogPaneController {

    @FXML
    ComboBox countryComboBox;
    @FXML
    ComboBox venueComboBox;


    public void initialize() {
        DataSource dataSource = new DataSource();
        countryComboBox.setItems(FXCollections.observableArrayList(dataSource.getCountryList())); //TODO add listener to update venueComboBox
    }
}
