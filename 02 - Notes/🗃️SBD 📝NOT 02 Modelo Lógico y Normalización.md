---
tags:
  - 🗃️SBD
  - 📝NOT
cssclasses:
  - center-titles
  - embed-auto
---

# [[🗃️SBD 🏫MPR 02 Modelo Conceptual a Modelo Lógico.pdf|Modelo Lógico y Normalización - Unidad 2]]

## 1. Proceso de Diseño de Bases de Datos

> [!info] Tres Etapas Principales
> El diseño de una base de datos sigue un proceso estructurado en tres fases principales:

| Etapa                 | Objetivo                                 | Resultado                      |
| --------------------- | ---------------------------------------- | ------------------------------ |
| **Diseño Conceptual** | Identificar datos y restricciones        | Modelo Entidad-Relación (ERD)  |
| **Diseño Lógico**     | Crear tablas, relaciones y restricciones | Esquema relacional normalizado |
| **Diseño Físico**     | Implementar procedimientos y triggers    | Base de datos operativa        |

> [!success] Flujo del Proceso
> ```
> Especificación de Requisitos → Diseño Conceptual → Diseño Lógico → Diseño Físico
> ```

---

## 2. Transformación del Modelo Conceptual al Lógico

### 2.1 Conversión de Entidades

> [!info] Reglas Básicas
> - Cada **entidad** se transforma en una **tabla**
> - Los **atributos** se convierten en **columnas**
> - Las **claves primarias** se mantienen

> [!example] Ejemplo de Conversión

![[Pasted image 20251111071618.png]]

| Modelo Conceptual               | Modelo Lógico                                 |
| ------------------------------- | --------------------------------------------- |
| `CLIENTE` entidad               | `CLIENTE` tabla                               |
| `idCliente` (PK)                | `idCliente INT PRIMARY KEY`                   |
| `Nombre`, `Dirección` atributos | `Nombre VARCHAR(30)`, `Dirección VARCHAR(50)` |

### 2.2 Conversión de Atributos

> [!warning] Atributos Multivaluados
> Los atributos multivaluados requieren una tabla separada:
> 
> ```sql
> -- Ejemplo: Múltiples teléfonos por cliente
> CLIENTE (idCliente, Nombre, ...)
> TELEFONO (idCliente, Telefono)
> ```

---

## 3. Conversión de Relaciones

### 3.1 Relaciones 1:1 (Uno a Uno)

> [!info] Estrategias
> - **Fusión de tablas**: Unir ambas entidades en una sola tabla
> - **Propagación de clave**: Copiar PK de una tabla a otra como FK

> [!example] Caso: Empleado - Vehículo

| CARRO          | EMPLEADO       |
| -------------- | -------------- |
| `matricula PK` | `cedula PK`    |
| `marca`        | `nombre`       |
|                | `matricula FK` |

### 3.2 Relaciones 1:M (Uno a Muchos)

> [!success] Patrón Estándar
> - La entidad del lado "1" es el **padre**
> - La entidad del lado "M" es el **hijo**
> - Se copia la **PK del padre** como **FK en el hijo**

> [!example] Empleado - Departamento
> 
> ```sql
> DEPARTAMENTO (idDepartamento PK, Nombre)
> EMPLEADO (idEmpleado PK, Nombre, idDepartamento FK)
> ```

### 3.3 Relaciones M:M (Muchos a Muchos)

> [!warning] Creación de Tabla Intermedia
> Las relaciones M:N siempre generan una nueva tabla con las PKs de ambas entidades.

> [!example] Producto - Venta
> 
> ```sql
> PRODUCTO (idProducto PK, Nombre, Precio)
> VENTA (codigo PK, fecha)
> DETALLE (idProducto PK/FK, codigo PK/FK, cantidad)
> ```

### 3.4 Relaciones Ternarias

> [!info] Tres Entidades Participantes
> Se crea una tabla que incluye las tres claves primarias más los atributos de la relación.

> [!example] Profesor - Materia - Estudiante
> 
> ```sql
> REGISTRO (idProf PK/FK, idMateria PK/FK, Matricula PK/FK, calificación, Hora)
> ```

---

## 4. Conversión de Relaciones Especiales

### 4.1 Relaciones de Dependencia (Entidades Débiles)

> [!warning] Características
> - La entidad débil no puede existir sin la entidad fuerte
> - La PK de la entidad débil incluye la PK de la entidad fuerte

> [!example] Edificio - Departamento
> 
> ```sql
> EDIFICIO (idEdificio PK, Nombre, Direccion)
> DEPARTAMENTO (idEdificio PK/FK, hab_num PK, Piso)
> ```

### 4.2 Relaciones Recursivas

> [!info] Autoreferencia
> La misma entidad participa en diferentes roles, usando una FK que referencia su propia PK.

> [!example] Empleado supervisa Empleado
> 
> ```sql
> EMPLEADO (idEmpleado PK, Nombre, idSupervisor FK)
> -- idSupervisor referencia idEmpleado en la misma tabla
> ```

### 4.3 Supertipo - Subtipo

> [!success] Patrones de Herencia
> Diferentes estrategias según la obligatoriedad y exclusividad:

