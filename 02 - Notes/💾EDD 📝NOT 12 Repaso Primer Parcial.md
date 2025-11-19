---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Guía Práctica de Implementación de Estructuras de Datos en Java

## 1. Nodos - La Base de las Estructuras Enlazadas

> [!info] Concepto fundamental Un **nodo** es la unidad básica de las estructuras enlazadas. Contiene datos y referencias a otros nodos.

### 1.1 Tipos de Nodos

|Tipo|Campos|Uso|
|---|---|---|
|**Simple**|dato, siguiente|Listas simples, pilas|
|**Doble**|dato, siguiente, anterior|Listas dobles, colas|
|**Circular**|dato, siguiente (apunta al inicio)|Listas circulares|

### 1.2 Implementación Paso a Paso

> [!bug] Código - Nodo Simple
> 
> ```java
> class Nodo<T> {
>     T dato;
>     Nodo<T> siguiente;
>     
>     public Nodo(T dato) {
>         this.dato = dato;
>         this.siguiente = null;
>     }
> }
> ```

> [!bug] Código - Nodo Doble
> 
> ```java
> class NodoDoble<T> {
>     T dato;
>     NodoDoble<T> siguiente;
>     NodoDoble<T> anterior;
>     
>     public NodoDoble(T dato) {
>         this.dato = dato;
>         this.siguiente = null;
>         this.anterior = null;
>     }
> }
> ```

> [!warning] Errores comunes
> 
> - Olvidar inicializar las referencias en `null`
> - No actualizar ambas referencias (siguiente y anterior) en nodos dobles
> - Perder referencias al modificar enlaces

---

## 2. Lista Enlazada Simple

> [!info] Estructura básica Secuencia de nodos donde cada uno apunta al siguiente. Requiere mantener referencia a la **cabeza**.

### 2.1 Estructura de la Clase

```java
public class ListaEnlazadaSimple<T> {
    private Nodo<T> cabeza;
    private int tamaño;
    
    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.tamaño = 0;
    }
}
```

### 2.2 Operación: Agregar al Inicio

> [!example] Procedimiento paso a paso
> 
> 1. Crear el nuevo nodo con el dato
> 2. Hacer que el nuevo nodo apunte a la cabeza actual
> 3. Actualizar cabeza para que apunte al nuevo nodo
> 4. Incrementar tamaño

> [!bug] Código - addFirst()
> 
> ```java
> public void addFirst(T dato) {
>     Nodo<T> nuevoNodo = new Nodo<>(dato);
>     nuevoNodo.siguiente = cabeza;  // El nuevo apunta a la cabeza actual
>     cabeza = nuevoNodo;            // Cabeza ahora es el nuevo nodo
>     tamaño++;
> }
> ```

### 2.3 Operación: Agregar al Final

> [!example] Procedimiento paso a paso
> 
> 1. Crear el nuevo nodo
> 2. Si la lista está vacía, el nuevo nodo es la cabeza
> 3. Si no, recorrer hasta el último nodo
> 4. Hacer que el último nodo apunte al nuevo
> 5. Incrementar tamaño

> [!bug] Código - addLast()
> 
> ```java
> public void addLast(T dato) {
>     Nodo<T> nuevoNodo = new Nodo<>(dato);
>     
>     if (cabeza == null) {
>         cabeza = nuevoNodo;
>     } else {
>         Nodo<T> actual = cabeza;
>         while (actual.siguiente != null) {
>             actual = actual.siguiente;
>         }
>         actual.siguiente = nuevoNodo;
>     }
>     tamaño++;
> }
> ```

### 2.4 Operación: Eliminar por Valor

> [!example] Procedimiento paso a paso
> 
> 1. Caso especial: si el nodo a eliminar es la cabeza
> 2. Caso general: recorrer hasta encontrar el nodo anterior al que se eliminará
> 3. Cambiar la referencia del nodo anterior para que apunte al siguiente del nodo a eliminar
> 4. Decrementar tamaño

> [!bug] Código - remove()
> 
> ```java
> public boolean remove(T dato) {
>     if (cabeza == null) return false;
>     
>     // Caso: eliminar la cabeza
>     if (cabeza.dato.equals(dato)) {
>         cabeza = cabeza.siguiente;
>         tamaño--;
>         return true;
>     }
>     
>     // Caso general
>     Nodo<T> actual = cabeza;
>     while (actual.siguiente != null) {
>         if (actual.siguiente.dato.equals(dato)) {
>             actual.siguiente = actual.siguiente.siguiente;
>             tamaño--;
>             return true;
>         }
>         actual = actual.siguiente;
>     }
>     return false;
> }
> ```

> [!warning] Errores comunes
> 
> - No verificar si la lista está vacía antes de eliminar
> - Perder la referencia al nodo anterior
> - No manejar el caso especial cuando se elimina la cabeza
> - Olvidar decrementar el tamaño

---

## 3. Lista Doblemente Enlazada

> [!info] Diferencia clave Cada nodo tiene referencia al **siguiente** y al **anterior**. Mantener referencias a **cabeza** y **cola**.

### 3.1 Estructura de la Clase

```java
public class ListaDobleEnlazada<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamaño;
    
    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }
}
```

### 3.2 Operación: Agregar al Final

> [!example] Procedimiento paso a paso
> 
> 1. Crear el nuevo nodo
> 2. Si la lista está vacía, cabeza y cola apuntan al nuevo nodo
> 3. Si no, conectar el nuevo nodo con la cola actual:
>     - `cola.siguiente = nuevoNodo`
>     - `nuevoNodo.anterior = cola`
>     - `cola = nuevoNodo`
> 4. Incrementar tamaño

> [!bug] Código - addLast()
> 
> ```java
> public void addLast(T dato) {
>     NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
>     
>     if (cabeza == null) {
>         cabeza = cola = nuevoNodo;
>     } else {
>         cola.siguiente = nuevoNodo;
>         nuevoNodo.anterior = cola;
>         cola = nuevoNodo;
>     }
>     tamaño++;
> }
> ```

### 3.3 Operación: Eliminar del Final

