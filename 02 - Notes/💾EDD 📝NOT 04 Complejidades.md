---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Complejidades

## 1. Notación O Grande (Big-O)

> [!info] Definición
> La **Notación O Grande** es una forma de expresar la complejidad de un algoritmo en términos del tamaño de la entrada. Describe cómo crece el tiempo de ejecución o uso de recursos a medida que el tamaño de los datos aumenta.

### 1.1 Principales Categorías de Complejidad

| **Complejidad** | **Notación** | **Descripción** | **Ejemplo** |
|-----------------|--------------|-----------------|-------------|
| Constante | O(1) | Tiempo independiente del tamaño de entrada | Acceso a array por índice |
| Logarítmica | O(log n) | Divide el problema en cada paso | Búsqueda binaria |
| Lineal | O(n) | Crece proporcionalmente al tamaño | Recorrer un array |
| Log Lineal | O(n log n) | Combinación lineal y logarítmica | QuickSort, MergeSort |
| Cuadrática | O(n²) | Crece con el cuadrado del tamaño | Bubble Sort |
| Exponencial | O(2ⁿ) | Se duplica con cada adición | Torres de Hanoi |
| Factorial | O(n!) | Crece factorialmente | Agente Viajero |

### 1.2 Ejemplos Prácticos

> [!bug] Código - O(1) Constante
```java
int[] arr = {10, 20, 30, 40, 50};
int valor = arr[2]; // Siempre O(1)
```

> [!bug] Código - O(n) Lineal
```java
void recorrerArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]); // O(n)
    }
}
```

> [!bug] Código - O(n²) Cuadrática
```java
void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Intercambiar elementos - O(n²)
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

---

## 2. Búsqueda Binaria

> [!info] Concepto Clave
> Algoritmo eficiente para buscar elementos en listas **ordenadas**. Divide repetidamente la lista a la mitad hasta encontrar el elemento.

### 2.1 Características Principales

- **Complejidad**: O(log n)
- **Requisito**: Lista debe estar ordenada
- **Mejor caso**: O(1) - elemento en el medio
- **Peor caso**: O(log n) - elemento en los extremos

### 2.2 Implementación en Java

> [!bug] Código - Búsqueda Binaria General
```java
public class BusquedaBinaria {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2; // Evitar overflow

            if (arr[medio] == valorBuscado) {
                return medio; // Elemento encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1; // Buscar en mitad derecha
            } else {
                fin = medio - 1; // Buscar en mitad izquierda
            }
        }
        return -1; // Elemento no encontrado
    }
}
```

### 2.3 Casos Específicos

> [!example] Caso 1: Valor en el Medio
```java
int[] arreglo = {1, 2, 3, 4, 5}; // Tamaño impar
int resultado = busquedaBinaria(arreglo, 3); // Índice 2
```

> [!example] Caso 2: Valor en Mitad Derecha
```java
int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int resultado = busquedaBinaria(arreglo, 7); // Índice 6
```

> [!example] Caso 3: Valor en Mitad Izquierda
```java
int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int resultado = busquedaBinaria(arreglo, 2); // Índice 1
```

### 2.4 ¿Por qué O(log n)?

> [!info] Explicación Matemática
> $$
> \text{Pasos} = \log_2 n
> $$

**Ejemplo con 16 elementos:**
- Paso 1: 16 elementos → 8 elementos
- Paso 2: 8 elementos → 4 elementos  
- Paso 3: 4 elementos → 2 elementos
- Paso 4: 2 elementos → 1 elemento

**Total: 4 pasos = log₂16**

---

## 3. Problema del Agente Viajero (TSP)

> [!info] Definición
> Problema clásico de optimización donde un vendedor debe visitar **n ciudades** exactamente una vez y regresar al origen, minimizando la distancia total.

### 3.1 Características del Problema

- **Complejidad**: O(n!) - Factorial
- **Número de rutas**: (n-1)! para n ciudades
- **Aplicaciones**: Logística, rutas de entrega, planificación de viajes

### 3.2 Ejemplo con 4 Ciudades

| **Ciudad** | **A** | **B** | **C** | **D** |
|------------|-------|-------|-------|-------|
| **A** | 0 | 5 | 9 | 14 |
| **B** | 5 | 0 | 7 | 8 |
| **C** | 9 | 7 | 0 | 10 |
| **D** | 14 | 8 | 10 | 0 |

**Rutas posibles:**
1. A→B→C→D→A = 5 + 7 + 10 + 14 = 36
2. A→B→D→C→A = 5 + 8 + 10 + 9 = 32 ✓
3. A→C→B→D→A = 9 + 7 + 8 + 14 = 38
4. A→C→D→B→A = 9 + 10 + 8 + 5 = 32 ✓
5. A→D→B→C→A = 14 + 8 + 7 + 9 = 38
6. A→D→C→B→A = 14 + 10 + 7 + 5 = 36

### 3.3 Implementación por Fuerza Bruta

> [!bug] Código - Agente Viajero
```java
import java.util.Arrays;

