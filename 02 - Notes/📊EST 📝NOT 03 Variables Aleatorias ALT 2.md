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
> Una **variable aleatoria** es una función que asigna un valor numérico a cada resultado de un experimento aleatorio. Los **modelos teóricos** de variables aleatorias permiten calcular probabilidades de manera más eficiente mediante fórmulas y propiedades matemáticas, en lugar de enumerar todos los resultados posibles.

> [!quote] Definición formal
> Una variable aleatoria $X$ es una función $X: S \to \mathbb{R}$ que asocia un número real a cada elemento del espacio muestral $S$.

> [!example] Ejemplo
> Lanzamiento de 2 monedas $\Omega = {cc, cs, sc, ss}$ Evento: Obtener cara $X$: Número de caras obtenidas $X(cc) = 2$, $X(cs) = 1$, $X(sc) = 1$, $X(ss) = 0$

> [!question] Pregunta clave sobre definiciones **¿Qué expresiones son correctas para una V.A.D.?**
> - ✅ $F(x) = P(X \leq x)$ (Función de Distribución Acumulada - CDF)
> - ✅ $f(x) = P(X = x)$ (Función de Probabilidad - PMF)

---

## 2. Función de Probabilidad para Variables Aleatorias Discretas

> [!info] Función de probabilidad $p(x)$
> Para una variable aleatoria discreta $X$, la **función de probabilidad** (también llamada función de masa de probabilidad o PMF) $p(x)$ se define como:
> 
> $$p(x) = P(X = x)$$
> 
> Esta función debe cumplir con dos propiedades fundamentales:
> 
> 1. $p(x) \geq 0$ para todo $x$ (las probabilidades no pueden ser negativas)
> 2. $\sum_{\text{todos los } x} p(x) = 1$ (la suma de todas las probabilidades debe ser 1)

| $x$    | 0     | 1     | 2     | 3     |
| ------ | ----- | ----- | ----- | ----- |
| $p(x)$ | 0.125 | 0.375 | 0.375 | 0.125 |

> [!warning] Propiedades importantes de f(x) y F(x)
> **¿Qué puede tomar valores negativos?**
> 
> - ❌ $f(x)$ NO puede ser negativa (es una probabilidad)
> - ❌ $F(x)$ NO puede ser negativa (es una probabilidad acumulada, va de 0 a 1)
> - ✅ $E(X)$ SÍ puede ser negativo (si X toma valores negativos con mayor ponderación)
> - ❌ $Var(X)$ NO puede ser negativa (es una suma de cuadrados ponderados, siempre $\geq 0$)

---

## 3. Función de Distribución Acumulada

> [!info] Definición
> Sea $X$ una variable aleatoria discreta. La **función de distribución acumulada** (CDF) $F(x)$ representa la probabilidad de que la variable aleatoria tome un valor menor o igual a $x$:
> 
> $$F(x) = P(X \leq x) = \sum_{t \leq x} f(t)$$
> 
> Esta función acumula las probabilidades desde el valor más pequeño hasta $x$.

| $x$    | 0     | 1   | 2     | 3   |
| ------ | ----- | --- | ----- | --- |
| $F(x)$ | 0.125 | 0.5 | 0.875 | 1   |

---

## 4. Valor Esperado y Varianza

### 4.1 Valor Esperado

> [!info] Definición
> Sea $X$ una variable aleatoria discreta, el **valor esperado** (o esperanza matemática) representa el promedio ponderado de todos los valores posibles de $X$:
> 
> $$E(X) = \mu_x = \sum_{\text{todos los } x} x \cdot p(x)$$
> 
> El valor esperado es el centro de masa de la distribución de probabilidad.

> [!info] Valor esperado de funciones
> Para cualquier función $g(X)$ de la variable aleatoria:
> 
> $$E[g(X)] = \sum_{\text{todos los } x} g(x) \cdot p(x)$$
> 
> Esta es la **Ley del Estadístico Inconsciente**, que permite calcular la esperanza de transformaciones de $X$ sin necesidad de encontrar primero la distribución de $g(X)$.

> [!success] Confirmación teórica
> **¿Es correcta la expresión $E(g(x)) = \sum g(x)f(x)$?** ✅ SÍ, es la definición correcta del Valor Esperado de una función $g(X)$ de una variable aleatoria discreta $X$.

### 4.2 Varianza

> [!info] Definición
> La **varianza** de $X$ mide la dispersión o variabilidad de los valores de la variable aleatoria respecto a su media:
> 
> $$Var(X) = \sigma_x^2 = \sum_{\text{todos los } x} (x - \mu)^2 p(x)$$
> 
> También puede calcularse usando la fórmula alternativa: $$Var(X) = E(X^2) - [E(X)]^2$$

> [!example] Ejemplo de cálculo de varianza

| $x$ | $p(x)$ | $(x - \mu)^2$ | $(x - \mu)^2 \cdot p(x)$ |
| --- | ------ | ------------- | ------------------------ |
| 0   | 0.125  | 2.25          | 0.28125                  |
| 1   | 0.375  | 0.25          | 0.09375                  |
| 2   | 0.375  | 0.25          | 0.09375                  |
| 3   | 0.125  | 2.25          | 0.28125                  |

$$Var(X) = 0.75$$

> [!warning] Error común sobre varianza
> **¿Es correcto que $Var(aX+c) = a Var(X) + c$?** ❌ NO, la fórmula correcta es: $$Var(aX+c) = a^2 Var(X)$$
> 
> - La constante aditiva $c$ NO afecta la dispersión (solo desplaza la distribución)
> - El factor multiplicativo $a$ se eleva al cuadrado porque la varianza mide desviaciones cuadráticas

---

## 5. Propiedades del Valor Esperado y Varianza

> [!success] Propiedades clave

| Concepto                          | Fórmula                      | Explicación                                                  |
| --------------------------------- | ---------------------------- | ------------------------------------------------------------ |
| Esperanza de constante            | $E(c) = c$                   | El valor esperado de una constante es la constante misma     |
| Varianza de constante             | $Var(c) = 0$                 | Una constante no tiene variabilidad                          |
| Esperanza de constante × variable | $E(cX) = cE(X)$              | La esperanza es un operador lineal                           |
| Varianza de constante × variable  | $Var(cX) = c^2 Var(X)$       | La varianza escala con el cuadrado del factor multiplicativo |
| Fórmula alternativa de varianza   | $Var(X) = E(X^2) - [E(X)]^2$ | Útil para cálculos prácticos                                 |

> [!info] Propiedades adicionales de Esperanza
> 
> - Si $X \geq 0$ entonces $E(X) \geq 0$ (monotonicidad)
> - $E(X + Y) = E(X) + E(Y)$ (linealidad, válida siempre, incluso si no son independientes)
> - $E(aX + b) = aE(X) + b$ (transformación lineal)

> [!info] Propiedades adicionales de Varianza
> 
> - $Var(X) \geq 0$ (siempre no negativa)
> - $Var(X + c) = Var(X)$ (las constantes aditivas no afectan la varianza)
> - $Var(X + Y) = Var(X) + Var(Y)$ SOLO si $X$ e $Y$ son independientes
> - En general: $Var(X + Y) = Var(X) + Var(Y) + 2Cov(X,Y)$

