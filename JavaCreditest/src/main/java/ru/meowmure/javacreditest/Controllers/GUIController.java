package ru.meowmure.javacreditest.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.meowmure.javacreditest.ClockShopApplication;
import ru.meowmure.javacreditest.Clockshop.Clock;

import java.security.PrivateKey;
import java.util.Iterator;


public class GUIController {

    @FXML
    private ListView<Clock> listView = new ListView<>();
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button setTime;
    @FXML
    private Label labelName;
    @FXML
    private Label labelMark;
    @FXML
    private Label labelType;
    @FXML
    private Label labelPrice;
    @FXML
    private MenuItem menuItemAction1;
    @FXML
    private MenuItem menuItemAction2;
    @FXML
    private MenuItem menuItemAction3;
    @FXML
    private MenuItem menuItemOpen;
    @FXML
    private MenuItem menuItemSave;
    @FXML
    private MenuItem menuItemClose;
    @FXML
    private Canvas canvas;

    private ClockShopApplication app;

    public void setApp(ClockShopApplication app) {
        this.app = app;
    }

    public void setListView(ListView<Clock> listView) {
        this.listView = listView;
        listView.refresh();
    }

    public void add(ActionEvent actionEvent) {
        Clock clock = new Clock((Stage) listView.getScene().getWindow());
        app.showAddWindow(clock, listView);
    }

    public void onItemSelected(MouseEvent mouseEvent) {
        labelName.setText(listView.getSelectionModel().getSelectedItem().name.getValue());
        labelMark.setText(listView.getSelectionModel().getSelectedItem().mark.getValue());
        labelType.setText(listView.getSelectionModel().getSelectedItem().isTyped ? "With seconds" : "Without seconds");
        labelPrice.setText(String.valueOf((listView.getSelectionModel().getSelectedItem().cost.getValue())));
    }

    public void getExpensive(ActionEvent actionEvent) {
        int max = 0;
        Iterator<Clock> iterator = listView.getItems().iterator();
        while (iterator.hasNext()) {
            Clock temp = iterator.next();
            if (temp.cost.getValue() > max) {
                max = temp.cost.getValue();
            }
        }
        new Alert(Alert.AlertType.INFORMATION, "The most expensive clock price is: " + max).showAndWait();
    }

    // TODO: 16.11.2022 output description of clock from listview, add new labels for description properties (DONE)
    // TODO:
}
