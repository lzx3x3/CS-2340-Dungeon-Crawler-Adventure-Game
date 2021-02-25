package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.GameModel;
import view.InitialConfigScreen;

public class Controller extends Application {
    private GameModel gameModel;
    private Stage mainWindow;
    private final int width = 500;
    private final int height = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameModel = new GameModel();
        mainWindow = primaryStage;
        mainWindow.setTitle("Start a New Game");
        initInitialConfigScreen();
    }

    /**
     * Initializes InitialConfigScreen
     */
    private void initInitialConfigScreen() {
        InitialConfigScreen screen = new InitialConfigScreen(width, height);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> goToInitialGameScreen());

        Scene scene = screen.getScene();
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
