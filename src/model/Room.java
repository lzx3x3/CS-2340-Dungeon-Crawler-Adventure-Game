package model;

import javafx.scene.layout.Pane;

import java.util.List;

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
        //createTileArray();
    }
    public abstract void createTileArray();
    public abstract Tile[][] getTileArray();
    public abstract Pane drawRoom(Pane root, Player player);
    public abstract List<IMonster> getMonsterArray();
    public abstract List<IItems> getItemArray();
    public abstract void removeItem(IItems item);
}
