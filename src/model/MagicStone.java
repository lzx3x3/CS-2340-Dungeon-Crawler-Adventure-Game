package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

public class MagicStone implements IItems {
    private Image image;
    private ImageView imageView;
    private int x;
    private int y;

    public MagicStone(int x, int y) {
        this.image = new Image("file:resources/MagicStone.png");
        this.x = x;
        this.y = y;
    }

    @Override
    public void use(Player player) {
        Random r = new Random();
        double random = r.nextDouble();
        int i = 0;

        if (random <= 0.7) {
            //while use stone, there is 70% chance that kill a monster in the room
            // (except for the final monster)
//            List<IMonster> monsters = player.getCurrRoom().getMonsterArray();
//            for (IMonster monster : monsters) {
//                if (monster instanceof Monster1) {
//                    Monster1 m1 = (Monster1) monster;
//                    m1.setHealth(0);
//                } else if (monster instanceof Monster2) {
//                    Monster2 m2 = (Monster2) monster;
//                    m2.setHealth(0);
//                }
//            }
            List<IMonster> monsters = player.getCurrRoom().getMonsterArray();
            IMonster monster = monsters.get(i);
            if (monster instanceof Monster1) {
                Monster1 m1 = (Monster1) monster;
                m1.setHealth(0);
            } else if (monster instanceof Monster2) {
                Monster2 m2 = (Monster2) monster;
                m2.setHealth(0);
            }
            i++;
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
    public ImageView draw() {
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX((x + 1.6) * 32);
        imageView.setY((y + 1.0) * 32);
        imageView.setFitHeight(25);
        imageView.setFitWidth(30);
        return imageView;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public Pane drawMagicStone(Pane root) {
        root.getChildren().add(draw());
        return root;
    }

    public Pane removeMagicStone(Pane root) {
        root.getChildren().remove(draw());
        return root;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
