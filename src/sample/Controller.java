package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

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
    @FXML
    private ChoiceBox selectResultsTypeChoiceBox;
    @FXML
    private ListView<Region> listView;
    @FXML
    private VBox menuBox;
    @FXML
    private VBox addResultsTypeVBox;
    //Labels
    @FXML
    private Label headingLabel;
    @FXML
    private Label lowerLabel;


    public void initialize() {
        dataSource = new DataSource();
//        cancelButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(final KeyEvent event) {
//                cancelButtonFun(event);
//            }
//        });

        // listView.getItems().addAll(dataSource.regionList());

    }

    @FXML
    public void handleAddResultButton() {
        menuBox.setVisible(false);
        cancelButton.setVisible(true);
        headingLabel.setText("Add result");
        lowerLabel.setText("Choose a type of results input");
        lowerLabel.setVisible(true);
        addResultsTypeVBox.setVisible(true);
        selectResultsTypeChoiceBox.setItems(FXCollections.observableArrayList(
                "POS|NAME|COUNTRY|NOTE", "dwa", "trzy"));
        selectResultsTypeChoiceBox.getSelectionModel().selectFirst();
    }


    @FXML
    public void cancelButton() {
        menuBox.setVisible(true);
        cancelButton.setVisible(false);
        headingLabel.setText("Menu");
        lowerLabel.setVisible(false);
        addResultsTypeVBox.setVisible(false);
    }

//    @FXML
//    public void cancelButtonFun(KeyEvent event) {
//        if (event.getCode() == KeyCode.N) {
//            System.out.println("S");
//            cancelButton.setDisable(true);
//            try {
//                Thread.sleep(10000);
//                System.out.println("thread");
//                cancelButton.setText("Cancel");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}





