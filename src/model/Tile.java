package model;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile {

    private int x;
    private int y;
    private String type;
    private Image image;

    private ArrayList<String> validTypes;
    private static Image[] textures;

//    public Tile(int x, int y, String type, Image image) {
//        this.x = x;
//        this.y = y;
//        this.type = type;
//        validTypes = new ArrayList<>();
//        validTypes.add("Wooden Floor");
//        validTypes.add("Stone Floor");
//        validTypes.add("Door");
//        validTypes.add("Obstacle");
//        validTypes.add("Enemy");
//        this.image = image;
//    }

    public Tile(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        validTypes = new ArrayList<>();
        validTypes.add("Wooden Floor");
        validTypes.add("Stone Floor");
        validTypes.add("Door");
        validTypes.add("Obstacle");
        validTypes.add("Enemy");
        textures = new Image[5];
        textures[0] = new Image("file:resources/wooden_floor.png"); // floor
        textures[1] = new Image("file:resources/images/stone.png"); // door
        textures[2] = new Image("file:resources/images/box.png"); // obstacle
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

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void setType(String newType) {
        if (validTypes.contains(newType)) {
            type = newType;
        }
    }


    /**
     *
     * @param index 0: floor, 1: door, 2: obstacle
     * @return
     */
    public static ImageView getImageView(int index) {
        ImageView woodFloorTile = new ImageView();
        woodFloorTile.setImage(textures[index]);

        return woodFloorTile;
}
