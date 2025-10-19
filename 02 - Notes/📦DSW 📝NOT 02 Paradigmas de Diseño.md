---
fecha: 2025-10-13
tags:
  - 📦DSW
  - 📝NOT
---
---
# Paradigmas de Diseño

## Paradigmas de Programación

### 1. ¿Qué es un Paradigma?

- Estilo de programación, no un lenguaje específico.
- Permite elegir el mejor enfoque para resolver un problema.

### 2. Tipos de Paradigmas

- **Imperativo**: Instrucciones que cambian el estado (Ej: C, Fortran).
- **Declarativo**: Especifica el resultado, no el proceso (Ej: Prolog, Haskell).

### 3. Paradigma Orientado a Aspectos (AOP)

- **Objetivo**: Separar *cross-cutting concerns* (ej: seguridad, logging).
- **Conceptos Clave**:
    - **Aspecto**: Unidad modular que encapsula comportamiento transversal.
    - **Join Point**: Punto de ejecución donde se inserta el aspecto.
    - **Pointcut**: Conjunto de join points.
    - **Advice**: Código a ejecutar en un pointcut.
    - **Weaving**: Proceso de integración de aspectos en el código base.

### 4. Síntomas de Mala Modularidad

- **Code Tangling**: Múltiples preocupaciones en un módulo.
- **Code Scattering**: Una preocupación implementada en múltiples módulos.

### 5. Paradigma Orientado a Componentes

- **Definición**: Componente = Unidad independiente y desplegable con interfaces.
- **Características**: Composable, desplegable, documentado, independiente, estandarizado.
- **Proceso**:
    1. Análisis y búsqueda de componentes.
    2. Modificación de requerimientos.
    3. Diseño con reuso.
    4. Desarrollo e integración.

### 6. Ventajas y Limitaciones

- **Ventajas**: Reducción de costos, tiempo de desarrollo.
- **Limitaciones**: Pérdida de control, ajuste forzado de requerimientos.

### 7. Modelos de Componentes

- Ejemplos: EJB, .NET, CORBA.

---

## 🧠 Puntos Clave para Recordar

- Diseño de software abarca desde la arquitectura hasta la implementación detallada.
- Los principios de diseño guían la creación de sistemas modulares y mantenibles.
- Git es esencial para el control de versiones y colaboración.
- AOP y Componentes son paradigmas que mejoran la modularidad y reutilización.