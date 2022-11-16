package ru.meowmure.javacreditest.Controllers;


import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ru.meowmure.javacreditest.ClockShopApplication;
import ru.meowmure.javacreditest.Clockshop.Clock;
import ru.meowmure.javacreditest.Exceptions.IncorrectNumberException;

import java.io.IOException;

public class ItemController {

    @FXML
    private Button buttonCreate = new Button();
    @FXML
    private TextField name   = new TextField();
    @FXML
    private TextField mark = new TextField();
    @FXML
    private TextField price = new TextField();
    @FXML
    private CheckBox type = new CheckBox();
    private ClockShopApplication app;
    private ListView<Clock> listView;
    private Clock clock;

    public void setApp(ClockShopApplication app) {
        this.app = app;
    }

    public void setListView(ListView<Clock> listView) {
        this.listView = listView;
    }

    public void create(ActionEvent actionEvent) {
        if ((mark == null || mark.getText().isEmpty()) && (name == null || name.getText().isEmpty()) && (price == null || price.getText().isEmpty()) && (type == null)) {
            new Alert(Alert.AlertType.ERROR, "The one of the fields is null or empty").showAndWait();
            return;
        }
        clock.setMark(mark.getText());

        try {clock.setCost(Integer.parseInt(price.getText()));} catch (IncorrectNumberException e) {throw new RuntimeException(e);}

        clock.setName(name.getText());

        listView.getItems().add(clock);
        returnList();
        ((Stage)(buttonCreate.getScene().getWindow())).close();
    }

    public void setObject(Clock clock) {
        this.clock = clock;
    }

    public void returnList() {
        app.GUIcontroller.setListView(listView);
    }
}
