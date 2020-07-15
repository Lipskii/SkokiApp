package BuchalkaCourse;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize() {

        //SPOSÓB BEZ UŻYWANIA SINGLETON DO WCZYTYWANIA Z PLIKU
//        TodoItem item1 = new TodoItem("Mail Birthday card", "Buy a 36th birthday card for John", LocalDate.of(2016, Month.APRIL, 25));
//        TodoItem item2 = new TodoItem("Doctor's appointment", "See doctor smith at some stree", LocalDate.of(2016, Month.MAY, 25));
//        TodoItem item3 = new TodoItem("Finish design proposal for a client", "I promised Mike I'd email him with details"
//                , LocalDate.now());
//        TodoItem item4 = new TodoItem("Pickup Doug at the train station", "Doug's arriving on March 23", LocalDate.of(2019, Month.APRIL, 25));
//        TodoItem item5 = new TodoItem("Pick up dry cleaning", "Clothes should be ready by Wednesday", LocalDate.of(2017, Month.JULY, 6));
//
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        TodoData_Singleton.getInstance().setTodoItems(todoItems);


        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            //automatycznie wybiera pierwszy, a później działa jak handleClickListView()
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if (t1 != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());

                    //formatowanie daty
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
                    deadlineLabel.setText(dateTimeFormatter.format(item.getDeadline()));

                }
            }
        });

        //to jest ze sposobu bez wczytywania z singleton z pliku
        // todoListView.getItems().setAll(todoItems);
        todoListView.getItems().setAll(TodoData_Singleton.getInstance().getTodoItems());

        //ensure that we can select only one item at the time
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //choosing first by default
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}
