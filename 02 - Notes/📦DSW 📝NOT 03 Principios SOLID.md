---
tags:
  - 📦DSW
  - 📝NOT
cssclasses:
  - center-titles
---
---
# Principios SOLID

> [!info] Definición
> Los principios SOLID son un conjunto de cinco principios de diseño de software que, cuando se aplican, ayudan a los desarrolladores a crear sistemas más comprensibles, flexibles y mantenibles. Fueron popularizados por Robert C. Martin (también conocido como "Uncle Bob").

| **Nombre completo**             | **Descripción breve**                                                                                                                |
| ------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| Single Responsibility Principle | Cada clase debe tener **una sola responsabilidad** o motivo para cambiar.                                                            |
| Open/Closed Principle           | El código debe estar **abierto a extensión, pero cerrado a modificación**. Puedes agregar funciones sin tocar lo ya hecho.           |
| Liskov Substitution Principle   | Las **subclases deben poder reemplazar a sus clases base** sin alterar el comportamiento del programa.                               |
| Interface Segregation Principle | Es mejor tener **interfaces pequeñas y específicas** que una grande y genérica. Las clases no deben implementar métodos que no usan. |
| Dependency Inversion Principle  | Las clases deben **depender de abstracciones (interfaces)** y no de implementaciones concretas. Esto reduce el acoplamiento.         |

---

## 1. [S] - Principio de Responsabilidad Única

> [!quote] Descripción
> Una clase debe tener una, y solo una, razón para cambiar. Esto significa que una clase debe tener una única responsabilidad bien definida. Si una clase tiene múltiples responsabilidades, se acopla a diferentes partes del sistema y se vuelve más frágil a los cambios.

> [!example] Estrategias para comprenderlo
> *   **Pregunta clave**: "¿Por qué podría cambiar esta clase?" Si la respuesta incluye la palabra "o" (ej. "cambiará si la lógica de cálculo cambia *o* si la forma de guardar los datos cambia"), entonces probablemente tiene más de una responsabilidad.
> *   **Cohesión**: Busca clases con alta cohesión (sus métodos y datos están fuertemente relacionados con su única responsabilidad) y bajo acoplamiento (depende poco de otras clases).
> *   **Separación de preocupaciones**: Identifica las diferentes "preocupaciones" o tareas que una clase está manejando y sepáralas en clases distintas.

### Ejemplo básico en Java + POO

> [!error] Mal ejemplo (Violación de SRP)
Una clase `Reporte` que se encarga tanto de generar el contenido del reporte como de guardarlo en un archivo.
> ```java
> // Clase que viola el SRP
> class Reporte {
>     private String contenido;
> 
>     public Reporte(String contenido) {
>         this.contenido = contenido;
>     }
> 
>     // Responsabilidad 1: Generar el contenido del reporte
>     public String generarContenido() {
>         // Lógica compleja para formatear el reporte
>         return "Contenido del reporte: " + this.contenido;
>     }
> 
>     // Responsabilidad 2: Guardar el reporte en un archivo
>     public void guardarEnArchivo(String nombreArchivo) {
>         System.out.println("Guardando reporte en " + nombreArchivo + "...");
>         // Lógica para escribir el contenido en un archivo
>         System.out.println("Reporte guardado.");
>     }
> }
> 
> public class MainSRPMalo {
>     public static void main(String[] args) {
>         Reporte miReporte = new Reporte("Datos de ventas de Enero");
>         String contenidoGenerado = miReporte.generarContenido();
>         System.out.println(contenidoGenerado);
>         miReporte.guardarEnArchivo("ventas_enero.txt");
>     }
> }
> ```

> [!warning] Problema
> Si cambia la lógica de cómo se genera el reporte, esta clase debe cambiar. Si cambia la forma en que se guarda (ej. a una base de datos o a la nube), esta clase también debe cambiar. Tiene dos razones para cambiar.

