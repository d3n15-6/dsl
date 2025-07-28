Martes, Jun 24
___

```shell
/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java 
-agentlib:jdwp=transport=dt_socket,address=127.0.0.1:53789,suspend=y,server=n -javaagent:
/Users/julietacristaldo/Library/Caches/JetBrains/IdeaIC2024.2/captureAgent/debugger-agent.jar 
-Dkotlinx.coroutines.debug.enable.creation.stack.trace=false -Ddebugger.agent.enable.coroutines=true 
-Dfile.encoding=UTF-8 
-classpath /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:
/Users/julietacristaldo/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:
/Users/julietacristaldo/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:
/Users/julietacristaldo/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar:
/Applications/IntelliJ IDEA 
CE.app/Contents/lib/idea_rt.jar -p /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-mac.jar:
/Users/julietacristaldo/IdeaProjects/dsl/target/classes:
/Users/julietacristaldo/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-mac.jar:
/Users/julietacristaldo/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-mac.jar:
/Users/julietacristaldo/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-mac.jar -m 
com.dslengine.dslui/com.dslengine.dslui.DslApp 
Connected to the target VM, 
address: '127.0.0.1:53789', transport: 'socket' 
Exception in Application start method java.lang.reflect.InvocationTargetException 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) 
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
at javafx.graphics/com.sun.javafx.application.LauncherImpl.launchApplicationWithArgs(LauncherImpl.java:465) 
at javafx.graphics/com.sun.javafx.application.LauncherImpl.launchApplication(LauncherImpl.java:364) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) 
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
at java.base/sun.launcher.LauncherHelper$FXHelper.main(LauncherHelper.java:1091) 
Caused by: java.lang.RuntimeException: Exception in Application start method 
at javafx.graphics/com.sun.javafx.application.LauncherImpl.launchApplication1(LauncherImpl.java:901) 
at javafx.graphics/com.sun.javafx.application.LauncherImpl.lambda$launchApplication$2(LauncherImpl.java:196) 
at java.base/java.lang.Thread.run(Thread.java:842) 
Caused by: javafx.fxml.LoadException: 
/Users/julietacristaldo/IdeaProjects/dsl/target/classes/com/dslengine/dslui/UIBuilder.fxml:11 
at javafx.fxml/javafx.fxml.FXMLLoader.constructLoadException(FXMLLoader.java:2714) 
at javafx.fxml/javafx.fxml.FXMLLoader$ValueElement.processAttribute(FXMLLoader.java:933) 
at javafx.fxml/javafx.fxml.FXMLLoader$InstanceDeclarationElement.processAttribute(FXMLLoader.java:981) 
at javafx.fxml/javafx.fxml.FXMLLoader$Element.processStartElement(FXMLLoader.java:230) 
at javafx.fxml/javafx.fxml.FXMLLoader$ValueElement.processStartElement(FXMLLoader.java:755) 
at javafx.fxml/javafx.fxml.FXMLLoader.processStartElement(FXMLLoader.java:2845) 
at javafx.fxml/javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2641) 
at javafx.fxml/javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2555) 
at javafx.fxml/javafx.fxml.FXMLLoader.load(FXMLLoader.java:2523) 
at com.dslengine.dslui/com.dslengine.dslui.DslApp.start(DslApp.java:17) 
at javafx.graphics/com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$9(LauncherImpl.java:847) 
at javafx.graphics/com.sun.javafx.application.PlatformImpl.lambda$runAndWait$12(PlatformImpl.java:484) 
at javafx.graphics/com.sun.javafx.application.PlatformImpl.lambda$runLater$10(PlatformImpl.java:457) 
at java.base/java.security.AccessController.doPrivileged(AccessController.java:399) 
at javafx.graphics/com.sun.javafx.application.PlatformImpl.lambda$runLater$11(PlatformImpl.java:456) 
at javafx.graphics/com.sun.glass.ui.InvokeLaterDispatcher$Future.run$$$capture(InvokeLaterDispatcher.java:96) 
at javafx.graphics/com.sun.glass.ui.InvokeLaterDispatcher$Future.run(InvokeLaterDispatcher.java) 
Caused by: java.lang.ClassNotFoundException: UIBuilderController 
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) 
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) 
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:525) 
at javafx.fxml/javafx.fxml.FXMLLoader$ValueElement.processAttribute(FXMLLoader.java:931) ... 
15 more Exception running application com.dslengine.dslui.DslApp 
Disconnected from the target VM, address: '127.0.0.1:53789', transport: 'socket' 

Process finished with exit code 1
```
El error se debe a que ```JavaFX``` no puede encontrar la clase ```UIBuilderController``` mencionada como controlador en
el archivo ```UIBuilder.fxml``` (```línea 11```). Aquí hay algunas posibles causas y soluciones:
___
## ✅ Posibles causas
1. **La clase no se ha compilado** o **no está en el ```classpath```** Asegúrate de que ```UIBuilderController.java``` exista y 
esté correctamente compilado dentro de ```target/classes```.
2. **Nombre de clase** o **paquete incorrecto** El atributo ```fx:controller``` en tu archivo ```FXML``` debe tener el 
nombre completamente calificado, por ejemplo:
```xml 
fx:controller="com.dslengine.dslui.UIBuilderController"
```
3. **Está en una carpeta equivocada** Verifica que el archivo esté en ```src/main/java``` y no en ```src/test/java``` u 
en otra carpeta que no se incluya en la compilación.
4. **Problemas con ```IntelliJ```** o **el sistema de construcción** A veces, ```IntelliJ``` puede tener cachés corruptos.
Intenta:
   * Ir a ```Build``` > ```Rebuild Project```
   * ```File > Invalidate Caches / Restart```

