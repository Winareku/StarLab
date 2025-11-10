---
fecha: 2025-10-10
tags:
  - 🗃️SBD
  - 📝TAR
cssclasses:
  - center-titles
---
---
# Tarea:
> [!quote] Estimados estudiantes:
> Como parte del curso de Bases de Datos, cada uno de ustedes deberá **proponer individualmente un proyecto que requiera el diseño de una base de datos relacional**. Esta actividad tiene como finalidad ejercitar su capacidad de análisis y aplicación de conceptos teóricos en contextos reales o simulados.
> Posteriormente, el docente seleccionará las propuestas más viables o interesantes, y se organizarán equipos de trabajo para desarrollar dichos proyectos de forma colaborativa durante el resto del curso.
> **Nota:** el proyecto seleccionado por grupo debe contener actores reales ya que parte de los siguientes avances son fotos y videos de las entrevistas realizados a los clientes finales.
> La siguiente clase traer los grupos conformados ya que se creará en el sitio virtual del curso dichos grupos
> ### **Propuesta Individual**
> #### **Objetivo**
> Identificar una necesidad concreta en la que el uso de una base de datos permita gestionar información de forma eficiente y estructurada. 
> #### **Contenido de la Propuesta (1 página máximo)**
> El documento debe contener:
> - **Nombre del proyecto.**
> - **Breve descripción del problema o necesidad.**
> - **Principales entidades de datos a almacenar.**
> - **Ejemplos de consultas útiles que debería responder el sistema.**

---
# Borrador
**Archivo** [[🗃️SBD 📝TAR 01 Propuesta de Proyecto Individual.pdf|Propuesta]]

**Nombre**
> **AI Hint:**Un título claro y atractivo.

Sistema de Recomendaciones para “PoliBaldeo”

**Descripción del Problema**
> **AI Hint:**Explicar brevemente qué necesidad o inconveniente solucionará tu base de datos.

PoliBaldeo es una aplicación de escritorio desarrollada en Python que permite a los estudiantes gestionar sus horarios académicos de manera local. Una de sus funcionalidades es ordenar manualmente los paralelos dentro de cada materia, lo que resulta crucial durante el período de registro cuando los cupos se agotan rápidamente y los estudiantes deben identificar alternativas disponibles sin conflictos horarios.
Necesidades Identificadas
Actualmente, los usuarios organizan manualmente sus paralelos, colocando en la parte superior aquellos que prefieren. Sin embargo, este proceso resulta tedioso y poco eficiente, especialmente cuando el criterio principal de selección suele ser la reputación del profesor, información que deben consultar de forma externa en plataformas como PoliRecomienda.

**Principales Entidades de Datos**
> **AI Hint:**Listar las "tablas" principales que tendrás (ej: Usuarios, Productos, Pedidos) y una mención de sus atributos clave

- **Materias:** Almacenan la información de asignaturas como códigos.
- **Profesores:** Registra los profesores asociados a cada materia.
- **Calificaciones:** Guarda los promedios o métricas de reputación por profesor.
- **Paralelos:** Mantiene la relación entre materias y profesores.

**Consultas Útiles**
> **AI Hint:** Describir de 3 a 5 preguntas que tu sistema debería poder responder gracias a la base de datos (ej: "¿Cuáles son los 10 productos más vendidos del mes?").
> **Punto Crítico:** Tu proyecto debe involucrar **actores reales** (usuarios finales), ya que luego tendrás que entrevistarlos. Piensa en un problema de alguien (un negocio local, un club universitario, un profesor, etc.) que pueda ser solucionado con una base de datos.

- **Ordenamiento automático:** Listar los paralelos de una materia de manera descendente por calificación.
- **Filtrado:** Puede solo mostrar paralelos con profesores que superen cierta calificación.
- **Actualización periódica:** Los promedios se pueden sincronizar con PoliRecomienda.