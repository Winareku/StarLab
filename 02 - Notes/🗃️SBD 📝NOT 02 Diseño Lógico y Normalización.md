---
tags:
  - 🗃️SBD
  - 📝NOT
cssclasses:
  - center-titles
---

Diseño Lógico y Normalización

---

## 1. Del Modelo Conceptual al Modelo Lógico

> [!info] Información clave
> [cite_start]El **Diseño Lógico** es una fase en la metodología de diseño de bases de datos que refina el Modelo Conceptual (MC)[cite: 144]. [cite_start]Su objetivo es transformar las entidades, atributos y relaciones del MC en una estructura que se pueda implementar en una base de datos relacional, principalmente en tablas[cite: 173, 183]. [cite_start]En este proceso se aplican reglas de **normalización** para optimizar el esquema[cite: 176].

### 1.1 Transformación de Entidades y Claves

[cite_start]Cada entidad del modelo conceptual se convierte en una **tabla** [cite: 178][cite_start], y sus atributos se transforman en las **columnas** de dicha tabla[cite: 179].

| Elemento MC | Elemento ML | Descripción |
|-------------|-------------|-------------|
| [cite_start]Entidad [cite: 182] | [cite_start]Tabla [cite: 183] | Representa un conjunto de objetos del mundo real con propiedades comunes. |
| [cite_start]Atributo [cite: 180] | [cite_start]Columna [cite: 181] | Representa una característica o propiedad de una entidad. |
| Identificador | Clave Primaria (PK) | [cite_start]Un atributo o conjunto de atributos que identifica de forma única cada fila en una tabla[cite: 200, 203]. [cite_start]La PK no puede contener valores nulos[cite: 41]. |
| Relación | Clave Foránea (FK) | [cite_start]Una columna (o conjunto de columnas) que establece un vínculo entre dos tablas[cite: 210]. [cite_start]Debe hacer referencia a una clave única en la tabla referenciada[cite: 212]. |

> [!example] Ejemplo de transformación
> [cite_start]Una entidad **CLIENTE** con atributos `idCliente`, `Nombre` y `Dirección` se convierte en una tabla `CLIENTE` con esas mismas columnas, donde `idCliente` es la Clave Primaria (PK)[cite: 184, 185, 186, 187, 188, 189].

### 1.2 Conversión de Relaciones

La cardinalidad de las relaciones en el Modelo Conceptual determina cómo se implementan en el Modelo Lógico.

* **Relaciones 1:1 (Uno a Uno)**
    * [cite_start]Si la participación es total (1,1) en ambos lados, las entidades se pueden fusionar en una sola tabla[cite: 318].
    * [cite_start]Si la participación es parcial (0,1) en un lado, la clave primaria de la entidad "padre" (participación 1,1) se propaga como clave foránea a la tabla "hija" (participación 0,1)[cite: 271, 299].

* **Relaciones 1:M (Uno a Muchos)**
    * [cite_start]La clave primaria de la tabla del lado "1" (padre) se añade como clave foránea en la tabla del lado "M" (hijo)[cite: 341].
    * [cite_start]Los atributos de la relación, si existen, también se agregan a la tabla del lado "M"[cite: 342].

* **Relaciones M:M (Muchos a Muchos)**
    * [cite_start]Se crea una **nueva tabla intermedia** para representar la relación[cite: 233].
    * [cite_start]Esta nueva tabla incluye las claves primarias de las dos entidades originales como claves foráneas (que juntas forman la clave primaria compuesta de la nueva tabla) y cualquier atributo propio de la relación[cite: 234].

---

## 2. Normalización de Datos

> [!quote] Definición
> [cite_start]La **normalización** es un proceso que consiste en aplicar un conjunto de reglas a las tablas para minimizar la redundancia de datos, evitar problemas de actualización y proteger la integridad de la información[cite: 10, 12, 13, 14]. [cite_start]Se basa en el concepto de **dependencia funcional**[cite: 19].

### 2.1 Dependencia Funcional

