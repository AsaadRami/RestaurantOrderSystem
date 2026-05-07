package com.restaurant.controller;

import com.restaurant.util.DataStore;
import com.restaurant.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class RegisterController {
    @FXML private TextField     usernameField;
    @FXML private TextField     emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label         messageLabel;
    @FXML
    private void handleRegister() {
        String username = usernameField.getText().trim();
        String email    = emailField.getText().trim();
        String password = passwordField.getText().trim();
        String confirm  = confirmPasswordField.getText().trim();
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Please fill in all fields.");
            return;
        }
        if (!password.equals(confirm)) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Passwords do not match.");
            return;
        }
        if (password.length() < 4) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Password must be at least 4 characters.");
            return;
        }
        boolean success = DataStore.getInstance().registerUser(username, password, email);
        if (success) {
            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Registered successfully! Please log in.");
        } else {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Username already exists.");
        }
    }
    @FXML
    private void handleGoToLogin() {
        SceneManager.switchScene("Login.fxml", "Login - Restaurant Order System");
    }
}
