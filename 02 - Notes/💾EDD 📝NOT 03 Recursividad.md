---
banner: https://images.unsplash.com/photo-1520076794559-6a1229412a42?ixlib=rb-4.1.0&q=85&fm=jpg&crop=entropy&cs=srgb&w=4800
fecha: 2025-10-16
tags:
  - 💾EDD
  - 📝NOT
---
---

# Recursividad
Un proceso recursivo se llama a sí mismo continuamente.
La forma más práctica de representarla en código es interpretarlas como funciones.

## Sucesión de Fibonacci
es una secuencia numérica infinita donde cada número es la suma de los dos anteriores, comenzando con 0 y 1.
La secuencia se define matemáticamente como: $F_n = F_{n-1} + F_{n-2}$ con los casos base: $F_0 = 0$ $F_1 = 1$

```java
public class Fibonacci {
    public static int fibonacci(int n) {
        switch (n) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
public static void main(String[] args) {
    System.out.println("Los primeros 10 números de Fibonacci:");
    for (int i = 0; i < 10; i++) {
        System.out.println("Fibonacci(" + i + ") = " + fibonacci(i));
    }
}
```

## Comentarios Finales
- Un proceso recursivo se llama a sí mismo continuamente.

## Ejercicio
Escribir métodos:
1. esPalindromo que recibe un objeto de tipo String y retorna si está o no es un palíndromo