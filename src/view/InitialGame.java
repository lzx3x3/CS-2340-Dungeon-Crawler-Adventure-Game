package view;

import controller.Controller;
import controller.Draw;
import controller.Motion;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Maze;
import model.Player;
import model.Room;

public class InitialGame {

    private int width;
    private int height;
    private Button exit3;
    private Room currentRoom;

    private InitialGame() { }

    public InitialGame(int w, int h) {
        this.width = w;
        this.height = h;
        this.exit3 = new Button("BACK");

    }

    public Scene start(Player player, Maze maze, Stage stage, Controller controller) {
        //Pane root1 = new Pane();
        Pane root2 = new Pane();
        Room room0 =  maze.getCurrentRoom();
        player.setMaze(maze);
        player.setCurrRoom(room0);
        player.addToVisitedRooms(room0);
        Draw draw = new Draw();
        Pane roomPane = draw.draw(player, controller);



        // create two scenes
        //Scene scene1 = new Scene(root1, width, height);
        Text currentRoom = new Text("Current level:"
                + Integer.toString(maze.getX()) + Integer.toString(maze.getY()));
        currentRoom.setX(650);
        currentRoom.setY(400);
        roomPane.getChildren().add(currentRoom);
        Scene scene2 = new Scene(roomPane, width, height);

        new Motion(player, scene2, stage, controller, draw);

        roomPane.getChildren().add(exit3);

        return scene2;
    }

    public Button getExit3() {
        return exit3;
    }
}
