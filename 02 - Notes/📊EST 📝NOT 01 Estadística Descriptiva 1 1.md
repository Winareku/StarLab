---
tags:
  - 📊EST
  - 📝NOT
cssclasses:
  - center-titles
---

# Estadística Descriptiva
by Deepseek

---

## 1. Introducción a la Estadística

> [!info] Definición
> La **Estadística** es la ciencia que proporciona las herramientas para recolectar, transformar, interpretar y analizar datos para obtener información para la toma de decisiones. Trabaja fundamentalmente con la incertidumbre y la aleatoriedad.

> [!success] Aplicaciones de la Estadística
> - Control de calidad en la industria
> - Marketing y estudios de opinión
> - Bioestadística y salud pública
> - Machine Learning y Big Data

> [!example] Ejemplo histórico
> Desde la antigüedad (Egipto, China, Roma) se realizaban censos para registrar posesiones, producción y población con fines tributarios y administrativos.

> [!quote] La estadística se clasifica principalmente en tres grandes áreas:
> |**Tipo**|**Descripción**|
|---|---|
|**Estadística Descriptiva**|Se enfoca en recopilar, organizar, presentar y resumir un conjunto de datos para facilitar su comprensión y análisis.|
|**Probabilidad**|Modela cómo pueden suceder eventos inciertos y busca encontrar el orden dentro del azar.|
|**Estadística Inferencial**|Permite proyectar o inferir las propiedades de una población completa a partir del análisis de una muestra.|

---

## 2. Conceptos Básicos

> [!info] Población vs. Muestra
> La correcta distinción entre estos conceptos es clave para la estadística inferencial.

| **Concepto**  | **Descripción**                                                                               | **Característica Numérica**                                                                            |
| ------------- | --------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| **Población** | Es el conjunto completo y bien definido de todos los elementos (N) que son objeto de estudio. | **Parámetro**: Cantidad numérica calculada a partir de _toda_ la población.                            |
| **Muestra**   | Es un subconjunto (n) de unidades de investigación extraídas de la población objetivo.        | **Estadístico (o Estimador)**: Cantidad numérica calculada a partir de los elementos de una _muestra_. |

> [!warning] Diferencia clave
> La estadística trabaja con **incertidumbre**, a diferencia de las matemáticas puras que son deterministas.

---

## 3. Variables y Datos

### 3.1 Tipos de Variables

| **Tipo Principal** | **Subtipo**  | **Descripción**                                                                | **Ejemplos**                                     |
| ------------------ | ------------ | ------------------------------------------------------------------------------ | ------------------------------------------------ |
| **Cualitativas**   | **Nominal**  | No cuantifican, solo nombran categorías sin un orden inherente.                | Género, Tipo de Música, Provincia de Nacimiento. |
|                    | **Ordinal**  | Representan categorías con un orden o jerarquía establecida.                   | Nivel socioeconómico, grado de satisfacción.     |
| **Cuantitativas**  | **Discreta** | Resultan de un proceso de conteo y toman valores enteros.                      | Número de hijos, número de materias aprobadas.   |
|                    | **Continua** | Resultan de un proceso de medición y pueden tomar cualquier valor en un rango. | Peso, estatura, temperatura.                     |

> [!info] Registro de datos
> Los datos se registran típicamente en formato tabular:
> - **Filas**: registros/individuos
> - **Columnas**: variables

---

## 4. Tablas de Frecuencias

### 4.1 Tipos de Frecuencias

| **Tipo de Frecuencia** | **Símbolo** | **Descripción**                                                                 |
| ---------------------- | ----------- | ------------------------------------------------------------------------------- |
| **Absoluta**           | $f_i$       | Número total de observaciones que pertenecen a una clase.                       |
| **Absoluta Acumulada** | $F_i$       | Suma de las frecuencias absolutas desde la primera clase hasta la clase actual. |
| **Relativa**           | $f_i / n$   | Proporción (o porcentaje) de observaciones en una clase respecto al total.      |
| **Relativa Acumulada** | $F_i / n$   | Proporción (o porcentaje) acumulada de observaciones hasta la clase actual.     |

> [!success] Construcción de Clases (Variables Cuantitativas)
> 
> Para agrupar datos cuantitativos, se definen intervalos o clases. Un método común es:
> 
> 1. **Determinar el número de clases (k)**: Generalmente entre 5 y 12.
>     
> 2. **Calcular el Rango (R)**: $R = Valor_{máximo} - Valor_{mínimo}$.
>     
> 3. **Calcular el Ancho de Clase (A)**: $A = R / k$.
>     
> 4. **Clases**: [MIN, MIN+Ancho), [MIN+Ancho, MIN+2Ancho), ...

---

## 5. Representación Gráfica

### 5.1 Tipos de Gráficos por Variable
| **Tipo de Gráfico**         | **Variable Adecuada**           | **Descripción**                                                                              |
| --------------------------- | ------------------------------- | -------------------------------------------------------------------------------------------- |
| **Gráfico de Barras**       | Cualitativa (Nominal / Ordinal) | Muestra las frecuencias de cada categoría en barras separadas.                               |
| **Gráfico de Pastel**       | Cualitativa (Nominal)           | Divide un círculo en sectores que representan porcentajes.                                   |
| **Histograma**              | Cuantitativa                    | Muestra la distribución de frecuencias con barras juntas que representan intervalos.         |
| **Polígono de Frecuencias** | Cuantitativa                    | Une los puntos medios (marcas de clase) de la parte superior de las barras de un histograma. |
| **Ojiva**                   | Cuantitativa / Ordinal          | Gráfico de línea que muestra la frecuencia _acumulada_.                                      |

