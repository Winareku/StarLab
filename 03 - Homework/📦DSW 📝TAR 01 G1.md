---
tags:
  - 📦DSW
  - 📝TAR
cssclasses:
  - center-titles
---

# Tarea Grupal #01

> [!question] Integrantes:
> - Estrada Lara Windsor Alexander
> - Defranc Rojas Francisco Etienne
> - Arenas Tituaña Juan Pablo
> - Gonzalez Prieto Lenier

***

## Antecedentes
> [!info] Contexto
> **Sistema de alquiler de hospedaje HomeStay**
> - El sistema de alquiler de hospedaje HomeStay facilita la búsqueda, reserva y gestión de alojamientos temporales en diferentes ubicaciones a nivel del país. Cada propiedad en el sistema puede tener múltiples unidades disponibles para alquiler, las cuales pueden variar en tipo (habitaciones privadas, departamentos completos, o casas). Una unidad puede estar en uno de los siguientes estados: disponible, reservada, ocupada, en mantenimiento, o fuera de servicio.
> - Los usuarios pueden buscar propiedades según criterios como ubicación, precio, tipo de alojamiento, y servicios ofrecidos. Una vez encontrada una opción adecuada, los usuarios pueden reservar la unidad por un período específico, sujeto a la disponibilidad y a las políticas de cancelación establecidas por el anfitrión. Además, el sistema debe gestionar el cobro automático de depósitos de seguridad y tarifas adicionales, según corresponda.
> - Los anfitriones pueden establecer reglas específicas para sus propiedades, como horarios de check-in/check-out y restricciones de uso. Las reseñas de los huéspedes son gestionadas de forma transparente, permitiendo que tanto anfitriones como huéspedes puedan calificar su experiencia.
> - El sistema también ofrece la opción de enviar notificaciones a través de distintos canales, como correo electrónico, SMS o aplicaciones de mensajería, para mantener a los usuarios informados sobre el estado de sus reservas o eventos importantes relacionados con su estancia. Nuevos métodos de notificación pueden añadirse al sistema sin causar alteraciones significativas.
> - Para asegurar la calidad del servicio, el sistema debe manejar incidentes reportados por los huéspedes, los cuales son atendidos primero por el anfitrión; si no se resuelven, son escalados a un moderador de la plataforma, y finalmente al equipo de soporte legal para una resolución definitiva en casos críticos.

***
## Realización

> [!check] Objetivos Específicos
> 1. Aplicar principios SOLID para garantizar un diseño de software que sea robusto, flexible y fácilmente mantenible.
> 2. Utilizar diagramas UML para documentar y comunicar el diseño del sistema, especificando casos de uso, clases, y secuencias de interacciones entre componentes.
> 3. Generar código basado en los diagramas UML de clases y de secuencias, siguiendo el diseño planteado.

> [!quote] Resultado de Aprendizaje
> 1. Funcionar efectivamente como miembro o líder de un equipo involucrado en actividades apropiadas para la disciplina del programa.
> 2. Habilidad para aplicar teoría de ciencias computacionales y fundamentos de desarrollo de software para producir soluciones basadas en computación.

> [!info] Descripción
> En equipos de trabajo de entre 3 a 4 estudiantes, se les asignará la descripción de un sistema para el cual deberán:
> 1. Aplicar los principios SOLID en el diseño de las clases del sistema.
> 2. Generar diagramas UML de Casos de uso, de Clases y de Secuencias.
> 3. Escribir el código base a partir de los diagramas generados.

