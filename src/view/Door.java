package view;

public class Door {
    private int x = 0;
    private int y = 0;
    private Room nextRoom;

    Door(int x, int y, Room nextRoom) {
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

    public Room getNextRoom() {
        return nextRoom;
    }
}
