---
tags:
  - 📦DSW
  - 📝NOT
cssclasses:
  - center-titles
---
---
# Diseño de Software

| **Definición 1** | Proceso que define la arquitectura, componentes, interfaces y características de un sistema.                                                                                                                                |
| ---------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Definición 2** | Es una descripción de la estructura del software a ser implementado, los modelos de datos y estructuras usadas por el sistema, las interfaces entre los componentes del sistema y, algunas veces los algoritmos utilizados. |

### Componentes de Software
- **Definición**: Bloque modular, desplegable y reemplazable que encapsula implementación y expone interfaces.
- **Características**: Independiente, ejecutable, más abstracto que las clases.

### Principios de Diseño

> 1. **Abstracción**
> Se refiere a la vista de un objeto enfocándose en la información relevante e ignorando el resto de la información.

> 2. **Acoplamiento y Cohesión**
> Acoplamiento es el **grado de interdependencia** o interconexión **entre los módulos** de un software, mientras que cohesión se define como el **grado de relación entre las responsabilidades** asignadas a un módulo.

> 3. **Descomposición y Modularización**
> Significa que un software es dividido en un número de componentes más pequeños con interfaces bien definidas que describen las interacciones entre los componentes.

> 4. **Encapsulamiento**
> Significa agrupar y empaquetar los detalles internos de una abstracción y hacer esos detalles inaccesibles a entidades externas.

> 5. **Separación de Interfaz e Implementación**
> Implica definir un componente especificando una interfaz pública (conocida para los clientes) que está separada de los detalles de cómo el componente está implementado.

> 6. **Suficiencia, Completitud y Primitivismo**
> Alcanzar suficiencia y completitud significa asegurar que un componente de software captura todas las características importantes para alcanzar su objetivo, no más y no menos. Primitivismo significa que el diseño debería estar basado en patrones que sean de fácil implementación.

> 7. **Separación de Preocupaciones**
> Una preocupación **(Concern)** es un área de interés con respecto al diseño de un software. La arquitectura de un software debe tener una o varias vistas de preocupaciones que permitan a los interesados concentrarse en pocas cosas a la vez a fin de reducir la complejidad
### Diseño Arquitectural vs. Detallado
- **Arquitectural**: Decisiones de alto nivel (plataforma, componentes, comunicación, concurrencia).
- **Detallado**: Refinamiento hasta clases, interfaces, relaciones y patrones.
### Estilos Arquitectónicos
- Centrado en Datos
- Flujo de Datos (Pipes and Filters)
- Capas (Layered)
- Llamada y Retorno
- Orientado a Objetos
### Control de Versiones con Git
- **Conceptos**: Repositorio, Commit, Stage, Ramas.
- **Ventajas**: Historial, colaboración, reversión de cambios.
- **Git vs. GitHub**: Local vs. Remoto, ramas principales `main`.