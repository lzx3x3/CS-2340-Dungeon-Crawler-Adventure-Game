package controller;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.*;

import java.util.List;

public class Draw {

    public Pane draw(Player player, Controller controller) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player);
        if (player.getHealth() > 0) {
            root = player.drawPlayer(root);
            Text currentRoom = new Text("Current Room:"
                    + Integer.toString(player.getMaze().getX())
                    + Integer.toString(player.getMaze().getY()));
            currentRoom.setX(650);
            currentRoom.setY(400);
            root.getChildren().add(currentRoom);
        } else {
            root = player.drawDeadPlayer(root);
        }
        return root;
    }


    //DRAW both the player and the monster and the chest
    public Pane drawSprites(Player player, List<IMonster> monsters, Controller controller) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        if (player.getHealth() > 0) {
            root = room.drawRoom(root, player);
            //draws either a start, wooden, challenge, or end room

            root = player.drawPlayer(root);
            Text currentRoom = new Text("Current Room:"
                    + Integer.toString(player.getMaze().getX())
                    + Integer.toString(player.getMaze().getY()));
            currentRoom.setX(650);
            currentRoom.setY(400);
            root.getChildren().add(currentRoom);
        } else {
            root = player.drawDeadPlayer(root);
        }

        // open chest when player enters deadends
        if (player.getCurrRoom() instanceof Deadend2) {
            Deadend2 deadend2 = (Deadend2) player.getCurrRoom();
            if (deadend2.getChest().getChestState() != 2
                    && (player.getX() == 7 && player.getY() == 7)) {
                deadend2.getChest().setChestState(1);
            }
        }
        if (player.getCurrRoom() instanceof Deadend3) {
            Deadend3 deadend3 = (Deadend3) player.getCurrRoom();
            if (deadend3.getChest().getChestState() != 2
                    && (player.getX() == 7 && player.getY() == 7)) {
                deadend3.getChest().setChestState(1);
            }
        }

        return root;

    }

}
