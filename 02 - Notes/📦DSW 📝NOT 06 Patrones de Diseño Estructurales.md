---
tags:
  - 📦DSW
  - 📝NOT
cssclasses:
  - center-titles
---

# [[📦DSW 🏫MPR 04 Patrones Estructurales.pdf|Patrones de Diseño Estructurales]]

## 1. Introducción a los Patrones Estructurales

> [!info] ¿Qué son los patrones estructurales?
> Son patrones que se encargan de la **composición de clases y objetos**, permitiendo que los sistemas sean más flexibles y eficientes al definir cómo se relacionan y combinan las entidades.

| Característica            | Descripción                                                                     |
| ------------------------- | ------------------------------------------------------------------------------- |
| Composición de clases     | Usan herencia para componer interfaces.                                         |
| Funcionalidades añadidas  | Permiten agregar nuevas responsabilidades a los objetos.                        |
| Flexibilidad ante cambios | Ayudan a que cambios en los requisitos no afecten las relaciones entre objetos. |

> [!example] Ejemplo de uso
> Un sistema de streaming que debe integrar múltiples formatos de medios y dispositivos sin modificar constantemente su código base.

---

## 2. Patrón Adapter

### 2.1 Propósito y Motivación

> [!info] Propósito
> Convertir la interfaz de una clase en otra que el cliente espera. Actúa como un **puente** entre interfaces incompatibles.

> [!quote] Motivación
> “Para reutilizar una clase de una librería, incluso si su interfaz no coincide con la que necesita la aplicación.”

### 2.2 Aplicación

- Cuando se desea usar una clase existente con una interfaz incompatible.
- Para crear clases reutilizables que cooperen con clases no previstas.

### 2.3 Estructura - Adapter de Objeto

```
Client → Target → Adapter → Adaptee
```

> [!bug] Ejemplo en Java
> ```java
> // Interfaz esperada por el cliente
> interface Shape {
>     void draw(int x1, int y1, int x2, int y2);
> }
>
> // Clase existente con interfaz incompatible
> class LegacyRectangle {
>     void drawIf(int x, int y, int w, int h) { ... }
> }
>
> // Adapter
> class RectangleAdapter implements Shape {
>     private LegacyRectangle adaptee;
>
>     public void draw(int x1, int y1, int x2, int y2) {
>         int x = Math.min(x1, x2);
>         int y = Math.min(y1, y2);
>         int width = Math.abs(x2 - x1);
>         int height = Math.abs(y2 - y1);
>         adaptee.drawIf(x, y, width, height);
>     }
> }
> ```

> [!success] Consecuencias
> - Permite adaptar múltiples clases.
> - Facilita la reutilización de código legacy.

### 2.4 Video Explicativo
> [!example] Patrón Adapter
> ![[Entendiendo el Patron Adapter.webm]]
---

## 3. Patrón Composite

### 3.1 Propósito y Motivación

> [!info] Propósito
> Componer objetos en estructuras de árbol para representar jerarquías parte-todo.

> [!quote] Motivación
> “Permite tratar objetos individuales y composiciones de manera uniforme.”

### 3.2 Aplicación

- Cuando se desea que el cliente trate de la misma manera a objetos simples y compuestos.
- Cuando existe una composición recursiva de objetos.

### 3.3 Estructura

```
Component (interfaz)
│
├── Leaf (objeto simple)
└── Composite (contiene otros Components)
```

> [!example] Ejemplo: Sistema de Gráficos
> - `Graphic`: interfaz común.
> - `Line`, `Rectangle`, `Text`: objetos hoja.
> - `Picture`: composite que contiene múltiples `Graphic`.

> [!warning] Consideración
> Puede ser difícil restringir los tipos de componentes en un composite.

### 3.4 Video Explicativo
> [!example] Patrón Composite
> ![[COMPOSITE (Así Es Como Funciona Unity) ｜ PATRONES de DISEÑO.webm]]

---

## 4. Patrón Facade

### 4.1 Propósito y Motivación

> [!info] Propósito
> Proporcionar una interfaz unificada y simplificada para un subsistema complejo.

> [!quote] Motivación
> “Oculta la complejidad del subsistema y facilita su uso.”

