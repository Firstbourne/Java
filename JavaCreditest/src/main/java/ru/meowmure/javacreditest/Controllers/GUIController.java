package ru.meowmure.javacreditest.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.meowmure.javacreditest.ClockShopApplication;
import ru.meowmure.javacreditest.Clockshop.Clock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class GUIController {

    @FXML
    private ListView<Clock> listView = new ListView<>();
    @FXML
    private Button add;
    @FXML
    private Button setTime;
    @FXML
    private Button buttonSet;
    @FXML
    private Label labelName;
    @FXML
    private Label labelBrand;
    @FXML
    private Label labelType;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labelHour;
    @FXML
    private Label labelMin;
    @FXML
    private Label labelSec;
    @FXML
    private TextField textFieldHour;
    @FXML
    private TextField textFieldMin;
    @FXML
    private TextField textFieldSec;
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
    private Group group;

    private HashMap<String, Integer> map;

    private ClockShopApplication app;

    public void setApp(ClockShopApplication app) {
        this.app = app;
    }

    public void setListView(ListView<Clock> listView) {
        this.listView = listView;
    }

    public void add(ActionEvent actionEvent) {
        Clock clock = new Clock(group);
        app.showAddWindow(clock, listView);
    }

    public void onItemSelected(MouseEvent mouseEvent) {
        if (listView.getItems().isEmpty()) return;
        labelName.setText(listView.getSelectionModel().getSelectedItem().name.getValue());
        labelBrand.setText(listView.getSelectionModel().getSelectedItem().mark.getValue());
        labelType.setText(listView.getSelectionModel().getSelectedItem().isTyped ? "With seconds" : "Without seconds");
        labelPrice.setText(String.valueOf((listView.getSelectionModel().getSelectedItem().cost.getValue())));
        listView.getSelectionModel().getSelectedItem().draw();
        labelHour.setVisible(true);
        labelMin.setVisible(true);
        labelSec.setVisible(true);
        textFieldHour.setVisible(true);
        textFieldMin.setVisible(true);
        textFieldSec.setVisible(true);
        buttonSet.setVisible(true);
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

    //Button Set on main window
    public void setChosenTime(ActionEvent actionEvent) {
        listView.getSelectionModel().getSelectedItem().setTime(
                textFieldHour.getText().isEmpty() ? 0 : Integer.parseInt(textFieldHour.getText()),
                textFieldMin.getText().isEmpty() ? 0 : Integer.parseInt(textFieldMin.getText()),
                textFieldSec.getText().isEmpty() ? 0 : Integer.parseInt(textFieldSec.getText())
        );
        listView.getSelectionModel().getSelectedItem().draw();
    }

    //Action 2 in actions menu
    public void setUpAllClocks(ActionEvent actionEvent) {
        app.showTimeWindow(listView);
    }


    //NOT DONE YET
    public void action3(ActionEvent actionEvent) {
        map = new HashMap<>();
        for (Clock clock : listView.getItems()) {
            if (!map.containsKey(clock.mark)) {
                map.put(String.valueOf(clock.mark), 1);
            } else {
                for(Map.Entry<String, Integer> pair : map.entrySet()) {
                    if (pair.getKey() == String.valueOf(clock.mark)) {
                        pair.setValue(pair.getValue() + 1);
                    }
                }
            }
        }
        System.out.println(map.values());
    }
}
