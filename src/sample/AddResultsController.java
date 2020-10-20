package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddResultsController {

   private DataSource dataSource;

   @FXML
   ComboBox<Season> seasonComboBox;
   @FXML
   ComboBox<Series> seriesComboBox;
   @FXML
   ComboBox<Subseries> subSeriesComboBox;
   @FXML
   TextField seriesRoundTextField;

   public void initialize() {
      dataSource = new DataSource();
      seasonComboBox.setItems(dataSource.getSeasons());
      seasonComboBox.getSelectionModel().select(0);
      seriesComboBox.setItems(dataSource.getSeries());
      seriesComboBox.getSelectionModel().select(0);
      subSeriesComboBox.setItems(dataSource.getSubSeries());
      //subSeriesComboBox.getItems().add(null);

      seriesRoundTextField.textProperty().addListener((observableValue, s, t1) -> {
         if (!t1.matches("\\d*")) {
            seriesRoundTextField.setText(t1.replaceAll("[^\\d]", ""));
         }
      });
   }


}
