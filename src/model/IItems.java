package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface IItems {
    void use(Player player);
    Image getImage();
    ImageView draw(int x, int y);
}
