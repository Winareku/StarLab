---
tags:
  - 💾EDD
  - 📝TAR
cssclasses:
  - center-titles
---

# Tarea: Implementación de TDAs Lista

## 1. ArrayList

### 📋 Descripción
Implementación del TDA ArrayList con métodos básicos de inserción y eliminación.

### 💻 Código Implementado

> [!bug] Implementación de ArrayList
> ```java
> import java.util.Arrays;
> 
> /**
>  * Implementación personalizada de ArrayList genérico
>  * @param <E> Tipo de elementos almacenados en la lista
>  */
> public class ArrayList<E> {
>     private static final int CAPACIDAD_INICIAL = 10;
>     private Object[] elementos;
>     private int tamaño;
>     private int capacidad;
> 
>     /**
>      * Constructor que inicializa el ArrayList con capacidad inicial
>      */
>     public ArrayList() {
>         this.capacidad = CAPACIDAD_INICIAL;
>         this.elementos = new Object[capacidad];
>         this.tamaño = 0;
>     }
> 
>     /**
>      * Añade un elemento al final de la lista
>      * @param e Elemento a añadir
>      */
>     public void add(E e) {
>         // Verificar si es necesario expandir la capacidad
>         if (tamaño == capacidad) {
>             expandirCapacidad();
>         }
>         elementos[tamaño] = e;
>         tamaño++;
>     }
> 
>     /**
>      * Añade un elemento en la posición especificada
>      * @param indice Posición donde insertar el elemento
>      * @param e Elemento a insertar
>      * @throws IndexOutOfBoundsException Si el índice está fuera de rango
>      */
>     public void add(int indice, E e) {
>         if (indice < 0 || indice > tamaño) {
>             throw new IndexOutOfBoundsException("Índice: " + indice + ", Tamaño: " + tamaño);
>         }
>         
>         // Expandir capacidad si es necesario
>         if (tamaño == capacidad) {
>             expandirCapacidad();
>         }
>         
>         // Desplazar elementos a la derecha
>         for (int i = tamaño; i > indice; i--) {
>             elementos[i] = elementos[i - 1];
>         }
>         
>         elementos[indice] = e;
>         tamaño++;
>     }
> 
>     /**
>      * Remueve el elemento en la posición especificada
>      * @param indice Posición del elemento a remover
>      * @return Elemento removido
>      * @throws IndexOutOfBoundsException Si el índice está fuera de rango
>      */
>     @SuppressWarnings("unchecked")
>     public E remove(int indice) {
>         if (indice < 0 || indice >= tamaño) {
>             throw new IndexOutOfBoundsException("Índice: " + indice + ", Tamaño: " + tamaño);
>         }
>         
>         E elementoRemovido = (E) elementos[indice];
>         
>         // Desplazar elementos a la izquierda
>         for (int i = indice; i < tamaño - 1; i++) {
>             elementos[i] = elementos[i + 1];
>         }
>         
>         elementos[tamaño - 1] = null; // Ayuda al garbage collector
>         tamaño--;
>         
>         return elementoRemovido;
>     }
> 
>     /**
>      * Expande la capacidad del array interno en un 50%
>      */
>     private void expandirCapacidad() {
>         capacidad = capacidad + (capacidad / 2);
>         elementos = Arrays.copyOf(elementos, capacidad);
>     }
> 
>     /**
>      * Obtiene el elemento en la posición especificada
>      * @param indice Posición del elemento
>      * @return Elemento en la posición
>      */
>     @SuppressWarnings("unchecked")
>     public E get(int indice) {
>         if (indice < 0 || indice >= tamaño) {
>             throw new IndexOutOfBoundsException("Índice: " + indice + ", Tamaño: " + tamaño);
>         }
>         return (E) elementos[indice];
>     }
> 
>     /**
>      * @return Número de elementos en la lista
>      */
>     public int size() {
>         return tamaño;
>     }
> 
>     /**
>      * @return Representación en String de la lista
>      */
>     @Override
>     public String toString() {
>         if (tamaño == 0) return "[]";
>         
>         StringBuilder sb = new StringBuilder();
>         sb.append("[");
>         for (int i = 0; i < tamaño; i++) {
>             sb.append(elementos[i]);
>             if (i < tamaño - 1) sb.append(", ");
>         }
>         sb.append("]");
>         return sb.toString();
>     }
> }
> ```

### 🧪 Prueba de Uso

