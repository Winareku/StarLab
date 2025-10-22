---
tags:
  - 🗃️SBD
  - 📝NOT
cssclasses:
  - center-titles
---

# Lenguaje de Consulta Estructurada (SQL)

---

## 1. Introducción al SQL (Structured Query Language)

> [!quote] ¿Qué es?
> 
> SQL es el lenguaje estándar para el manejo de bases de datos relacionales. Permite tanto la definición de la estructura de la base de datos (esquema) como la manipulación de los datos que contiene.

> [!question] 1.1 Componentes de SQL
> SQL se divide en dos sublenguajes principales:
> 
> |**Sublenguaje**|**Nombre**|**Propósito**|**Comandos Principales**|
> |---|---|---|---|
> |**DDL**|Data Definition Language|Definir y modificar la **estructura** de los objetos de la base de datos (tablas, índices, etc.).|`CREATE`, `ALTER`, `DROP`|
> |**DML**|Data Manipulation Language|Manipular los **datos** almacenados en las tablas.|`SELECT`, `INSERT`, `UPDATE`, `DELETE`|
> 
---

## 2. DDL (Data Definition Language)
> [!quote] Definición
El DDL se centra en la definición de los objetos del esquema, no en los datos que contienen.

> [!question] 2.1 CREATE TABLE
> 
Se utiliza para crear una nueva tabla y definir sus columnas, tipos de datos y restricciones.

> [!bug] Sintaxis
> ```sql
> CREATE TABLE nombre_tabla (
>     columna1 tipo_dato [restricciones de columna],
>     columna2 tipo_dato [restricciones de columna],
>     ...
>     [restricciones de tabla]
> );
> ```

> [!question] Tipos de Datos Comunes
> 
> |**Tipo de Dato**|**Descripción**|
> |---|---|
> |`CHAR(n)`|Cadena de caracteres de tamaño fijo (`n`).|
> |`VARCHAR2(n)`|Cadena de caracteres de tamaño variable (eficiente en almacenamiento).|
> |`INTEGER`, `NUMERIC`|Tipos para números enteros o con decimales.|
> |`REAL`, `FLOAT`|Tipos para números en punto flotante.|
> |`DATE`, `TIMESTAMP`|Almacena fechas y/o fecha y hora.|
> |`SERIAL` / `AUTO_INCREMENT`|Genera valores numéricos únicos y secuenciales (utilizado para PK).|

> [!question] Restricciones (Constraints)
> 
Las restricciones garantizan la integridad y consistencia de los datos.
> 
> |**Restricción**|**Propósito**|
> |---|---|
> |`NOT NULL`|Impide que la columna tenga valores vacíos (nulos).|
> |`UNIQUE`|Garantiza que todos los valores en la columna o conjunto de columnas son distintos.|
> |`PRIMARY KEY`|Identifica de forma única cada fila. Es una combinación de `NOT NULL` y `UNIQUE`.|
> |`FOREIGN KEY`|Establece un vínculo referencial con una clave primaria de otra tabla.|
> |`CHECK`|Asegura que el valor en una columna cumpla una condición específica (Ej: `Edad > 18`).|

> [!example] Ejemplo de `CREATE TABLE`
> ```sql
> CREATE TABLE Marineros (
>     sid INTEGER PRIMARY KEY,           -- Clave primaria
>     snombre CHAR(20) NOT NULL,
>     rating INTEGER,
>     edad REAL
> );
> 
> CREATE TABLE Reservacion (
> 
> sid INTEGER,
> 
> bid INTEGER,
> 
> dia DATE,
> 
> PRIMARY KEY (sid, bid, dia), -- Clave primaria compuesta
> 
> FOREIGN KEY (sid) REFERENCES Marineros(sid)
> 
> );
> ```

> [!question] 2.2 ALTER TABLE
> Se utiliza para modificar la estructura de una tabla existente.

> [!bug] Comandos `ALTER`
> ```sql
> -- Añadir una columna
> ALTER TABLE Botes
> ADD COLUMN Edad REAL;
> 
> -- Modificar el tipo de dato de una columna
> ALTER TABLE Marineros
> MODIFY rating REAL;
> 
> -- Eliminar una columna
> ALTER TABLE Films
> DROP COLUMN genero;
> 
> -- Añadir una restricción de tabla (CHECK)
> ALTER TABLE Botes
> ADD CONSTRAINT EdadValida CHECK (Edad < 100);
> ```

> [!question] 2.3 DROP TABLE
> 
Elimina la definición de una tabla y todos los datos que contiene de la base de datos. Es una operación irreversible.

> [!example] Ejemplo
> ```sql
> DROP TABLE Films;
> ```

---

## 3. DML (Data Manipulation Language)

> [!quote] Definición
El DML se enfoca en la manipulación de los datos dentro de las tablas.

> [!question] 3.1 INSERT
> 
Añade una o más filas de datos a una tabla.

> [!bug] Sintaxis
> ```sql
> -- Insertar una fila con valores explícitos
> INSERT INTO nombre_tabla (columna1, columna2, ...)
> VALUES (valor1, valor2, ...);
> 
> -- Insertar filas a partir de una consulta
> 
> INSERT INTO tabla_destino
> 
> SELECT columna_a, columna_b, ...
> 
> FROM tabla_origen
> 
> WHERE condicion;
> ```