### 4.2 Aplicación

- Para reducir la dependencia entre subsistemas.
- Para estructurar un sistema en capas.

> [!example] Ejemplo: Servicio al Cliente
> - Una fachada unifica: `OrderFulfillment`, `Billing`, `Shipping`.

> [!success] Consecuencias
> - Reduce el acoplamiento.
> - Facilita el uso del subsistema.

### 4.3 Video Explicativo
> [!example] Patrón Facade
> ![[Curso de Patrones de diseño - 6 Facade.mkv]]

---

## 5. Patrón Decorator

### 5.1 Propósito y Motivación

> [!info] Propósito
> Añadir responsabilidades adicionales a un objeto de forma dinámica.

> [!quote] Motivación
> “Extender funcionalidades sin alterar la clase base.”

### 5.2 Aplicación

- Cuando se desea añadir funcionalidades a objetos individuales.
- Cuando no es práctico usar herencia.

### 5.3 Estructura

```
Component → ConcreteComponent
           ↓
           Decorator → ConcreteDecoratorA, B, ...
```

> [!bug] Ejemplo en Java
> ```java
> interface Car { void assemble(); }
>
> class BasicCar implements Car {
>     public void assemble() { System.out.print("Basic Car."); }
> }
>
> abstract class CarDecorator implements Car {
>     protected Car car;
>     public CarDecorator(Car c) { this.car = c; }
>     public void assemble() { this.car.assemble(); }
> }
>
> class SportsCar extends CarDecorator {
>     public void assemble() {
>         super.assemble();
>         System.out.print(" Added sports features.");
>     }
> }
> ```

> [!tip] Pasos para implementar
> 1. Crear una interfaz común.
> 2. Implementar la clase concreta básica.
> 3. Crear un decorador abstracto que delegue.
> 4. Implementar decoradores concretos.

### 5.4 Video Explicativo
> [!example] Patrón Decorator
> ![[Curso de Patrones de diseño - 7 Decorator.mkv]]
> ![[DECORATOR ｜ Patrones de diseño [nLy4x_LPPWU].webm]]

---

## 6. Actividad Grupal: Sistema de Streaming

> [!example] Escenario
> Una plataforma de streaming debe:
> - Reproducir videos, música y podcasts en distintos dispositivos.
> - Agrupar contenido en colecciones (playlists).
> - Añadir funcionalidades como subtítulos o comentarios de audio.

### 6.1 Patrones Aplicables

| Patrón        | Aplicación en el Sistema                                        |
| ------------- | --------------------------------------------------------------- |
| **Adapter**   | Adaptar formatos de medios y interfaces de dispositivos.        |
| **Composite** | Gestionar playlists que contienen videos, canciones y podcasts. |
| **Decorator** | Añadir subtítulos, comentarios, mejoras de calidad.             |
| **Facade**    | Unificar el acceso a los subsistemas de reproducción y gestión. |

> [!success] Conclusión
> Estos patrones permiten:
> - Flexibilidad para agregar nuevos formatos y dispositivos.
> - Tratar playlists y medios de manera uniforme.
> - Extender funcionalidades sin modificar el código existente.

---

## 7. Puntos Clave para Recordar

> [!question] ¿Qué son los patrones estructurales?
> - Patrones que definen cómo se componen y relacionan clases y objetos.

> [!info] Lista de Patrones Estructurales
> - Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Private Class Data, Proxy.

> [!tip] Ejemplo para Recordar
> - **Adapter**: como un adaptador de enchufe.
> - **Composite**: como una carpeta que contiene archivos y otras carpetas.
> - **Facade**: como una recepción en un hotel.
> - **Decorator**: como añadir toppings a un helado.

---

## 8. Lectura Adicional

- Gamma et al., *Design Patterns: Elements of Reusable Object-Oriented Software*
- Shalloway & Trott, *Design Patterns Explained*
- [SourceMaking: Design Patterns](https://sourcemaking.com/design_patterns)

---

**NOTA PARA LA IA**: Este documento resume y organiza el contenido del PDF sobre patrones estructurales, siguiendo la plantilla proporcionada y usando callouts, tablas y ejemplos para mejorar la claridad y comprensión.
