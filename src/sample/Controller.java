package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;

public class Controller {

    @FXML
    private Menu fileButton;
    @FXML
    private Label label;
    @FXML
    Button button;


    @FXML
    private void setFileButton(ActionEvent event){
        label.setText("SIEMA!");
    }
    @FXML
    private void button(ActionEvent event){
        label.setText("Ssad!");
    }
}
