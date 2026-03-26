package com.dslengine.dslui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DslApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carga FXML de tu constructor de UI.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UIBuilder.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Parent root = fxmlLoader.load();

        stage.setTitle("Generador de UI Dinámico");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}