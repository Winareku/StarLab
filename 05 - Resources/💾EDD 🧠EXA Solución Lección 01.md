---
tags:
  - 💾EDD
  - 🏫MPR
cssclasses:
  - center-titles
---
# Solución - Lección 01
> [!success] Recursividad
```java
public class EjerciciosRecursivos {

    // EJERCICIO 1: Sumar dígitos recursivamente
    public static int sumarDigitos(int n) {
        // Caso base: si n es menor a 10, ya no se puede dividir más
        if (n < 10) {
            return n;
        }
        // Caso recursivo: se suma el último dígito (n % 10) + suma de los dígitos restantes
        return (n % 10) + sumarDigitos(n / 10);
    }

    // EJERCICIO 2.1: Verificar si una cadena es un palíndromo usando recursividad
    public static boolean esPalindromo(String s) {
        // Si la cadena tiene 0 o 1 caracteres, es un palíndromo
        if (s.length() <= 1) {
            return true;
        }
        // Comparar primer y último carácter
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        // Llamada recursiva eliminando el primer y último carácter
        return esPalindromo(s.substring(1, s.length() - 1));
    }

    // EJERCICIO 2.2: Calcular potencia de forma recursiva
    public static int potencia(int base, int exponente) {
        // Caso base: cualquier número elevado a 0 es 1
        if (exponente == 0) {
            return 1;
        }
        // Caso recursivo: base * potencia(base, exponente - 1)
        return base * potencia(base, exponente - 1);
    }

    // EJERCICIO 2.3: Invertir una cadena recursivamente
    public static String revertir(String s) {
        // Caso base: cadena vacía o de un solo carácter
        if (s.length() <= 1) {
            return s;
        }
        // Tomar el último carácter + revertir el resto de la cadena
        return s.charAt(s.length() - 1) + revertir(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {

        // Pruebas del ejercicio 1
        System.out.println("La suma de dígitos de 135 es " + sumarDigitos(135) + ".");
        System.out.println("La suma de dígitos de 67 es " + sumarDigitos(67) + ".");
        System.out.println("La suma de dígitos de 1111 es " + sumarDigitos(1111) + ".");

        System.out.println();

        // Pruebas de esPalindromo
        System.out.println("El string \"ana\" " + (esPalindromo("ana") ? "es un palíndromo." : "no es un palíndromo."));
        System.out.println("El string \"perro\" " + (esPalindromo("perro") ? "es un palíndromo." : "no es un palíndromo."));
        System.out.println("El string \"arroz\" " + (esPalindromo("arroz") ? "es un palíndromo." : "no es un palíndromo."));

        System.out.println();

        // Pruebas de potencia
        System.out.println("2 elevado a 5 es " + potencia(2, 5) + ".");
        System.out.println("3 elevado a 3 es " + potencia(3, 3) + ".");
        System.out.println("1 elevado a 10 es " + potencia(1, 10) + ".");

        System.out.println();

        // Pruebas de revertir
        System.out.println("\"Hello\" revertido es \"" + revertir("Hello") + "\".");
        System.out.println("\"Palíndromo\" revertido es \"" + revertir("Palíndromo") + "\".");
        System.out.println("\"Agua\" revertido es \"" + revertir("Agua") + "\".");
    }
}
```

***

