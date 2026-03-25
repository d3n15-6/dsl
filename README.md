# DSL Engine 🚀

> Motor de lenguaje específico de dominio (DSL) extensible, ligero y diseñado para crear lógica dinámica de forma simple y poderosa.

---

### 🧠 ¿Qué es esto?

DSL Engine es un motor que te permite crear y ejecutar un lenguaje de programación simplificado (DSL).

Con este proyecto puedes:

- Definir sintaxis simplificadas
- Ejecutar lógica dinámica sin recompilar
- Crear sistemas configurables
- Extender funcionalidades mediante plugins

---

### ⚙️ Características principales

- 🧩 Parser de DSL personalizable
- ⚡ Motor de ejecución dinámico
- 🔌 Arquitectura basada en plugins
- 🧠 Registro de funciones extensible
- ✏️ Modificación de sintaxis en tiempo de ejecución

---

### 🏗️ Arquitectura

El sistema se compone de:

#### 1. DSL Engine
Encargado de interpretar y ejecutar el lenguaje.

#### 2. Sistema de Plugins
Permite extender:
- Funciones
- Sintaxis
- Comportamiento

#### 3. Function Registry
Registro donde se definen las funciones disponibles dentro del DSL.

#### 4. Syntax Modifier
Permite modificar o extender la gramática del lenguaje.

---

### 🔌 Sistema de Plugins

```java
public interface DslPlugin {
    void initialize(DslPluginContext context);
}
```
---

El contexto permite acceso a:

- Motor DSL
- Registro de funciones
- Modificadores de sintaxis

---

### 📦 Casos de uso

- Motores de reglas (rule engines)
- Automatización de procesos
- Sistemas configurables
- Plataformas low-code/no-code
- Scripting interno en aplicaciones

---

### 🧱 Estado del proyecto

    🚧 En desarrollo activo

---

### 📌 Roadmap

- Mejorar sintaxis del DSL
- Optimización del motor de ejecución
- Marketplace de plugins (futuro)
- Integración con editor visual (GlassFX Workbench)

---

### 🧑‍💻 Autor

Cesar Denis Balbuena

---

📜 Licencia

Copyright (c) 2026 Denis Balbuena

Todos los derechos reservados.
Este software es propietario y confidencial. No está permitido copiar, modificar, distribuir o utilizar este código sin autorización expresa.


