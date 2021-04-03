package model;

import controller.Draw;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.List;
import java.util.HashSet;
import java.util.Random;


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
    private int damage;
    private boolean attacked;
    private boolean attacking;
    private Weapon weapon;

    public Player() {
        health = 250;
        money = 0;
        level = 1;
        name = "";
        difficulty = "easy";
        x = 7;
        y = 7;
        currRoom = null;
        visitedRooms = new HashSet<Room>();
        damage = 20;
        attacked = false;
        attacking = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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

    public void setWeapon(String wpn) {
        if (wpn == "Stick") {
            this.weapon = new Stick();
        } else if (wpn == "Sword") {

        } else if (wpn == "Bow") {

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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int newDamage) {
        damage = newDamage;
    }

    public void addToVisitedRooms(Room room) {
        visitedRooms.add(room);
    }

    public HashSet<Room> getVisitedRooms() {
        return visitedRooms;
    }

    public void increaseX() {
        if (x < 14) {
            boolean monsterNear = false;
            for (IMonster monster : currRoom.getMonsterArray()) {
                if (monster instanceof Monster1) {
                    Monster1 monster1 = (Monster1) monster;
                    if (!monster1.isDead() && monster1.getX() == x + 1 && monster1.getY() == y) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof Monster2) {
                    Monster2 monster2 = (Monster2) monster;
                    if (!monster2.isDead() && monster2.getX() == x + 1 && monster2.getY() == y) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof EndMonster) {
                    EndMonster endMonster = (EndMonster) monster;
                    if (!endMonster.isDead() && endMonster.getX() == x + 1
                            && endMonster.getY() == y) {
                        monsterNear = true;
                        break;
                    }
                }
            }
            if (!monsterNear) {
                x++;
                checkCollision(x, y);
            }
        }
    }

    public void increaseY() {
        if (y < 14) {
            boolean monsterNear = false;
            for (IMonster monster : currRoom.getMonsterArray()) {
                if (monster instanceof Monster1) {
                    Monster1 m1 = (Monster1) monster;
                    if (!m1.isDead() && m1.getY() == y + 1 && m1.getX() == x) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof Monster2) {
                    Monster2 m2 = (Monster2) monster;
                    if (!m2.isDead() && m2.getY() == y + 1 && m2.getX() == x) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof  EndMonster) {
                    EndMonster endMonster = (EndMonster) monster;
                    if (!endMonster.isDead() && endMonster.getY() == y + 1
                            && endMonster.getX() == x) {
                        monsterNear = true;
                        break;
                    }
                }
            }
            if (!monsterNear) {
                y++;
                checkCollision(x, y);
            }
        }
    }

    public void decreaseX() {
        if (x > 0) {
            boolean monsterNear = false;
            for (IMonster monster : currRoom.getMonsterArray()) {
                if (monster instanceof Monster1) {
                    Monster1 monster1 = (Monster1) monster;
                    if (!monster1.isDead() && monster1.getX() == x - 1 && monster1.getY() == y) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof Monster2) {
                    Monster2 monster2 = (Monster2) monster;
                    if (!monster2.isDead() && monster2.getX() == x - 1 && monster2.getY() == y) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof EndMonster) {
                    EndMonster endMonster = (EndMonster) monster;
                    if (!endMonster.isDead() && endMonster.getX() == x - 1
                            && endMonster.getY() == y) {
                        monsterNear = true;
                        break;
                    }
                }
            }
            if (!monsterNear) {
                x--;
                checkCollision(x, y);
            }
        }
    }

    public void decreaseY() {
        if (y > 0) {
            boolean monsterNear = false;
            for (IMonster monster : currRoom.getMonsterArray()) {
                if (monster instanceof Monster1) {
                    Monster1 m1 = (Monster1) monster;
                    if (!m1.isDead() && m1.getY() == y - 1 && m1.getX() == x) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof Monster2) {
                    Monster2 m2 = (Monster2) monster;
                    if (!m2.isDead() && m2.getY() == y - 1 && m2.getX() == x) {
                        monsterNear = true;
                        break;
                    }
                } else if (monster instanceof  EndMonster) {
                    EndMonster endMonster = (EndMonster) monster;
                    if (!endMonster.isDead() && endMonster.getY() == y - 1
                            && endMonster.getX() == x) {
                        monsterNear = true;
                        break;
                    }
                }
            }
            if (!monsterNear) {
                y--;
                checkCollision(x, y);
            }
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

        ImageView iV2 = new ImageView();
        if (attacked) {
            iV2.setImage(new Image("file:resources/deduct.png"));
            iV2.setX((x + 1.8) * 32);
            iV2.setY((y + 1.2) * 32);
            iV2.setFitHeight(15);
            iV2.setFitWidth(15);
            attacked = false;
        }

        ImageView iV3 = new ImageView();;
        if (weapon != null) {
            if (attacking) {
                iV3 = weapon.drawAttack(x, y);
//                System.out.println(attacking);
                attacking = false;
            } else {
                iV3 = weapon.draw(x, y);
            }
        }

        System.out.println(iV3);
        root.getChildren().addAll(iV, iV2, iV3);
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
        checkAttacked();
        Tile[][] array = currRoom.getTileArray();
        if (array[x][y].getType() == "Door") {
            handleRoomChange(checkMonstersDead());
        }
    }

    public boolean checkIfVisited(Room room) {
        return visitedRooms.contains(room);
    }

    public boolean checkMonstersDead() {
        for (IMonster m:currRoom.getMonsterArray()) {
            if (!m.isDead()) {
                return false;
            }
        }
        return true;
    }

    private void handleRoomChange(Boolean clear) {
        if (x == 14 && y == 7) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
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
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
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
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
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
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
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
        //addToVisitedRooms(currRoom);
    }

    public int getHealth() {
        return health;
    }

    // diff can be positive or negative
    public void setHealth(int diff) {
        this.health = health + diff;
    }

    public void attack() {
        List<IMonster> monsters = currRoom.getMonsterArray();
        attacking = true;
        Random r = new Random();
        for (IMonster monster : monsters) {
            if (monster instanceof Monster1) {
                Monster1 m1 = (Monster1) monster;
                if (!m1.getDead()) {
                    if (Math.abs(m1.getX() - this.x) <= weapon.getRange() && m1.getY() == y) {
                        m1.setHealth(m1.getHealth() - weapon.getDamage());
                        int attackBack = r.nextInt(2);
                        if (attackBack == 1) {
                            checkAttacked();
                        }
                    } else if (Math.abs(m1.getY() - this.y) <= weapon.getRange()
                            && m1.getX() == x) {
                        m1.setHealth(m1.getHealth() - weapon.getDamage());
                        int attackBack = r.nextInt(2);
                        if (attackBack == 1) {
                            checkAttacked();
                        }
                    }
                }
            } else if (monster instanceof Monster2) {
                Monster2 m2 = (Monster2) monster;
                if (!m2.getDead()) {
                    if (Math.abs(m2.getX() - this.x) <= weapon.getRange() && m2.getY() == y) {
                        m2.setHealth(m2.getHealth() - weapon.getDamage());
                        int attackBack = r.nextInt(2);
                        if (attackBack == 1) {
                            checkAttacked();
                        }
                    } else if (Math.abs(m2.getY() - this.y) <= weapon.getRange()
                            && m2.getX() == x) {
                        m2.setHealth(m2.getHealth() - weapon.getDamage());
                        int attackBack = r.nextInt(2);
                        if (attackBack == 1) {
                            checkAttacked();
                        }
                    }
                }
            } else if (monster instanceof EndMonster) {
                EndMonster m3 = (EndMonster) monster;
                if (!m3.getDead()) {
                    if (Math.abs(m3.getX() - this.x) <= weapon.getRange() && m3.getY() == y) {
                        m3.setHealth(m3.getHealth() - weapon.getDamage());
                        int attackBack = r.nextInt(2);
                        if (attackBack == 1) {
                            checkAttacked();
                        }
                    } else if (Math.abs(m3.getY() - this.y) <= weapon.getRange()
                            && m3.getX() == x) {
                        m3.setHealth(m3.getHealth() - weapon.getDamage());
                        int attackBack = r.nextInt(2);
                        if (attackBack == 1) {
                            checkAttacked();
                        }
                    }
                }
            }
        }
    }

    private void checkAttacked() {
        List<IMonster> monsters = currRoom.getMonsterArray();
        for (IMonster monster : monsters) {
            if (monster.isDead()) {
                attacked = false;
            } else {
                if (monster instanceof Monster1) {
                    Monster1 m1 = (Monster1) monster;
                    if (Math.hypot((this.x - m1.getX()), (this.y - m1.getY())) < m1.getRadius()) {
                        health -= m1.getDamage();
                        attacked = true;
                    }
                } else if (monster instanceof Monster2) {
                    Monster2 m2 = (Monster2) monster;
                    if (Math.hypot((this.x - m2.getX()), (this.y - m2.getY())) < m2.getRadius()) {
                        health -= m2.getDamage();
                        attacked = true;
                    }
                } else if (monster instanceof EndMonster) {
                    EndMonster m3 = (EndMonster) monster;
                    if (Math.hypot((this.x - m3.getX()), (this.y - m3.getY())) < m3.getRadius()) {
                        health -= m3.getDamage();
                        attacked = true;
                    }
                }
            }

        }
    }
}
