package model;

import controller.Draw;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monster1 implements IMonster {
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


    public Monster1 () {
        this.health = 100;
        this.damage = 30;
        this.weapon = "stick";
        this.radius = 2;
        this.x = 9;
        this.y = 7;
        this.currRoom = null;
        this.dead = false;
    }

    @Override
    public Pane drawMonster(Pane root) {
        ImageView iv = new ImageView();
        if (!dead) {
            iv.setImage(new Image("file:resources/MinotaurMonsterStanding.png"));
        } else {
            iv.setImage(new Image("file:resources/MinotaurMonsterDead.png"));
        }
        iv.setX(x * 32 + 50);
        iv.setY(y * 32 + 50);
        root.getChildren().add(iv);
        return root;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        if (newHealth == 0) {
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
