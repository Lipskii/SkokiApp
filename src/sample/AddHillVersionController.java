package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.util.*;


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

        typeOfHillComboBox.setItems(dataSource.getTypeOfHills());
        typeOfHillComboBox.getSelectionModel().select(0);


        //fix later to prevent user from typing two dots
        firstYearTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                firstYearTextField.setText(t1.replaceAll("[^\\d]", ""));
            }
        });

        lastYearTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                lastYearTextField.setText(t1.replaceAll("[^\\d]", ""));
            }
        });

        inrunLengthTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                inrunLengthTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        inrunAngleTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                inrunAngleTextField.setText(t1.replaceAll("[^\\d\\.]]", ""));
            }
        });

        takeOffLengthTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                takeOffLengthTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        takeOffAngleTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                takeOffAngleTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        takeOffHeightTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                takeOffHeightTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        kPointTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                kPointTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        hillSizeTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                hillSizeTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        hillVersionRecordTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                hillVersionRecordTextField.setText(t1.replaceAll("[^\\d\\.]", ""));
            }
        });

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(0);

        countryComboBox.valueProperty().addListener(((observableValue, country, t1) -> {
            hillListView.setItems(dataSource.getHillByCountry(t1));
            visibility(false);
        }));

        hillListView.getSelectionModel().selectedItemProperty().addListener((observableValue, hill, t1) -> {
            selectedHill = t1;
            hillVersionListView.setItems(dataSource.getHillVersionByHill(selectedHill));
        });


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
        int firstYear = 0;
        int lastYear = 0;
        BigDecimal inrunLength = BigDecimal.valueOf(0);
        BigDecimal inrunAngle = BigDecimal.valueOf(0);
        BigDecimal takeOffLength = BigDecimal.valueOf(0);
        BigDecimal takeOffHeight = BigDecimal.valueOf(0);
        BigDecimal takeOffAngle = BigDecimal.valueOf(0);
        BigDecimal kPoint = BigDecimal.valueOf(0);
        BigDecimal hillSize = BigDecimal.valueOf(0);
        BigDecimal versionRecord = BigDecimal.valueOf(0);

        if (!firstYearTextField.getText().isEmpty()) firstYear = Integer.parseInt(firstYearTextField.getText());
        if (!lastYearTextField.getText().isEmpty()) lastYear = Integer.parseInt(lastYearTextField.getText());
        if (!inrunLengthTextField.getText().isEmpty())
            inrunLength = BigDecimal.valueOf(Double.parseDouble(inrunLengthTextField.getText()));
        if (!inrunAngleTextField.getText().isEmpty())
            inrunAngle = BigDecimal.valueOf(Double.parseDouble(inrunAngleTextField.getText()));
        if (!takeOffAngleTextField.getText().isEmpty())
            takeOffAngle = BigDecimal.valueOf(Double.parseDouble(takeOffAngleTextField.getText()));
        if (!takeOffLengthTextField.getText().isEmpty())
            takeOffLength = BigDecimal.valueOf(Double.parseDouble(takeOffLengthTextField.getText()));
        if (!takeOffHeightTextField.getText().isEmpty())
            takeOffHeight = BigDecimal.valueOf(Double.parseDouble(takeOffHeightTextField.getText()));
        if (!kPointTextField.getText().isEmpty())
            kPoint = BigDecimal.valueOf(Double.parseDouble(kPointTextField.getText()));
        if (!hillSizeTextField.getText().isEmpty())
            hillSize = BigDecimal.valueOf(Double.parseDouble(hillSizeTextField.getText()));
        if (!hillVersionRecordTextField.getText().isEmpty())
            versionRecord = BigDecimal.valueOf(Double.parseDouble(hillVersionRecordTextField.getText()));


        dataSource.addHillVersion(firstYear, lastYear, inrunLength, inrunAngle, takeOffLength, takeOffAngle,
                takeOffHeight, kPoint, hillSize, versionRecord, typeOfHillComboBox.getValue(), selectedHill);

        visibility(false);

    }

    //temporary solution TODO(find better solution)
    private void visibility(Boolean currentVisibility) {
        for (Node node : nodeList) {
            node.setVisible(currentVisibility);
        }
    }
}
