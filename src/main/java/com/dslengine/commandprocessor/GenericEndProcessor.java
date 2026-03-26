package com.dslengine.commandprocessor;

import com.dslengine.dslui.UIBuilderController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Map;

public class GenericEndProcessor<T extends Pane> implements CommandProcessor {
    private final Class<T> expectedClass;
    private final UIBuilderController controller;

    public GenericEndProcessor(Class<T> expectedClass, UIBuilderController controller) {
        this.expectedClass = expectedClass;
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
        if (expectedClass.isInstance(currentContainer)) {
            throw new IllegalArgumentException("[»] Error de anidamiento: 'end " + expectedClass.getSimpleName().toLowerCase() + "' no coinciden con el contenedor actual.");
        }
        controller.popContainer();
        // ↪ 🔔Feedback visual
        if (statusLabel != null) {
            statusLabel.setText(expectedClass.getSimpleName() + " cerrado correctamente.");
        }
        return null;
    }
}
