package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttackPotion implements IItems {
    private int newDamage;
    private Image image;
    private int oldDamage;
    private int x;
    private int y;

    public AttackPotion(int x, int y) {
        newDamage = 10;
        image = new Image("file:resources/AttackPotion.png");
        oldDamage = 0;
        this.x = x;
        this.y = y;
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
