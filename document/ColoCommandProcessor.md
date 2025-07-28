Miércoles, 25 / junio / 2025
___
# Clase ColorCommandProcessor
```java
package com.dslengine.commandprocessor;

import javafx.scene.Node; 
import javafx.scene.control.Label; 
import javafx.scene.layout.Pane; 
import javafx.scene.paint.Color; 
import java.util.Map; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
public class ColorCommandProcessor implements CommandProcessor { 
    /**  Procesa una līnea de comandos y aplica las propiedades al Stage o al contenedor actual. 
     *  @param line La linea de comando completa. 
     *  @param currentContainer El contenedor de JavaFX actual donde se deben añadir los elementos.
     *  @param properties Un mapa mutable donde se pueden almacenar propiedades globales (ejemplo: ancho/alto de ventana).
     *  @param statusLabel La etiqueta para mostrar mensajes de estado de error.
     *  @return El nodo UI creado o modificado, o null si el commando no crea un nuevo nodo.
     *  @throws IllegalArgumentException Si el formato del documento es incorrecto o hay un error de lógica. 
     */ 
    @Override 
    public Node process(String line, Pane currentContainer, Map<String, Object> properties, Label statusLabel) 
            throws IllegalArgumentException { 
        // Ejemplo 1: "color RGB:255,255,0" 
        // Ejemplo 2: "color RGB: 255,255,0" 
        // Ejemplo 3: "color RGB:255,255, 0" 
        // Ejemplo 4: "color RGB:255, 255, 0" 
        // Ejemplo 5: "color RGB: 255, 255, 0" 
        Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*"); 
        Matcher matcher = pattern.matcher(line); 
        if (matcher.find()) { 
            int r = Integer.parseInt(matcher.group(1)); 
            int g = Integer.parseInt(matcher.group(2)); 
            int b = Integer.parseInt(matcher.group(3)); 
            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) { 
                throw new IllegalArgumentException(); 
            } 
            properties.put("panelColor", Color.rgb(r, g, b)); 
        } else { 
            throw new IllegalArgumentException("Formato de color RGB incorrecto '" + line + "'. Use R, G, B"); 
        } 
        return null; 
    } 
}
```
## Esto es parte del [CHANGELOG] -
### ```WindowCommandProcessor``` - ```match```
```java
Pattern pattern = Pattern.compile("(\\d+),(\\d+),(\\d+)"); 
Matcher matcher = pattern.matcher(line);
```
El código funciona para entradas con **comas** entre los valores RGB como:
```text
color RGB: 255,255,0
```
Para soportar espacios opcionales, debemos ajustar la expresión regular así:
```java
Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)");
```
Esta versión permite:
* ```color RGB:255,255,0```
* ```color RGB:255, 255, 0```
* ```color RGB:255 ,255 ,0```
* ```color RGB: 255,255,0```
* ```color RGB: 255, 255, 0```
* ```color RGB: 255 ,255 ,0```

Y cualquier combinación con o sin espacios alrededor de las comas.
```java
Matcher matcher = pattern.matcher(line);
if (matcher.find()) {
    int r = Integer.parseInt(matcher.group(1));
    int g = Integer.parseInt(matcher.group(2));
    int b = Integer.parseInt(matcher.group(3));
    // validación, construcción del Color, etc.
}
```
Luego el resto queda igual.

> ### Nota
> También podemos hacer que el comando acepte guiones (255-255-0) o incluso espacios (255 255 0) para que el  ```DSL```
> sea más tolerante.
___
## Esto es parte del [CHANGELOG] -
### ```WindowCommandProcessor``` - [```replaceFirst()```](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#replaceFirst-java.lang.String-java.lang.String-)
La modificación evita un error de escritura como ```color RGB: , 255, 255``` y haga que explote en un
[```StringIndexOutOfBoundsException```](https://docs.oracle.com/javase/8/docs/api/java/lang/StringIndexOutOfBoundsException.html) o un [```NumberFormatException```](https://docs.oracle.com/javase/8/docs/api/java/lang/NumberFormatException.html)
```java
Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)");
```
Sin embargo, cuidado con la expresión:
```java
"\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)"
```
Sigue esperando **tres números**, separados por coma con o sin espacios alrededor. La parte ```\\s*``` al principio
```no sustituye``` al prefijo ```"color RGB:"```, por lo que se necesita extraer solo la parte de los números.<p>
Una forma más clara sería usar [```replaceFirst()```](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#replaceFirst-java.lang.String-java.lang.String-) para eliminar el prefijo:
```java
String rgbPart = line.replaceFirst("^color RGB:\\s*", "").trim();
Pattern pattern = Pattern.compile("(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)");
Matcher matcher = pattern.matcher(rgbPart);
```
Esto te da más control, y hace que él ```regex``` no tenga que lidiar con el prefijo completo.
> [!NOTE]
>