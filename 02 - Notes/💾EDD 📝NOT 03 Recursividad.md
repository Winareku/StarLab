---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Recursividad

## 1. Introducción a la Recursividad

> [!info] Definición
> La **recursividad** es una técnica de programación donde una función se llama a sí misma para resolver un problema. Un proceso recursivo debe tener al menos un **caso base** que detenga las llamadas recursivas.

### 1.1 Conceptos Fundamentales

| **Concepto**       | **Descripción**                                       | **Importancia**                    |
| ------------------ | ----------------------------------------------------- | ---------------------------------- |
| **Caso Base**      | Condición que detiene la recursión                    | Evita llamadas infinitas           |
| **Caso Recursivo** | Llamada a la misma función con parámetros modificados | Divide el problema en subproblemas |
| **Stack (Pila)**   | Memoria donde se almacenan las llamadas               | Límite: StackOverflowError         |

> [!danger] ¡Precaución!
> Sin caso base, la recursión causa **StackOverflowError**:
> ```java
> // EJEMPLO PELIGROSO - RECURSIÓN INFINITA
> static void recursiveMethod() {
>     System.out.println("Hello");
>     recursiveMethod(); // ¡LLAMADA INFINITA!
> }
> ```

---

## 2. Componentes de la Recursividad

### 2.1 Estructura Básica

> [!bug] Código - Estructura General
```java
public static tipoRetorno metodoRecursivo(parametros) {
    // 1. CASO BASE - Condición de parada
    if (condicionDeParada) {
        return valorBase;
    }
    
    // 2. CASO RECURSIVO - Llamada recursiva
    return operacion(metodoRecursivo(parametrosModificados));
}
```

### 2.2 Ejemplo con Condición de Salida

> [!success] Ejemplo Controlado
```java
public class RecursionExample {
    static int count = 0;
    
    static void recursiveMethod() {
        count++;
        if (count <= 5) {  // CASO BASE
            System.out.println("Hello " + count);
            recursiveMethod();  // CASO RECURSIVO
        }
    }
    
    public static void main(String[] args) {
        recursiveMethod();
    }
}
```

**Salida:**
```
Hello 1
Hello 2
Hello 3
Hello 4
Hello 5
```

---

## 3. Ejemplos Clásicos de Recursividad

### 3.1 Factorial

> [!info] Definición Matemática
> $$
> factorial(n) = \begin{cases} 
> 1 & \text{si } n = 0 \\
> n \times factorial(n-1) & \text{si } n > 0 
> \end{cases}
> $$

> [!bug] Código - Factorial Recursivo
```java
public static int factorial(int n) {
    if (n == 0) {           // CASO BASE
        return 1;
    } else {                // CASO RECURSIVO
        return n * factorial(n - 1);
    }
}
```

**Ejemplo con factorial(5):**
```
factorial(5) = 5 * factorial(4)
             = 5 * 4 * factorial(3)
             = 5 * 4 * 3 * factorial(2)
             = 5 * 4 * 3 * 2 * factorial(1)
             = 5 * 4 * 3 * 2 * 1 * factorial(0)
             = 5 * 4 * 3 * 2 * 1 * 1 = 120
```

### 3.2 Sucesión de Fibonacci

> [!info] Definición
> La serie comienza con 0 y 1, y cada término siguiente es la suma de los dos anteriores:
> $$
> fibonacci(n) = \begin{cases}
> 0 & \text{si } n = 1 \\
> 1 & \text{si } n = 2 \\
> fibonacci(n-1) + fibonacci(n-2) & \text{si } n > 2
> \end{cases}
> $$

> [!bug] Código - Fibonacci Recursivo
```java
public static int fibonacci(int n) {
    if (n == 1) {                   // CASO BASE 1
        return 0;
    } else if (n == 2) {            // CASO BASE 2
        return 1;
    } else {                        // CASO RECURSIVO
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

**Primeros 14 términos:**

| n          | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  | 12  | 13  | 14  |
| ---------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| **fib(n)** | 0   | 1   | 1   | 2   | 3   | 5   | 8   | 13  | 21  | 34  | 55  | 89  | 144 | 233 |

---

## 4. Ejercicios Resueltos de Recursividad

### 4.1 Suma de Dígitos

> [!bug] Código - Suma de Dígitos
```java
public static int sumarDigitos(int n) {
    if (n < 10) {                   // CASO BASE
        return n;
    }
    return (n % 10) + sumarDigitos(n / 10);  // CASO RECURSIVO
}
```

**Ejemplo con 135:**
```
sumarDigitos(135) = 5 + sumarDigitos(13)
                  = 5 + 3 + sumarDigitos(1)
                  = 5 + 3 + 1 = 9
