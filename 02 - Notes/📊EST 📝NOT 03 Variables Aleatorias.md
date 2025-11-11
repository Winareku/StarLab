---
tags:
  - 📊EST
  - 📝NOT
cssclasses:
  - center-titles
---

# [[📊EST 🏫MPR 03 Variables Aleatorias.pdf|Unidad 3: Variables Aleatorias]]

## 1. Introducción a Variables Aleatorias

> [!info] ¿Qué es una variable aleatoria?
> Una **variable aleatoria** es una función que asigna un valor numérico a cada resultado de un experimento aleatorio. Los **modelos teóricos** permiten calcular probabilidades de manera más simple mediante fórmulas y propiedades matemáticas.

> [!quote] Definición formal
> Una variable aleatoria $X$ es una función $X: S \to \mathbb{R}$ que asocia un número real a cada elemento del espacio muestral $S$.

> [!example] Ejemplo: Lanzamiento de 2 monedas
> $\Omega = \{cc, cs, sc, ss\}$
> Evento: Obtener cara
> $X$: Número de caras obtenidas
> $X(cc) = 2$, $X(cs) = 1$, $X(sc) = 1$, $X(ss) = 0$

> [!example] Video
> ![[Variables aleatorias discretas y continuas ｜ Ejemplos.webm]]

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

| $x$    | 0     | 1     | 2     | 3     |
| ------ | ----- | ----- | ----- | ----- |
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
> $$F(x) = P(X \leq x) = \sum_{t \leq x} f(t)$$

| $x$    | 0     | 1   | 2     | 3   |
| ------ | ----- | --- | ----- | --- |
| $F(x)$ | 0.125 | 0.5 | 0.875 | 1   |

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
| --- | ------ | ------------- | ------------------------ |
| 0   | 0.125  | 2.25          | 0.28125                  |
| 1   | 0.375  | 0.25          | 0.09375                  |
| 2   | 0.375  | 0.25          | 0.09375                  |
| 3   | 0.125  | 2.25          | 0.28125                  |

$$Var(X) = 0.75$$

> [!warning] Error común sobre varianza
> **¿Es correcto que $Var(aX+c) = a Var(X) + c$?**
> ❌ NO, la fórmula correcta es:
> $$Var(aX+c) = a^2 Var(X)$$
> La constante aditiva 'c' no afecta la dispersión, y el factor multiplicativo 'a' se eleva al cuadrado.

---

## 5. Propiedades del Valor Esperado y Varianza

> [!success] Propiedades clave

| Concepto                          | Fórmula                      |
| --------------------------------- | ---------------------------- |
| Esperanza de constante            | $E(c) = c$                   |
| Varianza de constante             | $Var(c) = 0$                 |
| Esperanza de constante × variable | $E(cX) = cE(X)$              |
| Varianza de constante × variable  | $Var(cX) = c^2 Var(X)$       |
| Fórmula alternativa de varianza   | $Var(X) = E(X^2) - [E(X)]^2$ |

> [!info] Propiedades adicionales de Esperanza
> - Si $X \geq 0$ entonces $E(X) \geq 0$
> - $E(X + Y) = E(X) + E(Y)$

> [!info] Propiedades adicionales de Varianza
> - $V(X) \geq 0$
> - $V(X + c) = V(X)$
> - $V(X + Y) \neq V(X) + V(Y)$ (excepto cuando son independientes)

> [!example] Aplicación práctica: Juego de monedas
> **Problema**: Lanzar 3 monedas. Ganar \$15 por 3 sellos o 3 caras, \$8 por 2 sellos, perder \$10 por 1 sello.
> 
> **Solución**:
> $$E(X) = (15) \cdot \frac{2}{8} + (8) \cdot \frac{3}{8} + (-10) \cdot \frac{3}{8} = 3$$
> ✅ Se espera ganar \$3 en promedio.

---

## 6. Principales Modelos Discretos

### 6.1 Distribución Binomial
> [!success] Descripción  
> Este modelo se usa cuando queremos contar el número de éxitos en una cantidad fija de intentos independientes, donde cada intento tiene la misma probabilidad de éxito. Es como lanzar una moneda varias veces y contar cuántas veces sale cara.

> [!info] Características
> - $X \sim B(n, p)$
> - Cuenta el número de éxitos en $n$ intentos independientes
> - $P(X = x) = \binom{n}{x} p^x (1-p)^{n-x}$
> - $E(X) = np$
> - $Var(X) = np(1-p)$

