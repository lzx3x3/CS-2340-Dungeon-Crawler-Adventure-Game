package model;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;


public class Inventory extends Pane {
    private Player player;
    private TilePane slots;
    private int numItems;

    public Inventory(Player player) {
        this.player = player;
        create();
        getChildren().add(slots);
    }

    private TilePane create() {
        slots = new TilePane();
        slots.setPrefRows(3);
        slots.setPrefColumns(3);
        slots.setVgap(10);
        slots.setLayoutX(600);
        slots.setLayoutY(170);
        for (int i = 0; i < 9; i++) {
            slots.getChildren().add(new InventorySlot(null));
        }
        return slots;
    }

    public void add(IItems item) {
        if (numItems < 9) {
            slots.getChildren().set(numItems, new InventorySlot(item));
            numItems++;
        }
    }

    public int getNumItems() {
        return numItems;
    }
    private class InventorySlot extends StackPane {
        private IItems item;
        private final int width = 50;
        private final int height = 50;
        public InventorySlot(IItems item) {
            this.item = item;
            Rectangle slot = new Rectangle(width, height);
            slot.setStroke(Color.WHITE);
            getChildren().add(slot);
            if (item != null) {
                ImageView itemImage = new ImageView(item.getImage());
                itemImage.setFitHeight(width);
                itemImage.setFitWidth(height);
                getChildren().add(itemImage);
                Button removeButton = new Button();
                removeButton.setOpacity(0);
                removeButton.setMaxSize(width, height);
                removeButton.setOnAction(e -> {
                    remove();
                    System.out.println("You are using item!");
                    // item.use(player);
                });
                getChildren().add(removeButton);
            }
        }

        public void remove() {
            item.use(player);
            if (item instanceof Weapon) {
                return;
            } else {
                slots.getChildren().remove(this);
                slots.getChildren().add(new InventorySlot(null));
                numItems--;
            }
        }
    }
}
