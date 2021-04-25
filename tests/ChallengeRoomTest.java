import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class ChallengeRoomTest extends ApplicationTest {
    Controller controller;
    @Override
    public void start(Stage stage) throws Exception {
        controller = new Controller();
        controller.start(stage);
    }

    @Test
    public void testChallengeRoomAlert() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        Player player = controller.getPlayer();
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        verifyThat("OK", NodeMatchers.isNotNull());
    }

    @Test
    public void testChallengeRoomMonsters() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        Player player = controller.getPlayer();
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        clickOn("OK");
        verifyThat("health: 100", NodeMatchers.isNotNull());
    }

}
