package com.dslengine.commandprocessor;

import javafx.scene.layout.HBox;

import java.util.function.DoubleConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Nuevo código.
// ↪ Nueva clase para implementar el HBox - vie 27 junio 20:02
//public class HBoxStartProcessor implements CommandProcessor{
public class HBoxStartProcessor extends AbstractContainerStartProcessor<HBox> {
    @Override
    protected HBox createContainer() {
        // Nuevo código
        // ↪ 🧱 crear el nuevo HBox. 4-julio-2025 07:40
        return new HBox();
    }

    @Override
    protected void applyCustomAttributes(String line, HBox hBox) {
        // -------------- Propiedades del HBox ---------------
        applyDimensionIfPresent(line, "espaciado", hBox::setSpacing);
        applyDimensionIfPresent(line, "prefWidth", hBox::setPrefWidth);
        applyDimensionIfPresent(line, "prefHeigth", hBox::setPrefHeight);
        applyDimensionIfPresent(line, "maxWidth", hBox::setMaxWidth);
        applyDimensionIfPresent(line, "maxHeigth", hBox::setMaxHeight);
    }

    private void applyDimensionIfPresent(String line, String key, DoubleConsumer setter) {
        // ↪ ✍️ Busca el espacio si está declarado (ej: "Hbox: espaciado 10").
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
