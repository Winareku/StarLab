---
banner: "https://images.unsplash.com/photo-1520076794559-6a1229412a42?ixlib=rb-4.1.0&q=85&fm=jpg&crop=entropy&cs=srgb&w=4800"
fecha: 2025-10-10
tags:
  - 📊EST
  - 📝NOT
---
---
# Unidad 1: Estadística Descriptiva

## 1. Introducción a la Estadística

### Definición y Propósito

- **Estadística**: Ciencia que proporciona herramientas para recolectar, transformar, interpretar y analizar datos para la toma de decisiones
- **Enfoque**: Trabaja con incertidumbre y aleatoriedad (≠ determinismo matemático)
- **Aplicaciones**: Salud, industria, economía, políticas públicas, educación, servicios

### Evolución Histórica

- Orígenes en civilizaciones antiguas (censos, impuestos)
- Actualmente fusionada con informática → Machine Learning, Bioestadística, Deep Learning
- Era del Big Data: facilidad en recopilación y análisis de datos

## 2. Clasificación de la Estadística

| **Rama**         | **Propósito**                                    | **Características**                                               |
| ---------------- | ------------------------------------------------ | ----------------------------------------------------------------- |
| **Descriptiva**  | Comprender y describir conjuntos de datos        | Tendencias, homogeneidad, herramientas: tablas, gráficos, medidas |
| **Probabilidad** | Modelar eventos con incertidumbre                | Orden dentro del azar, leyes de fenómenos                         |
| **Inferencial**  | Inferir propiedades poblacionales desde muestras | Proyección de resultados                                          |

## 3. Conceptos Fundamentales

### Terminología Básica

- **Población objetivo**: Conjunto bien definido de N elementos
- **Muestra**: Subconjunto de n unidades (n < N)
- **Unidad de investigación**: Elementos con características medibles
- **Observación**: Valores específicos en la muestra

### Parámetros vs Estimadores

- **Parámetro**: Cantidad numérica calculada de la población
- **Estimador**: Cantidad numérica calculada de la muestra

## 4. Variables y Tipos de Datos

### Clasificación de Variables

```jsx
Variables
├── Cuantitativas (Numéricas)
│ ├── Discretas (procesos de conteo)
│ └── Continuas (procesos de medición)
└── Cualitativas (Categóricas)
  ├── Ordinales (con orden)
  └── Nominales (sin orden)
```

### Ejemplos por Tipo

- **Discretas**: Número de hijos, goles en partido
- **Continuas**: Litros de agua, temperatura corporal
- **Ordinales**: Grado de satisfacción, nivel socioeconómico
- **Nominales**: Barrio de residencia, grupo sanguíneo

## 5. Organización de Datos

### Formato Estándar

- **Filas**: Registros individuales (entidades)
- **Columnas**: Variables (características)

### Plataformas de Registro

- Excel, Google Sheets, CSV, Bases de datos SQL

## 6. Tablas de Frecuencias

### Tipos de Frecuencias

| Tipo | Notación | Fórmula | Propiedad |
| --- | --- | --- | --- |
| Absoluta | fᵢ | Conteo directo | ∑fᵢ = n |
| Absoluta Acumulada | Fᵢ | Fᵢ = f₁ + ... + fᵢ | Fₖ = n |
| Relativa | fᵢ/n | fᵢ ÷ n | ∑(fᵢ/n) = 1 |
| Relativa Acumulada | Fᵢ/n | Fᵢ ÷ n | Fₖ = 1 |

### Aplicación por Tipo de Variable

| Tipo Variable | F. Absoluta | F. Acumulada | F. Relativa | F. Rel. Acumulada |
| --- | --- | --- | --- | --- |
| Nominales | ✓ | ✗ | ✓ | ✗ |
| Ordinales/Cuantitativas | ✓ | ✓ | ✓ | ✓ |

## 7. Construcción de Clases (Variables Cuantitativas)

### Proceso de Agrupación

1. **k** = Número de clases (5-12)
2. **MIN** = Valor mínimo, **MAX** = Valor máximo
3. **Rango** = MAX - MIN
4. **Ancho** = Rango ÷ k
5. **Clases**: [MIN, MIN+Ancho), [MIN+Ancho, MIN+2Ancho), ...

### Estructura de Tabla para Datos Agrupados

| Ordinal | Clase | Marca Clase | fᵢ | Fᵢ | fᵢ/n | Fᵢ/n |
| --- | --- | --- | --- | --- | --- | --- |

## 8. Representación Gráfica

### Gráficos por Tipo de Variable

