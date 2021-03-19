package model;

import controller.Draw;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Monster2 implements IMonster {

    private int health;
    private boolean dead;
    private String weapon;
    private int x;
    private int y;
    private int level;
    private Room currRoom;
    private Draw draw;


    public Monster2 () {
        this.health = 100;
        this.level = 1;
        this.weapon = "magic";
        this.x = 14;
        this.y = 14;
        this.currRoom = null;
        this.dead = false;
    }
    @Override
    public void AttackPlayer() {

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

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public String getWeapon() { return weapon; }

    public Room getCurrRoom() { return currRoom; }
}
