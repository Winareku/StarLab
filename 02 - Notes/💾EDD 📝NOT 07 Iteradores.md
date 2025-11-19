---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Iteradores en Java

## 1. Introducción a los Iteradores

> [!info] Definición
> Un **Iterator** es un objeto en Java que permite recorrer una lista o colección de elementos uno a uno. Proporciona un acceso seguro a los elementos sin modificar directamente la estructura de datos y permite eliminar elementos de manera segura durante el recorrido.

### 1.1 Métodos Principales del Iterator

| Método    | Descripción                                                              |
| --------- | ------------------------------------------------------------------------ |
| hasNext() | Verifica si hay más elementos en la colección (retorna `true` o `false`) |
| next()    | Devuelve el siguiente elemento y avanza el iterador                      |
| remove()  | Elimina el último elemento devuelto por `next()` de forma segura         |

> [!example] Ejemplo Básico
> ```java
> ArrayList<String> lista = new ArrayList<>();
> lista.add("A");
> lista.add("B");
> lista.add("C");
> 
> Iterator<String> iterator = lista.iterator();
> while (iterator.hasNext()) {
>     String elemento = iterator.next();
>     System.out.println(elemento);
> }
> ```

---

## 2. Eliminación Segura con Iterator

> [!warning] Importante
> No se debe modificar directamente la lista durante un recorrido con bucles tradicionales, ya que puede causar `ConcurrentModificationException`.

> [!example] Eliminación con Iterator
> ```java
> Iterator<String> iterator = lista.iterator();
> while (iterator.hasNext()) {
>     String elemento = iterator.next();
>     if (elemento.equals("B")) {
>         iterator.remove(); // Elimina "B" de forma segura
>     }
> }
> ```

---

## 3. Iteradores en Diferentes Estructuras de Datos

### 3.1 ArrayList

> [!info] Características
> - Estructura: Array dinámico
> - Eficiencia de `next()`: **O(1)**
> - Ideal para recorridos secuenciales rápidos

> [!example] Uso en ArrayList
> ```java
> ArrayList<Integer> arrayList = new ArrayList<>();
> arrayList.add(1);
> arrayList.add(2);
> arrayList.add(3);
> 
> Iterator<Integer> iterator = arrayList.iterator();
> while (iterator.hasNext()) {
>     int number = iterator.next();
>     if (number % 2 == 0) {
>         iterator.remove(); // Elimina números pares
>     }
> }
> ```

### 3.2 LinkedList (Doblemente Enlazada)

> [!info] Características
> - Estructura: Nodos con referencias anterior/siguiente
> - Eficiencia de `next()`: **O(1)** por nodo
> - Soporta `ListIterator` para navegación bidireccional

> [!example] Uso con ListIterator
> ```java
> LinkedList<String> linkedList = new LinkedList<>();
> linkedList.add("A");
> linkedList.add("B");
> linkedList.add("C");
> 
> ListIterator<String> listIterator = linkedList.listIterator();
> while (listIterator.hasNext()) {
>     String element = listIterator.next();
>     if (element.equals("B")) {
>         listIterator.add("D"); // Agrega "D" después de "B"
>     }
> }
> ```

### 3.3 Lista Enlazada Simple

> [!info] Características
> - Estructura: Nodos con referencia al siguiente
> - Eficiencia de `next()`: **O(1)** por nodo
> - Solo permite recorrido unidireccional

### 3.4 Listas Circulares

> [!info] Características
> - Estructura: Último nodo apunta al primero
> - Eficiencia de `next()`: **O(1)** por nodo
> - Ideal para aplicaciones cíclicas

---

## 4. Complejidad y Comparativa

### 4.1 Complejidad de Iteradores

| Estructura            | Eficiencia de next() | Casos de Uso                    |
| --------------------- | -------------------- | ------------------------------- |
| ArrayList             | O(1)                 | Recorridos secuenciales rápidos |
| LinkedList            | O(1) por nodo        | Navegación bidireccional        |
| Lista Enlazada Simple | O(1) por nodo        | Recorridos unidireccionales     |
| Lista Circular        | O(1) por nodo        | Aplicaciones cíclicas           |

