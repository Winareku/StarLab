---
tags:
  - 💾EDD
  - 📝TAR
cssclasses:
  - center-titles
---

# Aplicación de la Recursión

## Ejercicio 1: Sucesión de Fibonacci con Recursión

> [!info] Enunciado
> Implementa un método recursivo que calcule el n-ésimo término de la Sucesión de Fibonacci.

### 📌 Definición Matemática

La sucesión de Fibonacci se define como:
- **F(0) = 0**
- **F(1) = 1**  
- **F(n) = F(n-1) + F(n-2)** para n ≥ 2

### 💻 Implementación en Java

> [!bug] Código Fibonacci Recursivo
> ```java
> public class Fibonacci {
>     
>     /**
>      * Calcula el n-ésimo término de la sucesión de Fibonacci de forma recursiva
>      * @param n posición en la sucesión (n >= 0)
>      * @return el valor del n-ésimo término de Fibonacci
>      */
>     public static int fibonacciRecursivo(int n) {
>         // Casos base
>         if (n == 0) {
>             return 0;
>         }
>         if (n == 1) {
>             return 1;
>         }
>         
>         // Caso recursivo
>         return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
>     }
>     
>     // Método main para pruebas
>     public static void main(String[] args) {
>         // Prueba con n = 9
>         int resultado = fibonacciRecursivo(9);
>         System.out.println("El término 9 de la sucesión de Fibonacci es: " + resultado);
>         
>         // Pruebas adicionales
>         System.out.println("\nPrimeros 15 términos de Fibonacci:");
>         for (int i = 0; i <= 14; i++) {
>             System.out.println("F(" + i + ") = " + fibonacciRecursivo(i));
>         }
>     }
> }
> ```

### 🧪 Ejecución y Resultados

> [!example] Salida Esperada
> ```
> El término 9 de la sucesión de Fibonacci es: 21
> 
> Primeros 15 términos de Fibonacci:
> F(0) = 0
> F(1) = 1
> F(2) = 1
> F(3) = 2
> F(4) = 3
> F(5) = 5
> F(6) = 8
> F(7) = 13
> F(8) = 21
> F(9) = 34
> F(10) = 55
> F(11) = 89
> F(12) = 144
> F(13) = 233
> F(14) = 377
> ```

### ⚠️ Consideraciones de Implementación

> [!warning] Limitaciones de la Versión Recursiva Simple
> - **Complejidad exponencial**: O(2ⁿ)
> - **Ineficiente para valores grandes** de n
> - **Llamadas recursivas repetitivas** calculan los mismos valores múltiples veces

> [!tip] Versión Mejorada (Opcional)
> ```java
> // Versión con memoización para mejorar el rendimiento
> import java.util.HashMap;
> import java.util.Map;
> 
> public class FibonacciMemoizado {
>     private static Map<Integer, Integer> memo = new HashMap<>();
>     
>     public static int fibonacciMemo(int n) {
>         if (n == 0) return 0;
>         if (n == 1) return 1;
>         
>         if (memo.containsKey(n)) {
>             return memo.get(n);
>         }
>         
>         int resultado = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
>         memo.put(n, resultado);
>         return resultado;
>     }
> }
> ```

---

## Ejercicio 2: Determinar si una Cadena es Palíndromo

> [!info] Enunciado
> Implementa un método recursivo que verifique si una cadena de texto es un palíndromo, ignorando espacios y signos de puntuación.

### 📌 Definición de Palíndromo

Un **palíndromo** es una palabra, frase o secuencia que se lee igual en ambas direcciones.

**Ejemplos:**
- "anilina" → es palíndromo
- "reconocer" → es palíndromo  
- "A man, a plan, a canal: Panama" → es palíndromo (ignorando espacios y puntuación)

### 💻 Implementación en Java

