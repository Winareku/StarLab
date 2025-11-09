---
tags:
  - [MATERIA]       # Ej: #🎨IHC
  - [TIPO_ARCHIVO]  # Ej: #📝NOT
cssclasses:
  - center-titles
  - embed-auto
---

# Título Principal del Documento

---

## 1. Primera Sección

> [!info] Información clave
> Descripción general del concepto principal.

| Concepto A | Concepto B | Diferencia |
|------------|------------|------------|
| Característica 1 | Característica 1 | Explicación |
| Característica 2 | Característica 2 | Explicación |

> [!example] Ejemplo práctico
> Caso de uso concreto con aplicación real.

---

## 2. Segunda Sección

### 2.1 Subsección

> [!info] Instrucción para la IA
> Todo el contenido de un callout debe estar contenido después del símbolo “>” y debe haber por lo menos un salto de línea entre callouts diferentes. No pongas tablas dentro de callouts, siempre debes dejar un salto de línea (línea vacía) antes de una tabla.
> > [!info] También puede haber callouts dentro de callouts y el nivel se define por el número de “>”.

> [!warning] Punto importante
> Aspectos críticos o advertencias sobre el tema.

> [!success] Buenas prácticas
> Recomendaciones y enfoques efectivos.

> [!bug] Código
> ```java
> // Ejemplos de código cuando sea relevante
> public class Ejemplo {
>     // implementación
> }
> ```

> [!quote] Definición o cita
> Conceptos fundamentales o citas relevantes.

> [!bug] Fórmulas o Ecuaciones (Latex)
> - Para escribir en latex dentro de la misma linea se usa $ para abrir y cerrar, procura no poner espacios entre los signos y la ecuación dentro. Por ejemplo: $2+2=4$ o $\omega$
> - Para poner una ecuación fuera de línea, es decir, que está fuera de linea, usa doble signo de dolar, ejemplo:
> $$
> \omega + \alpha = \beta
> $$
---

### SISTEMA DE IDENTIFICACIÓN (INCLUIR EN TAGS)

#### MATERIAS DISPONIBLES
| **Materia** | **Tag** | **Para usar** |
|-------------|---------|---------------|
| Estadística | #📊EST | 📊EST |
| Interacción H-C | #🎨IHC | 🎨IHC |
| Bases de Datos | #🗃️SBD | 🗃️SBD |
| Estructuras de Datos | #💾EDD | 💾EDD |
| Diseño de Software | #📦DSW | 📦DSW |
| Misceláneos | #🔰MISC | 🔰MISC |

#### TIPOS DE ARCHIVO
| **Tipo** | **Tag** | **Para usar** |
|----------|---------|---------------|
| Apuntes | #📝NOT | 📝NOT |
| Libros | #📚LIB | 📚LIB |
| Taller Individual | #💻TIN | 💻TIN |
| Taller Grupal | #👥TGR | 👥TGR |
| Tarea | #📝TAR | 📝TAR |
| Material | #🏫MPR | 🏫MPR |
| Exámenes | #🧠EXA | 🧠EXA |
| Proyectos | #🚀PRO | 🚀PRO |
| Prácticas | #🔬LAB | 🔬LAB |

### TIPOS DE CALLOUTS DISPONIBLES
- `> [!note]` - Notas generales
- `> [!tip]` - Consejos útiles
- `> [!success]` - Éxitos/completados
- `> [!question]` - Preguntas/dudas
- `> [!warning]` - Advertencias
- `> [!failure]` - Fallos/errores
- `> [!danger]` - Peligros críticos
- `> [!bug]` - Errores en código
- `> [!example]` - Ejemplos prácticos
- `> [!quote]` - Citas textuales
- `> [!info]` - Información adicional

### CONVENCIONES DE ESCRITURA
- Usar **negritas** para conceptos importantes
- Mantener tablas alineadas y claras
- Incluir ejemplos de código cuando sea relevante
- Separar secciones con `---`

**NOTA PARA LA IA**: Esta plantilla debe usarse como guía para estructurar cualquier nuevo documento o resumen, manteniendo la coherencia visual y organizativa con los documentos existentes.