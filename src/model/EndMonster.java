package model;

import controller.Draw;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EndMonster implements IMonster {
    private int health;
    private boolean dead;
    private String weapon;
    private int x;
    private int y;
    private int radius;
    private int damage;
    private Room currRoom;
    private Draw draw;
    private Maze maze;
    private Text monHealth;

    public EndMonster() {
        this.health = 150;
        this.weapon = "fire";
        this.radius = 3;
        this.damage = 20;
        this.x = 9;
        this.y = 7;
        this.currRoom = null;
        this.dead = false;
        this.monHealth = new Text();
    }

    @Override
    public Pane drawMonster(Pane root) {
        ImageView iv = new ImageView();
        if (!dead) {
            iv.setImage(new Image("file:resources/EndMonster.png"));
        } else {
            iv.setImage(new Image("file:resources/EndMonsterDead.png"));
        }
        iv.setX(x * 32 + 50);
        iv.setY(y * 32 + 50);

        Text monHealth = new Text();
        monHealth.textProperty().bind(new SimpleStringProperty(("health: ")).concat(
                new SimpleIntegerProperty(health)));
        monHealth.setX((x + 1) * 32);
        monHealth.setY((y + 1) * 32);
        monHealth.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        monHealth.setFill(Color.BLACK);

        root.getChildren().addAll(iv, monHealth);
        return root;
    }

    @Override
    public boolean isDead() {
        return this.dead;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        if (newHealth <= 0) {
            health = 0;
            dead = true;
            monHealth.textProperty().bind(new SimpleStringProperty(""));
        } else {
            health = newHealth;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    public String getWeapon() {
        return weapon;
    }

    public Room getCurrRoom() {
        return currRoom;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze newMaze) {
        maze = newMaze;
    }
}