> [!question] 3.2 UPDATE
> 
Modifica los valores de una o varias columnas para un conjunto de filas que cumplen una condición.

> [!warning] ¡Cuidado!
> 
> Si se omite la cláusula WHERE, el UPDATE afectará a todas las filas de la tabla.

> [!example] Ejemplo
> ```sql
> UPDATE CLIENTES
> SET LIMITECREDITO = LIMITECREDITO * 1.12
> WHERE REPCLIE = 102;
> ```

> [!question] 3.3 DELETE
> 
Elimina una o varias filas de una tabla que cumplen una condición.

> [!warning] ¡Cuidado!
> 
> Si se omite la cláusula WHERE, el DELETE eliminará todas las filas de la tabla.

> [!example] Ejemplo
> ```sql
> DELETE FROM CLIENTES
> WHERE NUMCLIE = 2100;
> ```

> [!question] 3.4 SELECT (Consulta de Datos)
El comando `SELECT` es la operación fundamental del DML, utilizada para recuperar datos.

> [!info] Estructura General del `SELECT`
> ```sql
> SELECT [DISTINCT] lista_columnas     -- 1. Proyección (Qué columnas mostrar)
> FROM lista_tablas                    -- 2. Origen (De dónde obtener los datos)
> [WHERE condicion]                    -- 3. Selección (Filtro de filas)
> [GROUP BY columnas_agrupacion]       -- 4. Agrupación (Combinar filas en grupos)
> [HAVING condicion_grupo]             -- 5. Filtrar grupos (Filtro post-agregación)
> [ORDER BY columnas_orden [ASC/DESC]] -- 6. Ordenamiento (Cómo presentar el resultado)
> ```

> [!question] Cláusula WHERE (Condiciones)
> Se utiliza para filtrar registros individuales.
> 
> |**Operador**|**Descripción**|**Ejemplo**|
> |---|---|---|
> |`=, <>, <, >`|Operadores de comparación.|`WHERE PRECIO < 100`|
> |`BETWEEN a AND b`|Valor dentro de un rango inclusivo.|`WHERE NUMCLIE BETWEEN 2100 AND 2110`|
> |`IN (lista)`|Valor coincide con alguno de la lista.|`WHERE REPCLIE IN (102, 105)`|
> |`LIKE 'patrón'`|Búsqueda de patrones en cadenas.|`WHERE EMPRESA LIKE '%E.P.%'`|
> |`IS NULL / IS NOT NULL`|Comprueba si el valor es nulo.|`WHERE telefono IS NULL`|

> [!question] Funciones de Agregación
> Operan sobre un conjunto de filas (o un grupo) y devuelven un único valor de resumen.
> 
> |**Función**|**Descripción**|
> |---|---|
> |`COUNT()`|Cuenta el número de filas o valores no nulos.|
> |`SUM()`|Suma los valores de una columna.|
> |`AVG()`|Calcula el promedio de los valores.|
> |`MAX()`|Retorna el valor máximo.|
> |`MIN()`|Retorna el valor mínimo.|


> [!question] GROUP BY y HAVING
> 
> - **`GROUP BY`**: Agrupa filas que tienen los mismos valores en la columna de agrupación para aplicar funciones de agregación.
>     
> - **`HAVING`**: Se utiliza para filtrar los **grupos** creados por `GROUP BY`. Las condiciones del `HAVING` generalmente involucran funciones de agregación.
    

> [!example] Ejemplo de Agrupación
> ```sql
> -- Muestra los representantes que manejan más de 5 clientes
> SELECT REPCLIE, COUNT(NUMCLIE) AS TotalClientes
> FROM Cliente
> GROUP BY REPCLIE
> HAVING COUNT(NUMCLIE) > 5;
> ```

> [!question] Subconsultas (Subqueries)
> Una subconsulta es una consulta `SELECT` anidada dentro de otra instrucción DML. Se utilizan a menudo en la cláusula `WHERE` para filtrar datos en base a un resultado dinámico de otra consulta.

> [!example] Ejemplo de Subconsulta
> ```sql
> -- Seleccionar clientes cuyo límite de crédito es mayor que el promedio de todos los clientes
> SELECT NUMCLIE, EMPRESA, LIMITECREDITO
> FROM CLIENTES
> WHERE LIMITECREDITO > (
>     SELECT AVG(LIMITECREDITO) 
>     FROM CLIENTES
> );
> ```
> 
> El subquery `(SELECT AVG(LIMITECREDITO) FROM CLIENTES)` se evalúa primero, devolviendo un único valor (el promedio), que luego se usa en la condición `WHERE`.

> [!question] JOINs (Uniones)
Combina datos de dos o más tablas en función de una relación (clave foránea).

> [!info] Tipo de JOIN más común
> INNER JOIN: Devuelve solo las filas que tienen valores coincidentes en ambas tablas, basándose en la condición especificada (la igualdad de la clave foránea con la clave primaria).

> [!bug] Sintaxis de `INNER JOIN`
> ```sql
> SELECT P.NUMPEDIDO, C.EMPRESA
> FROM Pedidos P
> INNER JOIN Clientes C 
> ON P.CLIE = C.NUMCLIE;
> ```

> [!tip] Juego
> Prueba [SQLnoir](https://www.sqlnoir.com/) para probar tus conocimientos en SQL.