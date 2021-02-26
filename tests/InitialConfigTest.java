import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import view.InitialConfigScreen;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialConfigTest extends ApplicationTest {
    private final InitialConfigScreen initConfig = new InitialConfigScreen(500, 500);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(initConfig.getScene());
        stage.show();
        stage.toFront();
    }

    //edited by Pei Yi
    @Test
    public void testWeapon() {
//        BorderPane rootNode = initConfig.getBorderPane();
//        Button button = from(rootNode).lookup(".wpn1Button").query();
        clickOn(".wpn1Button");
        verifyThat("Weapon:  Stick", NodeMatchers.isNotNull());
    }
}