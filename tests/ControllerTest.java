import controller.Controller;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest extends ApplicationTest {
    @Override
    @BeforeEach
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.start(primaryStage);
    }
    @Test
    public void testWeaponButton() {
        clickOn(".wpn1Button");
        verifyThat("Weapon 1 selected!", NodeMatchers.isNotNull());
    }

    //Edited by Siying
    @Test
    public void testBackInitialConfig() {
        clickOn("#BACK");
        verifyThat("Start", NodeMatchers.isNotNull());
    }

    @Test
    public void testGetMoney() {
        Player player = new Player();
        player.setMoney("Easy");
        assertEquals(10000, player.getMoney());
    }
}
