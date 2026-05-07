package com.restaurant.controller;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Order;
import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderController {
    @FXML private TableView<MenuItem>           orderTable;
    @FXML private TableColumn<MenuItem, String> itemNameColumn;
    @FXML private TableColumn<MenuItem, String> itemCategoryColumn;
    @FXML private TableColumn<MenuItem, Double> itemPriceColumn;
    @FXML private Label                         totalLabel;
    private Order order;
    @FXML
    public void initialize() {
        order = MenuController.getCurrentOrder();
        itemNameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));
        itemCategoryColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCategory()));
        itemPriceColumn.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().getPrice()).asObject());

        orderTable.setItems(FXCollections.observableArrayList(order.getItems()));
        totalLabel.setText("Total: " + String.format("%.2f", order.getTotalPrice()));
    }
    @FXML
    private void handlePlaceOrder() {
        DataStore.getInstance().saveOrder(order);
        Thread networkThread = new Thread(() -> {
            com.restaurant.network.OrderClient client = new com.restaurant.network.OrderClient();
            String response = client.sendOrder(order.toNetworkString());
            System.out.println("Server response: " + response);
        });
        networkThread.setDaemon(true);
        networkThread.start();
        SceneManager.switchScene("OrderConfirmation.fxml", "Order Confirmed!");
    }
    @FXML
    private void handleBack() {
        SceneManager.switchScene("Menu.fxml", "Menu - Restaurant Order System");
    }
}
