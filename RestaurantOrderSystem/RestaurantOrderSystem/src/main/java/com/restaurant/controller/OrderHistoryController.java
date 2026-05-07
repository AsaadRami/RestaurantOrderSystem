package com.restaurant.controller;

import com.restaurant.model.Order;
import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
public class OrderHistoryController {
    @FXML private TableView<Order>              historyTable;
    @FXML private TableColumn<Order, Integer>   idColumn;
    @FXML private TableColumn<Order, String>    timeColumn;
    @FXML private TableColumn<Order, Double>    totalColumn;
    @FXML private TableColumn<Order, String>    statusColumn;
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getOrderId()).asObject());
        timeColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getOrderTime()));
        totalColumn.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().getTotalPrice()).asObject());
        statusColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        String username = DataStore.getInstance().getCurrentUser().getUsername();
        List<Order> orders = DataStore.getInstance().getOrdersByUser(username);
        historyTable.setItems(FXCollections.observableArrayList(orders));
    }
    @FXML
    private void handleBack() {
        SceneManager.switchScene("Home.fxml", "Home - Restaurant Order System");
    }
}