---

## 6. Medidas de Tendencia Central

| Medida | Definición | Fórmula (datos no agrupados) |
|--------|------------|------------------------------|
| **Media** | Promedio de todos los valores | $\bar{x} = \frac{\sum x_i}{n}$ |
| **Mediana** | Valor que divide la muestra en dos partes iguales | Valor central en datos ordenados |
| **Moda** | Valor que más se repite | Valor con mayor frecuencia |

> [!info] Relación con la simetría
> En distribuciones simétricas: Media ≈ Mediana ≈ Moda

---

## 7. Medidas de Dispersión

### 7.1 Principales Medidas

| Medida                       | Fórmula                             | Interpretación                             |
| ---------------------------- | ----------------------------------- | ------------------------------------------ |
| **Rango**                    | $$MAX - MIN$$                       | Amplitud total de los datos                |
| **Varianza (s²)**            | $\frac{\sum(x_i - \bar{x})^2}{n-1}$ | Dispersión cuadrática promedio             |
| **Desviación Estándar (s)**  | $\sqrt{s^2}$                        | Dispersión en unidades originales          |
| **Coeficiente de Variación** | $CV = \frac{s}{\bar{x}}$            | Dispersión relativa (para comparar grupos) |

> [!warning] Población vs Muestra
> - **Población**: $\sigma^2 = \frac{\sum(x_i - \mu)^2}{N}$
> - **Muestra**: $s^2 = \frac{\sum(x_i - \bar{x})^2}{n-1}$

---

## 8. Medidas de Posición

### 8.1 Cuantiles

| Medida | Orden | Divide los datos en |
|--------|-------|---------------------|
| **Cuartiles** | Q₁, Q₂, Q₃ | 4 partes iguales |
| **Deciles** | D₁, D₂, ..., D₉ | 10 partes iguales |
| **Percentiles** | P₁, P₂, ..., P₉₉ | 100 partes iguales |

> [!success] Relaciones importantes
> - Q₂ = Mediana = P₅₀
> - Q₁ = P₂₅, Q₃ = P₇₅
> - Rango Intercuartílico (IQR) = Q₃ - Q₁

---

## 9. Gráficos de Caja y Bigotes

> [!info] Componentes de un Gráfico de Caja
> 
> - La **caja** está delimitada por el primer cuartil ($Q_1$) y el tercer cuartil ($Q_3$). Su longitud es el Rango Intercuartílico (IQR).
>     
> - La **línea** dentro de la caja marca la Mediana ($Q_2$).
>     
> - Los **bigotes** se extienden desde la caja hasta los valores mínimo y máximo que no son considerados atípicos.
>     
> - Los **valores atípicos (outliers)** son puntos que se encuentran más allá de $1.5 \times IQR$ por debajo de $Q_1$ o por encima de $Q_3$.
>     

> [!example] Interpretación
> Permite visualizar simultáneamente: tendencia central, dispersión, simetría y valores atípicos.

---

## 10. Medidas de Forma

> [!bug] 10.1 Asimetría (Sesgo)
> Mide el grado de simetría de la distribución. Puede ser positiva (cola a la derecha) o negativa (cola a la izquierda). En distribuciones simétricas, la media y la mediana coinciden.
> - **Simétrica**: Media = Mediana
> - **Asimetría positiva**: Cola a la derecha, Media > Mediana
> - **Asimetría negativa**: Cola a la izquierda, Media < Mediana

> [!danger] 10.2 Curtosis (Apuntamiento)
> Mide qué tan "puntiaguda" o "achatada" es una distribución en comparación con una distribución normal.
> - **Mesocúrtica**: Distribución normal (Kᵤ ≈ 3)
> - **Leptocúrtica**: Más apuntada (Kᵤ > 3)
> - **Platicúrtica**: Más aplanada (Kᵤ < 3)

---

## 11. Estadísticos para Datos Agrupados

| Estadístico  | Fórmula                                                                        |
| ------------ | ------------------------------------------------------------------------------ |
| **Media**    | $\bar{x} = \frac{\sum f_i m_i}{n}$                                             |
| **Varianza** | $s^2 = \frac{\sum f_i (m_i - \bar{x})^2}{n-1}$                                 |
| **Mediana**  | $\tilde{X} = L_i + \frac{\frac{n}{2} - F_{i-1}}{f_i} \cdot a_i$                |
| **Moda**     | $Mo = L_i + \frac{f_i - f_{i-1}}{(f_i - f_{i-1}) + (f_i - f_{i+1})} \cdot a_i$ |

> [!note] Donde:
> - mᵢ: marca de clase
> - fᵢ: frecuencia absoluta
> - Fᵢ: frecuencia acumulada
> - Lᵢ: límite inferior del intervalo
> - aᵢ: ancho del intervalo

---

> [!success] Aplicación práctica
> Estos conceptos son fundamentales para el análisis exploratorio de datos, la toma de decisiones basada en evidencia y la inferencia estadística.
