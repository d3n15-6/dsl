package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Map;

public class LabelCommandProcessor implements CommandProcessor{
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
        // Ejemplo "Label: Mi texto de etiqueta"
        if (currentContainer == null) {
            throw new IllegalArgumentException("Label no puede ser creada sin un contenedor.");
        }
        // Nuevo código.
        // Se reemplazó el line.substring() por line.replaceFirst()
        // para eliminar el prefijo de tolerante a mayúsculas y minúsculas.
        String labelText = line.replaceFirst("(?i)^label:\\s*", "").trim();

        if (labelText.isEmpty()){
            throw new IllegalArgumentException("El texto de la etiqueta no puede estar vacío.");
        }

        Label label = new Label(labelText);

        if (statusLabel != null) {
            statusLabel.setText("Label creada: \"" + labelText + "\"");
        }
        // El contenedor superior se encarga de agregarla si corresponde.
        return label;
    }
}
