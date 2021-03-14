import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class EndTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.setMainWindow(stage);
        controller.initEndScreen();
    }

    // Edited by Siying
    @Test
    public void testStartOver() {
        clickOn("STARTOVER");
        verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }


}
