package controller;
import model.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;


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
        //this.monster1 = new Monster1();
        //this.monster2 = new Monster2();
        keyHandler(controller);
    }

    private void keyHandler(Controller controller) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                player.decreaseY();
                player.getWeapon().setY(player.getY());
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),
                         controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.A) {
                player.decreaseX();
                player.getWeapon().setX(player.getX());
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),
                        controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.S) {
                player.increaseY();
                player.getWeapon().setY(player.getY());
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),
                        controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.D) {
                player.increaseX();
                player.getWeapon().setX(player.getX());
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),
                        controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.F) {
                if (!player.checkMonstersDead()) {
                    player.attack();
                    if (player.checkMonstersDead()) {
                        player.setHealth(10); //player's health increases 10 after defeating monster
                    }

                    player.useAttackPotion();
                }
                scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),
                        controller));
            }
            if (player.getCurrRoom() instanceof ExitRoom) {
                if (player.checkMonstersDead()) {
                    scene.setRoot(draw.drawSprites(player, player.getCurrRoom().getMonsterArray(),
                            controller));
                    stage.setScene(scene);
                    if (player.getPassExit()) {
                        controller.initEndScreen();
                    }
                }
            }
            if (player.getHealth() <= 0) {
                controller.initLoseScreen();
            }
        });
    }
}
