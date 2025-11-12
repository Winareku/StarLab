---
tags:
  - 📦DSW
  - 📝NOT
cssclasses:
  - center-titles
  - embed-auto
  - embed-inverse
---
# Patrones de Diseño

## 1. Introducción a los Patrones de Diseño

> [!info] ¿Qué es un patrón?
> Es un modelo que sirve de muestra para sacar otra cosa igual. Los patrones facilitan la **reutilización** de diseños y arquitecturas de software exitosos.

> [!quote] Breve historia
> - **1977** – Christopher Alexander identificó patrones en Arquitectura
> - **1987** – Cunningham and Beck aplicaron estos conceptos en Smalltalk-80
> - **1995** – Gang of Four (GoF) publicó el libro seminal "Design Patterns"

> [!success] Ventajas
> - Proporcionan estructura conocida por todos los programadores
> - Permiten código común entre proyectos
> - Ahorran tiempo en desarrollo
> - Software más fácil de comprender, mantener y extender

> [!warning] Desventajas
> - Dependientes del paradigma orientado a objetos
> - Difíciles de usar cuando las similitudes con los patrones son escasas

---

## 2. Elementos de un Patrón de Diseño

| Componente | Descripción |
| ---------- | ----------- |
| **Nombre** | Identifica el patrón y define terminología |
| **Alias** | Otros nombres por los que se conoce |
| **Problema** | Situación que resuelve el patrón |
| **Solución** | Descripción en lenguaje natural de la solución |
| **Estructura** | Clases, objetos y diagramas de la solución |
| **Consecuencias** | Ventajas y desventajas del uso del patrón |
| **Implementación** | Parte crítica del código |
| **Usos conocidos** | Sistemas que inspiraron al patrón |

---

## 3. Taxonomía de Patrones de Diseño

### 3.1 Clasificación por Propósito

| Tipo | Propósito |
| ---- | --------- |
| **Creacionales** | Controlan el proceso de creación de objetos |
| **Estructurales** | Tratan sobre la composición de clases u objetos |
| **Comportamiento** | Definen formas de interacción y distribución de responsabilidades |

### 3.2 Tabla Completa de Patrones GoF

| Scope | Creacional | Estructural | Behavioral |
| ----- | ---------- | ----------- | ---------- |
| **Class** | Factory Method | Adapter (class) | Interpreter, Template Method |
| **Object** | Abstract Factory, Builder, Prototype, Singleton | Adapter (object), Bridge, Composite, Decorator, Facade, Flyweight, Proxy | Chain of Responsibility, Command, Iterator, Mediator, Memento, Observer, State, Strategy, Visitor |

> [!info] Definiciones
> - **Scope**: Dominio sobre el cual se aplica un patrón
> - **Purpose**: Qué hace el patrón

---

## 4. Patrones Creacionales

> [!info] Descripción
> Abstrael y controlan la forma de crear objetos, haciendo que los sistemas sean independientes de la creación, composición y representación de los objetos.

### 4.1 Builder

> [!example] Propósito
> Separa la construcción de un objeto complejo de su representación, permitiendo el mismo proceso de construcción para crear representaciones diferentes.

```java
// Ejemplo: Sistema de construcción de vehículos
public abstract class VehiculoBuilder {
    protected Vehículo v;
    
    public abstract void DefinirVehiculo();
    public abstract void ConstruirRuedas();
    public abstract void ConstruirHabitaculo();
    public abstract void ConstruirMotor();
    public abstract void DefinirExtras();
}
```

> [!success] Aplicación
> - Compiladores (análisis léxico, sintáctico, semántico)
> - Construcción de vehículos con diferentes configuraciones
> - Cualquier objeto complejo que requiera construcción paso a paso

> [!example] Video
> ![[PATRÓN de DISEÑO BUILDER en JAVA - Tutorial Completo Fácil.mkv]]

### 4.2 Singleton

> [!example] Propósito
> Asegura que una clase sólo tenga una instancia y proporciona un punto de acceso global a ésta.

```java
public class SingleObject {
    private static SingleObject instance = new SingleObject();
    
    private SingleObject(){}
    
    public static SingleObject getInstance(){
        return instance;
    }
}
```

> [!warning] Consideraciones
> - Útil para gestores de ventanas, sistemas de archivos
> - Acceso controlado a instancia única
> - Reduce espacio de nombres vs variables globales

> [!example] Video
> ![[SINGLETON ｜ PATRONES de DISEÑO [GGq6s7xhHzY].webm]]
> ![[Curso de Patrones de diseño - 2 Singleton.mkv]]

### 4.3 Factory Method

> [!example] Propósito
> Permite que una clase difiera la instanciación de objetos a las subclases.

```java
public interface Product {
    public void operation();
}

public abstract class Creator {
    public abstract Product factoryMethod();
}
```

> [!success] Ventajas
> - Centralización de la creación de objetos
> - Facilita escalabilidad del sistema
> - Cliente se abstrae de la instancia a crear

> [!example] Video
> ![[FACTORY ｜ PATRONES de DISEÑO [lLvYAzXO7Ek].webm]]
> ![[Curso de Patrones de diseño - 3 Fábrica.mkv]]

### 4.4 Abstract Factory

> [!example] Propósito
> Provee una interfaz para crear familias de objetos relacionados sin especificar sus clases concretas.

```java
public interface OSComponents {
    Window mWindow();
    Menu sMenu();
    Panel aPanel();
}
```

> [!example] Video
> ![[ABSTRACT FACTORY ｜ PATRONES de DISEÑO [CVlpjFJN17U].webm]]
> ![[Curso de Patrones de diseño - 4 Fábrica Abstracta.mkv]]

### 4.5 Comparación Builder vs Factory Method

| Aspecto | Builder | Factory Method |
| ------- | ------- | -------------- |
| **Enfoque** | Construcción paso a paso de objetos complejos | Creación de familia de objetos relacionados |
| **Resultado** | Composición de objetos | Instancia única |
| **Complejidad** | Mayor flexibilidad en construcción | Más simple, creación directa |
| **Ejemplo** | Auto con partes específicas | Carro, Bus, Avión como Vehículos |

---

## 5. Modelos de Negocio Genéricos

> [!info] Reutilización de modelos
> Los patrones permiten identificar similitudes entre diferentes dominios:

| Biblioteca | Hotel | Modelo Genérico |
| ---------- | ----- | --------------- |
| Catalog | Hotel | Business Unit |
| Book-Title | Room Type | Product Type |
| Reservation | Reservation | Transaction Intention |
| Book-Copy | Room | Product |
| Loan | Stay | Effective Transaction |

> [!success] Beneficios
> - Evita reinventar la rueda repetidamente
> - Permite beneficiarse del conocimiento existente
> - Proporciona estructura conocida y probada

---

## 6. Consideraciones Finales

> [!tip] Para recordar
> - ¿Qué es un patrón de diseño?
> - ¿Para qué sirve?
> - ¿Cuál es la taxonomía de patrones?
> - Asocia ejemplos fáciles de recordar para cada patrón
