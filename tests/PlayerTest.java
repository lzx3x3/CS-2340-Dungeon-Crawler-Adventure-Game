import model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PlayerTest {

    // Edited by siying
    @Test
    public void testGetMoney() {
        Player player = new Player();
        player.setMoney("Easy");
        assertEquals(10000, player.getMoney());
    }

    // Edited by Pei Yi
    @Test
    public void testGetDiff() {
        Player player = new Player();
        player.setDiff("Medium");
        assertEquals("Medium", player.getDiff());
    }
}
