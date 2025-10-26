---
tags:
  - 📊EST
  - 📝NOT
cssclasses:
  - center-titles
---

# [[📊EST 🏫MPR 01 Estadística Descriptiva.pdf|Unidad 1: Estadística Descriptiva]]

---

## 1. Introducción a la Estadística

> [!info] Definición
> La **Estadística** es la ciencia que proporciona las herramientas para recolectar, transformar, interpretar y analizar datos para obtener información para la toma de decisiones. Trabaja fundamentalmente con la incertidumbre y la aleatoriedad.
> $$\text{Aleatoriedad} \neq \text{Determinismo}$$

> [!info] Tener en cuenta que:
> La Estadística transforma datos en información para tomar decisiones, pero no es una rama de las matemáticas que estudie exclusivamente datos determinísticos.

> [!success] Aplicaciones de la Estadística
> - Control de calidad en la industria
> - Marketing y estudios de opinión
> - Bioestadística y salud pública
> - Machine Learning y Big Data

> [!example] Ejemplo histórico
> Desde la antigüedad (Egipto, China, Roma) se realizaban censos para registrar posesiones, producción y población con fines tributarios y administrativos.

> [!quote] La estadística se clasifica principalmente en tres grandes áreas:

| **Tipo**                    | **Descripción**                                                                                                                                                                                                                                                                                |
| --------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Estadística Descriptiva** | - Es la parte de la estadística que nos permite comprender un conjunto de datos.<br>- Permite conocer las tendencias y homogeneidad dentro de un conjunto de datos.<br>- Se enfoca en recopilar, organizar, presentar y resumir un conjunto de datos para facilitar su comprensión y análisis. |
| **Probabilidad**            | Modela cómo pueden suceder eventos inciertos y busca encontrar el orden dentro del azar.                                                                                                                                                                                                       |
| **Estadística Inferencial** | Permite proyectar o inferir las propiedades de una población completa a partir del análisis de una muestra.                                                                                                                                                                                    |


> [!info] Tener en cuenta que:
> La Estadística Inferencial permite realizar predicciones, análisis de pruebas de hipótesis y estudiar correlaciones.

---

## 2. Conceptos Básicos

> [!info] Población vs. Muestra
> La correcta distinción entre estos conceptos es clave para la estadística inferencial.

| **Concepto**  | **Descripción**                                                                                       | **Característica Numérica**                                                                            |
| ------------- | ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| **Población** | Es el conjunto completo y bien definido de N **unidades de investigación** que son objeto de estudio. | **Parámetro**: Cantidad numérica calculada a partir de _toda_ la población.                            |
| **Muestra**   | Es un subconjunto de n **observaciones** de la población objetivo.                                    | **Estadístico (o Estimador)**: Cantidad numérica calculada a partir de los elementos de una _muestra_. |

> [!warning] Diferencia clave
> La estadística trabaja con **incertidumbre**, a diferencia de las matemáticas puras que son deterministas.

---

## 3. Variables y Datos
> [!success] Definición de Variable
> Es cualquier característica que se registra o mide sobre cualquier entidad.

> [!info] Tener en cuenta que:
> Un dato es el valor que toma una variable para un individuo (caso) específico.

### 3.1 Tipos de Variables

| **Tipo Principal** | **Subtipo**  | **Descripción**                                                                | **Ejemplos**                                     |
| ------------------ | ------------ | ------------------------------------------------------------------------------ | ------------------------------------------------ |
| **Cualitativas**   | **Nominal**  | No cuantifican, solo nombran categorías sin un orden inherente.                | Género, Tipo de Música, Provincia de Nacimiento. |
|                    | **Ordinal**  | Representan categorías con un orden o jerarquía establecida.                   | Nivel socioeconómico, grado de satisfacción.     |
| **Cuantitativas**  | **Discreta** | Resultan de un proceso de conteo y toman valores enteros.                      | Número de hijos, número de materias aprobadas.   |
|                    | **Continua** | Resultan de un proceso de medición y pueden tomar cualquier valor en un rango. | Peso, estatura, temperatura.                     |

> [!info] Tener en cuenta que:
> Las variables discretas provienen de procesos de contar, mientras que las continuas provienen de procesos de medir.

> [!warning] Diferencia clave:
> Si existe un orden en las categorías (ej: nivel de satisfacción 1 es inferior al nivel 2), la variable es **cualitativa ordinal**, no nominal.

> [!info] Registro de datos
> Los datos son los valores que toman las variables y se registran típicamente en formato tabular:
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

> [!info] Tener en cuenta que:
> La división de la frecuencia absoluta para el total de datos da como resultado la frecuencia relativa.

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

> [!info] Tener en cuenta que:
> La **Ojiva** es un gráfico que en el eje X muestra la marca de clase y en el eje Y presenta la frecuencia relativa acumulada.