> [!example] Procedimiento paso a paso
> 
> 1. Verificar que la lista no esté vacía
> 2. Si solo hay un nodo, cabeza y cola pasan a `null`
> 3. Si hay más nodos:
>     - `cola = cola.anterior`
>     - `cola.siguiente = null`
> 4. Decrementar tamaño

> [!bug] Código - removeLast()
> 
> ```java
> public T removeLast() {
>     if (cola == null) throw new NoSuchElementException();
>     
>     T dato = cola.dato;
>     
>     if (cabeza == cola) {
>         cabeza = cola = null;
>     } else {
>         cola = cola.anterior;
>         cola.siguiente = null;
>     }
>     tamaño--;
>     return dato;
> }
> ```

> [!warning] Errores comunes
> 
> - No actualizar ambas referencias (siguiente y anterior)
> - Olvidar actualizar cabeza o cola en casos límite
> - No manejar el caso cuando solo hay un nodo
> - Perder referencias antes de actualizar

---

## 4. Lista Circular Simple

> [!info] Característica distintiva El último nodo apunta al primero, formando un ciclo. Mantener referencia a **cola** (más eficiente que cabeza).

### 4.1 Estructura de la Clase

```java
public class ListaCircularSimple<T> {
    private Nodo<T> cola;
    private int tamaño;
    
    public ListaCircularSimple() {
        this.cola = null;
        this.tamaño = 0;
    }
}
```

### 4.2 Operación: Agregar al Final

> [!example] Procedimiento paso a paso
> 
> 1. Crear el nuevo nodo
> 2. Si la lista está vacía:
>     - El nodo apunta a sí mismo
>     - Cola apunta al nuevo nodo
> 3. Si no está vacía:
>     - Nuevo nodo apunta a `cola.siguiente` (la cabeza)
>     - Cola actual apunta al nuevo nodo
>     - Cola se actualiza al nuevo nodo
> 4. Incrementar tamaño

> [!bug] Código - add()
> 
> ```java
> public void add(T dato) {
>     Nodo<T> nuevoNodo = new Nodo<>(dato);
>     
>     if (cola == null) {
>         cola = nuevoNodo;
>         cola.siguiente = cola;  // Apunta a sí mismo
>     } else {
>         nuevoNodo.siguiente = cola.siguiente;  // Apunta a la cabeza
>         cola.siguiente = nuevoNodo;            // Cola apunta al nuevo
>         cola = nuevoNodo;                      // Actualizar cola
>     }
>     tamaño++;
> }
> ```

> [!warning] Errores comunes
> 
> - Olvidar hacer que el último nodo apunte al primero
> - No manejar correctamente el caso de lista vacía (nodo debe apuntar a sí mismo)
> - Perder la referencia al primer nodo al agregar

---

## 5. Lista Circular Doble

> [!info] Combinación de características Combina listas circulares y doblemente enlazadas. Cada nodo tiene `siguiente` y `anterior`, formando un ciclo bidireccional.

### 5.1 Estructura de la Clase

```java
public class ListaCircularDoble<T> {
    private NodoDoble<T> cabeza;
    private int tamaño;
    
    public ListaCircularDoble() {
        this.cabeza = null;
        this.tamaño = 0;
    }
}
```

### 5.2 Operación: Agregar al Final

> [!example] Procedimiento paso a paso
> 
> 1. Crear el nuevo nodo
> 2. Si la lista está vacía:
>     - Cabeza apunta al nuevo nodo
>     - Nuevo nodo apunta a sí mismo en ambas direcciones
> 3. Si no está vacía:
>     - Obtener la cola (`cabeza.anterior`)
>     - Conectar cola con nuevo nodo
>     - Conectar nuevo nodo con cabeza
>     - Actualizar referencias circulares
> 4. Incrementar tamaño

> [!bug] Código - add()
> 
> ```java
> public void add(T dato) {
>     NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
>     
>     if (cabeza == null) {
>         cabeza = nuevoNodo;
>         cabeza.siguiente = cabeza;
>         cabeza.anterior = cabeza;
>     } else {
>         NodoDoble<T> cola = cabeza.anterior;
>         cola.siguiente = nuevoNodo;
>         nuevoNodo.anterior = cola;
>         nuevoNodo.siguiente = cabeza;
>         cabeza.anterior = nuevoNodo;
>     }
>     tamaño++;
> }
> ```

> [!warning] Errores comunes
> 
> - No establecer correctamente las cuatro conexiones necesarias
> - Olvidar actualizar `cabeza.anterior` para mantener la circularidad
> - No manejar el caso de lista vacía (debe apuntar a sí mismo en ambas direcciones)

---

## 6. Pila (Stack) - Implementación con ArrayList

> [!info] Principio LIFO Last In, First Out - El último en entrar es el primero en salir. Solo se opera desde el **tope**.

### 6.1 Estructura de la Clase

```java
public class PilaArrayList<T> {
    private ArrayList<T> lista;
    
    public PilaArrayList() {
        this.lista = new ArrayList<>();
    }
}
```

### 6.2 Operaciones Principales

> [!bug] Código - Operaciones de Pila
> 
> ```java
> public void push(T elemento) {
>     lista.add(elemento);  // Agregar al final
> }
> 
> public T pop() {
>     if (isEmpty()) throw new NoSuchElementException("Pila vacía");
>     return lista.remove(lista.size() - 1);  // Eliminar del final
> }
> 
> public T peek() {
>     if (isEmpty()) throw new NoSuchElementException("Pila vacía");
>     return lista.get(lista.size() - 1);  // Ver sin eliminar
> }
> 
> public boolean isEmpty() {
>     return lista.isEmpty();
> }
> 
> public int size() {
>     return lista.size();
> }
> ```

> [!warning] Errores comunes
> 
> - No verificar si la pila está vacía antes de `pop()` o `peek()`
> - Confundir el índice del tope (`size() - 1`)
> - No decrementar el tamaño al hacer pop

---

## 7. Cola (Queue) - Implementación con LinkedList