> [!success]  Buen ejemplo (Aplicando SRP)
Separamos las responsabilidades en dos clases: `GeneradorReporte` y `GuardadorReporte`.
> ```java
> // Clase con una única responsabilidad: Generar el contenido del reporte
> class GeneradorReporte {
>     public String generarContenido(String datos) {
>         // Lógica compleja para formatear el reporte
>         return "Contenido del reporte: " + datos;
>     }
> }
> 
> // Clase con una única responsabilidad: Guardar el reporte
> class GuardadorReporte {
>     public void guardarEnArchivo(String contenido, String nombreArchivo) {
>         System.out.println("Guardando reporte en " + nombreArchivo + "...");
>         // Lógica para escribir el contenido en un archivo
>         System.out.println("Reporte guardado.");
>     }
> }
> 
> public class MainSRPBueno {
>     public static void main(String[] args) {
>         GeneradorReporte generador = new GeneradorReporte();
>         String contenidoGenerado = generador.generarContenido("Datos de ventas de Enero");
>         System.out.println(contenidoGenerado);
> 
>         GuardadorReporte guardador = new GuardadorReporte();
>         guardador.guardarEnArchivo(contenidoGenerado, "ventas_enero.txt");
>     }
> }
> ```

> [!bug] Beneficio
> Ahora, si la lógica de generación cambia, solo `GeneradorReporte` se modifica. Si la lógica de guardado cambia, solo `GuardadorReporte` se modifica. Cada clase tiene una única razón para cambiar.

---

## 2. [O] - Principio Abierto/Cerrado

> [!quote] Descripción
> Las entidades de software (clases, módulos, funciones, etc.) deben estar abiertas a la extensión, pero cerradas a la modificación. Esto significa que deberías poder agregar nuevas funcionalidades sin cambiar el código existente que ya funciona.

> [!example] Estrategias para comprenderlo
> *   **Abierto a extensión**: Puedes agregar nuevas características o comportamientos.
> *   **Cerrado a modificación**: No necesitas cambiar el código fuente de las clases existentes.
> *   **Usa abstracciones**: Este principio se logra a menudo mediante el uso de interfaces y clases abstractas. Define un contrato (interfaz) y permite que diferentes implementaciones lo extiendan.
> *   **Polimorfismo**: Es la clave para implementar OCP.

### Ejemplo básico en Java + POO

> [!error] Mal ejemplo (Violación de OCP)
Una clase `CalculadoraDescuento` que tiene que ser modificada cada vez que se añade un nuevo tipo de descuento.
> ```java
> // Clase que viola el OCP
> class CalculadoraDescuento {
>     public double calcularDescuento(double precio, String tipoDescuento) {
>         if ("VIP".equals(tipoDescuento)) {
>             return precio * 0.10; // 10% de descuento
>         } else if ("Estudiante".equals(tipoDescuento)) {
>             return precio * 0.05; // 5% de descuento
>         } else if ("Empleado".equals(tipoDescuento)) {
>             return precio * 0.15; // 15% de descuento
>         }
>         // Si se añade un nuevo tipo de descuento, esta clase debe ser modificada.
>         return 0;
>     }
> }
> 
> public class MainOCPMalo {
>     public static void main(String[] args) {
>         CalculadoraDescuento calculadora = new CalculadoraDescuento();
>         System.out.println("Descuento VIP: " + calculadora.calcularDescuento(100, "VIP"));
>         System.out.println("Descuento Estudiante: " + calculadora.calcularDescuento(100, "Estudiante"));
>     }
> }
> ```

> [!warning] Problema
> Cada vez que se introduce un nuevo tipo de descuento, la clase `CalculadoraDescuento` debe ser modificada (se añade otro `else if`). Esto viola el OCP.

