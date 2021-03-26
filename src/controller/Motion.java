package controller;
import model.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

import java.util.List;

public class Motion {

    private Player player;
    private Monster1 monster1;
    private Monster2 monster2;
    private Scene scene;
    private Stage stage;
    private Draw draw;

    public Motion(Player player, Scene scene, Stage stage, Controller controller, Draw draw) {
        this.player = player;
        this.scene = scene;
        this.stage = stage;
        this.draw = draw;
        this.monster1 = new Monster1();
        this.monster2 = new Monster2();
        keyHandler(controller);
    }

    private void keyHandler(Controller controller) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                player.decreaseY();
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.A) {
                player.decreaseX();
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(), controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.S) {
                player.increaseY();
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(), controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.D) {
                player.increaseX();
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(), controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.F) {
                player.attack();
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(), controller));
            }
            if (player.getCurrRoom() instanceof ExitRoom) {
                List<IMonster> currMonsters = player.getCurrRoom().getMonsterArray();
                boolean allDead = true;
                for (IMonster monster : currMonsters) {
                    if(!monster.isDead())
                        allDead = false;
                }
                if(allDead)
                    controller.initEndScreen();
            }
            if(player.getHealth() <= 0) {
                controller.initLoseScreen();
            }
        });
    }
}