> [!bug] Código Palíndromo Recursivo
> ```java
> public class Palindromo {
>     
>     /**
>      * Verifica si una cadena es palíndromo (versión recursiva)
>      * @param palabra cadena a verificar
>      * @return true si es palíndromo, false en caso contrario
>      */
>     public static boolean esPalindromeRecursivo(String palabra) {
>         // Limpiar la cadena: eliminar espacios y signos de puntuación, convertir a minúsculas
>         String cadenaLimpia = palabra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
>         
>         // Llamar al método recursivo auxiliar
>         return esPalindromeAuxiliar(cadenaLimpia);
>     }
>     
>     /**
>      * Método auxiliar recursivo que verifica si una cadena limpia es palíndromo
>      * @param cadena cadena limpia (sin espacios/puntuación, en minúsculas)
>      * @return true si es palíndromo
>      */
>     private static boolean esPalindromeAuxiliar(String cadena) {
>         // Casos base
>         if (cadena.length() <= 1) {
>             return true;
>         }
>         
>         // Verificar primer y último carácter
>         char primerChar = cadena.charAt(0);
>         char ultimoChar = cadena.charAt(cadena.length() - 1);
>         
>         if (primerChar != ultimoChar) {
>             return false;
>         }
>         
>         // Llamada recursiva con el substring interior
>         String interior = cadena.substring(1, cadena.length() - 1);
>         return esPalindromeAuxiliar(interior);
>     }
>     
>     // Método main para pruebas
>     public static void main(String[] args) {
>         // Pruebas con diferentes cadenas
>         String[] pruebas = {
>             "anilina",
>             "reconocer",
>             "A man, a plan, a canal: Panama",
>             "Java",
>             "hola",
>             "12321",
>             "Anita lava la tina"
>         };
>         
>         for (String prueba : pruebas) {
>             boolean resultado = esPalindromeRecursivo(prueba);
>             System.out.println("\"" + prueba + "\" -> " + 
>                 (resultado ? "ES palíndromo" : "NO es palíndromo"));
>         }
>     }
> }
> ```

### 🧪 Ejecución y Resultados

> [!example] Salida Esperada
> ```
> "anilina" -> ES palíndromo
> "reconocer" -> ES palíndromo
> "A man, a plan, a canal: Panama" -> ES palíndromo
> "Java" -> NO es palíndromo
> "hola" -> NO es palíndromo
> "12321" -> ES palíndromo
> "Anita lava la tina" -> ES palíndromo
> ```

### 🔍 Explicación del Algoritmo

> [!success] Estrategia Recursiva
> 1. **Limpieza**: Eliminar caracteres no alfanuméricos y convertir a minúsculas
> 2. **Caso base**: Cadena vacía o de 1 carácter → siempre es palíndromo
> 3. **Comparación**: Verificar si primer y último carácter son iguales
> 4. **Recursión**: Aplicar mismo algoritmo al substring interior

### ⚡ Versión con Índices (Alternativa Eficiente)

> [!tip] Implementación Optimizada
> ```java
> // Versión que evita crear múltiples substrings
> public static boolean esPalindromeRecursivoEficiente(String palabra) {
>     String cadenaLimpia = palabra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
>     return esPalindromeConIndices(cadenaLimpia, 0, cadenaLimpia.length() - 1);
> }
> 
> private static boolean esPalindromeConIndices(String cadena, int inicio, int fin) {
>     // Caso base
>     if (inicio >= fin) {
>         return true;
>     }
>     
>     // Verificar caracteres en las posiciones inicio y fin
>     if (cadena.charAt(inicio) != cadena.charAt(fin)) {
>         return false;
>     }
>     
>     // Llamada recursiva moviendo los índices
>     return esPalindromeConIndices(cadena, inicio + 1, fin - 1);
> }
> ```

---

## 📊 Análisis de Complejidad

| **Ejercicio** | **Complejidad Temporal** | **Complejidad Espacial** | **Observaciones** |
|---------------|--------------------------|--------------------------|-------------------|
| **Fibonacci Recursivo** | O(2ⁿ) | O(n) | Muy ineficiente para n grande |
| **Fibonacci con Memoización** | O(n) | O(n) | Mejor rendimiento |
| **Palíndromo Recursivo** | O(n) | O(n) | n = longitud de la cadena |
| **Palíndromo con Índices** | O(n) | O(1) | Más eficiente en memoria |

---

## 🎯 Conclusiones

> [!success] Logros de la Tarea
> - ✅ Implementación correcta de **Fibonacci recursivo**
> - ✅ Implementación funcional de **verificación de palíndromos**
> - ✅ Manejo adecuado de **casos base** en recursión
> - ✅ Procesamiento de cadenas con **limpieza de caracteres**
> - ✅ Pruebas exhaustivas con diferentes casos de uso

> [!warning] Consideraciones Adicionales
> - La recursión puede causar **StackOverflowError** para entradas muy grandes
> - Es importante considerar **iterativas** para mejor rendimiento en producción
> - Siempre validar **entradas nulas o vacías** en métodos públicos