> [!info] Principio FIFO First In, First Out - El primero en entrar es el primero en salir. Se agrega por el **final** y se elimina por el **frente**.

### 7.1 Estructura de la Clase

```java
public class ColaLinkedList<T> {
    private LinkedList<T> lista;
    
    public ColaLinkedList() {
        this.lista = new LinkedList<>();
    }
}
```

### 7.2 Operaciones Principales

> [!bug] Código - Operaciones de Cola
> 
> ```java
> public void encolar(T elemento) {
>     lista.addLast(elemento);  // Agregar al final
> }
> 
> public T desencolar() {
>     if (isEmpty()) throw new NoSuchElementException("Cola vacía");
>     return lista.removeFirst();  // Eliminar del frente
> }
> 
> public T frente() {
>     if (isEmpty()) throw new NoSuchElementException("Cola vacía");
>     return lista.getFirst();  // Ver sin eliminar
> }
> 
> public boolean isEmpty() {
>     return lista.isEmpty();
> }
> 
> public int size() {
>     return lista.size();
> }
> ```

> [!warning] Errores comunes
> 
> - Confundir el orden: agregar y eliminar por el mismo extremo
> - No verificar si la cola está vacía antes de desencolar
> - Usar ArrayList para colas (ineficiente en `remove(0)`)

---

## 8. Cola Circular con Arreglo

> [!info] Optimización de espacio Usa un arreglo fijo donde el siguiente índice después del último es el primero. Evita desperdicio de espacio.

### 8.1 Estructura de la Clase

```java
public class ColaCircular<T> {
    private Object[] array;
    private int frente;
    private int fin;
    private int capacidad;
    
    public ColaCircular(int capacidad) {
        this.array = new Object[capacidad + 1];  // +1 para distinguir llena/vacía
        this.frente = 0;
        this.fin = 0;
        this.capacidad = capacidad + 1;
    }
}
```

### 8.2 Función Auxiliar: Siguiente Índice

> [!bug] Código - Cálculo circular
> 
> ```java
> private int siguiente(int indice) {
>     return (indice + 1) % capacidad;
> }
> ```

### 8.3 Operaciones Principales

> [!bug] Código - Operaciones de Cola Circular
> 
> ```java
> public void encolar(T elemento) {
>     if (estaLlena()) throw new IllegalStateException("Cola llena");
>     array[fin] = elemento;
>     fin = siguiente(fin);
> }
> 
> @SuppressWarnings("unchecked")
> public T desencolar() {
>     if (estaVacia()) throw new NoSuchElementException("Cola vacía");
>     T elemento = (T) array[frente];
>     frente = siguiente(frente);
>     return elemento;
> }
> 
> public boolean estaVacia() {
>     return frente == siguiente(fin);
> }
> 
> public boolean estaLlena() {
>     return frente == siguiente(siguiente(fin));
> }
> ```

> [!warning] Errores comunes
> 
> - No reservar un espacio extra para distinguir cola llena de vacía
> - Olvidar usar el operador módulo para circularidad
> - Confundir las condiciones de vacía y llena

---

## 9. Iteradores Personalizados

> [!info] Propósito Permiten recorrer una estructura de datos sin exponer su implementación interna. Implementan la interfaz `Iterator<T>`.

### 9.1 Estructura Básica

```java
private class MiIterador implements Iterator<T> {
    private Nodo<T> actual;
    private Nodo<T> anterior;
    
    public MiIterador() {
        this.actual = cabeza;
        this.anterior = null;
    }
    
    @Override
    public boolean hasNext() {
        return actual != null;
    }
    
    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T dato = actual.dato;
        anterior = actual;
        actual = actual.siguiente;
        return dato;
    }
    
    @Override
    public void remove() {
        if (anterior == null) throw new IllegalStateException();
        // Lógica para eliminar el nodo anterior
    }
}
```

### 9.2 Iterador para Lista Circular

> [!example] Procedimiento especial Debe detectar cuando ha completado un ciclo completo.

> [!bug] Código - Iterador Circular
> 
> ```java
> private class IteradorCircular implements Iterator<T> {
>     private Nodo<T> actual;
>     private Nodo<T> inicio;
>     private boolean primerRecorrido;
>     
>     public IteradorCircular() {
>         this.inicio = (cola != null) ? cola.siguiente : null;
>         this.actual = inicio;
>         this.primerRecorrido = true;
>     }
>     
>     @Override
>     public boolean hasNext() {
>         if (actual == null) return false;
>         return primerRecorrido || actual != inicio;
>     }
>     
>     @Override
>     public T next() {
>         if (!hasNext()) throw new NoSuchElementException();
>         T dato = actual.dato;
>         actual = actual.siguiente;
>         primerRecorrido = false;
>         return dato;
>     }
> }
> ```

> [!warning] Errores comunes
> 
> - No mantener referencia al nodo anterior para `remove()`
> - En listas circulares, no detectar cuando se completa el ciclo
> - Llamar `next()` sin verificar `hasNext()`

---

## 10. HashMap - Implementación Interna Básica

> [!info] Concepto Estructura clave-valor que usa **hashing** para almacenar y recuperar elementos en O(1) promedio.

### 10.1 Estructura Interna

```java
class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;  // Para manejar colisiones (chaining)
    
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class MiHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity;
    private int size;
    
    @SuppressWarnings("unchecked")
    public MiHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }
}
```

### 10.2 Función Hash

> [!bug] Código - Calcular índice
> 
> ```java
> private int hash(K key) {
>     return Math.abs(key.hashCode()) % capacity;
> }
> ```

### 10.3 Operación: Put

> [!example] Procedimiento paso a paso
> 
> 1. Calcular el índice usando la función hash
> 2. Si no hay entrada en ese índice, crear una nueva
> 3. Si ya existe, recorrer la cadena:
>     - Si se encuentra la clave, actualizar el valor
>     - Si no se encuentra, agregar al final de la cadena
> 4. Incrementar tamaño