> [!bug] Agente Viajero (Fuerza Bruta)
``` java
/** 
Código para la Fuerza Bruta del Problema del Agente Viajero con Complejidad O(n!)

A continuación te muestro un ejemplo en código que implementa la solución de fuerza bruta para el problema del agente viajero. Este código calcula todas las rutas posibles y selecciona la de menor distancia. **/

import java.util.Arrays;

public class AgenteViajero {

    // Método para calcular la distancia total de una ruta
    public static int calcularDistancia(int[][] distancias, int[] ruta) {
        int distanciaTotal = 0;
        for (int i = 0; i < ruta.length - 1; i++) {
            distanciaTotal += distancias[ruta[i]][ruta[i + 1]];
        }
        // Agregar la distancia de regreso a la ciudad de origen
        distanciaTotal += distancias[ruta[ruta.length - 1]][ruta[0]];
        return distanciaTotal;
    }

    // Método para generar todas las permutaciones posibles de la ruta
    public static void permutar(int[] ruta, int l, int r, int[][] distancias, int[] mejorRuta, int[] minDistancia) {
        if (l == r) {
            // Calcular la distancia de la ruta actual
            int distanciaActual = calcularDistancia(distancias, ruta);
            // Actualizar si encontramos una mejor ruta
            if (distanciaActual < minDistancia[0]) {
                minDistancia[0] = distanciaActual;
                System.arraycopy(ruta, 0, mejorRuta, 0, ruta.length);
            }
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(ruta, l, i);
                permutar(ruta, l + 1, r, distancias, mejorRuta, minDistancia);
                intercambiar(ruta, l, i);  // Volver al estado original
            }
        }
    }

    // Método para intercambiar dos elementos en el arreglo
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Matriz de distancias entre ciudades
        int[][] distancias = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        // Inicializar la ruta
        int[] ruta = {0, 1, 2, 3};  // Representa las ciudades A, B, C, D
        int[] mejorRuta = new int[ruta.length];
        int[] minDistancia = {Integer.MAX_VALUE};  // Almacena la distancia mínima

        // Generar todas las permutaciones de la ruta y calcular la distancia mínima
        permutar(ruta, 0, ruta.length - 1, distancias, mejorRuta, minDistancia);

        // Imprimir la mejor ruta y la distancia mínima
        System.out.println("Mejor ruta: " + Arrays.toString(mejorRuta));
        System.out.println("Distancia mínima: " + minDistancia[0]);
    }
}

/**Ejemplo modificado para que veas cómo la multiplicación ocurre en la selección de rutas, y la suma ocurre al calcular las distancias.**/
import java.util.Arrays;

public class AgenteViajeroExplicado {

    // Método para calcular la distancia total de una ruta
    public static int calcularDistancia(int[][] distancias, int[] ruta) {
        int distanciaTotal = 0;
        // Sumar las distancias entre ciudades en la ruta
        for (int i = 0; i < ruta.length - 1; i++) {
            distanciaTotal += distancias[ruta[i]][ruta[i + 1]];
        }
        // Agregar la distancia de regreso a la ciudad de origen
        distanciaTotal += distancias[ruta[ruta.length - 1]][ruta[0]];
        return distanciaTotal;
    }

    // Método para generar todas las rutas posibles (permuta las ciudades)
    public static void permutar(int[] ruta, int l, int r, int[][] distancias, int[] mejorRuta, int[] minDistancia) {
        if (l == r) {
            // Calcular la distancia de la ruta actual
            int distanciaActual = calcularDistancia(distancias, ruta);
            // Actualizar si encontramos una mejor ruta (distancia más corta)
            if (distanciaActual < minDistancia[0]) {
                minDistancia[0] = distanciaActual;
                System.arraycopy(ruta, 0, mejorRuta, 0, ruta.length);
            }
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(ruta, l, i);  // Intercambiar ciudades
                permutar(ruta, l + 1, r, distancias, mejorRuta, minDistancia);  // Recursión
                intercambiar(ruta, l, i);  // Volver al estado original
            }
        }
    }

    // Método para intercambiar dos ciudades
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Matriz de distancias entre las ciudades
        int[][] distancias = {
            {0, 10, 15, 20},  // Distancias desde la ciudad A
            {10, 0, 35, 25},  // Distancias desde la ciudad B
            {15, 35, 0, 30},  // Distancias desde la ciudad C
            {20, 25, 30, 0}   // Distancias desde la ciudad D
        };

        // Inicializamos la ruta
        int[] ruta = {0, 1, 2, 3};  // Ciudades A, B, C, D
        int[] mejorRuta = new int[ruta.length];  // Para guardar la mejor ruta
        int[] minDistancia = {Integer.MAX_VALUE};  // Para guardar la distancia mínima

        // Generamos todas las permutaciones y calculamos la mejor ruta
        permutar(ruta, 0, ruta.length - 1, distancias, mejorRuta, minDistancia);

        // Imprimimos la mejor ruta y la distancia mínima
        System.out.println("Mejor ruta: " + Arrays.toString(mejorRuta));
        System.out.println("Distancia mínima: " + minDistancia[0]);
    }
}
```

***

> [!example] Búsqueda Binaria

