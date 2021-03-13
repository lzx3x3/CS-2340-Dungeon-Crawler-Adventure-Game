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
    private static Image[] textures;

    public Tile(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        oldRoom = null;
        newRoom = null;

        validTypes = new ArrayList<>();
        validTypes.add("Wooden Floor");
        validTypes.add("Stone Floor");
        validTypes.add("Door");
        validTypes.add("Obstacle");
        validTypes.add("Enemy");
        validTypes.add("Ladder");

        textures = new Image[5];
        textures[0] = new Image("file:resources/wooden_floor.png"); // floor
        textures[1] = new Image("file:resources/doors.png"); // door
        textures[2] = new Image("file:resources/images/box.jpg"); // obstacle
    }

    //    public void setImage(Image newImage) {
    //        image = newImage;
    //    }
    //
    //    public Image getImage() {
    //        return image;
    //    }

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
        y = newY;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        if (validTypes.contains(newType)) {
            type = newType;
        }
    }

    public static Image getImage(int index) {
        return textures[index];
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