> [!question] Especificaciones
> > [!tip] Sección A: Casos de Uso (20%)
> > Diseñar el diagrama de Casos de Uso del sistema con al menos 2 refinamientos (includes, extends). Indique las asunciones tomadas para su proyecto. Luego, seleccionar 4 casos de uso que cubran las principales funcionalidades del sistema asignado y para cada caso de uso, detallar:
> > * Actores involucrados.
> > * Precondiciones necesarias para que el caso de uso pueda ejecutarse.
> > * Flujo de Eventos Principal que describe paso a paso la secuencia de acciones.
> > * Flujos Alternativos para gestionar variaciones en la secuencia.
> > * Postcondiciones que indican el estado esperado del sistema al completar el caso de uso.
>
> > [!tip] Sección B: Diagrama de Clases (30%)
> > Aplicar los principios SOLID al definir las clases, interfaces y relaciones del diagrama de clase del sistema asignado. El diagrama debe representar los atributos, métodos, y asociaciones necesarias para soportar los casos de uso. Justificar la aplicación de cada principio SOLID en las clases y relaciones diseñadas.
>
> > [!tip] Sección C: Diagrama de Secuencias (40%)
> > Diseñar los 4 diagramas de secuencia que representen la ejecución de los casos de uso seleccionados en la sección A, detallando los mensajes enviados entre objetos, la creación de instancias y las llamadas a métodos. Sin embargo, debe asegurarse de que los diagramas sean consistentes con el diagrama de clases y muestren cómo se comunican los objetos en respuesta a los eventos de usuario.
>
> > [!tip] Sección D: Generación de Código Base (10%)
> > Basándose en los diagramas de clases y de secuencias, desarrollar un prototipo inicial del sistema en Java. El código debe incluir:
> > * Definición de las clases, interfaces y métodos reflejados en los diagramas.
> > * Implementación de la lógica mínima para los métodos, según los diagramas.
> > * Utilizar control de versiones para gestionar el código y registrar el progreso en un repositorio en GitHub.

> [!tip] Entregables (en un archivo ZIP o RAR)
> 4. Un documento (en formato DOCX y PDF) que contenga:
>     * Una portada con los nombres de los integrantes del equipo.
>     * Un índice de contenido.
>     * Los diagramas UML, las asunciones de su proyecto, la descripción de los Casos de Uso seleccionados y la justificación de la aplicación de los principios SOLID.
> 5. Los archivos de proyecto en Visual Paradigm con los diseños UML.
> 6. Código Java generado a partir de los diagramas UML, almacenado en un repositorio de GitHub, y evidencia del uso de control de versiones (Todos los integrantes deben aportar al proyecto de manera equitativa).

***

# RoadMap

## 🎯 Fase 1: Planificación Inicial
- [x] **Formar equipo** (3-4 personas) y asignar roles
- [ ] **Leer y analizar** detenidamente los antecedentes del sistema HomeStay
- [ ] **Identificar** los actores principales del sistema
- [ ] **Definir** las funcionalidades clave del sistema

> [!tip] Consejo
> Realicen una sesión de lluvia de ideas para identificar todos los casos de uso posibles antes de seleccionar los 4 principales.

## 📋 Fase 2: Diagrama de Casos de Uso (Sección A - 20%)
- [ ] **Diseñar** diagrama de casos de uso con todos los actores y relaciones
- [ ] **Incluir** al menos 2 refinamientos `includes` y 2 `extends`
- [ ] **Documentar** las asunciones del proyecto
- [ ] **Seleccionar** 4 casos de uso principales
- [ ] **Detallar** cada caso de uso con:
  - [ ] Actores involucrados
  - [ ] Precondiciones
  - [ ] Flujo principal de eventos
  - [ ] Flujos alternativos
  - [ ] Postcondiciones

## 🏗️ Fase 3: Diagrama de Clases (Sección B - 30%)
- [ ] **Identificar** clases, atributos y métodos principales
- [ ] **Aplicar principios SOLID** en el diseño:
  - [ ] **S** - Principio de responsabilidad única
  - [ ] **O** - Principio abierto/cerrado
  - [ ] **L** - Principio de sustitución de Liskov
  - [ ] **I** - Principio de segregación de interfaces
  - [ ] **D** - Principio de inversión de dependencias
- [ ] **Definir** relaciones entre clases con multiplicidad y roles
- [ ] **Justificar** aplicación de cada principio SOLID
- [ ] **Validar** que el diseño soporte los casos de uso

> [!warning] Importante
> Asegúrense de que cada principio SOLID esté claramente aplicado y justificado en el documento.

## 🔄 Fase 4: Diagramas de Secuencia (Sección C - 40%)
- [ ] **Seleccionar** los 4 casos de uso de la Sección A
- [ ] **Diseñar** diagrama de secuencia para cada caso de uso
- [ ] **Incluir** en cada diagrama:
  - [ ] Mensajes entre objetos
  - [ ] Creación de instancias
  - [ ] Llamadas a métodos
- [ ] **Verificar** consistencia con el diagrama de clases

