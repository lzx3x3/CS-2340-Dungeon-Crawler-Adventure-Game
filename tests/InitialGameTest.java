import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import view.InitialGame;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialGameTest extends ApplicationTest {

     private InitialGame initGame = new InitialGame(500, 500);
     private Player player = new Player();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(initGame.start(stage, player));
        stage.show();
    }

    //edited by Siying
    @Test
    public void testBack() {
        clickOn("#BACK");
        verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }
}
