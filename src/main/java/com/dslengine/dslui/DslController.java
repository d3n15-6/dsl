package com.dslengine.dslui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DslController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}