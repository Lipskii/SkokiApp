package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;


public class AddHillVersionController {

    DataSource dataSource;
    Hill selectedHill;
    private final List<Node> nodeList = new ArrayList<>();


    @FXML
    Button addButton;
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

        nodeList.add(typeOfHillComboBox);
        nodeList.add(typeOfHillLabel);
        nodeList.add(firstYearOfThisVersionLabel);
        nodeList.add(firstYearTextField);
        nodeList.add(lastYearOfThisVersionLabel);
        nodeList.add(lastYearTextField);
        nodeList.add(inrunAngleLabel);
        nodeList.add(inrunAngleTextField);
        nodeList.add(inrunLengthLabel);
        nodeList.add(inrunLengthTextField);
        nodeList.add(takeOffAngleLabel);
        nodeList.add(takeOffAngleTextField);
        nodeList.add(takeOfHeightLabel);
        nodeList.add(takeOffHeightTextField);
        nodeList.add(takeOffLengthLabel);
        nodeList.add(takeOffLengthTextField);
        nodeList.add(kPointLabel);
        nodeList.add(kPointTextField);
        nodeList.add(hillSizeLabel);
        nodeList.add(hillSizeTextField);
        nodeList.add(hillVersionRecordLabel);
        nodeList.add(hillVersionRecordTextField);
        nodeList.add(addButton);
        nodeList.add(hillVersionListView);
        nodeList.add(existingVersionsLabel);

        refresh();

        hillListView.getSelectionModel().selectedItemProperty().addListener((observableValue, hill, t1) -> selectedHill = t1);

    }


    @FXML
    public void handleSelectButton() {
        if (selectedHill != null) {
            selectionLabel.setText("You've selected " + selectedHill);
            visibility(true);
        } else {
            selectionLabel.setText("Choose a hill to proceed");
            visibility(false);
        }
    }

    @FXML
    public void handleAddButton() {

    }


    public void refresh() {
        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.valueProperty().addListener(((observableValue, country, t1) -> hillListView.setItems(dataSource.getHillByCountry(t1))));

        typeOfHillComboBox.setItems(dataSource.getTypeOfHills());
    }

    //temporary solution TODO(find better solution)
    public void visibility(Boolean currentVisibility) {

        for (Node node : nodeList) {
            node.setVisible(currentVisibility);
        }
    }
}
