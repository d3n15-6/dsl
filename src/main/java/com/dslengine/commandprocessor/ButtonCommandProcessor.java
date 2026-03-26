package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Map;

public class ButtonCommandProcessor implements CommandProcessor {
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
            throw new IllegalArgumentException("El botón no puede ser creado sin un contenedor.");
        }
        //
        String buttonText = line.replaceFirst("(?i)^boton:\\s*", "").trim();
        if (buttonText.isEmpty()) {
            throw new IllegalArgumentException("El texto del botón no puede estar vacío.");
        }

        Button button = new Button();

        //
        button.setOnAction(e -> {
            if (statusLabel != null) {
                statusLabel.setText("[@] Click en botón: \"" + buttonText + "\"");
            }
        });

        if (statusLabel != null) {
            statusLabel.setText("[@] Botón creado: \"" + buttonText + "\"");
        }
        return button; // Retorna el botón para la posible manipulación.
    }
}