> [!success]  Buen ejemplo (Aplicando OCP)
Definimos una interfaz `Descuento` y creamos implementaciones concretas para cada tipo de descuento. La `CalculadoraDescuento` ahora depende de la abstracción `Descuento`.
> ```java
> // Interfaz que define el contrato para cualquier tipo de descuento
> interface Descuento {
>     double aplicarDescuento(double precio);
> }
> 
> // Implementación concreta para descuento VIP
> class DescuentoVIP implements Descuento {
>     @Override
>     public double aplicarDescuento(double precio) {
>         return precio * 0.10; // 10% de descuento
>     }
> }
> 
> // Implementación concreta para descuento de Estudiante
> class DescuentoEstudiante implements Descuento {
>     @Override
>     public double aplicarDescuento(double precio) {
>         return precio * 0.05; // 5% de descuento
>     }
> }
> 
> // Implementación concreta para descuento de Empleado
> class DescuentoEmpleado implements Descuento {
>     @Override
>     public double aplicarDescuento(double precio) {
>         return precio * 0.15; // 15% de descuento
>     }
> }
> 
> // La calculadora ahora depende de la abstracción Descuento
> class CalculadoraDescuentoOCP {
>     public double calcular(double precio, Descuento descuento) {
>         return descuento.aplicarDescuento(precio);
>     }
> }
> 
> public class MainOCPBueno {
>     public static void main(String[] args) {
>         CalculadoraDescuentoOCP calculadora = new CalculadoraDescuentoOCP();
> 
>         Descuento descuentoVIP = new DescuentoVIP();
>         System.out.println("Descuento VIP: " + calculadora.calcular(100, descuentoVIP));
> 
>         Descuento descuentoEstudiante = new DescuentoEstudiante();
>         System.out.println("Descuento Estudiante: " + calculadora.calcular(100, descuentoEstudiante));
> 
>         // Si se añade un nuevo tipo de descuento (ej. DescuentoNavidad),
>         // solo se crea una nueva clase que implementa Descuento.
>         // La clase CalculadoraDescuentoOCP no necesita ser modificada.
>         Descuento descuentoEmpleado = new DescuentoEmpleado();
>         System.out.println("Descuento Empleado: " + calculadora.calcular(100, descuentoEmpleado));
>     }
> }
> ```

> [!bug] Beneficio
> Para añadir un nuevo tipo de descuento, simplemente creamos una nueva clase que implemente la interfaz `Descuento`. La clase `CalculadoraDescuentoOCP` permanece sin cambios, cumpliendo con el OCP.

---

## 3. [L] - Principio de Sustitución de Liskov

> [!quote] Descripción
> Las subclases deben poder sustituir a sus clases base sin alterar la corrección del programa. En otras palabras, si un programa funciona con un objeto de una clase base, también debe funcionar correctamente cuando se le pasa un objeto de una subclase de esa clase base.

> [!example] Estrategias para comprenderlo
> *   **"Es un" real**: Asegúrate de que la relación de herencia "es un" sea realmente válida y que la subclase no rompa el contrato de la superclase.
> *   **Contratos y pre/post-condiciones**: Una subclase no debe requerir más precondiciones ni garantizar menos postcondiciones que su superclase.
> *   **No lanzar nuevas excepciones inesperadas**: Las subclases no deben lanzar excepciones que no sean esperadas por el código cliente que usa la clase base.
> *   **Evitar `instanceof`**: Si constantemente necesitas verificar el tipo de un objeto con `instanceof` para decidir qué hacer, es una señal de que podrías estar violando LSP.

### Ejemplo básico en Java + POO

> [!error] Mal ejemplo (Violación de LSP)
Un ejemplo clásico es la relación `Cuadrado` que hereda de `Rectangulo`, donde `Cuadrado` modifica el comportamiento de `setAncho` y `setAlto` de una manera que rompe las expectativas de un `Rectangulo`. Usaremos un ejemplo más sencillo con animales.
> ```java
> // Clase base Pájaro
> class Pajaro {
>     public void volar() {
>         System.out.println("El pájaro está volando.");
>     }
> }
> 
> // Clase Avestruz que hereda de Pájaro, pero no puede volar
> class Avestruz extends Pajaro {
>     @Override
>     public void volar() {
>         // Una avestruz no puede volar, esto rompe la expectativa de la clase base.
>         // Podría lanzar una excepción o simplemente no hacer nada, lo cual es problemático.
>         throw new UnsupportedOperationException("Las avestruces no pueden volar.");
>     }
> }
> 
> public class MainLSPMalo {
>     public static void main(String[] args) {
>         Pajaro pajaroNormal = new Pajaro();
>         pajaroNormal.volar(); // Funciona bien
> 
>         Pajaro avestruz = new Avestruz();
>         try {
>             avestruz.volar(); // Esto lanzará una excepción, rompiendo el programa
>                               // si el cliente espera que todos los pájaros puedan volar.
>         } catch (UnsupportedOperationException e) {
>             System.out.println("Error: " + e.getMessage());
>         }
>     }
> }
> ```

> [!warning] Problema
> El código cliente que espera que cualquier `Pajaro` pueda `volar()` se romperá cuando se le pase una `Avestruz`. La `Avestruz` no puede sustituir a `Pajaro` sin cambiar el comportamiento esperado del programa.

