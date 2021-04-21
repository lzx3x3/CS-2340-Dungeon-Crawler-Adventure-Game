import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class LoseTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        /*Controller controller = new Controller();
        controller.setMainWindow(stage);
        controller.initLoseScreen();*/
        Controller controller = new Controller();
        controller.start(stage);
    }

    //edited by Kayla
    @Test
    public void testLoseScreen() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 20);
        for (int i = 0; i < 25; i++) {
            type(KeyCode.A);
            type(KeyCode.D);
        }
        verifyThat("EXIT", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testLoseAndRestart() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 20);
        for (int i = 0; i < 25; i++) {
            type(KeyCode.A);
            type(KeyCode.D);
        }
        clickOn("Try Again!");
        verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testLoseAndRoomsStat() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 20);
        for (int i = 0; i < 25; i++) {
            type(KeyCode.A);
            type(KeyCode.D);
        }
        verifyThat("Total Rooms Visited: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void testLoseAndMonstersStat() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 20);
        type(KeyCode.F, 5);
        type(KeyCode.D, 20);
        for (int i = 0; i < 25; i++) {
            type(KeyCode.A);
            type(KeyCode.D);
        }
        verifyThat("Total Monsters Killed: 1", NodeMatchers.isNotNull());
    }
}
