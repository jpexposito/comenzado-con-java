# Instalación y configuración del entorno Java

# Requisitos hardware (RAM)

- Si queremos utilizar un IDE como Eclipse:
    - Windows: mínimo 2 GB, recomendable 3 GB
    - Linux: mínimo 1 GB, recomendable 2 GB

# Requisitos mínimos

- **JDK** (Java Development Kit)
    - Imprescindible
- **IDE** (Integrated Development Environment)
    - Muy recomendable
        - Compilador
        - Autocompletado
        - Refactoring
        - Plugins
            - Chequeos
            - Testing
            - Control de versiones

# Requisitos recomendados

- Control de versiones (SVN, Git)
      - Historial del código
      - Crear y unir ramas
      - Versionado
- Gestión y empaquetamiento (Ant, Maven)
      - Compilación
      - Chequeo
      - Testing
      - Empaquetamiento
- Integración continua (Hudson, Jenkins)
      - Lo anterior, cada vez que hay un cambio

# Instalación en Windows

- Descargar el JDK de:
    - <http://www.oracle.com/technetwork/java/javase/downloads/index.html>
- Instalar el JDK de:
    - Siguiente, siguiente, siguiente...
- Descargar Eclipse:
    - <http://eclipse.org/downloads/>
- Descomprimir Eclipse en una carpeta:
    - Botón derecho, descomprimir...

# Instalación en Linux

- Abrir gestor de paquetes
- Instalar Eclipse (con sus dependencias)
- **Así de fácil**

# Configuración

- Hoy en día, en principio, no hay que hacer nada.
- Único problema: tener varías JDK, JRE instaladas.
- En este último caso comprobar las variables de entorno:
    - **PATH**: dónde busca los ejecutables el sistema
    - **CLASSPATH**: dónde busca la MV las clases del sistema
