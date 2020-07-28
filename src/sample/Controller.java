package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;

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
    //Listy
    @FXML
    private ListView<Region> listView;
    @FXML
    private VBox menuBox;


    //Labels
    @FXML
    private Label headingLabel;


    public void initialize() {
        dataSource = new DataSource();
//        cancelButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(final KeyEvent event) {
//                cancelButtonFun(event);
//            }
//        });


        //    ObservableList<Region> regions = dataSource.regionList();
        listView.getItems().addAll(dataSource.regionList());

    }

    @FXML
    public void handleAddResultButton() {
        menuBox.setVisible(false);
        cancelButton.setVisible(true);
        headingLabel.setText("Add result");
    }


    @FXML
    public void cancelButton() {
        menuBox.setVisible(true);
        cancelButton.setVisible(false);
        headingLabel.setText("Menu");
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