> [!bug] Código - put()
> 
> ```java
> public void put(K key, V value) {
>     int index = hash(key);
>     Entry<K, V> entry = table[index];
>     
>     // Caso: índice vacío
>     if (entry == null) {
>         table[index] = new Entry<>(key, value);
>         size++;
>         return;
>     }
>     
>     // Caso: buscar en la cadena
>     Entry<K, V> prev = null;
>     while (entry != null) {
>         if (entry.key.equals(key)) {
>             entry.value = value;  // Actualizar
>             return;
>         }
>         prev = entry;
>         entry = entry.next;
>     }
>     
>     // Agregar al final
>     prev.next = new Entry<>(key, value);
>     size++;
> }
> ```

### 10.4 Operación: Get

> [!bug] Código - get()
> 
> ```java
> public V get(K key) {
>     int index = hash(key);
>     Entry<K, V> entry = table[index];
>     
>     while (entry != null) {
>         if (entry.key.equals(key)) {
>             return entry.value;
>         }
>         entry = entry.next;
>     }
>     return null;  // No encontrado
> }
> ```

> [!warning] Errores comunes
> 
> - No manejar colisiones correctamente
> - Olvidar comparar las claves con `equals()` en lugar de `==`
> - No actualizar el tamaño al agregar/eliminar
> - Usar capacidad muy pequeña (muchas colisiones)

---

## 11. Recursividad - Patrones de Implementación

> [!info] Estructura fundamental Toda función recursiva necesita: **caso base** (detiene la recursión) y **caso recursivo** (llamada a sí misma con parámetros modificados).

### 11.1 Patrón: Acumulación

> [!example] Factorial
> 
> ```java
> public static int factorial(int n) {
>     if (n == 0) return 1;              // Caso base
>     return n * factorial(n - 1);        // Caso recursivo
> }
> ```

### 11.2 Patrón: División

> [!example] Suma de dígitos
> 
> ```java
> public static int sumaDigitos(int n) {
>     if (n < 10) return n;              // Caso base
>     return (n % 10) + sumaDigitos(n / 10);  // Caso recursivo
> }
> ```

### 11.3 Patrón: Comparación

> [!example] Palíndromo
> 
> ```java
> public static boolean esPalindromo(String s) {
>     if (s.length() <= 1) return true;  // Caso base
>     if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
>     return esPalindromo(s.substring(1, s.length() - 1));
> }
> ```

### 11.4 Patrón: Múltiples Llamadas

> [!example] Fibonacci
> 
> ```java
> public static int fibonacci(int n) {
>     if (n == 1) return 0;              // Caso base 1
>     if (n == 2) return 1;              // Caso base 2
>     return fibonacci(n - 1) + fibonacci(n - 2);  // Dos llamadas
> }
> ```

> [!warning] Errores comunes en recursividad
> 
> - Olvidar el caso base (recursión infinita → StackOverflowError)
> - Caso base inalcanzable
> - No modificar correctamente los parámetros en la llamada recursiva
> - En funciones con múltiples llamadas, no combinar correctamente los resultados

---

## 12. Comparadores - Implementación Práctica

> [!info] Interfaz Comparator Permite definir múltiples criterios de ordenamiento para una clase sin modificarla.

### 12.1 Estructura Básica

```java
class Persona {
    String nombre;
    int edad;
    String ciudad;
    
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}
```

### 12.2 Comparador Simple

> [!bug] Código - Comparar por edad
> 
> ```java
> class ComparadorPorEdad implements Comparator<Persona> {
>     @Override
>     public int compare(Persona p1, Persona p2) {
>         return Integer.compare(p1.edad, p2.edad);
>     }
> }
> 
> // Uso
> List<Persona> personas = new ArrayList<>();
> personas.sort(new ComparadorPorEdad());
> ```

### 12.3 Comparador con Lambda

> [!bug] Código - Sintaxis compacta
> 
> ```java
> // Ascendente por edad
> personas.sort((p1, p2) -> Integer.compare(p1.edad, p2.edad));
> 
> // Descendente por edad
> personas.sort((p1, p2) -> Integer.compare(p2.edad, p1.edad));
> 
> // Por nombre (ignorar mayúsculas)
> personas.sort((p1, p2) -> p1.nombre.compareToIgnoreCase(p2.nombre));
> ```

### 12.4 Comparador con Múltiples Criterios

> [!bug] Código - Encadenar criterios
> 
> ```java
> Comparator<Persona> comparadorMultiple = 
>     Comparator.comparingInt((Persona p) -> p.edad)
>               .thenComparing(p -> p.nombre);
> 
> personas.sort(comparadorMultiple);
> ```

### 12.5 Reglas del Método compare()

|Retorno|Significado|Orden en lista|
|---|---|---|
|< 0|p1 < p2|p1 va antes|
|0|p1 == p2|Orden equivalente|
|> 0|p1 > p2|p1 va después|

> [!warning] Errores comunes
> 
> - Usar `p1.edad - p2.edad` (puede causar overflow; usar `Integer.compare()`)
> - Confundir el orden de los parámetros para ascendente/descendente
> - No manejar valores `null`
> - Olvidar que `compare()` debe ser consistente con `equals()`

---

## 13. Genéricos - Implementación en Estructuras Propias

> [!info] Problema de los arrays genéricos Java no permite `new T[size]` directamente debido al borrado de tipos.

### 13.1 Solución con Object[] y Casting

> [!bug] Código - ArrayList genérico
> 
> ```java
> public class MiArrayList<E> {
>     private Object[] array;
>     private int size;
>     private int capacity;
>     
>     public MiArrayList(int capacidadInicial) {
>         this.array = new Object[capacidadInicial];
>         this.size = 0;
>         this.capacity = capacidadInicial;
>     }
>     
>     @SuppressWarnings("unchecked")
>     public E get(int index) {
>         if (index >= size) throw new IndexOutOfBoundsException();
>         return (E) array[index];
>     }
>     
>     public void add(E elemento) {
>         if (size == capacity) expandir();
>         array[size++] = elemento;
>     }
>     
>     @SuppressWarnings("unchecked")
>     private void expandir() {
>         capacity = capacity + (capacity / 2);
>         Object[] nuevoArray = new Object[capacity];
>         System.arraycopy(array, 0, nuevoArray, 0, size);
>         array = nuevoArray;
>     }
> }
> ```

