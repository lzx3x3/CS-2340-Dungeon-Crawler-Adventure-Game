package model;

import java.util.Random;

public class Maze {
    public Room[][] maze;
    private int X;
    private int Y;
    public Maze() {
        maze = new Room[7][7];
        X = 1;
        Y = 1;
        createMaze();
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
        // Initialize start room
        maze[1][1] = new StartRoom(1, 15, 15);
        // Initialize random exit
        Random r = new Random();
        int position = r.nextInt(4 - 2 + 1) + 2;
        maze[position][5] = new ExitRoom(position, 15, 15);
        for (int i = 0; i < 6; i++) {
            // Dead-end room creation (WIP)
            maze[0][i] = new WoodenRoom(i, 15, 15);
            maze[6][i] = new WoodenRoom(i, 15, 15);
            maze[i][6] = new WoodenRoom(i, 15, 15);
            maze[i][0] = new WoodenRoom(i, 15, 15);
        }
    }
}
