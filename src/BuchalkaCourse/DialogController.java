package BuchalkaCourse;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescription;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {
        String shortDescriptionString = shortDescription.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescriptionString, details, deadlineValue);
        TodoData_Singleton.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
