import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.ExitRoom;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class MotionTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.start(stage);
    }

    @Test
    public void testRightRoom() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 8);
        verifyThat("Current Room:21", NodeMatchers.isNotNull());
    }
    @Test
    public void testBottomRoom() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.S, 8);
        verifyThat("Current Room:12", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testExitRoom() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Easy");
        clickOn(".wpn2Button");
        clickOn("Start");
        Player player = new Player();
        type(KeyCode.S, 7);
        for (int i = 1; i < 4; i++) {
            type(KeyCode.S, 14);
        }
        type(KeyCode.S, 7);
        if (player.getCurrRoom() instanceof ExitRoom) {
            verifyThat("STARTOVER", NodeMatchers.isNotNull());
        } else {
            int count = 1;
            for (int i = 1; i <= 4; i++) {
                if (!(player.getCurrRoom() instanceof ExitRoom)) {
                    if (count == 1) {
                        type(KeyCode.D, 7);
                        count++;
                    } else {
                        type(KeyCode.D, 14);
                    }
                } else {
                    break;
                }
            }
        }
        verifyThat("STARTOVER", NodeMatchers.isNotNull());
    }

    @Test
    public void testRetreatToUnvisited() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        type(KeyCode.S, 7);
        type(KeyCode.D, 7);
        verifyThat("Current Room:21", NodeMatchers.isNotNull());
    }

    @Test
    public void testRetreatToVisited() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 8);
        type(KeyCode.A, 3);
        verifyThat("Current Room:11", NodeMatchers.isNotNull());
    }

    // Edited by Jason
    @Test
    public void testAdvanceAfterMonsterKill() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.S, 14);
        type(KeyCode.D, 2);
        type(KeyCode.F, 5);
        type(KeyCode.S, 7);
        type(KeyCode.A, 1);
        verifyThat("Current Room:13", NodeMatchers.isNotNull());
    }
}

