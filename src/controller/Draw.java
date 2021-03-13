package controller;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Player;
import model.Room;

 public class Draw {

    static public Pane draw(Player player) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player);
        root = player.drawPlayer(root);
        Text currentRoom = new Text("Current level:" + Integer.toString(player.getMaze().getX()) + Integer.toString(player.getMaze().getY()));
        currentRoom.setX(650);
        currentRoom.setY(400);
        root.getChildren().add(currentRoom);

        return root;
    }
}