> [!example] Clase de Prueba para ArrayList
> ```java
> public class TestArrayList {
>     public static void main(String[] args) {
>         ArrayList<String> lista = new ArrayList<>();
>         
>         System.out.println("=== PRUEBAS ARRAYLIST ===");
>         
>         // Prueba de add(E e)
>         lista.add("A");
>         lista.add("B");
>         lista.add("C");
>         System.out.println("Después de añadir A, B, C: " + lista);
>         
>         // Prueba de add(int indice, E e)
>         lista.add(1, "X");
>         System.out.println("Después de insertar X en índice 1: " + lista);
>         
>         // Prueba de remove(int indice)
>         String removido = lista.remove(2);
>         System.out.println("Elemento removido en índice 2: " + removido);
>         System.out.println("Lista después de remover: " + lista);
>         
>         // Prueba de get(int indice)
>         System.out.println("Elemento en índice 0: " + lista.get(0));
>         System.out.println("Elemento en índice 1: " + lista.get(1));
>         
>         // Prueba de tamaño
>         System.out.println("Tamaño final: " + lista.size());
>     }
> }
> ```

---

## 2. LinkedList (get y getLast)

### 📋 Descripción
Implementación de LinkedList con métodos get(i) y getLast().

### 💻 Código Implementado

> [!bug] Implementación de LinkedList
> ```java
> /**
>  * Implementación de LinkedList genérica con nodos enlazados
>  * @param <E> Tipo de elementos almacenados en la lista
>  */
> public class LinkedList<E> {
>     private Nodo<E> cabeza;
>     private int tamaño;
> 
>     /**
>      * Clase interna que representa un nodo de la lista
>      */
>     private static class Nodo<E> {
>         E dato;
>         Nodo<E> siguiente;
> 
>         Nodo(E dato) {
>             this.dato = dato;
>             this.siguiente = null;
>         }
>     }
> 
>     public LinkedList() {
>         this.cabeza = null;
>         this.tamaño = 0;
>     }
> 
>     /**
>      * Añade un elemento al final de la lista
>      * @param e Elemento a añadir
>      */
>     public void add(E e) {
>         Nodo<E> nuevoNodo = new Nodo<>(e);
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
>     /**
>      * Obtiene el elemento en la posición especificada
>      * @param indice Posición del elemento
>      * @return Elemento en la posición
>      * @throws IndexOutOfBoundsException Si el índice está fuera de rango
>      */
>     public E get(int indice) {
>         if (indice < 0 || indice >= tamaño) {
>             throw new IndexOutOfBoundsException("Índice: " + indice + ", Tamaño: " + tamaño);
>         }
>         
>         Nodo<E> actual = cabeza;
>         for (int i = 0; i < indice; i++) {
>             actual = actual.siguiente;
>         }
>         return actual.dato;
>     }
> 
>     /**
>      * Obtiene el último elemento de la lista
>      * @return Último elemento
>      * @throws IllegalStateException Si la lista está vacía
>      */
>     public E getLast() {
>         if (cabeza == null) {
>             throw new IllegalStateException("La lista está vacía");
>         }
>         
>         Nodo<E> actual = cabeza;
>         while (actual.siguiente != null) {
>             actual = actual.siguiente;
>         }
>         return actual.dato;
>     }
> 
>     /**
>      * @return Número de elementos en la lista
>      */
>     public int size() {
>         return tamaño;
>     }
> 
>     /**
>      * @return Representación en String de la lista
>      */
>     @Override
>     public String toString() {
>         if (cabeza == null) return "[]";
>         
>         StringBuilder sb = new StringBuilder();
>         sb.append("[");
>         Nodo<E> actual = cabeza;
>         while (actual != null) {
>             sb.append(actual.dato);
>             if (actual.siguiente != null) sb.append(" -> ");
>             actual = actual.siguiente;
>         }
>         sb.append("]");
>         return sb.toString();
>     }
> }
> ```

### 🧪 Prueba de Uso

