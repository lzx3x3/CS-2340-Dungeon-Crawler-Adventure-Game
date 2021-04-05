import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class MazeLayoutTest extends ApplicationTest {
    private Controller controller = new Controller();
    @Override
    public void start(Stage stage) throws Exception {

        Player player = new Player();
        controller.setMainWindow(stage);
        controller.initInitialGameScreen(player);
    }

    // edited by Siying
    @Test
    public void testOldRoom() {
        clickOn("Right Door");
        clickOn("Bottom Door");
        clickOn("Top Door");
        clickOn("Left Door");
        verifyThat("Current level:11", NodeMatchers.isNotNull());
    }

    // edited by Kayla
    @Test
    public void testThrowAway() {
        type(KeyCode.D, 7);
        type(KeyCode.D, 7);
        type(KeyCode.W, 7);
        verifyThat("Current level:20", NodeMatchers.isNotNull());
    }

    // edited by Pei Yi
    @Test
    public void testDoorLocation() {
        type(KeyCode.W, 7);
        type(KeyCode.W, 14);
        verifyThat("Current level:10", NodeMatchers.isNotNull());
    }

    @Test
    public void testOldRoomPlayer() {
        type(KeyCode.D, 7);
        type(KeyCode.D, 1);
        type(KeyCode.A, 1);
        verifyThat("Current level:11", NodeMatchers.isNotNull());
    }
}
