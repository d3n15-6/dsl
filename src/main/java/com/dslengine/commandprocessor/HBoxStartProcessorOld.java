package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Nuevo código.
// ↪ Nueva clase para implementar el HBox - vie 27 junio 20:02
public class HBoxStartProcessorOld implements CommandProcessor{
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
            throw new IllegalArgumentException("No se puede crear un HBox sin el contenedor activo.");
        }
        // Nuevo código
        // ↪ 🧱 crear el nuevo HBox.
        HBox hBox = new HBox();
        // ↪ ✍️ Busca el espacio si está declarado (ej: "hBox: espaciado 10").
        Matcher matcher = Pattern.compile("espaciado\\s+(\\d+(?:\\.\\d+)?)").matcher(line);
        if (matcher.find()) {
            double spacing = Double.parseDouble(matcher.group(1));
            hBox.setSpacing(spacing);
        }
        // ↪ 📌Agregarlo al contenedor actual (tope de la pila)
        @SuppressWarnings("unchecked")
        Stack<Pane> containerStack = (Stack<Pane>) properties.get("containerStack");
        Pane parent = containerStack.peek();
        parent.getChildren().add(hBox);
        // ↪ 🚀 Empujar el nuevo HBox a la pila: ahora será el contenedor activo.
        containerStack.push(hBox);
        // Ya no necesitamos de currentContainer.
        //currentContainer.getChildren().add(hBox);
        //properties.put("currentContainer", hBox);

        // ↪ 🔔Feedback visual
        if (statusLabel != null) {
            statusLabel.setText("[↪] HBox iniciado y anidado en: " + parent.getClass().getSimpleName());
        }
        return hBox;
    }
}