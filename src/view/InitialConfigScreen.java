package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;

public class InitialConfigScreen {
    private int width;
    private int height;
    private TextField nameInput;
    private ComboBox<String> diffSelect;
    private Button wpn1Button;
    private Button wpn2Button;
    private Button wpn3Button;
    private Button startButton;
    private BorderPane borderPane;
    private Alert nameAlert;
    private Alert diffAlert;

    /**
     * Private constructor
     */
    private InitialConfigScreen() { }

    /**
     * Public constructor
     * @param width scene width
     * @param height scene height
     */
    public InitialConfigScreen(int width, int height) {
        this.width = width;
        this.height = height;
        nameInput = new TextField();
        diffSelect = new ComboBox<>();
        wpn1Button = new Button();
        wpn2Button = new Button();
        wpn3Button = new Button();
        startButton = new Button("Start");
        nameAlert = new Alert(Alert.AlertType.ERROR);
        diffAlert = new Alert(Alert.AlertType.ERROR);
    }

    /**
     * Returns initial configuration scene
     * @return Initial configuration scene
     */
    public Scene getScene() {
        Label screenTitle = new Label("Start a New Game");
        screenTitle.getStyleClass().add("statusText");

        //enter name
        nameInput.setPromptText("Enter your name");
        nameInput.getStyleClass().add("nameInputText");
        Label nameLabel = new Label("Name:");
        nameLabel.getStyleClass().add("label");

        //select your game difficulty
        diffSelect.getItems().addAll("Easy", "Medium", "Hard");
        diffSelect.setPromptText("Select your difficulty");
        Label diffLabel = new Label("Difficulty:");
        diffSelect.getStyleClass().add("diffSelectBox");

        //select weapon
        wpn1Button.getStyleClass().add("wpn1Button");
        wpn1Button.setId("wpn");
        wpn2Button.getStyleClass().add("wpn2Button");
        wpn3Button.getStyleClass().add("wpn3Button");

        HBox wpnButtons = new HBox(wpn1Button, wpn2Button, wpn3Button);
        wpnButtons.getStyleClass().add("wpnHBox");
        Label wpnLabel = new Label("Weapon:  None");
        wpnLabel.getStyleClass().add("wpnLabel");

        //show text when weapon is selected
        wpn1Button.setOnAction(e -> {
            wpnLabel.setText("Weapon:  Stick");
            Label label = new Label("Weapon 1 selected!");
        });
        wpn2Button.setOnAction(e -> {
            wpnLabel.setText("Weapon:  Sword");
        });
        wpn3Button.setOnAction(e -> {
            wpnLabel.setText("Weapon:  Bow");
        });

        //start game
        startButton.getStyleClass().add("startButton");

        //inner VBoxes
        VBox name = new VBox();
        name.getChildren().addAll(nameLabel, nameInput);
        name.getStyleClass().add("innerVBox");

        VBox difficulty = new VBox();
        difficulty.getChildren().addAll(diffLabel, diffSelect);
        difficulty.getStyleClass().add("innerVBox");

        VBox wpn = new VBox();
        wpn.getChildren().addAll(wpnLabel, wpnButtons);
        wpn.getStyleClass().add("innerVBox");

        //Everything is together aligned in this VBOX
        VBox selections = new VBox(screenTitle, name, difficulty, wpn, startButton);
        selections.getStyleClass().add("outerVBox");
        //Use an HBox to center align
        HBox selectionsWrapper = new HBox(selections);
        selectionsWrapper.getStyleClass().add("outerHBox");

        borderPane = new BorderPane(selectionsWrapper);
        borderPane.setId("pane");
        Scene scene = new Scene(borderPane, width, height);
        scene.getStylesheets().add("file:resources/css/InitialConfigScreen.css");
        return scene;
    }

    /**
     * Returns name input field
     * @return Name input field
     */
    public TextField getNameInput() {
        return nameInput;
    }

    /**
     *
     * @return Difficulty select combo box
     */
    public ComboBox<String> getDiffSelect() {
        return diffSelect;
    }

    /**
     *
     * @return Start button
     */
    public Button getStartButton() {
        return startButton;
    }

    /**
     *
     * @return Invalid name alert
     */
    public Alert getNameAlert() {
        return nameAlert;
    }

    /**
     *
     * @return Invalid difficulty alert
     */
    public Alert getDiffAlert() {
        return diffAlert;
    }

    /**
     *
     * @return Border pane
     */
    public BorderPane getBorderPane() {
        return borderPane;
    }
}
