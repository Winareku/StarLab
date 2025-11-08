---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# ArrayList vs LinkedList en Java

## 1. Introducción a las Listas en Java

> [!info] Información clave
> Las listas son estructuras de datos fundamentales en Java que permiten almacenar colecciones de elementos. Las dos implementaciones más comunes son **ArrayList** y **LinkedList**, cada una con características y ventajas diferentes.

| **ArrayList**                                         | **LinkedList**                                     | **Diferencia Principal**      |
| ----------------------------------------------------- | -------------------------------------------------- | ----------------------------- |
| Basado en array dinámico                              | Basado en nodos enlazados                          | Estructura de almacenamiento  |
| Acceso rápido por índice (O(1))                       | Acceso secuencial (O(n))                           | Velocidad de acceso           |
| Inserción/eliminación lenta en posiciones intermedias | Inserción/eliminación rápida en cualquier posición | Rendimiento en modificaciones |

---

## 2. ArrayList

### 2.1 Estructura Interna

> [!info] Características de ArrayList
> - Usa un **array dinámico** como estructura subyacente
> - Los elementos se almacenan en **memoria contigua**
> - Capacidad inicial por defecto: 10 elementos
> - Expansión automática cuando se llena (generalmente 50% más)

```java
// Ejemplo básico de ArrayList
ArrayList<String> lista = new ArrayList<>();
lista.add("Primero");
lista.add("Segundo");
lista.add("Tercero");
```

### 2.2 Implementación del Método add()

> [!bug] Código de implementación
> ```java
> public class MiArrayList<E> {
>     private int tamaño = 0;
>     private E[] array;
>     
>     public void add(E elemento) {
>         if (tamaño == array.length) {
>             expandirCapacidad(); // Expande en 50%
>         }
>         array[tamaño] = elemento;
>         tamaño++;
>     }
>     
>     private void expandirCapacidad() {
>         int nuevaCapacidad = array.length + (array.length / 2);
>         E[] nuevoArray = (E[]) new Object[nuevaCapacidad];
>         // Copiar elementos al nuevo array
>         array = nuevoArray;
>     }
> }
> ```

> [!warning] Consideraciones de rendimiento
> - **Redimensionamiento costoso**: Copiar elementos al nuevo array es O(n)
> - **Inserción en medio**: Requiere desplazar elementos (O(n))

---

## 3. LinkedList

### 3.1 Estructura de Nodos

> [!info] Clase Nodo fundamental
> Cada nodo contiene:
> - **Datos**: El valor almacenado
> - **Siguiente**: Referencia al nodo siguiente
> - **Anterior** (en listas doblemente enlazadas)

```java
// Nodo para lista simplemente enlazada
class Nodo<E> {
    E dato;
    Nodo<E> siguiente;
    
    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Nodo para lista doblemente enlazada
class NodoDoble<E> {
    E dato;
    NodoDoble<E> siguiente;
    NodoDoble<E> anterior;
    
    public NodoDoble(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
```

### 3.2 Implementación del Método add()

> [!bug] Código de implementación
> ```java
> public class MiLinkedList<E> {
>     private Nodo<E> cabeza;
>     private int tamaño = 0;
>     
>     public void add(E dato) {
>         Nodo<E> nuevoNodo = new Nodo<>(dato);
>         if (cabeza == null) {
>             cabeza = nuevoNodo;
>         } else {
>             Nodo<E> actual = cabeza;
>             while (actual.siguiente != null) {
>                 actual = actual.siguiente;
>             }
>             actual.siguiente = nuevoNodo;
>         }
>         tamaño++;
>     }
>     
>     public int size() {
>         return tamaño;
>     }
> }
> ```

### 3.3 Métodos Especiales de LinkedList

> [!success] Ventajas operacionales
> ```java
> LinkedList<String> lista = new LinkedList<>();
> 
> // Métodos exclusivos de LinkedList
> lista.addFirst("Inicio");    // O(1)
> lista.addLast("Final");      // O(1)
> lista.removeFirst();         // O(1)
> lista.removeLast();          // O(1)
> 
> // Útiles para pilas y colas
> lista.push("Elemento");      // Similar a addFirst()
> lista.pop();                 // Similar to removeFirst()
> lista.peek();                // Ver primer elemento sin eliminar
> ```

---

## 4. Comparación de Rendimiento

> [!info] Tabla comparativa de complejidades
> | **Operación** | **ArrayList** | **LinkedList** |
> |---------------|---------------|----------------|
> | **Acceso por índice** | O(1) | O(n) |
> | **Inserción al final** | O(1) (amortizado) | O(1) |
> | **Inserción en medio** | O(n) | O(1) * |
> | **Eliminación en medio** | O(n) | O(1) * |
> | **Búsqueda** | O(n) | O(n) |

> [!note] Nota importante
> * Las operaciones O(1) en LinkedList asumen que ya se tiene referencia al nodo. Si no, la búsqueda es O(n).

---

## 5. Casos de Uso Recomendados

### 5.1 Cuándo usar ArrayList

> [!success] Escenarios ideales para ArrayList
> - **Acceso frecuente por índice**: Cuando necesitas obtener elementos por posición rápidamente
> - **Iteraciones secuenciales**: Los datos contiguos son más eficientes para la CPU
> - **Menos modificaciones**: Pocas inserciones/eliminaciones en posiciones intermedias
> - **Tamaño predecible**: Minimiza redimensionamientos

### 5.2 Cuándo usar LinkedList

> [!success] Escenarios ideales para LinkedList
> - **Muchas modificaciones**: Frecuentes inserciones/eliminaciones en cualquier posición
> - **Implementación de pilas/colas**: Operaciones LIFO/FIFO eficientes
> - **Tamaño variable**: No requiere redimensionamiento
> - **Acceso secuencial**: Cuando el acceso aleatorio no es prioritario

---

## 6. Ejemplos Prácticos

### 6.1 ArrayList en Acción

> [!example] Uso típico de ArrayList
> ```java
> ArrayList<String> frutas = new ArrayList<>();
> frutas.add("Manzana");
> frutas.add("Banana");
> frutas.add(1, "Naranja"); // Inserta en posición específica
> 
> // Acceso rápido por índice
> String primeraFruta = frutas.get(0); // "Manzana"
> 
> // Iteración eficiente
> for (String fruta : frutas) {
>     System.out.println(fruta);
> }
> ```

### 6.2 LinkedList en Acción

> [!example] Uso típico de LinkedList
> ```java
> LinkedList<Integer> numeros = new LinkedList<>();
> numeros.add(10);
> numeros.addFirst(5);    // Al inicio
> numeros.addLast(15);    // Al final
> 
> // Como pila
> numeros.push(20);       // Equivale a addFirst()
> int tope = numeros.pop(); // Equivale a removeFirst()
> 
> // Como cola
> numeros.offer(25);      // Equivale a addLast()
> int cabeza = numeros.poll(); // Equivale a removeFirst()
> ```

---

## 7. Conclusiones

> [!quote] Resumen final
> "La elección entre ArrayList y LinkedList depende del tipo de operaciones que predominen en tu aplicación. **ArrayList para acceso rápido**, **LinkedList para modificaciones frecuentes**."

> [!warning] Puntos clave a recordar
> - **ArrayList** es generalmente más eficiente en memoria
> - **LinkedList** ofrece mejor rendimiento en modificaciones
> - Considera el **patrón de uso** antes de elegir
> - Ambas implementan la interfaz `List`, por lo que son intercambiables a nivel de API
