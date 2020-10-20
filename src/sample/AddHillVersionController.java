package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigDecimal;

public class AddHillVersionController {

    DataSource dataSource;


    @FXML
    Button addButton;
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

        addButton.setDisable(true);

        typeOfHillComboBox.setItems(dataSource.getTypeOfHills());
        typeOfHillComboBox.getSelectionModel().select(0);


        countryComboBox.setItems(dataSource.getCountryWithHillsList());
        countryComboBox.getSelectionModel().select(0);
        hillListView.setItems(dataSource.getHillByCountry(countryComboBox.getValue()));
        hillListView.getSelectionModel().select(0);
        hillVersionListView.setItems(dataSource.getHillVersionByHill(hillListView.getSelectionModel().getSelectedItem()));
        selectionLabel.setText("You've selected: " + hillListView.getSelectionModel().getSelectedItem());

        countryComboBox.valueProperty().addListener(((observableValue, country, t1) -> {
            hillListView.setItems(dataSource.getHillByCountry(t1));
            hillListView.getSelectionModel().select(0);
        }));


        hillListView.getSelectionModel().selectedItemProperty().addListener((observableValue, hill, t1) -> {
            hillVersionListView.setItems(dataSource.getHillVersionByHill(hillListView.getSelectionModel().getSelectedItem()));
            selectionLabel.setText("You've selected: " + hillListView.getSelectionModel().getSelectedItem());
        });

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
                inrunLengthTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
        });

        inrunAngleTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                inrunAngleTextField.setText(t1.replaceAll("[^\\d.]]", ""));
            }
        });

        takeOffLengthTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                takeOffLengthTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
        });

        takeOffAngleTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                takeOffAngleTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
        });

        takeOffHeightTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                takeOffHeightTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
        });

        kPointTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                kPointTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
            addButton.setDisable(kPointTextField.getText().isEmpty());
        });

        hillSizeTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                hillSizeTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
        });

        hillVersionRecordTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.")) {
                hillVersionRecordTextField.setText(t1.replaceAll("[^\\d.]", ""));
            }
        });

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
                takeOffHeight, kPoint, hillSize, versionRecord, typeOfHillComboBox.getValue(), hillListView.getSelectionModel().getSelectedItem());

        int countryIndex = countryComboBox.getSelectionModel().getSelectedIndex();
        int hillIndex = hillListView.getSelectionModel().getSelectedIndex();

        countryComboBox.setItems(dataSource.getCountryWithHillsList());
        countryComboBox.getSelectionModel().select(countryIndex);

        hillListView.setItems(dataSource.getHillByCountry(countryComboBox.getValue()));
        hillListView.getSelectionModel().select(hillIndex);
        hillVersionListView.setItems(dataSource.getHillVersionByHill(hillListView.getSelectionModel().getSelectedItem()));
        hillVersionListView.setItems(dataSource.getHillVersionByHill(hillListView.getSelectionModel().getSelectedItem()));

    }



}
