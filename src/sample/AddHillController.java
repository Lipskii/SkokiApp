package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;


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

        refresh();

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

            hillListView.setItems(dataSource.getHillByVenue(venueComboBox.getValue()));
            hillNameTextField.clear();
            yearOfConstructionTextField.clear();
            lastReconstructionTextField.clear();
            reconstructionsTextField.clear();
            refresh();

        } else {
            mandatoryFieldLabel.setVisible(true);
        }

    }

    public void refresh() {

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> cityComboBox.setItems(dataSource.getCityByCountry(t1)));


        cityComboBox.valueProperty().addListener((observableValue, city, t1) -> venueComboBox.setItems(dataSource.getVenueByCity(t1)));


        venueComboBox.valueProperty().addListener((observableValue, venue, t1) -> hillListView.setItems(dataSource.getHillByVenue(t1)));


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
}
