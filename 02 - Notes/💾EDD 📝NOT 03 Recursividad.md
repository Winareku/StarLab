---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Recursividad
---
> [!info] Un proceso recursivo se llama a sí mismo continuamente.
La forma más práctica de representarla en código es interpretarlas como funciones.

> [!quote] Sucesión de Fibonacci
Es una secuencia numérica infinita donde cada número es la suma de los dos anteriores, comenzando con 0 y 1.
La secuencia se define matemáticamente como: $F_n = F_{n-1} + F_{n-2}$ con los casos base: $F_0 = 0$ y $F_1 = 1$

> [!bug] Método
> ```java
> public class Fibonacci {
>     public static int fibonacci(int n) {
>         switch (n) {
>             case 1:
>                 return 0;
>             case 2:
>                 return 1;
>             default:
>                 return fibonacci(n - 1) + fibonacci(n - 2);
>         }
>     }
> }
> public static void main(String[] args) {
>     System.out.println("Los primeros 10 números de Fibonacci:");
>     for (int i = 0; i < 10; i++) {
>         System.out.println("Fibonacci(" + i + ") = " + fibonacci(i));
>     }
> }
> ```

> [!info] Un proceso recursivo se llama a sí mismo continuamente.

> [!success] Ejercicio
> Escribir métodos:
> 1. esPalindromo() que recibe un objeto de tipo String y retorna si está o no es un palíndromo.
> 2. revertir() que recibe un arreglo e invierte su orden.