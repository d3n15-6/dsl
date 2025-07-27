# DSL - Domain-Specific Language
Un lenguaje ```DSL``` ***(Domain-Specific Language)*** *"universal"* suena como una contradicción, ¿verdad?.
Por definición, los ```DSL``` están diseñados para dominios específicos, pero si queremos que uno sea ampliamente 
adaptable, podemos enfocarnos en ciertas cualidades universales. Aquí van algunas claves para lograrlo:

### 1. Simplicidad y legibilidad
El lenguaje debe ser intuitivo y cercano a la forma en que piensan los humanos en ese dominio. Cuanto menos ambigüedad 
y más expresividad directa, mejor. 
#### Ejemplo:
```Yaml
Button: 
  Text: "Aceptar"
  onClick: cerrarVentana
```
### 2. Extensibilidad modular
Un ```DSL``` poderoso debe permitir que los usuarios lo amplíen o personalicen sin romper las reglas del lenguaje. 
Piensa en definiciones anidadas, bloques composables y plantillas reutilizables.
### 3. Abstracción sobre implementación
Que se enfoque en ___qué se quiere lograr, no cómo se logra___. El ```DSL``` debe esconder la complejidad técnica detrás
de construcciones elegantes.
### 4. Compatibilidad con distintos entornos
Un DSL más *“universal”* gana mucho si puede exportar o integrarse con diversos frameworks, entornos o lenguajes host, 
como ```Java```, ```JavaScript``` o ```Python```.
### 5. Internacionalización y localización
El soporte para distintos idiomas, no solo en contenido, sino en la propia sintaxis, puede abrir la puerta a comunidades 
más diversas.

## Transformar un lenguaje de programación en DSL.
Transformar el lenguaje ```Java``` y ```JavaFX``` en un lenguaje ```DSL``` legible que hasta un niño pueda usarlo es 
como mezclar pedagogía, diseño técnico.<p>
El lenguaje propuesto para un ```DSL``` visual y expresivo llamado **DSLEngine**, pensado para ser claro, directo, y 
fácilmente adaptable a estructuras ```JavaFX```. Y lo mejor:<p> 
>___¡suena como si estuvieras hablando con tu computadora!___

## 🧠 Traducción de lenguaje Java/JavaFX a "DSLEngine"
| Java/JavaFx            | Lenguaje DSL       |
|------------------------|--------------------|
| ```Stage```            | ```Ventana```      |
| ```Scene```            | ```Pantalla```     |
| ```VBox``` / ```HBox``` | ```Fila``` / ```Columna```|
| ```Button```           | ```Botón```        |
| ```Label```            | ```Etiqueta```     |
| ```setOncAction```     | ```cuandoClic```   |
| ```setText```          | ```Texto```        |

___
## ✨ Ejemplo de script en estilo DSL
```yaml
Ventana:
  titulo: "Hola mundo"
  tamaño: 400, 200
  Pantalla:
    Columna:
      - Texto: "Bienvenido a DSLEngine"
      - Boton:
          Texto: "Haz clic!"
          cuandoClic: mostrarSaludo
Funciones:
  mostrarSaludo:
    hacer:
      - mostrar: "Hola desde tu primera app DSL!"
```
## 🛠️ ¿Y cómo traduce el motor DSL a lenguaje JavaFX?
Internamente, tú o tu motor ```DSL``` interpretan esto y generan código ```JavaFX``` como:
```java
Label label = new Label("Bienvenido a MiniFX");
Button boton = new Button("¡Haz clic!");
boton.setOnAction(e -> {
    System.out.println("¡Hola desde tu primera app DSL!");
});
VBox columna = new VBox(label, boton);
Scene scene = new Scene(columna, 400, 200);
Stage ventana = new Stage();
ventana.setTitle("Hola Mundo");
ventana.setScene(scene);
ventana.show();
```

___
## Clases, Propiedades y Métodos comunes de JavaFX
### 📦 Controles y Componentes
| JavaFx              | Lenguaje DSL       |
|---------------------|--------------------|
| ```Button```        | ```Boton```        |
| ```Label```         | ```Etiqueta```     |
| ```TextField```     | ```Texto```        |
| ```PasswordField``` | ```TextoSecreto``` |
| ```CheckBox```      | ```Casilla```      |
| ```RadioButton```   | ```Opcion```       |
| ```ListView```      | ```Lista```        |




