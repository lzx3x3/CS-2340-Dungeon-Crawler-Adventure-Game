import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Deadend3;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PlayerTest extends ApplicationTest {
    private Controller controller = new Controller();
    private Player player = new Player();
    @Override
    public void start(Stage stage) throws Exception {
        //Controller controller = new Controller();
        controller.start(stage);
    }

    // Edited by siying
    @Test
    public void testGetMoney() {
        Player player = new Player();
        player.setMoney("Easy");
        assertEquals(30000, player.getMoney());
    }

    // Edited by Pei Yi
    @Test
    public void testGetDiff() {
        Player player = new Player();
        player.setDiff("Medium");
        assertEquals("Medium", player.getDiff());
    }

    @Test
    public void testItemPickup() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.D, 15);
        type(KeyCode.F, 10);
        type(KeyCode.D, 1);
        assertTrue(controller.getPlayer().getCurrRoom().getItemArray().isEmpty());
    }

    // Edited by Siying
    @Test
    public void testChestOpen() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        type(KeyCode.S, 7);

        type(KeyCode.S, 7);
        type(KeyCode.D, 1);
        type(KeyCode.F, 10);
        type(KeyCode.A, 1);
        type(KeyCode.S, 7);

        type(KeyCode.S, 7);
        type(KeyCode.D, 1);
        type(KeyCode.F, 10);
        type(KeyCode.A, 1);
        type(KeyCode.S, 7);

        type(KeyCode.S, 7);
        type(KeyCode.D, 1);
        type(KeyCode.F, 10);
        type(KeyCode.A, 1);
        type(KeyCode.S, 7);

        type(KeyCode.S, 7);
        type(KeyCode.D, 1);
        type(KeyCode.F, 10);
        type(KeyCode.A, 1);
        type(KeyCode.S, 7);

        type(KeyCode.S, 7);
        type(KeyCode.D, 3);

        Deadend3 room = (Deadend3)controller.getPlayer().getCurrRoom();
        assertEquals(1, room.getChest().getChestState());   // test if chest is open when player walks close to it
        assertTrue(!room.getItemArray().isEmpty());
    }
}