> [!info] Concepto
> [cite_start]Una dependencia funcional existe cuando el valor de un atributo (o un conjunto de atributos) **A** determina de manera única el valor de otro atributo **B**[cite: 22]. [cite_start]Esto se denota como $A \rightarrow B$[cite: 23]. [cite_start]El atributo **A** se conoce como el determinante[cite: 24].

> [!example] Ejemplo de Dependencia Funcional
> En una tabla de empleados:
> [cite_start]* `Número_cliente` $\rightarrow$ `Nombre` (Conocer el número de cliente permite saber su nombre)[cite: 29].
> [cite_start]* `Fecha_Nacimiento` $\rightarrow$ `Edad` (Conocer la fecha de nacimiento permite calcular la edad)[cite: 28, 33].

### 2.2 Formas Normales

#### **Primera Forma Normal (1FN)**

> [!info] Requisitos
> Una tabla está en 1FN si cumple con las siguientes condiciones:
> [cite_start]* **Atomicidad**: Todos sus atributos contienen valores indivisibles (atómicos)[cite: 38]. [cite_start]No se permiten múltiples valores en una sola celda[cite: 47].
> [cite_start]* **Clave Primaria**: La tabla debe tener una clave primaria única para identificar cada fila[cite: 39, 43]. [cite_start]Esta clave no puede contener valores nulos[cite: 41].
> [cite_start]* **Estructura Fija**: No debe haber una variación en el número de columnas entre las filas[cite: 42].

> [!warning] Problema a resolver
> [cite_start]La 1FN prohíbe los atributos multivaluados y compuestos[cite: 47]. [cite_start]Si una tabla no cumple la 1FN, se debe dividir, creando una nueva tabla para el atributo problemático junto con la clave primaria de la tabla original[cite: 48, 49].

#### **Segunda Forma Normal (2FN)**

> [!info] Requisitos
> Una tabla está en 2FN si:
> [cite_start]1.  Ya se encuentra en 1FN[cite: 52].
> [cite_start]2.  Todos los atributos que no son parte de la clave primaria dependen funcionalmente de la **clave primaria completa**, y no solo de una parte de ella[cite: 53].

> [!warning] Punto importante
> [cite_start]La 2FN solo es relevante para tablas con **claves primarias compuestas** (formadas por más de un atributo)[cite: 54]. Si una tabla tiene una clave primaria simple, y ya está en 1FN, automáticamente cumple con la 2FN. [cite_start]Si se viola la 2FN, los atributos que dependen parcialmente de la clave se mueven a una nueva tabla[cite: 55].

#### **Tercera Forma Normal (3FN)**

> [!info] Requisitos
> Una tabla está en 3FN si:
> [cite_start]1.  Ya se encuentra en 2FN[cite: 61].
> [cite_start]2.  No existen **dependencias transitivas**[cite: 62]. [cite_start]Esto significa que ningún atributo no clave depende funcionalmente de otro atributo no clave[cite: 63].

> [!example] Ejemplo de dependencia transitiva
> En una tabla `Empleados(idEmpleado, Puesto, Salario)`:
> * `idEmpleado` $\rightarrow$ `Puesto`
> * `Puesto` $\rightarrow$ `Salario`
>
> Aquí, `Salario` depende transitivamente de `idEmpleado` a través de `Puesto`. [cite_start]Esto puede causar anomalías, como tener el mismo puesto con salarios diferentes[cite: 67].
>
> **Solución**: Se divide la tabla en dos:
> [cite_start]* `Empleados(idEmpleado, Puesto)` [cite: 91, 92]
> [cite_start]* `Puestos(Puesto, Salario)` [cite: 103, 104]

> [!success] Buenas prácticas
> [cite_start]La mayoría de las bases de datos bien diseñadas alcanzan la 3FN, ya que esto suele ser suficiente para eliminar las anomalías de inserción, actualización y borrado más comunes[cite: 111]. [cite_start]Aunque existen formas normales superiores (FNBC, 4FN, 5FN), no siempre es necesario o práctico llegar a esos niveles[cite: 20]. [cite_start]La decisión de qué tan lejos normalizar depende de las necesidades del sistema[cite: 111].