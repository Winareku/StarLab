---
tags:
- 📊EST
- 📝NOT
---

# Probabilidad: Teoría y Aplicaciones
by Deepseek

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

### 2.2 Espacio Muestral

> [!quote] Definición
> Conjunto de todos los resultados posibles de un experimento aleatorio, denotado por \( S \) o \( \Omega \).

| **Tipo** | **Ejemplo** |
|----------|-------------|
| Discreto y Finito | \( S = \{1, 2, 3, 4, 5, 6\} \) (lanzar un dado) |
| Discreto e Infinito | \( S = \{1, 2, 3, \ldots\} \) (intentos hasta obtener un 6) |
| Continuo | \( S = \{t / t > 0\} \) (tiempo de crecimiento bacteriano) |

---

## 3. Eventos y Probabilidad Clásica

### 3.1 Eventos

> [!info] Definición
> Cualquier subconjunto del espacio muestral. Se denotan con letras mayúsculas: \( A, B, C, \ldots \)

### 3.2 Probabilidad Clásica (Laplace)

\[
P(A) = \frac{n(A)}{n(S)} = \frac{\text{Número de casos favorables}}{\text{Número de casos posibles}}
\]

> [!warning] Condición
> Solo aplica cuando los eventos elementales son **equiprobables**.

> [!example] Lanzamiento de dos dados
> - Espacio muestral: 36 resultados posibles.
> - Evento A: suma sea 6 → \( A = \{(1,5), (2,4), (3,3), (4,2), (5,1)\} \)
> - \( P(A) = \frac{5}{36} \approx 13.89\% \)

---

## 4. Métodos de Conteo

### 4.1 Regla de Multiplicación

\[
n(S) = n_1 \times n_2 \times \ldots \times n_k
\]

### 4.2 Permutaciones

- **Sin repetición**: 
  \[
  nP_r = \frac{n!}{(n - r)!}
  \]
- **Con repetición**:
  \[
  \frac{n!}{n_1! \cdot n_2! \cdot \ldots \cdot n_k!}
  \]

> [!example] Elección de directiva
> - 40 estudiantes, elegir presidente, vicepresidente y tesorero:
> - \( 40P3 = 40 \times 39 \times 38 = 59,280 \)

### 4.3 Combinaciones

\[
nC_r = \binom{n}{r} = \frac{n!}{(n - r)! \cdot r!}
\]

> [!example] Comités sin orden
> - De 40 estudiantes, elegir 3 sin cargos:
> - \( \binom{40}{3} = 9,880 \)

---

## 5. Axiomas de Probabilidad

> [!info] Axiomas fundamentales
> 1. \( P(A) \geq 0 \)
> 2. \( P(S) = 1 \)
> 3. Si \( A \cap B = \emptyset \), entonces \( P(A \cup B) = P(A) + P(B) \)

> [!success] Propiedades derivadas
> - \( P(A^c) = 1 - P(A) \)
> - \( P(\emptyset) = 0 \)
> - \( P(A \cup B) = P(A) + P(B) - P(A \cap B) \)

---

## 6. Probabilidad Condicional e Independencia

### 6.1 Probabilidad Condicional

\[
P(A|B) = \frac{P(A \cap B)}{P(B)}, \quad P(B) \neq 0
\]

### 6.2 Eventos Independientes

\[
P(A \cap B) = P(A) \cdot P(B)
\]

> [!example] Enfermedades A y B
> - \( P(A) = 0.10, P(B) = 0.06, P(A \cap B) = 0.02 \)
> - \( P(A|B) = \frac{0.02}{0.06} = 0.333 \)

---

## 7. Probabilidad Total y Teorema de Bayes

### 7.1 Probabilidad Total

\[
P(A) = \sum_{i=1}^k P(B_i) \cdot P(A|B_i)
\]

### 7.2 Teorema de Bayes

\[
P(B_r|A) = \frac{P(B_r) \cdot P(A|B_r)}{\sum_{i=1}^k P(B_i) \cdot P(A|B_i)}
\]

> [!example] Máquinas y defectos
> - Máquinas: A (45%), B (30%), C (25%)
> - Defectos: A (3%), B (4%), C (5%)
> - \( P(\text{defectuoso}) = 0.45 \times 0.03 + 0.30 \times 0.04 + 0.25 \times 0.05 = 0.038 \)
> - \( P(B|\text{defectuoso}) = \frac{0.30 \times 0.04}{0.038} \approx 0.316 \)

---

## 8. Ejemplo de Aplicación: Prueba Médica

> [!example] Enfermedad pulmonar
> - Prevalencia: 1%
> - Sensibilidad: 95%
> - Especificidad: 90%
> - Si la prueba es positiva:
> \[
> P(\text{enfermo}|\text{positivo}) = \frac{0.01 \times 0.95}{0.01 \times 0.95 + 0.99 \times 0.10} \approx 0.087
> \]
> - Aunque la prueba sea positiva, la probabilidad real de tener la enfermedad es solo del 8.7%.

---