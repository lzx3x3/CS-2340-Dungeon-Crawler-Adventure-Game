package model;

public class Player {

    private String name;
    private int health;
    private int money;
    private int level;
    private String difficulty;
    private int x,y;

    public Player() {
        health = 100;
        money = 0;
        level = 1;
        name = "";
        difficulty = "easy";
        x = 300;
        y = 400;
    }

    public Player(String name, String difficulty) {
        health = 100;
        money = 0;
        level = 1;
        this.name = name;
        this.difficulty = difficulty;
        x = 300;
        y = 400;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Edit by Siying: money varies based on difficulty
    public void setMoney(String difficulty) {
        if(difficulty.equals("Easy")) {
            money = 10000;
        }
        if(difficulty.equals("Medium")) {
            money = 20000;
        }
        if(difficulty.equals("Hard")) {
            money = 30000;
        }
    }

    public int getMoney() {
        return this.money;
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
}
