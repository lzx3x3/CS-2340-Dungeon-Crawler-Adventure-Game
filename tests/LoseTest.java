import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class LoseTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.setMainWindow(stage);
        controller.initLoseScreen();
    }

    //edited by Kayla
    @Test
    public void testLoseScreen() {
        verifyThat("EXIT", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testLoseAndRestart() {
        clickOn("Try Again!");
        verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }

}