> [!example] Video
> ![[Distribución binomial ｜ Ejercicios resueltos ｜ Introducción.webm]]

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

> [!example] Ejemplo aplicado
> **Problema**: Probabilidad de que 7 personas de 10 se recuperen de una enfermedad si la probabilidad de recuperación es 0.40
> $$P(X=7) = \binom{10}{7} (0.40)^7 (0.60)^3$$

### 6.2 Distribución Binomial Negativa
> [!success] Descripción  
> Este modelo se usa cuando queremos saber cuántos intentos necesitamos para lograr un número específico de éxitos. Es como preguntar: "¿Cuántas veces debo lanzar un dado hasta que salga el número 6 por tercera vez?"

> [!info] Características
> - Cuenta el número de intentos hasta el $k$-ésimo éxito
> - $P(X = x) = \binom{x-1}{k-1} p^k (1-p)^{x-k}$
> - $E(X) = \frac{k}{p}$
> - $Var(X) = \frac{k(1-p)}{p^2}$

> [!example] Video
> ![[Probabilidad ｜ Distribución binomial negativa.mkv]]

> [!example] Aplicación práctica
> **Problema**: 5% defectuosas, buscar 3 piezas defectuosas.
> $$P(X \geq 5) = 1 - [P(X=3) + P(X=4)] \approx 0.9995$$

> [!example] Ejemplo aplicado
> **Problema**: Probabilidad de necesitar exactamente 10 intentos para lograr 3 éxitos con probabilidad de éxito 20%
> $$P(X=10) = \binom{9}{2} (0.20)^3 (0.80)^7$$

### 6.3 Distribución Geométrica
> [!success] Descripción  
> Este modelo es un caso especial de la binomial negativa y se usa cuando queremos saber cuántos intentos necesitamos para lograr el primer éxito. Es como preguntar: "¿Cuántas veces debo lanzar una moneda hasta que salga cara por primera vez?"

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

> [!example] Ejemplo aplicado
> **Problema**: 15% de piezas defectuosas
> a) Probabilidad de primera pieza defectuosa en quinta inspección:
> $$P(X=5) = 0.15 \times (0.85)^4$$
> b) Probabilidad de no encontrar defectuosas en 10 inspecciones:
> $$P(X > 10) = (0.85)^{10}$$

### 6.4 Distribución de Poisson
> [!success] Descripción  
> Este modelo se usa cuando queremos contar eventos que ocurren aleatoriamente en el tiempo o espacio, con una tasa constante conocida. Es ideal para situaciones donde contamos "cuántos eventos ocurren" en un período determinado.

> [!info] Características
> - $X \sim P(\lambda)$
> - Modela eventos en unidad de tiempo/área/volumen
> - $P(X = x) = \frac{\lambda^x e^{-\lambda}}{x!}$
> - $E(X) = Var(X) = \lambda$

> [!example] Video
> ![[Distribución de Poisson ｜ Ejercicios resueltos ｜ Intro.webm]]

> [!example] Ejemplo aplicado
> **Problema**: Promedio de 2 microorganismos patógenos por hora
> Probabilidad de observar hasta 3 microorganismos:
> $$P(X \leq 3) = \sum_{x=0}^{3} \frac{e^{-2} 2^x}{x!}$$

### 6.5 Distribución Hipergeométrica
> [!success] Descripción  
> Este modelo se usa cuando extraemos elementos sin reemplazo de una población finita. A diferencia de la binomial, la probabilidad cambia en cada extracción porque no hay reemplazo. Es como sacar cartas de una baraja: cada carta que sacamos afecta las probabilidades de las siguientes.

> [!info] Identificación de distribución
> **Problema**: Curso de 40 personas, seleccionar 8 SIN reemplazo, probabilidad de que 5 sean de ingeniería mecánica.
> ✅ **Distribución Hipergeométrica** - muestreo sin reemplazo de población finita.

> [!info] Características
> - Número de éxitos en muestra de $n$ elementos de población $N$ con $k$ elementos con característica de interés
> - $P(X = x) = \frac{\binom{k}{x}\binom{N-k}{n-x}}{\binom{N}{n}}$
> - $E(X) = \frac{nk}{N}$
> - $V(X) = \frac{N-n}{N-1} \cdot \frac{nk}{N}(1-\frac{k}{N})$

> [!example] Video
> ![[Probabilidad ｜ La distribución hipergeométrica.webm]]

