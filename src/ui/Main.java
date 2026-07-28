package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        new ServerWindow().show(new Stage());
        new ClientWindow().show(new Stage());
    }

    public static void main(String[] args) {
        launch();
    }
}
