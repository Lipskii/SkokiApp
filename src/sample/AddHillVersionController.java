package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;


public class AddHillVersionController {

    DataSource dataSource;
    Hill selectedHill;
    // Group group;

    @FXML
    Button selectButton;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<TypeOfHill> typeOfHillComboBox;
    @FXML
    Label existingVersionsLabel;
    @FXML
    Label firstYearOfThisVersionLabel;
    @FXML
    Label hillSizeLabel;
    @FXML
    Label hillVersionRecordLabel;
    @FXML
    Label inrunAngleLabel;
    @FXML
    Label inrunLengthLabel;
    @FXML
    Label kPointLabel;
    @FXML
    Label lastYearOfThisVersionLabel;
    @FXML
    Label selectionLabel;
    @FXML
    Label takeOffAngleLabel;
    @FXML
    Label takeOfHeightLabel;
    @FXML
    Label takeOffLengthLabel;
    @FXML
    Label typeOfHillLabel;
    @FXML
    ListView<Hill> hillListView;
    @FXML
    ListView<HillVersion> hillVersionListView;
    @FXML
    TextField firstYearTextField;
    @FXML
    TextField hillSizeTextField;
    @FXML
    TextField hillVersionRecordTextField;
    @FXML
    TextField inrunAngleTextField;
    @FXML
    TextField inrunLengthTextField;
    @FXML
    TextField kPointTextField;
    @FXML
    TextField lastYearTextField;
    @FXML
    TextField takeOffAngleTextField;
    @FXML
    TextField takeOffHeightTextField;
    @FXML
    TextField takeOffLengthTextField;

    public void initialize() {
        dataSource = new DataSource();

        // group = new Group();

        //  group.getChildren().addAll(typeOfHillComboBox, typeOfHillLabel);


        refresh();

        hillListView.getSelectionModel().selectedItemProperty().addListener((observableValue, hill, t1) -> {
            selectedHill = t1;
        });

    }


    @FXML
    public void handleSelectButton() {
        if (selectedHill != null) {
            selectionLabel.setText("You've selected " + selectedHill);
            //      group.setVisible(true);
        } else
            selectionLabel.setText("Choose a hill to proceed");
    }


    public void refresh() {
        //  group.setVisible(false);

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.valueProperty().addListener(((observableValue, country, t1) -> hillListView.setItems(dataSource.getHillByCountry(t1))));

        typeOfHillComboBox.setItems(dataSource.getTypeOfHills());
    }
}
