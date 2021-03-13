package controller;
import model.ExitRoom;
import model.Player;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Motion {

    private Player player;
    private Scene scene;
    private Stage stage;

    public Motion(Player player, Scene scene, Stage stage, Controller controller) {
        this.player = player;
        this.scene = scene;
        this.stage = stage;
        keyHandler(controller);
    }

    private void keyHandler(Controller controller) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                player.decreaseY();
                scene.setRoot(Draw.draw(player));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.A) {
                player.decreaseX();
                scene.setRoot(Draw.draw(player));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.S) {
                player.increaseY();
                scene.setRoot(Draw.draw(player));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.D) {
                player.increaseX();
                scene.setRoot(Draw.draw(player));
                stage.setScene(scene);
            }
            if (player.getCurrRoom() instanceof ExitRoom) {
                controller.initEndScreen();
            }
        });
    }
}