> [!success]  Buen ejemplo (Aplicando LSP)
Creamos una interfaz `Volador` para los pájaros que sí pueden volar, y la clase `Pajaro` puede ser más genérica o abstracta.
> ```java
> // Clase base más genérica para cualquier tipo de ave
> class Ave {
>     public void comer() {
>         System.out.println("El ave está comiendo.");
>     }
> }
> 
> // Interfaz para aves que pueden volar
> interface Volador {
>     void volar();
> }
> 
> // Pájaro que puede volar, implementa la interfaz Volador
> class Gorrion extends Ave implements Volador {
>     @Override
>     public void volar() {
>         System.out.println("El gorrión está volando.");
>     }
> }
> 
> // Avestruz, que es un Ave pero no implementa Volador
> class AvestruzLSP extends Ave {
>     // No tiene el método volar(), o si lo tuviera, no lanzaría una excepción
>     // sino que podría tener un comportamiento específico de avestruz.
>     public void correr() {
>         System.out.println("La avestruz está corriendo.");
>     }
> }
> 
> public class MainLSPBueno {
>     public static void main(String[] args) {
>         // Un gorrión es un Ave y también un Volador
>         Ave ave1 = new Gorrion();
>         ave1.comer();
>         if (ave1 instanceof Volador) {
>             ((Volador) ave1).volar(); // Solo llamamos a volar si sabemos que puede
>         }
> 
>         // Una avestruz es un Ave, pero no un Volador
>         Ave ave2 = new AvestruzLSP();
>         ave2.comer();
>         // ave2.volar(); // Esto no compilaría, lo cual es correcto.
>         if (ave2 instanceof AvestruzLSP) {
>             ((AvestruzLSP) ave2).correr();
>         }
> 
>         // Podemos tener una lista de Voladores
>         Volador[] voladores = new Volador[1];
>         voladores[0] = new Gorrion();
>         // voladores[1] = new AvestruzLSP(); // Esto no compilaría, lo cual es correcto.
> 
>         for (Volador v : voladores) {
>             v.volar(); // Todos los elementos en esta lista pueden volar sin problemas
>         }
>     }
> }
> ```

> [!bug] Beneficio
> Al separar la capacidad de volar en una interfaz, el código cliente que necesita que un objeto vuele solo interactúa con la interfaz `Volador`. Las `AvestruzLSP` no se presentan como `Volador`, evitando la ruptura del contrato.

---

## 4. [I] - Principio de Segregación de Interfaces

> [!quote] Descripción
> Los clientes no deben ser forzados a depender de interfaces que no utilizan. Es mejor tener muchas interfaces pequeñas y específicas que una interfaz grande y monolítica.

> [!example] Estrategias para comprenderlo
> *   **Interfaces "gordas"**: Si una interfaz tiene muchos métodos y las clases que la implementan solo usan un subconjunto de esos métodos, es una señal de que la interfaz es "gorda" y necesita ser segregada.
> *   **Roles específicos**: Piensa en los diferentes "roles" o capacidades que un objeto puede tener y crea una interfaz para cada rol.
> *   **Evita métodos vacíos o excepciones**: Si una clase implementa una interfaz y deja algunos métodos vacíos o lanza `UnsupportedOperationException`, es una clara violación de ISP.

### Ejemplo básico en Java + POO

