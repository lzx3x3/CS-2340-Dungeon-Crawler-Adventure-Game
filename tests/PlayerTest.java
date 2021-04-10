import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.HealthPotion;
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

    @Test
    public void testAttackPotionTemporary() {
        clickOn("Start");
        write("Test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        controller.getPlayer().setUseAttack(true);
        controller.getPlayer().setDamage(30);
        type(KeyCode.D, 15);
        type(KeyCode.F, 10);
        assertEquals(20, controller.getPlayer().getDamage());
    }

    @Test
    public void testHealthPotion() {
        clickOn("Start");
        write("Test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn1Button");
        clickOn("Start");
        HealthPotion healthpotion = new HealthPotion();
        healthpotion.use(controller.getPlayer());
        assertEquals(270, controller.getPlayer().getHealth());
    }
}
