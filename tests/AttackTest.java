import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.TextMatchers;

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
        FxAssert.verifyThat("#healthValue", TextMatchers.hasText("Current health: 250"));
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
        type(KeyCode.S, 7);
        type(KeyCode.D, 2);
        type(KeyCode.F, 1);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 80"));
    }

    // Edited by Siying
    @Test
    public void testMonsterHealthAttackLeftFurther() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 7);
        type(KeyCode.F, 1);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 100"));
    }


    // Edited by Jason
    @Test
    public void testMonsterKill() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        type(KeyCode.D, 2);
        type(KeyCode.F, 6);
        FxAssert.verifyThat("#monHealth", TextMatchers.hasText("health: 0"));
    }

    // Edited by Pei Yi
    @Test
    public void testPlayerOutside() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 3);
        FxAssert.verifyThat("#healthValue", TextMatchers.hasText("Current health: 250"));
    }
}
