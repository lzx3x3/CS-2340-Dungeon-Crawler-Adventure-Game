package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import view.InitialGame;

public class Controller extends Application {

    private Player player;
    private final int width = 800;
    private final int height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
        player = new Player();
        initInitialGameScreen(primaryStage);
    }

    private void initInitialGameScreen(Stage primaryStage) {
        // player select difficulty
        player.setMoney(player.getDiff());
        System.out.println("Player Money: "+player.getMoney());

        InitialGame InitialGameScreen = new InitialGame(width, height);
        InitialGameScreen.start(primaryStage, player);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
