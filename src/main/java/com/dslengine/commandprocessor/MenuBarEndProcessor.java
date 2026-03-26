package com.dslengine.commandprocessor;

import com.dslengine.dslui.UIBuilderController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

import java.util.Map;
import java.util.Stack;

public class MenuBarEndProcessor implements CommandProcessor {
    private final UIBuilderController controller;

    public MenuBarEndProcessor(UIBuilderController controller) {
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
        @SuppressWarnings("unchecked")
        Stack<Object> containerStack = (Stack<Object>) properties.get("containerStack");

        if (containerStack.isEmpty()) {
            throw new IllegalArgumentException("[] No hay MenuBar para finalizar.");
        }

        Object popped = containerStack.pop();

        if (!(popped instanceof MenuBar)) {
            throw new IllegalArgumentException("[] Se esperaba un MenuBar para finalizar pero se encontro: " + popped.getClass().getSimpleName());
        }

        if (statusLabel != null) {
            statusLabel.setText("[↪] Fin de MenuBar procesado.");
        }
        return null;
    }
}
