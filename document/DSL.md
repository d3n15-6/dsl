## DSL - Domain-Specific Language
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
