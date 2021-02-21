package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialGameScreen extends Application {

    private int screenWidth = 800;
    private int screenHeight = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root1 = new Pane();
        Pane root2 = new Pane();

        Scene scene1 = new Scene(root1, screenWidth, screenHeight);
        Scene scene2 = new Scene(root2, screenWidth, screenHeight);

        // add background
        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0,0,0,1)");
        root1.getChildren().add(background);

        // 1. add buttons
        Button exit1 = new Button("Go to initial configuration screen");
        Button exit2 = new Button("Go to welcome screen");
        Button door = new Button("Choose your rooms!");
        door.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
        // add listener to door
        door.setOnAction(e -> primaryStage.setScene(scene2));

        HBox buttons = new HBox(exit1, exit2, door);

        root1.getChildren().addAll(buttons);


        // 2. add Texts
        Text money = new Text("YOUR MONEY: ");
        money.setX(300);
        money.setY(200);
        money.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        money.setFill(Color.WHITE);
        root1.getChildren().add(money);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Initial_Game_Screen");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
