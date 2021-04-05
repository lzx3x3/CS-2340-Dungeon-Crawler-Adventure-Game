package model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Inventory extends Pane {
    Player player;
    TilePane slots;
    public Inventory(Player player) {
        this.player = player;
        slots = create();
        getChildren().add(slots);
    }

    private TilePane create() {
        slots = new TilePane();
        slots.setPrefRows(3);
        slots.setPrefColumns(3);
        slots.setVgap(10);
        slots.setLayoutX(650);
        slots.setLayoutY(200);
        slots.getChildren().add(new InventorySlot());
        return slots;
    }

    public void add() {
        slots.getChildren().add(new InventorySlot());
    }

    private class InventorySlot extends StackPane {
        public InventorySlot() {
            Rectangle slot = new Rectangle(10, 10);
            slot.setStroke(Color.GRAY);
            getChildren().add(slot);
        }
    }
}
