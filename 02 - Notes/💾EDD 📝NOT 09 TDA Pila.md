---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# TDA Pila (Stack)

## 1. Introducción a las Pilas

> [!info] Definición
> Una **pila** (stack) es una estructura de datos que sigue el principio **LIFO** (Last In, First Out), donde el último elemento en entrar es el primero en salir.

> [!example] Analogía práctica
> Imagine una pila de platos: solo puede agregar o quitar platos desde la parte superior. El último plato colocado será el primero en ser retirado.

---

## 2. Operaciones Básicas

| Operación        | Descripción                                 | Comportamiento en caso de error       |
| ---------------- | ------------------------------------------- | ------------------------------------- |
| `push(elemento)` | Agrega un elemento en el tope de la pila    | -                                     |
| `pop()`          | Remueve y devuelve el elemento del tope     | Lanza excepción si la pila está vacía |
| `peek()`         | Devuelve el elemento del tope sin removerlo | Lanza excepción si la pila está vacía |
| `size()`         | Devuelve el número de elementos             | -                                     |
| `isEmpty()`      | Verifica si la pila está vacía              | -                                     |

> [!warning] Subdesbordamiento
> Intentar realizar `pop()` o `peek()` en una pila vacía genera un **subdesbordamiento**, lo que generalmente resulta en una excepción.

---

## 3. Implementaciones de Pilas

### 3.1 Implementación con ArrayList

```java
public class PilaArrayList<T> {
    private ArrayList<T> lista = new ArrayList<>();
    
    public void push(T elemento) {
        lista.add(elemento);
    }
    
    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return lista.remove(lista.size() - 1);
    }
    
    // ... otros métodos
}
```

> [!success] Ventajas
> - Implementación simple y eficiente
> - Acceso rápido por índice

### 3.2 Implementación con LinkedList

```java
public class PilaLinkedList<T> {
    private LinkedList<T> lista = new LinkedList<>();
    
    public void push(T elemento) {
        lista.addLast(elemento);
    }
    
    public T pop() {
        if (estaVacia()) throw new NoSuchElementException("Pila vacía");
        return lista.removeLast();
    }
    
    // ... otros métodos
}
```

### 3.3 Implementaciones con Estructuras Personalizadas

| Tipo de Implementación        | Características                                                          |
| ----------------------------- | ------------------------------------------------------------------------ |
| **Lista Doblemente Enlazada** | Permite inserción/eliminación eficiente en ambos extremos                |
| **Lista Circular Simple**     | Último nodo apunta al primero, formando un ciclo                         |
| **Lista Circular Doble**      | Nodos con referencias anterior y siguiente, formando ciclo bidireccional |

> [!bug] Comparación de Implementaciones
> ```java
> // ArrayDeque (estática) vs LinkedList (dinámica)
> Deque<Integer> s1 = new ArrayDeque<>();  // Más eficiente en memoria
> Deque<Integer> s2 = new LinkedList<>();  // Permite elementos null
> ```

---

## 4. Caso de Estudio: Agenda con Historial

### 4.1 Estructura Principal

```java
class Agenda {
    private ListaCircularDobleEnlazada<Contacto> contactos;
    private Stack<String> historialAcciones;
    private Stack<String> redoAcciones;
    
    public void agregarContacto(Contacto contacto) {
        contactos.agregar(contacto);
        historialAcciones.push("ADD:" + contacto.getNombre());
        redoAcciones = new Stack<>();
    }
}
```

### 4.2 Sistema de Deshacer/Rehacer

> [!info] Mecanismo de Historial
> El sistema mantiene dos pilas:
> - **historialAcciones**: Registra todas las acciones realizadas
> - **redoAcciones**: Almacena acciones deshechas para posible rehacer

```java
public void deshacer() {
    if (historialAcciones.isEmpty()) return;
    
    String accion = historialAcciones.pop();
    redoAcciones.push(accion);
    
    // Lógica para revertir la acción
    if (accion.startsWith("ADD")) {
        eliminarContacto(accion.split(":")[1]);
    }
    // ... más casos
}
```

---

## 5. Ejercicio Práctico

> [!example] Invertir Secuencia
> **Problema**: Leer una secuencia de números enteros y mostrarlos en orden inverso.

```java
public class InvertirSecuencia {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        // Leer elementos
        while (scanner.hasNextInt()) {
            pila.push(scanner.nextInt());
        }
        
        // Mostrar en orden inverso
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}
```

**Entrada**: `1 3 5 7`  
**Salida**: `7 5 3 1`

---

## 6. Aplicaciones Comunes

> [!tip] Usos de las Pilas
> - **Pila de llamadas** en ejecución de programas
> - **Evaluación de expresiones** matemáticas
> - **Algoritmos de backtracking**
> - **Sistemas de deshacer/rehacer** en aplicaciones
> - **Navegación entre páginas** en navegadores web

> [!quote] Concepto Fundamental
> "La simplicidad de la pila contrasta con su utilidad en múltiples dominios de la computación, desde sistemas operativos hasta aplicaciones empresariales."

---

**NOTA**: Esta documentación sigue las convenciones establecidas en la plantilla AI-Template, utilizando callouts apropiados, tablas claras y ejemplos de código relevantes para facilitar la comprensión del TDA Pila.