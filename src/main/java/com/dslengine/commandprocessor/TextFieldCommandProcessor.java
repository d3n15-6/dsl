package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.Map;

public class TextFieldCommandProcessor implements CommandProcessor{
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
            throw new IllegalArgumentException("TextField no puede ser creada sin un contenedor.");
        }
        // Ejemplo: "textfield: Valor Inicial."
        String initialText = line.replaceFirst("(?i)^textfield:\\s*","").trim();

        TextField textField = new TextField();
        if (!initialText.isEmpty()) {
            textField.setText(initialText);
        } else {
            textField.setText("Ingrese el texto...");
        }

        if (statusLabel != null) {
            statusLabel.setText(initialText.isEmpty() ? "Campo de texto creado sin valor inicial." : "Campo de texto creado con valor: \"" + initialText + "\"");
        }
        return textField;
    }
}
