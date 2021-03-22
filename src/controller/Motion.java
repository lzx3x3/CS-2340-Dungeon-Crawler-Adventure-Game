package controller;
import model.ExitRoom;
import model.Player;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class Motion {

    private Player player;
    private Scene scene;
    private Stage stage;
    private Draw draw;

    public Motion(Player player, Scene scene, Stage stage, Controller controller, Draw draw) {
        this.player = player;
        this.scene = scene;
        this.stage = stage;
        this.draw = draw;
        keyHandler(controller);
    }

    private void keyHandler(Controller controller) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                player.decreaseY();
                //player.decreHealth(50);
                scene.setRoot(draw.draw(player, controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.A) {
                player.decreaseX();
                scene.setRoot(draw.draw(player, controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.S) {
                player.increaseY();
                scene.setRoot(draw.draw(player, controller));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.D) {
                player.increaseX();
                scene.setRoot(draw.draw(player, controller));
                stage.setScene(scene);
            }
            if (player.getCurrRoom() instanceof ExitRoom) {
                controller.initEndScreen();
            }
            if(player.getHealth() < 0) {
                controller.initLoseScreen();
            }
        });
    }
}
