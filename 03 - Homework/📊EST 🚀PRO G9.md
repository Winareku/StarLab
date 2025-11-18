---
tags:
  - 📊EST
  - 🚀PRO
  - Grupo09
cssclasses:
  - center-titles
  - embed-auto
---

# Proyecto de Estadística: Estimación del Tiempo de Ejecución de un Algoritmo según el Tamaño de Datos

## Avance del Proyecto - Hasta Análisis Bivariado e Inferencial

> [!info] Estado Actual
> Este documento contiene el avance del proyecto hasta la etapa de análisis bivariado e inferencial, correspondiente a las semanas 1-7 del cronograma.

---

## CONTENIDO DEL REPORTE ESCRITO

### 1. Resumen

> [!info] Límite: 800 caracteres
> *Por completar en la siguiente iteración - Se llenará cuando tengamos los resultados finales*

### 2. Introducción

**Objetivo General:**  
Predecir el tiempo de ejecución de un algoritmo de ordenación en función del tamaño de los datos de entrada.

**Justificación:**  
En ingeniería de software, predecir tiempos de ejecución es crucial para:
- Seleccionar algoritmos eficientes según el volumen de datos
- Planificar capacidad de sistemas y recursos computacionales
- Optimizar el rendimiento de aplicaciones que procesan grandes volúmenes de información

**Pregunta de investigación:**  
¿Cómo se relaciona el tamaño de los datos de entrada (número de elementos) con el tiempo de ejecución de un algoritmo de ordenación?

### 3. Descripción del Problema

**Población objetivo:**  
Arrays de diferentes tamaños (desde 1,000 hasta 4,000,000 elementos) con datos de punto flotante.

**Fuentes de datos:**  
Benchmark Dataset for Sorting Algorithms (Sahin Emrah AMRAHOV et al., Future Generation Computer Systems)

**Variables analizadas:**

| Variable              | Tipo                  | Soporte                      | Descripción                           |
| --------------------- | --------------------- | ---------------------------- | ------------------------------------- |
| Tamaño del array      | Cuantitativa discreta | 1,000 - 4,000,000 elementos  | Número de elementos en el array       |
| Tiempo de ejecución   | Cuantitativa continua | Segundos o milisegundos      | Tiempo que toma ordenar el array      |
| Algoritmo             | Cualitativa           | {QuickSort, MergeSort, etc.} | Algoritmo de ordenación utilizado     |
| Distribución de datos | Cualitativa           | {Uniforme, Normal}           | Distribución estadística de los datos |

### 4. Metodología

**Técnicas y métodos utilizados:**

| Técnica                     | Propósito                                                         |
| --------------------------- | ----------------------------------------------------------------- |
| **Estadística descriptiva** | Caracterizar el comportamiento de las variables individualmente   |
| **Análisis exploratorio**   | Identificar patrones, valores atípicos y relaciones preliminares  |
| **Correlación de Pearson**  | Medir la relación lineal entre tamaño y tiempo de ejecución       |
| **Pruebas de hipótesis**    | Verificar significancia estadística de las relaciones encontradas |

**Recursos:**
- Lenguaje de programación: Python 3.x
- Librerías: pandas, matplotlib, scipy, numpy
- Dataset: Benchmark de algoritmos de ordenación

### 5. Estadística Descriptiva de Datos

> [!info] Por completar
> *Esta sección se llenará con los resultados específicos una vez recopilados los datos*

**Análisis planificado para cada variable:**

**Variable: Tamaño del array**
- Medidas de tendencia central: media, mediana
- Medidas de dispersión: desviación estándar, rango
- Gráficos: histograma, diagrama de caja

**Variable: Tiempo de ejecución**
- Medidas de tendencia central: media, mediana
- Medidas de dispersión: desviación estándar, rango intercuartílico
- Gráficos: histograma, diagrama de caja

**Gráficos bivariados planificados:**
- Diagrama de dispersión: Tiempo vs. Tamaño
- Línea de tendencia para visualizar relación

### 6. Estadística Inferencial

**Análisis de correlación planificado:**

**Hipótesis:**
- **H₀:** ρ = 0 (No existe correlación lineal entre tamaño y tiempo)
- **H₁:** ρ ≠ 0 (Existe correlación lineal entre tamaño y tiempo)
- **Nivel de significancia:** α = 0.05

**Método:** Correlación de Pearson

**Matriz de correlación a obtener:**

| Variable | Tamaño | Tiempo |
| -------- | ------ | ------ |
| Tamaño   | 1.00   | [r]    |
| Tiempo   | [r]    | 1.00   |

> [!info] Interpretación esperada
> Se espera encontrar una correlación positiva fuerte (r > 0.7) y estadísticamente significativa (p < 0.05) entre el tamaño del array y el tiempo de ejecución.

### 7. Plan de Recolección de Datos

**Bitácora de experimentación:**
```
Fecha: [Fecha de ejecución]
Algoritmo: [QuickSort/MergeSort/Etc.]
Lenguaje: Python 3.x
Hardware: [Especificaciones del equipo]
Condiciones: [Carga del sistema, etc.]

Ejemplo de registro:
- Tamaño: 1000 elementos
  • Ejecución 1: 0.045s
  • Ejecución 2: 0.043s
  • Ejecución 3: 0.047s
  • Promedio: 0.045s
```

### 8. Próximos Pasos

**Para completar en siguientes iteraciones:**
- [ ] Ejecutar experimentos y recopilar datos
- [ ] Realizar análisis descriptivo completo
- [ ] Calcular matriz de correlación
- [ ] Realizar pruebas de hipótesis
- [ ] Interpretar resultados y redactar conclusiones

> [!success] Cronograma en progreso
> Actualmente nos encontramos en la etapa de análisis bivariado e inferencial (semanas 6-7). Las etapas completadas incluyen planteamiento del problema y planificación de recolección de datos.

---

> [!note] Nota sobre formato final
> Este documento servirá como base para el reporte final en Word, manteniendo la estructura requerida pero adaptándose a las especificaciones de formato de la guía.