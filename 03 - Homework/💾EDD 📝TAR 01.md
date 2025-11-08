---
tags:
  - 💾EDD
  - 📝TAR
cssclasses:
  - center-titles
---

# Aplicación de Genéricos y TDAs en Java

## Ejercicio 1: Clase Genérica Caja<T>

> [!info] Objetivo
> Implementar una clase genérica que pueda almacenar cualquier tipo de dato, incluyendo tipos primitivos y compuestos.

### 1.1 Implementación de Caja<T>

> [!bug] Código - Clase Caja
```java
package com.espol;

public class Caja<T> {
    // Atributos
    private T contenido;

    // Constructor
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    // Métodos
    public void set(T contenido) {
        this.contenido = contenido;
    }
    
    public T get() {
        return contenido;
    }
    
    public void mostrarTipo() {
        System.out.println("El tipo de contenido es: " + contenido.getClass().getName());
    }
}
```

### 1.2 Clase CustomClass

> [!bug] Código - Clase Personalizada
```java
package com.espol;

public class CustomClass {
    // Atributos
    private String nombre;
    private int id;

    // Constructor
    public CustomClass(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "CustomClass{nombre='" + nombre + "', id=" + id + "}";
    }
}
```

---

## Ejercicio 2: TDA ListaPersonalizada<T>

> [!info] Objetivo
> Implementar una estructura de datos genérica que almacene elementos y provea operaciones básicas de lista.

### 2.1 Implementación Completa

> [!bug] Código - ListaPersonalizada
```java
package com.espol;

public class ListaPersonalizada<T> {
    // Atributos
    private int capacity;
    private int effectiveSize;
    private T[] elements;
    
    // Constructor
    @SuppressWarnings("unchecked")
    public ListaPersonalizada() {
        this.capacity = 10;
        this.effectiveSize = 0;
        this.elements = (T[]) new Object[capacity];
    }

    // Métodos Auxiliares
    public void extendCapacity() {
        capacity += capacity / 2;
        @SuppressWarnings("unchecked")
        T[] newElements = (T[]) new Object[capacity];
        for (int i = 0; i < effectiveSize; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public Boolean indexValid(int index) {
        return index >= 0 && index < effectiveSize;
    }

    public Boolean isEmpty() {
        return effectiveSize == 0;
    }

    // Métodos Principales
    public void agregar(T elemento) {
        if (elemento == null) return;
        if (effectiveSize == capacity) extendCapacity();
        elements[effectiveSize] = elemento;
        effectiveSize++;
    }

    public void eliminar(T elemento) {
        for (int i = 0; i < effectiveSize; i++) {
            if (elemento == null) return;
            if (elements[i].equals(elemento)) {
                for (int j = i; j < effectiveSize - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                effectiveSize--;
                elements[effectiveSize] = null;
                return;
            }
        }
    }

    public Boolean buscar(T elemento) {
        for (int i = 0; i < effectiveSize; i++) {
            if (elements[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int tamanio() {
        return effectiveSize;
    }
    
    // Método adicional para mostrar elementos
    public void mostrarElementos() {
        System.out.print("Elementos: [");
        for (int i = 0; i < effectiveSize; i++) {
            System.out.print(elements[i]);
            if (i < effectiveSize - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
```

---

## Ejercicio 3: GestorDeListas

> [!info] Objetivo
> Implementar una clase con métodos genéricos para gestionar listas de cualquier tipo.

### 3.1 Implementación Completa

> [!bug] Código - GestorDeListas
```java
package com.espol;

import java.util.List;

public class GestorDeListas {
    
    // Agregar elemento a cualquier lista genérica
    public static <T> void agregarElementoALista(List<T> lista, T elemento) {
        lista.add(elemento);
        System.out.println("Elemento agregado: " + elemento);
    }
    
    // Remover elemento de cualquier lista genérica
    public static <T> boolean removerElementoDeLista(List<T> lista, T elemento) {
        boolean removido = lista.remove(elemento);
        if (removido) {
            System.out.println("Elemento removido: " + elemento);
        } else {
            System.out.println("Elemento no encontrado: " + elemento);
        }
        return removido;
    }
    
    // Imprimir todos los elementos de una lista genérica
    public static <T> void imprimirLista(List<T> lista) {
        System.out.println("Contenido de la lista:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }
}
```

---

## Ejercicio 4: TDAs y Clases Abstractas

> [!info] Objetivo
> Crear una jerarquía de clases usando genéricos y clases abstractas para representar vehículos.

### 4.1 Clase Abstracta Vehículo