> [!example] Clase de Prueba para LinkedList
> ```java
> public class TestLinkedList {
>     public static void main(String[] args) {
>         LinkedList<Integer> lista = new LinkedList<>();
>         
>         System.out.println("=== PRUEBAS LINKEDLIST ===");
>         
>         // Añadir elementos
>         lista.add(10);
>         lista.add(20);
>         lista.add(30);
>         lista.add(40);
>         System.out.println("Lista: " + lista);
>         
>         // Prueba de get(i)
>         System.out.println("Elemento en índice 0: " + lista.get(0));
>         System.out.println("Elemento en índice 2: " + lista.get(2));
>         
>         // Prueba de getLast()
>         System.out.println("Último elemento: " + lista.getLast());
>         
>         // Prueba de tamaño
>         System.out.println("Tamaño de la lista: " + lista.size());
>         
>         // Intentar acceder a índice inválido
>         try {
>             System.out.println("Elemento en índice 10: " + lista.get(10));
>         } catch (IndexOutOfBoundsException e) {
>             System.out.println("Error esperado: " + e.getMessage());
>         }
>     }
> }
> ```

---

## 3. Lista Circular Doblemente Enlazada

### 📋 Descripción
Implementación de lista circular doblemente enlazada donde cada nodo tiene referencias al siguiente y anterior.

### 💻 Código Implementado

> [!bug] Implementación de Lista Circular Doblemente Enlazada
> ```java
> /**
>  * Implementación de lista circular doblemente enlazada
>  * @param <E> Tipo de elementos almacenados en la lista
>  */
> public class ListaCircularDoblementeEnlazada<E> {
>     private Nodo<E> cabeza;
>     private int tamaño;
> 
>     /**
>      * Clase interna que representa un nodo con referencias dobles
>      */
>     private static class Nodo<E> {
>         E dato;
>         Nodo<E> siguiente;
>         Nodo<E> anterior;
> 
>         Nodo(E dato) {
>             this.dato = dato;
>             this.siguiente = null;
>             this.anterior = null;
>         }
>     }
> 
>     public ListaCircularDoblementeEnlazada() {
>         this.cabeza = null;
>         this.tamaño = 0;
>     }
> 
>     /**
>      * Añade un elemento al final de la lista circular
>      * @param e Elemento a añadir
>      */
>     public void add(E e) {
>         Nodo<E> nuevoNodo = new Nodo<>(e);
>         
>         if (cabeza == null) {
>             // Primer elemento - se apunta a sí mismo
>             cabeza = nuevoNodo;
>             cabeza.siguiente = cabeza;
>             cabeza.anterior = cabeza;
>         } else {
>             // Insertar al final (antes de la cabeza)
>             Nodo<E> cola = cabeza.anterior;
>             
>             cola.siguiente = nuevoNodo;
>             nuevoNodo.anterior = cola;
>             nuevoNodo.siguiente = cabeza;
>             cabeza.anterior = nuevoNodo;
>         }
>         tamaño++;
>     }
> 
>     /**
>      * Obtiene el elemento en la posición especificada
>      * @param indice Posición del elemento
>      * @return Elemento en la posición
>      * @throws IndexOutOfBoundsException Si el índice está fuera de rango
>      */
>     public E get(int indice) {
>         if (indice < 0 || indice >= tamaño) {
>             throw new IndexOutOfBoundsException("Índice: " + indice + ", Tamaño: " + tamaño);
>         }
>         
>         Nodo<E> actual = cabeza;
>         for (int i = 0; i < indice; i++) {
>             actual = actual.siguiente;
>         }
>         return actual.dato;
>     }
> 
>     /**
>      * Obtiene el último elemento de la lista
>      * @return Último elemento
>      * @throws IllegalStateException Si la lista está vacía
>      */
>     public E getLast() {
>         if (cabeza == null) {
>             throw new IllegalStateException("La lista está vacía");
>         }
>         return cabeza.anterior.dato;
>     }
> 
>     /**
>      * @return Número de elementos en la lista
>      */
>     public int size() {
>         return tamaño;
>     }
> 
>     /**
>      * Recorre e imprime la lista en orden circular
>      */
>     public void imprimirCircular(int vueltas) {
>         if (cabeza == null) {
>             System.out.println("Lista vacía");
>             return;
>         }
>         
>         Nodo<E> actual = cabeza;
>         System.out.print("Recorrido circular (" + vueltas + " vueltas): ");
>         for (int i = 0; i < tamaño * vueltas; i++) {
>             System.out.print(actual.dato);
>             if (i < tamaño * vueltas - 1) System.out.print(" -> ");
>             actual = actual.siguiente;
>         }
>         System.out.println();
>     }
> 
>     /**
>      * @return Representación en String de la lista
>      */
>     @Override
>     public String toString() {
>         if (cabeza == null) return "[]";
>         
>         StringBuilder sb = new StringBuilder();
>         sb.append("[");
>         Nodo<E> actual = cabeza;
>         for (int i = 0; i < tamaño; i++) {
>             sb.append(actual.dato);
>             if (i < tamaño - 1) sb.append(" <-> ");
>             actual = actual.siguiente;
>         }
>         sb.append("]");
>         return sb.toString();
>     }
> }
> ```

