---
tags:
  - 🗃️SBD
  - 📝NOT
cssclasses:
  - center-titles
  - embed-auto
---

# [[🗃️SBD 🏫MPR 03 Álgebra Relacional.pdf|Álgebra Relacional - Unidad 3]]

## 1. Introducción al Álgebra Relacional

> [!info] Definición
> El **álgebra relacional** es un lenguaje de consulta procedural que consiste en un conjunto de operaciones que toman una o dos relaciones como entrada y producen una nueva relación como resultado. Es la base teórica de SQL.

> [!quote] Conceptos Fundamentales
> - **Tupla**: Cada fila de una tabla
> - **Query**: Consulta aplicada a instancias de tablas
> - **Resultado**: Siempre es otra relación (tabla)

> [!success] Importancia
> Entender el álgebra relacional es clave para comprender SQL y el procesamiento de consultas en bases de datos relacionales.

---

## 2. Operaciones Básicas del Álgebra Relacional

### 2.1 Proyección (π)

> [!info] Definición
> Retiene solo las columnas especificadas de una relación (operación vertical).

> [!bug] Símbolo y Sintaxis
> $$
> \pi_{\text{atributo1, atributo2, ...}} (Relación)
> $$

> [!example] Ejemplo Práctico

#### Marineros (S2)

| mid | mnombre | rating | edad |
|:--- |:------- |:------ |:---- |
| 28  | yuppy   | 9      | 35.0 |
| 31  | lubber  | 8      | 55.5 |
| 44  | guppy   | 5      | 35.0 |
| 58  | rusty   | 10     | 35.0 |

#### Proyección: π mnombre, rating (S2)

| mnombre | rating |
|:------- |:------ |
| yuppy   | 9      |
| lubber  | 8      |
| guppy   | 5      |
| rusty   | 10     |

### 2.2 Selección (σ)

> [!info] Definición
> Selecciona un subconjunto de filas que satisfacen una condición (operación horizontal).

> [!bug] Símbolo y Sintaxis
> $$
> \sigma_{\text{condición}} (Relación)
> $$

> [!example] Ejemplo Práctico

#### Marineros (S2)
| mid | mnombre | rating | edad |
|:--- |:------- |:------ |:---- |
| 28  | yuppy   | 9      | 35.0 |
| 31  | lubber  | 8      | 55.5 |
| 44  | guppy   | 5      | 35.0 |
| 58  | rusty   | 10     | 35.0 |

#### Selección: σ rating>8 (S2)
| mid | mnombre | rating | edad |
| --- | ------- | ------ | ---- |
| 28  | yuppy   | 9      | 35.0 |
| 58  | rusty   | 10     | 35.0 |

#### π mnombre, rating (σ rating>8 (S2))
| mnombre | rating |
| ------- | ------ |
| yuppy   | 9      |
| rusty   | 10     |

### 2.3 Producto Cartesiano (×)

> [!info] Definición
> Combina cada tupla de la primera relación con cada tupla de la segunda relación.

> [!warning] Consideraciones
> - Puede generar relaciones muy grandes
> - Puede haber conflictos de nombres de atributos

> [!example] Ejemplo: S1 × R1

#### S1
| mid | mnombre | rating | edad |
| --- | ------- | ------ | ---- |
| 22  | dustin  | 7      | 45.0 |
| 31  | lubber  | 8      | 55.5 |
| 58  | rusty   | 10     | 35.0 |

#### R1
| mid | bid | dia      |
| --- | --- | -------- |
| 22  | 101 | 10/10/96 |
| 58  | 103 | 11/12/96 |

#### S1 x R1
| mid | mnombre | rating | edad | mid | bid | dia      |
|:---:| ------- | ------ | ---- | --- | --- | -------- |
| 22  | dustin  | 7      | 45.0 | 22  | 101 | 10/10/96 |
| 22  | dustin  | 7      | 45.0 | 58  | 103 | 11/12/96 |
| 31  | lubber  | 8      | 55.5 | 22  | 101 | 10/10/96 |
| 31  | lubber  | 8      | 55.5 | 58  | 103 | 11/12/96 | 
| ... | ...     | ...    | ...  | ... | ... | ...      |

