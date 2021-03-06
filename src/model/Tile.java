package model;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Tile {

    private int x;
    private int y;
    private String type;
    private Image image;

    private ArrayList<String> validTypes;


    Tile(int x, int y, String type, Image image) {
        this.x = x;
        this.y = y;
        this.type = type;
        validTypes = new ArrayList<>();
        validTypes.add("Wooden Floor");
        validTypes.add("Stone Floor");
        validTypes.add("Door");
        validTypes.add("Obstacle");
        validTypes.add("Enemy");
        this.image = image;
    }

    public void setImage(Image newImage) {
        image = newImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
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
}
