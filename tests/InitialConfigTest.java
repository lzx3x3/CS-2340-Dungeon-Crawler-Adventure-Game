import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import view.InitialConfigScreen;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialConfigTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        JFXPanel fxPanel = new JFXPanel(); //work around for JavaFX ToolkitNotInitialized exception
        InitialConfigScreen initConfig = new InitialConfigScreen(500, 500);
        stage.setScene(initConfig.getScene());
        stage.show();

    }

    //edited by Pei Yi
    @Test
    public void testWeapon() {
        clickOn(".wpn1Button");
        verifyThat("Stick", NodeMatchers.isNotNull());
    }

    //edited by Kayla
    @Test
    public void testWeapon2() {
        clickOn(".wpn2Button");
        verifyThat("Sword", NodeMatchers.isNotNull());
    }


}