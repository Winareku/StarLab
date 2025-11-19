---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# TDA Cola - Estructuras de Datos

## 1. Definición y Conceptos Fundamentales

> [!info] Concepto de Cola
> Una cola es una estructura de datos lineal que sigue el principio **FIFO** (First In First Out), donde el primer elemento en entrar es el primero en salir.

**Características principales:**
- Tiene dos extremos: **frente** (front) y **final** (rear)
- Los elementos nuevos se agregan al final
- Los elementos se eliminan del frente
- Operan por turnos, garantizando orden de llegada

> [!example] Aplicaciones en la vida real
> - Colas de espera en cines, bancos, supermercados
> - Impresión de documentos (spool de impresión)
> - Procesamiento de solicitudes en sistemas operativos

---

## 2. Operaciones Básicas del TDA Cola

| Operación           | Descripción                     | Condición     |
| ------------------- | ------------------------------- | ------------- |
| `CrearCola()`       | Inicializa una cola vacía       | -             |
| `EliminarCola()`    | Remueve todos los elementos     | -             |
| `EstaVacia()`       | Verifica si la cola está vacía  | -             |
| `Frente()`          | Consulta el elemento del frente | Cola no vacía |
| `Final()`           | Consulta el elemento del final  | Cola no vacía |
| `Encolar(elemento)` | Agrega elemento al final        | -             |
| `Desencolar()`      | Remueve elemento del frente     | Cola no vacía |

> [!warning] Subdesbordamiento
> Cualquier intento de acceder a elementos en una cola vacía genera un error de subdesbordamiento.

---

## 3. Implementaciones de Colas

### 3.1 Implementación con ArrayList

> [!bug] Código - Cola con ArrayList
> ```java
> public class ColaArrayList<T> {
>     private ArrayList<T> lista = new ArrayList<>();
>     
>     public void encolar(T elemento) {
>         lista.add(elemento); // se agrega al final
>     }
>     
>     public T desencolar() {
>         if (estaVacia()) throw new NoSuchElementException("Cola vacía");
>         return lista.remove(0); // se elimina del frente
>     }
>     
>     public boolean estaVacia() {
>         return lista.isEmpty();
>     }
> }
> ```

### 3.2 Implementación con LinkedList

> [!bug] Código - Cola con LinkedList
> ```java
> public class ColaLinkedList<T> {
>     private LinkedList<T> lista = new LinkedList<>();
>     
>     public void encolar(T elemento) {
>         lista.addLast(elemento);
>     }
>     
>     public T desencolar() {
>         if (estaVacia()) throw new NoSuchElementException("Cola vacía");
>         return lista.removeFirst();
>     }
> }
> ```

### 3.3 Implementación con Lista Enlazada Simple

**Ventajas:**
- No existe problema de desperdicio de memoria
- No hay límites máximos predefinidos
- Las operaciones de cola llaman a las operaciones de la lista enlazada

---

## 4. Colas Circulares con Arreglos

### 4.1 Problema de los Arreglos Lineales

> [!warning] Desperdicio de espacio
> En arreglos lineales, al desencolar se desperdician espacios al frente del arreglo.

**Soluciones propuestas:**
1. **Retroceder elementos**: Mover todos los elementos una posición al desencolar
2. **Reiniciar posición**: Cuando el final llega al límite, mover elementos al inicio

### 4.2 Implementación Óptima: Arreglo Circular

> [!info] Concepto de Arreglo Circular
> Un arreglo donde el siguiente elemento después del último es el primero, creando un ciclo continuo.

**Condiciones importantes:**
- **Cola vacía**: `frente == siguiente(fin)`
- **Cola llena**: `frente == siguiente(siguiente(fin))`

> [!bug] Código - Cola Circular con Arreglo
> ```java
> public class ColaCircular {
>     private static final int MAXTAMQ = 99;
>     protected int frente;
>     protected int fin;
>     protected Object[] listaCola;
>     
>     private int siguiente(int r) {
>         return (r + 1) % MAXTAMQ;
>     }
>     
>     public boolean colaVacia() {
>         return frente == siguiente(fin);
>     }
>     
>     public boolean colaLlena() {
>         return frente == siguiente(siguiente(fin));
>     }
> }
> ```

### 4.3 Implementaciones con Nodos

**Cola Circular con Lista Enlazada Simple:**
- El último nodo apunta al primero
- Operaciones eficientes en tiempo constante

**Cola Doblemente Enlazada:**
- Cada nodo tiene referencias al siguiente y anterior
- Permite recorrido en ambas direcciones

**Cola Doblemente Circular:**
- Combina características de lista doble y circular
- Máxima flexibilidad en operaciones

---

## 5. Colas de Prioridad

### 5.1 Definición y Tipos

> [!quote] Concepto
> En una cola de prioridad, el orden de atención no está dado solo por el orden de llegada, sino por la prioridad asociada a cada elemento.

| Tipo                      | Descripción                                      | Operación Desencolar            |
| ------------------------- | ------------------------------------------------ | ------------------------------- |
| **Prioridad Ascendente**  | Elementos con menor valor tienen mayor prioridad | Remueve el elemento más pequeño |
| **Prioridad Descendente** | Elementos con mayor valor tienen mayor prioridad | Remueve el elemento más grande  |

### 5.2 Implementaciones

**Implementación Estática (Arreglos):**
- Insertar elementos ordenadamente
- Usar arreglo circular
- Requiere desplazamientos al insertar

**Implementación con Múltiples Colas:**
```java
public class ColaPrioridad {
    int numero;
    Cola cola;  // cola de elementos con esta prioridad
}
```

**Implementación Dinámica (Lista Enlazada):**
- Cada nodo contiene: contenido, prioridad y enlace
- La lista se mantiene ordenada por prioridad
- Para encolar: buscar posición correcta
- Para desencolar: eliminar primer elemento

---

## 6. Ejercicio Práctico: Números Capicúa

> [!example] Algoritmo para detectar capicúas
> Utiliza concurrentemente una **Pila** y una **Cola**:
> 1. Procesar dígitos uno por uno
> 2. Insertar cada dígito en la pila y en la cola
> 3. Extraer elementos de ambas estructuras en paralelo
> 4. Comparar dígitos extraídos
> 5. Si hay discrepancia, no es capicúa

> [!success] Ventaja del enfoque
> Combina LIFO (pila) y FIFO (cola) para verificar simetría eficientemente.

---

## 7. Resumen Comparativo

| Implementación       | Ventajas              | Desventajas                | Uso Recomendado        |
| -------------------- | --------------------- | -------------------------- | ---------------------- |
| **ArrayList**        | Simple implementación | Costoso desencolar (O(n))  | Colas pequeñas         |
| **LinkedList**       | Operaciones O(1)      | Mayor uso de memoria       | Casos generales        |
| **Arreglo Circular** | Eficiente en memoria  | Tamaño fijo                | Sistemas embebidos     |
| **Lista Enlazada**   | Tamaño dinámico       | Complejidad implementación | Aplicaciones dinámicas |
| **Cola Prioridad**   | Orden por prioridad   | Mayor complejidad          | Sistemas de scheduling |

> [!tip] Recomendación Final
> La elección de implementación depende del contexto: use arreglos circulares para sistemas con memoria limitada y listas enlazadas para aplicaciones con requisitos dinámicos.