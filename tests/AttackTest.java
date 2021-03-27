import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextMatchers;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.testfx.api.FxAssert.verifyThat;

public class AttackTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        Player player = new Player();
        controller.setMainWindow(stage);
        controller.initInitialGameScreen(player);
    }

    // Edited by Pei Yi
    @Test
    public void testInitPlayerHealth() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        FxAssert.verifyThat("#healthValue", TextMatchers.hasText("Current health: 100"));
    }

    // Edited by Pei Yi
    @Test
    public void testInitMonHealth() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 100"));
    }

    // Edited by Siying
    @Test
    public void testMonsterHealthAttackLeftCloser() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        type(KeyCode.D, 1);
        type(KeyCode.F, 1);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 80"));
    }

    // Edited by Siying
    @Test
    public void testMonsterHealthAttackLeftFurther() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        type(KeyCode.F, 1);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 99"));
    }

    // Edited by Siying
    @Test
    public void testMonsterHealthAttackUp() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 4);
        type(KeyCode.D, 2);
        type(KeyCode.F, 1);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 80"));
    }
}
