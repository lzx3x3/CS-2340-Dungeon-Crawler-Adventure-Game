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
            //ImageView image = new ImageView();
            //image.setImage(new Image("file:resources/player.png"));
            //Button restart = new Button("Try Again!", image);
            //restart.setOnAction(e -> {
            //    controller.initInitialConfigScreen();
            //});
            //restart.setLayoutX(250);
            //restart.setLayoutY(250);

            //Alert deadAlert = new Alert(Alert.AlertType.WARNING);
            //deadAlert.setContentText("You died! Please click button 'Try Again'");
            //deadAlert.show();
            //root.getChildren().add(restart);
        }
        return root;
    }


    public Pane drawEndMonster(Player player, Controller controller, EndMonster endMonster) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player);

        endMonster.drawMonster(root);

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

        // draw chest
        if(player.getCurrRoom() instanceof Deadend2) {
            if( (player.getX() == 8 && player.getY() == 7) ||  (player.getX() == 7 && player.getY() == 6)
            || (player.getX() == 6 && player.getY() == 7) || (player.getX() == 7 && player.getY() == 8)) {
                Deadend2 deadend2 = (Deadend2)player.getCurrRoom();
                deadend2.getChest().setChestState(1);
            }
        }
        if(player.getCurrRoom() instanceof Deadend3) {
            if( (player.getX() == 8 && player.getY() == 7) ||  (player.getX() == 7 && player.getY() == 6)
                    || (player.getX() == 6 && player.getY() == 7) || (player.getX() == 7 && player.getY() == 8)) {
                Deadend3 deadend3 = (Deadend3)player.getCurrRoom();
                deadend3.getChest().setChestState(1);
            }
        }
        if(player.getCurrRoom() instanceof Deadend4) {
            if( (player.getX() == 8 && player.getY() == 7) ||  (player.getX() == 7 && player.getY() == 6)
                    || (player.getX() == 6 && player.getY() == 7) || (player.getX() == 7 && player.getY() == 8)) {
                Deadend4 deadend4 = (Deadend4)player.getCurrRoom();
                deadend4.getChest().setChestState(1);
            }
        }

        return root;

    }

}