```java
/**
Ejemplo en Java
A continuación, te muestro un ejemplo de cómo implementar la búsqueda binaria en Java.
**/

public class BusquedaBinaria {

    // Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el índice medio

            // Verificar si el valor buscado está en el medio
            if (arr[medio] == valorBuscado) {
                return medio;  // Elemento encontrado
            }

            // Si el valor buscado es mayor, ignorar la mitad izquierda
            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                // Si el valor buscado es menor, ignorar la mitad derecha
                fin = medio - 1;
            }
        }

        // El valor no está presente en el arreglo
        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 3, 4, 10, 40};  // El arreglo debe estar ordenado
        int valorBuscado = 10;

        // Llamar al método de búsqueda binaria
        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
}


/** Código para los Casos de Búsqueda Binaria

Caso 1: Valor en el Medio
Este caso muestra cómo se comporta la búsqueda binaria cuando el valor buscado está justo en el medio del arreglo**/


public class BusquedaBinariaCaso1 {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el valor medio

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado en el medio
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;  // Valor no encontrado
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};  // Tamaño impar, el valor buscado está en el medio
        int valorBuscado = 3;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/** Caso 2: Valor en la Mitad Derecha
En este caso, el valor buscado está en la mitad derecha del arreglo.**/


public class BusquedaBinariaCaso2 {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el valor medio

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }

        return -1;  // Valor no encontrado
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // Tamaño impar, el valor está en la mitad derecha
        int valorBuscado = 7;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/**Caso 3: Valor en la Mitad Izquierda
En este caso, el valor buscado está en la mitad izquierda del arreglo.**/


public class BusquedaBinariaCaso3 {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el valor medio

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }

        return -1;  // Valor no encontrado
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // Tamaño impar, el valor está en la mitad izquierda
        int valorBuscado = 2;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}

/**Caso General 2: Tamaño Par e Impar
Aquí tienes ejemplos para un arreglo con tamaño par y otro con tamaño impar, para ver cómo se comporta la búsqueda binaria en cada uno.

Arreglo de Tamaño Impar**/

public class BusquedaBinariaTamañoImpar {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7};  // Tamaño impar
        int valorBuscado = 5;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/**Arreglo de Tamaño Par**/

public class BusquedaBinariaTamañoPar {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8};  // Tamaño par
        int valorBuscado = 6;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/**Código General para Búsqueda Binaria (incluyendo todos los casos)**/

public class BusquedaBinariaGeneral {

    // Método general de búsqueda binaria que cubre todos los casos
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        // Bucle que sigue dividiendo la lista hasta encontrar el valor o agotar la búsqueda
        while (inicio <= fin) {
            // Calcular el índice del valor medio
            int medio = inicio + (fin - inicio) / 2;

            // Caso 1: Valor encontrado en el medio
            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado, retornar el índice
            }

            // Caso 2: El valor buscado es mayor que el valor medio
            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                // Caso 3: El valor buscado es menor que el valor medio
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }

        // Si el valor no se encuentra en el arreglo, retorna -1
        return -1;
    }

    public static void main(String[] args) {
        // Ejemplos de arreglos de diferentes tamaños (par e impar)
        int[] arregloImpar = {1, 2, 3, 4, 5, 6, 7};  // Tamaño impar
        int[] arregloPar = {1, 2, 3, 4, 5, 6, 7, 8};  // Tamaño par

        // Probar el caso 1: valor en el medio del arreglo impar
        int resultado1 = busquedaBinaria(arregloImpar, 4);
        if (resultado1 != -1) {
            System.out.println("Valor encontrado en el índice (Caso 1): " + resultado1);
        } else {
            System.out.println("Valor no encontrado (Caso 1)");
        }

        // Probar el caso 2: valor en la mitad derecha del arreglo impar
        int resultado2 = busquedaBinaria(arregloImpar, 7);
        if (resultado2 != -1) {
            System.out.println("Valor encontrado en el índice (Caso 2): " + resultado2);
        } else {
            System.out.println("Valor no encontrado (Caso 2)");
        }

        // Probar el caso 3: valor en la mitad izquierda del arreglo impar
        int resultado3 = busquedaBinaria(arregloImpar, 2);
        if (resultado3 != -1) {
            System.out.println("Valor encontrado en el índice (Caso 3): " + resultado3);
        } else {
            System.out.println("Valor no encontrado (Caso 3)");
        }

        // Probar el caso general: valor en el arreglo par
        int resultado4 = busquedaBinaria(arregloPar, 6);
        if (resultado4 != -1) {
            System.out.println("Valor encontrado en el índice (Arreglo Par): " + resultado4);
        } else {
            System.out.println("Valor no encontrado (Arreglo Par)");
        }
    }
}
```

***

