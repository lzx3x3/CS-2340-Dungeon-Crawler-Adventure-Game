package main;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class InitialGame {

    public Scene sceneInitGame;
    private int screenWidth = 800;
    private int screenHeight = 600;

    public Scene InitialGameScreen(Stage primaryStage, Player player) throws Exception {

        // player select difficulty
        player.setMoney(player.getDiff());
        //System.out.println("Player Money: "+player.getMoney());

        Pane root1 = new Pane();
        Pane root2 = new Pane();
        Room room0 = new Room(0, 15,15);
        Pane roomPane = room0.drawRoom(root2, player);
        Scene scene1 = new Scene(root1, screenWidth, screenHeight);
        Scene scene2 = new Scene(roomPane, screenWidth, screenHeight);

        // add background
        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0,0,0,1)");
        root1.getChildren().add(background);

        // 1-(1). add buttons to scene 1
        Button exit1 = new Button("Go back to initial configuration screen");
//        Button exit2 = new Button("Go back to welcome screen");
        Button door = new Button("Choose your rooms!");
        door.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");

        exit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InitialConfig config = new InitialConfig();
                try {
                    config.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("Initial_Config_Screen");
            }
        });

        // change screen "scene1" - > "scene2" via button "door"
        door.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
                primaryStage.setTitle("Choose_Rooms");
            }
        });

        HBox buttons = new HBox(exit1, door);

        root1.getChildren().addAll(buttons);

        // 1-(2). add buttons to scene 2
        Button exit3 = new Button("X");
        // change screen "scene2" - > "scene1" via button "X"
        exit3.setOnAction(new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent actionEvent) {
                                  primaryStage.setScene(scene1);
                                  primaryStage.setTitle("Initial_Game_Screen");
                              }
                          });

        roomPane.getChildren().add(exit3);


        // 2. add Texts
        Text money = new Text();
        // money varies based on difficulty chosen
        money.textProperty().bind(new SimpleStringProperty(("Your Initial Money: ")).concat(new SimpleIntegerProperty(player.getMoney()).asString()));

        money.setX(250);
        money.setY(200);
        money.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        money.setFill(Color.WHITE);

        Text level = new Text();
        // show current player level
        level.textProperty().bind(new SimpleStringProperty(("Your Level: ")).concat(new SimpleIntegerProperty(player.getLevel()).asString()));

        level.setX(320);
        level.setY(300);
        level.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        level.setFill(Color.YELLOW);

        root1.getChildren().addAll(money, level);
        return scene1;

//        primaryStage.setScene(scene1);
//        primaryStage.setTitle("Initial_Game_Screen");
//        primaryStage.show();

    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