### 13.2 Solución con Array.newInstance

> [!bug] Código - Con reflexión
> 
> ```java
> import java.lang.reflect.Array;
> 
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

> [!warning] Consideraciones
> 
> - Usar `@SuppressWarnings("unchecked")` solo cuando estés seguro del casting
> - La reflexión es más compleja pero más tipo-segura
> - Para estructuras enlazadas, los genéricos funcionan sin problemas

---

## 14. Checklist de Implementación

> [!success] Antes de implementar cualquier estructura
> 
> - [/] Definir la clase del nodo (si es enlazada)
> - [/] Declarar atributos principales (cabeza, cola, tamaño, etc.)
> - [/] Implementar constructor(es)
> - [/] Implementar operaciones básicas (add, remove, get)
> - [/] Manejar casos especiales (vacía, un elemento, llena)
> - [/] Actualizar el tamaño en cada operación
> - [/] Implementar verificaciones de estado (isEmpty, isFull)
> - [/] Agregar validaciones y excepciones
> - [/] Implementar iterador si es necesario
> - [/] Probar con casos límite

---

## 15. ArrayList Personalizado - Implementación Completa Paso a Paso

> [!info] Estructura dinámica basada en arreglo Un ArrayList crece automáticamente cuando se llena, típicamente un 50% de su capacidad actual.

### 15.1 Estructura Base

```java
public class MiArrayList<E> {
    private Object[] array;
    private int size;
    private int capacity;
    private static final int CAPACIDAD_INICIAL = 10;
    
    public MiArrayList() {
        this.capacity = CAPACIDAD_INICIAL;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    public MiArrayList(int capacidadInicial) {
        this.capacity = capacidadInicial;
        this.array = new Object[capacity];
        this.size = 0;
    }
}
```

### 15.2 Método: Agregar al Final

> [!example] Procedimiento
> 
> 1. Verificar si hay espacio disponible
> 2. Si está lleno, expandir capacidad
> 3. Agregar elemento en la posición `size`
> 4. Incrementar `size`

> [!bug] Código - add()
> 
> ```java
> public void add(E elemento) {
>     if (size == capacity) {
>         expandir();
>     }
>     array[size++] = elemento;
> }
> 
> private void expandir() {
>     int nuevaCapacidad = capacity + (capacity / 2);  // 50% más
>     Object[] nuevoArray = new Object[nuevaCapacidad];
>     System.arraycopy(array, 0, nuevoArray, 0, size);
>     array = nuevoArray;
>     capacity = nuevaCapacidad;
> }
> ```

### 15.3 Método: Insertar en Posición

> [!example] Procedimiento
> 
> 1. Validar el índice (0 <= index <= size)
> 2. Expandir si es necesario
> 3. Desplazar elementos hacia la derecha desde el índice
> 4. Insertar el elemento
> 5. Incrementar size

> [!bug] Código - add(index, elemento)
> 
> ```java
> public void add(int index, E elemento) {
>     if (index < 0 || index > size) {
>         throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
>     }
>     
>     if (size == capacity) {
>         expandir();
>     }
>     
>     // Desplazar elementos a la derecha
>     for (int i = size; i > index; i--) {
>         array[i] = array[i - 1];
>     }
>     
>     array[index] = elemento;
>     size++;
> }
> ```

### 15.4 Método: Eliminar por Índice

> [!example] Procedimiento
> 
> 1. Validar el índice (0 <= index < size)
> 2. Guardar el elemento a retornar
> 3. Desplazar elementos hacia la izquierda desde index+1
> 4. Limpiar la última posición
> 5. Decrementar size
> 6. Retornar el elemento eliminado

> [!bug] Código - remove(index)
> 
> ```java
> @SuppressWarnings("unchecked")
> public E remove(int index) {
>     if (index < 0 || index >= size) {
>         throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
>     }
>     
>     E elementoEliminado = (E) array[index];
>     
>     // Desplazar elementos a la izquierda
>     for (int i = index; i < size - 1; i++) {
>         array[i] = array[i + 1];
>     }
>     
>     array[--size] = null;  // Evitar memory leak
>     return elementoEliminado;
> }
> ```

### 15.5 Método: Obtener Elemento

> [!bug] Código - get()
> 
> ```java
> @SuppressWarnings("unchecked")
> public E get(int index) {
>     if (index < 0 || index >= size) {
>         throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
>     }
>     return (E) array[index];
> }
> ```

### 15.6 Método: Establecer Elemento

> [!bug] Código - set()
> 
> ```java
> @SuppressWarnings("unchecked")
> public E set(int index, E elemento) {
>     if (index < 0 || index >= size) {
>         throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
>     }
>     E elementoAnterior = (E) array[index];
>     array[index] = elemento;
>     return elementoAnterior;
> }
> ```

### 15.7 Métodos Auxiliares

> [!bug] Código - Métodos de utilidad
> 
> ```java
> public int size() {
>     return size;
> }
> 
> public boolean isEmpty() {
>     return size == 0;
> }
> 
> public void clear() {
>     for (int i = 0; i < size; i++) {
>         array[i] = null;
>     }
>     size = 0;
> }
> 
> public boolean contains(E elemento) {
>     return indexOf(elemento) >= 0;
> }
> 
> public int indexOf(E elemento) {
>     for (int i = 0; i < size; i++) {
>         if (elemento == null ? array[i] == null : elemento.equals(array[i])) {
>             return i;
>         }
>     }
>     return -1;
> }
> ```

> [!warning] Errores comunes en ArrayList
> 
> - No desplazar elementos correctamente al insertar/eliminar
> - Olvidar validar índices antes de acceder
> - No poner `null` en posiciones eliminadas (memory leak)
> - Confundir `size` con `capacity`
> - No manejar el caso cuando `elemento` es `null` en búsquedas

---

## 16. Implementación de TreeMap - Concepto Básico

> [!info] Árbol Binario de Búsqueda TreeMap usa internamente un árbol rojo-negro, pero el concepto básico es un **árbol binario de búsqueda** donde las claves se ordenan automáticamente.

### 16.1 Nodo del Árbol

```java
class NodoArbol<K, V> {
    K clave;
    V valor;
    NodoArbol<K, V> izquierdo;
    NodoArbol<K, V> derecho;
    
