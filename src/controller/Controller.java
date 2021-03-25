package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.GameModel;
import model.Maze;
import model.Player;
import view.*;

public class Controller extends Application {
    private GameModel gameModel;
    private Stage mainWindow;
    private Player player;
    private final int width = 800;
    private final int height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameModel = new GameModel();
        mainWindow = primaryStage;
        initFirstScreen();
        // initInitialConfigScreen();
        //initEndScreen();
    }

    /**
     * Initializes welcome screen
     */
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
        mainWindow.setTitle("Dungeon Crawler Game");
        mainWindow.show();
    }
    /**
     * Initializes InitialConfigScreen
     */
    public void initInitialConfigScreen() {
        player = new Player();
        InitialConfigScreen screen = new InitialConfigScreen(width, height);
        Button startButton = screen.getStartButton();
        TextField nameInput = screen.getNameInput();
        ComboBox<String> diffSelect = screen.getDiffSelect();
        Label wpnSelect = screen.getWpnSelect();

        startButton.setOnAction(e -> {
            try {
                if (nameInput.getText() == null || nameInput.getText().trim().isEmpty()
                        || diffSelect.getValue() == null || wpnSelect.getText() == "None") {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid selection");
                    if (nameInput.getText() == null || nameInput.getText().trim().isEmpty()) {
                        alert.setContentText("- Your name must include at least one character\n");
                    }
                    if (diffSelect.getValue() == null) {
                        alert.setContentText(alert.getContentText()
                                + "- Please choose a difficulty\n");
                    }
                    if (wpnSelect.getText() == "None") {
                        alert.setContentText(alert.getContentText() + "- Please choose a weapon");
                    }
                    alert.show();
                } else {
                    //initInitialGameScreen(nameInput, screen.getDiffSelect());
                    player.setName(nameInput.getText());
                    player.setDiff(screen.getDiffSelect().getValue());
                    initInitialGameScreen(player);
                }
            } catch (Exception f) {
                f.printStackTrace();
            }
        });
        Scene scene = screen.getScene();
        mainWindow.setTitle("Initial Configutation Screen");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     *
     * @param player Player instance
     * @throws Exception Throws a NullPointerException when fields are null
     */
    public void initInitialGameScreen(Player player) throws Exception {
        InitialGame screen = new InitialGame(800, 600);
        Button exit3 = screen.getExit3();
        exit3.setOnAction(e -> {
            initInitialConfigScreen();
        });
        //        player = new Player(playerName.getText(), difficulty.getValue());
        player.setMoney(player.getDiff());
        Maze maze = new Maze();
        Scene scene = screen.start(player, maze, mainWindow, this);
        MazeTest test = new MazeTest(this);
        maze.getCurrentRoom().getRightDoor().setOnAction(e -> {
            maze.updateRoom("RIGHT");
            test.initNextRoom(mainWindow, maze, player);
        });
        maze.getCurrentRoom().getBottomDoor().setOnAction(e -> {
            maze.updateRoom("DOWN");
            test.initNextRoom(mainWindow, maze, player);
        });
        mainWindow.setTitle("Initial Game Screen");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     * Initializes end(win/lose) screen
     */
    public void initEndScreen() {
        WinScreen screen = new WinScreen(width, height);
        Button startOver = screen.getStartOver();
        startOver.setOnAction(e -> {
            initInitialConfigScreen();
        });
        Button exit = screen.getExit();
        exit.setOnAction(e -> {
            mainWindow.close();
        });
        Scene scene = screen.getScene();
        mainWindow.setTitle("Win Screen");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public void initLoseScreen() {
        LoseScreen screen = new LoseScreen(width, height);
        Button startOver = screen.getStartOver();
        startOver.setOnAction(e -> {
            initInitialConfigScreen();
        });
        Button exit = screen.getExit();
        exit.setOnAction(e -> {
            mainWindow.close();
        });
        Scene scene = screen.getScene();
        mainWindow.setTitle("Lose Screen");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     *
     * @param stage Sets the stage for the mainWindow to display
     */
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
