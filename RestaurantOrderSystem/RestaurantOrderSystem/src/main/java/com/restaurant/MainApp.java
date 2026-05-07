package com.restaurant;

import com.restaurant.util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneManager.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Restaurant Order System");
        primaryStage.setResizable(true);
        primaryStage.setWidth(700);
        primaryStage.setHeight(550);
        SceneManager.switchScene("Login.fxml", "Login - Restaurant Order System");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
