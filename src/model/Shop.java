package model;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;


import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<IItems> itemsList;

    public Shop() {
        this.itemsList = new ArrayList<>();
        itemsList.add(new MagicStone(9, 7));
        itemsList.add(new HealthPotion(9, 7));
        itemsList.add(new AttackPotion(9, 7));
        itemsList.add(new Stick(9, 7));
    }

    public boolean checkMoney(Player player, int cost) {
        if (player.getMoney() - cost >= 0) {
            player.changeMoney(cost);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("You couldn't afford this item! Please cancel this transaction.");
            a.show();
            return false;
        }
        return true;
    }

    public Pane drawShop(Pane root, Player player) {

        /*for (IItems item:itemsList) {
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
                        alert.setContentText("A Magic Stone costs you 10000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 10000)) {
                                //player.getCurrRoom().drawRoom(root, player);
                                System.out.println("You get a Magic Stone!");
                            }
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
                        alert.setContentText("A HealthPotion costs you 2000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 2000)) {
                                System.out.println("You get a HealthPotion!");
                                //player.getCurrRoom().drawRoom(root, player);
                            }
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
                        alert.setContentText("An AttackPotion costs you 2000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 2000)) {
                                System.out.println("You get an AttackPotion!");
                                //player.getCurrRoom().drawRoom(root, player);
                            }

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
                        alert.setContentText("A Stick costs you 5000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 5000)) {
                                System.out.println("You get a Stick!");
                                //player.getCurrRoom().drawRoom(root, player);
                            }

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
        }*/
        return root;


    }

}
