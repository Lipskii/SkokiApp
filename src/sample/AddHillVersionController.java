package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class AddHillVersionController {

    DataSource dataSource;
    Hill selectedHill;
    Group group;

    @FXML
    Button selectButton;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<TypeOfHill> typeOfHillComboBox;
    @FXML
    Label selectionLabel;
    @FXML
    Label typeOfHillLabel;
    @FXML
    ListView<Hill> hillListView;

    public void initialize() {
        dataSource = new DataSource();

        group = new Group();

        group.getChildren().addAll(typeOfHillComboBox, typeOfHillLabel);
        group.setVisible(false);

        refresh();

        hillListView.getSelectionModel().selectedItemProperty().addListener((observableValue, hill, t1) -> {
            selectedHill = t1;
        });

    }


    @FXML
    public void handleSelectButton() {
        if (selectedHill != null) {
            selectionLabel.setText("You've selected " + selectedHill);
            group.setVisible(true);
            System.out.println("DONE");
        } else
            selectionLabel.setText("Choose a hill to proceed");
    }


    public void refresh() {
        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.valueProperty().addListener(((observableValue, country, t1) -> hillListView.setItems(dataSource.getHillByCountry(t1))));

        typeOfHillComboBox.setItems(dataSource.getTypeOfHills());
    }
}
