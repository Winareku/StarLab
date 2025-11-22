# Hacer que las Arquitecturas de Programación Neuronal Generalicen mediante Recursión

Jonathon Cai, Richard Shin, Dawn Song  
Departamento de Ciencias de la Computación  
Universidad de California, Berkeley

## Resumen

Las redes neuronales que intentan aprender programas a partir de datos han mostrado una generalización deficiente. En este trabajo, proponemos aumentar las arquitecturas neuronales con una abstracción clave: la **recursión**. Implementamos la recursión en el marco de Neural Programmer-Interpreter (NPI) en cuatro tareas: suma de números de varios dígitos, ordenamiento burbuja, ordenamiento topológico y quicksort. Demostramos una generalización e interpretabilidad superiores con pequeñas cantidades de datos de entrenamiento. La recursión divide el problema en partes más pequeñas y reduce drásticamente el dominio de cada componente de la red neuronal, haciendo posible probar garantías sobre el comportamiento del sistema. Nuestra experiencia sugiere que para que las arquitecturas neuronales aprendan semánticas de programas de manera robusta, es necesario incorporar un concepto como la recursión.

## 1. Introducción

Entrenar redes neuronales para sintetizar programas robustos a partir de pocos ejemplos es un desafío. Los modelos existentes generalizan mal más allá de un umbral de complejidad, debido a dependencias no interpretables en estados ocultos de alta dimensión. Estrategias como el aprendizaje curricular ayudan, pero eventualmente fallan. Proponemos que la **recursión** es esencial para que los programas neuronales generalicen correctamente y permite demostrar garantías formales sobre su comportamiento.

## 2. El Problema y Nuestro Enfoque

### El Problema de la Generalización

Los modelos actuales de programación neuronal no generalizan bien a entradas más complejas que las de entrenamiento, y no ofrecen garantías comprobables. La red aprende dependencias espurias de características irrelevantes (como la longitud de la entrada), lo que impide la generalización.

### Nuestro Enfoque mediante Recursión

La recursión permite resolver un problema grande combinando soluciones de instancias más pequeñas del mismo problema. Una función recursiva tiene:

1. **Casos base**: Escenarios que no usan recursión.
2. **Reglas de reducción**: Reducen problemas hacia los casos base.

Implementamos la recursión en una Arquitectura de Programación Neuronal (como NPI) permitiendo que un programa se llame a sí mismo, con un stack para guardar el contexto. Esto permite:

- Descomponer el problema.
- Facilitar el razonamiento sobre el comportamiento.
- Probar la generalización perfecta verificando solo los casos base y las reglas de reducción.

## 3. Aplicación a NPI con Programas Recursivos

### Antecedentes: Arquitectura NPI

NPI consta de:

- Un núcleo LSTM (controlador).
- Un conjunto de programas.
- Codificadores específicos del dominio.

El controlador decide qué programa ejecutar a continuación. Cuando se llama a un programa, el contexto se guarda en un stack; al retornar, se restaura.

### Formulaciones Recursivas para NPI

Modificamos las trazas de entrenamiento para incluir llamadas recursivas:

- **Suma**: Se añade una llamada recursiva a `ADD` después de `ADD1` y `LSHIFT`.
- **Ordenamiento Burbuja**: Se hacen recursivos `BUBBLESORT`, `BSTEP` y `LSHIFT`.
- **Ordenamiento Topológico**: Se hacen recursivas las funciones `TOPOSORT`, `CHECK_CHILD`, `EXPLORE` y `NEXT_START`.
- **Quicksort**: Se implementa la recursión directa según el algoritmo de divide y vencerás.

### Generalización Perfectamente Comprobable

Para probar que un programa neuronal generaliza perfectamente, verificamos que se comporta correctamente en todos los casos base y reglas de reducción. La recursión hace que el conjunto de verificación \( V \) sea finito y manejable, incluso para entradas de longitud arbitraria.

## 4. Experimentos

### Configuración de Entrenamiento

- **Suma**: 200 trazas (longitud máxima 3).
- **Burbuja**: 100 trazas (longitud máxima 2).
- **Ordenamiento Topológico**: 6 trazas (grafos de 5 y 7 nodos).
- **Quicksort**: 4 trazas (arrays de longitud 5).

### Resultados

| Tarea             | No Recursivo | Recursivo |
|-------------------|--------------|-----------|
| Suma              | Generaliza hasta 5000 dígitos, pero sin garantía | Generaliza perfectamente con garantía |
| Burbuja           | Falla en arrays largos | 100% de precisión en cualquier longitud |
| Ordenamiento Topológico | Falla en grafos grandes | 100% de precisión en grafos grandes |
| Quicksort         | Falla en arrays largos | 100% de precisión en cualquier longitud |

### Verificación de la Generalización Perfecta

Para cada tarea, construimos un conjunto de verificación \( S_V \) que cubre todos los casos base y reglas de reducción. Los programas recursivos pasaron todas las pruebas, demostrando generalización perfecta.

## 5. Conclusión

La **recursión** es un concepto novedoso en programación neuronal que permite:

- Aprender programas robustos con pocos ejemplos.
- Generalizar perfectamente a entradas de cualquier complejidad.
- Probar garantías formales sobre el comportamiento.

Es la primera vez que se logran garantías comprobables para programas neuronales. Futuros trabajos explorarán cómo inducir recursión con menos supervisión.

## Agradecimientos

Trabajo apoyado por la National Science Foundation, DARPA y Berkeley Deep Drive.

## Referencias

Reed & de Freitas (2016), Graves et al. (2014), Vinyals et al. (2015), entre otros.