> [!example] Aplicación práctica: Juego de monedas
> **Problema**: Lanzar 3 monedas. Ganar $15 por 3 sellos o 3 caras, $8 por 2 sellos, perder $10 por 1 sello.
> 
> **Solución**:
> 
> - $P(\text{3 sellos o 3 caras}) = \frac{2}{8}$
> - $P(\text{2 sellos}) = \frac{3}{8}$
> - $P(\text{1 sello}) = \frac{3}{8}$
> 
> $$E(X) = (15) \cdot \frac{2}{8} + (8) \cdot \frac{3}{8} + (-10) \cdot \frac{3}{8} = 3$$ ✅ Se espera ganar $3 en promedio por juego.

---

## 6. Principales Modelos Discretos

### 6.1 Distribución Binomial

> [!success] Descripción  
> La distribución binomial permite calcular la probabilidad de obtener un número específico de éxitos en $n$ ensayos o experimentos independientes, donde cada ensayo tiene exactamente dos resultados posibles (éxito o fracaso) y la probabilidad de éxito $p$ permanece constante en todos los ensayos.

> [!info] Características
> 
> - Notación: $X \sim B(n, p)$ o $X \sim Bin(n, p)$
> - Cuenta el número de éxitos en $n$ intentos independientes
> - Función de probabilidad: $P(X = x) = \binom{n}{x} p^x (1-p)^{n-x}$ para $x = 0, 1, 2, \ldots, n$
> - Valor esperado: $E(X) = np$
> - Varianza: $Var(X) = np(1-p) = npq$ donde $q = 1-p$

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución binomial, se necesita:
> 
> - **$n$**: Número fijo de ensayos o intentos
> - **$p$**: Probabilidad de éxito en cada ensayo (constante)
> - **$x$**: Número de éxitos que se desea calcular (entre 0 y $n$)
> 
> Además, debe verificarse que:
> 
> - Los ensayos sean independientes entre sí
> - Cada ensayo tenga solo dos resultados posibles
> - La probabilidad de éxito sea la misma en todos los ensayos

> [!success] Características de un experimento binomial
> ✅ **Requisitos que deben cumplirse**:
> 
> - El experimento consiste en $n$ repeticiones o intentos idénticos
> - Cada intento es independiente de los demás
> - Cada intento solo puede resultar en éxito o fracaso
> - La probabilidad de éxito $p$ es constante en todos los intentos
> - La variable de interés es el número total de éxitos en los $n$ intentos

> [!example] Cálculo binomial
> **Problema**: Una fábrica produce piezas con 5% de defectuosas. Si se seleccionan 10 piezas al azar (con reemplazo), ¿cuál es la probabilidad de encontrar exactamente 2 defectuosas?
> 
> **Solución**: $n = 10$, $p = 0.05$, $x = 2$ $$P(X=2) = \binom{10}{2} (0.05)^2 (0.95)^8 = 45 \times 0.0025 \times 0.6634 \approx 0.0746$$

> [!example] Ejemplo aplicado
> **Problema**: Si la probabilidad de que un paciente se recupere de una enfermedad es 0.40, ¿cuál es la probabilidad de que exactamente 7 de 10 pacientes se recuperen?
> 
> **Solución**: $n = 10$, $p = 0.40$, $x = 7$ $$P(X=7) = \binom{10}{7} (0.40)^7 (0.60)^3 = 120 \times 0.0016384 \times 0.216 \approx 0.0425$$

### 6.2 Distribución Binomial Negativa

> [!success] Descripción  
> La distribución binomial negativa permite calcular la probabilidad de que se necesiten exactamente $x$ ensayos para obtener el $k$-ésimo éxito, en una secuencia de ensayos independientes donde cada uno tiene probabilidad constante $p$ de éxito. A diferencia de la binomial, aquí el número de ensayos es variable y lo que se fija es el número de éxitos deseados.

> [!info] Características
> 
> - Notación: $X \sim BN(k, p)$ o $X \sim NB(k, p)$
> - Cuenta el número de ensayos necesarios hasta obtener el $k$-ésimo éxito
> - Función de probabilidad: $P(X = x) = \binom{x-1}{k-1} p^k (1-p)^{x-k}$ para $x = k, k+1, k+2, \ldots$
> - Valor esperado: $E(X) = \frac{k}{p}$
> - Varianza: $Var(X) = \frac{k(1-p)}{p^2}$

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución binomial negativa, se necesita:
> 
> - **$k$**: Número de éxitos que se desea alcanzar (fijo)
> - **$p$**: Probabilidad de éxito en cada ensayo (constante)
> - **$x$**: Número total de ensayos en el cual ocurre el $k$-ésimo éxito
> 
> Además, debe verificarse que:
> 
> - Los ensayos sean independientes entre sí
> - La probabilidad de éxito sea constante
> - Se continúa hasta lograr exactamente $k$ éxitos

> [!example] Aplicación práctica
> **Problema**: En un lote con 5% de piezas defectuosas, si se inspeccionan piezas una por una (con reemplazo), ¿cuál es la probabilidad de necesitar 5 o más inspecciones para encontrar 3 piezas defectuosas?
> 
> **Solución**: $k = 3$, $p = 0.05$ $$P(X \geq 5) = 1 - [P(X=3) + P(X=4)]$$ $$P(X=3) = \binom{2}{2}(0.05)^3(0.95)^0 = 0.000125$$ $$P(X=4) = \binom{3}{2}(0.05)^3(0.95)^1 = 0.000356$$ $$P(X \geq 5) \approx 0.9995$$

> [!example] Ejemplo aplicado
> **Problema**: Si la probabilidad de éxito en cada intento es 20%, ¿cuál es la probabilidad de necesitar exactamente 10 intentos para lograr 3 éxitos?
> 
> **Solución**: $k = 3$, $p = 0.20$, $x = 10$ $$P(X=10) = \binom{9}{2} (0.20)^3 (0.80)^7 = 36 \times 0.008 \times 0.2097 \approx 0.0605$$

### 6.3 Distribución Geométrica

> [!success] Descripción  
> La distribución geométrica permite calcular la probabilidad de que el primer éxito ocurra en el $x$-ésimo ensayo, en una secuencia de ensayos independientes con probabilidad constante $p$ de éxito. Es un caso especial de la binomial negativa cuando $k=1$ (buscamos solo el primer éxito).

> [!tip] Caso especial
> Es un caso particular de la binomial negativa cuando $k = 1$:
> 
> - Función de probabilidad: $P(X = x) = p(1-p)^{x-1}$ para $x = 1, 2, 3, \ldots$
> - Valor esperado: $E(X) = \frac{1}{p}$
> - Varianza: $Var(X) = \frac{1-p}{p^2}$

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución geométrica, se necesita:
> 
> - **$p$**: Probabilidad de éxito en cada ensayo (constante)
> - **$x$**: Número del ensayo en el cual ocurre el primer éxito
> 
> Además, debe verificarse que:
> 
> - Los ensayos sean independientes entre sí
> - La probabilidad de éxito sea constante
> - Se busca únicamente el primer éxito

