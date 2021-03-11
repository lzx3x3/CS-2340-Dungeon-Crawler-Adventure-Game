package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import junit.framework.Test;
import model.Player;
import view.Door;

import java.util.ArrayList;

public class WoodenRoom extends Room{
    private ArrayList<Door> doors;
    Button rightDoor;
    Button leftDoor;
    Button topDoor;
    Button bottomDoor;


    public WoodenRoom(int index, int height, int width) {
        super(index, height, width);
        doors = new ArrayList<Door>();
        //createTileArray();
        //This will probably be replaced with a addDoor() method
        leftDoor = new Button("Left Door");
        bottomDoor = new Button("Bottom Door");
        rightDoor = new Button("Right Door");
        topDoor = new Button("Top Door");


    }

    @Override
    public void createTileArray() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                super.tileArray[j][i] = new Tile(j, i, "Wooden Floor",
                        new Image("file:resources/wooden_floor.png"));
            }
        }
        tileArray[7][0] = new Tile(7, 0, "Door", new Image("file:resources/doors.png")); // top door
        tileArray[0][7] = new Tile(0, 7, "Door", new Image("file:resources/doors.png")); // left door
        tileArray[14][7] = new Tile(8, 0, "Door", new Image("file:resources/doors.png")); // right door
        tileArray[7][14] = new Tile(8, 0, "Door", new Image("file:resources/doors.png")); // bottom door

    }

    @Override
    public Tile[][] getTileArray() {
        return tileArray;
    }

    public Pane drawRoom(Pane root, Player player) {
        createTileArray();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                ImageView iV = new ImageView();
                iV.setImage(tileArray[j][i].getImage());
                iV.setX(i * 32 + 50);
                iV.setY(j * 32 + 50);
                root.getChildren().add(iV);
            }
        }

//        for (Door one : doors) {
//            ImageView iV = new ImageView();
//            iV.setImage(door);
//            iV.setX(one.getX() * 32 + 50);
//            iV.setY(one.getY() * 32 + 50);
//            root.getChildren().add(iV);
//        }

        Text money = new Text();
        money.textProperty().bind(new SimpleStringProperty(("Current Money: ")).concat(
                new SimpleIntegerProperty(player.getMoney()).asString()));
        money.setX(600);
        money.setY(20);
        money.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        money.setFill(Color.GREEN);

        Text diff = new Text();
        diff.textProperty().bind(new SimpleStringProperty(("Current Difficulty: ")).concat(
                new SimpleStringProperty(player.getDiff())));
        diff.setX(600);
        diff.setY(40);
        diff.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        diff.setFill(Color.RED);

        Text level = new Text();
        level.textProperty().bind(new SimpleStringProperty(("Current Level: ")).concat(
                new SimpleIntegerProperty(player.getLevel()).asString()));
        level.setX(600);
        level.setY(60);
        level.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        level.setFill(Color.BLUE);
        rightDoor.setLayoutX(700);
        rightDoor.setLayoutY(150);
        topDoor.setLayoutY(100);
        topDoor.setLayoutX(650);
        leftDoor.setLayoutX(600);
        leftDoor.setLayoutY(150);
        bottomDoor.setLayoutY(200);
        bottomDoor.setLayoutX(650);
        root.getChildren().addAll(money, diff, level, topDoor, rightDoor, bottomDoor, leftDoor);

        return root;
    }


    @Override
    public Button getRightDoor() {
        return rightDoor;
    }

    @Override
    public Button getLeftDoor() {
        return leftDoor;
    }

    @Override
    public Button getTopDoor() {
        return topDoor;
    }

    @Override
    public Button getBottomDoor() {
        return bottomDoor;
    }
}
