package model;

import javafx.scene.image.ImageView;

public abstract class Weapon implements IItems {
    protected abstract int getDamage();
    protected abstract int getRange();
    protected abstract ImageView drawAttack(int x, int y);
}
