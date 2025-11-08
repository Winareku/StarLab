---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Java Generics

## 1. Introducción a los Genéricos

> [!info] ¿Qué son los Genéricos?
> Los genéricos permiten crear **clases, interfaces y métodos** que operan sobre tipos de datos especificados como parámetros, proporcionando **seguridad de tipo en tiempo de compilación**.

### 1.1 Motivación

> [!example] Problema sin Genéricos
> ```java
> public class Box {
>     private Object objeto;
>     
>     public void set(Object objeto) {
>         this.objeto = objeto;
>     }
> 
>     public Object get() {
>         return objeto;
>     }
> }
> ```
> **Problemas:**
> - Necesidad de casting explícito
> - Posibles errores en tiempo de ejecución

### 1.2 Beneficios de los Genéricos

| **Sin Genéricos**    | **Con Genéricos**      | **Ventaja**          |
| -------------------- | ---------------------- | -------------------- |
| Casting necesario    | Sin casting            | Mayor seguridad      |
| Errores en ejecución | Errores en compilación | Detección temprana   |
| Código menos legible | Código más claro       | Mejor mantenibilidad |

---

## 2. Clases Genéricas

> [!info] Definición
> Clases que pueden trabajar con diferentes tipos de datos mediante parámetros de tipo.

### 2.1 Ejemplo Básico

> [!bug] Código
> ```java
> public class Caja<T> {
>     private T contenido;
>     
>     public void set(T contenido) {
>         this.contenido = contenido;
>     }
>     
>     public T get() {
>         return contenido;
>     }
> }
> ```

### 2.2 Uso de Clases Genéricas

> [!example] Implementación
> ```java
> public class Main {
>     public static void main(String[] args) {
>         // Caja para String
>         Caja<String> cajaString = new Caja<>();
>         cajaString.set("Hola Mundo");
>         String mensaje = cajaString.get(); // Sin casting
>         
>         // Caja para Integer
>         Caja<Integer> cajaEntero = new Caja<>();
>         cajaEntero.set(123);
>         Integer numero = cajaEntero.get(); // Sin casting
>     }
> }
> ```

---

## 3. Métodos Genéricos

> [!info] Características
> Métodos que pueden declarar sus propios parámetros de tipo, independientemente de la clase.

### 3.1 Ejemplo de Método Genérico

> [!bug] Código
> ```java
> public class Utilidad {
>     public static <T> void imprimir(T objeto) {
>         System.out.println(objeto);
>     }
> }
> ```

### 3.2 Uso de Métodos Genéricos

