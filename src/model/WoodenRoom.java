package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import view.Door;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WoodenRoom extends Room {
    private ArrayList<Door> doors;
    private ArrayList<IMonster> monsters;
    private ArrayList<IMonster> allMonsters;
    private Random rand;
    private List<IItems> itemArray;

    public WoodenRoom(int index, int height, int width) {
        super(index, height, width);
        doors = new ArrayList<Door>();
        //createTileArray();
        //This will probably be replaced with a addDoor() method
        //<<<<<<< HEAD
        //        doors.add(new Door(7, 0, null));
        //        doors.add(new Door(0, 7, null));
        //        doors.add(new Door(7, 14, null));
        //        doors.add(new Door(14, 7, null));
        //=======
        allMonsters = new ArrayList<>();
        itemArray = new ArrayList<IItems>();
        allMonsters.add(new Monster1(generateRandPos(), generateRandPos()));
        allMonsters.add(new Monster2(generateRandPos(), generateRandPos()));
        rand = new Random();
        int randint = rand.nextInt(2);
        monsters = new ArrayList<>();
        monsters.add(allMonsters.get(randint));
        //monsters.add(new Monster1());

        int randItem = rand.nextInt(7);
        if (randItem == 0 || randItem == 5) {
            itemArray.add(new AttackPotion());
        } else if (randItem == 1 || randItem == 6) {
            itemArray.add(new HealthPotion());
        } else if (randItem == 2) {
            itemArray.add(new MagicStone());
        } else if (randItem == 3) {
            itemArray.add(new Sword());
        } else if (randItem == 4) {
            itemArray.add(new Bow());
        }
    }

    @Override
    public void createTileArray() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                super.tileArray[j][i] = new Tile(j, i, "Wooden Floor");
            }
        }
        tileArray[7][0] = new Tile(7, 0, "Door"); // top door
        tileArray[0][7] = new Tile(0, 7, "Door"); // left door
        tileArray[14][7] = new Tile(8, 0, "Door"); // right door
        tileArray[7][14] = new Tile(8, 0, "Door"); // bottom door

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

        Text health = new Text();
        health.setId("healthValue");
        health.textProperty().bind(new SimpleStringProperty(("Current health: ")).concat(
                new SimpleIntegerProperty(player.getHealth()).asString()));
        health.setX(600);
        health.setY(80);
        health.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        health.setFill(Color.BLACK);

        root.getChildren().addAll(money, diff, level, health, player.getInventory());

        return root;
    }

    @Override
    public List<IMonster> getMonsterArray() {
        return monsters;
    }


    @Override
    public List getItemArray() {
        return itemArray;
    }
    @Override
    public IItems removeItem() {
        return itemArray.remove(0);
    }

    private int generateRandPos() {
        Random rand = new Random();
        int randPos = rand.nextInt(13) + 1;
        return randPos;
    }
}
