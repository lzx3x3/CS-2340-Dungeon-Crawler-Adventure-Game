package model;

public class Maze {
    public Room[][] maze;
    private int X;
    private int Y;
    public Maze() {
        maze = new Room[7][7];
        X = 1;
        Y = 1;
    }

    public void updateRoom(String direction) {
        if (direction.equals("UP")) {
            Y--;
        } else if (direction.equals("DOWN")) {
            Y++;
        } else if (direction.equals("RIGHT")) {
            X++;
        } else if (direction.equals("LEFT")) {
            X--;
        }
    }

    public void createMaze() {

    }
}