> [!question] Relación entre distribuciones
> **¿La binomial es caso particular de la geométrica cuando intentos=1?** ❌ NO. La binomial con $n=1$ es una distribución de Bernoulli (un solo ensayo con éxito/fracaso), no una distribución geométrica. La geométrica cuenta el número de ensayos hasta el primer éxito, que puede ser cualquier número $\geq 1$.

> [!example] Identificación de distribución
> **Problema**: En un proceso con 20% de productos defectuosos, ¿cuál es la probabilidad de que la primera pieza defectuosa se encuentre en la primera inspección?
> 
> **Solución**: ✅ **Distribución Geométrica** - se busca el primer éxito $$P(X=1) = 0.20 \times (0.80)^0 = 0.20$$

> [!example] Ejemplo aplicado
> **Problema**: Si 15% de las piezas son defectuosas:
> 
> a) ¿Probabilidad de que la primera pieza defectuosa aparezca en la quinta inspección? $$P(X=5) = 0.15 \times (0.85)^4 = 0.15 \times 0.5220 \approx 0.0783$$
> 
> b) ¿Probabilidad de no encontrar piezas defectuosas en las primeras 10 inspecciones? $$P(X > 10) = (0.85)^{10} \approx 0.1969$$

### 6.4 Distribución de Poisson

> [!success] Descripción  
> La distribución de Poisson permite calcular la probabilidad de que ocurra un número específico de eventos en un intervalo fijo de tiempo, espacio, área o volumen, cuando estos eventos ocurren de manera independiente y con una tasa promedio constante conocida $\lambda$. Es especialmente útil para modelar eventos raros que ocurren de forma aleatoria.

> [!info] Características
> 
> - Notación: $X \sim P(\lambda)$ o $X \sim Poisson(\lambda)$
> - Modela el número de eventos que ocurren en una unidad fija de tiempo, área o volumen
> - Función de probabilidad: $P(X = x) = \frac{\lambda^x e^{-\lambda}}{x!}$ para $x = 0, 1, 2, \ldots$
> - Valor esperado: $E(X) = \lambda$
> - Varianza: $Var(X) = \lambda$
> - **Propiedad única**: La media y la varianza son iguales

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución de Poisson, se necesita:
> 
> - **$\lambda$**: Tasa promedio de ocurrencia de eventos por unidad (tiempo, área, volumen, etc.)
> - **$x$**: Número de eventos que se desea calcular
> - **Unidad de medida**: Intervalo de tiempo, área o volumen en el que se cuentan los eventos
> 
> Además, debe verificarse que:
> 
> - Los eventos ocurren de manera independiente
> - La tasa promedio $\lambda$ es constante
> - Los eventos son raros (baja probabilidad individual)
> - No pueden ocurrir dos eventos simultáneamente en el mismo punto

> [!example] Ejemplo aplicado
> **Problema**: En un cultivo llegan en promedio 2 microorganismos patógenos por hora. ¿Cuál es la probabilidad de observar hasta 3 microorganismos en una hora?
> 
> **Solución**: $\lambda = 2$, calcular $P(X \leq 3)$ $$P(X \leq 3) = \sum_{x=0}^{3} \frac{e^{-2} \cdot 2^x}{x!} = e^{-2}\left(\frac{2^0}{0!} + \frac{2^1}{1!} + \frac{2^2}{2!} + \frac{2^3}{3!}\right)$$ $$= e^{-2}(1 + 2 + 2 + 1.333) = 0.1353 \times 6.333 \approx 0.857$$

### 6.5 Distribución Hipergeométrica

> [!success] Descripción  
> La distribución hipergeométrica permite calcular la probabilidad de obtener un número específico de éxitos al extraer una muestra de tamaño $n$ sin reemplazo de una población finita de tamaño $N$ que contiene $k$ elementos con la característica de interés. A diferencia de la binomial, las extracciones NO son independientes porque no hay reemplazo, lo que hace que las probabilidades cambien en cada extracción.

> [!info] Identificación de distribución
> **Problema**: En un curso de 40 personas hay estudiantes de varias ingenierías. Si se seleccionan 8 personas SIN reemplazo, ¿cuál es la probabilidad de que 5 sean de ingeniería mecánica?
> 
> ✅ **Distribución Hipergeométrica** - muestreo sin reemplazo de población finita.

> [!info] Características
> 
> - Notación: $X \sim H(N, n, k)$ o $X \sim Hypergeom(N, n, k)$
> - Modela el número de éxitos en una muestra de tamaño $n$ extraída sin reemplazo de una población de tamaño $N$
> - Función de probabilidad: $P(X = x) = \frac{\binom{k}{x}\binom{N-k}{n-x}}{\binom{N}{n}}$
> - Valor esperado: $E(X) = \frac{nk}{N} = n \cdot \frac{k}{N}$
> - Varianza: $V(X) = \frac{N-n}{N-1} \cdot \frac{nk}{N}\left(1-\frac{k}{N}\right)$
> - El factor $\frac{N-n}{N-1}$ es el **factor de corrección por población finita**

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución hipergeométrica, se necesita:
> 
> - **$N$**: Tamaño total de la población
> - **$k$**: Número de elementos en la población con la característica de interés (éxitos)
> - **$n$**: Tamaño de la muestra extraída
> - **$x$**: Número de éxitos deseados en la muestra
> 
> Además, debe verificarse que:
> 
> - El muestreo sea sin reemplazo
> - La población sea finita
> - $x \leq \min(n, k)$ y $x \geq \max(0, n-(N-k))$

> [!example] Ejemplo aplicado
> **Problema**: En una población de 1000 bacterias hay 150 resistentes a un antibiótico. Si se toma una muestra de 100 bacterias, ¿cuál es la probabilidad de obtener exactamente 10 resistentes?
> 
> **Solución**: $N = 1000$, $k = 150$, $n = 100$, $x = 10$ $$P(X=10) = \frac{\binom{150}{10}\binom{850}{90}}{\binom{1000}{100}}$$
> 
> Este cálculo requiere software estadístico para obtener el resultado numérico.

---

## 7. Variables Aleatorias Continuas

### 7.1 Definición y Función de Densidad

> [!info] Definición
> Una variable aleatoria es **continua** cuando puede tomar cualquier valor dentro de un intervalo de números reales. A diferencia de las discretas, las continuas no pueden enumerarse y tienen infinitos valores posibles en cualquier intervalo.

> [!info] Función de densidad de probabilidad $f(x)$
> Sea $X$ una variable aleatoria continua. La función $f(x): \mathbb{R} \to \mathbb{R}$ es la **función de densidad de probabilidad** (PDF) de $X$ si cumple:
> 
> 1. $f(x) \geq 0$ para todo $x \in \mathbb{R}$ (no negatividad)
> 2. $\int_{-\infty}^{+\infty} f(x) , dx = 1$ (área total igual a 1)
> 
> **Importante**: Para variables continuas, $P(X = x) = 0$ para cualquier valor específico $x$. La probabilidad se calcula sobre intervalos:
> 
> $$P(a < X < b) = P(a \leq X \leq b) = \int_a^b f(x) , dx$$

