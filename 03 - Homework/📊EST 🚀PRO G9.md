---
tags:
  - 📊EST
  - 🚀PRO
  - Grupo09
cssclasses:
  - center-titles
  - embed-auto
---

# Proyecto Final: Predicción de Uso de CPU/RAM en Función de Aplicaciones Activas

> Grupo 09

---

## 1. Planteamiento del Problema

> [!info] Información clave
> Proyecto predictivo que relaciona aplicaciones activas (variables independientes X) con el consumo de CPU/RAM (variable dependiente Y).

### Descripción del Problema
- **Tema**: Predicción de uso de recursos del sistema (CPU/RAM)
- **Población objetivo**: Sistemas computacionales con múltiples aplicaciones ejecutándose
- **Variable dependiente (Y)**: Uso de CPU (%) y RAM (%)
- **Variables independientes (X)**: Aplicaciones activas, tiempo de ejecución, tipo de aplicación

### Objetivos
- Predecir el consumo de recursos del sistema basado en aplicaciones activas
- Identificar qué aplicaciones tienen mayor impacto en el rendimiento
- Optimizar la asignación de recursos del sistema

> [!example] Ejemplo práctico
> Un sistema con Chrome (10 pestañas), Photoshop y VS Code abiertos simultáneamente - predecir el consumo total de CPU y RAM.

---

## 2. Cronograma del Proyecto

| Etapa                                   | Descripción                                                   | Semanas | Estado         |
| --------------------------------------- | ------------------------------------------------------------- | ------- | -------------- |
| **Planteamiento del problema**          | Formular pregunta predictiva, identificar variables X e Y     | 1-2     | ✅ Completado  |
| **Recolección y construcción de datos** | Definir fuentes, asegurar calidad, documentar obtención       | 2-4     | 🔄 En progreso |
| **Análisis exploratorio y descriptivo** | Estadísticos básicos, gráficos, detección de valores atípicos | 4-5     | ⏳ Pendiente   |
| **Análisis bivariado e inferencial**    | Relaciones entre variables, matriz de correlación             | 6-7     | ⏳ Pendiente   |
| **Construcción del modelo predictivo**  | Selección y ajuste del modelo, verificación de supuestos      | 9-11    | ⏳ Pendiente   |
| **Evaluación y validación**             | Medidas de ajuste, interpretación de coeficientes             | 12-13   | ⏳ Pendiente   |
| **Presentación de resultados**          | Informe escrito y presentación oral                           | 14-15   | ⏳ Pendiente   |

> [!warning] Punto importante
> Dividir datos en entrenamiento y prueba para validación del modelo predictivo.

---

## 3. Metodología y Estructura del Reporte

### 3.1 Estructura del Documento Escrito

> [!info] Instrucciones para el reporte
> Extensión máxima: 8 páginas | Formato: Word | Decimales: máximo 2

#### Secciones Requeridas:

1. **Portada**
   - Título del trabajo
   - Institución (ESPOL, FCNM)
   - Nombres de autores (Grupo 09)
   - Correos electrónicos
   - Profesor: Fernando Sandoya, PhD.
   - Ciudad, país, mes y año

2. **Resumen** (máximo 800 caracteres)
3. **Introducción**
   - Descripción del proyecto
   - Objetivos generales
   - Justificación

4. **Descripción del Problema**
   - Población objetivo
   - Fuentes de datos
   - Variables analizadas (tipo y soporte)

1. **Metodología** (No escribir en detalle la teoría)
   - Técnicas y métodos utilizados
   - Recursos y modelos

6. **Estadística Descriptiva**
   ```python
   # Ejemplo de análisis esperado
   - Tablas de frecuencia (variables cualitativas)
   - Histogramas, diagramas de caja (variables cuantitativas)
   - Medidas de tendencia central y dispersión
   ```

7. **Estadística Inferencial**
   - Intervalos de confianza
   - Pruebas de hipótesis
   - Regresión lineal

8. **Conclusiones**
9. **Referencias** (formato APA 7)
10. **Anexos**

> [!success] Buenas prácticas
> Incluir llamado explícito a tablas y gráficos: "En la Tabla 2.10 se aprecia..."

---

## 4. Consideraciones Técnicas

### 4.1 Recolección de Datos

> [!bug] Código de ejemplo
> ```python
> # Simulación de recolección de datos
> import psutil
> import time
> 
> def monitor_resources():
>     cpu_percent = psutil.cpu_percent(interval=1)
>     memory_info = psutil.virtual_memory()
>     active_apps = get_active_applications()
>     return {
>         'timestamp': time.time(),
>         'cpu_usage': cpu_percent,
>         'ram_usage': memory_info.percent,
>         'active_apps': active_apps
>     }
> ```

### 4.2 Análisis Estadístico

> [!info] Enfoque analítico
> - **Variables cualitativas**: Aplicaciones activas (categóricas)
> - **Variables cuantitativas**: Uso de CPU (%), Uso de RAM (%)
> - **Análisis bivariado**: Correlación entre aplicaciones y consumo
> - **Modelo predictivo**: Regresión lineal múltiple

> [!quote] Definición estadística
> "La regresión lineal múltiple permite modelar la relación entre varias variables independientes y una variable dependiente continua."

---

## 5. Evaluación y Rúbrica

### 5.1 Componentes de Calificación

| Componente               | % Nota Práctica | % Nota Final Curso |
| ------------------------ | --------------- | ------------------ |
| Talleres aplicados       | 30%             | 9%                 |
| Avances del proyecto     | 20%             | 6%                 |
| Informe técnico final    | 30%             | 9%                 |
| Presentación oral grupal | 20%             | 6%                 |
| **TOTAL**                | **100%**        | **30%**            |

### 5.2 Presentación Oral
- **Duración máxima**: 15 minutos
- **Fecha**: Última semana de clases
- **Enfoque**: Simular presentación a "cliente" o "jefe de ingeniería"

> [!warning] Aspectos críticos
> - El proyecto debe estar completamente terminado para ser calificado
> - Propiedad y claridad en expresiones matemáticas y conceptos estadísticos
> - Validez de resultados y coherencia de conclusiones

---

## 6. Bitácora del Proyecto

> [!note] Diario de recolección (Requerimiento)
> Justificar decisiones tomadas durante la recolección y procesamiento de datos.

**Entradas de bitácora:**
- Fuentes de datos seleccionadas y justificación
- Decisiones sobre limpieza y transformación de datos
- Criterios para manejo de valores atípicos
- Selección de variables para el modelo final

---

## 7. Formatos y Convenciones

### 7.1 Encabezado y Pie de Página
- **Encabezado**: Nombres de autores + Título del trabajo
- **Pie de página**: "Proyecto de estadística" + Número de página

### 7.2 Precisión Numérica
- Todos los resultados con máximo 2 decimales
- Coherencia en unidades de medida

> [!success] Recomendación final
> Mantener enfoque práctico y orientado a decisiones de ingeniería, simulando escenarios reales de optimización de recursos.