    public NodoArbol(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
```

### 16.2 Estructura del TreeMap Simplificado

```java
public class MiTreeMap<K extends Comparable<K>, V> {
    private NodoArbol<K, V> raiz;
    private int size;
    
    public MiTreeMap() {
        this.raiz = null;
        this.size = 0;
    }
}
```

### 16.3 Operación: Put (Insertar)

> [!example] Procedimiento recursivo
> 
> 1. Si el árbol está vacío, crear la raíz
> 2. Comparar la clave con el nodo actual:
>     - Si es menor, ir al subárbol izquierdo
>     - Si es mayor, ir al subárbol derecho
>     - Si es igual, actualizar el valor
> 3. Insertar recursivamente

> [!bug] Código - put()
> 
> ```java
> public void put(K clave, V valor) {
>     raiz = putRecursivo(raiz, clave, valor);
> }
> 
> private NodoArbol<K, V> putRecursivo(NodoArbol<K, V> nodo, K clave, V valor) {
>     // Caso base: posición encontrada
>     if (nodo == null) {
>         size++;
>         return new NodoArbol<>(clave, valor);
>     }
>     
>     int comparacion = clave.compareTo(nodo.clave);
>     
>     if (comparacion < 0) {
>         nodo.izquierdo = putRecursivo(nodo.izquierdo, clave, valor);
>     } else if (comparacion > 0) {
>         nodo.derecho = putRecursivo(nodo.derecho, clave, valor);
>     } else {
>         nodo.valor = valor;  // Actualizar valor existente
>     }
>     
>     return nodo;
> }
> ```

### 16.4 Operación: Get (Buscar)

> [!bug] Código - get()
> 
> ```java
> public V get(K clave) {
>     return getRecursivo(raiz, clave);
> }
> 
> private V getRecursivo(NodoArbol<K, V> nodo, K clave) {
>     if (nodo == null) {
>         return null;  // No encontrado
>     }
>     
>     int comparacion = clave.compareTo(nodo.clave);
>     
>     if (comparacion < 0) {
>         return getRecursivo(nodo.izquierdo, clave);
>     } else if (comparacion > 0) {
>         return getRecursivo(nodo.derecho, clave);
>     } else {
>         return nodo.valor;  // Encontrado
>     }
> }
> ```

### 16.5 Recorrido In-Order (Orden Ascendente)

> [!example] Procedimiento
> 
> 1. Recorrer subárbol izquierdo
> 2. Procesar nodo actual
> 3. Recorrer subárbol derecho

> [!bug] Código - Recorrido in-order
> 
> ```java
> public void recorrerInOrder() {
>     recorrerInOrderRecursivo(raiz);
> }
> 
> private void recorrerInOrderRecursivo(NodoArbol<K, V> nodo) {
>     if (nodo == null) return;
>     
>     recorrerInOrderRecursivo(nodo.izquierdo);
>     System.out.println(nodo.clave + ": " + nodo.valor);
>     recorrerInOrderRecursivo(nodo.derecho);
> }
> ```

> [!warning] Consideraciones para TreeMap
> 
> - La clave debe implementar `Comparable` o proporcionar un `Comparator`
> - La eliminación de nodos es compleja (requiere reorganizar el árbol)
> - TreeMap real usa árboles rojo-negro para mantener balanceo
> - Las operaciones básicas son O(log n) en árboles balanceados

---

## 17. LinkedHashMap - Concepto de Implementación

> [!info] Mantiene orden de inserción Combina HashMap con una lista doblemente enlazada para recordar el orden de inserción.

### 17.1 Nodo Extendido

```java
class EntryLinked<K, V> {
    K clave;
    V valor;
    EntryLinked<K, V> next;       // Para el HashMap (colisiones)
    EntryLinked<K, V> before;     // Para orden de inserción
    EntryLinked<K, V> after;      // Para orden de inserción
    
    public EntryLinked(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }
}
```

### 17.2 Estructura Principal

```java
public class MiLinkedHashMap<K, V> {
    private EntryLinked<K, V>[] table;
    private EntryLinked<K, V> header;  // Cabeza de la lista de orden
    private EntryLinked<K, V> tail;    // Cola de la lista de orden
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public MiLinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new EntryLinked[capacity];
        this.header = null;
        this.tail = null;
        this.size = 0;
    }
}
```

### 17.3 Operación: Put con Orden

> [!example] Procedimiento
> 
> 1. Calcular hash e insertar en la tabla (como HashMap)
> 2. Si es una nueva entrada, agregarla al final de la lista de orden
> 3. Actualizar referencias `before` y `after`

> [!bug] Código - put() simplificado
> 
> ```java
> public void put(K clave, V valor) {
>     int index = hash(clave);
>     EntryLinked<K, V> entry = table[index];
>     
>     // Buscar si ya existe
>     while (entry != null) {
>         if (entry.clave.equals(clave)) {
>             entry.valor = valor;
>             return;
>         }
>         entry = entry.next;
>     }
>     
>     // Crear nueva entrada
>     EntryLinked<K, V> nuevaEntry = new EntryLinked<>(clave, valor);
>     
>     // Agregar a la tabla (manejo de colisiones)
>     nuevaEntry.next = table[index];
>     table[index] = nuevaEntry;
>     
>     // Agregar al final de la lista de orden
>     if (tail == null) {
>         header = tail = nuevaEntry;
>     } else {
>         tail.after = nuevaEntry;
>         nuevaEntry.before = tail;
>         tail = nuevaEntry;
>     }
>     
>     size++;
> }
> 
> private int hash(K clave) {
>     return Math.abs(clave.hashCode()) % capacity;
> }
> ```

### 17.4 Iteración en Orden de Inserción

> [!bug] Código - Recorrer en orden
> 
> ```java
> public void recorrerEnOrden() {
>     EntryLinked<K, V> actual = header;
>     while (actual != null) {
>         System.out.println(actual.clave + ": " + actual.valor);
>         actual = actual.after;
>     }
> }
> ```

> [!warning] Complejidad de LinkedHashMap
> 
> - Mantener dos estructuras (tabla hash + lista enlazada) aumenta uso de memoria
> - Operaciones siguen siendo O(1) promedio
> - Útil cuando el orden de iteración importa

---

## 18. Cola de Prioridad - Implementación con Heap Binario

> [!info] Estructura heap Un **heap mínimo** es un árbol binario completo donde cada padre es menor o igual que sus hijos. Se implementa eficientemente con un arreglo.

### 18.1 Relaciones en el Arreglo

|Elemento|Índice|Fórmula|
|---|---|---|
|Nodo|i|-|
|Padre|(i-1)/2|`(i - 1) / 2`|
|Hijo izquierdo|2i+1|`2 * i + 1`|
|Hijo derecho|2i+2|`2 * i + 2`|

### 18.2 Estructura de la Clase

```java
public class ColaPrioridad<T extends Comparable<T>> {
    private Object[] heap;
    private int size;
    private int capacity;
    