> [!error] Mal ejemplo (Violación de ISP)
Una interfaz `Trabajador` que incluye métodos para todas las posibles acciones de cualquier tipo de trabajador, incluyendo robots.
> ```java
> // Interfaz "gorda" que viola el ISP
> interface Trabajador {
>     void trabajar();
>     void comer();
>     void dormir();
>     void gestionar(); // Solo algunos trabajadores gestionan
> }
> 
> // Un HumanoTrabajador puede implementar todos los métodos
> class HumanoTrabajador implements Trabajador {
>     @Override
>     public void trabajar() { System.out.println("Humano trabajando..."); }
>     @Override
>     public void comer() { System.out.println("Humano comiendo..."); }
>     @Override
>     public void dormir() { System.out.println("Humano durmiendo..."); }
>     @Override
>     public void gestionar() { System.out.println("Humano gestionando..."); }
> }
> 
> // Un RobotTrabajador es forzado a implementar métodos que no le aplican
> class RobotTrabajador implements Trabajador {
>     @Override
>     public void trabajar() { System.out.println("Robot trabajando..."); }
>     @Override
>     public void comer() {
>         // Un robot no come, este método es irrelevante o debería lanzar una excepción
>         System.out.println("Robot no necesita comer.");
>     }
>     @Override
>     public void dormir() {
>         // Un robot no duerme
>         System.out.println("Robot no necesita dormir.");
>     }
>     @Override
>     public void gestionar() {
>         // Un robot podría o no gestionar, pero si no lo hace, es un método forzado
>         System.out.println("Robot no gestiona.");
>     }
> }
> 
> public class MainISPMalo {
>     public static void main(String[] args) {
>         HumanoTrabajador humano = new HumanoTrabajador();
>         humano.trabajar();
>         humano.comer();
> 
>         RobotTrabajador robot = new RobotTrabajador();
>         robot.trabajar();
>         robot.comer(); // Llamar a esto en un robot es extraño y sin sentido
>     }
> }
> ```

> [!warning] Problema
> `RobotTrabajador` se ve obligado a implementar `comer()` y `dormir()`, que no son relevantes para un robot. Esto hace que la interfaz sea menos útil y más difícil de mantener.

> [!success]  Buen ejemplo (Aplicando ISP)
Dividimos la interfaz `Trabajador` en interfaces más pequeñas y específicas, cada una representando una capacidad o rol.
> ```java
> // Interfaz para entidades que pueden trabajar
> interface TrabajadorProductivo {
>     void trabajar();
> }
> 
> // Interfaz para entidades que pueden comer
> interface Comedor {
>     void comer();
> }
> 
> // Interfaz para entidades que pueden dormir
> interface Dormilon {
>     void dormir();
> }
> 
> // Interfaz para entidades que pueden gestionar
> interface Gestor {
>     void gestionar();
> }
> 
> // HumanoTrabajador implementa las interfaces que le corresponden
> class HumanoTrabajadorISP implements TrabajadorProductivo, Comedor, Dormilon, Gestor {
>     @Override
>     public void trabajar() { System.out.println("Humano trabajando..."); }
>     @Override
>     public void comer() { System.out.println("Humano comiendo..."); }
>     @Override
>     public void dormir() { System.out.println("Humano durmiendo..."); }
>     @Override
>     public void gestionar() { System.out.println("Humano gestionando..."); }
> }
> 
> // RobotTrabajador solo implementa las interfaces que le corresponden
> class RobotTrabajadorISP implements TrabajadorProductivo {
>     @Override
>     public void trabajar() { System.out.println("Robot trabajando..."); }
>     // No necesita implementar comer(), dormir() o gestionar()
> }
> 
> public class MainISPBueno {
>     public static void main(String[] args) {
>         HumanoTrabajadorISP humano = new HumanoTrabajadorISP();
>         humano.trabajar();
>         humano.comer();
>         humano.gestionar();
> 
>         RobotTrabajadorISP robot = new RobotTrabajadorISP();
>         robot.trabajar();
>         // robot.comer(); // Esto no compilaría, lo cual es correcto.
>     }
> }
> ```

> [!bug] Beneficio
> Ahora, `RobotTrabajadorISP` solo implementa `TrabajadorProductivo`, que es la única capacidad que tiene. El código es más claro, y las clases no están forzadas a depender de métodos que no usan.

---

## 5. [D] - Principio de Inversión de Dependencias

> [!quote] Descripción
> 1.  Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones.
> 2.  Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.
z
> [!tip]
> En esencia, esto significa que las clases deben depender de interfaces o clases abstractas en lugar de implementaciones concretas. Esto "invierte" la dependencia tradicional donde los módulos de alto nivel dependen de los de bajo nivel.

> [!example] Estrategias para comprenderlo
> *   **Inyección de dependencias**: Es la forma más común de implementar DIP. En lugar de que una clase cree sus propias dependencias, se le "inyectan" desde fuera (a través del constructor, un setter o un método).
> *   **Programar a una interfaz, no a una implementación**: Siempre que sea posible, usa tipos de interfaz para variables, parámetros y tipos de retorno.
> *   **Evita `new` dentro de clases de alto nivel**: Si una clase de alto nivel usa `new` para crear una instancia de una clase de bajo nivel, está directamente acoplada a esa implementación concreta.

