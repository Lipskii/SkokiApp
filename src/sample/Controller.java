package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Controller {

    @FXML
    private Button addHillButton;
    @FXML
    private Button addResultButton;
    @FXML
    private Button addVenueButton;
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
    private Button selectResultsTypeButton;
    @FXML
    private Button skiJumpersButton;
    @FXML
    private ChoiceBox selectResultsTypeChoiceBox;
    @FXML
    private GridPane mainGridPane;
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
//        cancelButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(final KeyEvent event) {
//                cancelButtonFun(event);
//            }
//        });

        // listView.getItems().addAll(dataSource.regionList());

    }

    @FXML
    public void handleAddHillButton() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add Hill");
        dialog.setHeaderText("Select");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddHill.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        dialog.showAndWait();
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
    public void handleSelectResultsTypeButton() {
        if (selectResultsTypeChoiceBox.getValue() == "POS|NAME|COUNTRY|NOTE") {
            showPosNameCountryNoteDialogPane();
        } else {
        }
    }

    @FXML
    public void showPosNameCountryNoteDialogPane() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add results");
        dialog.setHeaderText("Select");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("PosNameCountryNoteDialogPane.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        dialog.showAndWait();

    }

    @FXML
    public void handleAddVenueButton() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add venue");
        dialog.setHeaderText("");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddVenue.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        dialog.showAndWait();
        cancelButton.setVisible(false);
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





