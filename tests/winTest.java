import controller.Controller;
import controller.Draw;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.EndMonster;
import model.ExitRoom;
import model.IMonster;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.testfx.api.FxAssert.verifyThat;

public class winTest extends ApplicationTest {

    Player player = new Player();
    ExitRoom exitRoom = new ExitRoom(1, 600, 800);

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        Pane root = new Pane();
        player.setCurrRoom(exitRoom);
        player.drawPlayer(root);
//        Draw draw = new Draw();
//        root = draw.drawSprites(player, monsters, controller);
        exitRoom.drawRoom(root, player);
        exitRoom.drawExit(root, player);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
        //controller.start(stage);
    }

    // Edited by Siying
    @Test
    public void testWinPerformanceMonsterDead() {
//        clickOn("Start");
//        write("test");
//        clickOn("Select your difficulty");
//        clickOn("Medium");
//        clickOn(".wpn1Button");
//        clickOn("Start");
        player.setCurrRoom(exitRoom);
        player.getCurrRoom().getMonsterArray().add(new EndMonster());

        type(KeyCode.W, 5);
        verifyThat("You Win!", NodeMatchers.isNotNull());
    }
}
