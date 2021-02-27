package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.GameModel;
import model.Player;
import view.InitialConfigScreen;
import view.InitialGame;
import view.WelcomeScreen;

public class Controller extends Application {
    private GameModel gameModel;
    private Stage mainWindow;
    private Player player;
    private final int width = 800;
    private final int height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameModel = new GameModel();
        player = new Player();
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
        TextField nameInput = screen.getNameInput();
        ComboBox<String> diffSelect = screen.getDiffSelect();
        startButton.setOnAction(e -> {
            try {
                if (nameInput.getText() == null || nameInput.getText().isEmpty()) {
                    Alert nameAlert = screen.getNameAlert();
                    nameAlert.setTitle("Error");
                    nameAlert.setHeaderText("Invalid Name");
                    nameAlert.setContentText("Your name must include at least one character");
                    nameAlert.show();
                } else if (diffSelect.getValue() == null) {
                    Alert diffAlert = screen.getDiffAlert();
                    diffAlert.setTitle("Error");
                    diffAlert.setHeaderText("Invalid Difficulty");
                    diffAlert.setContentText("Please choose a difficulty");
                    diffAlert.show();
                } else {
//                    initInitialGameScreen(nameInput, screen.getDiffSelect());
                    player.setName(nameInput.getText());
                    player.setDiff(screen.getDiffSelect().getValue());
                    initInitialGameScreen(player);
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
//    private void initInitialGameScreen(TextField playerName, ComboBox<String> difficulty) throws Exception {
    public void initInitialGameScreen(Player player) throws Exception {
        // We need to have a standard resolution!!!!
        InitialGame screen = new InitialGame(800, 600);
        Button exit3 = screen.getExit3();
        exit3.setOnAction(e -> {
            initInitialConfigScreen();
        });
//        player = new Player(playerName.getText(), difficulty.getValue());
        player.setMoney(player.getDiff());
        Scene scene = screen.start(mainWindow, player);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public void setMainWindow(Stage stage) {
        this.mainWindow = stage;
    }

    /**
     *
     * @param args main method argument
     */
    public static void main(String[] args) {
        launch(args);
    }
}