    public ColaPrioridad(int capacity) {
        this.capacity = capacity;
        this.heap = new Object[capacity];
        this.size = 0;
    }
}
```

### 18.3 Operación: Encolar (Insert)

> [!example] Procedimiento "bubble up"
> 
> 1. Agregar el elemento al final del heap
> 2. Comparar con el padre
> 3. Si es menor que el padre, intercambiar
> 4. Repetir hasta que esté en la posición correcta o sea la raíz

> [!bug] Código - encolar()
> 
> ```java
> public void encolar(T elemento) {
>     if (size == capacity) {
>         throw new IllegalStateException("Cola llena");
>     }
>     
>     heap[size] = elemento;
>     bubbleUp(size);
>     size++;
> }
> 
> @SuppressWarnings("unchecked")
> private void bubbleUp(int index) {
>     while (index > 0) {
>         int indicePadre = (index - 1) / 2;
>         
>         T elemento = (T) heap[index];
>         T padre = (T) heap[indicePadre];
>         
>         if (elemento.compareTo(padre) >= 0) {
>             break;  // Ya está en posición correcta
>         }
>         
>         // Intercambiar con el padre
>         heap[index] = padre;
>         heap[indicePadre] = elemento;
>         index = indicePadre;
>     }
> }
> ```

### 18.4 Operación: Desencolar (Remove)

> [!example] Procedimiento "bubble down"
> 
> 1. Guardar el elemento raíz (mínimo)
> 2. Mover el último elemento a la raíz
> 3. Decrementar size
> 4. Comparar con los hijos y bajar si es necesario
> 5. Retornar el elemento guardado

> [!bug] Código - desencolar()
> 
> ```java
> @SuppressWarnings("unchecked")
> public T desencolar() {
>     if (size == 0) {
>         throw new NoSuchElementException("Cola vacía");
>     }
>     
>     T minimo = (T) heap[0];
>     heap[0] = heap[size - 1];
>     heap[size - 1] = null;
>     size--;
>     
>     if (size > 0) {
>         bubbleDown(0);
>     }
>     
>     return minimo;
> }
> 
> @SuppressWarnings("unchecked")
> private void bubbleDown(int index) {
>     while (true) {
>         int indiceIzq = 2 * index + 1;
>         int indiceDer = 2 * index + 2;
>         int indiceMenor = index;
>         
>         // Comparar con hijo izquierdo
>         if (indiceIzq < size) {
>             T elemento = (T) heap[indiceMenor];
>             T hijoIzq = (T) heap[indiceIzq];
>             if (hijoIzq.compareTo(elemento) < 0) {
>                 indiceMenor = indiceIzq;
>             }
>         }
>         
>         // Comparar con hijo derecho
>         if (indiceDer < size) {
>             T elemento = (T) heap[indiceMenor];
>             T hijoDer = (T) heap[indiceDer];
>             if (hijoDer.compareTo(elemento) < 0) {
>                 indiceMenor = indiceDer;
>             }
>         }
>         
>         // Si ya está en posición correcta, terminar
>         if (indiceMenor == index) {
>             break;
>         }
>         
>         // Intercambiar
>         Object temp = heap[index];
>         heap[index] = heap[indiceMenor];
>         heap[indiceMenor] = temp;
>         index = indiceMenor;
>     }
> }
> ```

### 18.5 Método: Peek (Ver mínimo)

> [!bug] Código - peek()
> 
> ```java
> @SuppressWarnings("unchecked")
> public T peek() {
>     if (size == 0) {
>         throw new NoSuchElementException("Cola vacía");
>     }
>     return (T) heap[0];
> }
> ```

> [!warning] Errores comunes en heaps
> 
> - Confundir las fórmulas de padre e hijos
> - No verificar límites al acceder a hijos
> - Olvidar decrementar size antes de bubble down
> - No poner null en la posición eliminada
> - Errores de comparación (< vs >) según sea heap mínimo o máximo

---

## 19. Algoritmos Recursivos sobre Listas

### 19.1 Búsqueda Recursiva en Lista Enlazada

> [!bug] Código - Buscar elemento
> 
> ```java
> public boolean contiene(T dato) {
>     return contieneRecursivo(cabeza, dato);
> }
> 
> private boolean contieneRecursivo(Nodo<T> nodo, T dato) {
>     if (nodo == null) return false;              // Caso base: no encontrado
>     if (nodo.dato.equals(dato)) return true;     // Caso base: encontrado
>     return contieneRecursivo(nodo.siguiente, dato);  // Caso recursivo
> }
> ```

### 19.2 Invertir Lista Recursivamente

> [!example] Procedimiento
> 
> 1. Caso base: lista vacía o de un elemento
> 2. Invertir el resto de la lista recursivamente
> 3. Hacer que el segundo nodo apunte al primero
> 4. El primer nodo ahora es el último (apunta a null)

> [!bug] Código - Invertir lista
> 
> ```java
> public void invertir() {
>     cabeza = invertirRecursivo(cabeza);
> }
> 
> private Nodo<T> invertirRecursivo(Nodo<T> nodo) {
>     // Casos base
>     if (nodo == null || nodo.siguiente == null) {
>         return nodo;
>     }
>     
>     // Invertir el resto
>     Nodo<T> nuevaCabeza = invertirRecursivo(nodo.siguiente);
>     
>     // Hacer que el siguiente nodo apunte al actual
>     nodo.siguiente.siguiente = nodo;
>     nodo.siguiente = null;
>     
>     return nuevaCabeza;
> }
> ```

### 19.3 Obtener Elemento en Posición (Recursivo)

> [!bug] Código - get recursivo
> 
> ```java
> public T get(int index) {
>     if (index < 0 || index >= tamaño) {
>         throw new IndexOutOfBoundsException();
>     }
>     return getRecursivo(cabeza, index);
> }
> 
> private T getRecursivo(Nodo<T> nodo, int index) {
>     if (index == 0) return nodo.dato;         // Caso base
>     return getRecursivo(nodo.siguiente, index - 1);  // Caso recursivo
> }
> ```

---

## 20. Patrones Comunes de Errores y Sus Soluciones

### 20.1 Error: NullPointerException en Listas

> [!warning] Causas comunes
> 
> ```java
> // ❌ No verificar si la lista está vacía
> public T getFirst() {
>     return cabeza.dato;  // Falla si cabeza es null
> }
> 
> // ✅ Verificar primero
> public T getFirst() {
>     if (cabeza == null) {
>         throw new NoSuchElementException("Lista vacía");
>     }
>     return cabeza.dato;
> }
> ```

### 20.2 Error: ConcurrentModificationException

> [!warning] Causa Modificar una colección mientras se itera con for-each

```java
// ❌ Incorrecto
for (String elemento : lista) {
    if (condicion) {
        lista.remove(elemento);  // Falla
    }
}

// ✅ Usar Iterator
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String elemento = it.next();
    if (condicion) {
        it.remove();  // Correcto
    }
}
```

### 20.3 Error: Perder Referencias en Listas Enlazadas

> [!warning] Problema común
> 
> ```java
> // ❌ Pierde la referencia al resto de la lista
> public void addFirst(T dato) {
>     cabeza = new Nodo<>(dato);  // Se pierde la lista anterior
> }
> 
> // ✅ Mantener la referencia
> public void addFirst(T dato) {
>     Nodo<T> nuevoNodo = new Nodo<>(dato);
>     nuevoNodo.siguiente = cabeza;
>     cabeza = nuevoNodo;
> }
> ```

### 20.4 Error: Índices en Estructuras Circulares

> [!warning] No detectar el ciclo completo
> 
> ```java
> // ❌ Bucle infinito
> Nodo<T> actual = cola.siguiente;  // cabeza
> while (actual != null) {  // Nunca será null en circular
>     // procesar
>     actual = actual.siguiente;
> }
> 
> // ✅ Detectar vuelta completa
> Nodo<T> inicio = cola.siguiente;
> Nodo<T> actual = inicio;
> do {
>     // procesar
>     actual = actual.siguiente;
> } while (actual != inicio);
> ```

### 20.5 Error: No Actualizar Tamaño

> [!warning] Olvidar mantener el contador
> 
> ```java
> // ❌ Tamaño incorrecto
> public void add(T dato) {
>     // ... lógica de agregar
>     // Olvida: tamaño++;
> }
> 
> // ✅ Siempre actualizar
> public void add(T dato) {
>     // ... lógica de agregar
>     tamaño++;  // No olvidar
> }
> ```

---

## 21. Tabla de Complejidades - Referencia Rápida

|Estructura|get(i)|add (fin)|add (inicio)|remove (fin)|remove (inicio)|search|
|---|---|---|---|---|---|---|
|**ArrayList**|O(1)|O(1)*|O(n)|O(1)|O(n)|O(n)|
|**LinkedList Simple**|O(n)|O(n)|O(1)|O(n)|O(1)|O(n)|
|**LinkedList Doble**|O(n)|O(1)|O(1)|O(1)|O(1)|O(n)|
|**Circular Simple**|O(n)|O(1)|O(1)|O(n)|O(1)|O(n)|
|**Circular Doble**|O(n)|O(1)|O(1)|O(1)|O(1)|O(n)|
|**HashMap**|-|O(1)**|-|-|O(1)**|O(1)**|
|**TreeMap**|-|O(log n)|-|-|O(log n)|O(log n)|
|**PriorityQueue**|-|O(log n)|-|O(log n)|-|O(n)|

* Amortizado (puede ser O(n) al expandir)  
** Promedio (peor caso O(n) con muchas colisiones)

---

## 22. Tips Finales para Examen

> [!success] Estrategias de implementación
> 
> 1. **Siempre dibuja primero**: Antes de codificar, dibuja la estructura con 2-3 nodos
> 2. **Identifica casos especiales**: vacío, un elemento, dos elementos
> 3. **Escribe el caso base primero**: En recursividad, empezar por el caso base
> 4. **Prueba mentalmente**: Ejecuta tu código con ejemplos pequeños
> 5. **Referencias críticas**: En listas enlazadas, nunca pierdas la referencia al siguiente antes de reasignar

> [!tip] Errores que evitar el día del examen
> 
> - No verificar `null` antes de acceder a `.next` o `.dato`
> - Olvidar actualizar `tamaño` en operaciones de agregar/eliminar
> - No manejar el caso cuando la estructura está vacía
> - Confundir `size` con `capacity` en ArrayList
> - No cerrar correctamente los enlaces en listas circulares
> - Olvidar el `@SuppressWarnings("unchecked")` en casts de genéricos

> [!quote] Regla de oro "Si tu estructura tiene punteros (referencias), cada operación debe actualizar TODOS los punteros relevantes, no solo uno."