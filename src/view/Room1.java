package view;

import model.Tile;


public class Room1 {
    private int height = 0;
    private int width = 0;
    private Tile[][] tileLayout;
    // with the current implementation it has to be a factor of both height and width
    private final int tileSize = 20;

    /**
     * Public constructor to set the scene
     * @param height height of the screen
     * @param width width of the screen
     */
    public Room1(int height, int width) {
        this.height = height;   //600
        this.width = width;     //800
        tileLayout = new Tile[height / tileSize][width / tileSize];
        // floor
        for (int i = 0; i < height / tileSize; i++) {
            for (int j = 0; j < width / tileSize; j++) {
                // Each tile instance has a position and a type
                Tile tileInstance = new Tile(j * tileSize, i * tileSize, "Wooden Floor");
                tileLayout[i][j] = tileInstance;
            }
        }

        // left door
        for (int i = 0; i < 3; i++) {
            Tile tileInstance = new Tile(0, (height / (tileSize * 2) - i) * tileSize, "Door");
            tileLayout[(height / (tileSize * 2) - i)][0] = tileInstance;
        }

        // right door
        for (int i = 0; i < 3; i++) {
            Tile tileInstance = new Tile((width / tileSize - 1) * tileSize,
                    (height / (tileSize * 2) - i) * tileSize, "Door");
            tileLayout[(height / (tileSize * 2) - i)][width / tileSize - 1] = tileInstance;
        }

        // top door
        for (int j = 0; j < 3; j++) {
            Tile tileInstance = new Tile((width / (tileSize * 2) - j + 1) * tileSize, 0, "Door");
            tileLayout[0][(width / (tileSize * 2) - j + 1)] = tileInstance;
        }

        // bottom door
        for (int j = 0; j < 3; j++) {
            Tile tileInstance = new Tile((width / (tileSize * 2) - j + 1) * tileSize,
                    (height / tileSize - 1) * tileSize, "Door");
            tileLayout[height / tileSize - 1][(width / (tileSize * 2) - j + 1)] = tileInstance;
        }

        // obstacles
    }

    /**
     * Returns the room scene drawn from the tile layout
     * @return scene
     */
    //    public Scene getScene(Player player) {
    //        Pane pane = new Pane();
    //        for (int i = 0; i < height / tileSize; i++) {
    //            for (int j = 0; j < width / tileSize; j++) {
    //                Tile tile = tileLayout[i][j];
    //                ImageView tileImgview = tile.getImageView(0);
    //                if (tile.getType() == "Wooden Floor") {
    //                    tileImgview = tile.getImageView(0);
    //                } else if (tile.getType() == "Door") {
    //                    tileImgview = tile.getImageView(1);
    //                } else if (tile.getType() == "Obstacle") {
    //                    tileImgview = tile.getImageView(2);
    //                }
    //                tileImgview.setX(tile.getX());
    //                tileImgview.setY(tile.getY());
    //                pane.getChildren().add(tileImgview);
    //            }
    //        }
    //
    //        // player info
    //        Text money = new Text();
    //        money.textProperty().bind(new SimpleStringProperty(("Current Money: ")).concat(
    //                new SimpleIntegerProperty(player.getMoney()).asString()));
    //        money.setX(width - 200);
    //        money.setY(20);
    //        money.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
    //        money.setFill(Color.DARKBLUE);
    ////        money.getStyleClass().add("playerInfo");
    //
    //        Text diff = new Text();
    //        diff.textProperty().bind(new SimpleStringProperty(("Current Difficulty: ")).concat(
    //                new SimpleStringProperty(player.getDiff())));
    //        diff.setX(width - 200);
    //        diff.setY(40);
    //        diff.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
    //        diff.setFill(Color.DARKBLUE);
    ////        diff.getStyleClass().add("playerInfo");
    //
    //        Text level = new Text();
    //        level.textProperty().bind(new SimpleStringProperty(("Current Level: ")).concat(
    //                new SimpleIntegerProperty(player.getLevel()).asString()));
    //        level.setX(width - 200);
    //        level.setY(60);
    //        level.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
    //        level.setFill(Color.DARKBLUE);
    ////        level.getStyleClass().add("playerInfo");
    //
    //
    //        pane.getChildren().addAll(money, diff, level);
    //        Scene scene = new Scene(pane, width, height);
    ////        scene.getStylesheets().add("file:resources/css/Room.css");
    //        return scene;
    //    }

    /**
     * Returns the tile layout array, each element is a Tile obj
     * @return the tile layout array
     */
    public Tile[][] getTileLayout() {
        return tileLayout;
    }
}
