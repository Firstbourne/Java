package ru.meowmure.javacreditest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import ru.meowmure.javacreditest.Clockshop.Clock;
import ru.meowmure.javacreditest.Controllers.GUIController;
import ru.meowmure.javacreditest.Controllers.ItemController;

import java.io.IOException;

public class ClockShopApplication extends Application {
    public GUIController GUIcontroller;
    public ItemController itemController;

    @Override
    public void start(Stage stage) throws IOException {
        showMainWindow();
    }

    public void showMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(ClockShopApplication.class.getResource("ShopGUI.fxml"));
            Scene mainScene = new Scene(loader.load(), 1280, 720);
            Stage mainStage = new Stage();
            mainStage.setTitle("Shop");
            mainStage.setScene(mainScene);
            GUIController controller = loader.getController();
            GUIcontroller = controller;
            controller.setApp(this);
            mainStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void showAddWindow(Clock clock, ListView<Clock> listView) {
        FXMLLoader loader = new FXMLLoader(ClockShopApplication.class.getResource("NewItem.fxml"));
        try {
            Scene newScene = new Scene(loader.load(),240,400);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("Add new");
            ItemController controller = loader.getController();
            itemController = controller;
            controller.setApp(this);
            controller.setListView(listView);
            controller.setObject(clock);
            newStage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showTimeWindow() {
        FXMLLoader loader = new FXMLLoader(ClockShopApplication.class.getResource("SetTimeForm.fxml"));
        try {
            Scene newScene = new Scene(loader.load(),300, 250);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("Set Time");
            GUIController controller = loader.getController();
            this.GUIcontroller = controller;
            controller.setApp(this);
            newStage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}