---

## 3. Operaciones de Conjunto

### 3.1 Unión (∪)

> [!info] Definición
> Retorna todas las tuplas que están en R, en S, o en ambas (elimina duplicados).

> [!success] Requisito
> Las relaciones deben ser **compatibles en unión**:
> - Mismo número de columnas
> - Columnas correspondientes del mismo tipo

> [!example] S1 ∪ S2

| mid | mnombre | rating | edad |
| --- | ------- | ------ | ---- |
| 22  | dustin  | 7      | 45.0 |
| 31  | lubber  | 8      | 55.5 |
| 58  | rusty   | 10     | 35.0 |
| --- | -----   | ---    | ---- |
| 28  | yuppy   | 9      | 35.0 |
| 44  | guppy   | 5      | 35.0 |
| --- | -----   | ---    | ---- |

### 3.2 Diferencia (−)

> [!info] Definición
> Retorna las tuplas que están en R pero no en S.

> [!warning] Importante
> R − S ≠ S − R (no es conmutativa)

> [!example] Ejemplos

| S1 − S2 |         | S2 − S1 |      |     |     |         |        |      |
| ------- | ------- | ------- | ---- | --- | --- | ------- | ------ | ---- |
| mid     | mnombre | rating  | edad |     | mid | mnombre | rating | edad |
| 22      | dustin  | 7       | 45.0 |     | 28  | yuppy   | 9      | 35.0 |
|         |         |         |      |     | 44  | guppy   | 5      | 35.0 |

### 3.3 Intersección (∩)

> [!info] Definición
> Retorna las tuplas que están tanto en R como en S.

> [!example] ADMINISTRADOR ∩ PRODUCTOR

| código | nombre        | edad |
| ------ | ------------- | ---- |
| 2      | Enrique Muñoz | 25   |

---

## 4. Operaciones Compuestas Avanzadas

### 4.1 Reunión Natural (⨝)

> [!info] Definición
> Combina dos relaciones basándose en atributos comunes con el mismo nombre.

> [!example] EMPLEADO ⨝ DEPARTAMENTO

| código | nombre        | edad | depto | descripción    |
| ------ | ------------- | ---- | ----- | -------------- |
| 1      | Jorge Campos  | 33   | 1     | Administración |
| 2      | Enrique Muñoz | 25   | 1     | Administración |
| 3      | Esteban Paz   | 21   | 1     | Administración |
| 8      | Jorge Arias   | 30   | 2     | Producción     |
| 10     | Juan Martínez | 19   | 2     | Producción     |

### 4.2 División (÷)

> [!info] Definición
> Encuentra valores que están combinados con todos los valores de otra relación.

> [!example] ARTISTAYGÉNERO ÷ GÉNERO

| codartista |
| ---------- |
| 45         |

> [!success] Explicación
> Solo el artista 45 está combinado con todos los géneros (Soul, Pop, Dance) de la relación GÉNERO.

### 4.3 Semi-reunión (⋉)

> [!info] Definición
> Similar a la reunión natural pero solo muestra los atributos de la relación de la izquierda.

---

## 5. Funciones de Agregación

### 5.1 Funciones Básicas

> [!info] Operador de Agregación (G)

| Función | Descripción         | Ejemplo                   |
| ------- | ------------------- | ------------------------- |
| COUNT   | Número de elementos | G count(mid) (Marineros)  |
| SUM     | Suma de valores     | G sum(rating) (Marineros) |
| AVG     | Promedio de valores | G avg(edad) (Marineros)   |
| MAX     | Valor máximo        | G max(edad) (Marineros)   |
| MIN     | Valor mínimo        | G min(edad) (Marineros)   |

### 5.2 DISTINCT en Agregaciones

> [!warning] Eliminación de Duplicados

