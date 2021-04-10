package model;

public abstract class Weapon implements IItems {
    protected abstract int getDamage();
    protected abstract int getRange();
}
