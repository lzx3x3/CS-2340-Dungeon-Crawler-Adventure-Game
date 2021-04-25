package model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    private Inventory inventory;
    private int damage;
    private boolean attacked;
    private Weapon weapon;
    private boolean wpnUpdated;
    private int timesAttack;
    private boolean useAttack;
    private int damageDealt;
    private int monstersKilled;
    private boolean passExit;

    public Player() {
        health = 300;
        money = 0;
        level = 1;
        name = "";
        difficulty = "easy";
        x = 7;
        y = 7;
        currRoom = null;
        visitedRooms = new HashSet<Room>();
        inventory = new Inventory(this);
        damage = 20;
        attacked = false;
        wpnUpdated = false;
        timesAttack = 0;
        useAttack = false;
        damageDealt = 0;
        monstersKilled = 0;
        passExit = false;
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

    public int getMoney() {
        return this.money;
    }

    public void changeMoney(int cost) {
        this.money = money - cost;
    }

    public void setWeaponType(String wpn) {
        if (wpn == "Stick") {
            this.weapon = new Stick(x, y);
        } else if (wpn == "Sword") {
            this.weapon = new Sword(x, y);
        } else if (wpn == "Bow") {
            this.weapon = new Bow(x, y);
        }
        inventory.add(this.weapon);
    }

    public void useWeapon(Weapon wpn) {
        this.weapon = wpn;
        wpnUpdated = true;
    }

    public int getLevel() {
        return this.level;
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

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public int getTimesAttack() {
        return timesAttack;
    }

    public void setTimesAttack(int newAttack) {
        if (timesAttack == 10) {
            timesAttack = 0;
        } else {
            timesAttack = newAttack;
        }
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
                if (!monster.isDead() && monster.getX() == x + 1 && monster.getY() == y) {
                    monsterNear = true;
                    break;
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
                if (!monster.isDead() && monster.getY() == y + 1 && monster.getX() == x) {
                    monsterNear = true;
                    break;
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
                if (!monster.isDead() && monster.getX() == x - 1 && monster.getY() == y) {
                    monsterNear = true;
                    break;
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
                if (!monster.isDead() && monster.getY() == y - 1 && monster.getX() == x) {
                    monsterNear = true;
                    break;
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

        ImageView iV3 = new ImageView();
        if (weapon != null) {
            iV3 = weapon.draw();
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
        checkMonsterAttack();
        Tile[][] array = currRoom.getTileArray();
        if (array[x][y].getType() == "Door") {
            if (currRoom instanceof ChallengeRoom) {
                challengeRoomChange(checkMonstersDead());
            } else {
                handleRoomChange(checkMonstersDead());
            }
        }
        //if (x == 9 && y == 7) {
        //    if (checkMonstersDead() && !currRoom.getItemArray().isEmpty()) {
        //        //currRoom.removeItem();
        //        IItems item = currRoom.removeItem();
        //        if (item != null) {
        //            inventory.add(item);
        //        }
        //    }
        //}
        //List<IMonster> monsters = currRoom.getMonsterArray();
        //for (IMonster monster : monsters) {
        //    if (x == monster.getX() && y == monster.getY() && monster.isDead()
        //            && !currRoom.getItemArray().isEmpty()) {
        //        IItems item = currRoom.removeItem();
        //        if (item != null) {
        //            inventory.add(item);
        //        }
        //    }
        //}
        IItems removedItem = null;
        for (IItems item : currRoom.getItemArray()) {
            if (x == item.getX() && y == item.getY()) {
                removedItem = item;
                inventory.add(item);
            }
        }

        if (removedItem != null) {
            currRoom.removeItem(removedItem);
        }
        if (currRoom instanceof Deadend2 || currRoom instanceof Deadend3) {
            if (!currRoom.getItemArray().isEmpty()) {
                IItems item = currRoom.getItemArray().get(0);
                if (item != null) {
                    inventory.add(item);
                }
            }
        }
    }

    public boolean checkIfVisited(Room room) {
        return visitedRooms.contains(room);
    }

    public boolean checkMonstersDead() {
        if (currRoom instanceof ChallengeRoom) {
            if (!((ChallengeRoom) currRoom).getWantsChallenge()) {
                return true;
            }
        }
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
            currMaze.updateRoom("RIGHT");
            if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                currRoom = currMaze.getCurrentRoom();
                setX(0);
                setY(7);
            } else {
                currMaze.updateRoom("LEFT");
            }
        } else if (x == 7 && y == 0) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //top
            currMaze.updateRoom("UP");
            if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                currRoom = currMaze.getCurrentRoom();
                setX(7);
                setY(14);
            } else {
                currMaze.updateRoom("DOWN");
            }
        } else if (x == 0 && y == 7) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //left
            currMaze.updateRoom("LEFT");
            if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                currRoom = currMaze.getCurrentRoom();
                setX(14);
                setY(7);
            } else {
                currMaze.updateRoom("RIGHT");
            }
        } else if (x == 7 && y == 14) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //bottom
            currMaze.updateRoom("DOWN");
            if (clear || visitedRooms.contains(currMaze.getCurrentRoom())) {
                currRoom = currMaze.getCurrentRoom();
                setX(7);
                setY(0);
            } else {
                currMaze.updateRoom("UP");
            }
        }
        if (currRoom instanceof ChallengeRoom) {
            if (!visitedRooms.contains(currRoom)) {
                ((ChallengeRoom) currRoom).setWantsChallenge(false);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Challenge Room");
                alert.setHeaderText("Challenge Room");
                alert.setContentText("You have reached a Challenge Room!"
                        + " Would you like to take the challenge?");
                alert.showAndWait().ifPresent((button) -> {
                    if (button == ButtonType.OK) {
                        ((ChallengeRoom) currRoom).setWantsChallenge(true);
                        money += 10000;
                    } else if (button == ButtonType.CANCEL) {
                        ((ChallengeRoom) currRoom).setWantsChallenge(false);
                    }
                });
            }
        }
        //addToVisitedRooms(currRoom);
    }

    private void challengeRoomChange(Boolean clear) {
        if (x == 14 && y == 7) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //right
            if (clear) {
                currMaze.updateRoom("RIGHT");
                currRoom = currMaze.getCurrentRoom();
                setX(0);
                setY(7);
            }
        } else if (x == 7 && y == 0) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //top
            if (clear) {
                currMaze.updateRoom("UP");
                currRoom = currMaze.getCurrentRoom();
                setX(7);
                setY(14);
            }
        } else if (x == 0 && y == 7) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //left
            if (clear) {
                currMaze.updateRoom("LEFT");
                currRoom = currMaze.getCurrentRoom();
                setX(14);
                setY(7);
            }
        } else if (x == 7 && y == 14) {
            if (checkMonstersDead()) {
                addToVisitedRooms(currRoom);
            }
            //bottom
            if (clear) {
                currMaze.updateRoom("DOWN");
                currRoom = currMaze.getCurrentRoom();
                setX(7);
                setY(0);
            }
        }
    }

    public int getHealth() {
        return health;
    }

    // diff can be positive or negative
    public void setHealth(int diff) {
        health = health + diff;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public void attack() {
        System.out.println("attack");
        List<IMonster> monsters = currRoom.getMonsterArray();
        for (IMonster monster : monsters) {
            if (!monster.isDead()) {
                if (Math.abs(monster.getX() - this.x) <= weapon.getRange() && monster.getY() == y) {
                    monster.setHealth(monster.getHealth() - weapon.getDamage());
                    damageDealt += damage;
                    System.out.println("deduct health");
                    if (monster.isDead()) {
                        monstersKilled++;
                    }
                    attacked();
                } else if (Math.abs(monster.getY() - this.y) <= weapon.getRange()
                        && monster.getX() == x) {
                    monster.setHealth(monster.getHealth() - weapon.getDamage());
                    damageDealt += damage;
                    System.out.println("deduct health");
                    if (monster.isDead()) {
                        monstersKilled++;
                    }
                    attacked();
                }
            }
        }
    }

    private void attacked() {
        Random r = new Random();
        int attackBack = r.nextInt(2);
        if (attackBack == 1) {
            checkMonsterAttack();
        }
    }

    private void checkMonsterAttack() {
        List<IMonster> monsters = currRoom.getMonsterArray();
        for (IMonster monster : monsters) {
            if (monster.isDead()) {
                attacked = false;
            } else {
                if (Math.hypot((this.x - monster.getX()),
                        (this.y - monster.getY())) < monster.getRadius()) {
                    health -= monster.getDamage();
                    attacked = true;
                }
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setUseAttack(boolean used) {
        useAttack = used;
    }

    public void useAttackPotion() {
        for (IMonster monster : getCurrRoom().getMonsterArray()) {
            if (Math.abs(monster.getX() - x) <= monster.getRadius()
                    && Math.abs(monster.getY() - y) <= monster.getRadius()) {
                if (useAttack) {
                    timesAttack++;
                }
                break;
            }
        }
        if (timesAttack >= 10 && useAttack) {
            damage = damage - 10;
            useAttack = false;
            timesAttack = 0;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean getPassExit() {
        return this.passExit;
    }

    public void setPassExit(boolean pass) {
        this.passExit = pass;
    }
    public void killMonster() {
        currRoom.getMonsterArray().get(0).setHealth(0);
    }
}