| Tipo Variable | Gráficos Recomendados |
| --- | --- |
| Nominales | Barras verticales, Pastel |
| Ordinales | Histogramas, Pastel, Pareto, Ojiva |
| Cuantitativas | Dispersión, Líneas, Histogramas |

### Descripción de Gráficos Principales

### Gráfico de Barras

- **Eje X**: Categorías de variable cualitativa
- **Eje Y**: Frecuencias absolutas

### Histograma

- **Eje X**: Clases (intervalos)
- **Eje Y**: Frecuencias relativas o absolutas

### Polígono de Frecuencias

- **Eje X**: Marcas de clase
- **Eje Y**: Frecuencias relativas o absolutas

### Ojiva

- **Eje X**: Marcas de clase
- **Eje Y**: Frecuencia relativa acumulada

### Gráfico de Dispersión

- Visualiza relación entre dos variables
- Correlación: positiva, negativa, curvilínea, sin correlación

## 9. Medidas Estadísticas

### Medidas de Tendencia Central

| Medida | Definición | Fórmula |
| --- | --- | --- |
| Media | Suma de valores ÷ cantidad | x̄ = ∑xᵢ/n |
| Mediana | Valor que divide datos en 50% | Punto medio ordenado |
| Moda | Valor más frecuente | Elemento más repetido |

### Medidas de Dispersión

| Medida | Fórmula | Interpretación |
| --- | --- | --- |
| Rango | MAX - MIN | Amplitud total |
| Varianza Muestral | s² = ∑(xᵢ - x̄)²/(n-1) | Dispersión cuadrática |
| Desviación Estándar | s = √s² | Dispersión en unidades originales |
| Rango Intercuartílico | IQR = Q₃ - Q₁ | Dispersión del 50% central |
| Coeficiente Variación | CV = s/x̄ | Variabilidad relativa |

### Medidas de Posición

| Medida | División | Equivalencias |
| --- | --- | --- |
| Percentiles | 100 partes | Pₖ = cuantil k/100 |
| Cuartiles | 4 partes | Q₁=P₂₅, Q₂=P₅₀, Q₃=P₇₅ |
| Deciles | 10 partes | D₁=P₁₀, D₂=P₂₀, ..., D₉=P₉₀ |

## 10. Gráfico de Caja (Boxplot)

### Elementos

- **Línea central**: Mediana (Q₂)
- **Caja**: Rango intercuartílico (Q₁ a Q₃)
- **Bigotes**: 1.5 × IQR desde Q₁ y Q₃
- **Outliers**: Valores beyond 1.5 × IQR

## 11. Medidas de Forma

### Asimetría (Sesgo)

- **Simétrica**: Media = Mediana = Moda
- **Asimetría positiva**: Cola a la derecha
- **Asimetría negativa**: Cola a la izquierda

### Curtosis (Apuntamiento)

- **Fórmula**: Kᵤ = (P₇₅ - P₂₅) / [2(P₉₀ - P₁₀)]
- **>3**: Distribución apuntada
- **<3**: Distribución aplanada
- **=3**: Distribución normal

## 12. Cálculos para Datos Agrupados

### Fórmulas Principales

| Medida | Fórmula |
| --- | --- |
| Media | x̄ = ∑(fᵢ × mᵢ)/n |
| Varianza | s² = ∑[fᵢ × (mᵢ - x̄)²]/(n-1) |
| Mediana | Lᵢ + [(n/2 - Fᵢ₋₁)/fᵢ] × aᵢ |
| Moda | Lᵢ + [(fᵢ - fᵢ₋₁)/((fᵢ - fᵢ₋₁) + (fᵢ - fᵢ₊₁))] × aᵢ |
| Cuantiles | Lᵢ + [(α·n - Fᵢ₋₁)/fᵢ] × aᵢ |

**Donde**: mᵢ = Marca de clase, Lᵢ = Límite inferior, aᵢ = Ancho del intervalo, Fᵢ₋₁ = Frecuencia acumulada anterior

## 13. Regla Empírica (Distribución Normal)

- ±1σ: 68% de datos
- ±2σ: 95% de datos
- ±3σ: 99.7% de datos

## 14. Ejercicios Prácticos Recomendados

### Con Archivos de Datos

1. **Adquisiciones laboratorio Química.xlsx**
    - Tablas de frecuencia para variables cualitativas
    - Gráficos de barras y pastel
    - Medidas de tendencia central y dispersión
2. **Datos vehículos.xlsx**
    - Diagramas de caja comparativos
    - Análisis por subgrupos (automáticos vs no automáticos)

### Actividades en R

- Funciones: `summary()`, `describe()`, `plot()`, `ggplot2`
- Creación de histogramas, boxplots, gráficos de dispersión
- Cálculo de medidas de posición y dispersión