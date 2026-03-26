package com.dslengine.dslui;

import com.dslengine.commandprocessor.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UIBuilderController {
    @FXML
    private TextArea commandTextArea;
    @FXML
    private Label statusLabel;

    // Nuevo código.
    private Stage generatedStage;
    private Pane currentRootPane; // El panel raíz de la ventana generada.
    // Para propiedades como título, dimensiones, color.
    private Map<String, Object> globalProperties = new HashMap<>();
    // Mapa para almacenar los procesadores de comandos.
    private Map<String, CommandProcessor> commandProcessor = new HashMap<>();
    // Nuevo código.
    // ↪ Pila de contenedores. - vie 28 junio 06:46
    /// 🧰Bonus: Usar stack para nesting profundo
    /// Para permitir nesting recursivo con múltiples niveles, es conveniente inicializar una pila global.
    private Stack<Pane> containerStack = new Stack<>();

    public UIBuilderController()  {
        // Inicializar los procesadores de comandos.
        commandProcessor.put("ventana", new WindowCommandProcessor());
        commandProcessor.put("dimensiones", new DimensionsCommandProcessor());
        commandProcessor.put("color RGB", new ColorCommandProcessor());
        commandProcessor.put("boton", new ButtonCommandProcessor());
        commandProcessor.put("label", new LabelCommandProcessor());
        commandProcessor.put("textfield", new TextFieldCommandProcessor());
        commandProcessor.put("vbox", new VBoxStartProcessor());
        //commandProcessor.put("end vbox", new VBoxEndProcessorOld(this));
        commandProcessor.put("end vbox", new GenericEndProcessor<>(VBox.class, this));
        commandProcessor.put("hbox", new HBoxStartProcessor());
        //commandProcessor.put("end hbox", new HBoxEndProcessorOld(this));
        commandProcessor.put("end hbox", new GenericEndProcessor<>(HBox.class, this));
        commandProcessor.put("menubar", new MenuBarStartProcessor(this));
        commandProcessor.put("end menubar", new MenuBarEndProcessor(this));
        commandProcessor.put("menu", new MenuStartProcessor(this));
        commandProcessor.put("end menu", new MenuEndProcessor(this));
        commandProcessor.put("menuitem", new MenuItemStartProcessor(this));
        //...
        commandProcessor.put("pane", new PaneStartProcessor());
        commandProcessor.put("end pane", new GenericEndProcessor<>(Pane.class, this));
        commandProcessor.put("stackpane", new StackPaneStartProcessor());
        commandProcessor.put("end stackpane", new GenericEndProcessor<>(StackPane.class, this));
        // Agregar aquí más procesadores para otros componentes.
    }

    @FXML
    private void generateWindow() {

        // 🧹🧽🧼Limpiar el estado anterior.
        // Nuevo código.
        clearPreviousState();
        // statusLabel.setText("");
        //if (generatedStage != null) {
            // Cerrar la ventana anterior si existe.
            //generatedStage.close();
        //}

        // Nuevo código
        // ↪ Limpiar variables globales.
        globalProperties.clear();
        // 🧱Valores por defecto.
        globalProperties.put("WindowTitle", "Ventana Generada");
        globalProperties.put("windowWidth", 400.0);
        globalProperties.put("windowHeight", 300.0);
        globalProperties.put("panelColor", Color.web("#f0f0f0"));
        // Un Pane flexible por defecto para el contenido de la ventana.
        // currentRootPane = new Pane(); // Ya no hace falta hardcodear.
        // Nuevo código.
        // ↪ se declara el layout base desde el comando ventana. - vie 27 junio 08:33
        currentRootPane = (Pane) globalProperties.getOrDefault("rootPane", new Pane());
        // Nuevo código.
        // ↪ Empuje el panel raíz a la pila. - vie 28 junio 05:54
        containerStack.push(currentRootPane);
        //------------------------------------------------
        // Nuevo código
        // Imprimir el contenido de la pila.
        System.out.println("[] Pila de contenedores: ");
        for (int i = 0; i < containerStack.size(); i++) {
            System.out.println(" nivel " + i + ": " + containerStack.get(i).getClass().getSimpleName());
        }
        //------------------------------------------------
        globalProperties.put("containerStack", containerStack);
        // Para aplicar propiedades como 'posición' al último elemento.
        Node lastAddedNode = null;

        String commands = commandTextArea.getText();
        String[] lines = commands.split("\\r?\\n");

        try {
            for (String line : lines) {
                // Elimina espacios en blancos al inicio y al final.
                line = line.trim();
                if (line.isEmpty()) continue;
                // Extrae el comando principal (ejemplo: "ventana", "label", "botón").
                String commandKey = extractCommandKey(line);
                CommandProcessor processor = commandProcessor.get(commandKey);
                if (processor != null) {
                    // Nuevo código.
                    // ↪ 🧠 Determinar si el processor necesita un Pane (comandos visuales) o no
                    Object active = containerStack.peek();
                    // Nuevo código.
                    // ↪ Obtener el contenedor activo para añadir elementos. - vie 28 junio 06:49
                    //Pane activeContainer = containerStack.peek(); // Siempre trabajamos con el contenedor encima de la pila.
                    // Nuevo código
                    // 🛠️
                    Pane activeContainer = (active instanceof Pane p) ? p : null;
                    // Si el procesador devuelve un nodo (es decir creó un componente de UI),
                    // lo guardamos como el último nodo añadido para comandos como "posición".
                    // VBox =
                    Node createdNode = processor.process(line, activeContainer, globalProperties, statusLabel);
                    // Comprobar que los nodos realmente existen. Asi veo si el botón están siendo creados,
                    // aunque no se vean.
                    //System.out.println("Nodo agregado: " + createdNode.getClass().getSimpleName());
                    if (createdNode != null) {
                        //currentRootPane.getChildren().add(createdNode); <- esta parte de aqui genera errores.
                        lastAddedNode = createdNode;
                        // Opcional para otros comandos.
                        globalProperties.put("lastNode", createdNode);
                        System.out.println("[↪] Nodo agregado: " + createdNode.getClass().getSimpleName());
                        /////-- verficamos si el nodo fue creado.
                        System.out.println("[@] Nodo creado por " + commandKey + ": " + createdNode.getClass().getSimpleName());
                    }
                } else if (commandKey.equals("posicion") && lastAddedNode != null) {
                    applayPosition(line, lastAddedNode);
                } else {
                    // Nuevo código
                    // nueva variable warning.
                    String warning = "[»] Comando desconocido o incompleto: " + line;
                    // le pasamos el warning al statusLabel
                    statusLabel.setText(warning);
                    System.err.println(warning);
                }
            }
            // Nuevo código.
            // ↪ Validar que la pila solo contenga el panel raíz al finalizar. - vie 28 junio 07:07
            if (containerStack.size() != 1) {
                // Mensaje modificado.
                throw new IllegalArgumentException("[»] Error de anidamiento: sobran o faltan comandos 'end'.");
            }
            // Nuevo código.
            Color backgroundColor = (Color) globalProperties.get("panelColor");
            // Configurar el fondo del panel raíz después de procesar todos los comandos.
            currentRootPane.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));

            //
            generatedStage = new Stage();
            generatedStage.setTitle((String) globalProperties.get("windowTitle"));
            generatedStage.setScene(new Scene(currentRootPane,
                    (Double) globalProperties.get("windowWidth"),
                    (Double) globalProperties.get("windowHeight")));
            generatedStage.show();

        } catch (IllegalArgumentException e) {
            statusLabel.setText("[»] Error en el commando: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            statusLabel.setText("[»] Error desconocido al generar la ventana: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Nuevo código.
            // ↪ Asegúrate de limpiar la pila para la próxima generación. - vie 28 junio 07:14
            containerStack.clear();
        }
    }

    private void clearPreviousState() {
    }

    private void applayPosition(String line, Node node) {
        // Manejo de la posición para el último nodo creado.
        Matcher matcher = Pattern.compile("(\\d+)[xX](\\d+)").matcher(line);
        if (matcher.find()) {
            double x = Double.parseDouble(matcher.group((1)));
            double y = Double.parseDouble(matcher.group((2)));
        } else {
            throw new IllegalArgumentException("[»] Formato de posición incorrecto. Use AxB. Ej: 100x200.");
        }
    }

    @FXML
    private void clearTerminal() {
        commandTextArea.clear();
        statusLabel.setText("");
        if (generatedStage != null) {
            generatedStage.close();
            generatedStage = null;
        }
    }

    // Método auxiliar para extraer la clave del comando.
    private String extractCommandKey(String line) {
        if (line.contains(":")) {
            return line.substring(0, line.indexOf(":")).trim();
        }
        // Si no hay ':', toda la línea es la clave (o un error)
        return line.trim();
    }

    // Ya no se usa.
    // Nuevo código.
    // Métodos adicionales en UIBuildController para gestionar la pila.
    public void pushContainer(Pane newContainer) {
        containerStack.push(newContainer);
    }
    // Ya no se usa
    public Pane popContainer() {
        // No puedes sacar el panel raíz.
        if (containerStack.size() <= 1) {
            throw new IllegalArgumentException("[»] Error de anidamiento: Intentando finalizar un panel raíz o un panel vacío.");
        }
        return containerStack.pop();
    }

    private Pane requireActivePane() {
        Object top = containerStack.peek();
        if (!(top instanceof Pane pane)) {
            throw new IllegalArgumentException("[] Contenedor actual no es visual: " + top.getClass().getSimpleName());
        }
        return pane;
    }
}
