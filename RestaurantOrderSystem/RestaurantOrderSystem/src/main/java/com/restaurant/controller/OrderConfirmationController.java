package com.restaurant.controller;

import com.restaurant.model.Order;
import com.restaurant.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderConfirmationController {

    @FXML private Label confirmLabel;
    @FXML private Label orderDetailsLabel;

    @FXML
    public void initialize() {
        Order order = MenuController.getCurrentOrder();
        confirmLabel.setText("Order #" + order.getOrderId() + " placed successfully!");
        orderDetailsLabel.setText(
                "Items: " + order.getItems().size() +
                "  |  Total: " + String.format("%.2f", order.getTotalPrice()) +
                "\nStatus: " + order.getStatus() +
                "\nOrder sent to server."
        );
    }
    @FXML
    private void handleGoToHistory() {
        SceneManager.switchScene("OrderHistory.fxml", "Order History");
    }
    @FXML
    private void handleGoHome() {
        SceneManager.switchScene("Home.fxml", "Home - Restaurant Order System");
    }
}
