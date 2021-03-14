import com.sun.javafx.robot.FXRobot;
import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Player;
import model.Room;
import model.WoodenRoom;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.service.query.NodeQuery;
import org.testfx.service.query.impl.NodeQueryImpl;

import static org.testfx.api.FxAssert.verifyThat;

public class MazeTest  extends ApplicationTest {
    Controller controller = new Controller();
    @Override
    public void start(Stage stage) throws Exception {

        Player player = new Player();
        controller.setMainWindow(stage);
        controller.initInitialGameScreen(player);
    }

    // Edited by Siying
    @Test
    public void testOldRoom() {
        clickOn("Right Door");
        clickOn("Bottom Door");
        clickOn("Top Door");
        clickOn("Left Door");
        verifyThat("Current level:11", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testThrowAway() {
        Player player = new Player();
        type(KeyCode.D, 7);
        type(KeyCode.D, 7);
        type(KeyCode.W, 7);
        verifyThat("Current level:20", NodeMatchers.isNotNull());
    }
}
