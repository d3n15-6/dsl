Sábado, Jun 28

---
¿Qué tendrías que hacer para mantener el contexto de ```nesting```?
En el ```UIBuilderController```, cada vez que se procesa una línea, podés hacer:
```java
Pane container = (Pane) globalProperties.getOrDefault("currentContainer", currentRootPane); 
Node createdNode = processor.process(line, container, globalProperties, statusLabel);
```
Y si el ```VBoxStartProcessor``` actualiza currentContainer, lo heredan los comandos que vienen después (hasta que hagas
un ```end``` o lo resetees manualmente).<p>
🧩Esta técnica es una forma muy elegante y extensible de manejar estructuras anidadas (```nesting```) en un flujo 
declarativo como el de ```DSL```. y aquí vamos a desglosarlo paso a paso:
___

### 🧠 ¿Qué significa mantener el contexto de ```nesting```?
En interfaces jerárquicas (como las creadas con ```VBox```, ```HBox```, etc.), se necesita saber “dónde” agregar cada 
nuevo nodo.<p>
Esa ubicación —**el contenedor actual**— puede cambiar dinámicamente a medida que va interpretando el ```DSL```.
___

### 🧱 Bloque del código
```java
Pane container = (Pane) globalProperties.getOrDefault("currentContainer", currentRootPane);
Node createdNode = processor.process(line, container, globalProperties, statusLabel);
```
1. ```currentContainer```: es una propiedad global que guarda en qué contenedor estamos trabajando actualmente. 
Por ejemplo, si abrimos un VBox, esa referencia se guarda ahí.
2. ```getOrDefault(...)```: si no se ha establecido aún un ```currentContainer```, usamos ```currentRootPane``` como 
fallback. Ideal para comenzar en la ```raíz```.
3. ```processor.process(...)```: cada línea del ```DSL``` se procesa con el contenedor actual, y se le pasa el contexto 
completo (```globalProperties```) para que pueda modificarlo si es necesario (como al abrir un nuevo ```VBox```).
___