### 7.2 Función de Distribución Acumulada

> [!info] Definición
> La función de distribución acumulada (CDF) para una variable aleatoria continua es:
> 
> $$F(x) = P(X \leq x) = \int_{-\infty}^{x} f(t) , dt$$
> 
> Esta función acumula toda la probabilidad desde $-\infty$ hasta $x$.

> [!success] Propiedades importantes
> 
> - La densidad es la derivada de la CDF: $f(x) = \frac{d}{dx}F(x)$
> - $F(x)$ es una función monótona no decreciente (siempre crece o se mantiene constante)
> - $F(x)$ es una función continua
> - $\lim_{x \to -\infty} F(x) = 0$ y $\lim_{x \to +\infty} F(x) = 1$
> - $P(a < X < b) = F(b) - F(a)$

### 7.3 Valor Esperado y Varianza

> [!info] Definiciones para variables continuas
> Para una variable aleatoria continua $X$ con función de densidad $f(x)$:
> 
> - **Valor esperado**: $E(X) = \mu = \int_{-\infty}^{+\infty} x \cdot f(x) , dx$
> - **Varianza**: $Var(X) = \sigma^2 = \int_{-\infty}^{+\infty} (x - \mu)^2 f(x) , dx$
> - **Fórmula alternativa**: $Var(X) = E(X^2) - [E(X)]^2$
> - **Esperanza de funciones**: $E(g(X)) = \int_{-\infty}^{+\infty} g(x) \cdot f(x) , dx$

---

## 8. Principales Modelos Continuos

### 8.1 Distribución Uniforme

> [!success] Descripción
> La distribución uniforme continua modela situaciones donde todos los valores en un intervalo $[a, b]$ tienen la misma probabilidad de ocurrir. La probabilidad es "uniforme" o constante en todo el intervalo. Es útil cuando no hay razón para favorecer ningún valor sobre otro dentro del rango.

> [!info] Características
> 
> - Notación: $X \sim U(a,b)$ o $X \sim Uniform(a,b)$
> - Probabilidad uniforme en el intervalo $[a, b]$
> - Función de densidad: $$f(x) = \begin{cases} \frac{1}{b-a} & \text{si } a \leq x \leq b \ 0 & \text{en otro caso} \end{cases}$$
> - Función de distribución: $$F(x) = \begin{cases} 0 & \text{si } x < a \ \frac{x-a}{b-a} & \text{si } a \leq x \leq b \ 1 & \text{si } x > b \end{cases}$$
> - Valor esperado: $E(X) = \frac{a+b}{2}$ (punto medio del intervalo)
> - Varianza: $Var(X) = \frac{(b-a)^2}{12}$

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución uniforme, se necesita:
> 
> - **$a$**: Límite inferior del intervalo
> - **$b$**: Límite superior del intervalo (con $b > a$)
> 
> Debe verificarse que:
> 
> - Todos los valores en $[a, b]$ sean igualmente probables
> - No haya información que favorezca ningún valor sobre otro

> [!example] Ejemplo aplicado
> **Problema**: El tiempo de metabolización de un medicamento en el cuerpo está uniformemente distribuido entre 2 y 6 horas. ¿Cuál es la probabilidad de que la metabolización ocurra entre 3 y 4 horas?
> 
> **Solución**: $a = 2$, $b = 6$ $$P(3 < X < 4) = \frac{4-3}{6-2} = \frac{1}{4} = 0.25$$
> 
> También: $E(X) = \frac{2+6}{2} = 4$ horas (tiempo promedio de metabolización)

### 8.2 Distribución Normal

> [!success] Descripción
> La distribución normal (o gaussiana) es la distribución continua más importante en estadística. Modela fenómenos naturales y mediciones que tienden a concentrarse alrededor de un valor central (la media), con desviaciones simétricas hacia ambos lados. Es fundamental en inferencia estadística por el Teorema del Límite Central, que establece que las sumas y promedios de muchas variables tienden a seguir una distribución normal.

> [!info] Características
> 
> - Notación: $X \sim N(\mu, \sigma)$ o $X \sim Normal(\mu, \sigma^2)$
> - Función de densidad: $$f(x) = \frac{1}{\sigma\sqrt{2\pi}} e^{-\frac{(x-\mu)^2}{2\sigma^2}}, \quad x \in \mathbb{R}$$
> - Curva simétrica respecto a la media $\mu$ (forma de campana)
> - Valor esperado: $E(X) = \mu$
> - Varianza: $Var(X) = \sigma^2$
> - Desviación estándar: $\sigma$
> - Área total bajo la curva = 1
> - Aproximadamente 68% de los datos están dentro de $\mu \pm \sigma$
> - Aproximadamente 95% de los datos están dentro de $\mu \pm 2\sigma$
> - Aproximadamente 99.7% de los datos están dentro de $\mu \pm 3\sigma$ (Regla empírica)

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución normal, se necesita:
> 
> - **$\mu$**: Media o valor esperado de la distribución
> - **$\sigma$**: Desviación estándar (con $\sigma > 0$)
> - **$\sigma^2$**: Varianza (a veces se proporciona en lugar de $\sigma$)
> 
> Para calcular probabilidades, también se necesita:
> 
> - Los valores o intervalo de interés para calcular $P(a < X < b)$

> [!example] Ejemplo aplicado
> **Problema**: La concentración de una toxina en muestras de agua sigue una distribución $N(10, 2)$ µg/ml. ¿Cuál es la probabilidad de que una muestra tenga concentración entre 8 y 12 µg/ml?
> 
> **Solución**: $\mu = 10$, $\sigma = 2$
> 
> Estandarizamos: $$Z_1 = \frac{8-10}{2} = -1, \quad Z_2 = \frac{12-10}{2} = 1$$ $$P(8 < X < 12) = P(-1 < Z < 1) \approx 0.6827$$
> 
> Interpretación: Aproximadamente 68.27% de las muestras tendrán concentraciones entre 8 y 12 µg/ml.

### 8.3 Distribución Normal Estándar

> [!success] Descripción
> La distribución normal estándar es un caso especial de la distribución normal con media 0 y desviación estándar 1. Es fundamental porque cualquier variable con distribución normal puede transformarse a una normal estándar mediante estandarización, lo que permite usar tablas de probabilidades universales.

> [!info] Características
> 
> - Notación: $Z \sim N(0, 1)$
> - **Transformación de estandarización**: Si $X \sim N(\mu, \sigma)$, entonces $Z = \frac{X-\mu}{\sigma} \sim N(0, 1)$
> - Función de densidad: $$f(z) = \frac{1}{\sqrt{2\pi}} e^{-\frac{z^2}{2}}, \quad z \in \mathbb{R}$$
> - Valor esperado: $E(Z) = 0$
> - Varianza: $Var(Z) = 1$
> - Simétrica respecto a $z = 0$
> - Se utilizan tablas o software para calcular probabilidades