public class AgenteViajero {
    public static int calcularDistancia(int[][] distancias, int[] ruta) {
        int distanciaTotal = 0;
        for (int i = 0; i < ruta.length - 1; i++) {
            distanciaTotal += distancias[ruta[i]][ruta[i + 1]];
        }
        distanciaTotal += distancias[ruta[ruta.length - 1]][ruta[0]];
        return distanciaTotal;
    }

    public static void permutar(int[] ruta, int l, int r, int[][] distancias, 
                               int[] mejorRuta, int[] minDistancia) {
        if (l == r) {
            int distanciaActual = calcularDistancia(distancias, ruta);
            if (distanciaActual < minDistancia[0]) {
                minDistancia[0] = distanciaActual;
                System.arraycopy(ruta, 0, mejorRuta, 0, ruta.length);
            }
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(ruta, l, i);
                permutar(ruta, l + 1, r, distancias, mejorRuta, minDistancia);
                intercambiar(ruta, l, i); // Backtracking
            }
        }
    }

    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

### 3.4 ¿Por qué O(n!)?

> [!info] Explicación Combinatoria
> Para n ciudades:
> - Primera ciudad: n opciones
> - Segunda ciudad: n-1 opciones  
> - Tercera ciudad: n-2 opciones
> - ...
> - Total: n × (n-1) × (n-2) × ... × 1 = n!

**Crecimiento factorial:**
- 4 ciudades: 4! = 24 rutas
- 10 ciudades: 10! = 3,628,800 rutas
- 28 ciudades: 28! ≈ 3.04 × 10²⁹ rutas

---

## 4. Estructuras de Datos y sus Complejidades

### 4.1 Arreglos (Arrays)

> [!bug] Código - Operaciones con Arrays
```java
public class ArregloEjemplo {
    public static void main(String[] args) {
        int[] arreglo = {10, 20, 30, 40, 50};
        
        // Acceso: O(1)
        System.out.println(arreglo[2]); // 30
        
        // Búsqueda: O(n)
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == 40) {
                System.out.println("Encontrado en índice: " + i);
                break;
            }
        }
        
        // Inserción: O(n) - requiere desplazamiento
        int[] nuevoArreglo = new int[arreglo.length + 1];
        // ... lógica de inserción
    }
}
```

### 4.2 Listas Enlazadas

> [!bug] Código - Lista Enlazada Simple
```java
class Nodo {
    int dato;
    Nodo siguiente;
    public Nodo(int dato) { this.dato = dato; }
}

public class ListaEnlazada {
    Nodo cabeza;
    
    // Inserción al inicio: O(1)
    public void agregarInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }
    
    // Búsqueda: O(n)
    public boolean buscar(int dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}
```

### 4.3 Tablas Hash (HashMap)

> [!bug] Código - HashMap
```java
import java.util.HashMap;

public class HashMapEjemplo {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        
        // Inserción: O(1) promedio
        mapa.put("Juan", 30);
        mapa.put("Ana", 25);
        
        // Acceso: O(1) promedio
        System.out.println(mapa.get("Ana")); // 25
        
        // Eliminación: O(1) promedio
        mapa.remove("Juan");
    }
}
```

### 4.4 Resumen de Complejidades

| **Estructura** | **Acceso** | **Búsqueda** | **Inserción** | **Eliminación** |
|----------------|------------|--------------|---------------|-----------------|
| Array | O(1) | O(n) | O(n) | O(n) |
| Lista Enlazada | O(n) | O(n) | O(1) inicio | O(1) inicio |
| Pila (Stack) | O(n) | O(n) | O(1) | O(1) |
| Cola (Queue) | O(n) | O(n) | O(1) | O(1) |
| HashMap | O(1) | O(1) | O(1) | O(1) |

---

## 5. Algoritmos de Ordenamiento

### 5.1 QuickSort - O(n log n)

