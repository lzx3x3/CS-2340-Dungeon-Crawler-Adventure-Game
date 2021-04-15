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

public class LoseScreen {
    private int width;
    private int height;
    private Button restart;
    private Button exit;
    private Text visRooms;
    private Text damageDealt;

    private LoseScreen() { }

    public Button getStartOver() {
        return this.restart;
    }

    public Button getExit() {
        return this.exit;
    }



    public LoseScreen(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        exit = new Button("EXIT");
        ImageView image = new ImageView();
        image.setImage(new Image("file:resources/player.png"));
        restart = new Button("Try Again!", image);
        visRooms = new Text("Total Rooms Visited: " + player.getVisitedRooms().size());
        damageDealt = new Text("Total Damage Dealt: " + player.getDamageDealt());
    }

    public Scene getScene()  {
        StackPane root = new StackPane();
        Image background = new Image("file:resources/youLose.png");
        ImageView img = new ImageView(background);
        img.setFitWidth(800);
        img.setFitHeight(600);
        root.getChildren().add(img);
        visRooms.setFill(Color.WHITE);
        damageDealt.setFill(Color.WHITE);
        BorderPane loseScreen = new BorderPane();

        // Add restart and exit buttons
        ImageView image = new ImageView();

        VBox buttons = new VBox(restart, exit, visRooms, damageDealt);
        buttons.setSpacing(10);
        restart.getStyleClass().add("buttons");
        exit.getStyleClass().add("buttons");
        root.getChildren().add(loseScreen);
        buttons.setAlignment(Pos.CENTER);
        loseScreen.setCenter(buttons);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("file:resources/css/EndScreen.css");

        return scene;
    }

    public Button getRestart() {
        return this.restart;
    }
}
