import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import view.InitialGame;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialGameTest extends ApplicationTest {

    private final InitialGame initGame = new InitialGame(500, 500);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(initGame.start(stage, new Player()));
        stage.show();
        stage.toFront();
    }

    //edited by Siying
    @Test
    public void testBack() {
        clickOn(".exit3");
        verifyThat("current Money", NodeMatchers.isNotNull());
    }
}
