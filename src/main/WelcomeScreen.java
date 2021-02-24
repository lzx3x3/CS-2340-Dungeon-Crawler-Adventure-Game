package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WelcomeScreen {

    public void start(Stage stage)  {
        StackPane root = new StackPane();
        Image background = new Image("file:assets/WelcomeScreenImage.png");
        root.getChildren().add(new ImageView(background));
        BorderPane welcomeScreen = new BorderPane();
        // Title screen Title text
        Label gameTitle = new Label("Dungeon Crawler Game");
        gameTitle.setAlignment(Pos.CENTER);
        Font titleFont = Font.loadFont("file:assets/fonts/BreatheFireIi-2z9W.ttf", 70);
        gameTitle.setStyle("-fx-text-fill: white; -fx-stroke: black;");
        gameTitle.setFont(titleFont);
        // Title screen start button
        welcomeScreen.setTop(gameTitle);
        welcomeScreen.setAlignment(gameTitle, Pos.CENTER);
        welcomeScreen.setMargin(gameTitle, new Insets(50, 10, 10, 10));
        VBox buttons = new VBox();
        buttons.setSpacing(20);
        Button start = new Button("Start");
        //start.setOnAction(stage.setScene(initialConfigScreen));
        start.setStyle(" -fx-background-color: \n" +
                "        #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");
        Button quit = new Button("Quit");
        quit.setOnAction(e -> {
            stage.close();
        });
        quit.setStyle("-fx-background-color: \n" +
                "        #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");
        root.getChildren().add(welcomeScreen);
        buttons.getChildren().addAll(start, quit);
        buttons.setAlignment(Pos.CENTER);
        welcomeScreen.setCenter(buttons);
        Scene scene = new Scene(root, 800, 575);
        stage.setTitle("Dungeon Crawler Game");
        stage.setScene(scene);
    }
}