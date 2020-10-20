package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;

import java.util.stream.Stream;


public class ComboBoxAutoComplete<T> {

    private final ComboBox<T> comboBox;
    private String filter = "";
    private final ObservableList<T> originalItems;

    public ComboBoxAutoComplete(ComboBox<T> cmb) {
        this.comboBox = cmb;
        originalItems = comboBox.getItems();
        comboBox.setTooltip(new Tooltip());
        comboBox.setOnKeyPressed(this::handleOnKeyPressed);
        comboBox.setOnHidden(this::handleOnHiding);
    }

    public void handleOnKeyPressed(KeyEvent e) {
        ObservableList<T> filteredList = FXCollections.observableArrayList();
        KeyCode code = e.getCode();

        if (code.isLetterKey()) {
            filter += e.getText();
        }

        if (code == KeyCode.BACK_SPACE && filter.length() > 0) {
            filter = filter.substring(0, filter.length() - 1);
            comboBox.getItems().setAll(originalItems);
        }

        if (code == KeyCode.ESCAPE) {
            filter = "";
        }

        if (filter.length() == 0) {
            filteredList = originalItems;
            comboBox.getTooltip().hide();

        } else {

            Stream<T> items = comboBox.getItems().stream();
            String userText = filter.toLowerCase();

            items.filter(el -> el.toString().toLowerCase().contains(userText)).forEach(filteredList::add);

            comboBox.getTooltip().setText(userText);

            Window stage = comboBox.getScene().getWindow();
            double posX = stage.getX() + comboBox.getBoundsInParent().getMinX();
            double posY = stage.getY() + comboBox.getBoundsInParent().getMinY();
            comboBox.getTooltip().show(stage, posX, posY);
            comboBox.show();
        }

        comboBox.setItems(filteredList);
        comboBox.getSelectionModel().select(0);
    }

    public void handleOnHiding(Event e) {
        filter = "";
        comboBox.getTooltip().hide();
        T s = comboBox.getSelectionModel().getSelectedItem();
        comboBox.setItems(originalItems);
        comboBox.getSelectionModel().select(s);
    }
}
