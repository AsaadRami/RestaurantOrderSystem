package com.restaurant.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class SceneManager {
    private static Stage primaryStage;
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void switchScene(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource("/com/restaurant/fxml/" + fxmlPath)
            );
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle(title);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML: " + fxmlPath);
        }
    }
}
