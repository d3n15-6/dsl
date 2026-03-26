package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCommandProcessor implements CommandProcessor {

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
        // Ejemplo 1: "color RGB:255,255,0"
        // Ejemplo 2: "color RGB: 255,255,0"
        // Ejemplo 3: "color RGB:255,255, 0"
        // Ejemplo 4: "color RGB:255, 255, 0"
        // Ejemplo 5: "color RGB: 255, 255, 0"

        // Nuevo código.
        // Elimina el prefijo y extrae solo la parte RGB.
        String rgbPart = line.replaceFirst("(?i)^color RGB:\\s*", "").trim();

        // Permite espacios opcionales entre los componentes RGB.
        Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*");
        Matcher matcher = pattern.matcher(rgbPart);

        // En el if cambiamos matcher.find() por matcher.matches().
        if (matcher.matches()) {
            int r = Integer.parseInt(matcher.group(1));
            int g = Integer.parseInt(matcher.group(2));
            int b = Integer.parseInt(matcher.group(3));

            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                throw new IllegalArgumentException("Valores RGB fuera de rangos. Deben estar entre 0 y 255");
            }
            properties.put("panelColor", Color.rgb(r, g, b));

            if (statusLabel != null) {
                statusLabel.setText("[@] Color asignado: RGB("+ r + ", " + g + ", " + b + ")");
            }
        } else {
            throw new IllegalArgumentException("Formato de color RGB incorrecto '" + line + "'. Use R, G, B");
        }
        return null;
    }
}
