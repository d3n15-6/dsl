# Clase UIBuilderController
```java
package com.dslengine.dslui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UIBuilderController {
    @FXML
    private TextArea commandTextArea;
    @FXML
    private Label statusLabel;
    private Stage generatedStage;
    @FXML
    private void generateWindow() { 
        // Limpiar el estado anterior. 
        statusLabel.setText("");
        if (generatedStage != null) {
            // Cerrar la ventana anterior si existe. 
            generatedStage.close();
        }
        
        String commands = commandTextArea.getText();
        // Divide el texto en líneas. 
        String[] lines = commands.split("\\r?\\n");
        // Propiedades por defecto. 
        String windowTitle = "Ventana Generada";
        double windowWidth = 400;
        double windowsHeight = 300;
        // Color gris claro por defecto. 
        Color panelColor = Color.web("#f0f0f0");
        String buttonText = "Botón Generado";
        double buttonX = 10;
        double buttonY = 10;
        // Un pane flexible para colocar elementos. 
        Pane rootPane = new Pane();
        try {
            for (String line : lines) {
                // Elimina espacios en blancos al inicio y al final. 
                line = line.trim();
                if (line.isEmpty()) continue;
                if (line.startsWith("ventana:")) {
                    windowTitle = line.substring("ventana:".length()).trim();
                } else if (line.startsWith("dimensiones:")) {
                    Pattern pattern = Pattern.compile("(\\d*)x(\\d*)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        windowWidth = Double.parseDouble(matcher.group(1));
                        windowsHeight = Double.parseDouble(matcher.group(2));
                    } else {
                        throw new IllegalArgumentException("Formato de dimensiones incorrecto. Use WxH");
                    }
                } else if (line.startsWith("color RGB:")) {
                    Pattern pattern = Pattern.compile("(\\d+)-(\\d+)-(\\d+)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                    int r = Integer.parseInt(matcher.group(1));
                    int g = Integer.parseInt(matcher.group(2));
                    int b = Integer.parseInt(matcher.group(3));
                    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                        throw new IllegalArgumentException("Valores RGB deben estar entre 0 y 255");
                    }
                    panelColor = Color.rgb(r, g, b);
                    } else {
                        throw new IllegalArgumentException("Formato de color RGB incorrecto. Use R-G-B");
                    }
                } else if(line.startsWith("boton:")) {
                    buttonText = line.substring("boton:".length()).trim();
                    Button newButton = new Button(buttonText);
                    // Añadir el nuevo botón 
                    newButton.setOnAction(e ->System.out.println("Clic en: "+newButton.getText()));
                    // Añade el botón al panel. 
                    rootPane.getChildren().add(newButton);
                } else if(line.startsWith("posicion:") && rootPane.getChildren().size() >0){
                    // Aplicar la posición al último elemento añadido (asumimos que es el botón). 
                    Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
                    Matcher matcher = pattern.matcher(line); 
                    if(matcher.find()){
                        double x = Double.parseDouble(matcher.group(1));
                        double y = Double.parseDouble(matcher.group(2));
                        // Aplicar la posición al último nodo añadido (ejemplo: botón). 
                        rootPane.getChildren().get(rootPane.getChildren().size() -1).setLayoutX(x); 
                        rootPane.getChildren().get(rootPane.getChildren().size() -1).setLayoutY(y); 
                    } else {
                        throw new IllegalArgumentException("Formato de posición incorrecto. Use X,Y.");
                    }
                } 
                // Aquí podrías añadir más comandos como 'label:', 'texto:', etc. 
                // y si tuvieras diferentes tipos de paneles, tendrías que gestionar 
                // cuál es panel actual al que se le añaden los elementos. 
                }
                rootPane.setBackground(new Background(new BackgroundFill(panelColor, null,null)));
                generatedStage =new Stage();
                generatedStage.setTitle(windowTitle);
                generatedStage.setScene(new Scene(rootPane, windowWidth, windowsHeight));
                generatedStage.show();
        } catch(IllegalArgumentException e) {
            statusLabel.setText("Error en el commando: "+e.getMessage());
            e.printStackTrace(); 
        } catch(Exception e){
            statusLabel.setText("Error desconocido al generar la ventana: "+e.getMessage());
            e.printStackTrace();
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
}
```
este controlador está altamente funcional y refleja muy bien tu estilo meticuloso y orientado a la expresión clara 
mediante ```DSLs```. La estructura está limpia, intuitiva y extensible. Aquí algunas observaciones y sugerencias para 
enriquecerlo aún más:
___
## ✅ Fortalezas técnicas:
* **Parsers robustos con validación regex**: Muy buen manejo de expresiones regulares para asegurar formatos correctos.
* **Acoplamiento bajo**: Cada comando afecta solo lo que necesita. Muy en línea con el principio de responsabilidad única.
* **Feedback inmediato al usuario**: mediante ```statusLabel``` y excepciones bien diferenciadas.
___
## 💡 Sugerencias para refinar el motor DSL:
### 1. Separación de responsabilidades (SRP-friendly):
Podrías extraer el análisis y aplicación de comandos en una clase tipo ```DslCommandProcessor```. Por ejemplo:
```java
new DslCommandProcessor().apply(commands, rootPane);
```
Esto permitiría:
* Testear el parser sin lanzar una ```UI```.
* Reutilizar en otros contextos o UIs.
### 2. Soporte para múltiples botones o componentes:
Actualmente se asume que todo es un botón y solo uno por ventana. Podría enriquecerlo con lógica como:
```text
boton: Aceptar
posicion: 50,50
boton: Cancelar
posicion: 150,50
```
y que cada línea de ```boton:``` cree un nuevo botón en secuencia, como ya se está haciendo.
### 3. Expansión futura con más elementos: Estás a un paso de admitir:
* ```label: Bienvenido```
* ```textfield: Nombre```
* ```evento: boton Cancelar => cerrar```
### 4. Mensajes de error más expresivos: 
Podrías resaltar en el ```statusLabel``` qué línea exacta falló. Algo como:
```java
throw new IllegalArgumentException("Línea inválida [" + line + "]: " + e.getMessage());
```
> ### Nota
> diseñar en el futuro una arquitectura extensible tipo ```Command -> Action``` usando un ```Map<String, Consumer<String>>```
> para darle modularidad al parser. Sería una evolución elegante y le daría un nivel de control fascinante para un
> ```DSL``` visual.
___
AQUI VA EL LINK DEL FORMATO INCORRECTO USE X,Y.
___
## 🔍 Recomendaciones para mejorar la tolerancia del parser:
### 1. Permitir espacios opcionales:

```java
import java.util.regex.Pattern;

Pattern pattern = Pattern.compile("(\\d+)\\s*,\\s*(\\d+)");
```
### Eso soporta:
```text
posicion: 100 , 200
```
o...
```text
posicion: 100,200
```
### 2. Agregar validación más precisa con contexto:
```java
throw new IllegalArgumentException("Formato de posición incorrecto en: '" + line + "'. Use X,Y");
```