package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Map;

public class WindowCommandProcessor implements CommandProcessor {
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
        // Ejemplo: "ventana: Mi App"
        // String title = line.substring("ventana: ".length()).trim();
        // Nuevo código. - vie 26 junio.
        //  ↪ se agrego el (?i^) - vie 27 junio 08:10
        String title = line.replaceFirst("(?i)^ventana:\\s*", "").trim();
        if (title.isEmpty()) {
            throw new IllegalArgumentException("El título de la ventana no puede estar vacío.");
        }
        // Nuevo código.
        // ↪ Crea y almacena el contenedor principal. - vie 27 junio 08:17
        //Pane rootPane = new Pane(); // User vbox, stackpane, etc. si quieres ampliar.
        StackPane rootPane = new StackPane();
        // Nuevo código.
        // ↪ guardar propiedades globales. - vie 27 junio 08:18
        properties.put("windowTitle", title);
        properties.put("rootPane", rootPane);
        // Nuevo código.
        // ↪ imprime en el label el nombre de la ventana creada. - vie 27 junio 08:22
        if (statusLabel != null) {
            statusLabel.setText("[↪] ventana declarada con titulo: \"" + line + "\"");
        }
        return null; // Este comando no crea un nodo de UI.
    }
}