## 🔍 Checklist de verificación
* ¿Existe ```UIBuilderController.java```?
* ¿Está en el paquete correcto y es pública?
* ¿Compila correctamente al construir el proyecto?
* ¿El ```FXML``` tiene bien el atributo ```fx:controller```?

> La coincidencia exacta del nombre de clase totalmente calificado en el atributo ```fx:controller``` suele ser el 
> culpable en ese tipo de errores.

___
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextArea?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.layout.VBox?>
<?import javafx.geometry.Insets?>
<?import javafx.scene.layout.HBox?>

<BorderPane xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1"
            fx:controller="com.dslengine.dslui.UIBuilderController">
   <top>
      <VBox spacing="10" alignment="CENTER" BorderPane.alignment="CENTER">
         <padding>
            <Insets top="20" right="20" bottom="20" left="20"/>
         </padding>
         <Label text="Escribe tus comandos de UI aquí:"/>
         <TextArea fx:id="commandTextArea" prefHeight="200"
                   promptText="Ej:&#10;ventana: Mi App&#10;dimensiones: 600x400&#10;panel: principal&#10;color RGB: 255-0-0&#10;boton: ClickMe&#10;posicion: 50,50"/>
         <HBox spacing="10" alignment="CENTER">
            <Button text="Generar Ventana" onAction="#generateWindow"/>
            <Button text="Limpiar Terminal" onAction="#clearTerminal"/>
         </HBox>
      </VBox>
   </top>
   <center>
      <VBox alignment="CENTER" BorderPane.alignment="CENTER">
         <Label text="La ventana generada aparecerá aquí."/>
         <Label fx:id="statusLabel" textFill="RED"/>
      </VBox>
   </center>
</BorderPane>
```
___

## ¿Por qué ```generateWindow``` me marca error?
Si ```clearTerminal``` funciona pero ```generateWindow``` aparece en rojo, lo más probable es que el método 
```generateWindow``` **no esté declarado** o **esté mal escrito en tu clase** ```UIBuilderController```.
## 🔍 Checklist rápido:
### 1. ¿Existe el método?<p>
Asegurate de que en ```UIBuilderController.java``` tengas esto declarado:
```java
@FXML
private void generateWindow(ActionEvent event) {
    // tu lógica aquí
}
```
### 2. ¿Está anotado con `````@FXML`````?<p>
Sin la anotación, él ```FXMLloader``` no lo reconocerá como manejador del evento.
### 3. ¿Importaste correctamente ```javafx.event.ActionEvent```?<p> 
Es fácil olvidarlo si estás usando imports automáticos.
### 4. ¿Clase y método están ```public``` si estás probando algo fuera de lo común?<p>
Técnicamente no tiene que ser ```public```, pero depende de la configuración.
### 5. ¿El método está en la clase correcta?<p>
Que no esté por error en otra clase, o duplicado con una versión diferente.

> ### Nota:
> Como el ```DSL``` tiene un enfoque modular y expresivo, también podría considerar delegar el análisis de comandos a 
> una clase auxiliar para que ```UIBuilderController``` sea más limpio.
___
## El ```generateWindow``` no tiene el manejador de eventos ```@FXML```.<p>
Para que el método ```generateWindow``` sea reconocido desde el ```FXML```, necesitás agregar dos cosas fundamentales:
1. **La anotación** ```@FXML``` para que el loader de ```FXML``` sepa que puede acceder al método.
2. **El parámetro** ```ActionEvent```, que es lo que ```JavaFX``` le pasa cuando se dispara el evento desde un botón.

Así debería lucir:
```java
@FXML
private void generateWindow(javafx.event.ActionEvent event) {
    // tu lógica aquí
}
```
Una vez que lo agregues, ya debería compilar y ejecutarse sin  problema y sin que te marque error.
___

## El método ```clearTerminal``` no tiene ActionEvent
En ```JavaFX```, cuando declarás un método en el ```FXML``` usando ```onAction="#..."```, el parámetro ```ActionEvent```
es opcional desde el punto de vista del ```Runtime```. Es decir, ```JavaFX``` acepta métodos que:
* ### No tienen parámetros
```java
@FXML
private void clearTerminal() {
    // válido
}
```
* ### Tiene un único parámetro de tipo ```ActionEvent```
```java
@FXML
private void generateWindow(ActionEvent event) {
    // también válido
}
```
Lo que es obligatorio es que:
1. El método exista.
2. Tenga visibilidad adecuada (```private```).
3. Esté anotado con ```@FXML```.

Entonces, si ```clearTerminal()``` funciona sin ```ActionEvent```, es perfectamente válido. Y si no necesitás acceder 
al evento o al botón que lo disparó, podés omitir el parámetro sin drama.

> ### Nota 
> En cambio, si vas a necesitar saber quién activó el evento (por ejemplo, si tenés múltiples botones que llaman 
> al mismo método), ahí sí conviene incluir ```ActionEvent``` para acceder a ```event.getSource()``` o 
> ```event.getTarget().```
___