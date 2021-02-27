import controller.Controller;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialGameTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.setMainWindow(stage);
        Player player = new Player();
        controller.initInitialGameScreen(player);
    }

    //edited by Siying
    @Test
    public void testBack() {
        clickOn("BACK");
        verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }
}
