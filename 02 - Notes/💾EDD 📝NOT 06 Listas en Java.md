---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Listas en Java

## 1. Introducción a los TDA y Listas

> [!info] Concepto de TDA (Tipo de Datos Abstracto)
> Un TDA define el comportamiento de una estructura de datos a través de sus valores y operaciones, sin especificar la implementación concreta.

| **Concepto**       | **Definición**                                   | **Ejemplo en Java**                   |
| ------------------ | ------------------------------------------------ | ------------------------------------- |
| **TDA Lista**      | Colección de 0 o más elementos del mismo tipo    | `interface List<E>`                   |
| **Implementación** | Forma concreta de representar el TDA             | `ArrayList`, `LinkedList`             |
| **Abstracción**    | Separación entre comportamiento e implementación | Mismos métodos, diferente rendimiento |

> [!quote] Propósito fundamental
> "Las listas permiten trabajar dinámicamente con grupos de elementos, creciendo o reduciéndose según las necesidades, ofreciendo mayor flexibilidad que los arreglos tradicionales."

---

## 2. ArrayList: Implementación Estática

### 2.1 Estructura y Funcionamiento

> [!info] Características principales
> - Basado en **array dinámico** (memoria contigua)
> - Capacidad inicial: 10 elementos (por defecto)
> - Crecimiento: 50% más cuando se llena
> - Acceso rápido por índice: O(1)

```java
// Implementación del método add() en ArrayList
public void add(E elemento) {
    if (tamaño == capacidad) {
        expandirCapacidad(); // Incremento del 50%
    }
    array[tamaño] = elemento;
    tamaño++;
}
```

### 2.2 Complejidad de Operaciones

| **Operación**         | **Complejidad** | **Explicación**                    |
| --------------------- | --------------- | ---------------------------------- |
| `get(index)`          | O(1)            | Acceso directo por índice          |
| `add(element)`        | O(1) amortizado | Al final, salvo redimensionamiento |
| `add(index, element)` | O(n)            | Desplazamiento de elementos        |
| `remove(index)`       | O(n)            | Desplazamiento de elementos        |
| `contains(element)`   | O(n)            | Búsqueda lineal                    |

> [!warning] Limitaciones de ArrayList
> - **Redimensionamiento costoso**: Copia de todos los elementos
> - **Inserciones/eliminaciones lentas** en posiciones intermedias
> - **Memoria desperdiciada** cuando la capacidad excede el tamaño real

---

## 3. Listas Enlazadas Simples

### 3.1 Estructura de Nodos

> [!bug] Implementación del Nodo
> ```java
> class Nodo<E> {
>     E dato;
>     Nodo<E> siguiente;
>     
>     public Nodo(E dato) {
>         this.dato = dato;
>         this.siguiente = null;
>     }
> }
> ```

### 3.2 Operaciones Principales

```java
// Inserción al inicio - O(1)
public void addFirst(E dato) {
    Nodo<E> nuevoNodo = new Nodo<>(dato);
    nuevoNodo.siguiente = cabeza;
    cabeza = nuevoNodo;
    tamaño++;
}

// Inserción al final - O(n)
public void add(E dato) {
    Nodo<E> nuevoNodo = new Nodo<>(dato);
    if (cabeza == null) {
        cabeza = nuevoNodo;
    } else {
        Nodo<E> actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevoNodo;
    }
    tamaño++;
}
```

### 3.3 Complejidad de Operaciones

| **Operación**   | **Complejidad** | **Ventaja/Desventaja**                      |
| --------------- | --------------- | ------------------------------------------- |
| `addFirst()`    | O(1)            | **Muy rápido** al inicio                    |
| `addLast()`     | O(n)            | **Lento** - requiere recorrer toda la lista |
| `get(index)`    | O(n)            | **Acceso secuencial**                       |
| `removeFirst()` | O(1)            | **Eficiente** para pilas                    |

> [!example] Casos de uso prácticos
> - **Historial de navegación**: Nuevas páginas se añaden al inicio
> - **Sistemas de pila (LIFO)**: Operaciones push/pop eficientes
> - **Buffers de mensajes**: Procesamiento secuencial

---

## 4. Listas Doblemente Enlazadas

### 4.1 Estructura Mejorada

