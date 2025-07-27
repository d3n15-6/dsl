```java
@Override 
public Node process(String line, Pane currentContainer, Map<String, Object> properties, Label statusLabel) 
        throws IllegalArgumentException { 
    // Ejemplo: "ventana: Mi App" 
    String title = line.substring("ventana: ".length()).trim(); 
    if (title.isEmpty()) { 
        throw new IllegalArgumentException("El título de la ventana no puede estar vacío."); } properties.put("windowTitle", title); return null; 
        // Este comando no crea un nodo de UI. 
    }
```
