package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartRoom extends Room{
    Button leftDoor;
    Button bottomDoor;
    Button topDoor;
    Button rightDoor;
    public StartRoom(int index, int height, int width) {
        super(index, height, width);
        rightDoor = new Button("Right Door");
        bottomDoor = new Button("Bottom Door");
    }
    @Override
    public void createTileArray() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                super.tileArray[j][i] = new Tile(j, i, "Wooden Floor");
            }
        }
        //tileArray[7][0] = new Tile(7, 0, "Door", new Image("file:resources/doors.png")); // top door
        //tileArray[0][7] = new Tile(0, 7, "Door", new Image("file:resources/doors.png")); // left door
        tileArray[14][7] = new Tile(8, 0, "Door"); // right door
        tileArray[7][14] = new Tile(8, 0, "Door"); // bottom door
    }

    @Override
    public Tile[][] getTileArray() {
        return tileArray;
    }

    @Override
    public Pane drawRoom(Pane root, Player player) {
        createTileArray();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                ImageView iV = new ImageView();
                if (tileArray[j][i].getType() == "Wooden Floor") {
                    iV.setImage(tileArray[j][i].getImage(0));
                } else if (tileArray[j][i].getType() == "Door") {
                    iV.setImage(tileArray[j][i].getImage(1));
                }
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
        bottomDoor.setLayoutY(200);
        bottomDoor.setLayoutX(650);
        root.getChildren().addAll(money, diff, level, rightDoor, bottomDoor);

        return root;
    }
    @Override
    public Button getLeftDoor() {
        return null;
    }
    @Override
    public Button getBottomDoor() {
        return bottomDoor;
    }

    @Override
    public Button getRightDoor() {
        return rightDoor;
    }

    @Override
    public Button getTopDoor() {
        return null;
    }
}
