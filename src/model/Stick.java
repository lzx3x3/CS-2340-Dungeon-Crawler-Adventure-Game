package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class Stick extends Weapon {
    private int damage;
    private int range;
    private Image img;

    public Stick() {
        this.damage = 10;
        this.range = 1;
        this.img = new Image("file:resources/images/stick_removebg.png");
    }

    @Override
    public void use(Player player) {

    }

    @Override
    public ImageView draw(int x, int y) {
        ImageView iV = new ImageView();
        iV.setImage(img);
        iV.setX((x + 2.3) * 32);
        iV.setY((y + 1.8) * 32);
        iV.setFitHeight(18);
        iV.setFitWidth(18);
        return iV;
    }

//    public ImageView drawAttack(int x, int y) {
//        ImageView iV = new ImageView();
//
//        Rotate rotateTransform = new Rotate();
//        rotateTransform.setAngle(90);
//        rotateTransform.setPivotX(x + 2.3);
//        rotateTransform.setPivotY(y + 1.8);
//
//        iV.getTransforms().add(rotateTransform);
//        iV.setImage(img);
//        iV.setX((x + 2.3) * 32);
//        iV.setY((y + 1.8) * 32);
//        iV.setFitHeight(18);
//        iV.setFitWidth(18);
//        return iV;
//    }

    @Override
    public int getDamage() { return damage; }

    @Override
    public int getRange() { return range; }

//    public Image getImage() {
//        return img;
//    }
}
