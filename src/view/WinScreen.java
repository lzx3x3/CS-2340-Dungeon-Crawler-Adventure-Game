package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Player;

public class WinScreen {
    private int width;
    private int height;
    private Button startOver;
    private Button exit;
    private Text visRooms;

    private WinScreen() { }

    public Button getStartOver() {
        return this.startOver;
    }

    public Button getExit() {
        return this.exit;
    }



    public WinScreen(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        exit = new Button("EXIT");
        startOver = new Button("STARTOVER");
        visRooms = new Text("Total Rooms Visited: " + player.getVisitedRooms().size());
    }

    public Scene getScene()  {
        StackPane root = new StackPane();
        Image background = new Image("file:resources/youWin.png");
        ImageView img = new ImageView(background);
        img.setFitWidth(800);
        img.setFitHeight(600);
        root.getChildren().add(img);
        visRooms.setFill(Color.WHITE);
        BorderPane winScreen = new BorderPane();

        // Title screen start button
        VBox buttons = new VBox(exit, startOver);
        VBox stats = new VBox(visRooms);
        buttons.setSpacing(10);
        startOver.getStyleClass().add("buttons");
        exit.getStyleClass().add("buttons");
        root.getChildren().add(winScreen);
        buttons.setAlignment(Pos.BOTTOM_RIGHT);
        stats.setAlignment(Pos.BOTTOM_CENTER);
        winScreen.setBottom(buttons);
        winScreen.setCenter(stats);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("file:resources/css/EndScreen.css");
        return scene;
    }
}
