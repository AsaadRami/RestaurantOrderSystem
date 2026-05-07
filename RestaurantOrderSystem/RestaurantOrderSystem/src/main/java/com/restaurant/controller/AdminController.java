package com.restaurant.controller;

import com.restaurant.model.Order;
import com.restaurant.model.User;
import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
public class AdminController {

    @FXML private TableView<Order>              ordersTable;
    @FXML private TableColumn<Order, String>    userColumn;
    @FXML private TableColumn<Order, String>    timeColumn;
    @FXML private TableColumn<Order, Double>    totalColumn;
    @FXML private TableColumn<Order, String>    statusColumn;

    @FXML private TableView<User>               usersTable;
    @FXML private TableColumn<User, String>     unameColumn;
    @FXML private TableColumn<User, String>     emailColumn;
    @FXML private TableColumn<User, String>     roleColumn;

    @FXML
    public void initialize() {
        userColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getUsername()));
        timeColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getOrderTime()));
        totalColumn.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().getTotalPrice()).asObject());
        statusColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        List<Order> orders = DataStore.getInstance().getAllOrders();
        ordersTable.setItems(FXCollections.observableArrayList(orders));
        unameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getUsername()));
        emailColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getEmail()));
        roleColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getRole()));
        List<User> users = DataStore.getInstance().getAllUsers();
        usersTable.setItems(FXCollections.observableArrayList(users));
    }
    @FXML
    private void handleLogout() {
        SceneManager.switchScene("Logout.fxml", "Logout");
    }
}