| Tipo | Obligatorio | Exclusivo | Implementación                                          |
| ---- | ----------- | --------- | ------------------------------------------------------- |
| (a)  | Sí          | Solapado  | Tabla principal + flags + tablas específicas            |
| (b)  | Sí          | Disjunto  | Tabla única con tipo y atributos opcionales             |
| (c)  | No          | Disjunto  | Tabla principal + tablas específicas opcionales         |
| (d)  | No          | Solapado  | Tabla principal + flags + tablas específicas opcionales |

> [!example] Empleado - Vendedor/Técnico
> 
> ```sql
> -- Opción (a): {obligatorio, solapado}
> EMPLEADO (idEmp PK, Nombre, esVendedor, esTecnico)
> VENDEDOR (idEmp PK/FK, numVentas)
> TECNICO (idEmp PK/FK, licencia)
> ```

---

## 5. Normalización de Bases de Datos

### 5.1 Introducción a la Normalización

> [!quote] Propósito
> "La normalización evita la redundancia de datos, problemas de actualización y protege la integridad de los datos."

> [!info] Formas Normales

| Forma Normal | Descripción                         | Base                       |
| ------------ | ----------------------------------- | -------------------------- |
| 1FN          | Atributos atómicos, clave primaria  | Estructura básica          |
| 2FN          | Dependencia completa de la clave    | Claves compuestas          |
| 3FN          | Eliminar dependencias transitivas   | Dependencias funcionales   |
| FNBC         | Versión reforzada de 3FN            | Dependencias funcionales   |
| 4FN          | Eliminar dependencias multivaluadas | Dependencias multivaluadas |
| 5FN          | Eliminar dependencias de reunión    | Dependencias de reunión    |

### 5.2 Dependencias Funcionales

> [!info] Concepto Fundamental
> - **Notación**: A → B (A determina B)
> - **Determinante**: Atributo(s) en el lado izquierdo
> - **Dependiente**: Atributo(s) en el lado derecho

> [!example] Ejemplo: CLIENTE
> 
> ```
> Número_cliente → Nombre
> Número_cliente → Teléfono
> Número_cliente → Fecha_Nacimiento
> Fecha_Nacimiento → Edad  (dependencia transitiva)
> ```

### 5.3 Primera Forma Normal (1FN)

> [!success] Requisitos
> 1. Todos los atributos son **atómicos**
> 2. Existe una **clave primaria única**
> 3. No hay atributos nulos en la PK
> 4. Número constante de columnas
> 5. Campos no clave dependen funcionalmente de la clave
> 6. Independencia del orden de filas y columnas

> [!example] Corrección de Multivalores

| ❌ Antes (No 1FN)                 | ✅ Después (1FN)                  |
| --------------------------------- | --------------------------------- |
| `Cliente (ID, Nombre, Teléfonos)` | `Cliente (ID, Nombre)`            |
| `123, Juan, 555-111, 555-222`     | `Telefono (ID_Cliente, Telefono)` |

### 5.4 Segunda Forma Normal (2FN)

> [!warning] Aplicación
> Solo para tablas con **claves compuestas**. Todos los atributos no clave deben depender de **toda la clave**.

> [!example] Ejemplo: Habilidades de Empleados

| ❌ No 2FN                               | ✅ 2FN                                       |
| --------------------------------------- | -------------------------------------------- |
| `(Empleado, Habilidad) → LugarTrabajo`  | `Empleado → LugarTrabajo`                    |
| `LugarTrabajo depende solo de Empleado` | `(Empleado, Habilidad) → [sin LugarTrabajo]` |

### 5.5 Tercera Forma Normal (3FN)

> [!danger] Dependencias Transitivas
> Eliminar dependencias donde un atributo no clave depende de otro atributo no clave.

> [!example] Ejemplo: Ganadores de Torneo

| ❌ No 3FN                                   | ✅ 3FN                      |
| ------------------------------------------- | --------------------------- |
| `(Torneo, Año) → Ganador → FechaNacimiento` | `(Torneo, Año) → Ganador`   |
| `FechaNacimiento transitiva`                | `Ganador → FechaNacimiento` |

> [!bug] Fórmula de Dependencia Transitiva
> $$
> X \rightarrow Y \land Y \rightarrow Z \Rightarrow X \rightarrow Z
> $$

### 5.6 Consideraciones Prácticas

> [!tip] ¿Hasta dónde normalizar?
> - La normalización es una **ciencia subjetiva**
> - Considerar el **propósito** y **escala** de la base de datos
> - Balancear entre **normalización** y **rendimiento**
> - Las formas superiores (4FN, 5FN) son para casos muy específicos

---

## 6. Ejercicios y Casos Prácticos

### 6.1 Ejercicio de Conversión MC a ML

> [!example] Conversión Completa
> Dado un modelo ER con:
> - Entidades: CLIENTE, PRODUCTO, VENTA
> - Relaciones: CLIENTE realiza VENTA (1:N), VENTA contiene PRODUCTO (M:N)
> - Atributos multivaluados: múltiples teléfonos por cliente

### 6.2 Ejercicio de Normalización

> [!example] Normalización Paso a Paso
> 
> ```sql
> -- Tabla inicial no normalizada
> PEDIDO (NumPedido, Fecha, Cliente, Direccion, 
>         ProductoID, DescProducto, Categoria, Precio, Cantidad)
> ```
> 
> Aplicar 1FN, 2FN y 3FN sucesivamente.
