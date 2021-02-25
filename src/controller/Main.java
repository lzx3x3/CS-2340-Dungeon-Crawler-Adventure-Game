package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.WelcomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private int width = 800;
    private int height = 575;
    private Stage mainStage;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setTitle("Dungeon Crawler Game");
        initFirstScreen();
    }

    private void initFirstScreen() {
        WelcomeScreen screen = new WelcomeScreen(width, height);
        Button start = screen.getStart();
        start.setOnAction(e -> {
            mainStage.close();
        });
        Button quit = screen.getQuit();
        quit.setOnAction(e -> {
            mainStage.close();
        });
        Scene scene = screen.getScene();
        mainStage.setScene(scene);
        mainStage.show();
    }
}
