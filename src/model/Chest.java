package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Chest {
    private Image image;
    private int state;
    private MagicStone stone;

    public Chest() {
        this.image = new Image("file:resources/chest_closed.png");
        this.state = 0;
        stone = new MagicStone(7, 7);
    }

    public MagicStone getMagicStone() {
        return this.stone;
    }

    public Pane drawChest(Pane root) {
        // change the state of chest
        if (this.state == 1) {
            root = stone.drawMagicStone(root);
            this.image = new Image("file:resources/chest_opened.png");
        }
        if (this.state == 2) {
            root = stone.removeMagicStone(root);
            this.image = new Image("file:resources/chest_empty.png");
        }

        ImageView vi = new ImageView();
        vi.setImage(image);
        vi.setX((7 + 1.8) * 32);
        vi.setY((7 + 1.5) * 32);
        vi.setFitHeight(30);
        vi.setFitWidth(30);
        root.getChildren().add(vi);

        return root;
    }

    public void setChestState(int s) {
        this.state = s;
    }

    public int getChestState() {
        return this.state;
    }
}
