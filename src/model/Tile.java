package model;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Tile {

    private int x;
    private int y;
    private String type;
    private Image image;
    private Room oldRoom;
    private Room newRoom;

    private ArrayList<String> validTypes;


    public Tile(int x, int y, String type, Image image) {
        this.x = x;
        this.y = y;
        this.type = type;
        validTypes = new ArrayList<>();
        validTypes.add("Wooden Floor");
        validTypes.add("Stone Floor");
        validTypes.add("Door");
        validTypes.add("Obstacle");
        validTypes.add("Enemy");
        validTypes.add("Ladder");
        this.image = image;
        oldRoom = null;
        newRoom = null;
    }

    public void setImage(Image newImage) {
        image = newImage;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y= newY;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        if (validTypes.contains(newType)) {
            type = newType;
        }
    }

    public void setOldRoom(Room room) {
        if (type.equals("Door")) {
            oldRoom = room;
        }
    }

    public Room getOldRoom() {
        return oldRoom;
    }

    public void setNewRoom(Room room) {
        if (type.equals("Door")) {
            newRoom = room;
        }
    }

    public Room getNewRoom() {
        return newRoom;
    }
}