> [!example] Implementación
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Utilidad.imprimir("Hola Mundo");
>         Utilidad.imprimir(123);
>         Utilidad.imprimir(99.99);
>     }
> }
> ```

---

## 4. Interfaces Genéricas

> [!info] Definición
> Interfaces que pueden ser parametrizadas con tipos de datos.

### 4.1 Ejemplo de Interface Genérica

> [!bug] Código
> ```java
> public interface Comparador<T> {
>     boolean comparar(T a, T b);
> }
> ```

### 4.2 Implementación de Interface Genérica

> [!example] Uso
> ```java
> public class ComparadorEnteros implements Comparador<Integer> {
>     public boolean comparar(Integer a, Integer b) {
>         return a > b;
>     }
> }
> ```

---

## 5. Wildcards (Comodines)

> [!info] Tipos de Comodines
> Permiten mayor flexibilidad en el uso de tipos genéricos.

### 5.1 Wildcard Sin Restricción

> [!bug] Código
> ```java
> public class Utilidad {
>     public static void imprimirLista(List<?> lista) {
>         for (Object obj : lista) {
>             System.out.println(obj);
>         }
>     }
> }
> ```

### 5.2 Wildcard con Límite Superior

> [!bug] Código
> ```java
> public class Utilidad {
>     public static void imprimirNumeros(List<? extends Number> lista) {
>         for (Number numero : lista) {
>             System.out.println(numero);
>         }
>     }
> }
> ```

---

## 6. Convenciones de Nombres

> [!info] Estándares Comunes
> Convenciones para nombres de parámetros genéricos:

| **Letra** | **Significado**   | **Uso Típico**                |
| --------- | ----------------- | ----------------------------- |
| E         | Element           | Colecciones (List<E>, Set<E>) |
| K         | Key               | Mapas (Map<K, V>)             |
| N         | Number            | Tipos numéricos               |
| T         | Type              | Tipo genérico cualquiera      |
| V         | Value             | Valores en mapas              |
| S, U, V   | Tipos adicionales | Múltiples parámetros          |

> [!warning] Importante
> Estas son **convenciones**, no reglas. Puedes usar cualquier letra, pero se recomienda seguir los estándares para mejor legibilidad.

---

## 7. Puntos Importantes

### 7.1 Restricciones

> [!danger] Limitaciones
> - No se pueden usar tipos primitivos (`int`, `char`, etc.)
> - Se deben usar clases envoltorias (`Integer`, `Character`, etc.)

> [!bug] Ejemplo
> ```java
> Box<int> b1 = new Box(28); // ERROR
> Box<Integer> b1 = new Box(28); // OK
> ```

### 7.2 Métodos Estáticos y Genéricos

> [!warning] Precaución
> En métodos estáticos no se puede acceder directamente al parámetro de tipo de la clase.

> [!bug] Solución
> ```java
> // INCORRECTO
> public static void mostrarContenido() {
>     System.out.println(contenido); // Error
> }
> 
> // CORRECTO - Pasando instancia como parámetro
> public static <T> void mostrarContenido(Caja<T> caja) {
>     System.out.println(caja.contenido);
> }
> ```

### 7.3 Múltiples Parámetros Genéricos

> [!example] Ejemplo Avanzado
> ```java
> public class Par<K, V> {
>     private K clave;
>     private V valor;
> 
>     public Par(K clave, V valor) {
>         this.clave = clave;
>         this.valor = valor;
>     }
> 
>     public K getClave() { return clave; }
>     public V getValor() { return valor; }
> }
> ```

---

## 8. Ejercicios Prácticos

### 8.1 Ejercicio: Clase Par

> [!success] Implementación
> ```java
> public class Par<K, V> {
>     private K clave;
>     private V valor;
> 
>     public Par(K clave, V valor) {
>         this.clave = clave;
>         this.valor = valor;
>     }
> 
>     public K getClave() { return clave; }
>     public V getValor() { return valor; }
> }
> ```

### 8.2 Ejercicio: Clase Relación

> [!success] Implementación
> ```java
> public class Relation<T, R> {
>     private T entity1;
>     private R entity2;
>     private String description;
> 
>     public Relation(T entity1, R entity2, String description) {
>         this.entity1 = entity1;
>         this.entity2 = entity2;
>         this.description = description;
>     }
>     
>     // Getters y setters...
> }
> ```

---

## 9. Resumen Final

> [!quote] Concepto Clave
> "Los genéricos proporcionan **seguridad de tipo** y **eliminan la necesidad de casting**, haciendo el código más seguro y legible."

### 9.1 Ventajas Principales

- ✅ **Seguridad de tipo** en tiempo de compilación
- ✅ **Eliminación de casting** explícito
- ✅ **Reutilización de código** para diferentes tipos
- ✅ **Mejor legibilidad** y mantenimiento

### 9.2 Buenas Prácticas

- 🎯 Seguir convenciones de nombres (T, E, K, V, etc.)
- 🎯 Usar wildcards cuando se necesite flexibilidad
- 🎯 Evitar raw types (tipos crudos)
- 🎯 Considerar límites cuando se necesiten restricciones

> [!success] Conclusión
> Los genéricos son una herramienta fundamental en Java que permite escribir código **type-safe** y reutilizable, mejorando significativamente la calidad y mantenibilidad del software.