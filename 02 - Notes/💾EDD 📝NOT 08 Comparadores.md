---
tags:
  - 💾EDD
  - 📝NOT
cssclasses:
  - center-titles
---

# Comparadores en Java

## 1. Introducción a los Comparadores

> [!info] Definición
> **Comparator** es una interfaz funcional en Java que permite comparar dos objetos para definir su orden personalizado. Se utiliza para establecer órdenes alternativos diferentes al orden natural de una clase.

### 1.1 Comparator vs Comparable

| Característica   | Comparable               | Comparator                       |
| ---------------- | ------------------------ | -------------------------------- |
| **Ubicación**    | Implementado en la clase | Implementado externamente        |
| **Método**       | `compareTo()`            | `compare()`                      |
| **Orden**        | Orden natural único      | Múltiples órdenes personalizados |
| **Flexibilidad** | Limitada                 | Alta                             |

> [!example] Ejemplo Básico
> ```java
> // Comparator para ordenar Personas por edad
> class ComparadorPorEdad implements Comparator<Persona> {
>     @Override
>     public int compare(Persona p1, Persona p2) {
>         return Integer.compare(p1.edad, p2.edad);
>     }
> }
> ```

---

## 2. Método compare() - Funcionamiento Interno

> [!info] Comportamiento del método compare()
> El método `compare(T o1, T o2)` devuelve un entero que indica la relación entre dos objetos:

| Valor Retornado    | Significado              |
| ------------------ | ------------------------ |
| **Negativo (< 0)** | o1 debe preceder a o2    |
| **Cero (0)**       | o1 y o2 son equivalentes |
| **Positivo (> 0)** | o1 debe seguir a o2      |

> [!example] Ejemplo Práctico
> ```java
> Persona p1 = new Persona("Alice", 30);
> Persona p2 = new Persona("Bob", 25);
> 
> Comparator<Persona> comparador = (o1, o2) -> Integer.compare(o1.edad, o2.edad);
> int resultado = comparador.compare(p1, p2); // Retorna > 0 (Alice es mayor)
> ```

---

## 3. Formas de Implementar Comparator

### 3.1 Clases Separadas (Recomendado para reutilización)

> [!example] Implementación como Clase Separada
> ```java
> class ComparadorPorNombre implements Comparator<Persona> {
>     @Override
>     public int compare(Persona p1, Persona p2) {
>         return p1.nombre.compareTo(p2.nombre);
>     }
> }
> 
> // Uso
> personas.sort(new ComparadorPorNombre());
> ```

### 3.2 Clases Internas Estáticas

> [!example] Implementación como Clase Interna
> ```java
> class Persona {
>     String nombre;
>     int edad;
>     
>     public static class ComparadorPorEdad implements Comparator<Persona> {
>         @Override
>         public int compare(Persona p1, Persona p2) {
>             return Integer.compare(p1.edad, p2.edad);
>         }
>     }
> }
> ```

### 3.3 Clase con Constantes Estáticas

> [!example] Organización para Proyectos Grandes
> ```java
> public class PersonaComparators {
>     public static final Comparator<Persona> POR_NOMBRE = 
>         (p1, p2) -> p1.nombre.compareTo(p2.nombre);
>     
>     public static final Comparator<Persona> POR_EDAD = 
>         (p1, p2) -> Integer.compare(p1.edad, p2.edad);
> }
> 
> // Uso
> personas.sort(PersonaComparators.POR_EDAD);
> ```

### 3.4 Expresiones Lambda (Para casos simples)

> [!example] Uso de Lambdas
> ```java
> // Orden ascendente por edad
> personas.sort((p1, p2) -> Integer.compare(p1.edad, p2.edad));
> 
> // Orden descendente por edad
> personas.sort((p1, p2) -> Integer.compare(p2.edad, p1.edad));
> ```

---

## 4. Funcionalidades Avanzadas de Comparator

### 4.1 Múltiples Criterios con `thenComparing()`

> [!example] Ordenamiento por Múltiples Campos
> ```java
> // Ordenar primero por edad, luego por nombre
> Comparator<Persona> comparadorMultiple = 
>     Comparator.comparingInt((Persona p) -> p.edad)
>               .thenComparing(p -> p.nombre);
> 
> personas.sort(comparadorMultiple);
> ```

### 4.2 Métodos de Ayuda de Comparator

> [!info] Métodos Útiles
> ```java
> // Ordenar por nombre (ignore case)
> Comparator.comparing(Persona::getNombre, String.CASE_INSENSITIVE_ORDER);
> 
> // Ordenar en orden inverso
> Comparator.comparing(Persona::getEdad).reversed();
> 
> // Manejar valores nulos
> Comparator.nullsFirst(Comparator.comparing(Persona::getNombre));
> ```

---

## 5. Casos de Uso en Aplicaciones Reales

### 5.1 Sistema de Gestión de Inventarios

> [!example] Ordenar Productos por Precio
> ```java
> class Producto {
>     String nombre;
>     double precio;
> }
> 
> List<Producto> productos = new ArrayList<>();
> // Ordenar por precio ascendente
> productos.sort(Comparator.comparingDouble(p -> p.precio));
> ```

### 5.2 Sistema Académico

> [!example] Ordenar Estudiantes por Calificación
> ```java
> class Estudiante {
>     String nombre;
>     double calificacion;
> }
> 
> // Orden descendente por calificación
> estudiantes.sort((e1, e2) -> Double.compare(e2.calificacion, e1.calificacion));
> ```

### 5.3 Aplicación de Agenda de Contactos

