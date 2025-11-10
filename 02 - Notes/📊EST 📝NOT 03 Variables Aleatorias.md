---
tags:
  - 📊EST
  - 📝NOT
cssclasses:
  - center-titles
---

# [[📊EST 🏫MPR 02 Probabilidad.pdf|Unidad 3: Variables Aleatorias]]

## 1. Introducción a Variables Aleatorias

> [!info] ¿Qué es una variable aleatoria?
> Una **variable aleatoria** es una función que asigna un valor numérico a cada resultado de un experimento aleatorio. Los **modelos teóricos** permiten calcular probabilidades de manera más simple mediante fórmulas y propiedades matemáticas.

> [!quote] Definición formal
> Una variable aleatoria $X$ es una función $X: S \to \mathbb{R}$ que asocia un número real a cada elemento del espacio muestral $S$.

> [!question] Pregunta clave sobre definiciones
> **¿Qué expresiones son correctas para una V.A.D.?**
> - ✅ $F(x) = P(X \leq x)$ (Función de Distribución Acumulada - CDF)
> - ✅ $f(x) = P(X = x)$ (Función de Probabilidad - PMF)

---

## 2. Función de Probabilidad para Variables Aleatorias Discretas

> [!info] Función de probabilidad $p(x)$
> Para una variable aleatoria discreta $X$, la **función de probabilidad** $p(x)$ se define como:
> 
> $$p(x) = P(X = x)$$
> 
> y debe cumplir con:
> 1. $p(x) \geq 0$ para todo $x$
> 2. $\sum p(x) = 1$

| $x$ | 0 | 1 | 2 | 3 |
|-----|---|---|---|---|
| $p(x)$ | 0.125 | 0.375 | 0.375 | 0.125 |

> [!warning] Propiedades importantes de f(x) y F(x)
> **¿Qué puede tomar valores negativos?**
> - ❌ $f(x)$ NO puede ser negativa (es probabilidad)
> - ❌ $F(x)$ NO puede ser negativa (probabilidad acumulada)
> - ✅ $E(X)$ SÍ puede ser negativo (si X toma valores negativos)
> - ❌ $Var(X)$ NO puede ser negativa (siempre $\geq 0$)

---

## 3. Función de Distribución Acumulada

> [!info] Definición
> Sea $X$ una variable aleatoria discreta. Se define la **función de distribución acumulada** $F(x)$ como:
> 
> $$F(x) = P(X \leq x)$$

| $x$ | 0 | 1 | 2 | 3 |
|-----|---|---|---|---|
| $F(x)$ | 0.125 | 0.5 | 0.875 | 1 |

---

## 4. Valor Esperado y Varianza

### 4.1 Valor Esperado

> [!info] Definición
> Sea $X$ una v.a.d., se define el **valor esperado** como:
> 
> $$E(X) = \mu_x = \sum x \cdot p(x)$$

> [!info] Valor esperado de funciones
> Para cualquier función $g(X)$:
> 
> $$E[g(X)] = \sum g(x) \cdot p(x)$$

> [!success] Confirmación teórica
> **¿Es correcta la expresión $E(g(x)) = \sum g(x)f(x)$?**
> ✅ SÍ, es la definición del Valor Esperado de una función $g(X)$ de una variable aleatoria discreta $X$ (Ley del Estadístico Inconsciente).

### 4.2 Varianza

> [!info] Definición
> La **varianza** de $X$ se define como:
> 
> $$Var(X) = \sigma_x^2 = \sum (x - \mu)^2 p(x)$$

| $x$ | $p(x)$ | $(x - \mu)^2$ | $(x - \mu)^2 \cdot p(x)$ |
|-----|--------|---------------|--------------------------|
| 0 | 0.125 | 2.25 | 0.28125 |
| 1 | 0.375 | 0.25 | 0.09375 |
| 2 | 0.375 | 0.25 | 0.09375 |
| 3 | 0.125 | 2.25 | 0.28125 |

$$Var(X) = 0.75$$

> [!warning] Error común sobre varianza
> **¿Es correcto que $Var(aX+c) = a Var(X) + c$?**
> ❌ NO, la fórmula correcta es:
> $$Var(aX+c) = a^2 Var(X)$$
> La constante aditiva 'c' no afecta la dispersión, y el factor multiplicativo 'a' se eleva al cuadrado.

---

## 5. Propiedades del Valor Esperado y Varianza

> [!success] Propiedades clave

| Concepto | Fórmula |
|----------|---------|
| Esperanza de constante | $E(c) = c$ |
| Varianza de constante | $Var(c) = 0$ |
| Esperanza de constante × variable | $E(cX) = cE(X)$ |
| Varianza de constante × variable | $Var(cX) = c^2 Var(X)$ |
| Fórmula alternativa de varianza | $Var(X) = E(X^2) - [E(X)]^2$ |

