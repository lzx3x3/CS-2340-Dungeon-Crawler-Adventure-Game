package model;

import controller.Draw;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {

    private String name;
    private int health;
    private int money;
    private int level;
    private String difficulty;
    private int x;
    private int y;
    private Room currRoom;
    private Maze currMaze;
    private Draw draw;

    public Player() {
        health = 100;
        money = 0;
        level = 1;
        name = "";
        difficulty = "easy";
        x = 7;
        y = 7;
        currRoom = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Edit by Siying: money varies based on difficulty
    public void setMoney(String difficulty) {
        if (difficulty.equals("Easy")) {
            money = 30000;
        }
        if (difficulty.equals("Medium")) {
            money = 20000;
        }
        if (difficulty.equals("Hard")) {
            money = 10000;
        }
    }

    public int getMoney() {
        return this.money;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public void setDiff(String diff) {
        this.difficulty = diff;
    }

    public String getDiff() {
        return this.difficulty;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void increaseX() {
        if (x < 14) {
            x++;
            checkCollision(x, y);
        }
    }

    public void increaseY() {
        if (y < 14) {
            y++;
            checkCollision(x, y);
        }
    }

    public void decreaseX() {
        if (x > 0) {
            x--;
            checkCollision(x, y);
        }
    }

    public void decreaseY() {
        if (y > 0) {
            y--;
            checkCollision(x, y);
        }
    }

    public Room getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Room room) {
        currRoom = room;
    }

    public void setMaze(Maze maze) {
        currMaze = maze;
    }

    public Maze getMaze() {
        return currMaze;
    }

    public Pane drawPlayer(Pane root) {
        ImageView iV = new ImageView();
        iV.setImage(new Image("file:resources/player.png"));
        iV.setX(x * 32 + 50);
        iV.setY(y * 32 + 50);
        root.getChildren().add(iV);

        return root;
    }

    public Pane drawDeadPlayer(Pane root) {
//        ImageView iV = new ImageView();
//        iV.setImage(new Image("file:resources/player.png"));
//        iV.setX(x * 32 + 50);
//        iV.setY(y * 32 + 50);
//        root.getChildren().add(iV);

        return root;
    }

    private void checkCollision(int x, int y) {
        Tile[][] array = currRoom.getTileArray();

        if (array[x][y].getType() == "Door") {
            if (x == 14 && y == 7) {
                //right
                if (currRoom.getRightDoor() != null) {
                    currMaze.updateRoom("RIGHT");
                    currRoom = currMaze.getCurrentRoom();
                    setX(0);
                    setY(7);
                }

            } else if (x == 7 && y == 0) {
                //top
                if (currRoom.getTopDoor() != null) {
                    currMaze.updateRoom("UP");
                    currRoom = currMaze.getCurrentRoom();
                    setX(7);
                    setY(14);
                }

            } else if (x == 0 && y == 7) {
                //left
                if (currRoom.getLeftDoor() != null) {
                    currMaze.updateRoom("LEFT");
                    currRoom = currMaze.getCurrentRoom();
                    setX(14);
                    setY(7);
                }

            } else if (x == 7 && y == 14) {
                //bottom
                if (currRoom.getBottomDoor() != null) {
                    currMaze.updateRoom("DOWN");
                    currRoom = currMaze.getCurrentRoom();
                    setX(7);
                    setY(0);
                }

            }
        }
    }

    public int getHealth() {
        return health;
    }

    public void decreHealth(int loss) {
        this.health = health - loss;
    }

    public void increHealth(int gain) {
        this.health = health + gain;
    }
}
