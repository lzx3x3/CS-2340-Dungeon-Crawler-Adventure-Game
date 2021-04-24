package model;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;



public interface IMonster {
    Pane drawMonster(Pane root);
    boolean isDead();
    int getHealth();
    void setHealth(int newHealth);
    int getDamage();
    int getRadius();
    int getX();
    int getY();
}