> [!info] Requisitos / Datos necesarios
> Para usar la normal estándar, se necesita:
> 
> - La **puntuación z** o valor estandarizado
> - Si se parte de $X \sim N(\mu, \sigma)$: los valores de $\mu$, $\sigma$ y el valor $x$ a estandarizar
> 
> **Fórmula de estandarización**: $z = \frac{x - \mu}{\sigma}$

> [!tip] Uso práctico
> Para calcular $P(a < X < b)$ cuando $X \sim N(\mu, \sigma)$:
> 
> 1. Estandarizar: $z_1 = \frac{a-\mu}{\sigma}$ y $z_2 = \frac{b-\mu}{\sigma}$
> 2. Calcular: $P(a < X < b) = P(z_1 < Z < z_2) = \Phi(z_2) - \Phi(z_1)$
> 
> donde $\Phi(z)$ es la función de distribución acumulada de $Z$.

### 8.4 Distribución t-Student

> [!success] Descripción
> La distribución t-Student es una distribución continua simétrica similar a la normal pero con colas más pesadas (mayor probabilidad en los extremos). Es fundamental en inferencia estadística cuando se trabaja con muestras pequeñas y la desviación estándar poblacional es desconocida. A medida que aumenta el tamaño de muestra, se aproxima a la normal estándar.

> [!info] Características
> 
> - Notación: $T \sim t(v)$ o $T \sim t_{v}$
> - Parámetro: **grados de libertad** $v$ (usualmente $v = n - 1$ donde $n$ es el tamaño de muestra)
> - Simétrica y centrada en 0, como la normal estándar
> - Colas más pesadas que la normal (mayor variabilidad)
> - Cuando $v \to \infty$, entonces $t_v \to N(0,1)$
> - Para $v > 30$, la distribución t es muy similar a la normal estándar
> - Valor esperado: $E(T) = 0$ (para $v > 1$)
> - Varianza: $Var(T) = \frac{v}{v-2}$ (para $v > 2$)

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución t-Student, se necesita:
> 
> - **$v$**: Grados de libertad (típicamente $v = n - 1$ donde $n$ es el tamaño de muestra)
> - El **valor crítico** $t$ o el intervalo de interés
> 
> Se usa principalmente en:
> 
> - Pruebas de hipótesis para medias con $\sigma$ desconocida
> - Intervalos de confianza para medias
> - Comparación de dos medias

### 8.5 Distribución Exponencial

> [!success] Descripción
> La distribución exponencial modela el tiempo de espera hasta que ocurre un evento en un proceso de Poisson. Es la distribución continua del tiempo entre eventos consecutivos cuando los eventos ocurren de manera aleatoria e independiente con una tasa constante. Tiene la propiedad de "falta de memoria": la probabilidad de que ocurra un evento en el próximo intervalo no depende del tiempo ya transcurrido.

> [!info] Características
> 
> - Notación: $X \sim Exp(\beta)$ o $X \sim Exp(\lambda)$
> - Función de densidad (parametrización con $\beta$): $$f(x) = \begin{cases} \frac{1}{\beta} e^{-x/\beta} & \text{si } x > 0 \ 0 & \text{en otro caso} \end{cases}$$
> - Función de densidad (parametrización con $\lambda$): $$f(x) = \begin{cases} \lambda e^{-\lambda x} & \text{si } x > 0 \ 0 & \text{en otro caso} \end{cases}$$
> - Función de distribución: $F(x) = 1 - e^{-\lambda x} = 1 - e^{-x/\beta}$ para $x > 0$
> - Valor esperado: $E(X) = \beta = \frac{1}{\lambda}$
> - Varianza: $Var(X) = \beta^2 = \frac{1}{\lambda^2}$

> [!info] Relación con Poisson
> **Conexión importante**: Si el número de eventos por unidad de tiempo sigue una distribución de Poisson con parámetro $\lambda$, entonces el tiempo entre eventos consecutivos sigue una distribución Exponencial con parámetro $\lambda$.
> 
> - Poisson cuenta **cuántos eventos** ocurren en un tiempo fijo
> - Exponencial mide **cuánto tiempo** hasta el próximo evento

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución exponencial, se necesita:
> 
> - **$\lambda$**: Tasa de ocurrencia de eventos por unidad de tiempo (eventos/tiempo)
> - O alternativamente **$\beta = \frac{1}{\lambda}$**: Tiempo promedio entre eventos
> - **$x$ o intervalo**: El tiempo de interés para calcular probabilidades
> 
> Debe verificarse que:
> 
> - Los eventos ocurren de manera continua e independiente
> - La tasa de ocurrencia es constante
> - El proceso no tiene memoria

> [!example] Ejemplo aplicado
> **Problema**: Las bacterias en un cultivo mueren a una tasa de 0.25 por hora. ¿Cuál es la probabilidad de que una bacteria sobreviva menos de 3 horas?
> 
> **Solución**: $\lambda = 0.25$ por hora, calcular $P(X < 3)$ $$P(X < 3) = 1 - e^{-0.25 \times 3} = 1 - e^{-0.75} = 1 - 0.4724 \approx 0.5276$$
> 
> Interpretación: Aproximadamente 52.76% de las bacterias mueren antes de las 3 horas.
> 
> Tiempo promedio de supervivencia: $E(X) = \frac{1}{0.25} = 4$ horas.

### 8.6 Distribución Gamma

> [!success] Descripción
> La distribución Gamma es una familia flexible de distribuciones continuas que generaliza la distribución exponencial. Modela el tiempo de espera hasta que ocurren $\alpha$ eventos en un proceso de Poisson, o la suma de $\alpha$ variables exponenciales independientes. Es útil en análisis de confiabilidad, teoría de colas y modelado de tiempos de espera.

> [!info] Función Gamma
> La **función Gamma** $\Gamma(\alpha)$ es una generalización del factorial para números reales:
> 
> $$\Gamma(\alpha) = \int_{0}^{\infty} x^{\alpha-1} e^{-x} , dx, \quad \alpha > 0$$
> 
> **Propiedades importantes**:
> 
> - $\Gamma(\alpha) = (\alpha-1)\Gamma(\alpha-1)$ (propiedad recursiva)
> - Si $n$ es un entero positivo: $\Gamma(n) = (n-1)!$
> - $\Gamma(1) = 1$
> - $\Gamma(1/2) = \sqrt{\pi}$

> [!info] Distribución Gamma
> 
> - Notación: $X \sim Gamma(\alpha, \beta)$
> - Parámetros: $\alpha > 0$ (forma), $\beta > 0$ (escala)
> - Función de densidad: $$f(x) = \begin{cases} \frac{1}{\beta^\alpha \Gamma(\alpha)} x^{\alpha-1} e^{-x/\beta} & \text{si } x > 0 \ 0 & \text{en otro caso} \end{cases}$$
> - Valor esperado: $E(X) = \alpha\beta$
> - Varianza: $Var(X) = \alpha\beta^2$
> - Cuando $\alpha = 1$: se reduce a la distribución Exponencial($\beta$)

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución Gamma, se necesita:
> 
> - **$\alpha$**: Parámetro de forma (número de eventos, si se modela un proceso de Poisson)
> - **$\beta$**: Parámetro de escala (tiempo promedio entre eventos)
> 
> Interpretación: Si los eventos ocurren según un proceso de Poisson, Gamma($\alpha$, $\beta$) modela el tiempo hasta el $\alpha$-ésimo evento.

