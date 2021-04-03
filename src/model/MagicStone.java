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
        }
    }

    @Override
    public ImageView draw(int x, int y) {
        ImageView V = new ImageView();
        V.setImage(image);
        V.setX((x + 2) * 32);
        V.setY((y + 1.2) * 32);
        V.setFitHeight(30);
        V.setFitWidth(40);
        return V;
    }

    public Pane drawMagicStone(Pane root) {
        ImageView V = draw(7, 6);
        // set on Action
        V.setPickOnBounds(true);
        V.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("Congrat! You collect the Magic Stone!");
                click = true;
            }
        });

        if(!click)
            root.getChildren().add(V);
        return root;
    }

    public boolean isClick() {
        return this.click;
    }
}
