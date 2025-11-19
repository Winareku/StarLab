---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Mapas en Java: HashMap, LinkedHashMap y TreeMap

## 1. Introducción a los Mapas en Java

> [!info] TDA Mapa (Diccionario)
> Un **Mapa** (o **Diccionario**) es una estructura de datos que almacena pares clave-valor, donde cada clave debe ser única y está asociada a un único valor.

**Características principales:**
- No se permiten claves duplicadas
- Operaciones básicas: insertar, buscar y eliminar
- Implementaciones principales: `HashMap`, `LinkedHashMap`, `TreeMap`

---

## 2. Diferencias entre HashMap, LinkedHashMap y TreeMap

| **HashMap** | **LinkedHashMap** | **TreeMap** |
| ----------- | ----------------- | ----------- |
| No mantiene orden | Mantiene orden de inserción | Ordena claves automáticamente |
| Más rápido para operaciones básicas | Rendimiento ligeramente inferior | Más lento por operaciones de ordenamiento |
| No garantiza orden al iterar | Orden predecible de iteración | Orden natural o personalizado |

### 2.1 HashMap
> [!warning] Características HashMap
> - **Sin orden**: Las claves se retornan sin ningún orden particular
> - **Rendimiento óptimo**: Más rápido para insertar, eliminar y buscar
> - **Uso ideal**: Cuando el orden no es importante y se prioriza el rendimiento

### 2.2 LinkedHashMap
> [!info] Características LinkedHashMap
> - **Orden de inserción**: Mantiene el orden en que se insertaron las entradas
> - **Rendimiento medio**: Ligeramente más lento que HashMap
> - **Uso ideal**: Cuando se requiere un orden predecible de iteración

### 2.3 TreeMap
> [!success] Características TreeMap
> - **Orden automático**: Ordena las claves según orden natural o Comparator
> - **Rendimiento más lento**: Debido a operaciones de ordenamiento
> - **Uso ideal**: Cuando se requiere ordenamiento alfabético o numérico

---

## 3. Ejemplos Prácticos

### 3.1 Agenda con HashMap
> [!bug] Código
> ```java
> Map<String, String> agenda = new HashMap<>();
> agenda.put("Carlos", "0991234567");
> agenda.put("Ana", "0987654321");
> // Resultado: Sin orden específico
> ```

### 3.2 Agenda con LinkedHashMap
> [!bug] Código
> ```java
> Map<String, String> agenda = new LinkedHashMap<>();
> agenda.put("Carlos", "0991234567");
> agenda.put("Ana", "0987654321");
> // Resultado: Orden de inserción (Carlos, Ana)
> ```

### 3.3 Agenda con TreeMap
> [!bug] Código
> ```java
> Map<String, String> agenda = new TreeMap<>();
> agenda.put("Carlos", "0991234567");
> agenda.put("Ana", "0987654321");
> // Resultado: Orden alfabético (Ana, Carlos)
> ```

---

## 4. Funciones Comunes de Mapas

> [!example] Operaciones básicas
> ```java
> Map<String, String> agenda = new HashMap<>();
> 
> // Agregar o reemplazar
> agenda.put("Clave", "Valor");
> agenda.replace("Clave", "NuevoValor");
> 
> // Consultar
> String valor = agenda.get("Clave");
> boolean existeClave = agenda.containsKey("Clave");
> boolean existeValor = agenda.containsValue("Valor");
> 
> // Eliminar
> agenda.remove("Clave");
> 
> // Recorrer
> for (String clave : agenda.keySet()) { }
> for (String valor : agenda.values()) { }
> for (Map.Entry<String, String> entry : agenda.entrySet()) { }
> ```

---

## 5. Casos de Uso Avanzados

### 5.1 Agenda Multivaluada
> [!tip] Mapa con múltiples valores por clave
> ```java
> Map<String, List<String>> contactos = new HashMap<>();
> contactos.computeIfAbsent(nombre, k -> new ArrayList<>()).add(telefono);
> ```

### 5.2 Agenda Compleja con Objetos
> [!bug] Código
> ```java
> public class AgendaCompleja {
>     private Map<String, Contacto> contactos = new TreeMap<>();
>     // Orden automático por nombre
> }
> ```

---

## 6. Resumen de Selección

| **Criterio** | **HashMap** | **LinkedHashMap** | **TreeMap** |
| ------------ | ----------- | ----------------- | ----------- |
| **Orden** | Ninguno | Inserción | Natural/Comparator |
| **Rendimiento** | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐ |
| **Uso común** | Búsquedas rápidas | Mantener orden inserción | Ordenamiento automático |

> [!success] Recomendación final
> - Usa **HashMap** para máximo rendimiento sin necesidad de orden
> - Usa **LinkedHashMap** para mantener orden de inserción
> - Usa **TreeMap** cuando necesites las claves ordenadas

