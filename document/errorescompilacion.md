```shell
java.lang.IllegalArgumentException:
 
Formato de posición incorrecto. Use X,Y. 

at com.dslengine.dslui/com.dslengine.dslui.UIBuilderController.generateWindow(UIBuilderController.java:99) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) 
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
at com.sun.javafx.reflect.Trampoline.invoke(MethodUtil.java:77) 
at jdk.internal.reflect.GeneratedMethodAccessor2.invoke(Unknown Source) 
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
at javafx.base/com.sun.javafx.reflect.MethodUtil.invoke(MethodUtil.java:275) 
at javafx.fxml/com.sun.javafx.fxml.MethodHelper.invoke(MethodHelper.java:84) 
at javafx.fxml/javafx.fxml.FXMLLoader$MethodHandler.invoke(FXMLLoader.java:1854) 
at javafx.fxml/javafx.fxml.FXMLLoader$ControllerMethodEventHandler.handle(FXMLLoader.java:1724) 
at javafx.base/com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:86) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:234) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191) 
at javafx.base/com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
at javafx.base/com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:49) 
at javafx.base/javafx.event.Event.fireEvent(Event.java:198) 
at javafx.graphics/javafx.scene.Node.fireEvent(Node.java:8792) 
at javafx.controls/javafx.scene.control.Button.fire(Button.java:203) 
at javafx.controls/com.sun.javafx.scene.control.behavior.ButtonBehavior.mouseReleased(ButtonBehavior.java:208) 
at javafx.controls/com.sun.javafx.scene.control.inputmap.InputMap.handle(InputMap.java:274) 
at javafx.base/com.sun.javafx.event.CompositeEventHandler$NormalEventHandlerRecord.handleBubblingEvent(CompositeEventHandler.java:247) 
at javafx.base/com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:80) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:234) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191) 
at javafx.base/com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:54) 
at javafx.base/javafx.event.Event.fireEvent(Event.java:198) 
at javafx.graphics/javafx.scene.Scene$MouseHandler.process(Scene.java:3897) 
at javafx.graphics/javafx.scene.Scene.processMouseEvent(Scene.java:1878) 
at javafx.graphics/javafx.scene.Scene$ScenePeerListener.mouseEvent(Scene.java:2623) 
at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:411) 
at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:301) 
at java.base/java.security.AccessController.doPrivileged(AccessController.java:399) 
at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler.lambda$handleMouseEvent$2(GlassViewEventHandler.java:450) 
at javafx.graphics/com.sun.javafx.tk.quantum.QuantumToolkit.runWithoutRenderLock(QuantumToolkit.java:424) 
at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler.handleMouseEvent(GlassViewEventHandler.java:449) 
at javafx.graphics/com.sun.glass.ui.View.handleMouseEvent(View.java:557) 
at javafx.graphics/com.sun.glass.ui.View.notifyMouse(View.java:943) 
at javafx.graphics/com.sun.glass.ui.mac.MacView.notifyMouse(MacView.java:127) java.lang.IllegalArgumentException:

Formato de posición incorrecto. Use X,Y. 

at com.dslengine.dslui/com.dslengine.dslui.UIBuilderController.generateWindow(UIBuilderController.java:99) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) 
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) 
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
at com.sun.javafx.reflect.Trampoline.invoke(MethodUtil.java:77) 
at jdk.internal.reflect.GeneratedMethodAccessor2.invoke(Unknown Source) 
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
at javafx.base/com.sun.javafx.reflect.MethodUtil.invoke(MethodUtil.java:275) 
at javafx.fxml/com.sun.javafx.fxml.MethodHelper.invoke(MethodHelper.java:84) 
at javafx.fxml/javafx.fxml.FXMLLoader$MethodHandler.invoke(FXMLLoader.java:1854) 
at javafx.fxml/javafx.fxml.FXMLLoader$ControllerMethodEventHandler.handle(FXMLLoader.java:1724) 
at javafx.base/com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:86) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:234) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191) 
at javafx.base/com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:49) 
at javafx.base/javafx.event.Event.fireEvent(Event.java:198) 
at javafx.graphics/javafx.scene.Node.fireEvent(Node.java:8792) 
at javafx.controls/javafx.scene.control.Button.fire(Button.java:203) 
at javafx.controls/com.sun.javafx.scene.control.behavior.ButtonBehavior.mouseReleased(ButtonBehavior.java:208) 
at javafx.controls/com.sun.javafx.scene.control.inputmap.InputMap.handle(InputMap.java:274) 
at javafx.base/com.sun.javafx.event.CompositeEventHandler$NormalEventHandlerRecord.handleBubblingEvent(CompositeEventHandler.java:247) 
at javafx.base/com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:80) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:234) 
at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191) 
at javafx.base/com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74) 
at javafx.base/com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:54) 
at javafx.base/javafx.event.Event.fireEvent(Event.java:198) 
at javafx.graphics/javafx.scene.Scene$MouseHandler.process(Scene.java:3897) 
at javafx.graphics/javafx.scene.Scene.processMouseEvent(Scene.java:1878) 
at javafx.graphics/javafx.scene.Scene$ScenePeerListener.mouseEvent(Scene.java:2623) 
at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:411) 
```
### 🚧 Error en la ejecución del script
Este ```stack trace``` revela que la excepción se lanza exactamente en la línea donde está intentando aplicar la 
posición a un nodo con formato ```X,Y```, pero el patrón no está haciendo match.
### 1. Probable causa:
En el ```DSL```, podrías estar ingresando algo como:
```text
posicion: 100 x 200
```
o ...
```text
posicion: 100-200
```
...y tu ```regex``` espera literalmente ````\d+,\d+````, es decir, números separados por coma, sin espacios. 
Así que esto es válido:
```text
posicion: 100,200
```
___
```shell
ventana: Mi Súper App Dinámica 
dimensiones: 700x500 
color RGB: 100, 149, 237 
pane: label: Hola mundo end pane
 /Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java 
 -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:50301,suspend=y,server=n 
 -javaagent:/Users/julietacristaldo/Library/Caches/JetBrains/IdeaIC2024.2/captureAgent/debugger-agent.jar 
 -Dkotlinx.coroutines.debug.enable.creation.stack.trace=false -Ddebugger.agent.enable.coroutines=true 
 -Dfile.encoding=UTF-8 
 -classpath /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6.jar:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6.jar:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6.jar:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6.jar:
 /Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar -p /Users/julietacristaldo/IdeaProjects/dsl/target/classes:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-base/17.0.6/javafx-base-17.0.6-mac.jar:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-graphics/17.0.6/javafx-graphics-17.0.6-mac.jar:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-fxml/17.0.6/javafx-fxml-17.0.6-mac.jar:
 /Users/julietacristaldo/.m2/repository/org/openjfx/javafx-controls/17.0.6/javafx-controls-17.0.6-mac.jar 
 -m com.dslengine.dslui/com.dslengine.dslui.DslApp 
 Connected to the target VM, address: '127.0.0.1:50301', transport: 'socket' 
 [] Pila de contenedores: 
 nivel 0: Pane 
 [↪] Nodo agregado: Label 
 [@] Nodo creado por label: Label 
 [↪] Nodo agregado: Button 
 [@] Nodo creado por boton: Button 
 [↪] Nodo agregado: TextField 
 [@] Nodo creado por textfield: TextField 
 [] Pila de contenedores: nivel 0: Pane 
 [] Pila de contenedores: nivel 0: Pane 
 [] Pila de contenedores: nivel 0: Pane 
 [↪] Nodo agregado: Label 
 [@] Nodo creado por label: Label 
 [»] Comando desconocido o incompleto: Pane 
 [»] Comando desconocido o incompleto: End Pane 
 [] Pila de contenedores: nivel 0: Pane 
 [↪] Nodo agregado: Pane [@] Nodo creado por pane: Pane 
 [↪] Nodo agregado: Label [@] Nodo creado por label: Label java.lang.IllegalArgumentException: 
 [»] Error de anidamiento: 'end pane' no coinciden con el contenedor actual. 
 at com.dslengine.dslui/com.dslengine.commandprocessor.GenericEndProcessor.process(GenericEndProcessor.java:32) 
 at com.dslengine.dslui/com.dslengine.dslui.UIBuilderController.generateWindow(UIBuilderController.java:129) 
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) 
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) 
 at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
 at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
 at com.sun.javafx.reflect.Trampoline.invoke(MethodUtil.java:77) 
 at jdk.internal.reflect.GeneratedMethodAccessor2.invoke(Unknown Source) 
 at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) 
 at java.base/java.lang.reflect.Method.invoke(Method.java:568) 
 at javafx.base/com.sun.javafx.reflect.MethodUtil.invoke(MethodUtil.java:275) 
 at javafx.fxml/com.sun.javafx.fxml.MethodHelper.invoke(MethodHelper.java:84) 
 at javafx.fxml/javafx.fxml.FXMLLoader$MethodHandler.invoke(FXMLLoader.java:1854) 
 at javafx.fxml/javafx.fxml.FXMLLoader$ControllerMethodEventHandler.handle(FXMLLoader.java:1724) 
 at javafx.base/com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:86) 
 at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:234) 
 at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191) 
 at javafx.base/com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59) 
 at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58) 
 at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
 at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
 at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
 at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
 at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
 at javafx.base/com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74) 
 at javafx.base/com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:49) 
 at javafx.base/javafx.event.Event.fireEvent(Event.java:198) 
 at javafx.graphics/javafx.scene.Node.fireEvent(Node.java:8792) 
 at javafx.controls/javafx.scene.control.Button.fire(Button.java:203) 
 at javafx.controls/com.sun.javafx.scene.control.behavior.ButtonBehavior.mouseReleased(ButtonBehavior.java:208) 
 at javafx.controls/com.sun.javafx.scene.control.inputmap.InputMap.handle(InputMap.java:274) 
 at javafx.base/com.sun.javafx.event.CompositeEventHandler$NormalEventHandlerRecord.handleBubblingEvent(CompositeEventHandler.java:247) 
 at javafx.base/com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:80) 
 at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:234) 
 at javafx.base/com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191) 
 at javafx.base/com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59) 
 at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58) 
 at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
 at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
 at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
 at javafx.base/com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56) 
 at javafx.base/com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114) 
 at javafx.base/com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74) 
 at javafx.base/com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:54) 
 at javafx.base/javafx.event.Event.fireEvent(Event.java:198) 
 at javafx.graphics/javafx.scene.Scene$MouseHandler.process(Scene.java:3897) 
 at javafx.graphics/javafx.scene.Scene.processMouseEvent(Scene.java:1878) 
 at javafx.graphics/javafx.scene.Scene$ScenePeerListener.mouseEvent(Scene.java:2623) 
 at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:411) 
 at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:301) 
 at java.base/java.security.AccessController.doPrivileged(AccessController.java:399) 
 at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler.lambda$handleMouseEvent$2(GlassViewEventHandler.java:450) 
 at javafx.graphics/com.sun.javafx.tk.quantum.QuantumToolkit.runWithoutRenderLock(QuantumToolkit.java:424) 
 at javafx.graphics/com.sun.javafx.tk.quantum.GlassViewEventHandler.handleMouseEvent(GlassViewEventHandler.java:449) 
 at javafx.graphics/com.sun.glass.ui.View.handleMouseEvent(View.java:557) 
 at javafx.graphics/com.sun.glass.ui.View.notifyMouse(View.java:943) 
 at javafx.graphics/com.sun.glass.ui.mac.MacView.notifyMouse(MacView.java:127)
```
### 🚧 Error en la ejecución del script
El error que se visualiza sugiere que el comando ```end pane``` no está cerrando correctamente el contenedor que tienes abierto es
decir, el ```DSL``` está esperando cerrar otro tipo de contenedor o el flujo se ha desalineado.<p>
### Revisar qué está pasando y cómo corregirlo.