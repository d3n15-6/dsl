# Clase WindowCommandProcessor
```java
import javafx.scene.control.Label; 
import javafx.scene.Node; 
import javafx.scene.layout.Pane; 
import javafx.stage.Stage; 
import java.util.Map; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

public class WindowCommandProcessor implements CommandProcessor { 
    @Override 
    public Node process(String line, Pane currentContainer, Map<String, Object> properties, Label statusLabel) 
            throws IllegalArgumentException { 
        // Ejemplo: "ventana: Mi App" 
        String title = line.substring("ventana:".length()).trim(); 
        properties.put("windowTitle", title); 
        return null; // Este comando no crea un nodo de UI 
    } 
}
```
Este ```WindowCommandProcessor``` es perfecto como primera implementación! Encapsulá la lógica específica de un comando 
de forma limpia. Sienta las bases para una arquitectura totalmente ```modular``` y ```extensible```.
___
## ✨ Pequeños refinamientos
### 1. Validación adicional opcional:
* Podrías validar que el título no esté vacío, y dar feedback directo:
```java
if (title.isEmpty()) {
    throw new IllegalArgumentException("El título de la ventana no puede estar vacío.");
}
```
### 2. Uso opcional del statusLabel para feedback silencioso:
* Si quero mostrar al usuario lo que va interpretando el ```DSL```:
```java
statusLabel.setText("Título de ventana definido: \"" + title + "\"");
```
Claro, que si hay  muchas capas de ```feedback```, esto puede ser redundante — es solo para reforzar trazabilidad en vivo.
___
> ### Nota
> **En resumen**: Una interfaz impecable, y esta implementación cumple su rol a la perfección. 
> Seguimos con:
> * ```DimensionCommand```
> * ```ColorCommand```
> * ```ButtonCommand```: con lógica de acción.
___

# ⚙️ Propiedades de una ventana en JavaFX
### La ventana (```Stage```) en JavaFX
* El ```Stage``` tiene varias propiedades que podemos configurar, además del ```título```, ```dimensiones```, y 
```escena``` que ya manejamos. No es obligatorio definirlas todas desde el inicio — podemos agregarlas al ```DSL``` 
más adelante según la expresividad que se quiere lograr.
### 🪟 Propiedades más útiles y visualmente interesantes del ```Stage```
| Propiedades | Qué hace                                                 | Ejemplo DSL (si quisiera incluirlo) |
|-------------|----------------------------------------------------------|-------------------------------------|
|```resizable```| Permite o bloquea el cambio de tamaño de la ventana      | ```resizable: no```                 |
|```fullscreen```| Modo pantalla completa                                   | ```pantalla completa: si```         |
|```iconified```| Minimiza la ventana al inicio                            | ```minimizar al iniciar: si```      |
|```alwaysOnTop```| Mantiene la ventana siempre al frente                    | ```siempre visible: si```           |
|```opacity```| Define la opacidad(0.0 - 1.0)                            | ```opacidad: 0.85```                |
|```X``` y ```Y```| Posición inicial en pantalla                             | ```posicion ventana: 100, 200```    |
|```icon```| Icono de la ventana (archivo```.png```,```.icon```, etc) |```icono: ruta/carpeta/icono.png```|
|```style```|Estilo de ventana(```DECORATED```, ```UNDECORATED```, etc)|```estilo: undecorated```|
___
> ### Nota
> No necesitas incluir todo esto ahora. Puedes ir activando propiedades progresivamente según lo pida el ```DSL```, así  
> se mantiene la curva de aprendizaje suave y el código limpio.

___ 
## Esto es parte del [CHANGELOG]
### ```WindowCommandProcessor``` - ```setText()```
Este método del ```windowcommandoprocessor``` ya está muy bien, pero para incorporar un _feedback visual inmediato_ 
para reforzar lo que el ```DSL``` está entendiendo, añadir una línea con ```statusLabel.setText(...)``` justo después 
de guardar el título. 
### Por ejemplo:
```java
statusLabel.setText("✔️ Título asignado: \"" + title + "\"");
```
Entonces el método quedaría así:
```java
@Override 
public Node process(String line, Pane currentContainer, Map<String, Object> properties, Label statusLabel) 
        throws IllegalArgumentException { 
    // Ejemplo: "ventana: Mi App" 
    String title = line.substring("ventana: ".length()).trim(); 
    if (title.isEmpty()) { 
        throw new IllegalArgumentException("El título de la ventana no puede estar vacío."); 
    } 
    properties.put("windowTitle", title);
    statusLabel.setText("✔️ Título asignado: \"" + title + "\"");
    return null; // Este comando no crea un nodo de UI. 
    }
```
Esto mantiene el sistema amigable y transparente. Se debe aplicar este patrón al resto de los comandos (
```dimensiones```, ```color```, ```posicion```, etc.), también podemos implementar el uso de íconos como ⚠️ o ❌ para
```errores```, o 🟢 para ```confirmaciones```.
___
## Esto es parte del [CHANGELOG] - 
### ```WindowCommandProcessor``` - ```substring()```
En este bloque:
```java
String title = line.substring("ventana: ".length()).trim();
```
Hay un espacio extra dentro del string ```"ventana: "```. Es decir, el ```substring``` está calculando la longitud de
```"ventana: "``` (_con espacio_), pero si en el ```input``` del usuario usa ```"ventana:Mi App"``` (sin espacio después
de los dos puntos), quedará con un título que empieza con ```i App``` o directamente lanzar un ```error``` si no hay
suficientes caracteres.
### ✅ Solución sugerida:
Para hacer el código más robusto y tolerante a espacios opcionales, debemos reemplazar esa lógica con un ```replaceFirst```
que elimine el prefijo sin depender de la ```longitud``` exacta:
```java
String title = line.replaceFirst("^ventana:\\s*", "").trim();
```
Eso eliminará el prefijo ```ventana:``` y cualquier cantidad de espacios después de los ```:```, permitiendo entrada 
como:
* ```ventana: Mi App```
* ```ventana:Mi App```
* ```ventana: Mi App```
___