> [!example] Aplicación práctica: Juego de monedas
> **Problema**: Lanzar 3 monedas. Ganar \$15 por 3 sellos o 3 caras, \$8 por 2 sellos, perder \$10 por 1 sello.
> 
> **Solución**:
> $$E(X) = (15) \cdot \frac{2}{8} + (8) \cdot \frac{3}{8} + (-10) \cdot \frac{3}{8} = 3$$
> ✅ Se espera ganar \$3 en promedio.

---

## 6. Principales Modelos Discretos

### 6.1 Distribución Binomial

> [!info] Características
> - $X \sim B(n, p)$
> - Cuenta el número de éxitos en $n$ intentos independientes
> - $P(X = x) = \binom{n}{x} p^x (1-p)^{n-x}$
> - $E(X) = np$
> - $Var(X) = np(1-p)$

> [!success] Características de un experimento binomial
> ✅ **Correctas**:
> - Son $n$ repeticiones o intentos idénticos
> - Se busca el número de éxitos en $n$ intentos
> - Cada intento solo puede resultar en éxito o fracaso
> - La probabilidad de éxito $p$ es constante
> - Los intentos son independientes

> [!example] Cálculo binomial
> **Problema**: 5% de piezas defectuosas, seleccionar 10 al azar.
> $$P(X=2) = \binom{10}{2} (0.05)^2 (0.95)^8 \approx 0.0746$$

### 6.2 Distribución Binomial Negativa

> [!info] Características
> - Cuenta el número de intentos hasta el $k$-ésimo éxito
> - $P(X = x) = \binom{x-1}{k-1} p^k (1-p)^{x-k}$
> - $E(X) = \frac{k}{p}$
> - $Var(X) = \frac{k(1-p)}{p^2}$

> [!example] Aplicación práctica
> **Problema**: 5% defectuosas, buscar 3 piezas defectuosas.
> $$P(X \geq 5) = 1 - [P(X=3) + P(X=4)] \approx 0.9995$$

### 6.3 Distribución Geométrica

> [!tip] Caso especial
> Es un caso particular de la binomial negativa cuando $k = 1$:
> 
> - $P(X = x) = p(1-p)^{x-1}$
> - $E(X) = \frac{1}{p}$
> - $Var(X) = \frac{1-p}{p^2}$

> [!question] Relación entre distribuciones
> **¿La binomial es caso particular de la geométrica cuando intentos=1?**
> ❌ NO. La binomial con n=1 es Bernoulli, no geométrica.

> [!example] Identificación de distribución
> **Problema**: 20% defectuosos, probabilidad de primer defecto en primera inspección.
> ✅ **Distribución Geométrica** - se busca el primer éxito.

### 6.4 Distribución de Poisson

> [!info] Características
> - $X \sim P(\lambda)$
> - Modela eventos en unidad de tiempo/área/volumen
> - $P(X = x) = \frac{\lambda^x e^{-\lambda}}{x!}$
> - $E(X) = Var(X) = \lambda$

### 6.5 Distribución Hipergeométrica

> [!info] Identificación de distribución
> **Problema**: Curso de 40 personas, seleccionar 8 SIN reemplazo, probabilidad de que 5 sean de ingeniería mecánica.
> ✅ **Distribución Hipergeométrica** - muestreo sin reemplazo de población finita.

---

## 7. Resumen de Fórmulas

> [!note] Resumen de distribuciones discretas

| Distribución | Notación | Parámetros | $P(X = x)$ | $E(X)$ | $Var(X)$ |
|-------------|----------|------------|------------|--------|----------|
| Binomial | $B(n, p)$ | $n, p$ | $\binom{n}{x}p^x(1-p)^{n-x}$ | $np$ | $np(1-p)$ |
| Binomial Negativa | $BN(k, p)$ | $k, p$ | $\binom{x-1}{k-1}p^k(1-p)^{x-k}$ | $\frac{k}{p}$ | $\frac{k(1-p)}{p^2}$ |
| Geométrica | $Geo(p)$ | $p$ | $p(1-p)^{x-1}$ | $\frac{1}{p}$ | $\frac{1-p}{p^2}$ |
| Poisson | $P(\lambda)$ | $\lambda$ | $\frac{\lambda^x e^{-\lambda}}{x!}$ | $\lambda$ | $\lambda$ |

> [!success] Relación entre distribuciones
> 
> | Distribución | Descripción |
> |-------------|-------------|
> | Geométrica | Número de intentos hasta el primer éxito |
> | Binomial Negativa | Número de intentos hasta el k-ésimo éxito |
> | Binomial | Número de éxitos en n intentos |
> | Poisson | Número de eventos por unidad (tiempo/espacio) |

> [!warning] Importante
> Recuerda que todas estas distribuciones son para **variables aleatorias discretas** y cumplen con las propiedades básicas de las funciones de probabilidad.

