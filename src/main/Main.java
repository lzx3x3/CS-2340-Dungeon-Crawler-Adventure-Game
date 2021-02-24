package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Dungeon Crawler Game");
        WelcomeScreen screen = new WelcomeScreen();
        screen.start(stage);
        stage.show();
    }
}
