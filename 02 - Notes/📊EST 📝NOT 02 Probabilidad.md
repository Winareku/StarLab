---
tags:
  - 📊EST
  - 📝NOT
cssclasses:
  - center-titles
---

# [[📊EST 🏫MPR 02 Probabilidad.pdf|Unidad 2: Probabilidad]]

---

## 1. Introducción a la Probabilidad

> [!info] ¿Qué es la probabilidad?
> Es una medida que cuantifica la posibilidad de que ocurra un evento. Se expresa entre 0 y 1, donde 0 es imposibilidad y 1 es certeza absoluta.

> [!example] Aplicaciones de la probabilidad
> - Predicción de eventos futuros basados en datos históricos.
> - Evaluación de riesgos en finanzas, salud e ingeniería.
> - Toma de decisiones en situaciones de incertidumbre.

---

## 2. Experimentos Aleatorios y Espacio Muestral

### 2.1 Tipos de Experimentos

| **Experimento Determinístico** | **Experimento Aleatorio** |
|-------------------------------|----------------------------|
| Resultado conocido de antemano | Resultado impredecible |
| Ej: Calentar agua a 100°C | Ej: Lanzar un dado |
> [!tip] Elementos Clave
> 
> * Espacio Muestral ($S$ / $\omega$): Conjunto de todos los resultados posibles de un experimento aleatorio.
> 
> * Evento (A, B, etc.): Cualquier subconjunto del espacio muestral.
### 2.2 Espacio Muestral

> [!quote] Definición
> Conjunto de todos los resultados posibles de un experimento aleatorio, denotado por $S$ o $\Omega$.

| **Tipo** | **Ejemplo** |
|----------|-------------|
| Discreto y Finito | $$ S = \{1, 2, 3, 4, 5, 6\} $$ (lanzar un dado) |
| Discreto e Infinito | $$ S = \{1, 2, 3, \ldots\} $$ (intentos hasta obtener un 6) |
| Continuo | $$ S = \{t / t > 0\} $$ (tiempo de crecimiento bacteriano) |

---

## 3. Eventos y Probabilidad Clásica

### 3.1 Eventos

> [!info] Definición
> Cualquier subconjunto del espacio muestral. Se denotan con letras mayúsculas: $A, B, C, \ldots$

### 3.2 Probabilidad Clásica (Laplace)

$$
P(A) = \frac{n(A)}{n(S)} = \frac{\text{Número de casos favorables}}{\text{Número de casos posibles}}
$$
> [!info] Definición
> Se denomina evento elemental al evento que contiene un solo elemento.

> [!warning] Condición
> Solo aplica cuando los eventos elementales son **equiprobables**.

> [!example] Lanzamiento de dos dados
> - Espacio muestral: 36 resultados posibles.
> - Evento A: suma sea 6 → $A = \{(1,5), (2,4), (3,3), (4,2), (5,1)\}$
> - $P(A) = \frac{5}{36} \approx 13.89\%$

---

## 4. Métodos de Conteo

### 4.1 Regla de Multiplicación
> [!info] Definición
> La cantidad de elementos de un espacio muestral se define por la ocurrencia de varios eventos será el resultado de multiplicar la cantidad de elementos de cada uno de los eventos de manera secuencial.
> $$
> n(S) = n_1 \times n_2 \times \ldots \times n_k
> $$

### 4.2 Permutaciones

> [!info] Concepto Clave
> - Una permutación de $n$ elementos tomados de un conjunto de $N$ elementos es una disposición u ordenación de esos $n$ elementos, donde el orden en que se colocan sí importa.
> - En las permutaciones, el **orden** de los elementos seleccionados es crucial. Si cambiamos el orden, obtenemos una permutación diferente.

> [!success] Permutaciones sin repetición
> Se utilizan cuando se seleccionan $n$ elementos distintos de un total de $N$ elementos, y el orden en que se eligen es importante.
> $$
> P(N, n) = \frac{N!}{(N - n)!}
> $$
> Donde:
> *   $N$ es el número total de elementos disponibles.
> *   $n$ es el número de elementos que se van a ordenar o seleccionar.

> [!example] Elección de una directiva
> En un grupo de $N = 40$ estudiantes, se deben elegir un presidente, un vicepresidente y un tesorero. Dado que cada cargo es distinto, el orden en que se eligen las personas sí importa (no es lo mismo ser presidente que vicepresidente).
>
> Aquí, $N = 40$ (total de estudiantes) y $n = 3$ (cargos a elegir).
>
> Aplicando la fórmula:
> $$
> P(40, 3) = \frac{40!}{(40 - 3)!} = \frac{40 \times 39 \times 38 \times 37!}{37!} = 40 \times 39 \times 38 = 59,280
> $$
> Hay 59,280 maneras diferentes de elegir la directiva.

> [!bug] Permutaciones con elementos repetidos
> Se utilizan cuando se desea ordenar un conjunto de $N$ elementos, donde algunos de ellos son idénticos.
> $$
> P_{rep}(N; n_1, n_2, \ldots, n_k) = \frac{N!}{n_1! \cdot n_2! \cdot \ldots \cdot n_k!}
> $$
> Donde:
> *   $N$ es el número total de elementos a ordenar.
> *   $n_1, n_2, \ldots, n_k$ son las cantidades de cada tipo de elemento repetido, tal que $n_1 + n_2 + \ldots + n_k = N$.