> [!example] Ejemplo aplicado
> **Problema**: 1000 bacterias, 150 resistentes, muestra de 100
> Probabilidad de exactamente 10 resistentes:
> $$P(X=10) = \frac{\binom{150}{10}\binom{850}{90}}{\binom{1000}{100}}$$

---

## 7. Variables Aleatorias Continuas

### 7.1 Definición y Función de Densidad

> [!info] Definición
> Una variable aleatoria es continua cuando toma valores en un conjunto continuo (intervalo de números reales).

> [!info] Función de densidad $f(x)$
> Sea $X$ una v.a. continua, la función $f(x): \mathbb{R} \to \mathbb{R}$ es la función de densidad de $X$ si:
> 1. $f(x) \geq 0$
> 2. $\int_{-\infty}^{+\infty} f(x) dx = 1$
> 
> La probabilidad en un intervalo es:
> $$P(a < X < b) = \int_a^b f(x) dx$$

### 7.2 Función de Distribución Acumulada

> [!info] Definición
> $$F(x) = P(X \leq x) = \int_{-\infty}^{x} f(t) dt$$

> [!success] Propiedades
> - $f(x) = \frac{d}{dx}F(x)$
> - $F(x)$ es función creciente
> - $F(x)$ es función continua

### 7.3 Valor Esperado y Varianza

> [!info] Definiciones
> - $E(X) = \int_{-\infty}^{+\infty} x f(x) dx$
> - $Var(X) = \int_{-\infty}^{+\infty} (x - \mu)^2 f(x) dx$
> - $E(g(X)) = \int_{-\infty}^{+\infty} g(x) f(x) dx$

---

## 8. Principales Modelos Continuos

### 8.1 Distribución Uniforme

> [!info] Características
> - Probabilidad uniforme en intervalo $[a, b]$
> - $f(x) = \begin{cases} \frac{1}{b-a} & a \leq x \leq b \\ 0 & \text{otro caso} \end{cases}$
> - $E(X) = \frac{a+b}{2}$
> - $Var(X) = \frac{(b-a)^2}{12}$

> [!example] Ejemplo aplicado
> **Problema**: Tiempo de metabolización entre 2 y 6 horas
> Probabilidad de metabolización entre 3 y 4 horas:
> $$P(3 < X < 4) = \frac{4-3}{6-2} = 0.25$$

### 8.2 Distribución Normal

> [!info] Características
> - $X \sim N(\mu, \sigma)$
> - $f(x) = \frac{1}{\sqrt{2\pi}\sigma} e^{-\frac{(x-\mu)^2}{2\sigma^2}}$
> - Curva simétrica en $\mu$
> - Área bajo la curva = 1

> [!example] Ejemplo aplicado
> **Problema**: Concentración de toxina ~ $N(10, 2)$ µg/ml
> Probabilidad entre 8 y 12 µg/ml:
> $$P(8 < X < 12) = P(-1 < Z < 1) \approx 0.6827$$

### 8.3 Distribución Normal Estándar

> [!info] Características
> - $Z \sim N(0, 1)$
> - $Z = \frac{X-\mu}{\sigma}$
> - $f(x) = \frac{1}{\sqrt{2\pi}} e^{-\frac{x^2}{2}}$
> - $E(X) = 0$, $Var(X) = 1$

### 8.4 Distribución t-Student

> [!info] Características
> - Distribución continua simétrica con colas más pesadas que la Normal
> - Parámetro: grados de libertad ($gl = v$)
> - $v \to \infty$, $t_v \to N(0,1)$
> - Centrada en 0

### 8.5 Distribución Exponencial

> [!info] Características
> - $f(x) = \begin{cases} \frac{1}{\beta} e^{-x/\beta} & x > 0 \\ 0 & \text{otro caso} \end{cases}$
> - $E(X) = \beta$, $Var(X) = \beta^2$
> - Alternativamente: $f(t) = \lambda e^{-\lambda t}$, $E(T) = \frac{1}{\lambda}$

> [!info] Relación con Poisson
> Si el número de eventos por unidad de tiempo tiene distribución Poisson($\lambda$), entonces el tiempo entre eventos tiene distribución Exponencial($\lambda$)

> [!example] Ejemplo aplicado
> **Problema**: Tasa de muerte de bacterias = 0.25 por hora
> Probabilidad de supervivencia menor a 3 horas:
> $$P(X < 3) = 1 - e^{-0.25 \times 3} \approx 0.5276$$

### 8.6 Distribución Gamma

