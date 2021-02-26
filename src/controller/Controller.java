package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.InitialGame;
import model.GameModel;
import view.InitialConfigScreen;
import view.WelcomeScreen;
import model.Player;

public class Controller extends Application {
    private GameModel gameModel;
    private Stage mainWindow;
    private Player player;
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
        TextField nameInput = screen. getNameInput();
        startButton.setOnAction(e -> {
            try {
                if (nameInput.getText() == null || nameInput.getText().isEmpty()) {
                    Alert nameAlert = screen.getNameAlert();
                    nameAlert.setTitle("Error");
                    nameAlert.setHeaderText("Invalid Name");
                    nameAlert.setContentText("Your name must include at least one character");
                    nameAlert.show();
                } else {
                    initInitialGameScreen(nameInput, screen.getDiffSelect());
                }
            } catch (Exception f) {
                f.printStackTrace();
            }
        });
        Scene scene = screen.getScene();
        mainWindow.setTitle("Start a new game");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     *
     */
    private void initInitialGameScreen(TextField playerName, ComboBox<String> difficulty) throws Exception {
        InitialGame screen = new InitialGame();
        player = new Player(playerName.getText(), difficulty.getValue());
        Scene scene = screen.InitialGameScreen(mainWindow, player);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     *
     * @param args main method argument
     */
    public static void main(String[] args) {
        launch(args);
    }
}
