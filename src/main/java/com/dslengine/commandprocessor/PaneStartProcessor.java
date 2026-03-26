package com.dslengine.commandprocessor;

import javafx.scene.layout.Pane;

public class PaneStartProcessor extends AbstractContainerStartProcessor<Pane> {
    @Override
    protected Pane createContainer() {
        return new Pane(); // No tiene layout automático.
    }
}
