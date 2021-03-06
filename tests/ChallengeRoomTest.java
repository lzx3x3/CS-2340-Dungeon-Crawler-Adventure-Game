import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.IMonster;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;

public class ChallengeRoomTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        controller = new Controller();
        controller.start(stage);
    }

    // Edited by Jason
    @Test
    public void testChallengeRoomAlert() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        Player player = controller.getPlayer();
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        verifyThat("OK", NodeMatchers.isNotNull());
    }

    @Test
    public void testChallengeRoomMonsters() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        Player player = controller.getPlayer();
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        clickOn("OK");
        verifyThat("health: 100", NodeMatchers.isNotNull());
    }

    // Edited by Siying
    @Test
    public void testChallengeRoomCancel() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        Player player = controller.getPlayer();
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        clickOn("Cancel");
        type(KeyCode.D, 1);
        type(KeyCode.A, 3);
        verifyThat("Current Room:31", NodeMatchers.isNotNull());
    }

    @Test
    public void testChallengeRoomOK() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        type(KeyCode.D, 7);
        Player player = controller.getPlayer();
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        clickOn("OK");
        type(KeyCode.D, 1);
        type(KeyCode.A, 3);
        verifyThat("Current Room:41", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testChallengeRoomMultipleMonsters() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        Player player = controller.getPlayer();
        type(KeyCode.D, 7);
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        clickOn("OK");
        ArrayList<IMonster> monsterArrayList =
                (ArrayList<IMonster>) controller.getPlayer().getCurrRoom().getMonsterArray();
        assertTrue(monsterArrayList.size() > 1);
    }

    //edited by Kayla
    @Test
    public void testChallengeRoomReward() {
        clickOn("Start");
        write("test");
        clickOn("Select your difficulty");
        clickOn("Medium");
        clickOn(".wpn2Button");
        clickOn("Start");
        Player player = controller.getPlayer();
        int originMoney = player.getMoney();
        type(KeyCode.D, 7);
        player.killMonster();
        type(KeyCode.D, 14);
        player.killMonster();
        type(KeyCode.D, 14);
        clickOn("OK");
        type(KeyCode.D, 1);
        assertEquals(30000, player.getMoney());
    }

}
