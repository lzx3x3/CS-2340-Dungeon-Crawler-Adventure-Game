package model;

import javafx.scene.layout.Pane;

public abstract class Room {
    protected int height;
    protected int width;
    protected int index;
    protected Tile[][] tileArray;

    public Room(int index, int height, int width) {
        this.index = index;
        this.height = height;
        this.width = width;
        tileArray = new Tile[width][height];
//        createTileArray();
    }

    public abstract void createTileArray();
    public abstract Tile[][] getTileArray();
    public abstract Pane drawRoom(Pane root, Player player);
}