> [!info] Función Gamma
> - $\Gamma(\alpha) = \int_{0}^{\infty} x^{\alpha-1} e^{-x} dx$, $\alpha > 0$
> - $\Gamma(\alpha) = (\alpha-1)\Gamma(\alpha-1)$
> - Si $n$ entero: $\Gamma(n) = (n-1)!$
> - $\Gamma(1/2) = \sqrt{\pi}$

> [!info] Distribución Gamma
> - $f(x) = \begin{cases} \frac{1}{\beta^\alpha \Gamma(\alpha)} x^{\alpha-1} e^{-x/\beta} & x > 0 \\ 0 & \text{otro caso} \end{cases}$
> - $E(X) = \alpha\beta$, $Var(X) = \alpha\beta^2$

### 8.7 Distribución Chi-cuadrado

> [!info] Características
> - Caso especial de Gamma con $\alpha = v/2$, $\beta = 2$
> - $E(X) = v$, $Var(X) = 2v$
> - $f(x) = \begin{cases} \frac{1}{2^{v/2}\Gamma(v/2)} x^{v/2-1} e^{-x/2} & x > 0 \\ 0 & \text{otro caso} \end{cases}$

### 8.8 Distribución Weibull

> [!info] Características
> - Usada en fallas de materiales y estudios de confiabilidad
> - $f(x) = \begin{cases} \alpha\beta x^{\beta-1} e^{-\alpha x^\beta} & x > 0 \\ 0 & \text{otro caso} \end{cases}$
> - Parámetros: $\alpha > 0$, $\beta > 0$

### 8.9 Distribución Beta

> [!info] Características
> - Variedad de formas según parámetros
> - $f(x) = \begin{cases} \frac{\Gamma(\alpha+\beta)}{\Gamma(\alpha)\Gamma(\beta)} x^{\alpha-1}(1-x)^{\beta-1} & 0 < x < 1 \\ 0 & \text{otro caso} \end{cases}$
> - Parámetros: $\alpha > 0$, $\beta > 0$

> [!example] Ejemplo aplicado
> **Problema**: Tasa de supervivencia de bacterias ~ Beta(2, 5)
> Probabilidad de tasa de supervivencia > 20%:
> $$P(X > 0.20) = \int_{0.20}^{1} f(x) dx$$

---

## 9. Distribuciones Conjuntas

### 9.1 Caso Discreto

> [!info] Definición
> $f(x,y)$ es distribución de probabilidad conjunta si:
> 1. $f(x,y) \geq 0$, $\forall x,y$
> 2. $\sum_x \sum_y f(x,y) = 1$
> 3. $P(X=x, Y=y) = f(x,y)$

### 9.2 Caso Continuo

> [!info] Definición
> $f(x,y)$ es distribución de densidad conjunta si:
> 1. $f(x,y) \geq 0$, $\forall x,y$
> 2. $\int_{-\infty}^{+\infty} \int_{-\infty}^{+\infty} f(x,y) dxdy = 1$
> 3. $P((X,Y) \in A) = \iint_A f(x,y) dxdy$

### 9.3 Distribuciones Marginales

> [!info] Definición
> - Discretas: $f_X(x) = \sum_y f(x,y)$, $f_Y(y) = \sum_x f(x,y)$
> - Continuas: $f_X(x) = \int_y f(x,y)dy$, $f_Y(y) = \int_x f(x,y)dx$

### 9.4 Independencia

> [!info] Definición
> $X$ e $Y$ son independientes si:
> $$f(x,y) = f_X(x) \cdot f_Y(y), \forall x,y$$

### 9.5 Esperanza Conjunta

> [!info] Definición
> - Discreta: $E(g(x,y)) = \sum_x \sum_y g(x,y)f(x,y)$
> - Continua: $E(g(x,y)) = \int_y \int_x g(x,y)f(x,y) dxdy$
> 
> En particular: $E(XY) = \sum_x \sum_y xy f(x,y)$

### 9.6 Covarianza

> [!info] Definición
> $$\text{Cov}(X,Y) = E[(X-\mu_X)(Y-\mu_Y)] = E(XY) - E(X)E(Y)$$

> [!success] Propiedades de Covarianza
> 1. $\text{Cov}(X, a) = 0$
> 2. $\text{Cov}(X, X) = Var(X)$
> 3. $\text{Cov}(X, Y) = \text{Cov}(Y, X)$
> 4. $\text{Cov}(aX, bY) = ab \cdot \text{Cov}(X, Y)$
> 5. $\text{Cov}(X+a, Y+b) = \text{Cov}(X, Y)$

