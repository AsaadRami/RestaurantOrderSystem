package com.restaurant.controller;

import com.restaurant.model.User;
import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField     usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label         errorLabel;
    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("اتفضل حط بياناتك");
            return;
        }
        User user = DataStore.getInstance().loginUser(username, password);
        if (user == null) {
            errorLabel.setText("راجع تاني يا غبي ");
            return;
        }
        DataStore.getInstance().setCurrentUser(user);
        if ("admin".equals(user.getRole())) {
            SceneManager.switchScene("Admin.fxml", "Admin Panel");
        } else {
            SceneManager.switchScene("Home.fxml", "Home - Restaurant Order System");
        }
    }
    @FXML
    private void handleGoToRegister() {
        SceneManager.switchScene("Register.fxml", "Register - Restaurant Order System");
    }
}