> [!example] Múltiples Criterios para Contactos
> ```java
> class Contacto {
>     String nombreCompleto;
>     List<String> telefonos;
>     LocalDate fechaNacimiento;
>     String paisResidencia;
> }
> 
> // Comparadores personalizados
> class ComparadorPorCumpleanos implements Comparator<Contacto> {
>     @Override
>     public int compare(Contacto c1, Contacto c2) {
>         // Lógica para comparar por proximidad de cumpleaños
>     }
> }
> ```

---

## 6. Comparator en Estructuras de Datos

### 6.1 TreeSet y TreeMap

> [!example] TreeSet con Comparator Personalizado
> ```java
> TreeSet<Persona> personas = new TreeSet<>(
>     Comparator.comparingInt(p -> p.edad)
> );
> 
> personas.add(new Persona("Alice", 30));
> personas.add(new Persona("Bob", 25));
> // Se ordenan automáticamente por edad
> ```

### 6.2 PriorityQueue

> [!example] Cola de Prioridad Personalizada
> ```java
> PriorityQueue<Task> tareas = new PriorityQueue<>(new TaskComparator());
> 
> class TaskComparator implements Comparator<Task> {
>     @Override
>     public int compare(Task t1, Task t2) {
>         // Mayor prioridad primero, luego fecha más cercana
>         if (t1.getPrioridad() != t2.getPrioridad()) {
>             return Integer.compare(t2.getPrioridad(), t1.getPrioridad());
>         } else {
>             return t1.getDeadline().compareTo(t2.getDeadline());
>         }
>     }
> }
> ```

---

## 7. Comparator vs Otros Métodos de Comparación

### 7.1 Comparativa Completa

| Método         | Propósito             | Ventajas                      | Limitaciones                           |
| -------------- | --------------------- | ----------------------------- | -------------------------------------- |
| **==**         | Comparar referencias  | Rápido                        | Solo compara referencias, no contenido |
| **equals()**   | Comparar contenido    | Verifica equivalencia lógica  | Un solo criterio, requiere override    |
| **contains()** | Verificar pertenencia | Sencillo para colecciones     | Limitado al criterio de equals()       |
| **Comparator** | Ordenar y comparar    | Múltiples criterios, flexible | Configuración inicial más compleja     |

### 7.2 ¿Por qué Usar Comparator?

> [!success] Ventajas Clave
> 1. **Flexibilidad**: Permite definir múltiples criterios sin modificar la clase original
> 2. **Desacoplamiento**: La lógica de comparación está separada de la clase
> 3. **Reutilización**: Los comparadores pueden usarse en diferentes contextos
> 4. **Compatibilidad**: Funciona con APIs de Java como Collections.sort() y TreeSet

> [!warning] Limitaciones de Otros Métodos
> ```java
> // ❌ Esto puede causar problemas
> for (Persona p : personas) {
>     if (p.edad == 25) {
>         personas.remove(p); // ConcurrentModificationException
>     }
> }
> 
> // ✅ Mejor usar Iterator con lógica personalizada
> Iterator<Persona> it = personas.iterator();
> while (it.hasNext()) {
>     Persona p = it.next();
>     if (p.edad == 25) {
>         it.remove();
>     }
> }
> ```

---

## 8. Búsqueda con Comparator

### 8.1 Método findAll Personalizado

> [!example] Búsqueda con Criterios Personalizados
> ```java
> public static <T> List<T> findAll(List<T> elements, 
>                                  Comparator<T> cmp, 
>                                  T referencia) {
>     List<T> resultados = new ArrayList<>();
>     for (T element : elements) {
>         if (cmp.compare(element, referencia) == 0) {
>             resultados.add(element);
>         }
>     }
>     return resultados;
> }
> 
> // Uso: buscar personas de la misma ciudad
> Persona referencia = new Persona("", 0);
> referencia.ciudad = "Guayaquil";
> 
> List<Persona> resultados = findAll(personas, 
>     (p1, p2) -> p1.ciudad.equals(p2.ciudad) ? 0 : 1, 
>     referencia);
> ```

---

## 9. Mejores Prácticas y Organización

### 9.1 Estrategias de Organización

| Escenario                      | Enfoque Recomendado            |
| ------------------------------ | ------------------------------ |
| **Comparadores simples**       | Expresiones lambda             |
| **Comparadores reutilizables** | Clases separadas               |
| **Proyectos grandes**          | Clase con constantes estáticas |
| **Lógica compleja**            | Clases internas estáticas      |

### 9.2 Consejos de Implementación

> [!tip] Buenas Prácticas
> 1. Usar `Integer.compare()`, `Double.compare()` para evitar errores de desbordamiento
> 2. Considerar el uso de `Comparator.comparing()` para código más legible
> 3. Implementar `thenComparing()` para criterios múltiples
> 4. Documentar el comportamiento del comparador

> [!bug] Errores Comunes
> ```java
> // ❌ Propenso a errores de desbordamiento
> return p1.edad - p2.edad;
> 
> // ✅ Forma correcta
> return Integer.compare(p1.edad, p2.edad);
> ```

---

## 10. Resumen y Conclusiones

> [!success] Cuándo Usar Comparator
> 1. Cuando necesitas múltiples formas de ordenar una clase
> 2. Para definir órdenes personalizados sin modificar la clase original
> 3. Al trabajar con estructuras de datos que requieren ordenamiento
> 4. Para implementar búsquedas con criterios complejos

> [!quote] Conclusión
> Los comparadores en Java proporcionan un mecanismo poderoso y flexible para definir órdenes personalizados y criterios de comparación. Su capacidad para trabajar de forma externa a las clases, combinada con la compatibilidad con las principales APIs de Java, los convierte en una herramienta esencial para el desarrollo de aplicaciones robustas y mantenibles.