### 9.7 Coeficiente de Correlación

> [!info] Definición
> $$\rho_{X,Y} = \frac{\text{Cov}(X,Y)}{\sigma_X \sigma_Y}$$

---

## 10. Resumen de Fórmulas

> [!note] Resumen de distribuciones discretas

| Distribución      | Notación     | Parámetros | $P(X = x)$                                          | $E(X)$         | $Var(X)$                                            |
| ----------------- | ------------ | ---------- | --------------------------------------------------- | -------------- | --------------------------------------------------- |
| Binomial          | $B(n, p)$    | $n, p$     | $\binom{n}{x}p^x(1-p)^{n-x}$                        | $np$           | $np(1-p)$                                           |
| Binomial Negativa | $BN(k, p)$   | $k, p$     | $\binom{x-1}{k-1}p^k(1-p)^{x-k}$                    | $\frac{k}{p}$  | $\frac{k(1-p)}{p^2}$                                |
| Geométrica        | $Geo(p)$     | $p$        | $p(1-p)^{x-1}$                                      | $\frac{1}{p}$  | $\frac{1-p}{p^2}$                                   |
| Poisson           | $P(\lambda)$ | $\lambda$  | $\frac{\lambda^x e^{-\lambda}}{x!}$                 | $\lambda$      | $\lambda$                                           |
| Hipergeométrica   | $H(N,n,k)$   | $N,n,k$    | $\frac{\binom{k}{x}\binom{N-k}{n-x}}{\binom{N}{n}}$ | $\frac{nk}{N}$ | $\frac{N-n}{N-1} \cdot \frac{nk}{N}(1-\frac{k}{N})$ |

> [!note] Resumen de distribuciones continuas

| Distribución | Notación                | Parámetros     | $f(x)$                                                                                | $E(X)$                        | $Var(X)$                                               |
| ------------ | ----------------------- | -------------- | ------------------------------------------------------------------------------------- | ----------------------------- | ------------------------------------------------------ |
| Uniforme     | $U(a,b)$                | $a,b$          | $\frac{1}{b-a}$                                                                       | $\frac{a+b}{2}$               | $\frac{(b-a)^2}{12}$                                   |
| Normal       | $N(\mu,\sigma)$         | $\mu,\sigma$   | $\frac{1}{\sigma\sqrt{2\pi}}e^{-\frac{(x-\mu)^2}{2\sigma^2}}$                         | $\mu$                         | $\sigma^2$                                             |
| Exponencial  | $Exp(\beta)$            | $\beta$        | $\frac{1}{\beta}e^{-x/\beta}$                                                         | $\beta$                       | $\beta^2$                                              |
| Gamma        | $Gamma(\alpha,\beta)$   | $\alpha,\beta$ | $\frac{1}{\beta^\alpha\Gamma(\alpha)}x^{\alpha-1}e^{-x/\beta}$                        | $\alpha\beta$                 | $\alpha\beta^2$                                        |
| Chi-cuadrado | $\chi^2(v)$             | $v$            | $\frac{1}{2^{v/2}\Gamma(v/2)}x^{v/2-1}e^{-x/2}$                                       | $v$                           | $2v$                                                   |
| Weibull      | $Weibull(\alpha,\beta)$ | $\alpha,\beta$ | $\alpha\beta x^{\beta-1}e^{-\alpha x^\beta}$                                          | -                             | -                                                      |
| Beta         | $Beta(\alpha,\beta)$    | $\alpha,\beta$ | $\frac{\Gamma(\alpha+\beta)}{\Gamma(\alpha)\Gamma(\beta)}x^{\alpha-1}(1-x)^{\beta-1}$ | $\frac{\alpha}{\alpha+\beta}$ | $\frac{\alpha\beta}{(\alpha+\beta)^2(\alpha+\beta+1)}$ |

> [!success] Relación entre distribuciones

| Distribución      | Descripción                                   |
| ----------------- | --------------------------------------------- |
| Geométrica        | Número de intentos hasta el primer éxito      |
| Binomial Negativa | Número de intentos hasta el k-ésimo éxito     |
| Binomial          | Número de éxitos en n intentos                |
| Poisson           | Número de eventos por unidad (tiempo/espacio) |
| Exponencial       | Tiempo entre eventos de proceso Poisson       |

> [!warning] Importante
> Recuerda que todas estas distribuciones cumplen con las propiedades básicas de las funciones de probabilidad/densidad y tienen aplicaciones específicas según el contexto del problema.