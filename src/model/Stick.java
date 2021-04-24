package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stick extends Weapon {
    private int damage;
    private int range;
    private Image img;
    private int x;
    private int y;

    public Stick(int x, int y) {
        this.damage = 10;
        this.range = 1;
        this.img = new Image("file:resources/images/stick_removebg.png");
        this.x = x;
        this.y = y;
    }

    @Override
    public void use(Player player) {
        this.x = player.getX();
        this.y = player.getY();
        player.useWeapon(this);
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public ImageView draw() {
        ImageView iV = new ImageView();
        iV.setImage(img);
        iV.setX((x + 2) * 32);
        iV.setY((y + 1.8) * 32);
        iV.setFitHeight(18);
        iV.setFitWidth(18);
        return iV;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getRange() {
        return range;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
}
