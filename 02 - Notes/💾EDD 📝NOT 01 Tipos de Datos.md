---
fecha: 2025-10-09
tags:
  - 💾EDD
  - 📝NOT
---

# Tipos de Datos
---
> [!info] Los datos se clasifican en tipos según su dominio y operaciones asociadas
Los tipos de datos permiten representar información del mundo real con diferentes características y operaciones.

> [!quote] Datos Primitivos
Son tipos básicos que permiten representar información numérica, caracteres y valores lógicos.

| **Tipo** | **Valores** | **Operaciones** |
|----------|-------------|-----------------|
| Enteros | Números sin decimal | Suma, resta, multiplicación, división |
| Reales | Números con decimal | Operaciones aritméticas |
| Lógicos | True/False | And, Or, Not |
| Caracteres | Letras, símbolos | Concatenar, buscar, subcadena |

> [!bug] Datos Compuestos
> ```java
> // Ejemplos en Java
> int arreglo[];                    // Arreglos
> public class ClaseEjemplo { }     // Clases
> Set, List, Map, Queue            // Colecciones
> ```

> [!info] Abstracción en Programación
> - **Abstracción de Control**: Usar procedimientos sin conocer su implementación
> - **Abstracción de Datos**: Definir nuevos tipos de datos para programas más legibles

> [!success] Tipo de Dato Abstracto (TDA)  
> Un TDA representa entidades reales especificando el **QUÉ** y no el **CÓMO.**
>> [!info] Componentes:
>> - **Comportamiento**: Operaciones que provee el TDA
>> - **Propiedades**: Atributos internos (ocultos al usuario)
>
>> [!question] Implementación en Java:
>> - Clases
>> - Clases Abstractas
>> - Interfaces

> [!bug] Lista TDA
> ```java
> // Representa una colección de elementos
> List<String> lista = new ArrayList<>();
> lista.add("elemento");
> lista.contains("elemento");
> ```
>
>> [!info] Características:
>> - Permite elementos duplicados
>> - No admite valores nulos
>> - Operaciones retornan booleanos de éxito
>
>> [!warning] Para trabajar con TDAs necesitamos:
>> - Java Generics 
>> - Notación asintótica
>> - Recursividad