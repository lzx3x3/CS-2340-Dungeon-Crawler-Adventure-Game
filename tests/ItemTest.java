import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Deadend2;
import model.MagicStone;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ItemTest extends ApplicationTest {

    Player player = new Player();
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.setMainWindow(stage);
        controller.initInitialGameScreen(player);
    }

    @Test
    public void testMagicStoneUse() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        MagicStone stone = new MagicStone();
        stone.use(player);
        assertEquals(true, player.checkMonstersDead());
    }

    @Test
    public void testChestOpen() {
        type(KeyCode.S, 7);

        type(KeyCode.S, 7);
        type(KeyCode.D, 2);
        type(KeyCode.F, 6);
        type(KeyCode.A, 2);

        type(KeyCode.S, 7);
        type(KeyCode.D, 2);
        type(KeyCode.F, 6);
        type(KeyCode.A, 2);

        type(KeyCode.S, 7);
        type(KeyCode.D, 2);
        type(KeyCode.F, 6);
        type(KeyCode.A, 2);

        type(KeyCode.S, 7);
        type(KeyCode.D, 2);
        type(KeyCode.F, 6);
        type(KeyCode.A, 2);

        type(KeyCode.S, 7);
        type(KeyCode.D, 2);
        type(KeyCode.F, 6);
        type(KeyCode.A, 2);

        type(KeyCode.S, 7);
        type(KeyCode.D, 4);
    }

}
