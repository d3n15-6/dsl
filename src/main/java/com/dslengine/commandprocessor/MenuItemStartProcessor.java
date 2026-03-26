package com.dslengine.commandprocessor;

import com.dslengine.dslui.UIBuilderController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuItemStartProcessor implements CommandProcessor{
    private UIBuilderController controller;

    public MenuItemStartProcessor(UIBuilderController controller) {
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
        MenuItem menuItem = new MenuItem();

        // 🔍 Parser propiedades de la línea. Texto, deshabilitado, visible, al_accion.
        String propsString = line.substring("menuitem:".length()).trim();

        // Ejemplo de parsing de 'texto': Es el nombre que le damos al MenuItem.
        Matcher matcher = Pattern.compile("texto\\s+\"([^\"]*)\"").matcher(propsString);
        if (matcher.find()) {
            menuItem.setText(matcher.group(1));
        } else {
            throw new IllegalArgumentException("MenuItem debe tener una propiedad 'texto'");
        }
        // Ejemplo de parsing de 'deshabilitado'.
        if (propsString.contains("deshabilitado")) {
            menuItem.setDisable(true);
        }

        // Ejemplo de parsing 'visible falso'
        if (propsString.contains("visible falso")) {
            menuItem.setVisible(false);
        } else if (propsString.contains("visible verdadero")) {
            menuItem.setVisible(true);
        }

        Matcher actionMatcher = Pattern.compile("al_accion:\\s+(\\w+)").matcher(propsString);
        if (actionMatcher.find()) {
            String methodName = actionMatcher.group(1);
            // Aquí la complejidad: necesitas invocar el método 'methodName'
            // del controlador definido en 'controlador: dustin.examples.MenuController'
            // Esto se haría con Java Reflection.
            // Para simplificar, podrías tener un mapa de acciones predefinidas
            // o un System.out.println() para empezar.
            menuItem.setOnAction(e -> System.out.println("[↪] Acción disparada desde MenuItem: " + methodName));
        }

        // 📦 Añadir al padre que está en la cima de la pila.
        @SuppressWarnings("unchecked")
        Stack<Pane> containerStack = (Stack<Pane>) properties.get("containerStack");
        Object parent = containerStack.peek();

        if (parent instanceof Menu menu) {
            menu.getItems().add(menuItem);
        } else {
            throw new IllegalArgumentException("[»] MenuItem debe estar dentro de un Menu.");
        }

        properties.put("lastNode", menuItem);
        if (statusLabel != null) {
            statusLabel.setText("[↪] MenuItem agregado a menú");
        }
        return null; // MenuItem no es visual directamente.
    }
}
