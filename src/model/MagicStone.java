package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

public class MagicStone implements IItems {
    private Image image;
    private ImageView imageView;

    public MagicStone() {
        this.image = new Image("file:resources/MagicStone.png");
    }

    @Override
    public void use(Player player) {
        Random r = new Random();
        double random = r.nextDouble();

        if (random <= 0.7) {
            //while use stone, there is 70% chance that kill a monster in the room
            // (except for the final monster)
            List<IMonster> monsters = player.getCurrRoom().getMonsterArray();
            for (IMonster monster : monsters) {
                if (monster instanceof Monster1) {
                    Monster1 m1 = (Monster1) monster;
                    m1.setHealth(0);
                } else if (monster instanceof Monster2) {
                    Monster2 m2 = (Monster2) monster;
                    m2.setHealth(0);
                }
            }
        } else {  //while use stone, there is 30% chance that decrease the player's health by 50%
            player.setHealth(-player.getHealth() / 2);
            player.setAttacked(true);
        }
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public ImageView draw(int x, int y) {
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX((x + 1.8) * 32);
        imageView.setY((y + 1.0) * 32);
        imageView.setFitHeight(25);
        imageView.setFitWidth(30);
        return imageView;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public Pane drawMagicStone(Pane root) {
        root.getChildren().add(draw(7, 7));
        return root;
    }

    public Pane removeMagicStone(Pane root) {
        root.getChildren().remove(draw(7, 7));
        return root;
    }
}
