package com.dslengine.commandprocessor;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Map;
import java.util.Stack;

public abstract class AbstractContainerStartProcessor<T extends Pane> implements CommandProcessor{
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
        // ↪ 📌Agregarlo al contenedor actual (tope de la pila)
        @SuppressWarnings("unchecked")
        Stack<Pane> containerStack = (Stack<Pane>) properties.get("containerStack");
        // 1. Crear el nuevo layout específico (VBox, HBox, etc).
        T newContainer = createContainer();
        // 2. Aplicar configuración opcional como espaciado si corresponde.
        applyCustomAttributes(line, newContainer);
        // 3. Agregar al contenedor activo y empujar a la pila.
        Pane parent = containerStack.peek();
        parent.getChildren().add(newContainer);
        // ↪ 🚀 Empujar el nuevo VBox a la pila: ahora será el contenedor activo.
        containerStack.push(newContainer);
        // 4. Asignar color local si fue definido anteriormente.
        if (properties.containsKey("localColor")) {
            Color color = (Color) properties.remove("localColor");
            newContainer.setBackground(new Background(new BackgroundFill(color, null, null)));
        }
        // ↪ 🔔Feedback visual
        if (statusLabel == null) {
            statusLabel.setText("[↪] " + newContainer.getClass().getSimpleName() + " creado.");
        }
        return newContainer;
    }

    /**
     * Métodos que debe implementar cada subclase para crear su layout específico.
     * */
    protected abstract T createContainer();

    protected void applyCustomAttributes(String line, T newContainer) {

    }
}
