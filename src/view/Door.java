package view;

import model.WoodenRoom;

public class Door {
    private int x = 0;
    private int y = 0;
    private WoodenRoom nextRoom;

    public Door(int x, int y, WoodenRoom nextRoom) {
        this.x = x;
        this.y = y;
        this.nextRoom = nextRoom;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public WoodenRoom getNextRoom() {
        return nextRoom;
    }
}
