package model;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop {
    private List<IItems> itemsList;

    public Shop() {
        this.itemsList = new ArrayList<>();
        itemsList.add(new MagicStone());
        itemsList.add(new HealthPotion());
        itemsList.add(new AttackPotion());
        itemsList.add(new Stick());
    }

    public Pane drawShop(Pane root) {
        for (IItems item:itemsList) {
            if (item instanceof MagicStone) {
                ImageView image = item.draw(6,8);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("A Magic Stone costs you 10000 money. Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            System.out.println("You get a Magic Stone!");

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
            else if (item instanceof HealthPotion) {
                ImageView image = item.draw(6,7);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("A HealthPotion costs you 2000 money. Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            System.out.println("You get a HealthPotion!");

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
            else if (item instanceof AttackPotion) {
                ImageView image = item.draw(6,6);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("An AttackPotion costs you 2000 money. Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            System.out.println("You get an AttackPotion!");

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
            else if (item instanceof Stick) {
                ImageView image = item.draw(7,6);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("A Stick costs you 5000 money. Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            System.out.println("You get a Stick!");

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
        }
        return root;
    }
}
