# Library Manager Java 📚

> 🚧 **Proyecto en desarrollo activo** — Entidades `book.Book` y `member.Member` con sus operaciones CRUD, junto con la gestión básica de préstamos (`loan.Loan`) y devoluciones. Pendiente: persistencia y mejoras de validación.

Sistema de gestión de biblioteca desarrollado en Java, aplicando Programación Orientada a Objetos (POO) con relaciones reales entre entidades (`book.Book`, `member.Member`, `loan.Loan`).

Proyecto de práctica para consolidar POO avanzado en Java (2º de DAM - Desarrollo de Aplicaciones Multiplataforma), evolucionando desde el enfoque de una única entidad (ver [task-manager-java](https://github.com/JavierRomLoz/task-manager-java)) hacia un sistema con varias clases relacionadas entre sí.

## 📌 Funcionalidades

### Implementado
- **Gestión de libros** (`book.BookManager`): crear, listar, editar y borrar, con identificador único (`idBook`) para evitar ambigüedad cuando hay varios libros con el mismo título.
- **Gestión de socios** (`member.MemberManager`): crear, listar, editar y borrar, con número de socio autoincremental y búsqueda por DNI.
- **Gestión de préstamos** (`loan.LoanManager`): crear préstamos vinculando libros y socios, impedir prestar libros no disponibles, registrar devoluciones y calcular días de retraso.
- Menú principal (`main.Main`) para acceder a las operaciones de libros, socios y préstamos.
- Validación de entradas: estado del libro restringido a valores válidos, manejo de `InputMismatchException` cuando se espera un número y se introduce texto, confirmación antes de borrar.

### En construcción
- Persistencia de libros, socios y préstamos: actualmente los datos solo viven mientras el programa está en ejecución.
- Mejoras en la validación y edición de datos.

## 🛠️ Tecnologías y conceptos aplicados

- **Java** (sin frameworks ni dependencias externas)
- Programación Orientada a Objetos: relaciones entre clases (`loan.Loan` contiene objetos `book.Book` y `member.Member`, no copias de sus datos)
- Encapsulación (atributos privados + getters/setters), constructores
- `enum` para restringir estados a valores válidos (`book.BookStatus`, `loan.LoanStatus`)
- Colecciones: `List<T>` (programando contra la interfaz, no la implementación concreta)
- Identificadores únicos autoincrementales para evitar ambigüedad entre registros con datos duplicados
- Manejo de excepciones: `try/catch` (`IllegalArgumentException`, `InputMismatchException`)
- Entrada de datos por consola con `Scanner`, compartido entre clases mediante inyección por constructor

## 📂 Estructura del proyecto

```
library-manager-java/
├── src/
│   ├── main/Main.java              # Punto de entrada y menú principal
│   ├── book/
│   │   ├── Book.java               # Entidad Libro
│   │   ├── BookManager.java        # Lógica CRUD sobre la colección de libros
│   │   └── BookStatus.java         # Enum de estado del libro
│   ├── member/
│   │   ├── Member.java             # Entidad Socio
│   │   └── MemberManager.java      # Lógica CRUD sobre la colección de socios
│   └── loan/
│       ├── Loan.java               # Entidad Préstamo
│       ├── LoanManager.java        # Lógica de préstamos y devoluciones
│       └── LoanStatus.java         # Enum de estado del préstamo
├── .gitignore
└── README.md
```

## ▶️ Cómo ejecutarlo

Este proyecto está pensado para ejecutarse desde **IntelliJ IDEA**:

1. Clona el repositorio:
   ```
   git clone https://github.com/JavierRomLoz/library-manager-java.git
   ```
2. Abre la carpeta del proyecto con IntelliJ IDEA.
3. Ejecuta `main.Main` (botón ▶️ o `Run` sobre la clase `main.Main`).

No requiere ninguna dependencia ni librería externa: solo Java estándar (JDK).

## 🎯 Qué he aprendido con este proyecto (hasta ahora)

- A modelar relaciones reales entre clases: un `loan.Loan` guarda una referencia a un objeto `book.Book` y `member.Member` ya existentes, no una copia de sus datos.
- Por qué usar un identificador único (`id`) es necesario en cuanto puede haber registros con datos duplicados (dos libros con el mismo título).
- Cómo separar dos conceptos de estado distintos que parecían el mismo (disponibilidad del libro vs. estado del préstamo), para evitar inconsistencias de datos.
- La importancia de decidir con criterio entre mantener el código 100% en inglés o hacer concesiones puntuales (como el valor de un enum) según el contexto del proyecto.

## 🚀 Próximas mejoras

- Añadir penalización por retraso en `loan.LoanManager`.
- Validar las fechas con `LocalDate` en lugar de `String`.
- Migración a base de datos con MySQL (JDBC).

## 👤 Autor

**Javier Roman Lozano**
Estudiante de 2º de DAM | Backend Developer en formación (Java)
[LinkedIn](https://www.linkedin.com/in/javier-roman-lozano-838392106/)