## 💻 Fase 5: Generación de Código (Sección D - 10%)
- [ ] **Configurar** repositorio en GitHub
- [ ] **Implementar** clases e interfaces del diagrama
- [ ] **Codificar** lógica mínima para los métodos
- [ ] **Asegurar** que todos los integrantes contribuyan
- [ ] **Documentar** commits en el repositorio

## 📦 Fase 6: Integración y Entrega
- [ ] **Revisar** que todos los diagramas estén completos
- [ ] **Validar** consistencia entre diagramas y código
- [ ] **Preparar** documento final con:
  - [ ] Portada con nombres del equipo
  - [ ] Índice de contenido
  - [ ] Diagramas UML
  - [ ] Descripción de casos de uso
  - [ ] Justificación SOLID
- [ ] **Exportar** documentos en formato DOCX y PDF
- [ ] **Incluir** archivos de Visual Paradigm
- [ ] **Comprimir** todos los entregables en ZIP/RAR

> [!success] Recordatorio Final
> - **Fecha límite**: [Insertar fecha de entrega]
> - **Todos deben contribuir** equitativamente en GitHub
> - **Revisar la rúbrica** antes de entregar para asegurar cumplimiento de todos los criterios

***

## Rúbricas
> [!warning] Rúbrica 1

| **Descripción**                                                                 | **Valor** |
| ------------------------------------------------------------------------------- |:---------:|
| **Sección A**                                                                   |     <     |
| Diagrama de Casos de Uso (actores, relaciones y casos de uso)                   |     4     |
| Dos refinamientos de cada tipo (includes, extends)                              |     8     |
| Descripción de 4 casos de Uso (funcionalidades principales)                     |     8     |
| **Sección B**                                                                   |     <     |
| Diagrama de clases con atributos y métodos importantes                          |    10     |
| Relaciones entre clases usando nombre de la relación, multiplicidad y rol       |     5     |
| Justificación de los principios SOLID para cada elemento del diagrama de clases |    15     |
| **Sección C**                                                                   |     <     |
| Cuatro diagramas de secuencia de los Casos de Uso seleccionados                 |    10     |
| Uso correcto de los mensajes entre clases                                       |    20     |
| Consistencia con el diagrama de clases                                          |    10     |
| **Sección D**                                                                   |     <     |
| Implementación del código base Java                                             |    10     |
| **Total**                                                                       |  **100**  |
| Si no entrega el documento                                                      |    -20    |
| Si no entrega los diseños UML en Visual Paradigm                                |    -20    |
| Si no hay un uso adecuado del repositorio en GitHub (Todos deben aportar)       |    -40    |

> [!warning] Rúbrica 2

