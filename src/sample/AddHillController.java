package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

//TODO fix distance between radio buttons
//TODO prevent user from typing more than 4 digits in "year" fields
public class AddHillController {

    private DataSource dataSource;

    @FXML
    Button addHillButton;
    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<Venue> venueComboBox;
    @FXML
    Label mandatoryFieldLabel;
    @FXML
    ListView<Hill> hillListView;
    @FXML
    RadioButton plasticMattingRadioButtonYes;
    @FXML
    RadioButton plasticMattingRadioButtonNo;
    @FXML
    TextField hillNameTextField;
    @FXML
    TextField lastReconstructionTextField;
    @FXML
    TextField reconstructionsTextField;
    @FXML
    TextField yearOfConstructionTextField;

    public void initialize() {
        dataSource = new DataSource();

        final ToggleGroup group = new ToggleGroup();
        plasticMattingRadioButtonNo.setToggleGroup(group);
        plasticMattingRadioButtonYes.setToggleGroup(group);

        addHillButton.setDisable(true);

        countryComboBox.setItems(dataSource.getCountryWithVenuesList());
        countryComboBox.getSelectionModel().select(0);
        cityComboBox.setItems(dataSource.getCityWithVenuesByCountry(countryComboBox.getValue()));
        cityComboBox.getSelectionModel().select(0);
        venueComboBox.setItems(dataSource.getVenueByCity(cityComboBox.getValue()));
        venueComboBox.getSelectionModel().select(0);

        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            cityComboBox.setItems(dataSource.getCityWithVenuesByCountry(t1));
            cityComboBox.getSelectionModel().select(0);
        });

        cityComboBox.valueProperty().addListener((observableValue, city, t1) -> {
            venueComboBox.setItems(dataSource.getVenueByCity(t1));
            venueComboBox.getSelectionModel().select(0);
        });

        venueComboBox.valueProperty().addListener((observableValue, venue, t1) -> {
            hillListView.setItems(dataSource.getHillByVenue(t1));
            addHillButton.setDisable(hillNameTextField.getText().isEmpty()
                    || yearOfConstructionTextField.getText().isEmpty()
                    || lastReconstructionTextField.getText().isEmpty());
        });

        hillNameTextField.textProperty().addListener(observable -> addHillButton.setDisable(hillNameTextField.getText().isEmpty()
                || yearOfConstructionTextField.getText().isEmpty()
                || lastReconstructionTextField.getText().isEmpty()));

        yearOfConstructionTextField.textProperty().addListener(observable -> addHillButton.setDisable(hillNameTextField.getText().isEmpty()
                || yearOfConstructionTextField.getText().isEmpty()
                || lastReconstructionTextField.getText().isEmpty()));

        lastReconstructionTextField.textProperty().addListener(observable -> addHillButton.setDisable(hillNameTextField.getText().isEmpty()
                || yearOfConstructionTextField.getText().isEmpty()
                || lastReconstructionTextField.getText().isEmpty()
        ));


        yearOfConstructionTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                yearOfConstructionTextField.setText(t1.replaceAll("[^\\d]", ""));
            }
        });

        lastReconstructionTextField.textProperty().addListener(((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                lastReconstructionTextField.setText(t1.replaceAll("[^\\d]", ""));
            }
        }));

    }


    @FXML
    public void handleAddHillButton() {

        if (!hillNameTextField.getText().isEmpty() && !yearOfConstructionTextField.getText().isEmpty() && !lastReconstructionTextField.getText().isEmpty()) {
            mandatoryFieldLabel.setVisible(false);

            dataSource.addHill(hillNameTextField.getText(),
                    Integer.parseInt(yearOfConstructionTextField.getText()),
                    Integer.parseInt(lastReconstructionTextField.getText()),
                    reconstructionsTextField.getText(),
                    plasticMattingRadioButtonYes.isSelected(),
                    venueComboBox.getValue());

            hillNameTextField.clear();
            yearOfConstructionTextField.clear();
            lastReconstructionTextField.clear();
            reconstructionsTextField.clear();
            int countryIndex = countryComboBox.getSelectionModel().getSelectedIndex();
            int cityIndex = cityComboBox.getSelectionModel().getSelectedIndex();
            int venueIndex = venueComboBox.getSelectionModel().getSelectedIndex();
            countryComboBox.setItems(dataSource.getCountryWithVenuesList());
            countryComboBox.getSelectionModel().select(countryIndex);
            cityComboBox.getSelectionModel().select(cityIndex);
            venueComboBox.getSelectionModel().select(venueIndex);
            hillListView.setItems(dataSource.getHillByVenue(venueComboBox.getValue()));


        } else {
            mandatoryFieldLabel.setVisible(true);
        }

    }

}
