---
tags:
  - #🔰MISC
  - #📝NOT
cssclasses:
  - center-titles
  - embed-auto
---

# Making Neural Programming Architectures Generalize Via Recursion

## 1. Identificación del Problema

> [!info] Problema Central
> Las arquitecturas neuronales existentes para aprender programas a partir de datos **no generalizan bien** más allá de un cierto nivel de complejidad de entrada, y es difícil razonar sobre su comportamiento en situaciones no vistas.

| Problema                                   | Causa Principal                                                       |
| ------------------------------------------ | --------------------------------------------------------------------- |
| Generalización pobre en entradas complejas | Dependencias espurias en estados ocultos de alta dimensionalidad      |
| Falta de interpretabilidad                 | Comportamiento no razonable más allá de los ejemplos de entrenamiento |
| Sin garantías comprobables                 | Arquitecturas no diseñadas para permitir verificación formal          |

> [!example] Ejemplo en Tareas
> Modelos entrenados en sumas de 3 dígitos fallan al generalizar a sumas de 5000 dígitos, a pesar de usar *curriculum learning*.

---

## 2. Revisión de Información Relacionada

> [!info] Modelos Previos
> Se han propuesto múltiples arquitecturas para aprender programas, pero ninguna incorpora recursión de manera explícita.

| Modelo                              | Año  | Característica Principal               |
| ----------------------------------- | ---- | -------------------------------------- |
| Neural Turing Machine               | 2014 | Memoria externa diferenciable          |
| Neural GPU                          | 2015 | Aprendizaje de algoritmos con GPU      |
| Neural Programmer-Interpreter (NPI) | 2016 | Trazas de ejecución sintéticas         |
| Pointer Networks                    | 2015 | Mecanismos de atención para secuencias |
| Hierarchical Attentive Memory       | 2016 | Memoria jerárquica y atención          |

> [!warning] Limitaciones Comunes
> Ninguno de estos modelos provee **garantías comprobables** de generalización perfecta, y todos muestran degradación en entradas más complejas.

---

## 3. Formulación de Hipótesis

> [!success] Hipótesis Principal
> La **incorporación explícita de recursión** en arquitecturas neuronales permite:
> - Mejor generalización
> - Reducción de la complejidad del problema
> - **Garantías comprobables** de generalización perfecta

> [!info] Fundamentos de la Recursión
> - **Base cases**: Escenarios de terminación sin recursión
> - **Reduction rules**: Reglas que reducen problemas hacia los casos base
> - La recursión permite dividir el problema en instancias más pequeñas y manejables

---

## 4. Identificación de Datos Necesarios

> [!info] Requisitos de Datos
> Para entrenar y verificar programas neuronales recursivos se necesitan:

| Tipo de Dato                      | Descripción                                                             |
| --------------------------------- | ----------------------------------------------------------------------- |
| Trazas de ejecución sintéticas    | Secuencias de entrada-salida que capturen comportamiento recursivo      |
| Conjuntos de verificación         | Entradas que cubran todos los casos base y reglas de reducción          |
| Problemas de complejidad variable | Desde ejemplos simples hasta casos complejos no vistos en entrenamiento |

> [!example] Tareas Específicas
> - Suma de números de múltiples dígitos
> - Algoritmos de ordenamiento (Bubble Sort, Quicksort)
> - Ordenamiento topológico en grafos (DAGs)

---

## 5. Recolección de Datos

> [!success] Estrategia de Recolección
> Se generaron trazas de entrenamiento sintéticas para cada tarea:

| Tarea            | Cantidad de Trazas | Complejidad Máxima en Entrenamiento |
| ---------------- | ------------------ | ----------------------------------- |
| Suma             | 200                | 3 dígitos                           |
| Bubble Sort      | 100                | Arrays de longitud 2                |
| Topological Sort | 6                  | Grafos de 5-7 nodos                 |
| Quicksort        | 4                  | Arrays de longitud 5                |

> [!warning] Nota Importante
> Los mismos problemas se usaron para generar trazas tanto en versiones recursivas como no recursivas, permitiendo comparación justa.

---

## 6. Análisis de Datos

> [!success] Resultados de Generalización
> Los modelos recursivos mostraron **100% de precisión** en todas las tareas, incluso en entradas mucho más complejas que las de entrenamiento.

**Tabla 1: Bubble Sort - Precisión por Longitud del Array**

| Longitud | No Recursivo | Parcial Recursivo | Total Recursivo |
| -------- | ------------ | ----------------- | --------------- |
| 2        | 100%         | 100%              | 100%            |
| 3        | 6.7%         | 23%               | 100%            |
| 8        | 0%           | 0%                | 100%            |
| 90       | 0%           | 0%                | 100%            |

**Tabla 2: Quicksort - Precisión por Longitud del Array**

| Longitud | No Recursivo | Recursivo |
| -------- | ------------ | --------- |
| 11       | 73.3%        | 100%      |
| 20       | 30%          | 100%      |
| 70       | 0%           | 100%      |

> [!info] Interpretación
> Los modelos no recursivos aprendieron dependencias espurias relacionadas con la longitud de entrada, mientras que los recursivos capturaron la **semántica verdadera del programa**.

---

## 7. Resumen de Resultados

> [!success] Contribuciones Principales
> - **Primera implementación** de programas neuronales recursivos
> - **Generalización perfecta** demostrada empíricamente
> - **Verificación formal** mediante conjuntos de verificación finitos
> - **Reducción drástica** en datos de entrenamiento necesarios

> [!example] Caso Destacado
> En topological sort, el modelo recursivo entrenado con **solo 1 traza** generalizó perfectamente a grafos de 70 nodos, mientras que el no recursivo falló completamente.

---

## 8. Conclusiones e Implicaciones

> [!success] Conclusión Principal
> La **recursión es esencial** para que las arquitecturas neuronales aprendan programas que generalicen robustamente y permitan **garantías comprobables** de comportamiento correcto.

> [!info] Implicaciones Prácticas
> - Posibilidad de usar programas neuronales en aplicaciones críticas
> - Reducción significativa en la cantidad de datos de entrenamiento necesarios
> - Mayor interpretabilidad y capacidad de razonamiento sobre el comportamiento

> [!tip] Trabajo Futuro
> - Reducir supervisión (trazas parciales o no recursivas)
> - Explorar más tareas con estructura recursiva
> - Desarrollar arquitecturas integradas directamente con recursión

> [!quote] Cita Clave
> *"Recursion divides the problem into smaller pieces and drastically reduces the domain of each neural network component, making it tractable to prove guarantees about the overall system's behavior."*