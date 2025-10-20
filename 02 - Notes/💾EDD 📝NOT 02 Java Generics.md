---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Java Generics
---
> [!info] Los genéricos permiten crear código reusable y type-safe
Parametrización de tipos para crear clases, interfaces y métodos que trabajen con diferentes tipos de datos.

> [!quote] Motivación
> ¿Por qué necesitamos genéricos?
> ```java
> // Sin genéricos - métodos específicos
> public static int divideByTwo(int n)
> public static int divideByThree(int n)
> public static int divideByFour(int n)
> 
> // Con genéricos - un método reusable
> public static int divideBy(int n, int divisor)
> ```

> [!bug] Solución inicial: Usando Object
> ```java
> public class Box {
>     private Object article = null;
>     public Object getArticle() {
>         return article;
>     }
> }
> // Problema: necesita casting explícito
> String article = (String) box.getArticle();
> // Riesgo: ClassCastException en tiempo de ejecución
> ```

> [!success] Solución con Genéricos
> ```java
> public class Box<T> {
>     private T article = null;
>     
>     public Box(T article) {
>         this.article = article;
>     }
>     
>     public T getArticle() {
>         return article;
>     }
>     
>     public void setArticle(T article) {
>         this.article = article;
>     }
> }
> ```

> [!example] Uso de Clases Genéricas
> ```java
> Box<String> box1 = new Box<>("Joya");
> Box<Integer> box2 = new Box<>(1000);
> Box<Student> box3 = new Box<>(new Student("Gonzalo", "Méndez"));
> 
> // No necesita casting - type safe
> String article = box1.getArticle();
> ```

> [!info] Convenciones de Nombres
> | **Parámetro** | **Significado** |
> |---------------|-----------------|
> | E | Element (usado en Collections) |
> | K | Key |
> | N | Number |
> | T | Type |
> | V | Value |
> | S, U, V | 2nd, 3rd, 4th types |

> [!warning] Puntos Importantes
> - **Solo tipos compuestos**: `Box<int>` ❌, `Box<Integer>` ✅
> - **Tipos incompatibles**: `Box<String> ≠ Box<Integer>`
> - **No es Overloading**: Los genéricos varían el tipo, overloading varía los parámetros

> [!success] Ejercicio: Relación entre Entidades
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
> 
> // Uso:
> // Relation<Perro, Persona> mascota = new Relation<>(cachorro, señora, "es mascota de");
> // Relation<Empresario, Empresa> posesion = new Relation<>(empresario, empresa, "posee");
> ```