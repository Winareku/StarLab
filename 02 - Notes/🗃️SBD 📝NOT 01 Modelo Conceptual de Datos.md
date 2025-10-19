---
tags:
- 🗃️SBD
- 📝NOT
---

# Modelo Conceptual de Datos

---

## 1. Introducción a los Sistemas de Bases de Datos

> [!info] Concepto General  
> Un **Sistema de Gestión de Bases de Datos (DBMS)** es un conjunto de programas que permite definir, construir y manipular bases de datos para diferentes aplicaciones.

|Concepto|Descripción|
|---|---|
|**Base de datos**|Colección organizada de datos relacionados.|
|**DBMS**|Software que gestiona la creación, acceso y mantenimiento de la base de datos.|
|**Modelo de datos**|Representación conceptual que define cómo se estructuran y relacionan los datos.|

> [!example] Ejemplo  
> Un sistema de matrícula universitaria usa un DBMS para gestionar **estudiantes**, **materias** y **paralelos**, asegurando integridad y evitando duplicidad.

---

## 2. Modelamiento de Datos

> [!quote] Definición  
> El **modelamiento de datos** es el proceso de representar de manera abstracta y estructurada los elementos y relaciones del mundo real que serán almacenados en una base de datos.

> [!tip] Características
> 
> - Representación **gráfica** de la estructura del mundo real.
>     
> - Se enfoca en **cómo los datos serán guardados y administrados**.
>     
> - Es un proceso **iterativo**: se mejora conforme se comprende el dominio.
>     

### Importancia

> [!warning] Razones Clave
> 
> - Proporciona un **lenguaje común** entre analistas, diseñadores y usuarios.
>     
> - Permite **minimizar redundancias y errores** estructurales.
>     
> - Un mal modelo afecta el **rendimiento** y la **flexibilidad** de la aplicación.
>     

---

## 3. Modelos de Datos

|Modelo|Descripción|Ejemplo|
|---|---|---|
|**Jerárquico**|Estructura en forma de árbol (padre-hijo).|Sistema de archivos.|
|**Red**|Entidades con múltiples relaciones.|Catálogo de proveedores-productos.|
|**Relacional (RDBMS)**|Basado en tablas (filas y columnas).|MySQL, PostgreSQL.|
|**Entidad-Relación (ERM)**|Representación gráfica del modelo conceptual.|Diagrama E/R.|

> [!quote] Peter Chen, 1976  
> Introdujo el **Modelo Entidad-Relación (ER)**, estándar aún vigente para el modelamiento conceptual.

---

## 4. Elementos del Modelo Entidad-Relación (ER)

|Elemento|Descripción|
|---|---|
|**Entidad**|Objeto del mundo real que se desea representar.|
|**Atributo**|Propiedad o característica de una entidad.|
|**Relación**|Asociación entre dos o más entidades.|
|**Restricción**|Regla que limita los valores o relaciones posibles.|

---

### 4.1 Entidad

> [!info] Definición  
> Cualquier objeto, tangible o intangible, que tenga existencia y relevancia para el sistema.

|Tipo|Ejemplo|
|---|---|
|**Tangible**|Persona, vehículo, edificio|
|**Intangible**|Evento, venta, reserva|

> [!example] Ejemplo  
> En una **galería de arte**, las entidades pueden ser: `Artista`, `Obra`, `Cliente`.

> [!question] Ejercicio rápido  
> ¿“Perro” es una entidad o una instancia?  
> **→ Entidad.** Una instancia sería un perro específico: “Fido”.

---

### 4.2 Atributos

> [!quote] Definición  
> Son las **características que describen una entidad**. Todas las instancias de una entidad comparten los mismos atributos.

#### Clasificación

|Tipo|Descripción|Ejemplo|
|---|---|---|
|**Simples**|No se pueden dividir.|Apellido, salario|
|**Compuestos**|Se pueden subdividir.|Dirección (calle, ciudad)|
|**Derivados**|Calculados a partir de otros.|Edad (de la fecha de nacimiento)|
|**Multivaluados**|Pueden tener varios valores.|Teléfonos (1..*)|

#### Atributos Identificadores (Clave Primaria)

> [!info] PK — Primary Key  
> Uno o más atributos que identifican de manera **única** a una instancia.

|Tipo|Ejemplo|
|---|---|
|**Simple**|`Cédula`|
|**Compuesta**|`(codMateria, codParalelo)`|
|**Artificial**|`ID_Autoincremental`|

> [!question] Ejercicio  
> ¿Qué atributo seleccionaría como PK para “Vehículo”?  
> **→ Número de matrícula.**

---

### 4.3 Relaciones

> [!quote] Definición  
> Asociación entre dos o más entidades; se nombran usualmente con un **verbo**.

|Tipo|Ejemplo|
|---|---|
|**Binaria**|`Empleado trabaja en Departamento`|
|**Ternaria**|`Cliente realiza Pedido en Sucursal`|
|**Recursiva**|`Empleado supervisa Empleado`|

