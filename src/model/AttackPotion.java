package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttackPotion implements IItems {
    private int newDamage;
    private Image image;

    AttackPotion() {
        this.newDamage = 30;
        image = new Image ("file:resources/AttackPotion.png");
    }

//    @Override
    public void use(Player player) {
        player.setDamage(newDamage);
        //there will be some sort of measure of how temporary this should be,
        //and damage will be reverted back to original here once potion runs out
    }

    @Override
    public Image getImage() {
        return image;
    }

    public ImageView draw(int x, int y) {
        ImageView iV = new ImageView();
        iV.setImage(image);
        iV.setX((x + 2) * 32);
        iV.setY((y + 2) * 32);
        iV.setFitHeight(15);
        iV.setFitWidth(15);
        return iV;
    }

//    @Override
//    public Image getImage() {
//        return image;
//    }
}
