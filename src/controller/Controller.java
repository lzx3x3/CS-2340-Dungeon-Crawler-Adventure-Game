package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.GameModel;
import view.InitialConfigScreen;
import view.WelcomeScreen;

public class Controller extends Application {
    private GameModel gameModel;
    private Stage mainWindow;
    private final int width = 500;
    private final int height = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameModel = new GameModel();
        mainWindow = primaryStage;
        initFirstScreen();
        mainWindow.setTitle("Dungeon Crawler Game");
        // initInitialConfigScreen();
    }

    private void initFirstScreen() {
        WelcomeScreen screen = new WelcomeScreen(width, height);
        Button start = screen.getStart();
        start.setOnAction(e -> {
            initInitialConfigScreen();
        });
        Button quit = screen.getQuit();
        quit.setOnAction(e -> {
            mainWindow.close();
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }
    /**
     * Initializes InitialConfigScreen
     */
    private void initInitialConfigScreen() {
        InitialConfigScreen screen = new InitialConfigScreen(width, height);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> goToInitialGameScreen());
        Scene scene = screen.getScene();
        mainWindow.setTitle("Start a new game");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     *
     */
    private void goToInitialGameScreen() {
    }

    /**
     *
     * @param args main method argument
     */
    public static void main(String[] args) {
        launch(args);
    }
}
