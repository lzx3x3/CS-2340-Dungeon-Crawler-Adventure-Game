import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import view.InitialConfigScreen;

import static org.testfx.api.FxAssert.verifyThat;

public class InitialConfigTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        JFXPanel fxPanel = new JFXPanel(); //work around for JavaFX Toolkit Not Initialized exception
        InitialConfigScreen initConfig = new InitialConfigScreen(500, 500);
        stage.setScene(initConfig.getScene());
        stage.show();
    }

    //edited by Pei Yi
    @Test
    public void testWeapon() {
        clickOn(".wpn1Button");
        verifyThat("Weapon:  Stick", NodeMatchers.isNotNull());
    }
}