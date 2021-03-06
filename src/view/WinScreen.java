package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WinScreen {
    private int width;
    private int height;
    private Button startOver;
    private Button exit;

    private WinScreen() { }

    public Button getStartOver() {
        return this.startOver;
    }

    public Button getExit() {
        return this.exit;
    }



    public WinScreen(int width, int height) {
        this.width = width;
        this.height = height;
        exit = new Button("EXIT");
        startOver = new Button("STARTOVER");
    }

    public Scene getScene()  {
        StackPane root = new StackPane();
        Image background = new Image("file:resources/youWin.png");
        ImageView img = new ImageView(background);
        img.setFitWidth(800);
        img.setFitHeight(600);
        root.getChildren().add(img);

        BorderPane winScreen = new BorderPane();

        // Title screen start button
        VBox buttons = new VBox(exit, startOver);
        buttons.setSpacing(10);
        startOver.getStyleClass().add("buttons");
        exit.getStyleClass().add("buttons");
        root.getChildren().add(winScreen);
        buttons.setAlignment(Pos.BOTTOM_RIGHT);
        winScreen.setCenter(buttons);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("file:resources/css/EndScreen.css");
        return scene;
    }
}
