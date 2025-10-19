---
tags:
- 📊EST
- 📝NOT 
---

# Probabilidad y Teoremas Fundamentales
by Gemini

---

## 1. Conceptos Fundamentales de Probabilidad

> [!quote] Definición de Probabilidad
> 
> Es una medida que cuantifica la posibilidad de que ocurra un evento cualquiera1.
> 
> * Se utiliza para describir la incertidumbre asociada con fenómenos aleatorios2.
> 
> * Se expresa numéricamente entre 0 (imposibilidad de ocurrencia) y 1 (certeza absoluta de ocurrencia)3.

> [!info] Utilidad de la Probabilidad
> 
> La probabilidad sirve para cuantificar la incertidumbre y es fundamental para tomar decisiones informadas, predecir la frecuencia de eventos futuros, y evaluar riesgos en diversos contextos (financieros, salud, ingeniería, etc.)4.

### 1.1 Experimentos y Eventos

|**Concepto**|**Definición**|**Característica**|
|---|---|---|
|**Experimento Determinístico**|Procedimiento en el que el resultado se conoce de antemano5.|Resultado siempre predecible6.|
|**Experimento Aleatorio**|Procedimiento cuyo resultado no se puede determinar de antemano, pero sí el conjunto de posibles resultados7.|Debe poderse reproducir o repetir en condiciones similares (aleatoriedad)8.|

> [!tip] Elementos Clave
> 
> * Espacio Muestral (S o Ω): Conjunto de todos los resultados posibles de un experimento aleatorio9.
> 
> * Evento (A, B, etc.): Cualquier subconjunto del espacio muestral10.

---

## 2. Clasificación y Asignación de Probabilidad

### 2.1 Clasificación del Espacio Muestral

El espacio muestral ($S$) se clasifica según la naturaleza del experimento11.

|**Clasificación**|**Tipo**|**Descripción**|**Ejemplo**|
|---|---|---|---|
|**Discreto**|Finito|El número de resultados posibles es contable y limitado12121212.|Lanzar un dado y observar el resultado ($S=\{1, 2, 3, 4, 5, 6\}$)13.|
|**Discreto**|Infinito|El número de resultados es contable, pero ilimitado14.|Lanzar un dado y contar intentos hasta obtener un 615.|
|**Continuo**|Infinito|Los resultados pueden tomar cualquier valor en un intervalo, es un conjunto incontable16.|Medir el peso en gramos de un artículo elegido al azar17.|

### 2.2 Métodos de Asignación de Probabilidades

|**Método**|**Concepto**|**Fórmula Clásica/Base**|
|---|---|---|
|**Clásica o de Laplace**|Se aplica cuando los eventos elementales son **equiprobables**. Es la razón entre casos favorables y casos posibles18.||$$\boldsymbol{P(A) = \frac{n(A)}{n(S)}}$$|19|
|**Empírica o Frecuentista**|Es la proporción de veces que un evento ocurrió respecto al total de intentos realizados (basada en datos históricos)20.||$$\boldsymbol{P(A) \approx \frac{\text{Frecuencia del evento A}}{\text{Total de ensayos}}}$$|21|
|**Modelos Matemáticos**|Determinación de la probabilidad mediante la construcción de modelos de distribución (e.g., distribución normal, binomial)22.|Basado en la teoría de distribuciones 23|

---

## 3. Métodos de Conteo y Axiomas

### 3.1 Métodos de Conteo

Estos métodos son esenciales para calcular la cardinalidad ($n(A)$ o $n(S)$) requerida en la Regla de Laplace24.

|**Método**|**Definición**|**Orden Importa**|**Fórmula para r de n**|
|---|---|---|---|
|**Regla de Multiplicación**|Multiplicar el número de resultados para cada etapa secuencial25.|No Aplica||$$S = n_1 \cdot n_2 \cdots n_x$$|26|
|**Permutaciones**|Arreglo de objetos donde el **orden** de selección es relevante27.|Sí||$$\boldsymbol{P(n, r) = \frac{n!}{(n-r)!}}$$|28|
|**Combinaciones**|Selección de objetos donde el **orden** de selección no importa29.|No||$$\boldsymbol{C(n, r) = \binom{n}{r} = \frac{n!}{r!(n-r)!}}$$|30|

> [!example] Ejemplo de Permutación
> 
> Elegir una directiva (Presidente, Vicepresidente, Tesorero) de 40 estudiantes (n=40,r=3). El orden importa por los cargos.
> 
> $$P(40, 3) = \frac{40!}{(40-3)!} = 59,280$$
> 
> directivas posibles31.

### 3.2 Axiomas de Probabilidad

La función de probabilidad $P(A)$ debe cumplir con las siguientes reglas (Axiomas)32:

1. Axioma de no negatividad: La probabilidad de cualquier evento es mayor o igual a cero:
    
    $$\boldsymbol{P(A) \geq 0}$$
    
    33
    
2. Axioma de la certeza: La probabilidad del espacio muestral completo (S) es uno:
    
    $$\boldsymbol{P(S) = 1}$$
    
    34
    
3. Axioma de la adición (para eventos mutuamente excluyentes): Si A1​∩A2​=∅, la probabilidad de su unión es la suma de sus probabilidades:
    
    $$\boldsymbol{P(A_1 \cup A_2) = P(A_1) + P(A_2)}$$
    
    35
    

---

## 4. Probabilidad Compuesta y Teoremas

### 4.1 Probabilidad Condicional y Eventos Independientes

> [!quote] Probabilidad Condicional
> 
> La probabilidad de un evento A dado que el evento B ya ha ocurrido.
> 
> $$\boldsymbol{P(A | B) = \frac{P(A \cap B)}{P(B)}}, \quad P(B) \neq 0$$
> 
> 36

> [!info] Eventos Independientes
> 
> Dos eventos A y B son independientes si la ocurrencia de uno no influye en la probabilidad del otro37.
> 
> * Se define si: P(A∣B)=P(A) y P(B∣A)=P(B)38.
> 
> * También se cumple si: P(A∩B)=P(A)P(B)39.

### 4.2 Teorema de la Probabilidad Total

Permite calcular la probabilidad de un evento $A$ cuando este depende de un conjunto de eventos mutuamente excluyentes ($B_i$) que forman una partición del espacio muestral40404040.

> [!quote] Fórmula de la Probabilidad Total
> 
> Sean B1​,B2​,…,Bk​ una partición de Ω. La probabilidad de un evento A es:
> 
> $$\boldsymbol{P(A) = \sum_{i=1}^{k} P(B_i) P(A | B_i)}$$
> 
> 41

### 4.3 Teorema de Bayes

Se utiliza para calcular la probabilidad condicional de un evento de la partición ($B_r$) dado que se ha observado un evento $A$ (permite actualizar la probabilidad _a priori_ con nueva evidencia)42.

> [!quote] Fórmula del Teorema de Bayes
> 
> Para cualquier evento de la partición Br​:
> 
> $$\boldsymbol{P(B_r | A) = \frac{P(B_r) P(A | B_r)}{\sum_{i=1}^{k} P(B_i) P(A | B_i)}}$$
> 
> 43

> [!tip] Interpretación
> 
> * P(Br​): Probabilidad a priori (probabilidad inicial de Br​)44.
> 
> * P(A∣Br​): Verosimilitud (probabilidad de la evidencia A dado Br​)45.
> 
> * P(Br​∣A): Probabilidad a posteriori (probabilidad actualizada de Br​ después de ver A)46.
> 
> El documento generado es: 📊EST 📝NOT 02 Probabilidad.md