package model;

import javafx.scene.image.Image;

public class HealthPotion implements IItems {
    private int healthAdded;
    private Image image;

    public HealthPotion() {
        this.healthAdded = 20;
        this.image = new Image("file:resources/AttackPotion.png");
    }

    @Override
    public void use(Player player) {
        player.setHealth(healthAdded);
    }

    public int getHealthAdded() {
        return healthAdded;
    }

    @Override
    public Image getImage() {
        return image;
    }
}
