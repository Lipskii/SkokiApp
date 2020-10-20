package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import static java.lang.Integer.parseInt;


public class AddVenueController {

    private DataSource dataSource;
    @FXML
    Button addCityButton;
    @FXML
    Button addRegionButton;
    @FXML
    Button addVenueButton;
    @FXML
    Button deleteVenueButton;
    @FXML
    ComboBox<Country> countryComboBox;
    @FXML
    ComboBox<City> cityComboBox;
    @FXML
    ComboBox<Region> regionComboBox;
    @FXML
    ListView<Venue> venuesListView;
    @FXML
    TextField capacityTextField;
    @FXML
    TextField cityNameTextField;
    @FXML
    TextField regionNameTextField;
    @FXML
    TextField venueNameTextField;
    @FXML
    TextField yearOfOpeningTextField;

    //TODO fix refreshing
    public void initialize() {
        dataSource = new DataSource();

        addCityButton.setDisable(true);
        addVenueButton.setDisable(true);
        addRegionButton.setDisable(true);

        cityNameTextField.textProperty().addListener((observableValue, s, t1) ->
                addCityButton.setDisable((cityNameTextField.getText().isEmpty()) && regionComboBox.getValue() != null));

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(0);

        countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
            cityComboBox.setItems(dataSource.getCityByCountry(t1));
            cityComboBox.getSelectionModel().select(0);
            regionComboBox.setItems(dataSource.getRegionsByCountry(t1));
            regionComboBox.getSelectionModel().select(0);
        });

        venueNameTextField.textProperty().addListener(observable -> addVenueButton.setDisable(venueNameTextField.getText().isEmpty() || yearOfOpeningTextField.getText().isEmpty() || (cityComboBox.getValue() == null)));

        yearOfOpeningTextField.textProperty().addListener(observable -> addVenueButton.setDisable(venueNameTextField.getText().isEmpty() || yearOfOpeningTextField.getText().isEmpty() || (cityComboBox.getValue() == null)));

        cityComboBox.valueProperty().addListener(observable -> addVenueButton.setDisable(venueNameTextField.getText().isEmpty() || yearOfOpeningTextField.getText().isEmpty() || (cityComboBox.getValue() == null)));

        //to prevent user from typing not digits; left it as a not-lambda on purpose
        capacityTextField.textProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    capacityTextField.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        cityComboBox.valueProperty().addListener((observableValue, city, t1) -> {
            if (t1 != null) {
                ObservableList<Venue> venues = dataSource.getVenueByCity(t1);
                venuesListView.setItems(venues);
            } else {
                venuesListView.setItems(FXCollections.observableArrayList());
            }
        });

        //to prevent user from typing not digits
        yearOfOpeningTextField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                yearOfOpeningTextField.setText(t1.replaceAll("[^\\d]", ""));
            }
        });

        regionNameTextField.textProperty().addListener(observable -> addRegionButton.setDisable(regionNameTextField.getText().isEmpty()));


    }

    @FXML
    public void handleAddCityButton() {
        if ((regionComboBox.getValue() != null) && !cityNameTextField.getText().isEmpty()) {
            int index = countryComboBox.getSelectionModel().getSelectedIndex();
            dataSource.addCity(regionComboBox.getValue(), cityNameTextField.getText());
            countryComboBox.setItems(dataSource.getCountryList());
            countryComboBox.getSelectionModel().select(index);
            cityComboBox.getSelectionModel().select(0);
            cityNameTextField.clear();
        }
    }

    @FXML
    public void handleAddVenueButton() {
        int capacity;
        if (capacityTextField.getText().isEmpty()) {
            capacity = 0;
        } else {
            capacity = parseInt(capacityTextField.getText());
        }


        dataSource.addVenue(venueNameTextField.getText(), parseInt(yearOfOpeningTextField.getText()),
                capacity, cityComboBox.getValue());

        int indexCountry = countryComboBox.getSelectionModel().getSelectedIndex();
        int indexCity = cityComboBox.getSelectionModel().getSelectedIndex();

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(indexCountry);

        cityComboBox.getSelectionModel().select(indexCity);

        venuesListView.setItems(dataSource.getVenueByCity(cityComboBox.getValue()));
        venueNameTextField.clear();
        yearOfOpeningTextField.clear();
        capacityTextField.clear();


    }

    @FXML
    public void handleAddRegionButton() {
        dataSource.addRegion(regionNameTextField.getText(), countryComboBox.getValue());
        regionNameTextField.clear();
        int indexCountry = countryComboBox.getSelectionModel().getSelectedIndex();
        int indexCity = cityComboBox.getSelectionModel().getSelectedIndex();

        countryComboBox.setItems(dataSource.getCountryList());
        countryComboBox.getSelectionModel().select(indexCountry);

        cityComboBox.getSelectionModel().select(indexCity);
    }

    @FXML
    public void handleDeleteVenueButton() {
        if (venuesListView.getSelectionModel().getSelectedItem() != null) {
            dataSource.deleteRecord(venuesListView.getSelectionModel().getSelectedItem());
            int indexCountry = countryComboBox.getSelectionModel().getSelectedIndex();
            int indexCity = cityComboBox.getSelectionModel().getSelectedIndex();

            countryComboBox.setItems(dataSource.getCountryList());
            countryComboBox.getSelectionModel().select(indexCountry);

            cityComboBox.getSelectionModel().select(indexCity);
            venuesListView.setItems(dataSource.getVenueByCity(cityComboBox.getValue()));
        }
    }

}
