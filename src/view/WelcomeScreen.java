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


public class WelcomeScreen {
    private int width;
    private int height;
    private Button start;
    private Button quit;
    private WelcomeScreen() { }

    public Button getStart() {
        return start;
    }

    public Button getQuit() {
        return quit;
    }



    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;
        quit = new Button("Quit");
        start = new Button("Start");
    }

    public Scene getScene()  {
        StackPane root = new StackPane();
        Image background = new Image("file:resources/WelcomeScreenImage.png");
        ImageView backgroundImageView = new ImageView(background);
        backgroundImageView.setFitWidth(width);
        backgroundImageView.setFitHeight(height);
        root.getChildren().add(backgroundImageView);
        BorderPane welcomeScreen = new BorderPane();
        // Title screen Title text
        Label gameTitle = new Label("Dungeon Crawler Game");
        gameTitle.setAlignment(Pos.CENTER);
        Font titleFont = Font.loadFont("file:resources/fonts/BreatheFireIi-2z9W.ttf", 70);
        gameTitle.setStyle("-fx-text-fill: white; -fx-stroke: black;");
        gameTitle.setFont(titleFont);
        // Title screen start button
        welcomeScreen.setTop(gameTitle);
        welcomeScreen.setAlignment(gameTitle, Pos.CENTER);
        welcomeScreen.setMargin(gameTitle, new Insets(50, 10, 10, 10));
        VBox buttons = new VBox(start, quit);
        buttons.setSpacing(20);
        start.getStyleClass().add("buttons");
        quit.getStyleClass().add("buttons");
        root.getChildren().add(welcomeScreen);
        buttons.setAlignment(Pos.CENTER);
        welcomeScreen.setCenter(buttons);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("file:resources/css/WelcomeScreen.css");
        return scene;
    }
}