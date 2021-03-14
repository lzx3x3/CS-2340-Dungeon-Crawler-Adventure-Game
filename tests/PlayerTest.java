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
}
