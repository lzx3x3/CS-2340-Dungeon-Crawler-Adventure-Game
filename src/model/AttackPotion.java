package model;

import javafx.scene.image.Image;

public class AttackPotion implements IItems {
    private int newDamage;
    private Image image;

    AttackPotion() {
        this.newDamage = 30;
        image = new Image ("file:resources/AttackPotion.png");
    }

    @Override
    public void use(Player player) {
        player.setDamage(newDamage);
        //there will be some sort of measure of how temporary this should be,
        //and damage will be reverted back to original here once potion runs out
    }

    @Override
    public Image getImage() {
        return image;
    }
}