> [!bug] Código - Vehículo Abstracto
```java
package com.espol;

public abstract class Vehiculo<T> {
    protected T identificador;
    protected String marca;
    
    public Vehiculo(T identificador, String marca) {
        this.identificador = identificador;
        this.marca = marca;
    }
    
    // Método abstracto que deben implementar las subclases
    public abstract void encender();
    
    // Método concreto
    public void mostrarDatos() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Marca: " + marca);
    }
    
    // Getters
    public T getIdentificador() {
        return identificador;
    }
    
    public String getMarca() {
        return marca;
    }
}
```

### 4.2 Clase Concreta Carro

> [!bug] Código - Clase Carro
```java
package com.espol;

public class Carro<T> extends Vehiculo<T> {
    
    public Carro(T identificador, String marca) {
        super(identificador, marca);
    }
    
    @Override
    public void encender() {
        System.out.println("El carro " + marca + " con identificador " + 
                          identificador + " está encendido");
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS DEL CARRO ===");
        super.mostrarDatos();
    }
}
```

### 4.3 Clase Concreta Moto

> [!bug] Código - Clase Moto
```java
package com.espol;

public class Moto<T> extends Vehiculo<T> {
    private int cilindrada;
    
    public Moto(T identificador, String marca, int cilindrada) {
        super(identificador, marca);
        this.cilindrada = cilindrada;
    }
    
    @Override
    public void encender() {
        System.out.println("La moto " + marca + " " + cilindrada + "cc " + 
                          "con identificador " + identificador + " está encendida");
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS DE LA MOTO ===");
        super.mostrarDatos();
        System.out.println("Cilindrada: " + cilindrada + "cc");
    }
    
    public int getCilindrada() {
        return cilindrada;
    }
}
```

---

## Ejercicio 5: Uso de Comodines

> [!info] Objetivo
> Implementar un método genérico que use wildcards para trabajar con subtipos de Number.

### 5.1 Clase Utilidad

> [!bug] Código - Método con Wildcards
```java
package com.espol;

import java.util.List;

public class Utilidad {
    
    public static double sumarElementos(List<? extends Number> lista) {
        double suma = 0.0;
        for (Number numero : lista) {
            suma += numero.doubleValue();
        }
        return suma;
    }
    
    // Método adicional para encontrar el elemento menor
    public static <T extends Comparable<T>> T encontrarMenor(List<? extends T> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
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

## Ejercicio 6: Genéricos con Múltiples Tipos

> [!info] Objetivo
> Implementar una clase genérica que almacene tres elementos de diferentes tipos.

### 6.1 Clase Triple

> [!bug] Código - Triple con Múltiples Tipos
```java
package com.espol;

public class Triple<S, U, V> {
    private S primerElemento;
    private U segundoElemento;
    private V tercerElemento;
    
    public Triple(S primerElemento, U segundoElemento, V tercerElemento) {
        this.primerElemento = primerElemento;
        this.segundoElemento = segundoElemento;
        this.tercerElemento = tercerElemento;
    }
    
    public S getS() {
        return primerElemento;
    }
    
    public U getU() {
        return segundoElemento;
    }
    
    public V getV() {
        return tercerElemento;
    }
    
