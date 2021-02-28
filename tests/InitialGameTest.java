import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialGameTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.start(stage);
    }

    //edited by Siying
    @Test
    public void testBack() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Easy");
        clickOn(".wpn1Button");
        clickOn("Start");
        clickOn("BACK");
        verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }


    //edited by Jessica
    @Test
    public void testDifficulty() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Easy");
        clickOn(".wpn1Button");
        clickOn("Start");
        verifyThat("Current Difficulty: Easy", NodeMatchers.isNotNull());
    }

    @Test
    public void testStartingMoney() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        verifyThat("Current Money: 20000", NodeMatchers.isNotNull());
    }

    // Edited by Jason
    @Test
    public void testNameAlert() {
        clickOn("Start");
        clickOn("Start");
        verifyThat("OK", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testDifficultyAlert() {
        clickOn("Start");
        write("test");
        clickOn(".wpn2Button");
        clickOn("Start");
        verifyThat("OK", NodeMatchers.isNotNull());
    }

    @Test
    public void testStartGame() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn(".wpn2Button");
        clickOn("Start");
        verifyThat("BACK", NodeMatchers.isNotNull());
    }


}