| Con DISTINCT                      | Sin DISTINCT             |
| --------------------------------- | ------------------------ |
| G count distinct(nombre-sucursal) | G count(nombre-sucursal) |
| → 3 sucursales                    | → 8 registros            |

### 5.3 Agrupación

> [!info] Agregación por Grupos
> Se utiliza cuando se quiere aplicar funciones de agregación a subconjuntos de datos.

> [!example] Sueldos por Sucursal
> 
> ```sql
> nombre-sucursal G sum(sueldo), max(sueldo) (trabajo-por-horas)
> ```

| nombre-sucursal | suma-sueldo | sueldo-máximo |
| --------------- | ----------- | ------------- |
| Centro          | 5.300       | 2.500         |
| Leganés         | 3.100       | 1.600         |
| Navacerrada     | 8.100       | 5.300         |

---

## 6. Renombramiento (ρ)

### 6.1 Renombramiento de Relaciones

> [!info] Sintaxis
> $$
> \rho_{\text{nuevo_nombre}} (Relación)
> $$

> [!example] Ejemplo
> $$
> \rho_s (PROFE) \times \rho_t (CURSO)
> $$

### 6.2 Renombramiento de Atributos

> [!info] Sintaxis
> $$
> \rho_{R(A,X,C)} (R) \quad \text{o} \quad \pi_{A, B \text{ as } X, C} (R)
> $$

---

## 7. Ejercicios y Casos Prácticos

### 7.1 Ejercicios con Esquema de Marineros

> [!example] Consultas sobre Marineros, Botes y Reservas
> 
> **Esquema:**
> - **Marineros**(mid, mnombre, rating, edad)
> - **Botes**(bid, bnombre, color)
> - **Reserva**(mid, bid, fecha)

> [!success] Resolver en Álgebra Relacional
> 1. **Fechas en que se reservó el bote #103**
>    $$
>    \pi_{\text{fecha}} (\sigma_{\text{bid}=103} (Reserva))
>    $$
> 
> 2. **IDs de marineros que reservaron bote #102**
>    $$
>    \pi_{\text{mid}} (\sigma_{\text{bid}=102} (Reserva))
>    $$
> 
> 3. **Nombres de botes rojos**
>    $$
>    \pi_{\text{bnombre}} (\sigma_{\text{color='Rojo'}} (Botes))
>    $$
> 
> 4. **Edad de marineros con rating > 7**
>    $$
>    \pi_{\text{edad}} (\sigma_{\text{rating}>7} (Marineros))
>    $$

### 7.2 Ejercicios de Agregación

> [!example] Consultas con Funciones de Agregación
> 
> 1. **Cantidad total de marineros**
>    $$
>    G_{\text{count(mid)}} (Marineros)
>    $$
> 
> 2. **Edad promedio de marineros con rating = 10**
>    $$
>    G_{\text{avg(edad)}} (\sigma_{\text{rating}=10} (Marineros))
>    $$
> 
> 3. **Edad del marinero más joven con rating > 7**
>    $$
>    G_{\text{min(edad)}} (\sigma_{\text{rating}>7} (Marineros))
>    $$
> 
> 4. **Edad mínima por nivel de rating**
>    $$
>    _{\text{rating}}G_{\text{min(edad)}} (Marineros)
>    $$

---

## 8. Resumen de Operadores

| Operador            | Símbolo | Descripción                         |
| ------------------- | ------- | ----------------------------------- |
| Proyección          | π       | Selecciona columnas                 |
| Selección           | σ       | Filtra filas                        |
| Producto Cartesiano | ×       | Combina todas las tuplas            |
| Unión               | ∪       | Tuplas en R o S                     |
| Diferencia          | −       | Tuplas en R pero no en S            |
| Intersección        | ∩       | Tuplas en R y S                     |
| Reunión Natural     | ⨝       | Combina por atributos comunes       |
| División            | ÷       | Valores con todas las combinaciones |
| Renombramiento      | ρ       | Cambia nombres                      |

> [!success] Composición de Operaciones
> Como cada operación retorna una relación, las operaciones pueden ser **compuestas**, permitiendo consultas complejas.
