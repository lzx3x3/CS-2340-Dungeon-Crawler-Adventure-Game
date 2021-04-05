package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import model.*;

import java.util.ArrayList;
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


//    public Pane drawEndMonster(Player player, Controller controller, EndMonster endMonster) {
//        Pane root = new Pane();
//        Room room = player.getCurrRoom();
//        root = room.drawRoom(root, player);
//
//        endMonster.drawMonster(root);
//
//        if (player.getHealth() > 0) {
//            root = player.drawPlayer(root);
//            Text currentRoom = new Text("Current Room:"
//                    + Integer.toString(player.getMaze().getX())
//                    + Integer.toString(player.getMaze().getY()));
//            currentRoom.setX(650);
//            currentRoom.setY(400);
//            root.getChildren().add(currentRoom);
//        } else {
//            root = player.drawDeadPlayer(root);
//        }
//        return root;
//    }


    //DRAW both the player and the monster and the chest
    public Pane drawSprites(Player player, List<IMonster> monsters, Controller controller) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player); //draws either a start, wooden, or end room
        if (player.getHealth() > 0) {
            /*
                if (player.getCurrRoom() instanceof ExitRoom) {
                    EndMonster monster  = new EndMonster();
                }

                if (!(player.getCurrRoom() instanceof StartRoom)) {
                    if (monsters != null) {
                        for (IMonster monster : monsters) {
                            root = monster.drawMonster(root);
                        }
                    }
                }

             */

            if (monsters != null) {
                for (IMonster monster : monsters) {
                    if (player.checkIfVisited(room) && monster.isDead()) {
                        root = draw(player, controller);
                    } else  {
                        root = monster.drawMonster(root);
                    }
                }
            }
            List<IItems> items = player.getCurrRoom().getItemArray();
            if (items != null) {
                for (IItems item : items) {
                    if (player.checkMonstersDead()) {
                        root.getChildren().add(item.draw(9, 7));
                    }
                }
            }

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

        // open chest when player inside deadends
//        if(player.getCurrRoom() instanceof Deadend1) {
//            Deadend1 deadend1 = (Deadend1)player.getCurrRoom();
//            MagicStone stone = new MagicStone();
//            if((player.getX() == 8 && player.getY() == 7) || (player.getX() == 7 && player.getY() == 7) ) {
//                deadend1.getChest().setChestState(1);
//            }
//        }
        if(player.getCurrRoom() instanceof Deadend2) {
            Deadend2 deadend2 = (Deadend2)player.getCurrRoom();
            if( (player.getX() == 8 && player.getY() == 7) || (player.getX() == 7 && player.getY() == 7) ) {
                deadend2.getChest().setChestState(1);
            }
        }
        if(player.getCurrRoom() instanceof Deadend3) {
            Deadend3 deadend3 = (Deadend3)player.getCurrRoom();
            if( (player.getX() == 8 && player.getY() == 7) || (player.getX() == 7 && player.getY() == 7)) {
                deadend3.getChest().setChestState(1);
            }
        }

        return root;

    }

}