### 8.7 Distribución Chi-cuadrado

> [!success] Descripción
> La distribución Chi-cuadrado ($\chi^2$) es un caso especial de la distribución Gamma y es fundamental en inferencia estadística. Se usa en pruebas de bondad de ajuste, pruebas de independencia, y en la construcción de intervalos de confianza para varianzas. Si $Z_1, Z_2, \ldots, Z_v$ son variables normales estándar independientes, entonces $\sum_{i=1}^{v} Z_i^2$ sigue una distribución $\chi^2$ con $v$ grados de libertad.

> [!info] Características
> 
> - Notación: $X \sim \chi^2(v)$ o $X \sim \chi^2_{v}$
> - Parámetro: **grados de libertad** $v$ (entero positivo)
> - Caso especial de Gamma con $\alpha = \frac{v}{2}$ y $\beta = 2$
> - Función de densidad: $$f(x) = \begin{cases} \frac{1}{2^{v/2}\Gamma(v/2)} x^{v/2-1} e^{-x/2} & \text{si } x > 0 \ 0 & \text{en otro caso} \end{cases}$$
> - Valor esperado: $E(X) = v$
> - Varianza: $Var(X) = 2v$
> - La distribución es asimétrica positiva (sesgada a la derecha)
> - A medida que $v$ aumenta, se aproxima a la normal

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución Chi-cuadrado, se necesita:
> 
> - **$v$**: Grados de libertad
> 
> Se usa comúnmente en:
> 
> - Pruebas de bondad de ajuste
> - Pruebas de independencia en tablas de contingencia
> - Intervalos de confianza para varianzas
> - Estadístico: $\chi^2 = \sum \frac{(O_i - E_i)^2}{E_i}$ donde $O_i$ son frecuencias observadas y $E_i$ esperadas

### 8.8 Distribución Weibull

> [!success] Descripción
> La distribución Weibull es una distribución continua muy versátil usada principalmente en análisis de confiabilidad, estudios de vida útil de materiales y componentes, y modelado de tasas de falla. Puede modelar tanto tasas de falla crecientes, decrecientes o constantes dependiendo del parámetro de forma, lo que la hace muy útil en ingeniería y control de calidad.

> [!info] Características
> 
> - Notación: $X \sim Weibull(\alpha, \beta)$
> - Parámetros: $\alpha > 0$ (escala), $\beta > 0$ (forma)
> - Función de densidad: $$f(x) = \begin{cases} \alpha\beta x^{\beta-1} e^{-\alpha x^\beta} & \text{si } x > 0 \ 0 & \text{en otro caso} \end{cases}$$
> - Cuando $\beta = 1$: se reduce a la distribución Exponencial
> - Cuando $\beta < 1$: tasa de falla decreciente (mortalidad infantil)
> - Cuando $\beta = 1$: tasa de falla constante
> - Cuando $\beta > 1$: tasa de falla creciente (desgaste)

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución Weibull, se necesita:
> 
> - **$\alpha$**: Parámetro de escala ($\alpha > 0$)
> - **$\beta$**: Parámetro de forma ($\beta > 0$)
> 
> Se usa principalmente en:
> 
> - Análisis de confiabilidad de componentes
> - Estudios de vida útil
> - Modelado de tiempos de falla
> - Análisis de supervivencia

### 8.9 Distribución Beta

> [!success] Descripción
> La distribución Beta es una familia de distribuciones continuas definidas en el intervalo [0, 1], lo que la hace ideal para modelar proporciones, probabilidades y tasas. Es extremadamente flexible y puede tomar formas muy diversas (uniforme, en forma de U, en forma de campana, sesgada) dependiendo de sus parámetros, por lo que es útil en análisis bayesiano y modelado de incertidumbre.

> [!info] Características
> 
> - Notación: $X \sim Beta(\alpha, \beta)$
> - Parámetros: $\alpha > 0$, $\beta > 0$ (ambos de forma)
> - Dominio: $0 < x < 1$ (solo toma valores entre 0 y 1)
> - Función de densidad: $$f(x) = \begin{cases} \frac{\Gamma(\alpha+\beta)}{\Gamma(\alpha)\Gamma(\beta)} x^{\alpha-1}(1-x)^{\beta-1} & \text{si } 0 < x < 1 \ 0 & \text{en otro caso} \end{cases}$$
> - Valor esperado: $E(X) = \frac{\alpha}{\alpha+\beta}$
> - Varianza: $Var(X) = \frac{\alpha\beta}{(\alpha+\beta)^2(\alpha+\beta+1)}$
> - Cuando $\alpha = \beta = 1$: se reduce a la distribución Uniforme(0, 1)
> - Cuando $\alpha = \beta$: la distribución es simétrica

> [!info] Requisitos / Datos necesarios
> Para aplicar la distribución Beta, se necesita:
> 
> - **$\alpha$**: Primer parámetro de forma ($\alpha > 0$)
> - **$\beta$**: Segundo parámetro de forma ($\beta > 0$)
> 
> Se usa comúnmente para modelar:
> 
> - Proporciones o porcentajes
> - Probabilidades
> - Tasas de éxito o supervivencia
> - Variables que están naturalmente acotadas entre 0 y 1

> [!example] Ejemplo aplicado
> **Problema**: La tasa de supervivencia de bacterias tras un tratamiento sigue una distribución Beta(2, 5). ¿Cuál es la probabilidad de que la tasa de supervivencia sea mayor al 20%?
> 
> **Solución**: $\alpha = 2$, $\beta = 5$, calcular $P(X > 0.20)$ $$P(X > 0.20) = \int_{0.20}^{1} \frac{\Gamma(7)}{\Gamma(2)\Gamma(5)} x^{1}(1-x)^{4} , dx$$
> 
> Este cálculo requiere integración numérica o software estadístico.
> 
> Tasa promedio de supervivencia: $E(X) = \frac{2}{2+5} = \frac{2}{7} \approx 0.286$ o 28.6%

---

## 9. Distribuciones Conjuntas

### 9.1 Caso Discreto

> [!info] Definición
> Sean $X$ e $Y$ dos variables aleatorias discretas. La función $f(x,y)$ es una **distribución de probabilidad conjunta** si cumple:
> 
> 1. $f(x,y) \geq 0$ para todo par $(x,y)$ (no negatividad)
> 2. $\sum_{x} \sum_{y} f(x,y) = 1$ (suma total igual a 1)
> 3. $P(X=x, Y=y) = f(x,y)$ (probabilidad del evento conjunto)
> 
> La función conjunta describe la probabilidad de que $X$ tome el valor $x$ **y simultáneamente** $Y$ tome el valor $y$.