    public void mostrarTriple() {
        System.out.println("Triple: " + primerElemento + ", " + 
                          segundoElemento + ", " + tercerElemento);
    }
}
```

---

## Clase Principal Main

> [!success] Código Completo - Main
```java
package com.espol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1:
        System.out.println("\n=== Ejercicio 1 ===");

        Caja<String> cajaString = new Caja<>("Hello World");
        cajaString.set("Hello Sekai");
        cajaString.mostrarTipo();
        System.out.println("Contenido: " + cajaString.get());

        Caja<Integer> cajaInteger = new Caja<>(303);
        cajaInteger.set(505);
        cajaInteger.mostrarTipo();
        System.out.println("Contenido: " + cajaInteger.get());

        Caja<CustomClass> cajaCustomClass = new Caja<>(new CustomClass("Custom01", 1));
        cajaCustomClass.mostrarTipo();
        System.out.println("Contenido: " + cajaCustomClass.get());

        // Ejercicio 2:
        System.out.println("\n=== Ejercicio 2 ===");

        ListaPersonalizada<String> listaCadenas = new ListaPersonalizada<>();
        listaCadenas.agregar("Hola");
        listaCadenas.agregar("Mundo");
        listaCadenas.agregar("Java");
        
        System.out.println("Buscar 'Hola': " + listaCadenas.buscar("Hola"));
        listaCadenas.eliminar("Hola");
        System.out.println("Buscar 'Hola' después de eliminar: " + listaCadenas.buscar("Hola"));
        System.out.println("Tamaño de la lista: " + listaCadenas.tamanio());
        listaCadenas.mostrarElementos();
        
        // Ejercicio 3:
        System.out.println("\n=== Ejercicio 3 ===");
        
        List<String> listaStrings = new ArrayList<>();
        List<Integer> listaIntegers = new ArrayList<>();
        
        GestorDeListas.agregarElementoALista(listaStrings, "Programación");
        GestorDeListas.agregarElementoALista(listaStrings, "Estructuras de Datos");
        GestorDeListas.imprimirLista(listaStrings);
        
        GestorDeListas.agregarElementoALista(listaIntegers, 100);
        GestorDeListas.agregarElementoALista(listaIntegers, 200);
        GestorDeListas.imprimirLista(listaIntegers);
        
        GestorDeListas.removerElementoDeLista(listaStrings, "Programación");
        GestorDeListas.imprimirLista(listaStrings);

        // Ejercicio 4:
        System.out.println("\n=== Ejercicio 4 ===");
        
        Carro<String> miCarro = new Carro<>("ABC-123", "Toyota");
        miCarro.encender();
        miCarro.mostrarDatos();
        
        Moto<Integer> miMoto = new Moto<>(789456, "Yamaha", 250);
        miMoto.encender();
        miMoto.mostrarDatos();

        // Ejercicio 5:
        System.out.println("\n=== Ejercicio 5 ===");
        
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
        List<String> cadenas = Arrays.asList("z", "x", "a");
        
        System.out.println("Suma de enteros: " + Utilidad.sumarElementos(enteros));
        System.out.println("Suma de doubles: " + Utilidad.sumarElementos(doubles));
        System.out.println("Menor cadena: " + Utilidad.encontrarMenor(cadenas));

        // Ejercicio 6:
        System.out.println("\n=== Ejercicio 6 ===");
        
        Triple<String, Integer, Double> triple1 = new Triple<>("Hola", 42, 3.14);
        System.out.println("S: " + triple1.getS());
        System.out.println("U: " + triple1.getU());
        System.out.println("V: " + triple1.getV());
        triple1.mostrarTriple();
        
        Triple<Integer, String, Boolean> triple2 = new Triple<>(100, "Mensaje", true);
        triple2.mostrarTriple();
    }
}
```

---

## 📊 Resultados Esperados

> [!success] Salida del Programa
```
=== Ejercicio 1 ===
El tipo de contenido es: java.lang.String
Contenido: Hello Sekai
El tipo de contenido es: java.lang.Integer
Contenido: 505
El tipo de contenido es: com.espol.CustomClass
Contenido: CustomClass{nombre='Custom01', id=1}

=== Ejercicio 2 ===
Buscar 'Hola': true
Buscar 'Hola' después de eliminar: false
Tamaño de la lista: 2
Elementos: [Mundo, Java]

=== Ejercicio 3 ===
Elemento agregado: Programación
Elemento agregado: Estructuras de Datos
Contenido de la lista:
1. Programación
2. Estructuras de Datos
Elemento agregado: 100
Elemento agregado: 200
Contenido de la lista:
3. 100
4. 200
Elemento removido: Programación
Contenido de la lista:
5. Estructuras de Datos

=== Ejercicio 4 ===
El carro Toyota con identificador ABC-123 está encendido
=== DATOS DEL CARRO ===
Identificador: ABC-123
Marca: Toyota
La moto Yamaha 250cc con identificador 789456 está encendida
=== DATOS DE LA MOTO ===
Identificador: 789456
Marca: Yamaha
Cilindrada: 250cc

=== Ejercicio 5 ===
Suma de enteros: 15.0
Suma de doubles: 16.5
Menor cadena: a

=== Ejercicio 6 ===
S: Hola
U: 42
V: 3.14
Triple: Hola, 42, 3.14
Triple: 100, Mensaje, true
```

> [!info] Conclusión de la Tarea
> Esta tarea demuestra el dominio práctico de:
> - **Clases genéricas** para crear componentes reutilizables
> - **TDAs** para encapsular estructuras de datos
> - **Abstracción** mediante clases abstractas
> - **Comodines** para mayor flexibilidad en métodos
> - **Múltiples parámetros genéricos** para casos complejos
> 
> El código cumple con todos los requisitos especificados y muestra implementaciones claras y funcionales.

