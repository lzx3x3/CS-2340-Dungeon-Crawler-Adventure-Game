package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InitialConfig extends Application {

    private Player player = new Player();
    public Scene sceneConfig;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label screenTitle = new Label("Start a New Game");

        //enter name
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your name");
        nameInput.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
        Label nameLabel = new Label("Name:");
        nameLabel.setPrefWidth(200);

        //select your game difficulty
        ComboBox<String> diffSelect = new ComboBox<>();
        diffSelect.getItems().addAll("Easy", "Medium", "Hard");
        diffSelect.setPromptText("Select your difficulty");
        Label diffLabel = new Label("Difficulty:");
        diffSelect.setPrefWidth(300);
        // set player difficulty
        diffSelect.setOnAction(e -> {
            String diff = diffSelect.getValue().toString();
            player.setDiff(diff);
            //System.out.println("Difficulty:"+player.getDiff());
        });


        //player entries will be checked on button action
        //String playerName = nameInput.getCharacters().toString();
        //if (playerName == null || playerName.trim().isEmpty()) {
        //    Alert nameAlert = new Alert(Alert.AlertType.ERROR);
        //    nameAlert.setTitle("Error");
        //    nameAlert.setHeaderText("Invalid Name");
        //    nameAlert.setContentText("Your name must include at least one character");
        //    nameAlert.showAndWait();
        //    }

        //Name label and text field
        VBox name = new VBox();
        name.setAlignment(Pos.CENTER_LEFT);
        name.getChildren().addAll(nameLabel, nameInput);
        name.setSpacing(10);
        name.setPadding(new Insets(0, 50, 0, 50));

        // Button: Go to next screen (InitialGame)
        Button nextScreen = new Button("NEXT");
        nextScreen.setPrefWidth(300);

        nextScreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InitialGame game = new InitialGame();
                try {
                    game.start(primaryStage, player);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("Initial_Game_Screen");
            }
        });

        //Difficulty label and drop down menu
        VBox difficulty = new VBox();
        difficulty.setAlignment(Pos.CENTER_LEFT);
        difficulty.getChildren().addAll(diffLabel, diffSelect, nextScreen);
        difficulty.setSpacing(10);
        difficulty.setPadding(new Insets(0, 50, 0, 50));



        //Everything that will go in the center of the border pane is together aligned in this VBOX
        VBox selections = new VBox(name, difficulty);
        selections.setSpacing(20);

        //Border pane with all selections in the center, the title in the Top,
        // and the Start button can be in the bottom
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(screenTitle);
        borderPane.setAlignment(screenTitle, Pos.BOTTOM_CENTER);
        borderPane.setCenter(selections);
        borderPane.setAlignment(selections, Pos.CENTER);

        //The root will eventually be a stack pane so we can put everything on top of our background
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Start a New Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