### 9.2 Caso Continuo

> [!info] Definición
> Sean $X$ e $Y$ dos variables aleatorias continuas. La función $f(x,y)$ es una **distribución de densidad conjunta** si cumple:
> 
> 1. $f(x,y) \geq 0$ para todo par $(x,y)$ (no negatividad)
> 2. $\int_{-\infty}^{+\infty} \int_{-\infty}^{+\infty} f(x,y) , dx , dy = 1$ (volumen total igual a 1)
> 3. Para cualquier región $A$ en el plano: $$P((X,Y) \in A) = \iint_A f(x,y) , dx , dy$$
> 
> La densidad conjunta describe cómo se distribuye la probabilidad en el plano $(x,y)$.

### 9.3 Distribuciones Marginales

> [!info] Definición
> Las **distribuciones marginales** son las distribuciones de cada variable individual, obtenidas "sumando" o "integrando" sobre la otra variable:
> 
> **Caso discreto**:
> 
> - $f_X(x) = \sum_{y} f(x,y)$ (distribución marginal de $X$)
> - $f_Y(y) = \sum_{x} f(x,y)$ (distribución marginal de $Y$)
> 
> **Caso continuo**:
> 
> - $f_X(x) = \int_{-\infty}^{+\infty} f(x,y) , dy$ (densidad marginal de $X$)
> - $f_Y(y) = \int_{-\infty}^{+\infty} f(x,y) , dx$ (densidad marginal de $Y$)
> 
> Las marginales nos dan información sobre cada variable por separado, ignorando la otra.

### 9.4 Independencia

> [!info] Definición
> Dos variables aleatorias $X$ e $Y$ son **independientes** si y solo si su distribución conjunta se puede factorizar como el producto de sus marginales:
> 
> $$f(x,y) = f_X(x) \cdot f_Y(y) \quad \text{para todo par } (x,y)$$
> 
> **Interpretación**: Conocer el valor de una variable no proporciona información sobre la otra.
> 
> **Consecuencias de la independencia**:
> 
> - $P(X=x, Y=y) = P(X=x) \cdot P(Y=y)$ (caso discreto)
> - $E(XY) = E(X) \cdot E(Y)$
> - $Var(X+Y) = Var(X) + Var(Y)$
> - $Cov(X,Y) = 0$ (pero lo contrario no siempre es cierto)

### 9.5 Esperanza Conjunta

> [!info] Definición
> Para una función $g(X,Y)$ de dos variables aleatorias:
> 
> **Caso discreto**: $$E[g(X,Y)] = \sum_{x} \sum_{y} g(x,y) \cdot f(x,y)$$
> 
> **Caso continuo**: $$E[g(X,Y)] = \int_{-\infty}^{+\infty} \int_{-\infty}^{+\infty} g(x,y) \cdot f(x,y) , dx , dy$$
> 
> **Caso particular importante**: $$E(XY) = \sum_{x} \sum_{y} xy \cdot f(x,y) \quad \text{(discreto)}$$ $$E(XY) = \int_{-\infty}^{+\infty} \int_{-\infty}^{+\infty} xy \cdot f(x,y) , dx , dy \quad \text{(continuo)}$$

### 9.6 Covarianza

> [!info] Definición
> La **covarianza** mide la relación lineal entre dos variables aleatorias:
> 
> $$Cov(X,Y) = E[(X-\mu_X)(Y-\mu_Y)] = E(XY) - E(X)E(Y)$$
> 
> **Interpretación**:
> 
> - $Cov(X,Y) > 0$: Relación positiva (cuando $X$ aumenta, $Y$ tiende a aumentar)
> - $Cov(X,Y) < 0$: Relación negativa (cuando $X$ aumenta, $Y$ tiende a disminuir)
> - $Cov(X,Y) = 0$: No hay relación lineal (puede haber relación no lineal)

> [!success] Propiedades de la Covarianza
> 
> 1. $Cov(X, a) = 0$ (la covarianza con una constante es cero)
> 2. $Cov(X, X) = Var(X)$ (la covarianza de una variable consigo misma es su varianza)
> 3. $Cov(X, Y) = Cov(Y, X)$ (simetría)
> 4. $Cov(aX, bY) = ab \cdot Cov(X, Y)$ (factorización de constantes)
> 5. $Cov(X+a, Y+b) = Cov(X, Y)$ (invarianza ante traslaciones)
> 6. $Cov(X+Y, Z) = Cov(X, Z) + Cov(Y, Z)$ (linealidad)
> 7. $Var(X+Y) = Var(X) + Var(Y) + 2Cov(X,Y)$
> 8. Si $X$ e $Y$ son independientes, entonces $Cov(X,Y) = 0$ (pero no viceversa)

### 9.7 Coeficiente de Correlación

> [!info] Definición
> El **coeficiente de correlación** es una versión estandarizada de la covarianza que siempre está entre -1 y 1:
> 
> $$\rho_{X,Y} = \frac{Cov(X,Y)}{\sigma_X \sigma_Y}$$
> 
> donde $\sigma_X = \sqrt{Var(X)}$ y $\sigma_Y = \sqrt{Var(Y)}$ son las desviaciones estándar.
> 
> **Propiedades**:
> 
> - $-1 \leq \rho_{X,Y} \leq 1$
> - $\rho_{X,Y} = 1$: Relación lineal perfecta positiva ($Y = aX + b$ con $a > 0$)
> - $\rho_{X,Y} = -1$: Relación lineal perfecta negativa ($Y = aX + b$ con $a < 0$)
> - $\rho_{X,Y} = 0$: No hay relación lineal
> - $|\rho_{X,Y}|$ cercano a 1: Relación lineal fuerte
> - $|\rho_{X,Y}|$ cercano a 0: Relación lineal débil o inexistente
> 
> **Importante**: El coeficiente de correlación mide solo relaciones **lineales**. Puede ser cero incluso si existe una relación no lineal fuerte.

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
| Weibull      | $Weibull(\alpha,\beta)$ | $\alpha,\beta$ | $\alpha\beta x^{\beta-1}e^{-\alpha x^\beta}$                                          | Depende de parámetros         | Depende de parámetros                                  |
| Beta         | $Beta(\alpha,\beta)$    | $\alpha,\beta$ | $\frac{\Gamma(\alpha+\beta)}{\Gamma(\alpha)\Gamma(\beta)}x^{\alpha-1}(1-x)^{\beta-1}$ | $\frac{\alpha}{\alpha+\beta}$ | $\frac{\alpha\beta}{(\alpha+\beta)^2(\alpha+\beta+1)}$ |

> [!success] Relación entre distribuciones

