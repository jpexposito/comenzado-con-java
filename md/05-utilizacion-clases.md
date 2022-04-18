# Utilización avanzada de clases

# ¿Diseño incorrecto?

- ¿Cómo sabemos si nuestro diseño es incorrecto?
    - las clases son difíciles de cambiar
    - las clases son difíciles de reutilizar
    - las clases son difíciles de usar
    - las clases tienen código repetido
    - las clases dejen de funcionar sin motivo aparente

# Mejorarlo: principios SOLID

----- --- --------------------------------------------- --------------------------------------------- ---------------- ----
**S** SRP (The **S**ingle Responsibility Principle      Las clases se diseñan sólo para un propósito. Tom DeMarco      1979
          o **Principio de Responsabilidad Única**)                                                   

**O** OCP (The **O**pen/Closed Principle                Las clases debe permitir ser extendidas,      Bertrand Meyer   1997
          o **Principio Abierto/Cerrado**)              sin necesidad de ser modificadas.             

**L** LSP (The **L**iskov Substitution Principle        Las clases padre siempre deben poder ser      Barbara Liskov   1988
          o **Principio de Sustitución de Liskov**)     sustituidas por sus clases hijas y viceversa.

**I** ISP (The **I**nterface Segregation Principle      Las clases no deben ser forzados a depender   Robert C. Martin 1995
          o **Principio de Segregación de Interfaces**) de interfaces con métodos que no utilizan.    

**D** DIP (The **D**ependency Inversion Principle       Los clientes deben delegar la gestión de      Martin Fowler    2004
          o **Principio de Inversión de Dependencias**) las instancias de objetos a las librerias.    
----- --- --------------------------------------------- --------------------------------------------- ---------------- ----

# ¿Cómo utilizar nuestras clases?

- **Colaboración**
    - Cuando 2 o más clases colaboran de distintas formas (ver teoría POO)
- **Herencia**
    - Cuando una clase hija extiende una clase padre.
- Error común
    - Aplicar herencia para todo.

# Herencia

- En Java no hay herencia múltiple pero una clase puede implementar varias Interfaces.
- Las **Interfaces** son clases que sólo definen métodos (comportamientos) y que obligan a las clases hijas a implementarlos.
- Las **clases abstractas** son clases que no se pueden instanciar, osea que sólo se pueden heredar. Implementan varios métodos, y definen otros como abstractos, obligando a las clases hijas a implementarlos.

# Clases padre y clases hijas

- El operador **this** hace referencia a la instancia concreta del objeto.
- El operador **super** hace referencia a la clase padre.
- Los métodos no marcados como final y/ como private,
se pueden sobreescribir en las clases hijas (**polimorfismo**).
