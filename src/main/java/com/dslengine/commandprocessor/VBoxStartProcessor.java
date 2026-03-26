package com.dslengine.commandprocessor;

import javafx.scene.layout.VBox;

import java.util.function.DoubleConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Nuevo código.
// ↪ Nueva clase para implementar el VBox - vie 27 junio 20:02
//public class VBoxStartProcessor implements CommandProcessor{
public class VBoxStartProcessor extends AbstractContainerStartProcessor<VBox> {
    @Override
    protected VBox createContainer() {
        // Nuevo código
        // ↪ 🧱 crear el nuevo VBox. 4-julio-2025 07:40
        return new VBox();
    }

    @Override
    protected void applyCustomAttributes(String line, VBox vBox) {
        // -------------- Propiedades del VBox ---------------
        applyDimensionIfPresent(line, "espaciado", vBox::setSpacing);
        applyDimensionIfPresent(line, "prefWidth", vBox::setPrefWidth);
        applyDimensionIfPresent(line, "prefHeigth", vBox::setPrefHeight);
        applyDimensionIfPresent(line, "maxWidth", vBox::setMaxWidth);
        applyDimensionIfPresent(line, "maxHeigth", vBox::setMaxHeight);
    }

    private void applyDimensionIfPresent(String line, String key, DoubleConsumer setter) {
        // ↪ ✍️ Busca el espacio si está declarado (ej: "vbox: espaciado 10").
        Pattern pattern = Pattern.compile(key + "\\s+(\\d+(\\.\\d+)?)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            try {
                double value =Double.parseDouble(matcher.group(1));
                setter.accept(value);
            } catch (NumberFormatException ignored) {}
        }
    }
}
