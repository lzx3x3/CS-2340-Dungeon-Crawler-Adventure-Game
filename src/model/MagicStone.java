package model;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

public class MagicStone implements IItems {
    private Image image;
    private boolean click;
    private ImageView imageView;

    public MagicStone() {
        this.image = new Image("file:resources/MagicStone.png");
        this.click = false;
    }

    @Override
    public void use(Player player) {
        Random r = new Random();
        double random = r.nextDouble();

        if(random <= 0.7) {
            //while use stone, there is 70% chance that kill a monster in the room (except for the final monster)
            List<IMonster> monsters = player.getCurrRoom().getMonsterArray();
            for (IMonster monster : monsters) {
                if (monster instanceof Monster1) {
                    Monster1 m1 = (Monster1) monster;
                    m1.setDead(true);
                }
                else if (monster instanceof Monster2) {
                    Monster2 m2 = (Monster2) monster;
                    m2.setDead(true);
                }
            }
        }
        else {  //while use stone, there is 30% chance that decrease the player's health by 30%
            player.setHealth(-player.getHealth()*3/10);
            player.setAttacked(true);
        }
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public ImageView draw(int x, int y) {
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX((x + 1.8) * 32);
        imageView.setY((y + 1.4) * 32);
        imageView.setFitHeight(25);
        imageView.setFitWidth(30);
        return imageView;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public Pane drawMagicStone(Pane root) {
        ImageView V = draw(7, 6);
        // set on Action
        V.setPickOnBounds(true);
        V.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!click) {
                    System.out.println("Congrat! You collect the Magic Stone!");
                    click = true;
                    root.getChildren().remove(V);   // remove magicStone when click!
                }
            }
        });

        if(!click)
            root.getChildren().add(V);
        return root;
    }

    public boolean isClick() {
        return this.click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }
}
