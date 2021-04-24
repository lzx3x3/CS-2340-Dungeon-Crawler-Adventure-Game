import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.MagicStone;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ItemTest extends ApplicationTest {

    private Controller controller = new Controller();
    private Player player = new Player();
    @Override
    public void start(Stage stage) throws Exception {
        controller.setMainWindow(stage);
        controller.initInitialGameScreen(player);
    }

    // Edited by Siying
    @Test
    public void testMagicStoneUse() {
        type(KeyCode.S, 7);
        type(KeyCode.S, 6);
        MagicStone stone = new MagicStone(9, 7);
        stone.use(player);
        assertEquals(true, player.checkMonstersDead());
    }

}