### 🧪 Prueba de Uso

> [!example] Clase de Prueba para Lista Circular
> ```java
> public class TestListaCircular {
>     public static void main(String[] args) {
>         ListaCircularDoblementeEnlazada<String> listaCircular = new ListaCircularDoblementeEnlazada<>();
>         
>         System.out.println("=== PRUEBAS LISTA CIRCULAR DOBLEMENTE ENLAZADA ===");
>         
>         // Añadir elementos
>         listaCircular.add("A");
>         listaCircular.add("B");
>         listaCircular.add("C");
>         listaCircular.add("D");
>         
>         System.out.println("Lista: " + listaCircular);
>         System.out.println("Tamaño: " + listaCircular.size());
>         
>         // Prueba de get(i)
>         System.out.println("Elemento en índice 0: " + listaCircular.get(0));
>         System.out.println("Elemento en índice 2: " + listaCircular.get(2));
>         
>         // Prueba de getLast()
>         System.out.println("Último elemento: " + listaCircular.getLast());
>         
>         // Demostrar naturaleza circular
>         listaCircular.imprimirCircular(2);
>         listaCircular.imprimirCircular(3);
>         
>         // Verificar que el último apunta al primero
>         System.out.println("Último -> Siguiente debería ser primero: " + 
>             (listaCircular.getLast() + " -> " + listaCircular.get(0)));
>     }
> }
> ```

---

## 4. LinkedList Extendida

### 📋 Descripción
Implementación extendida de LinkedList con métodos adicionales: insertar al final, calcular longitud, recorrer, unir listas e invertir.

### 💻 Código Implementado

> [!bug] Implementación de LinkedList Extendida
> ```java
> /**
>  * Implementación extendida de LinkedList con métodos adicionales
>  * @param <E> Tipo de elementos almacenados en la lista
>  */
> public class LinkedListExtendida<E> {
>     private Nodo<E> cabeza;
>     private int tamaño;
> 
>     private static class Nodo<E> {
>         E dato;
>         Nodo<E> siguiente;
> 
>         Nodo(E dato) {
>             this.dato = dato;
>             this.siguiente = null;
>         }
>     }
> 
>     public LinkedListExtendida() {
>         this.cabeza = null;
>         this.tamaño = 0;
>     }
> 
>     /**
>      * Añade un elemento al final de la lista
>      * @param e Elemento a añadir
>      */
>     public void add(E e) {
>         Nodo<E> nuevoNodo = new Nodo<>(e);
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
>     /**
>      * Calcula y retorna la longitud de la lista
>      * @return Número de elementos en la lista
>      */
>     public int longitud() {
>         return tamaño;
>     }
> 
>     /**
>      * Recorre e imprime la lista
>      */
>     public void recorrer() {
>         if (cabeza == null) {
>             System.out.println("Lista vacía");
>             return;
>         }
>         
>         System.out.print("Recorrido: ");
>         Nodo<E> actual = cabeza;
>         while (actual != null) {
>             System.out.print(actual.dato);
>             if (actual.siguiente != null) System.out.print(" -> ");
>             actual = actual.siguiente;
>         }
>         System.out.println(" -> null");
>     }
> 
>     /**
>      * Une esta lista con otra lista
>      * @param otraLista Lista a unir con esta
>      * @return Nueva lista que es la unión de ambas
>      */
>     public LinkedListExtendida<E> unir(LinkedListExtendida<E> otraLista) {
>         LinkedListExtendida<E> listaUnida = new LinkedListExtendida<>();
>         
>         // Copiar elementos de esta lista
>         Nodo<E> actual = this.cabeza;
>         while (actual != null) {
>             listaUnida.add(actual.dato);
>             actual = actual.siguiente;
>         }
>         
>         // Copiar elementos de la otra lista
>         actual = otraLista.cabeza;
>         while (actual != null) {
>             listaUnida.add(actual.dato);
>             actual = actual.siguiente;
>         }
>         
>         return listaUnida;
>     }
> 
>     /**
>      * Invierte la lista y retorna una nueva lista invertida
>      * @return Nueva lista con los elementos en orden inverso
>      */
>     public LinkedListExtendida<E> invertir() {
>         LinkedListExtendida<E> listaInvertida = new LinkedListExtendida<>();
>         
>         // Usar pila temporal para invertir el orden
>         Object[] elementos = new Object[tamaño];
>         Nodo<E> actual = cabeza;
>         
>         // Almacenar elementos en array
>         for (int i = 0; i < tamaño; i++) {
>             elementos[i] = actual.dato;
>             actual = actual.siguiente;
>         }
>         
>         // Añadir en orden inverso
>         for (int i = tamaño - 1; i >= 0; i--) {
>             @SuppressWarnings("unchecked")
>             E elemento = (E) elementos[i];
>             listaInvertida.add(elemento);
>         }
>         
>         return listaInvertida;
>     }
> 
>     /**
>      * @return Representación en String de la lista
>      */
>     @Override
>     public String toString() {
>         if (cabeza == null) return "[]";
>         
>         StringBuilder sb = new StringBuilder();
>         sb.append("[");
>         Nodo<E> actual = cabeza;
>         while (actual != null) {
>             sb.append(actual.dato);
>             if (actual.siguiente != null) sb.append(" -> ");
>             actual = actual.siguiente;
>         }
>         sb.append("]");
>         return sb.toString();
>     }
> }
> ```

