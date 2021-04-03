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

    public Pane drawChest(Pane root) {
        // change the state of chest

        if(this.state == 1) {
            if(stone.isClick()) {
                //System.out.println("Change chest state to empty!");
                this.state = 2;
                //drawChest(root);
            }
            this.image = new Image("file:resources/chest_opened.png");
            stone.drawMagicStone(root);
        }
        if(this.state == 2) {
            this.image = new Image("file:resources/chest_empty.png");
        }

        ImageView Vi = new ImageView();
        Vi.setImage(image);
        Vi.setX((7 + 2) * 32);
        Vi.setY((7 + 1.5) * 32);
        Vi.setFitHeight(30);
        Vi.setFitWidth(30);
        root.getChildren().add(Vi);

        return root;
    }

    public void setChestState(int s) {
        this.state = s;
    }
}
