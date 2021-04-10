package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttackPotion implements IItems {
    private int newDamage;
    private Image image;
    private int oldDamage;

    AttackPotion() {
        newDamage = 10;
        image = new Image ("file:resources/AttackPotion.png");
        oldDamage = 0;
    }

    @Override
    public void use(Player player) {
        oldDamage = player.getDamage();
        player.setDamage(oldDamage + newDamage);
        player.setUseAttack(true);

        //click on it (call initial use) if you press the key, have method if key pressed
        //and have potion. if both true, increment the damage. if uses are at 10 then you lose it
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

}
