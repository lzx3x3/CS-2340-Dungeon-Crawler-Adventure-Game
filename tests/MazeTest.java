import controller.Controller;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class MazeTest  extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        Player player = new Player();
        controller.setMainWindow(stage);
        controller.initInitialGameScreen(player);
    }

    // Edited by Siying
    @Test
    public void testRightRoom() {
        clickOn("Right Door");
        verifyThat("Current level:21", NodeMatchers.isNotNull());
    }
}