> [!bug] Nodo Doblemente Enlazado
> ```java
> class NodoDoble<E> {
>     E dato;
>     NodoDoble<E> siguiente;
>     NodoDoble<E> anterior;
>     
>     public NodoDoble(E dato) {
>         this.dato = dato;
>         this.siguiente = null;
>         this.anterior = null;
>     }
> }
> ```

### 4.2 Ventajas Operacionales

```java
// Inserción al final - O(1) con referencia a cola
public void add(E dato) {
    NodoDoble<E> nuevoNodo = new NodoDoble<>(dato);
    if (cabeza == null) {
        cabeza = cola = nuevoNodo;
    } else {
        cola.siguiente = nuevoNodo;
        nuevoNodo.anterior = cola;
        cola = nuevoNodo;
    }
    tamaño++;
}
```

| **Operación**  | **Simple**    | **Doble**     | **Mejora**             |
| -------------- | ------------- | ------------- | ---------------------- |
| `addFirst()`   | O(1)          | O(1)          | Igual                  |
| `addLast()`    | O(n)          | O(1)          | **Significativa**      |
| `removeLast()` | O(n)          | O(1)          | **Significativa**      |
| Navegación     | Solo adelante | Bidireccional | **Mayor flexibilidad** |

> [!success] Aplicaciones ideales
> - **Editores de texto**: Navegación bidireccional entre caracteres
> - **Reproductores multimedia**: Avance/retroceso entre canciones
> - **Sistemas de navegación**: Rutas forward/backward

---

## 5. Listas Circulares

### 5.1 Lista Circular Simple

> [!info] Concepto fundamental
> El último nodo apunta al primero, formando un ciclo continuo.

```java
// Estructura circular - el último nodo apunta a cabeza
public void add(E dato) {
    NodoCircular<E> nuevoNodo = new NodoCircular<>(dato);
    if (cabeza == null) {
        cabeza = nuevoNodo;
        cola = nuevoNodo;
        cola.siguiente = cabeza; // Circularidad
    } else {
        cola.siguiente = nuevoNodo;
        nuevoNodo.siguiente = cabeza;
        cola = nuevoNodo;
    }
    tamaño++;
}
```

### 5.2 Lista Circular Doble

> [!bug] Implementación completa
> ```java
> // En lista circular doble: cabeza.anterior = cola y cola.siguiente = cabeza
> public void add(E dato) {
>     NodoDobleCircular<E> nuevoNodo = new NodoDobleCircular<>(dato);
>     if (cabeza == null) {
>         cabeza = nuevoNodo;
>         cabeza.siguiente = cabeza;
>         cabeza.anterior = cabeza;
>     } else {
>         NodoDobleCircular<E> cola = cabeza.anterior;
>         cola.siguiente = nuevoNodo;
>         nuevoNodo.anterior = cola;
>         nuevoNodo.siguiente = cabeza;
>         cabeza.anterior = nuevoNodo;
>     }
>     tamaño++;
> }
> ```

### 5.3 Comparativa de Complejidad

| **Operación**   | **Circular Simple**     | **Circular Doble**     |
| --------------- | ----------------------- | ---------------------- |
| `addFirst()`    | O(1)                    | O(1)                   |
| `addLast()`     | O(n)                    | O(1)                   |
| `removeFirst()` | O(1)                    | O(1)                   |
| `removeLast()`  | O(n)                    | O(1)                   |
| Navegación      | Unidireccional continua | Bidireccional continua |

> [!example] Aplicaciones cíclicas
> - **Sistemas de turnos**: Jugadores en juegos multijugador
> - **Buffers circulares**: Streaming de audio/video
> - **Planificación Round Robin**: Sistemas operativos
> - **Carruseles de productos**: E-commerce

---

## 6. Comparativa Completa de Estructuras

### 6.1 Rendimiento por Operación

> [!info] Tabla comparativa exhaustiva
> | **Estructura** | **Acceso** | **Inserción Inicio** | **Inserción Final** | **Inserción Medio** | **Memoria** |
> |----------------|------------|----------------------|---------------------|---------------------|-------------|
> | **ArrayList** | O(1) | O(n) | O(1) amortizado | O(n) | Más eficiente |
> | **Lista Simple** | O(n) | O(1) | O(n) | O(n) | Moderado |
> | **Lista Doble** | O(n) | O(1) | O(1) | O(n)* | Mayor overhead |
> | **Circular Simple** | O(n) | O(1) | O(n) | O(n) | Similar a simple |
> | **Circular Doble** | O(n) | O(1) | O(1) | O(n)* | Mayor overhead |

