package sample;

import BuchalkaCourse.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;
import java.util.List;


public class PosNameCountryNoteDialogPaneController {

    @FXML
    ComboBox countryComboBox;
    @FXML
    ComboBox venueComboBox;


    public void initialize() {
        DataSource dataSource = new DataSource();
        countryComboBox.setItems(FXCollections.observableArrayList(dataSource.getCountryList())); //TODO add listener to update venueComboBox
        countryComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Country country = (Country) countryComboBox.getValue();
                ObservableList<Region> list = dataSource.getRegionsByCountry(country);
                venueComboBox.setItems(list);
            }
        });
    }
}
//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)