package ru.meowmure.javacreditest.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import ru.meowmure.javacreditest.ClockShopApplication;
import ru.meowmure.javacreditest.Clockshop.Clock;


public class GUIController {

    @FXML
    private ListView<Clock> listView = new ListView<>();
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonSet;
    @FXML
    private Button buttonShow;

    private ClockShopApplication app;

    public void setApp(ClockShopApplication app) {
        this.app = app;
    }

    public void setListView(ListView<Clock> listView) {
        this.listView = listView;
        listView.refresh();
    }

    public void add(ActionEvent actionEvent) {
        Clock clock = new Clock();
        app.showAddWindow(clock, listView);
    }
}