```

### 4.2 Verificar Palíndromo

> [!bug] Código - Palíndromo Recursivo
```java
public static boolean esPalindromo(String s) {
    if (s.length() <= 1) {          // CASO BASE
        return true;
    }
    if (s.charAt(0) != s.charAt(s.length() - 1)) {
        return false;               // NO es palíndromo
    }
    return esPalindromo(s.substring(1, s.length() - 1));  // CASO RECURSIVO
}
```

**Ejemplos:**
- `"ana"` → `'a' == 'a'` → `esPalindromo("n")` → `true`
- `"perro"` → `'p' != 'o'` → `false`

### 4.3 Potencia de un Número

> [!bug] Código - Potencia Recursiva
```java
public static int potencia(int base, int exponente) {
    if (exponente == 0) {           // CASO BASE
        return 1;
    }
    return base * potencia(base, exponente - 1);  // CASO RECURSIVO
}
```

**Ejemplo con 2³:**
```
potencia(2, 3) = 2 * potencia(2, 2)
               = 2 * 2 * potencia(2, 1)
               = 2 * 2 * 2 * potencia(2, 0)
               = 2 * 2 * 2 * 1 = 8
```

### 4.4 Invertir String

> [!bug] Código - Invertir String Recursivo
```java
public static String revertir(String s) {
    if (s.length() <= 1) {          // CASO BASE
        return s;
    }
    return s.charAt(s.length() - 1) + revertir(s.substring(0, s.length() - 1));
}
```

**Ejemplo con "Hola":**
```
revertir("Hola") = 'a' + revertir("Hol")
                = 'a' + 'l' + revertir("Ho")
                = 'a' + 'l' + 'o' + revertir("H")
                = 'a' + 'l' + 'o' + 'H' = "aloH"
```

---

## 5. Recursión con Múltiples Llamadas

### 5.1 Ejemplo Complejo: Impresión con Retorno

> [!bug] Código - Múltiples Llamadas Recursivas
```java
public static void printFun(int test) {
    if (test < 1) return;           // CASO BASE
    
    System.out.print(test + " ");   // Antes de llamada recursiva
    printFun(test - 1);             // LLAMADA RECURSIVA
    System.out.print(test + " ");   // Después de llamada recursiva
}
```

**Ejecución con test = 3:**
```
printFun(3)
├── Imprime: 3
├── printFun(2)
│   ├── Imprime: 2
│   ├── printFun(1)
│   │   ├── Imprime: 1
│   │   ├── printFun(0) → RETURN
│   │   └── Imprime: 1
│   └── Imprime: 2
└── Imprime: 3

SALIDA: 3 2 1 1 2 3
```

---

## 6. Aplicaciones en la Naturaleza

> [!example] Fibonacci en la Naturaleza
> La sucesión de Fibonacci aparece en:
> - **Espirales** en girasoles y caracoles
> - **Ramas de árboles** y patrones de crecimiento
> - **Distribución de semillas** en flores
> - **Proporciones corporales** en animales

**Ejemplo de conejos (problema original):**

| Mes | Parejas | Explicación                           |
| --- | ------- | ------------------------------------- |
| 1   | 1       | Nace pareja A                         |
| 2   | 1       | Pareja A se cruza                     |
| 3   | 2       | Pareja A da a luz a B                 |
| 4   | 3       | Pareja A da a luz a C, B cumple 1 mes |
| 5   | 5       | A y B dan a luz, C cumple 1 mes       |
| 6   | 8       | A, B, C dan a luz, D y E cumplen 1 mes |

---

## 7. Consideraciones y Buenas Prácticas

### 7.1 Ventajas y Desventajas

| **Ventajas**                               | **Desventajas**                 |
| ------------------------------------------ | ------------------------------- |
| Código más legible y elegante              | Mayor consumo de memoria (pila) |
| Solución natural para problemas recursivos | Posible StackOverflowError      |
| Fácil de implementar para problemas dividibles | Menor eficiencia que iterativos |

### 7.2 Cuándo Usar Recursividad

> [!success] Casos Ideales
> - Problemas que se pueden dividir en subproblemas similares
> - Estructuras de datos recursivas (árboles, grafos)
> - Algoritmos de divide y vencerás
> - Problemas con definición matemática recursiva

> [!warning] Casos a Evitar
> - Problemas con profundidad recursiva muy grande
> - Sistemas con memoria limitada
> - Cuando existen soluciones iterativas más eficientes

### 7.3 Optimizaciones

> [!tip] Mejores Prácticas
> - **Siempre definir caso base** claro y alcanzable
> - **Memorización**: almacenar resultados intermedios
> - **Recursión de cola**: cuando la llamada recursiva es la última operación
> - **Considerar iteración** para problemas de gran profundidad

---

## 8. Ejercicios Propuestos

> [!question] Para Practicar
> 1. **Contar dígitos**: Método recursivo que cuente los dígitos de un número
> 2. **MCD**: Algoritmo de Euclides recursivo para máximo común divisor
> 3. **Torres de Hanoi**: Resolver el problema clásico recursivamente
> 4. **Búsqueda binaria**: Implementar versión recursiva
> 5. **Suma de array**: Calcular suma de elementos recursivamente

> [!quote] Reflexión Final
> "Para entender la recursión, primero debes entender la recursión."
> — Anónimo

> [!info] Importancia en el Curso
> La recursión será un tema **fundamental** en el segundo parcial y para estructuras de datos avanzadas como árboles y grafos.