*O(1) si se tiene referencia al nodo, O(n) para encontrar la posición

### 6.2 Casos de Uso Recomendados

> [!success] Guía de selección
> | **Escenario** | **Estructura Recomendada** | **Razón** |
> |---------------|----------------------------|-----------|
> | **Acceso frecuente por índice** | ArrayList | O(1) para acceso aleatorio |
> | **Muchas inserciones al inicio** | Cualquier lista enlazada | O(1) vs O(n) de ArrayList |
> | **Inserción/eliminación frecuente** | LinkedList doble | O(1) en extremos |
> | **Navegación bidireccional** | Lista doblemente enlazada | Referencias anterior/siguiente |
> | **Procesamiento cíclico** | Lista circular | Recorrido infinito sin fin |
> | **Memoria limitada** | ArrayList | Sin overhead de punteros |

---

## 7. Implementación de Estructuras Genéricas

### 7.1 Retos y Soluciones

> [!warning] Limitaciones de Java
> - **Borrado de tipos**: Información de genéricos se pierde en runtime
> - **No se pueden crear arrays de tipos genéricos**: `new T[size]` no permitido
> - **Necesidad de reflección** para arrays genéricos

> [!bug] Solución con Array.newInstance
> ```java
> public class MiArrayList<E> {
>     private E[] array;
>     private Class<E> tipo;
>     
>     @SuppressWarnings("unchecked")
>     public MiArrayList(Class<E> tipo, int capacidad) {
>         this.tipo = tipo;
>         this.array = (E[]) Array.newInstance(tipo, capacidad);
>     }
> }
> ```

### 7.2 Alternativas de Implementación

> [!info] Estrategias disponibles
> 1. **Usar Object[] y casting**: Menos seguro, más flexible
> 2. **Array.newInstance**: Tipo-safe, requiere Class<T>
> 3. **Listas enlazadas**: Evitan problemas de arrays
> 4. **Composición sobre herencia**: Mayor control

---

## 8. Algoritmos Avanzados y Recursividad

### 8.1 Métodos Recursivos en Listas

> [!bug] Reordenamiento recursivo
> ```java
> private Node reOrdenarRecursivo(int n) {
>     if (head == null || head.next == null) {
>         return head;
>     }
>     
>     Node current = head;
>     head = head.next;
>     Node rest = reOrdenarRecursivo(n);
>     
>     if (current.element <= n) {
>         current.next = rest;
>         return current;
>     } else {
>         // Mover al final recursivamente
>         Node temp = rest;
>         while (temp.next != null) {
>             temp = temp.next;
>         }
>         temp.next = current;
>         current.next = null;
>         return rest;
>     }
> }
> ```

### 8.2 Reorganización por Criterios

```java
public void reorganizarPorCriterio(int n, String criterio) {
    // Mover elementos según criterio "menor" o "mayor"
    // Útil para particionar listas, ordenamientos, filtrados
}
```

> [!tip] Aplicaciones de algoritmos avanzados
> - **Partición de listas**: Para algoritmos como QuickSort
> - **Filtrado en tiempo real**: Reorganizar según condiciones
> - **Procesamiento por lotes**: Agrupar elementos similares

---

## 9. Conclusiones y Mejores Prácticas

### 9.1 Resumen de Elección

> [!quote] Regla general
> "Usa **ArrayList** cuando necesites acceso rápido por índice y **LinkedList** cuando realices muchas inserciones/eliminaciones. Las variantes circulares son ideales para procesamiento continuo."

### 9.2 Consideraciones de Diseño

> [!success] Buenas prácticas
> - **Evalúa el patrón de uso** antes de elegir la estructura
> - **Considera la complejidad de memoria** en dispositivos limitados
> - **Usa iteradores** para recorridos seguros
> - **Implementa interfaces estándar** para compatibilidad

> [!warning] Errores comunes
> - Usar ArrayList para muchas inserciones en medio
> - Ignorar el costo del redimensionamiento
> - No considerar la localidad de memoria en ArrayList
> - Subestimar el overhead de memoria en LinkedList

### 9.3 Tendencias y Evolución

> [!info] En el mundo real
> - **ArrayList** es más común en aplicaciones generales
> - **LinkedList** se usa en casos específicos de alto rendimiento
> - **Estructuras híbridas** ganan popularidad para casos especializados
> - **Colecciones persistentes** emergen en programación funcional
