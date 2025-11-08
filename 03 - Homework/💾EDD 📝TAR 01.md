---
tags:
  - 💾EDD
  - 📝TAR
cssclasses:
  - center-titles
---

# Aplicación de Genéricos y TDAs en Java

## Ejercicio 1: Clase Genérica Caja<T>

> [!bug] Código - Clase Caja
```java
public class Caja<T> {
    private T objeto;
    
    public void set(T objeto) {
        this.objeto = objeto;
    }
    
    public T get() {
        return objeto;
    }
    
    public void mostrarTipo() {
        System.out.println("Tipo almacenado: " + objeto.getClass().getSimpleName());
    }
}
```

> [!bug] Código - Clase CustomClass
```java
public class CustomClass {
    private String nombre;
    private int valor;
    
    public CustomClass(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "CustomClass{nombre='" + nombre + "', valor=" + valor + "}";
    }
}
```

> [!bug] Código - Programa Principal Ejercicio 1
```java
public class MainEjercicio1 {
    public static void main(String[] args) {
        // Caja para String
        Caja<String> cajaString = new Caja<>();
        cajaString.set("Hola Mundo");
        cajaString.mostrarTipo();
        System.out.println("Contenido: " + cajaString.get());
        
        // Caja para Integer
        Caja<Integer> cajaInteger = new Caja<>();
        cajaInteger.set(123);
        cajaInteger.mostrarTipo();
        System.out.println("Contenido: " + cajaInteger.get());
        
        // Caja para CustomClass
        Caja<CustomClass> cajaCustom = new Caja<>();
        cajaCustom.set(new CustomClass("Ejemplo", 100));
        cajaCustom.mostrarTipo();
        System.out.println("Contenido: " + cajaCustom.get());
    }
}
```

---

## Ejercicio 2: TDA ListaPersonalizada<T>

> [!bug] Código - ListaPersonalizada
```java
import java.util.ArrayList;
import java.util.List;

public class ListaPersonalizada<T> {
    private List<T> elementos;
    
    public ListaPersonalizada() {
        this.elementos = new ArrayList<>();
    }
    
    public void agregar(T elemento) {
        elementos.add(elemento);
        System.out.println("Elemento agregado: " + elemento);
    }
    
    public boolean eliminar(T elemento) {
        boolean eliminado = elementos.remove(elemento);
        if (eliminado) {
            System.out.println("Elemento eliminado: " + elemento);
        } else {
            System.out.println("Elemento no encontrado: " + elemento);
        }
        return eliminado;
    }
    
    public boolean buscar(T elemento) {
        boolean encontrado = elementos.contains(elemento);
        System.out.println("Búsqueda de " + elemento + ": " + 
                          (encontrado ? "ENCONTRADO" : "NO ENCONTRADO"));
        return encontrado;
    }
    
    public int tamanio() {
        return elementos.size();
    }
    
    public void mostrarElementos() {
        System.out.println("Elementos en la lista: " + elementos);
    }
}
```

> [!bug] Código - Programa Principal Ejercicio 2
```java
public class MainEjercicio2 {
    public static void main(String[] args) {
        // Lista de Strings
        ListaPersonalizada<String> listaStrings = new ListaPersonalizada<>();
        listaStrings.agregar("Uno");
        listaStrings.agregar("Dos");
        listaStrings.agregar("Tres");
        
        listaStrings.buscar("Dos");
        listaStrings.eliminar("Dos");
        listaStrings.buscar("Dos");
        System.out.println("Tamaño de la lista: " + listaStrings.tamanio());
        listaStrings.mostrarElementos();
        
        // Lista de Integers
        ListaPersonalizada<Integer> listaIntegers = new ListaPersonalizada<>();
        listaIntegers.agregar(100);
        listaIntegers.agregar(200);
        listaIntegers.agregar(300);
        
        listaIntegers.buscar(200);
        listaIntegers.eliminar(200);
        System.out.println("Tamaño de la lista: " + listaIntegers.tamanio());
        listaIntegers.mostrarElementos();
    }
}
```

---

## Ejercicio 3: GestorDeListas

> [!bug] Código - GestorDeListas
```java
import java.util.List;

public class GestorDeListas {
    
    public static <T> void agregarElementoALista(List<T> lista, T elemento) {
        lista.add(elemento);
        System.out.println("Elemento agregado: " + elemento);
    }
    
    public static <T> boolean removerElementoDeLista(List<T> lista, T elemento) {
        boolean removido = lista.remove(elemento);
        if (removido) {
            System.out.println("Elemento removido: " + elemento);
        } else {
            System.out.println("Elemento no encontrado: " + elemento);
        }
        return removido;
    }
    
    public static <T> void imprimirLista(List<T> lista) {
        System.out.println("Contenido de la lista:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }
}
```

> [!bug] Código - Programa Principal Ejercicio 3
```java
import java.util.ArrayList;
import java.util.List;

public class MainEjercicio3 {
    public static void main(String[] args) {
        // Lista de Strings
        List<String> listaStrings = new ArrayList<>();
        GestorDeListas.agregarElementoALista(listaStrings, "Java");
        GestorDeListas.agregarElementoALista(listaStrings, "Python");
        GestorDeListas.agregarElementoALista(listaStrings, "C++");
        GestorDeListas.imprimirLista(listaStrings);
        
        GestorDeListas.removerElementoDeLista(listaStrings, "Python");
        GestorDeListas.imprimirLista(listaStrings);
        
        // Lista de Integers
        List<Integer> listaIntegers = new ArrayList<>();
        GestorDeListas.agregarElementoALista(listaIntegers, 10);
        GestorDeListas.agregarElementoALista(listaIntegers, 20);
        GestorDeListas.agregarElementoALista(listaIntegers, 30);
        GestorDeListas.imprimirLista(listaIntegers);
    }
}
```

