package model;

import controller.Draw;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;


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
    private HashSet<Room> visitedRooms;
    private Draw draw;
    private int damage = 20;
    private int range = 1;

    public Player() {
        health = 100;
        money = 0;
        level = 1;
        name = "";
        difficulty = "easy";
        x = 7;
        y = 7;
        currRoom = null;
        visitedRooms = new HashSet<Room>();
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

    public void addToVisitedRooms(Room room) {
        visitedRooms.add(room);
    }

    public HashSet<Room> getVisitedRooms() {
        return visitedRooms;
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
        ImageView iV = new ImageView();
        iV.setImage(new Image("file:resources/player.png"));
        iV.setRotate(90);
        iV.setX(x * 32 + 50);
        iV.setY(y * 32 + 50);
        root.getChildren().add(iV);

        return root;
    }

    private void checkCollision(int x, int y) {
        Tile[][] array = currRoom.getTileArray();

        if (array[x][y].getType() == "Door") {
            boolean clearRoom = true;
            /*for (Monster monster : monsterlist) {
                if (!monster.isDead()) {
                    clearRoom = false;
                }
            } */
            handleRoomChange(clearRoom);
        }
    }

    private boolean checkIfVisited(Room room) {
        return visitedRooms.contains(room);
    }

    private void handleRoomChange(Boolean clear) {
        if (x == 14 && y == 7) {
            //right
            if (currRoom.getRightDoor() != null) {
                currMaze.updateRoom("RIGHT");
                if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                    currRoom = currMaze.getCurrentRoom();
                    setX(0);
                    setY(7);
                } else {
                    currMaze.updateRoom("LEFT");
                }
            }
        } else if (x == 7 && y == 0) {
            //top
            if (currRoom.getTopDoor() != null) {
                currMaze.updateRoom("UP");
                if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                    currRoom = currMaze.getCurrentRoom();
                    setX(7);
                    setY(14);
                } else {
                    currMaze.updateRoom("DOWN");
                }
            }
        } else if (x == 0 && y == 7) {
            //left
            if (currRoom.getLeftDoor() != null) {
                currMaze.updateRoom("LEFT");
                if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                    currRoom = currMaze.getCurrentRoom();
                    setX(14);
                    setY(7);
                } else {
                    currMaze.updateRoom("RIGHT");
                }
            }
        } else if (x == 7 && y == 14) {
            //bottom
            if (currRoom.getBottomDoor() != null) {
                currMaze.updateRoom("DOWN");
                if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                    currRoom = currMaze.getCurrentRoom();
                    setX(7);
                    setY(0);
                } else {
                    currMaze.updateRoom("UP");
                }
            }
        }
        addToVisitedRooms(currRoom);
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

    public void attack() {
        List<IMonster> monsters = currRoom.getMonsterArray();
        for (IMonster monster : monsters) {
            if (monster instanceof Monster1) {
                Monster1 m1 = (Monster1) monster;
                if (!m1.getDead()) {
                    if (Math.abs(m1.getX() - this.x) <= range) {
                        m1.setHealth(m1.getHealth() - damage);
                    } else if (Math.abs(m1.getY() - this.y) <= range) {
                        m1.setHealth(m1.getHealth() - 1);
                    }
                }
                System.out.println("Monster Health: " + m1.getHealth());
            } else if (monster instanceof Monster2) {
                Monster2 m2 =(Monster2) monster;
                if (m2.getDead()) {
                    if (Math.abs(m2.getX() - this.x) <= range) {
                        m2.setHealth(m2.getHealth() - damage);
                    } else if (Math.abs(m2.getY() - this.y) <= range) {
                        m2.setHealth(m2.getHealth() - 1);
                    }
                }
                System.out.println(m2.getHealth());
            }
        }
    }

    private void checkAttacked() {
        List<IMonster> monsters = currRoom.getMonsterArray();
        for (IMonster monster : monsters) {
            if (monster instanceof Monster1) {
                Monster1 m1 = (Monster1) monster;
                if (Math.hypot((this.x - m1.getX()), (this.y - m1.getY())) < m1.getRadius())
                    health -= m1.getDamage();
                System.out.println("Player Health: " + health);
            } else if (monster instanceof Monster2) {
                Monster2 m2 = (Monster2) monster;
                if (Math.hypot((this.x - m2.getX()), (this.y - m2.getY())) < m2.getRadius())
                    health -= m2.getDamage();
                System.out.println("Player Health: " + health);
            }
        }
    }
}