> [!bug] Código - QuickSort
```java
public class QuickSortExample {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
```

### 5.2 Problema de la Mochila - O(2ⁿ)

> [!bug] Código - Mochila Recursiva
```java
public class MochilaEjemplo {
    public static int knapSack(int capacidad, int[] pesos, int[] valores, int n) {
        if (n == 0 || capacidad == 0) return 0;
        
        if (pesos[n - 1] > capacidad) {
            return knapSack(capacidad, pesos, valores, n - 1);
        } else {
            return Math.max(
                valores[n - 1] + knapSack(capacidad - pesos[n - 1], pesos, valores, n - 1),
                knapSack(capacidad, pesos, valores, n - 1)
            );
        }
    }
}
```

---

## 6. Comparable y Comparator

### 6.1 Comparable - Orden Natural

> [!bug] Código - Implementación Comparable
```java
public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private int edad;
    
    // Constructor, getters...
    
    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.edad, otro.edad); // Orden ascendente por edad
    }
}
```

### 6.2 Comparator - Múltiples Criterios

> [!bug] Código - Uso de Comparator
```java
import java.util.*;

public class OrdenamientoEjemplo {
    public static void main(String[] args) {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("Ana", 22));
        lista.add(new Estudiante("Luis", 20));
        lista.add(new Estudiante("Carla", 22));
        
        // Orden ascendente por edad y nombre
        lista.sort(Comparator
            .comparingInt(Estudiante::getEdad)
            .thenComparing(Estudiante::getNombre));
        
        // Orden descendente por edad
        lista.sort((e1, e2) -> Integer.compare(e2.getEdad(), e1.getEdad()));
    }
}
```

### 6.3 Método Genérico para Ordenar

> [!bug] Código - Ordenador Genérico
```java
public class Ordenador {
    public static <T> void ordenarPorCampo(List<T> lista, Comparator<T> comparador) {
        Collections.sort(lista, comparador);
    }
    
    public static <T extends Comparable<T>> T encontrarMenor(List<? extends T> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("Lista vacía");
        }
        T menor = lista.get(0);
        for (T elemento : lista) {
            if (elemento.compareTo(menor) < 0) {
                menor = elemento;
            }
        }
        return menor;
    }
}
```

---

## 7. Ejercicios de Aplicación

### 7.1 Ejercicio: Análisis de Complejidad

> [!question] Determina la complejidad de:
```java
function minMax1(array) {
    min, max = NULL
    for each e in array
        min = MIN(e, min)      // O(n)
    for each e in array  
        max = MAX(e, max)      // O(n)
}
// Total: O(n) + O(n) = O(n)

function minMax2(array) {
    min, max = NULL
    for each e in array
        min = MIN(e, min)      // O(n)
        max = MAX(e, max)      // O(n)
}
// Total: O(n)
```

### 7.2 Ejercicio: Intersección de Arrays

> [!question] Complejidad del siguiente código:
```java
int intersectionSize(int[] arrayA, int[] arrayB) {
    int count = 0;
    for (int a : arrayA) {           // O(n)
        for (int b : arrayB) {       // O(m)
            if (a == b) {
                count++;
            }
        }
    }
    return count;
}
// Total: O(n × m)
```

---

## 8. Conclusiones y Buenas Prácticas

> [!success] Resumen de Principios Clave
> 1. **Elige la estructura de datos adecuada** para cada problema
> 2. **Considera la complejidad algorítmica** al diseñar soluciones
> 3. **La notación O Grande ayuda** a predecir escalabilidad
> 4. **Algoritmos eficientes** son cruciales para grandes volúmenes de datos
> 5. **Balancea legibilidad vs eficiencia** según el contexto

> [!warning] Puntos Importantes
> - La búsqueda binaria requiere datos ordenados
> - Los algoritmos factoriales (O(n!)) son inviables para n grandes
> - HashMap ofrece mejor rendimiento promedio para búsquedas
> - QuickSort es generalmente más eficiente que BubbleSort

> [!info] Aplicaciones en el Mundo Real
> - **Búsqueda binaria**: Bases de datos, sistemas de archivos
> - **Problema del viajante**: Logística, planificación de rutas
> - **HashMap**: Cachés, índices de bases de datos
> - **Algoritmos de ordenamiento**: Motores de búsqueda, análisis de datos

**La comprensión de la complejidad algorítmica es fundamental para desarrollar software eficiente y escalable.**