package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;

public class Controller {

    private DataSource dataSource;
    @FXML
    private Button resultsButton;
    @FXML
    private Button allTimeRankingButton;
    @FXML
    private Label headingLabel;


    public void initialize() {
        dataSource = new DataSource();
    }


}