> [!example] Formación de palabras con letras repetidas
> ¿Cuántas palabras distintas (con o sin sentido) se pueden formar con las letras de la palabra "MATEMATICAS"?
>
> Primero, contamos el total de letras ($N$) y la repetición de cada una:
> *   $N = 11$ letras en total.
> *   M: 2 veces ($n_1 = 2$)
> *   A: 3 veces ($n_2 = 3$)
> *   T: 2 veces ($n_3 = 2$)
> *   E: 1 vez
> *   I: 1 vez
> *   C: 1 vez
> *   S: 1 vez
>
> Aplicando la fórmula:
> $$
> P_{rep}(11; 2, 3, 2) = \frac{11!}{2! \cdot 3! \cdot 2!} = \frac{39,916,800}{2 \cdot 6 \cdot 2} = \frac{39,916,800}{24} = 1,663,200
> $$
> Se pueden formar 1,663,200 palabras distintas.

### 4.3 Combinaciones

> [!info] Concepto Clave
> - Una combinación de $n$ elementos tomados de un conjunto de $N$ elementos es un subconjunto de esos $N$ elementos, donde solo importa qué elementos están incluidos, y no el orden en que se seleccionaron.
> - En las combinaciones, el **orden** de los elementos seleccionados **no importa**. Un conjunto de elementos es el mismo sin importar el orden en que se presenten.

> [!success] Combinaciones sin repetición
> Se utilizan cuando se seleccionan $n$ elementos distintos de un total de $N$ elementos, y el orden en que se eligen NO es importante.
> $$
> C(N, n) = \binom{N}{n} = \frac{N!}{(N - n)! \cdot n!}
> $$
> Donde:
> *   $N$ es el número total de elementos disponibles.
> *   $n$ es el número de elementos que se van a seleccionar para formar el subconjunto.

> [!example] Formación de un comité
> En un grupo de $N = 40$ estudiantes, se desea formar un comité de $n = 3$ miembros. En un comité, todos los miembros tienen el mismo "rango", por lo que el orden en que son elegidos no importa.
>
> Aquí, $N = 40$ (total de estudiantes) y $n = 3$ (miembros a elegir para el comité).
>
> Aplicando la fórmula:
> $$ C(40, 3) = \binom{40}{3} = \frac{40!}{(40 - 3)! \cdot 3!} = \frac{40!}{37! \cdot 3!} = \frac{40 \times 39 \times 38}{3 \times 2 \times 1} = 40 \times 13 \times 19 = 9,880 $$

> [!tip] Regla práctica
> - **Usa Combinaciones** cuando: "solo necesito un grupo" (todos los miembros son equivalentes)
> - **Usa Permutaciones** cuando: "necesito asignar roles específicos" (cada posición es única)

---

## 5. Axiomas de Probabilidad

> [!info] Axiomas fundamentales
> 1. $P(A) \geq 0$
> 2. $P(S) = 1$
> 3. Si $A \cap B = \emptyset$, entonces $P(A \cup B) = P(A) + P(B)$

> [!success] Propiedades derivadas
> - $P(A^c) = 1 - P(A)$
> - $P(\emptyset) = 0$
> - $P(A \cup B) = P(A) + P(B) - P(A \cap B)$

---

## 6. Probabilidad Condicional e Independencia

### 6.1 Probabilidad Condicional
> [!quote] Probabilidad Condicional
> 
> La probabilidad de un evento A dado que el evento B ya ha ocurrido.
> $$
> P(A|B) = \frac{P(A \cap B)}{P(B)}, \quad P(B) \neq 0
> $$ 



### 6.2 Eventos Independientes
> [!info] Eventos Independientes
> Dos eventos A y B son independientes si la ocurrencia de uno no influye en la probabilidad del otro.
> $$
> P(A \cap B) = P(A) \cdot P(B)
> $$

> [!example] Enfermedades A y B
> - $P(A) = 0.10, P(B) = 0.06, P(A \cap B) = 0.02$
> - $P(A|B) = \frac{0.02}{0.06} = 0.333$

---

## 7. Probabilidad Total y Teorema de Bayes

### 7.1 Probabilidad Total
> [!quote] Fórmula de la Probabilidad Total
> Sean B1​,B2​,…,Bk​ una partición de Ω. La probabilidad de un evento A es:
> $$
> P(A) = \sum_{i=1}^k P(B_i) \cdot P(A|B_i)
> $$

### 7.2 Teorema de Bayes
> [!quote] Fórmula del Teorema de Bayes
> Para cualquier evento de la partición Br​:
> $$
> P(B_r|A) = \frac{P(B_r) \cdot P(A|B_r)}{\sum_{i=1}^k P(B_i) \cdot P(A|B_i)}
> $$

> [!tip] Interpretación
> * $P(B_r​)$: Probabilidad a priori (probabilidad inicial de $B_r$​).
> * $P(A|B_r​)$: Verosimilitud (probabilidad de la evidencia $A$ dado $B_r$​​).
> * $P(B_r​|A)$: Probabilidad a posteriori (probabilidad actualizada de $B_r$​​ después de ver $A$).

> [!example] Máquinas y defectos
> - Máquinas: A (45%), B (30%), C (25%)
> - Defectos: A (3%), B (4%), C (5%)
> - $P(\text{defectuoso}) = 0.45 \times 0.03 + 0.30 \times 0.04 + 0.25 \times 0.05 = 0.038$
> - $P(B|\text{defectuoso}) = \frac{0.30 \times 0.04}{0.038} \approx 0.316$

---

## 8. Ejemplo de Aplicación: Prueba Médica

> [!example] Enfermedad pulmonar
> - Prevalencia: 1%
> - Sensibilidad: 95%
> - Especificidad: 90%
> - Si la prueba es positiva:
> $$
> P(\text{enfermo}|\text{positivo}) = \frac{0.01 \times 0.95}{0.01 \times 0.95 + 0.99 \times 0.10} \approx 0.087
> $$
> - Aunque la prueba sea positiva, la probabilidad real de tener la enfermedad es solo del 8.7%.

---