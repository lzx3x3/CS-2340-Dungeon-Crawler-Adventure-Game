package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ExitRoom;
import model.Maze;
import model.Player;
import model.StartRoom;
import view.InitialGame;

public class MazeTest {
    Controller controller;

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
        Scene scene = screen.start(player, maze, stage);
        maze.getCurrentRoom().getRightDoor().setOnAction(e -> {
            maze.updateRoom("RIGHT");
            if (maze.getCurrentRoom() instanceof ExitRoom) {
                controller.initEndScreen();
            } else {
                initNextRoom(stage, maze, player);
            }

        });
        maze.getCurrentRoom().getBottomDoor().setOnAction(e -> {
            maze.updateRoom("DOWN");
            if (maze.getCurrentRoom() instanceof ExitRoom) {
                controller.initEndScreen();
            } else {
                initNextRoom(stage, maze, player);
            }

        });
        if (!(maze.getCurrentRoom() instanceof StartRoom)) {
            maze.getCurrentRoom().getLeftDoor().setOnAction(e -> {
                maze.updateRoom("LEFT");
                if (maze.getCurrentRoom() instanceof ExitRoom) {
                    controller.initEndScreen();
                } else {
                    initNextRoom(stage, maze, player);
                }

            });
            maze.getCurrentRoom().getTopDoor().setOnAction(e -> {
                maze.updateRoom("UP");
                if (maze.getCurrentRoom() instanceof ExitRoom) {
                    controller.initEndScreen();
                } else {
                    initNextRoom(stage, maze, player);
                }

            });
        }
       stage.setScene(scene);
    }
}
