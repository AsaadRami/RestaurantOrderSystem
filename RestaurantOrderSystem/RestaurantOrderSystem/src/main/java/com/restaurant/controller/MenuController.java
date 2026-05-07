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

import java.util.List;
public class MenuController {
    @FXML private TableView<MenuItem>          menuTable;
    @FXML private TableColumn<MenuItem, String> nameColumn;
    @FXML private TableColumn<MenuItem, String> categoryColumn;
    @FXML private TableColumn<MenuItem, Double> priceColumn;
    @FXML private Label                         messageLabel;
    private static Order currentOrder;
    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));
        categoryColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCategory()));
        priceColumn.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        List<MenuItem> items = DataStore.getInstance().getMenuItems();
        menuTable.setItems(FXCollections.observableArrayList(items));
        currentOrder = new Order(DataStore.getInstance().getCurrentUser().getUsername());
        messageLabel.setText("اتفضل اختار الطفح");
    }
    public static Order getCurrentOrder() {
        return currentOrder;
    }
    @FXML
    private void handleAddToOrder() {
        MenuItem selected = menuTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("ماتخلصنا يعم");
            return;
        }
        currentOrder.addItem(selected);
        messageLabel.setText("Added: " + selected.getName() +
                " | Order total: " + String.format("%.1f", currentOrder.getTotalPrice()));
    }
    @FXML
    private void handleGoToOrder() {
        if (currentOrder.getItems().isEmpty()) {
            messageLabel.setText("يعم خلصنا بقااااااا");
            return;
        }
        SceneManager.switchScene("Order.fxml", "Your Order");
    }
    @FXML
    private void handleBack() {
        SceneManager.switchScene("Home.fxml", "Home - Restaurant Order System");
    }
}
