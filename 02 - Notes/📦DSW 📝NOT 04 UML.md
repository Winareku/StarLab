---
fecha: 2025-10-20
tags:
  - 📦DSW
  - 📝NOT
cssclasses:
---
# Lenguaje Unificado de Modelado (UML) - Casos de Uso, Clases y Secuencia

---

## 1. Introducción a UML

> [!info] UML es un **estándar de facto** para el modelado orientado a objetos que integra varias notaciones de los años 80 y 90.
> ![[📦DSW 📝NOT 04 UML - Image 01.png]]

| Aspecto | Descripción |
|---------|-------------|
| **Origen** | Integración de notaciones de modelado OO de los 80s y 90s |
| **Propósito** | Describir notaciones para modelos durante análisis y diseño OO |
| **Estado actual** | Estándar de facto para modelado orientado a objetos |

---

## 2. Diagramas de Casos de Uso

> [!info] Representan las **interacciones** entre los actores y el sistema desde la perspectiva del usuario.

### Relaciones Principales
| Tipo | Símbolo | Propósito |
|------|---------|-----------|
| **Include** | `<<include>>` | Comportamiento **obligatorio** que siempre se ejecuta |
| **Extend** | `<<extend>>` | Comportamiento **opcional** que puede ejecutarse |

> [!example] **Ejercicio: Sistema de Registro Académico**
> - **Caso de uso**: "Registrarse en un paralelo"
> - **Actores**: Estudiante (principal), Sistema (secundario)
> - **Precondiciones**: Estudiante autenticado, materia con cupos disponibles
> - **Flujo principal**: Selección → Verificación → Confirmación → Notificación

---

## 3. Diagramas de Clases

> [!info] Muestran la **estructura estática** del sistema mediante clases, atributos, operaciones y relaciones.

### Elementos de una Clase
```plaintext
Book
#title : String
+available : Boolean = true
+create()
+borrow(c:Copy)
```

### Visibilidad en Atributos y Métodos
| Símbolo | Visibilidad | Acceso |
|---------|-------------|--------|
| **+** | Público | Cualquier clase puede acceder |
| **#** | Protegido | Clase y subclases pueden acceder |
| **-** | Privado | Solo la misma clase puede acceder |

### Tipos de Relaciones
| Relación | Símbolo | Descripción |
|----------|---------|-------------|
| **Asociación** | `----` | Conexión básica entre clases |
| **Agregación** | `◇----` | Relación parte-todo **débil** |
| **Composición** | `◆----` | Relación parte-todo **fuerte** |
| **Herencia** | `▷-----` | Relación de generalización |

> [!warning] **Multiplicidad** es crucial: indica cuántos objetos participan en una relación (ej: `1..*`, `0..1`)

---

## 4. Diagramas de Secuencia

> [!info] Muestran las **interacciones temporales** entre objetos en un caso de uso específico.

### Elementos Clave
| Elemento | Representación | Propósito |
|----------|----------------|-----------|
| **Línea de vida** | Línea vertical | Representa un objeto durante el tiempo |
| **Activación** | Rectángulo delgado | Período de ejecución de un método |
| **Mensaje** | Flecha horizontal | Comunicación entre objetos |

### Operadores en UML 2.0
| Operador | Símbolo | Propósito |
|----------|---------|-----------|
| **alt** | `alt` | Fragmento alternativo condicional |
| **opt** | `opt` | Fragmento opcional |
| **loop** | `loop` | Fragmento que se repite |

> [!example] **Ejemplo: Máquina de Autoservicio**
> ```
> Front → Register: Insert(Input)
> Front → Register: Select(Selection)  
> Register → Dispenser: Deliver(Selection)
> Dispenser → Front: Notify()
> ```

### Tipos de Mensajes
| Tipo | Símbolo | Comportamiento |
|------|---------|----------------|
| **Síncrono** | `→` | El emisor espera la respuesta |
| **Asíncrono** | `→` | El emisor continúa sin esperar |
| **Return** | `←` | Retorno de llamada síncrona |

---

## 5. Enfoques para Identificar Clases

> [!success] Estrategias **data-driven** para descubrir clases en el dominio del problema:

| Enfoque | Ejemplos |
|---------|----------|
| **Entidades tangibles** | Libro, Curso, Producto |
| **Roles** | Estudiante, Administrador, Profesor |
| **Eventos** | Inscripción, Préstamo, Pago |
| **Interacciones** | Reunión, Transacción, Reserva |

> [!warning] No todas las relaciones 1-a-muchos implican **propiedad** (agregación/composición)

---

## 6. Puntos Clave para Recordar

> [!info] **Conceptos Fundamentales**
> - UML sirve para **visualizar, especificar, construir y documentar** sistemas software
> - Los **modelos** capturan la esencia del sistema, los **diagramas** los visualizan
> - Principales diagramas: **Casos de Uso, Clases, Secuencia**

> [!warning] La **usabilidad** de los diagramas depende de su claridad y consistencia

---

## 7. Lectura Adicional

> [!example] **Libros Recomendados**
> - *Rumbaugh, Jacobson & Booch*: "The Unified Modeling Language Reference Manual" (Capítulos 1-5, 8)
> - *Stevens & Pooley*: "Using UML" (Capítulos 1-3, 5-9)
> - *Pressman & Maxim*: "Software Engineering" (Apéndices 1 y 2)

---

> [!success] **Próximo Tema**: Proceso de implementación a partir de un diseño UML