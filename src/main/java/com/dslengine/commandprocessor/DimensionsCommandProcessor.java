package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DimensionsCommandProcessor implements CommandProcessor{
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
        // Ejemplo: "dimensiones: 800x600"
        Pattern pattern = Pattern.compile("(\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            properties.put("windowWidth", Double.parseDouble(matcher.group(1)));
            properties.put("windowHeight", Double.parseDouble(matcher.group(2)));
        } else {
            throw new IllegalArgumentException("Formato de dimensiones incorrecto en '" + line + "' Use WxH.");
        }
        return null;
    }
}
