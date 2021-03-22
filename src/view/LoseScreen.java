package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoseScreen {
    private int width;
    private int height;
    private Button restart;
    private Button exit;

    private LoseScreen() { }

    public Button getStartOver() {
        return this.restart;
    }

    public Button getExit() {
        return this.exit;
    }



    public LoseScreen(int width, int height) {
        this.width = width;
        this.height = height;
        exit = new Button("EXIT");
        ImageView image = new ImageView();
        image.setImage(new Image("file:resources/player.png"));
        restart = new Button("Try Again!", image);
        restart = new Button("Try Again");

    }

    public Scene getScene()  {
        StackPane root = new StackPane();
        Image background = new Image("file:resources/youWin.png");
        ImageView img = new ImageView(background);
        img.setFitWidth(800);
        img.setFitHeight(600);
        root.getChildren().add(img);

        BorderPane winScreen = new BorderPane();

        // Add restart and exit buttons
        restart.setLayoutX(250);
        restart.setLayoutY(250);
        VBox buttons = new VBox(exit);
        buttons.setSpacing(10);
        restart.getStyleClass().add("buttons");
        exit.getStyleClass().add("buttons");
        root.getChildren().add(winScreen);
        buttons.setAlignment(Pos.BOTTOM_RIGHT);
        winScreen.setCenter(buttons);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("file:resources/css/EndScreen.css");

        return scene;
    }

    public Button getRestart() {
        return this.restart;
    }
}
