package com.dslengine.commandprocessor;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class StackPaneStartProcessor extends AbstractContainerStartProcessor<StackPane> {
    @Override
    protected StackPane createContainer() {
        return new StackPane(); // Superpone nodos centrados por defecto.
    }
}
