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
        stone = new MagicStone();
    }

    public MagicStone getMagicStone() {
        return this.stone;
    }

    public Pane drawChest(Pane root) {
        // change the state of chest
        if(this.state == 1) {
//            if(stone.isClick()) {
//                this.state = 2;
//            }
            this.image = new Image("file:resources/chest_opened.png");
            //stone.drawMagicStone(root);
        }
        if(this.state == 2) {
            this.image = new Image("file:resources/chest_empty.png");
        }

        ImageView Vi = new ImageView();
        Vi.setImage(image);
        Vi.setX((9 + 1.8) * 32);
        Vi.setY((7 + 1.5) * 32);
        Vi.setFitHeight(30);
        Vi.setFitWidth(30);
        root.getChildren().add(Vi);

        return root;
    }

    public void setChestState(int s) {
        this.state = s;
    }

    public int getChestState() {
        return this.state;
    }
}