| **Criterios**                                                                       | **Calificaciones**                                                                                                                                                                           |   Pts   |
| ----------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |:-------:|
| **Diagrama de Casos de Uso (actores, relaciones y casos de uso)**                   | El diagrama es claro, completo e identifica correctamente todos los actores, casos de uso principales y sus relaciones.                                                                      |    4    |
| ^                                                                                   | El diagrama identifica la mayoría de actores y casos de uso.                                                                                                                                 |    2    |
| ^                                                                                   | Identifica algunos actores y casos de uso, pero está incompleto o las relaciones son confusas.                                                                                               |    1    |
| ^                                                                                   | No entrega el diagrama o es incorrecto.                                                                                                                                                      |    0    |
| **Uso de dos refinamientos de cada tipo (includes, extends)**                       | Incluye dos refinamientos de cada tipo y su uso es conceptualmente correcto.                                                                                                                 |    8    |
| ^                                                                                   | Incluye al menos un refinamiento de cada tipo.                                                                                                                                               |    4    |
| ^                                                                                   | Solo incluye un refinamiento y su uso puede no ser del todo correcto.                                                                                                                        |    2    |
| ^                                                                                   | No incluye refinamientos includes / extends o su uso es incorrecto.                                                                                                                          |    0    |
| **Descripción de 4 casos de Uso (funcionalidades principales)**                     | Describe 4 casos de uso principales. Cada descripción incluye todos los elementos solicitados (actores, pre/post-condiciones, flujo principal, flujos alternativos).                         |    8    |
| ^                                                                                   | Describe 4 casos de uso, pero a algunas descripciones les falta uno de los elementos.                                                                                                        |    6    |
| ^                                                                                   | Describe menos de 4 casos de uso, o las descripciones son incompletas.                                                                                                                       |    3    |
| ^                                                                                   | No entrega las descripciones.                                                                                                                                                                |    0    |
| **Diagrama de clases con atributos y métodos importantes**                          | Identifica todas las clases clave, con sus atributos y métodos relevantes para los casos de uso.                                                                                             |   10    |
| ^                                                                                   | Identifica la mayoría de las clases y sus atributos/métodos, pero omite algunos elementos importantes.                                                                                       |    7    |
| ^                                                                                   | El diagrama es básico, faltan clases importantes o la mayoría de atributos/métodos.                                                                                                          |    3    |
| ^                                                                                   | No entrega el diagrama o es incorrecto.                                                                                                                                                      |    0    |
| **Relaciones entre clases usando nombre de la relación, multiplicidad y rol**       | Define correctamente todas las relaciones (asociación, agregación, composición, herencia) incluyendo nombre, multiplicidad y roles donde aplica.                                             |    5    |
| ^                                                                                   | Define la mayoría de las relaciones correctamente, pero omite detalles en varias de ellas.                                                                                                   |    3    |
| ^                                                                                   | Define algunas relaciones, pero son incorrectas o están incompletas.                                                                                                                         |    1    |
| ^                                                                                   | No define relaciones.                                                                                                                                                                        |    0    |
| **Justificación de los principios SOLID para cada elemento del diagrama de clases** | Justifica la aplicación de los 5 principios SOLID de forma clara, correcta y específica, conectando cada principio con las clases/interfaces reales de su diagrama.                          |   15    |
| ^                                                                                   | Justifica la aplicación de la mayoría (3-4) de los principios SOLID correctamente, o la justificación de alguno es débil o genérica.                                                         |   10    |
| ^                                                                                   | Menciona los principios SOLID, pero la justificación es genérica, no se aplica al proyecto, o es incorrecta. O solo justifica 1-2 principios.                                                |    5    |
| ^                                                                                   | No entrega la justificación.                                                                                                                                                                 |    0    |
| **Diagramas de secuencia para los 4 casos de uso seleccionados**                    | Entrega 4 diagramas de secuencia completos que corresponden a los casos de uso de la Sección A.                                                                                              |   10    |
| ^                                                                                   | Entrega 3 diagramas completos.                                                                                                                                                               |    7    |
| ^                                                                                   | Entrega 1-2 diagramas completos.                                                                                                                                                             |    3    |
| ^                                                                                   | No entrega ningún diagrama.                                                                                                                                                                  |    0    |
| **Uso correcto de los mensajes entre clases**                                       | Todos los diagramas usan la notación correcta (mensajes síncronos, asíncronos, de creación, de retorno) y los mensajes fluyen de manera lógica y correcta.                                   |   20    |
| ^                                                                                   | La mayoría de los mensajes son correctos y lógicos, pero hay errores menores de notación o un flujo ilógico en algún diagrama.                                                               |   15    |
| ^                                                                                   | Los diagramas tienen errores significativos en la notación, o los flujos de mensajes son difíciles de seguir o conceptualmente incorrectos.                                                  |    7    |
| ^                                                                                   | El uso de mensajes es incorrecto.                                                                                                                                                            |    0    |
| **Consistencia con el diagrama de clases**                                          | Los diagramas de secuencia son totalmente consistentes con el diagrama de clases. Los objetos son instancias de las clases, y los mensajes (métodos) existen en las clases correspondientes. |   10    |
| ^                                                                                   | Los diagramas son mayoritariamente consistentes, pero se invocan métodos que no existen en el diagrama de clases o se usan objetos de clases no definidas.                                   |    5    |
| ^                                                                                   | Los diagramas son inconsistentes con el diagrama de clases.                                                                                                                                  |    0    |
| **Implementación del código base Java**                                             | El código Java refleja fielmente el diagrama de clases (clases, interfaces, atributos, métodos) y la lógica mínima de los diagramas de secuencia.                                            |   10    |
| ^                                                                                   | El código refleja el diagrama de clases, pero omite algunas clases/métodos, o no implementa la lógica mínima de las secuencias.                                                              |    7    |
| ^                                                                                   | El código es solo un esqueleto básico (solo clases vacías) y no refleja el diseño UML, o está incompleto.                                                                                    |    3    |
| ^                                                                                   | No entrega el código.                                                                                                                                                                        |    0    |
| **Puntos totales:**                                                                 | <                                                                                                                                                                                            | **100** |
