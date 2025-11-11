---
tags:
  - 🗃️SBD
  - 📝NOT
cssclasses:
  - center-titles
  - embed-auto
---

# [[05 - Resources/💾EDD 🏫MPR 01 Tipos de Datos.pdf|Modelo Conceptual de Datos - Unidad 1]]

## 1. Introducción al Modelo Conceptual

> [!info] Definición
> El **modelo conceptual** es una representación gráfica de una estructura del mundo real, enfocada en cómo los datos serán almacenados y administrados. Es un proceso iterativo que sirve como lenguaje común entre los diferentes roles en el desarrollo de sistemas.

> [!success] Importancia
> - Proporciona un lenguaje común entre desarrolladores, analistas y usuarios.
> - Minimiza problemas como cambios estructurales continuos, redundancia y acceso ineficiente a los datos.
> - Un buen diseño es crucial: incluso con el mejor hardware o interfaz, un mal diseño afecta el rendimiento.

---

## 2. Modelos de Datos

### 2.1 Modelo Relacional (RDBMS)

> [!info] Características
> - Introducido por E.F. Codd.
> - Basado en conceptos matemáticos.
> - Estructura: **relaciones** (tablas) con filas (**tuplas**) y columnas (**atributos**).
> - Las tablas se relacionan mediante columnas en común.

### 2.2 Modelo Entidad-Relación (ERM)

> [!info] Origen y propósito
> - Presentado por Peter Chen en 1976.
> - Permite modelar estructuras más avanzadas mediante el **Diagrama Entidad-Relación (ERD)**.
> - Notaciones comunes: Chen, Crow’s Foot, UML.

| Notación    | Símbolos                    | Uso                          |
| ----------- | --------------------------- | ---------------------------- |
| Chen        | Rectángulos, rombos, líneas | Modelado conceptual          |
| Crow’s Foot | Patas de gallo              | Cardinalidades               |
| UML         | Rectángulos con secciones   | Modelado orientado a objetos |

---

## 3. Elementos del Modelo ER

### 3.1 Entidades

> [!quote] Definición
> Cualquier objeto del mundo real que se desee representar.

| Tipo       | Ejemplos             |
| ---------- | -------------------- |
| Tangible   | Persona, cosa, lugar |
| Intangible | Concepto, venta      |
| Evento     | Concierto, compra    |

> [!example] Ejemplo
> - **Tipo de Entidad**: `Cliente`
> - **Instancias**: Luis Pérez, María Caña

> [!warning] Diferencia: Entidad vs. Instancia
> - **Entidad**: Clase o tipo (ej: `Cliente`).
> - **Instancia**: Objeto específico (ej: `Luis Pérez`).

### 3.2 Atributos

> [!info] Definición
> Cualidades, clasificaciones o cuantificaciones de una entidad. Todas las instancias de una entidad comparten los mismos atributos.

#### Clasificación de Atributos

| Tipo         | Descripción                  | Ejemplo                       |
| ------------ | ---------------------------- | ----------------------------- |
| Simple       | Atómico, no divisible        | Salario, primer apellido      |
| Compuesto    | Múltiples componentes        | Fecha (dd-mm-yyyy), dirección |
| Derivado     | Se calcula a partir de otros | Edad, subtotal                |
| Multivaluado | Múltiples valores            | Teléfono (varios números)     |

> [!tip] Preferencia por atributos no volátiles
> - **Volátil**: Cambia frecuentemente (ej: edad).
> - **No volátil**: Cambia raramente (ej: fecha de nacimiento).
> - **Recomendación**: Usar `fecha_nacimiento` en lugar de `edad`.

### 3.3 Clave Primaria (PK)

> [!info] Propiedades
> - Identifica de manera única cada instancia de una entidad.
> - No puede ser nula.
> - Puede ser **simple**, **compuesta** o **artificial** (incremental).

> [!example] Ejercicio: Identificar PK
> 
> | nombre | fecha_registro | cédula |
> |--------|----------------|--------|
> | Pepe   | 22-12-2015     | 0909090909 |
> | Laura  | 23-12-2015     | 0908080808 |
> 
> **PK**: `cédula` (identificador único).

### 3.4 Relaciones

> [!quote] Definición
> Asociación entre dos o más entidades, nombrada con un verbo.

> [!example] Ejemplo
> - `EMPLEADO` **trabaja** en `DEPARTAMENTO`.

#### Cardinalidad

> [!info] Tipos de Cardinalidad
> - **Máxima**: Número máximo de instancias que pueden participar.
> - **Mínima**: Si la participación es obligatoria (1) u opcional (0).

| Cardinalidad    | Símbolo | Ejemplo                                |
| --------------- | ------- | -------------------------------------- |
| Uno a Uno       | 1:1     | Un empleado tiene un cargo             |
| Uno a Muchos    | 1:N     | Un cliente realiza muchas compras      |
| Muchos a Muchos | M:N     | Un empleado aprende varias habilidades |

> [!example] Reglas de Negocio
> - Cada `CLIENTE` realiza **0..*** `COMPRAS`.
> - Cada `COMPRA` es realizada por **1..1** `CLIENTE`.

---

## 4. Tipos de Relaciones Avanzadas

### 4.1 Relación Ternaria

> [!info] Definición
> Relación que involucra tres entidades. Ejemplo: `PROFESOR` dicta `ASIGNATURA` a `ESTUDIANTE`, con atributo `nota`.

### 4.2 Relación Débil (Dependencia)

> [!warning] Características
> - Una entidad débil no puede existir sin la entidad fuerte.
> - Su identificador incluye la PK de la entidad fuerte.

### 4.3 Relación Recursiva

> [!example] Ejemplo
> - `EMPLEADO` **supervisa** a otros `EMPLEADOS`.

### 4.4 Supertipo y Subtipo

> [!info] Herencia en ER
> - **Supertipo**: Entidad que comparte atributos o relaciones con otras.
> - **Subtipo**: Hereda todos los atributos del supertipo y tiene atributos o relaciones propios.

> [!example] Ejemplo
> - `CLIENTE` (supertipo) → `EMPRESA` y `PERSONA` (subtipos).

---

## 5. Restricciones y Diccionario de Datos

### 5.1 Restricciones

> [!info] Tipos
> - **Dominio**: Valores legítimos para un atributo (ej: enteros, strings).
> - **Reglas de negocio**: Condiciones específicas (ej: calificación entre 0 y 100).

### 5.2 Diccionario de Datos

> [!example] Ejemplo de Diccionario
> 
> | Atributo | Dominio | Significado | Definición |
> |----------|---------|-------------|------------|
> | cédula | Número de cédula | Identificador único | Carácter: 10 dígitos |
> | nombres | Cadena de texto | Nombre completo | Carácter: hasta 50 caracteres |
> | fecha_nacimiento | Fecha | Fecha de nacimiento | Formato: dd-mm-yyyy |

---

## 6. Ejercicios y Casos Prácticos

> [!example] Ejercicio: Modelar Galería de Arte
> - Entidades: `ARTISTA`, `OBRA_ARTE`, `CLIENTE`, `GRUPO`.
> - Relaciones: Un `ARTISTA` crea varias `OBRAS_ARTE`. Una `OBRA_ARTE` puede pertenecer a varios `GRUPOS`.

> [!example] Ejercicio: Club de Tenis
> - Entidades: `MIEMBRO`, `ENTRENADOR`, `COMPETENCIA`.
> - Relaciones: Un `MIEMBRO` puede tener varios `ENTRENAMIENTOS`. Un `ENTRENADOR` entrena a varios `MIEMBROS`.
