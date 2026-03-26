package com.dslengine.commandprocessor;

import com.dslengine.dslui.UIBuilderController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuEndProcessor implements CommandProcessor {
    private UIBuilderController controller;

    public MenuEndProcessor() {}

    public MenuEndProcessor(UIBuilderController controller) {
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

        // El menú se añade a la colección de menus de la MenuBar.
        @SuppressWarnings("unchecked")
        Stack<Object> containerStack = (Stack<Object>) properties.get("containerStack");

        if (containerStack.isEmpty()) {
            throw new IllegalArgumentException("[] No hay ningún Menu para finalizar.");
        }

        Object popped = containerStack.pop();

        if (!(popped instanceof Menu)) {
            throw new IllegalArgumentException("Se esperaba finalizar un Menu, pero se encontró: " + popped.getClass().getSimpleName());
        }

        if (statusLabel != null) {
            statusLabel.setText("[↪] Fin de Menú: " + popped.getClass().getSimpleName());
        }
        return null; // Los menú no son nodos visuales directos.
    }
}
