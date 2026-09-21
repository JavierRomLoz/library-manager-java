# Library Manager Java 📚

> 🚧 **Proyecto en desarrollo activo** — Entidades `Book` y `Member` con sus operaciones CRUD completas y funcionales. Pendiente: gestión de préstamos (`Loan`) con lógica de retrasos y disponibilidad.

Sistema de gestión de biblioteca desarrollado en Java, aplicando Programación Orientada a Objetos (POO) con relaciones reales entre entidades (`Book`, `Member`, `Loan`).

Proyecto de práctica para consolidar POO avanzado en Java (2º de DAM - Desarrollo de Aplicaciones Multiplataforma), evolucionando desde el enfoque de una única entidad (ver [task-manager-java](https://github.com/JavierRomLoz/task-manager-java)) hacia un sistema con varias clases relacionadas entre sí.

## 📌 Funcionalidades

### Implementado
- **Gestión de libros** (`BookManager`): crear, listar, editar y borrar, con identificador único (`idBook`) para evitar ambigüedad cuando hay varios libros con el mismo título.
- **Gestión de socios** (`MemberManager`): crear, listar, editar y borrar, con número de socio autoincremental y búsqueda por DNI.
- Validación de entradas: estado del libro restringido a valores válidos, manejo de `InputMismatchException` cuando se espera un número y se introduce texto, confirmación antes de borrar.

### En construcción
- **Gestión de préstamos** (`LoanManager`): relación entre `Book`, `Member` y `Loan`, con cálculo de retraso en la devolución y actualización automática del estado de disponibilidad del libro.
- Menú principal (`Main`) que integre los tres gestores.

## 🛠️ Tecnologías y conceptos aplicados

- **Java** (sin frameworks ni dependencias externas)
- Programación Orientada a Objetos: relaciones entre clases (`Loan` contiene objetos `Book` y `Member`, no copias de sus datos)
- Encapsulación (atributos privados + getters/setters), constructores
- `enum` para restringir estados a valores válidos (`BookStatus`, próximamente `LoanStatus`)
- Colecciones: `List<T>` (programando contra la interfaz, no la implementación concreta)
- Identificadores únicos autoincrementales para evitar ambigüedad entre registros con datos duplicados
- Manejo de excepciones: `try/catch` (`IllegalArgumentException`, `InputMismatchException`)
- Entrada de datos por consola con `Scanner`, compartido entre clases mediante inyección por constructor

## 📂 Estructura del proyecto

```
library-manager-java/
├── src/
│   ├── Main.java              # Punto de entrada (pendiente)
│   ├── BookManager.java       # Lógica CRUD sobre la colección de libros
│   ├── MemberManager.java     # Lógica CRUD sobre la colección de socios
│   ├── LoanManager.java       # Lógica de préstamos (pendiente)
│   ├── Book.java              # Entidad Libro
│   ├── Member.java            # Entidad Socio
│   ├── Loan.java              # Entidad Préstamo
│   └── BookStatus.java        # Enum de estado del libro
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
3. Una vez esté disponible `Main.java`, ejecuta el programa (botón ▶️ o `Run` sobre la clase `Main`).

No requiere ninguna dependencia ni librería externa: solo Java estándar (JDK).

## 🎯 Qué he aprendido con este proyecto (hasta ahora)

- A modelar relaciones reales entre clases: un `Loan` guarda una referencia a un objeto `Book` y `Member` ya existentes, no una copia de sus datos.
- Por qué usar un identificador único (`id`) es necesario en cuanto puede haber registros con datos duplicados (dos libros con el mismo título).
- Cómo separar dos conceptos de estado distintos que parecían el mismo (disponibilidad del libro vs. estado del préstamo), para evitar inconsistencias de datos.
- La importancia de decidir con criterio entre mantener el código 100% en inglés o hacer concesiones puntuales (como el valor de un enum) según el contexto del proyecto.

## 🚀 Próximas mejoras

- Completar `LoanManager` con cálculo de días de retraso y penalización.
- Validar las fechas con `LocalDate` en lugar de `String`.
- Migración a base de datos con MySQL (JDBC).

## 👤 Autor

**Javier Roman Lozano**
Estudiante de 2º de DAM | Backend Developer en formación (Java)
[LinkedIn](https://www.linkedin.com/in/javier-roman-lozano-838392106/)