### 🧪 Prueba de Uso

> [!example] Clase de Prueba para LinkedList Extendida
> ```java
> public class TestLinkedListExtendida {
>     public static void main(String[] args) {
>         LinkedListExtendida<Integer> lista1 = new LinkedListExtendida<>();
>         LinkedListExtendida<Integer> lista2 = new LinkedListExtendida<>();
>         
>         System.out.println("=== PRUEBAS LINKEDLIST EXTENDIDA ===");
>         
>         // Llenar lista 1
>         lista1.add(1);
>         lista1.add(2);
>         lista1.add(3);
>         System.out.println("Lista 1: " + lista1);
>         
>         // Llenar lista 2
>         lista2.add(4);
>         lista2.add(5);
>         lista2.add(6);
>         System.out.println("Lista 2: " + lista2);
>         
>         // Prueba de longitud
>         System.out.println("Longitud lista 1: " + lista1.longitud());
>         System.out.println("Longitud lista 2: " + lista2.longitud());
>         
>         // Prueba de recorrer
>         lista1.recorrer();
>         lista2.recorrer();
>         
>         // Prueba de unir listas
>         LinkedListExtendida<Integer> listaUnida = lista1.unir(lista2);
>         System.out.println("Lista unida: " + listaUnida);
>         listaUnida.recorrer();
>         
>         // Prueba de invertir lista
>         LinkedListExtendida<Integer> listaInvertida = lista1.invertir();
>         System.out.println("Lista 1 invertida: " + listaInvertida);
>         listaInvertida.recorrer();
>         
>         // Verificar que la original no cambió
>         System.out.println("Lista 1 original (sin cambios): " + lista1);
>     }
> }
> ```

---

## 📊 Resumen de Implementaciones

| **Estructura** | **Métodos Implementados** | **Características** |
|----------------|---------------------------|---------------------|
| **ArrayList** | `add(E)`, `add(int, E)`, `remove(int)` | Array dinámico, acceso rápido por índice |
| **LinkedList** | `get(int)`, `getLast()` | Nodos enlazados, inserción eficiente |
| **Lista Circular Doble** | `add(E)`, `get(int)`, `getLast()` | Referencias bidireccionales, comportamiento circular |
| **LinkedList Extendida** | `longitud()`, `recorrer()`, `unir()`, `invertir()` | Funcionalidades adicionales para manipulación |

---

## 🎯 Conclusiones

> [!success] Logros de la Tarea
> - ✅ Implementación completa de **4 estructuras de datos** diferentes
> - ✅ **Documentación exhaustiva** con comentarios Javadoc
> - ✅ **Pruebas de uso** para cada implementación
> - ✅ Manejo de **excepciones** apropiado
> - ✅ Código **genérico** y reusable

> [!tip] Aprendizajes Clave
> - Diferencias entre implementaciones **estáticas** (ArrayList) y **dinámicas** (LinkedList)
> - Ventajas de las **listas circulares** para procesamiento continuo
> - Importancia de mantener la **integridad de referencias** en listas enlazadas
> - Estrategias para **invertir listas** sin modificar el original
