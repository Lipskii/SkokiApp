package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddResultsController {

   private DataSource dataSource;

   @FXML
   CheckBox koCheckBox;
   @FXML
   CheckBox teamCheckBox;
   @FXML
   ComboBox<City> cityComboBox;
   @FXML
   ComboBox<Country> countryComboBox;
   @FXML
   ComboBox<Hill> hillComboBox;
   @FXML
   ComboBox<HillVersion> hillVersionComboBox;
   @FXML
   ComboBox<Season> seasonComboBox;
   @FXML
   ComboBox<Series> seriesComboBox;
   @FXML
   ComboBox<Subseries> subSeriesComboBox;
   @FXML
   ComboBox<Venue> venueComboBox;
   @FXML
   DatePicker firstDayDatePicker;
   @FXML
   DatePicker secondDayDatePicker;
   @FXML
   Label firstDayDatePickerErrorLabel;
   @FXML
   Label secondDayDatePickerErrorLabel;
   @FXML
   TextField seriesRoundTextField;

   public void initialize() {
      dataSource = new DataSource();
      seasonComboBox.setItems(dataSource.getSeasons());
      seasonComboBox.getSelectionModel().select(0);
      seriesComboBox.setItems(dataSource.getSeries());
      seriesComboBox.getSelectionModel().select(0);
      subSeriesComboBox.setItems(dataSource.getSubSeries());

      seriesRoundTextField.textProperty().addListener((observableValue, s, t1) -> {
         if (!t1.matches("\\d*")) {
            seriesRoundTextField.setText(t1.replaceAll("[^\\d]", ""));
         }
      });

      firstDayDatePicker.getEditor().setText("2000-12-31");

      firstDayDatePicker.getEditor().textProperty().addListener((observableValue, s, t1) -> {
         if (!t1.matches("\\d*")) {
            firstDayDatePicker.getEditor().setText(firstDayDatePicker.getEditor().getText().replaceAll("[^\\d-]", ""));
         }
      });

      secondDayDatePicker.getEditor().setText("2000-12-31");

      secondDayDatePicker.getEditor().textProperty().addListener((observableValue, s, t1) -> {
         if (!t1.matches("\\d*")) {
            secondDayDatePicker.getEditor().setText(secondDayDatePicker.getEditor().getText().replaceAll("[^\\d-]", ""));
         }
      });

      countryComboBox.setItems(dataSource.getCountryWithVenuesList());
      countryComboBox.getSelectionModel().select(0);

      cityComboBox.setItems(dataSource.getCityWithVenuesByCountry(countryComboBox.getValue()));
      cityComboBox.getSelectionModel().select(0);

      venueComboBox.setItems(dataSource.getVenueByCity(cityComboBox.getValue()));
      venueComboBox.getSelectionModel().select(0);

      hillComboBox.setItems(dataSource.getHillByVenue(venueComboBox.getValue()));
      hillComboBox.getSelectionModel().select(0);

      hillVersionComboBox.setItems(dataSource.getHillVersionByHill(hillComboBox.getValue()));
      hillVersionComboBox.getSelectionModel().select(0);

      countryComboBox.valueProperty().addListener((observableValue, country, t1) -> {
         cityComboBox.setItems(dataSource.getCityWithVenuesByCountry(t1));
         cityComboBox.getSelectionModel().select(0);
      });


      cityComboBox.valueProperty().addListener((observableValue, city, t1) -> {
         venueComboBox.setItems(dataSource.getVenueByCity(t1));
         venueComboBox.getSelectionModel().select(0);
      });

      venueComboBox.valueProperty().addListener((observableValue, venue, t1) -> {
         hillComboBox.setItems(dataSource.getHillByVenue(t1));
         hillComboBox.getSelectionModel().select(0);
      });

      hillComboBox.valueProperty().addListener((observableValue, venue, t1) -> {
         hillVersionComboBox.setItems(dataSource.getHillVersionByHill(hillComboBox.getValue()));
         hillVersionComboBox.getSelectionModel().select(0);
      });


   }


}
