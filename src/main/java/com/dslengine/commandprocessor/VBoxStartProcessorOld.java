package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Map;
import java.util.Stack;
import java.util.function.DoubleConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Nuevo código.
// ↪ Nueva clase para implementar el VBox - vie 27 junio 20:02
public class VBoxStartProcessorOld implements CommandProcessor{
    /**
     * Procesa una līnea de comandos y aplica las propiedades al Stage o al contenedor actual.
     *
     * @param line             La linea de comando completa.
     * @param currentContainer El contenedor de JavaFX actual donde se deben añadir los elementos.
     * @param properties       Un mapa mutable donde se pueden almacenar propiedades globales (ejemplo: ancho/alto de ventana).
     * @param statusLabel      La etiqueta para mostrar mensajes de estado de error.
     * @return El nodo UI creado o modificado, o null si el commando no crea un nuevo nodo.
     * @throws IllegalArgumentException Si el formato del documento es incorrecto o hay un error de lógica.
     */
    @Override
    public Node process(String line, Pane currentContainer, Map<String, Object> properties, Label statusLabel) throws IllegalArgumentException {
        if (currentContainer == null) {
            throw new IllegalArgumentException("No se puede crear un VBox sin el contenedor activo.");
        }
        // Nuevo código
        // ↪ 🧱 crear el nuevo VBox.
        VBox vBox = new VBox();
        // -------------- Propiedades del VBox ---------------
        applyDimensionIfPresent(line, "espaciado", vBox::setSpacing);
        applyDimensionIfPresent(line, "prefWidth", vBox::setPrefWidth);
        applyDimensionIfPresent(line, "prefHeight", vBox::setPrefHeight);
        applyDimensionIfPresent(line, "maxWidth", vBox::setMaxWidth);
        applyDimensionIfPresent(line, "maxHeigth", vBox::setMaxHeight);

        // ↪ ✍️ Busca el espacio si está declarado (ej: "vbox: espaciado 10").
        Matcher matcher = Pattern.compile("espaciado\\s+(\\d+(?:\\.\\d+)?)").matcher(line);
        if (matcher.find()) {
            double spacing = Double.parseDouble(matcher.group(1));
            vBox.setSpacing(spacing);
        }
        // ↪ 📌Agregarlo al contenedor actual (tope de la pila)
        @SuppressWarnings("unchecked")
        Stack<Pane> containerStack = (Stack<Pane>) properties.get("containerStack");
        Pane parent = containerStack.peek();
        parent.getChildren().add(vBox);
        // ↪ 🚀 Empujar el nuevo VBox a la pila: ahora será el contenedor activo.
        containerStack.push(vBox);
        // Ya no necesitamos de currentContainer.
        //currentContainer.getChildren().add(vBox);
        //properties.put("currentContainer", vBox);

        // ↪ 🔔Feedback visual
        if (statusLabel != null) {
            statusLabel.setText("[↪] VBox iniciado y anidado en: " + parent.getClass().getSimpleName());
        }
        return vBox;
    }

    private void applyDimensionIfPresent(String line, String key, DoubleConsumer setter) {
        Pattern pattern = Pattern.compile(key + "\\s+(\\d+(\\.\\d+)?)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            try {
                double value =Double.parseDouble(matcher.group(1));
                setter.accept(value);
            } catch (NumberFormatException ignored) {}
        }
    }

//    private applyStringValue(String line, String key, Consumer<String> setter) {
//        Pattern pattern = Pattern.compile(key + "\\s+([\\w.%\"-]+)", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            setter.accept(matcher.group(1));
//        }
//    }
}