---

## 6. Medidas de Tendencia Central

![[📊EST 📝NOT 01 Estadística Descriptiva - Image 01.png]]
> [!info] Descripción
> Indican valores con respecto a los que los datos parecen agruparse: Media, mediana y moda

| Medida      | Definición                                        | Fórmula (datos no agrupados)     |
| ----------- | ------------------------------------------------- | -------------------------------- |
| **Media**   | Promedio de todos los valores                     | $\bar{x} = \frac{\sum x_i}{n}$   |
| **Mediana** | Valor que divide la muestra en dos partes iguales | Valor central en datos ordenados |
| **Moda**    | Valor que más se repite                           | Valor con mayor frecuencia       |

> [!info] Relación con la simetría
> En distribuciones simétricas: Media ≈ Mediana ≈ Moda

> [!example] Ejemplo de cálculo de mediana:
> Para los datos: `2,5 3,6 4,7 8,8 6,2 5,4`
> 1. Ordenar: `2,5 3,6 4,7 5,4 6,2 8,8`
> 2. Como n=6 (par), mediana = promedio de los valores centrales (4,7 y 5,4)
> 3. Mediana = (4,7 + 5,4)/2 = 5,05

---

## 7. Medidas de Dispersión

![[📊EST 📝NOT 01 Estadística Descriptiva - Image 02.png]]
> [!info] Descripción
> Indican la mayor o menor concentración de los datos con respecto a las medidas de centralización: Desviación típica, coeficiente de variación, rango, varianza.

### 7.1 Principales Medidas

| Medida                           | Fórmula                             | Interpretación                             |
| -------------------------------- | ----------------------------------- | ------------------------------------------ |
| **Rango (R)**                    | $$X_{(n)} - X_{(1)}$$               | Amplitud total de los datos                |
| **Varianza (s²)**                | $\frac{\sum(x_i - \bar{x})^2}{n-1}$ | Dispersión cuadrática promedio             |
| **Desviación Estándar (s)**      | $\sqrt{s^2}$                        | Dispersión en unidades originales          |
| **Coeficiente de Variación (V)** | $V = \frac{s}{\bar{x}}$             | Dispersión relativa (para comparar grupos) |

> [!warning] Población vs Muestra
> 
> | **Población**                              | **Muestra**                                 |
> | ------------------------------------------ | ------------------------------------------- |
> | $$\sigma^2 = \frac{\sum(x_i - \mu)^2}{N}$$ | $$s^2 = \frac{\sum(x_i - \bar{x})^2}{n-1}$$ |

> [!info] Tener en cuenta que:
> La desviación estándar siempre será ≥ 0, ya que es la raíz cuadrada positiva de la varianza.

---

## 8. Medidas de Posición

![[📊EST 📝NOT 01 Estadística Descriptiva - Image 03.png|100%]]
> [!info] Descripción
> Dividen un conjunto ordenado de datos en grupos con la misma cantidad de individuos: cuantiles, percentiles, cuartiles, deciles,...

### 8.1 Cuantiles

| Medida          | Orden            | Divide los datos en |
| --------------- | ---------------- | ------------------- |
| **Cuartiles**   | Q₁, Q₂, Q₃       | 4 partes iguales    |
| **Deciles**     | D₁, D₂, ..., D₉  | 10 partes iguales   |
| **Percentiles** | P₁, P₂, ..., P₉₉ | 100 partes iguales  |

> [!success] Relaciones importantes
> - Q₂ = Mediana = P₅₀
> - Q₁ = P₂₅, Q₃ = P₇₅
> - Rango Intercuartílico (IQR) = Q₃ - Q₁

> [!info] Tener en cuenta que:
> - El percentil 75 es equivalente al tercer cuartil (Q₃)
> - El quintil de una muestra acumula el 20% de las observaciones
> - El primer cuartil es una medida de posición, no de dispersión

---

## 9. Gráficos de Caja y Bigotes

> [!info] Componentes de un Gráfico de Caja
> ![[Pasted image 20251025133739.png|256]]
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
![[📊EST 📝NOT 01 Estadística Descriptiva - Image 04.png]]

> [!bug] 10.1 Asimetría (Sesgo)
> Mide el grado de simetría de la distribución. Puede ser positiva (cola a la derecha) o negativa (cola a la izquierda). En distribuciones simétricas, la media y la mediana coinciden.
> - **Simétrica**: Media = Mediana
> - **Asimetría positiva**: Cola a la derecha, Mediana < Media
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

> [!info] Tener en cuenta que:
> La Estadística Descriptiva utiliza principalmente tablas, medidas y gráficos para analizar tendencias, variabilidad y homogeneidad dentro de un conjunto de datos.