---

## Ejercicio 4: TDAs y Clases Abstractas

> [!bug] Código - Vehículo Abstracto
```java
public abstract class Vehiculo<T> {
    protected T identificador;
    protected String marca;
    
    public Vehiculo(T identificador, String marca) {
        this.identificador = identificador;
        this.marca = marca;
    }
    
    public abstract void encender();
    
    public void mostrarDatos() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Marca: " + marca);
    }
    
    public T getIdentificador() {
        return identificador;
    }
    
    public String getMarca() {
        return marca;
    }
}
```

> [!bug] Código - Clase Carro
```java
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

> [!bug] Código - Clase Moto
```java
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
}
```

> [!bug] Código - Programa Principal Ejercicio 4
```java
public class MainEjercicio4 {
    public static void main(String[] args) {
        // Carro con String como identificador (placa)
        Carro<String> miCarro = new Carro<>("ABC-123", "Toyota");
        miCarro.encender();
        miCarro.mostrarDatos();
        
        System.out.println();
        
        // Moto con Integer como identificador
        Moto<Integer> miMoto = new Moto<>(789456, "Yamaha", 250);
        miMoto.encender();
        miMoto.mostrarDatos();
    }
}
```

---

## Ejercicio 5: Uso de Comodines (? extends T)

> [!bug] Código - Clase Utilidad
```java
import java.util.List;

public class Utilidad {
    
    public static double sumarElementos(List<? extends Number> lista) {
        double suma = 0.0;
        for (Number numero : lista) {
            suma += numero.doubleValue();
        }
        return suma;
    }
}
```

> [!bug] Código - Programa Principal Ejercicio 5
```java
import java.util.Arrays;
import java.util.List;

public class MainEjercicio5 {
    public static void main(String[] args) {
        // Lista de Integers
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5);
        double sumaEnteros = Utilidad.sumarElementos(enteros);
        System.out.println("Suma de enteros: " + sumaEnteros);
        
        // Lista de Doubles
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
        double sumaDoubles = Utilidad.sumarElementos(doubles);
        System.out.println("Suma de doubles: " + sumaDoubles);
        
        // Lista mixta (solo para demostración - normalmente homogénea)
        List<Number> numeros = Arrays.asList(10, 20.5, 30, 40.7);
        double sumaNumeros = Utilidad.sumarElementos(numeros);
        System.out.println("Suma de números mixtos: " + sumaNumeros);
    }
}
```

---

## Ejercicio 6: Genéricos con múltiples tipos

> [!bug] Código - Clase Triple
```java
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

> [!bug] Código - Programa Principal Ejercicio 6
```java
public class MainEjercicio6 {
    public static void main(String[] args) {
        // Triple con String, Integer, Double
        Triple<String, Integer, Double> triple1 = 
            new Triple<>("Hola", 42, 3.14);
        
        System.out.println("S: " + triple1.getS());
        System.out.println("U: " + triple1.getU());
        System.out.println("V: " + triple1.getV());
        triple1.mostrarTriple();
        
        System.out.println();
        
        // Triple con diferentes tipos
        Triple<Integer, String, Boolean> triple2 = 
            new Triple<>(100, "Mensaje", true);
        
        System.out.println("S: " + triple2.getS());
        System.out.println("U: " + triple2.getU());
        System.out.println("V: " + triple2.getV());
        triple2.mostrarTriple();
    }
}
```

---

## 📊 Resultados Esperados

> [!success] Salida Esperada - Resumen
```
=== EJERCICIO 1 ===
Tipo almacenado: String
Contenido: Hola Mundo
Tipo almacenado: Integer
Contenido: 123
Tipo almacenado: CustomClass
Contenido: CustomClass{nombre='Ejemplo', valor=100}

=== EJERCICIO 2 ===
Elemento agregado: Uno
Elemento agregado: Dos
Elemento agregado: Tres
Búsqueda de Dos: ENCONTRADO
Elemento eliminado: Dos
Búsqueda de Dos: NO ENCONTRADO
Tamaño de la lista: 2
Elementos en la lista: [Uno, Tres]

=== EJERCICIO 3 ===
Elemento agregado: Java
Elemento agregado: Python
Elemento agregado: C++
Contenido de la lista:
1. Java
2. Python
3. C++
Elemento removido: Python
Contenido de la lista:
4. Java
5. C++

=== EJERCICIO 4 ===
El carro Toyota con identificador ABC-123 está encendido
=== DATOS DEL CARRO ===
Identificador: ABC-123
Marca: Toyota

La moto Yamaha 250cc con identificador 789456 está encendida
=== DATOS DE LA MOTO ===
Identificador: 789456
Marca: Yamaha
Cilindrada: 250cc

=== EJERCICIO 5 ===
Suma de enteros: 15.0
Suma de doubles: 16.5
Suma de números mixtos: 101.2

=== EJERCICIO 6 ===
S: Hola
U: 42
V: 3.14
Triple: Hola, 42, 3.14

S: 100
U: Mensaje
V: true
Triple: 100, Mensaje, true

> [!info] Conclusión de la Tarea
> Esta tarea demuestra el uso práctico de:
> - **Clases genéricas** para crear componentes reutilizables
> - **TDAs** para encapsular estructuras de datos
> - **Abstracción** mediante clases abstractas
> - **Comodines** para mayor flexibilidad en métodos
> - **Múltiples parámetros genéricos** para casos complejos
> 
> El código cumple con todos los requisitos especificados y muestra implementaciones claras y funcionales.
