package com.dslengine.commandprocessor;

import com.dslengine.dslui.UIBuilderController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane; // Para el cast del contenedor activo.

import java.util.Map;
import java.util.Stack;

public class MenuBarStartProcessor implements CommandProcessor{
    private final UIBuilderController controller;

    public MenuBarStartProcessor(UIBuilderController controller) {
        this.controller = controller;
    }

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
        MenuBar menuBar = new MenuBar();

        if (line.contains(":")) {
            // Parser ID y onKeyPressed (ej: "id menuBar", "al presionar tecla: handleKeyInput")
            String propsString = line.substring(line.indexOf(":")+ 1);
            String[] pairs = propsString.split(",");

            // Lógica de parsing para id y onKeyPressed aquí.
            for (String rawPair : pairs) {
                String[] kv = rawPair.trim().split("\\s+", 2);
                if (kv.length != 2) continue;

                String key = kv[0].toLowerCase();
                String value = kv[1].trim();

                switch (key) {
                    case "id" -> menuBar.setId(value);
                    case "estilo" -> menuBar.getStyleClass().add(value);
                    // Pódes agregar eventos aquí si querés: al presionar tecla.....
                }
            }
        }

        // Añadir al contenedor padre y empujar la pila.
        if (currentContainer != null) {
            currentContainer.getChildren().add(menuBar);
        } else {
            throw new IllegalArgumentException("MenuBar necesita un contenedor padre");
        }

        // Registrar el Menu como contenedor anidable (ej: para menú o ítems).
        Stack<Object> containerStack = (Stack<Object>) properties.get("containerStack");
        containerStack.push(menuBar);
        properties.put("lastNode", menuBar);

        if (statusLabel != null) {
            statusLabel.setText("[↪] MenuBar creado y anidado correctamente.");
        }
        return menuBar;
    }

    public UIBuilderController getController() {
        return controller;
    }
}