### Ejemplo básico en Java + POO

> [!error] Mal ejemplo (Violación de DIP)
Una clase `Interruptor` que depende directamente de una implementación concreta de `Bombilla`.
> ```java
> // Clase de bajo nivel (detalle)
> class Bombilla {
>     public void encender() {
>         System.out.println("Bombilla encendida.");
>     }
> 
>     public void apagar() {
>         System.out.println("Bombilla apagada.");
>     }
> }
> 
> // Clase de alto nivel que depende directamente de la Bombilla (detalle)
> class Interruptor {
>     private Bombilla bombilla; // Dependencia directa de una implementación concreta
> 
>     public Interruptor() {
>         this.bombilla = new Bombilla(); // El interruptor crea su propia bombilla
>     }
> 
>     public void presionar() {
>         // Lógica para encender/apagar
>         // Aquí se asume que la bombilla tiene un estado interno
>         // Para simplificar, solo la encenderemos
>         bombilla.encender();
>     }
> }
> 
> public class MainDIPMalo {
>     public static void main(String[] args) {
>         Interruptor interruptor = new Interruptor();
>         interruptor.presionar();
>     }
> }
> ```

> [!warning] Problema
> `Interruptor` (módulo de alto nivel) depende directamente de `Bombilla` (módulo de bajo nivel/detalle). Si queremos que el interruptor controle otro tipo de dispositivo (ej. un ventilador), tendríamos que modificar la clase `Interruptor`.

> [!success]  Buen ejemplo (Aplicando DIP)
Introducimos una abstracción (`DispositivoConmutable`) de la que tanto el `Interruptor` como los dispositivos concretos dependerán.
> ```java
> // Abstracción: Interfaz para cualquier dispositivo que pueda ser encendido/apagado
> interface DispositivoConmutable {
>     void encender();
>     void apagar();
> }
> 
> // Clase de bajo nivel (detalle) que implementa la abstracción
> class BombillaDIP implements DispositivoConmutable {
>     @Override
>     public void encender() {
>         System.out.println("Bombilla encendida.");
>     }
> 
>     @Override
>     public void apagar() {
>         System.out.println("Bombilla apagada.");
>     }
> }
> 
> // Otro detalle que implementa la misma abstracción
> class VentiladorDIP implements DispositivoConmutable {
>     @Override
>     public void encender() {
>         System.out.println("Ventilador encendido.");
>     }
> 
>     @Override
>     public void apagar() {
>         System.out.println("Ventilador apagado.");
>     }
> }
> 
> // Clase de alto nivel que depende de la abstracción, no del detalle
> class InterruptorDIP {
>     private DispositivoConmutable dispositivo; // Dependencia de la abstracción
> 
>     // Inyección de dependencia a través del constructor
>     public InterruptorDIP(DispositivoConmutable dispositivo) {
>         this.dispositivo = dispositivo;
>     }
> 
>     public void presionar() {
>         // Lógica para encender/apagar
>         dispositivo.encender(); // El interruptor no sabe qué tipo de dispositivo es, solo que puede encenderlo
>     }
> }
> 
> public class MainDIPBueno {
>     public static void main(String[] args) {
>         // Creamos una bombilla
>         DispositivoConmutable miBombilla = new BombillaDIP();
>         // Creamos un interruptor y le inyectamos la bombilla
>         InterruptorDIP interruptorBombilla = new InterruptorDIP(miBombilla);
>         interruptorBombilla.presionar(); // Enciende la bombilla
> 
>         System.out.println("---");
> 
>         // Creamos un ventilador
>         DispositivoConmutable miVentilador = new VentiladorDIP();
>         // Creamos otro interruptor y le inyectamos el ventilador
>         InterruptorDIP interruptorVentilador = new InterruptorDIP(miVentilador);
>         interruptorVentilador.presionar(); // Enciende el ventilador
>     }
> }
> ```

> [!bug] Beneficio
> `InterruptorDIP` (módulo de alto nivel) ahora depende de la abstracción `DispositivoConmutable`, no de `BombillaDIP` o `VentiladorDIP` (módulos de bajo nivel). Esto significa que podemos cambiar el dispositivo que controla el interruptor sin modificar la clase `InterruptorDIP`, simplemente inyectando una implementación diferente de `DispositivoConmutable`.

---
