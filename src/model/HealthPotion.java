package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HealthPotion implements IItems {
    private int healthAdded;
    private Image image;
    private int x;
    private int y;

    public HealthPotion(int x, int y) {
        this.healthAdded = 20;
        this.image = new Image("file:resources/HealthPotion.png");
        this.x = x;
        this.y = y;
    }

    @Override
    public void use(Player player) {
        player.setHealth(healthAdded);
    }

    @Override
    public Image getImage() {
        return image;
    }

    public int getHealthAdded() {
        return healthAdded;
    }

    public ImageView draw() {
        ImageView iV = new ImageView();
        iV.setImage(image);
        iV.setX((x + 1.8) * 32);
        iV.setY((y + 2.0) * 32);
        iV.setFitHeight(15);
        iV.setFitWidth(15);
        return iV;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
