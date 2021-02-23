import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class InitialConfig extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        //enter name, select game difficulty
        TextField nameInput = new TextField();
        Label nameLabel = new Label("Enter your name: ");

        ComboBox<String> difficulty = new ComboBox<>();
        difficulty.getItems().addAll("Easy", "Medium", "Hard");
        difficulty.getSelectionModel().selectLast();
        difficulty.getSelectionModel().selectFirst();
        Label diffLabel = new Label("Choose your difficulty level:");


        //player entries will be checked on button action
//        String playerName = nameInput.getCharacters().toString();
//        if (playerName == null || playerName.trim().isEmpty()) {
//            Alert nameAlert = new Alert(Alert.AlertType.ERROR);
//            nameAlert.setTitle("Error");
//            nameAlert.setHeaderText("Invalid Name");
//            nameAlert.setContentText("Your name must include at least one character");
//            nameAlert.showAndWait();
//        }

        HBox name = new HBox();
        name.setAlignment(Pos.CENTER);
        name.getChildren().addAll(nameLabel, nameInput);
        name.setSpacing(10);

        HBox diff = new HBox();
        diff.setAlignment(Pos.CENTER);
        diff.getChildren().addAll(diffLabel, difficulty);
        diff.setSpacing(10);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(name, diff);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Initial Config Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
