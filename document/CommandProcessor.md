# Interface CommandProcessor
```java
import java.util.Map;
/**
 * Interfaz para definir cómo se procesa un comando específico
 */
public interface CommandProcessor { 
    /**
     * Procesa una línea de comando y aplica las propiedades al Stage o al contenedor actual. 
     * @param line La línea de comando completa. 
     * @param currentContainer El contenedor de JavaFX actual donde se deben añadir los elementos (puede ser null para comandos de ventana).
     * @param properties Un mapa mutable donde se pueden almacenar propiedades globales (ej. ancho/alto de ventana). 
     * @param statusLabel La etiqueta para mostrar mensajes de estado/error. 
     * @return El nodo de UI creado o modificado, o null si el comando no crea un nuevo nodo. 
     * @throws IllegalArgumentException Si el formato del comando es incorrecto o hay un error de lógica. 
     * */ 
    Node process(String line, Pane currentContainer, Map<String, Object> properties, Label statusLabel) throws IllegalArgumentException;
}
```
### Esta interfaz está muy bien pensada: 
Es clara, modular y lista para ser el corazón de una arquitectura extensible tipo **Command-Driven UI** ```DSL```. 
Incluye al statusLabel como canal para ```feedback``` visual directo: eso revela el enfoque ```UI-first``` con 
trazabilidad.
___
## 🌱 Potenciales implementaciones
Podrías tener clases futuras como:
```java
public class WindowTitleCommand implements CommandProcessor {
    @Override
    public Node process(String line, Pane container, Map<String, Object> props, Label status) {
        String title = line.substring("ventana:".length()).trim();
        props.put("windowTitle", title);
        return null;
    }
}
```
o agruparlos via registros...
```java
Map<String, CommandProcessor> processors = Map.of(
    "ventana:", new WindowTitleCommand(),
    "dimensiones:", new DimensionCommand(),
    "boton:", new ButtonCommand(),
    "posicion:", new PositionCommand()
);
```
Con esto se puede recorrer cada linea y ejecutar segun el prefijo:
```java
for (String line : lines) {
    for (Map.Entry<String, CommandProcessor> entry : processors.entrySet()) {
        if (line.startsWith(entry.getKey())) {
            Node result = entry.getValue().process(line, currentContainer, props, status);
            if (result != null) currentContainer.getChildren().add(result);
            break;
        }
    }
}
```
___
## 🧠 Bonus: Flujo contextual
### En comandos como ```posicion```: 
* podrías usar una clave como ```lastNode``` en el mapa de propiedades para recordar el
nodo anterior:
```java
props.put("lastNode", newButton);
```
Así, ```PositionCommand``` puede extraer eso y aplicarle ```setLayoutX/Y```.
___
> ### Nota
> En resumen: Vamos por buena camino para un ```framework DSL``` declarativo. <p>
> Escribir un par de implementaciones concretas de ```CommandProcessor```, o a generar una base de carga dinámica que 
> escanee clases anotadas para registrar comandos automáticamente.
___