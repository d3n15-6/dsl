### paso a paso para integrarlo al ide workbench (proyecto gradle).
#### 1. instalar el motor dsl en el repositorio local maven.
Abrir la terminal en el directorio del motor DSL (donde está él ```pom.xml```) y ejecutar.
```bash
./gradlew build --info
```
Este comando compila y coloca el ```.jar``` en tu repositorio local:
📁```~/.m2/repository/com/dslengine/dsl/1.0-SNAPSHOT/dsl-1.0-SNAPSHOT.jar```

