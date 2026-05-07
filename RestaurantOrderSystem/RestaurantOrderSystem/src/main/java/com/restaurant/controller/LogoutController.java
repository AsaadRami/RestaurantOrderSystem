package com.restaurant.controller;

import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.fxml.FXML;
public class LogoutController {
    @FXML
    private void handleConfirmLogout() {
        DataStore.getInstance().logout();
        SceneManager.switchScene("Login.fxml", "Login - Restaurant Order System");
    }
    @FXML
    private void handleCancel() {
        SceneManager.switchScene("Home.fxml", "Home - Restaurant Order System");
    }
}
