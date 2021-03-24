package controller;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.EndMonster;
import model.ExitRoom;
import model.IMonster;
import model.Monster1;
import model.Monster2;
import model.Player;
import model.Room;
import model.StartRoom;

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
        }
        else {
            root = player.drawDeadPlayer(root);
//            ImageView image = new ImageView();
//            image.setImage(new Image("file:resources/player.png"));
//            Button restart = new Button("Try Again!", image);
//            restart.setOnAction(e -> {
//                controller.initInitialConfigScreen();
//            });
//            restart.setLayoutX(250);
//            restart.setLayoutY(250);
//
//            Alert deadAlert = new Alert(Alert.AlertType.WARNING);
//            deadAlert.setContentText("You died! Please click button 'Try Again'");
//            deadAlert.show();
//            root.getChildren().add(restart);
        }
        return root;
    }

    public Pane drawMonster1(Player player, Controller controller, Monster1 monster1) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player);

        monster1.drawMonster(root);

        if (player.getHealth() > 0) {
            root = player.drawPlayer(root);
            Text currentRoom = new Text("Current Room:"
                    + Integer.toString(player.getMaze().getX())
                    + Integer.toString(player.getMaze().getY()));
            currentRoom.setX(650);
            currentRoom.setY(400);
            root.getChildren().add(currentRoom);
        }
        else {
            root = player.drawDeadPlayer(root);
        }
        return root;
    }

    public Pane drawMonster2(Player player, Controller controller, Monster2 monster2) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player);

        monster2.drawMonster(root);

        if (player.getHealth() > 0) {
            root = player.drawPlayer(root);
            Text currentRoom = new Text("Current Room:"
                    + Integer.toString(player.getMaze().getX())
                    + Integer.toString(player.getMaze().getY()));
            currentRoom.setX(650);
            currentRoom.setY(400);
            root.getChildren().add(currentRoom);
        }
        else {
            root = player.drawDeadPlayer(root);
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
            Text currentRoom = new Text("Current Room:" +
                    Integer.toString(player.getMaze().getX()) +
                    Integer.toString(player.getMaze().getY()));
            currentRoom.setX(650);
            currentRoom.setY(400);
            root.getChildren().add(currentRoom);
        } else {
            root = player.drawDeadPlayer(root);
        }
        return root;
    }

    //DRAW both the player and the monster
    public Pane drawSprites(Player player, IMonster monster, Controller controller) {
        Pane root = new Pane();
        Room room = player.getCurrRoom();
        root = room.drawRoom(root, player); //draws either a start, wooden, or end room
        if (player.getHealth() > 0) {
            if (player.getCurrRoom() instanceof ExitRoom) {
                monster = new EndMonster();
            }
            if (!(player.getCurrRoom() instanceof StartRoom)) {
                root = monster.drawMonster(root);
            }
            root = player.drawPlayer(root);
            Text currentRoom = new Text("Current Room:" +
                    Integer.toString(player.getMaze().getX()) +
                    Integer.toString(player.getMaze().getY()));
            currentRoom.setX(650);
            currentRoom.setY(400);
            root.getChildren().add(currentRoom);
        } else {
            root = player.drawDeadPlayer(root);
        }
        return root;

    }

}
