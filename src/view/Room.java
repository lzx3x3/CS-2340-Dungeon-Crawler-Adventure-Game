package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import model.Player;

import java.util.ArrayList;

public class Room {
    private int height = 0;
    private int width = 0;
    private int index = 0;
    private ArrayList<Door> doors;

    Room(int index, int height, int width) {
        this.index = index;
        this.height = height;
        this.width = width;
        doors = new ArrayList<Door>();
        //This will probably be replaced with a addDoor() method
        doors.add(new Door(7, 0, null));
        doors.add(new Door(0, 7, null));
        doors.add(new Door(7, 14, null));
        doors.add(new Door(14, 7, null));


    }
    public Pane drawRoom(Pane root, Player player) {
        Image woodenFloor = new Image("file:resources/wooden_floor.png");
        Image door = new Image("file:resources/doors.png");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                ImageView iV = new ImageView();
                iV.setImage(woodenFloor);
                iV.setX(i * 32 + 50);
                iV.setY(j * 32 + 50);
                root.getChildren().add(iV);
            }
        }

        for (Door one :doors) {
            ImageView iV = new ImageView();
            iV.setImage(door);
            iV.setX(one.getX() * 32 + 50);
            iV.setY(one.getY() * 32 + 50);
            root.getChildren().add(iV);
        }

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

        root.getChildren().addAll(money, diff, level);

        return root;
    }

}
