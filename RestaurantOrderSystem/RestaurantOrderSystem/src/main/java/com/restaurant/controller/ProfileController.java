package com.restaurant.controller;

import com.restaurant.model.User;
import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class ProfileController {
    @FXML private Label usernameLabel;
    @FXML private Label emailLabel;
    @FXML private Label roleLabel;
    @FXML
    public void initialize() {
        User user = DataStore.getInstance().getCurrentUser();
        usernameLabel.setText("Username: " + user.getUsername());
        emailLabel.setText("Email: "    + user.getEmail());
        roleLabel.setText("Role: "      + user.getRole());
    }
    @FXML
    private void handleBack() {
        SceneManager.switchScene("Home.fxml", "Home - Restaurant Order System");
    }
}
