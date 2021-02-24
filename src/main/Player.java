package main;

public class Player {

    private String name;
    private int health;
    private int money;
    private int level;
    private int x,y;

    public Player() {
        health = 100;
        money = 0;
        level = 1;
        name = "";
        x = 300;
        y = 400;
    }

    // Edit by Siying: money varies based on difficulty
    public void setMoney(int difficulty) {
        if(difficulty == 1) {
            money = 10000;
        }
        if(difficulty == 2) {
            money = 20000;
        }
        if(difficulty == 3) {
            money = 30000;
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLevel() {
        return level;
    }
}
