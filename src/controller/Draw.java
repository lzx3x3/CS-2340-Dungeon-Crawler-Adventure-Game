package controller;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import model.Player;
import model.Room;

public class Draw {

    public Pane draw(Player player) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player);
        root = player.drawPlayer(root);

        return root;
    }
}
