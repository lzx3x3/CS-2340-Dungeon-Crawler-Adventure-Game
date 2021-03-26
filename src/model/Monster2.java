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

public class Monster2 implements IMonster {

    private int health;
    private boolean dead;
    private String weapon;
    private int x;
    private int y;
    private int damage;
    private int radius;
    private Room currRoom;
    private Draw draw;
    private Maze maze;


    public Monster2 () {
        this.health = 100;
        this.damage = 20;
        this.weapon = "magic";
        this.radius = 3;
        this.x = 9;
        this.y = 7;
        this.currRoom = null;
        this.dead = false;
    }

    @Override
    public Pane drawMonster(Pane root) {
        ImageView iv = new ImageView();
        if (!dead) {
            iv.setImage(new Image("file:resources/Monster2Standing.png"));
        } else {
            iv.setImage(new Image("file:resources/Monster2Dead.png"));
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        if (newHealth <= 0) {
            dead = true;
        }
        health = newHealth;
    }

    public boolean getDead() { return dead; }

    public void setDead(boolean isDead) { dead = isDead; }

    public int getDamage() { return damage; }

    public void setDamage(int damage) { this.damage = damage; }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public int getRadius() { return radius; }

    public void setRadius(int newRadius) { radius = newRadius; }

    public String getWeapon() { return weapon; }

    public Room getCurrRoom() { return currRoom; }

    public Maze getMaze() { return maze; }

    public void setMaze(Maze newMaze) { maze = newMaze; }
}