> [!success] Eficiencia Global
> La complejidad para recorrer toda la lista con un Iterator es **O(N)** para todas las estructuras.

---

## 5. Iterator vs Bucle For

### 5.1 Ventajas del Iterator

| Ventaja                          | Descripción                                                          |
| -------------------------------- | -------------------------------------------------------------------- |
| Modificación Segura              | Permite eliminar elementos sin causar errores de concurrencia        |
| Flexibilidad en Listas Enlazadas | Más eficiente que `for` en estructuras sin acceso directo por índice |
| Recorrido Bidireccional          | Con `ListIterator` permite navegar en ambas direcciones              |
| Consistencia                     | Funciona uniformemente en diferentes colecciones                     |

> [!bug] Problema con Bucle For
> ```java
> // Esto puede causar ConcurrentModificationException
> for (String elemento : lista) {
>     if (elemento.equals("B")) {
>         lista.remove(elemento); // ❌ No seguro
>     }
> }
> ```

> [!example] Solución con Iterator
> ```java
> Iterator<String> iterator = lista.iterator();
> while (iterator.hasNext()) {
>     String elemento = iterator.next();
>     if (elemento.equals("B")) {
>         iterator.remove(); // ✅ Seguro
>     }
> }
> ```

---

## 6. Implementaciones Personalizadas

### 6.1 CustomArrayList

> [!example] Iterador Personalizado para ArrayList
> ```java
> public class CustomArrayListIterator implements Iterator<T> {
>     private int currentIndex = 0;
>     
>     @Override
>     public boolean hasNext() {
>         return currentIndex < size;
>     }
>     
>     @Override
>     public T next() {
>         if (!hasNext()) throw new IllegalStateException("No more elements");
>         return array[currentIndex++];
>     }
>     
>     @Override
>     public void remove() {
>         if (currentIndex <= 0) throw new IllegalStateException("No current element");
>         for (int i = currentIndex - 1; i < size - 1; i++) {
>             array[i] = array[i + 1];
>         }
>         array[--size] = null;
>         currentIndex--;
>     }
> }
> ```

### 6.2 Iteradores para Listas Enlazadas

> [!example] Iterador para Lista Circular Simple
> ```java
> public class CircularSinglyLinkedListIterator implements Iterator<T> {
>     private Node<T> current = (tail != null) ? tail.next : null;
>     private Node<T> start = current;
>     private boolean hasLooped = false;
>     
>     @Override
>     public boolean hasNext() {
>         return current != null && (!hasLooped || current != start);
>     }
>     
>     @Override
>     public T next() {
>         if (!hasNext()) throw new IllegalStateException("No more elements");
>         T data = current.data;
>         current = current.next;
>         if (current == start) hasLooped = true;
>         return data;
>     }
> }
> ```

---

## 7. Interfaces Relacionadas

### 7.1 Interface Iterable

> [!info] Propósito
> Permite el uso del bucle **for-each** en estructuras personalizadas.

> [!example] Implementación
> ```java
> class CustomDataStructure implements Iterable<E> {
>     // código de la estructura de datos
>     
>     public Iterator<E> iterator() {
>         return new CustomIterator<>(this);
>     }
> }
> ```

### 7.2 Interface ListIterator

> [!info] Funcionalidad Extendida
> Proporciona métodos para recorrido bidireccional y modificación de elementos.

| Método        | Descripción                               |
| ------------- | ----------------------------------------- |
| hasPrevious() | Verifica si hay elementos anteriores      |
| previous()    | Devuelve el elemento anterior             |
| add(E e)      | Inserta un elemento en la posición actual |
| set(E e)      | Reemplaza el último elemento devuelto     |

---

## 8. Resumen y Recomendaciones

> [!success] Cuándo Usar Iterator
> 1. Cuando se necesita eliminar elementos durante el recorrido
> 2. Al trabajar con listas enlazadas sin acceso por índice
> 3. Para navegación bidireccional (con ListIterator)
> 4. Para un acceso uniforme a diferentes colecciones

> [!quote] Conclusión
> Los iteradores proporcionan un mecanismo seguro, flexible y eficiente para recorrer colecciones en Java, superando las limitaciones de los bucles tradicionales en muchos escenarios.