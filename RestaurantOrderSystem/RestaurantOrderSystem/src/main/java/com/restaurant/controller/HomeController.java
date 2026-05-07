package com.restaurant.controller;

import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class HomeController {
    @FXML private Label welcomeLabel;
    @FXML
    public void initialize() {
        String username = DataStore.getInstance().getCurrentUser().getUsername();
        welcomeLabel.setText("ازيك " + username );
    }
    @FXML
    private void handleGoToMenu() {
        SceneManager.switchScene("Menu.fxml", "Menu - Restaurant Order System");
    }
    @FXML
    private void handleGoToOrderHistory() {
        SceneManager.switchScene("OrderHistory.fxml", "Order History");
    }
    @FXML
    private void handleGoToProfile() {
        SceneManager.switchScene("Profile.fxml", "My Profile");
    }
    @FXML
    private void handleLogout() {
        SceneManager.switchScene("Logout.fxml", "Logout");
    }
}
