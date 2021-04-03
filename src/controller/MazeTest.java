package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.ExitRoom;
import model.Maze;
import model.Player;
import model.StartRoom;
import view.InitialGame;

public class MazeTest {
    private Controller controller;

    public MazeTest(Controller controller) {
        this.controller = controller;
    }

    public void initNextRoom(Stage stage, Maze maze, Player player) {
        InitialGame screen = new InitialGame(800, 600);
        Button exit3 = screen.getExit3();
        exit3.setOnAction(e -> {
            // initInitialConfigScreen();
        });
        //player = new Player(playerName.getText(), difficulty.getValue());
        player.setMoney(player.getDiff());
        Scene scene = screen.start(player, maze, stage, controller);
        //        Scene scene = screen.start(player, maze);
        stage.setScene(scene);
    }

    public Controller getController() {
        return controller;

    }
}
