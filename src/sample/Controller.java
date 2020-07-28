package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;

public class Controller {

    private DataSource dataSource;

    //Buttons
    @FXML
    private Button addResultButton;
    @FXML
    private Button allTimeRankingButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button hillsButton;
    @FXML
    private Button juryButton;
    @FXML
    private Button resultsButton;
    @FXML
    private Button skiJumpersButton;

    //Labels
    @FXML
    private Label headingLabel;


    public void initialize() {
        dataSource = new DataSource();
    }

    @FXML
    public void handleAddResultButton() {
        addResultButton.setVisible(false);
        allTimeRankingButton.setVisible(false);
        juryButton.setVisible(false);
        resultsButton.setVisible(false);
        skiJumpersButton.setVisible(false);
        hillsButton.setVisible(false);
        cancelButton.setVisible(true);
        headingLabel.setText("Add result");
    }

    @FXML
    public void cancelButton() {
        addResultButton.setVisible(true);
        allTimeRankingButton.setVisible(true);
        juryButton.setVisible(true);
        resultsButton.setVisible(true);
        skiJumpersButton.setVisible(true);
        hillsButton.setVisible(true);
        cancelButton.setVisible(false);
        headingLabel.setText("Menu");
    }


}
