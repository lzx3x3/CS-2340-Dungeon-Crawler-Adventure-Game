package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HealthPotion implements IItems {
    private int healthAdded;
    private Image image;

    public HealthPotion() {
        this.healthAdded = 20;
        this.image = new Image("file:resources/HealthPotion.png");
    }

//    @Override
    public void use(Player player) {
        player.setHealth(healthAdded);
    }

    public int getHealthAdded() {
        return healthAdded;
    }

    public ImageView draw(int x, int y) {
        ImageView iV = new ImageView();
        iV.setImage(image);
        iV.setX((x + 2) * 32);
        iV.setY((y + 1.2) * 32);
        iV.setFitHeight(15);
        iV.setFitWidth(15);
        return iV;
    }
//    @Override
//    public Image getImage() {
//        return image;
//    }
}