| Distribución      | Descripción                                                       | Cuándo usar                                            |
| ----------------- | ----------------------------------------------------------------- | ------------------------------------------------------ |
| Geométrica        | Número de intentos hasta el **primer** éxito                      | Buscar el primer evento exitoso                        |
| Binomial Negativa | Número de intentos hasta el **k-ésimo** éxito                     | Buscar múltiples eventos exitosos                      |
| Binomial          | Número de éxitos en **n intentos fijos**                          | Contar éxitos en cantidad fija de ensayos              |
| Poisson           | Número de eventos por unidad (tiempo/espacio/área)                | Contar eventos raros en un intervalo continuo          |
| Exponencial       | Tiempo entre eventos consecutivos de un proceso Poisson           | Modelar tiempos de espera                              |
| Gamma             | Tiempo hasta el k-ésimo evento en un proceso Poisson              | Suma de k variables exponenciales                      |
| Chi-cuadrado      | Suma de cuadrados de variables normales estándar independientes   | Pruebas de bondad de ajuste, independencia             |
| Normal Estándar   | Estandarización de cualquier variable normal                      | Cálculo de probabilidades usando tablas                |
| t-Student         | Distribución de la media muestral cuando $\sigma$ es desconocida  | Inferencia con muestras pequeñas                       |
| Hipergeométrica   | Número de éxitos en muestra **sin reemplazo** de población finita | Muestreo sin reemplazo (probabilidades cambian)        |
| Uniforme          | Todos los valores en un intervalo son igualmente probables        | Cuando no hay preferencia por ningún valor en un rango |
| Beta              | Variable acotada entre 0 y 1 (proporciones, probabilidades)       | Modelar tasas, proporciones, o variables en [0,1]      |
| Weibull           | Análisis de confiabilidad con tasas de falla variables            | Estudios de vida útil, fallas de materiales            |

> [!tip] Guía rápida de selección de distribución

**Para variables DISCRETAS**:

- ¿Número de éxitos en n ensayos fijos? → **Binomial**
- ¿Ensayos hasta el primer éxito? → **Geométrica**
- ¿Ensayos hasta el k-ésimo éxito? → **Binomial Negativa**
- ¿Contando eventos raros en tiempo/espacio? → **Poisson**
- ¿Muestreo SIN reemplazo de población finita? → **Hipergeométrica**

**Para variables CONTINUAS**:

- ¿Datos distribuidos simétricamente alrededor de la media? → **Normal**
- ¿Todos los valores igualmente probables en un rango? → **Uniforme**
- ¿Tiempo hasta un evento (sin memoria)? → **Exponencial**
- ¿Tiempo hasta k eventos? → **Gamma**
- ¿Proporción o tasa entre 0 y 1? → **Beta**
- ¿Confiabilidad o vida útil? → **Weibull**
- ¿Pruebas estadísticas con muestras pequeñas? → **t-Student**
- ¿Pruebas de bondad de ajuste o independencia? → **Chi-cuadrado**

> [!warning] Recordatorios importantes

**Conceptos fundamentales**:

1. Las funciones de probabilidad/densidad SIEMPRE son no negativas
2. La suma/integral de una función de probabilidad/densidad siempre es 1
3. Para variables continuas: $P(X = x) = 0$ (probabilidad en un punto específico)
4. La varianza NUNCA es negativa
5. El valor esperado SÍ puede ser negativo (si la variable toma valores negativos)

**Propiedades clave**:

- $E(aX + b) = aE(X) + b$ (linealidad de la esperanza)
- $Var(aX + b) = a^2 Var(X)$ (la constante aditiva no afecta la varianza)
- $E(X + Y) = E(X) + E(Y)$ (siempre, incluso si no son independientes)
- $Var(X + Y) = Var(X) + Var(Y)$ (SOLO si son independientes)
- Si $X$ e $Y$ son independientes: $E(XY) = E(X)E(Y)$ y $Cov(X,Y) = 0$

**Diferencias críticas**:

- **Binomial vs Hipergeométrica**: Binomial usa muestreo CON reemplazo (probabilidades constantes), Hipergeométrica usa muestreo SIN reemplazo (probabilidades cambian)
- **Poisson vs Exponencial**: Poisson cuenta EVENTOS en tiempo fijo, Exponencial mide TIEMPO entre eventos
- **Normal vs t-Student**: Normal cuando $\sigma$ es conocida o n grande, t-Student cuando $\sigma$ es desconocida y n pequeña
- **Geométrica vs Binomial Negativa**: Geométrica busca el PRIMER éxito (k=1), Binomial Negativa busca el k-ÉSIMO éxito

**Verificaciones antes de aplicar un modelo**:

- ¿Los ensayos son independientes?
- ¿La probabilidad es constante?
- ¿Hay reemplazo o no?
- ¿La población es finita o infinita?
- ¿Se cuenta eventos o se mide tiempo?
- ¿Cuál es el número fijo: ensayos o éxitos?

---

## 11. Fórmulas Útiles Adicionales

> [!note] Fórmulas de probabilidad para distribución normal

**Estandarización**: $$Z = \frac{X - \mu}{\sigma}$$

**Probabilidades comunes** (Regla empírica):

- $P(\mu - \sigma \leq X \leq \mu + \sigma) \approx 0.68$
- $P(\mu - 2\sigma \leq X \leq \mu + 2\sigma) \approx 0.95$
- $P(\mu - 3\sigma \leq X \leq \mu + 3\sigma) \approx 0.997$

**Cálculo de probabilidades**: $$P(a < X < b) = \Phi\left(\frac{b-\mu}{\sigma}\right) - \Phi\left(\frac{a-\mu}{\sigma}\right)$$

donde $\Phi(z)$ es la función de distribución acumulada de la normal estándar.

> [!note] Fórmulas para distribuciones conjuntas

**Probabilidad condicional**: $$f_{X|Y}(x|y) = \frac{f(x,y)}{f_Y(y)}$$

**Esperanza condicional**: $$E(X|Y=y) = \sum_x x \cdot f_{X|Y}(x|y) \quad \text{(discreto)}$$ $$E(X|Y=y) = \int_{-\infty}^{+\infty} x \cdot f_{X|Y}(x|y) , dx \quad \text{(continuo)}$$

**Varianza de suma**: $$Var(aX + bY) = a^2Var(X) + b^2Var(Y) + 2abCov(X,Y)$$

**Para variables independientes**: $$Var(X_1 + X_2 + \cdots + X_n) = Var(X_1) + Var(X_2) + \cdots + Var(X_n)$$

> [!note] Aproximaciones útiles

**Binomial a Normal** (cuando $n$ es grande): Si $X \sim B(n,p)$ y $np \geq 5$ y $n(1-p) \geq 5$: $$X \approx N(np, \sqrt{np(1-p)})$$

**Binomial a Poisson** (cuando $n$ es grande y $p$ es pequeña): Si $X \sim B(n,p)$ y $n \geq 20$, $p \leq 0.05$, y $np < 10$: $$X \approx Poisson(\lambda = np)$$

**Poisson a Normal** (cuando $\lambda$ es grande): Si $X \sim Poisson(\lambda)$ y $\lambda \geq 10$: $$X \approx N(\lambda, \sqrt{\lambda})$$

> [!warning] Importante
> Recuerda que estas fórmulas y distribuciones son herramientas para modelar la realidad. Siempre verifica que se cumplan los supuestos del modelo antes de aplicarlo. Un modelo incorrecto puede llevar a conclusiones erróneas, incluso si los cálculos están bien hechos.