#### Cardinalidad

> [!info] Indica cuántas instancias de una entidad pueden estar relacionadas con otra.

|Tipo|Ejemplo|
|---|---|
|**1:1**|Una persona tiene un pasaporte.|
|**1:N**|Un cliente realiza muchas compras.|
|**N:M**|Un estudiante cursa varias materias y cada materia tiene varios estudiantes.|

#### Cardinalidad Mínima y Máxima

|Notación|Significado|
|---|---|
|**1..1**|Obligatoria y única|
|**0..***|Opcional y múltiple|

> [!example]  
> Un cliente puede hacer **0 o muchas compras (0..*)**,  
> pero cada compra pertenece a **1 cliente (1..1)**.

---

## 5. Tipos de Relaciones Especiales

### 5.1 Relación de Dependencia

> [!info] Entidades fuertes y débiles  
> Una **entidad débil** depende de otra entidad **fuerte** para existir.  
> Su clave primaria incluye la del supertipo o entidad fuerte.

> [!example]  
> `Dependiente` existe solo si existe su `Empleado`.

### 5.2 Relación Recursiva

> [!quote]  
> Ocurre cuando una entidad se relaciona consigo misma.  
> Ejemplo: un **empleado supervisa a otro empleado**.

### 5.3 Participación Total

> [!info]  
> Una entidad tiene **participación total** si cada una de sus instancias **debe** participar en la relación.

---

## 6. Supertipo y Subtipo

> [!quote] Definición  
> Un **Supertipo** agrupa entidades que comparten atributos.  
> Un **Subtipo** tiene atributos o relaciones **propios**, heredando los del supertipo.

|Supertipo|Subtipos|Atributos propios|
|---|---|---|
|**Cliente**|Persona, Empresa|Persona → Cédula, Género; Empresa → RUC, Razón Social|

> [!example]  
> Un **Cliente** puede ser **Persona** o **Empresa**, pero ambos comparten el `idCliente` y `Dirección`.

> [!tip] Notación
> 
> - Línea simple: subtipo **opcional**
>     
> - Línea doble: subtipo **obligatorio**
>     
> - `d` = solo un subtipo (disjoint), `o` = más de uno (overlapping)
>     

> [!question] Ejercicio  
> Determine el supertipo/subtipo:  
> “Discapacidad → {Visual, Auditiva, Motriz}”  
> **→ Supertipo:** Discapacidad. **Subtipos:** Visual, Auditiva, Motriz.

---

## 7. Reglas de Negocio

> [!info] Definición  
> Las **reglas de negocio** definen condiciones, restricciones o políticas que gobiernan las operaciones de la base de datos.

|Tipo|Descripción|Ejemplo|
|---|---|---|
|**Estructural**|Describe relaciones o restricciones.|Un estudiante pertenece a un paralelo.|
|**Procedimental**|Describe procesos o secuencia de eventos.|Un pedido debe aprobarse antes de ser enviado.|

> [!example]  
> “La calificación de un estudiante debe ser entre 0 y 100.”  
> “Un curso de Bases de Datos debe tener mínimo 15 estudiantes.”

---

## 8. Dominio y Restricciones

> [!quote] Definición  
> El **dominio** de un atributo es el conjunto de valores válidos que puede tomar.

|Atributo|Dominio|Restricción|
|---|---|---|
|Edad|Entero|0 ≤ Edad ≤ 120|
|Calificación|Entero|0 ≤ Nota ≤ 100|
|Género|String|{‘M’, ‘F’, ‘Otro’}|

> [!question] Ejercicio  
> Defina el dominio para “precio”.  
> **→ Número decimal positivo.**

---

## 9. Buenas Prácticas de Modelamiento

> [!success]
> 
> - Priorizar **atributos no volátiles** (fecha de nacimiento en lugar de edad).
>     
> - Evitar redundancia: un dato debe almacenarse una sola vez.
>     
> - Nombrar las relaciones con **verbos claros** (e.g., “realiza”, “pertenece”).
>     
> - Documentar reglas de negocio desde el inicio del modelamiento.
>     
> - Revisar iterativamente con el usuario final.
>     

---

## 10. Ejercicios Representativos

1. **Identifique la PK** para las entidades:
    
    - Estudiante → `Matrícula`
        
    - Factura → `IDFactura`
        
    - País → `CódigoISO`
        
2. **Determine la cardinalidad:**
    
    - Un **cliente** realiza **muchas facturas** (1:N).
        
    - Cada **factura** pertenece a **un cliente** (1:1).
        
3. **Defina un supertipo/subtipo:**
    
    - `Empleado` → {Docente, Administrativo}
        

---

> [!tip] Resumen Final  
> El **modelo conceptual de datos** busca representar el mundo real de manera estructurada y comprensible, sirviendo como base para el **diseño lógico y físico** de la base de datos.

