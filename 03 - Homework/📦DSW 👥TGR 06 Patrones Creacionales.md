---
tags:
  - 📦DSW
  - 👥TGR
cssclasses:
  - center-titles
---

# Taller Grupal #06

## ✅ Estado del Proyecto

- [ ] **Sección A:** Reporte de patrones (0%)
- [ ] **Sección B:** Diagramas UML (0%) 
- [ ] **Sección C:** Implementación Java (0%)

---

## 🎯 Fase 1: Análisis y Planificación

### 1.1 Comprensión del Problema
> [!info] Contexto del Sistema
> Sistema de administración de productos para tienda con:
> - Artículos físicos y digitales
> - Gestión de categorías e inventario
> - Base de datos central única
> - Creación flexible de nuevos tipos de productos

### 1.2 Identificación de Patrones
> [!tip] Patrones a Considerar
> - **Singleton**: Para el componente único de acceso a BD
> - **Factory Method/Abstract Factory**: Para creación de productos
> - **Builder**: Opcional para productos complejos

### 1.3 Definición de Supuestos
> [!warning] Supuestos Clave
> - Base de datos relacional (MySQL/PostgreSQL)
> - Sistema monolítico (no microservicios)
> - No hay requerimientos de concurrencia avanzada
> - Los productos comparten atributos base (id, nombre, precio)

---

## 📋 Fase 2: Sección A - Reporte (30%)

### 2.1 Patrón Singleton - Acceso a Datos
- [ ] **Objetivo**: Garantizar una única instancia de conexión a BD
- [ ] **Motivación**: Evitar duplicación de recursos y conflictos
- [ ] **Consecuencias**: 
  - ✅ Control centralizado
  - ✅ Ahorro de recursos
  - ❌ Posible cuello de botella
- [ ] **Relación con SOLID**:
  - **SRP**: Gestión única de conexión
  - **DIP**: Depender de abstracciones de BD

### 2.2 Patrón Factory - Creación de Productos
- [ ] **Objetivo**: Crear productos dinámicamente según tipo
- [ ] **Motivación**: Extensibilidad sin modificar código existente
- [ ] **Consecuencias**:
  - ✅ Fácil añadir nuevos tipos
  - ✅ Código organizado
  - ❌ Mayor complejidad inicial
- [ ] **Relación con SOLID**:
  - **OCP**: Abierto a extensión
  - **SRP**: Responsabilidad única en creación

> [!success] Checklist Sección A
> - [ ] Reporte completo de ambos patrones
> - [ ] Justificación clara de elección
> - [ ] Supuestos documentados
> - [ ] Relación con principios SOLID

---

## 📊 Fase 3: Sección B - Diagramas UML (40%)

### 3.1 Diagrama de Clases
- [ ] **Paquete `database`**:
  - Clase `DatabaseConnection` (Singleton)
  - Métodos: `getInstance()`, `connect()`, `query()`
- [ ] **Paquete `products`**:
  - Interfaz `Product`
  - Clases abstractas/concretas: `PhysicalProduct`, `DigitalProduct`
  - Factory: `ProductFactory`
- [ ] **Relaciones**:
  - Herencia entre productos
  - Dependencia Factory → Product
  - Asociación Singleton → Database

### 3.2 Diagramas de Secuencia
- [ ] **Secuencia 1**: Obtención de instancia Singleton
- [ ] **Secuencia 2**: Creación de producto físico
- [ ] **Secuencia 3**: Creación de producto digital

> [!bug] Herramientas Recomendadas
> ```text
> - Visual Paradigm (recomendado)
> - PlantUML (gratuito)
> - Draw.io (gratuito)
> - Lucidchart
> ```

---

## 💻 Fase 4: Sección C - Implementación Java (30%)

### 4.1 Estructura de Paquetes
```java
src/
├── database/
│   └── DatabaseConnection.java
├── products/
│   ├── Product.java
│   ├── PhysicalProduct.java
│   ├── DigitalProduct.java
│   └── ProductFactory.java
└── Main.java
```

### 4.2 Implementación Singleton
```java
// DatabaseConnection.java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() { /* conexión real */ }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

### 4.3 Implementación Factory
```java
// ProductFactory.java
public class ProductFactory {
    public static Product createProduct(String type, String name, double price) {
        switch (type.toLowerCase()) {
            case "physical":
                return new PhysicalProduct(name, price);
            case "digital":
                return new DigitalProduct(name, price);
            default:
                throw new IllegalArgumentException("Tipo no soportado");
        }
    }
}
```

> [!success] Checklist Implementación
> - [ ] Singleton thread-safe (opcional)
> - [ ] Factory extensible para nuevos tipos
> - [ ] Atributos específicos por producto
> - [ ] Código compilable y ejecutable

---

## 📦 Fase 5: Empaquetado y Entrega

### 5.1 Documento Final
- [ ] Carátula con integrantes del equipo
- [ ] Tabla de contenido
- [ ] Herramientas de modelado especificadas
- [ ] Imágenes de diagramas en alta resolución
- [ ] Reporte completo de patrones

### 5.2 Estructura de Archivos
```
entrega/
├── documento/
│   └── TallerPatrones.pdf
├── src/
│   ├── database/
│   ├── products/
│   └── Main.java
└── README.txt
```

### 5.3 Validación Final
> [!warning] Puntos de Verificación
> - [ ] Todos los patrones correctamente implementados
> - [ ] Diagramas UML coherentes con código
> - [ ] Justificaciones claras y concisas
> - [ ] Código compila sin errores
> - [ ] Archivo ZIP/RAR correctamente estructurado

---

## 🚀 Siguientes Pasos Inmediatos

1. **Hoy**: Reunión de equipo para asignar roles
2. **Día 2**: Diseñar diagramas de clases preliminares
3. **Día 3**: Implementar código base de patrones
4. **Día 4**: Revisión y ajustes finales
5. **Día 5**: Empaquetado y entrega

> [!quote] Recordatorio Importante
> "Mantener el foco en dos piezas: acceso a datos y creación de productos"
> — Especificaciones del Taller
