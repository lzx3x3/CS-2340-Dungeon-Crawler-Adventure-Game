package model;

public abstract class Weapon implements IItems {
    protected abstract int getDamage();
    protected abstract int getRange();
    public abstract int getX();
    public abstract int getY();
    public abstract void setX(int x);
    public abstract void setY(int y);
}
