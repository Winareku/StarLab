# 📚 Guía de Estudio Completa: Diseño de Software

## 🎯 Análisis del Examen + Contenido de Apuntes

### 0. Examen
![[Examen Practico de Ejemplo.pdf]]

### 1. PRINCIPIOS SOLID (📦DSW 📝NOT 03)

#### 📖 Teoría Fundamental

**Definición:** Cinco principios que crean sistemas comprensibles, flexibles y mantenibles.

| Principio | Concepto Clave | Pregunta para Identificar |
|-----------|----------------|---------------------------|
| **SRP** | Una clase = Una responsabilidad | "¿Por qué podría cambiar esta clase?" Si usa "o" → violación |
| **OCP** | Abierto extensión, cerrado modificación | ¿Puedo añadir funcionalidad sin modificar código? |
| **LSP** | Subclases sustituibles | ¿Puedo usar subclases sin romper el programa? |
| **ISP** | Interfaces pequeñas y específicas | ¿La clase implementa métodos que no usa? |
| **DIP** | Depender de abstracciones | ¿La clase usa `new` para crear dependencias? |

#### 🔍 Ejercicios Prácticos para Examen

**Problema típico en exámenes:**
```java
// ❌ Código que viola múltiples principios
public class ReportService {
    public void generateReport(String type) {
        if (type.equals("PDF")) {
            // lógica PDF
        } else if (type.equals("EXCEL")) {
            // lógica Excel
        }
        // Viola OCP: cerrado a extensión
    }
    
    public void saveReport(String type) { /*...*/ }
    public void sendReport(String type, String method) { /*...*/ }
    // Viola SRP: múltiples responsabilidades
}
```

**Solución aplicando SOLID:**
```java
// ✅ Aplicando todos los principios
// ISP: Interfaces segregadas
interface ReportGenerator {
    void generate();
}

interface ReportStorage {
    void save();
}

interface ReportSender {
    void send();
}

// OCP: Fácil extensión
class PDFGenerator implements ReportGenerator {
    public void generate() { /* PDF */ }
}

class ExcelGenerator implements ReportGenerator {
    public void generate() { /* Excel */ }
}

// SRP: Clases con una responsabilidad
class PDFStorage implements ReportStorage {
    public void save() { /* solo guardar PDF */ }
}

// DIP: Dependencias inyectadas
class ReportService {
    private ReportGenerator generator;
    private ReportStorage storage;
    private ReportSender sender;
    
    public ReportService(ReportGenerator g, ReportStorage s, ReportSender se) {
        this.generator = g;
        this.storage = s;
        this.sender = se;
    }
}
```

---

### 2. UML - DIAGRAMAS (📦DSW 📝NOT 04)

#### 📖 Fundamentos de UML

**UML = Estándar para modelado orientado a objetos**

#### Diagramas de Casos de Uso
```plaintext
Actor -----> [Caso de Uso]
               ↑
          <<include>> / <<extend>>
```

#### Diagramas de Clases - Sintaxis Completa
```java
// Estructura de clase en UML
ClassName
---------------
# attribute : Type = defaultValue
+ operation(param: Type) : ReturnType

// Ejemplo concreto:
Book
---------------
- title : String
# available : Boolean = true
+ borrow() : void
+ returnBook() : Boolean
```

**Relaciones entre clases:**
- **Asociación:** `----` (conexión básica)
- **Agregación:** `◇----` (parte-todo débil)
- **Composición:** `◆----` (parte-todo fuerte)
- **Herencia:** `▷-----` (generalización)

#### Diagramas de Secuencia - Elementos Clave

**Para exámenes debes incluir:**
```plaintext
actor User
participant Controller
participant Service
participant Repository
participant Entity

User->Controller: createTask(data)
Controller->Service: validate(data)
Service->Repository: existsByName(name)
Repository-->Service: false
Service->Entity: new Task(data)
Service->Repository: save(task)
Service->Notifier: notifyUsers()
```

**Operadores UML 2.0 (OBLIGATORIOS en examen):**
```plaintext
alt [condición]
    Mensaje si verdadero
else [otra condición]
    Mensaje si falso
end

loop [para cada elemento]
    Mensaje repetitivo
end

opt [condición opcional]
    Mensaje opcional
end
```

---

### 3. PARADIGMAS DE DISEÑO (📦DSW 📝NOT 02)

#### 🧠 Paradigma Orientado a Aspectos (AOP)

**Problema que resuelve:** *Cross-cutting concerns*
- Logging, seguridad, transacciones
- **Code Tangling:** Múltiples preocupaciones en un módulo
- **Code Scattering:** Una preocupación en múltiples módulos

**Conceptos clave:**
- **Aspecto:** Comportamiento transversal
- **Join Point:** Punto de ejecución
- **Pointcut:** Conjunto de join points
- **Advice:** Código a ejecutar
- **Weaving:** Integración de aspectos

#### 🧩 Paradigma Orientado a Componentes

**Definición:** Componente = Unidad independiente y desplegable

**Características:**
- Composable, desplegable, documentado
- Independiente, estandarizado

**Proceso de desarrollo:**
1. Análisis y búsqueda de componentes
2. Modificación de requerimientos
3. Diseño con reuso
4. Desarrollo e integración

---

### 4. PATRONES CREACIONALES (📦DSW 📝NOT 05)

#### 🏗️ Builder Pattern

**Contexto en examen:** "construcción paso a paso", "personalización flexible"

**Implementación para presentaciones:**
```java
public class Presentation {
    private String title;
    private List<Section> sections;
    private Theme theme;
    
    // Constructor privado - Solo Builder puede crear
    private Presentation(Builder builder) {
        this.title = builder.title;
        this.sections = builder.sections;
        this.theme = builder.theme;
    }
    
    public static class Builder {
        private String title;
        private List<Section> sections = new ArrayList<>();
        private Theme theme = Theme.DEFAULT;
        
        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Builder addSection(Section section) {
            this.sections.add(section);
            return this;
        }
        
        public Builder withTheme(Theme theme) {
            this.theme = theme;
            return this;
        }
        
        public Presentation build() {
            // Validaciones aquí
            if (title == null) throw new IllegalStateException("Title required");
            return new Presentation(this);
        }
    }
}

// Uso en el examen:
Presentation pres = new Presentation.Builder()
    .withTitle("Mi Presentación")
    .addSection(new Section("Introducción"))
    .addSection(new Section("Desarrollo"))
    .withTheme(Theme.DARK)
    .build();
```

#### 🏭 Factory Method vs Abstract Factory

**Factory Method:** Delegar creación a subclases
```java
public abstract class DocumentCreator {
    public abstract Document createDocument();
    
    public void generateReport() {
        Document doc = createDocument();
        doc.generate();
    }
}
```

**Abstract Factory:** Familias de objetos relacionados
```java
public interface UIComponents {
    Button createButton();
    Menu createMenu();
    Panel createPanel();
}
```

#### ⚡ Singleton Pattern

**Para recursos compartidos:**
```java
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Properties config;
    
    private ConfigurationManager() {
        // Cargar configuración
        config = new Properties();
    }
    
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
}
```

---

### 5. PATRONES ESTRUCTURALES (📦DSW 📝NOT 06)

#### 🔌 Adapter Pattern

**Contexto en examen:** "librerías externas", "interfaces incompatibles"

**Solución para exportadores:**
```java
// Interfaz común del sistema
public interface Exporter {
    void export(Presentation presentation);
    String getFormatName();
}

// Clase externa que NO podemos modificar
public class LegacyPPTXExporter {
    public void savePresentation(PPTXDocument doc, String filename) {
        // Lógica específica de PowerPoint
    }
    
    public PPTXDocument createDocument() {
        return new PPTXDocument();
    }
}

// Adaptador que bridge la incompatibilidad
public class PPTXAdapter implements Exporter {
    private LegacyPPTXExporter adaptee;
    
    public PPTXAdapter(LegacyPPTXExporter exporter) {
        this.adaptee = exporter;
    }
    
    @Override
    public void export(Presentation presentation) {
        // Convertir nuestra Presentation a formato PPTX
        PPTXDocument doc = convertToPPTX(presentation);
        adaptee.savePresentation(doc, "presentation.pptx");
    }
    
    @Override
    public String getFormatName() {
        return "PPTX";
    }
    
    private PPTXDocument convertToPPTX(Presentation pres) {
        // Lógica compleja de conversión
        PPTXDocument doc = adaptee.createDocument();
        // Mapear secciones, temas, contenido...
        return doc;
    }
}
```

#### 🌳 Composite Pattern

**Para estructuras jerárquicas:**
```java
public interface PresentationElement {
    void render();
    void add(PresentationElement element);
    void remove(PresentationElement element);
}

public class Slide implements PresentationElement {
    private String title;
    private List<Content> contents;
    
    public void render() {
        System.out.println("Rendering slide: " + title);
        for (Content content : contents) {
            content.render();
        }
    }
    
    // Para hojas, add/remove pueden lanzar excepción o no hacer nada
    public void add(PresentationElement element) {
        throw new UnsupportedOperationException();
    }
}

public class Section implements PresentationElement {
    private String title;
    private List<PresentationElement> elements = new ArrayList<>();
    
    public void render() {
        System.out.println("Rendering section: " + title);
        for (PresentationElement element : elements) {
            element.render(); // Render recursivo
        }
    }
    
    public void add(PresentationElement element) {
        elements.add(element);
    }
    
    public void remove(PresentationElement element) {
        elements.remove(element);
    }
}
```

#### 🎭 Decorator Pattern

**Para añadir funcionalidades dinámicamente:**
```java
public abstract class PresentationDecorator implements Presentation {
    protected Presentation wrappedPresentation;
    
    public PresentationDecorator(Presentation presentation) {
        this.wrappedPresentation = presentation;
    }
    
    @Override
    public void render() {
        wrappedPresentation.render();
    }
}

public class WatermarkDecorator extends PresentationDecorator {
    private String watermark;
    
    public WatermarkDecorator(Presentation presentation, String watermark) {
        super(presentation);
        this.watermark = watermark;
    }
    
    @Override
    public void render() {
        super.render();
        addWatermark();
    }
    
    private void addWatermark() {
        System.out.println("Adding watermark: " + watermark);
    }
}

// Uso:
Presentation basic = new BasicPresentation();
Presentation withWatermark = new WatermarkDecorator(basic, "CONFIDENCIAL");
Presentation withHeader = new HeaderDecorator(withWatermark, "COMPANY LOGO");
```

#### 🏢 Facade Pattern

**Para simplificar subsistemas complejos:**
```java
public class ExportFacade {
    private PDFExporter pdfExporter;
    private HTMLExporter htmlExporter;
    private PPTXAdapter pptxAdapter;
    private Validator validator;
    
    public ExportFacade() {
        this.pdfExporter = new PDFExporter();
        this.htmlExporter = new HTMLExporter();
        this.pptxAdapter = new PPTXAdapter(new LegacyPPTXExporter());
        this.validator = new Validator();
    }
    
    public void exportPresentation(Presentation pres, Format format) {
        // Validar primero
        if (!validator.isValid(pres)) {
            throw new ValidationException("Invalid presentation");
        }
        
        // Exportar según formato
        switch (format) {
            case PDF:
                pdfExporter.export(pres);
                break;
            case HTML:
                htmlExporter.export(pres);
                break;
            case PPTX:
                pptxAdapter.export(pres);
                break;
            default:
                throw new UnsupportedFormatException();
        }
    }
}
```

---

## 🎯 ESTRATEGIA DE RESOLUCIÓN PARA EL EXAMEN

### Sección A: SOLID (35%)

**Paso a paso:**
1. **Identificar violaciones** (10 minutos)
   - Buscar if-else/switch por tipos → Viola OCP
   - Clases con múltiples métodos no relacionados → Viola SRP  
   - Interfaces con muchos métodos → Viola ISP
   - Uso de `new` para dependencias → Viola DIP

2. **Rediseñar** (15 minutos)
   - Crear interfaces específicas
   - Aplicar polimorfismo
   - Usar inyección de dependencias
   - Dibujar diagrama de clases limpio

3. **Implementar código** (10 minutos)
   - Solo estructura, no lógica completa
   - Métodos con System.out.println()
   - Mostrar relaciones claramente

### Sección B: Diagramas de Secuencia (35%)

**Elementos obligatorios:**
- ✅ **Clases** (5%): Todos los objetos participantes
- ✅ **Actores** (5%): Usuario y sistemas externos  
- ✅ **Barras de activación** (5%): Períodos de ejecución
- ✅ **Mensajes** (10%): Síncronos, asíncronos, creación, retorno
- ✅ **Bloques** (10%): alt, opt, loop

**Plantilla para seguir:**
```plaintext
actor Usuario
participant Controlador
participant Servicio  
participant Repositorio
participant Entidad
participant Notificador

Usuario->Controlador: createTask(datos)
Controlador->Servicio: validarTarea(datos)

alt [datos inválidos]
    Servicio-->Controlador: ValidationError
    Controlador-->Usuario: Mostrar error
else [datos válidos]
    Servicio->Repositorio: existeTarea(nombre)
    Repositorio-->Servicio: false
    
    Servicio->Entidad: new Tarea(datos)
    Servicio->Repositorio: guardar(tarea)
    Servicio->Notificador: notificarUsuarios()
    
    Servicio-->Controlador: Éxito
    Controlador-->Usuario: Tarea creada
end
```

### Sección C: Patrones de Diseño (30%)

**Identificación rápida:**
- "Construcción paso a paso" → **Builder**
- "Interfaces incompatibles" → **Adapter** 
- "Estructuras jerárquicas" → **Composite**
- "Funcionalidades dinámicas" → **Decorator**
- "Subsistemas complejos" → **Facade**

**Justificación obligatoria:**
- Explicar POR QUÉ cada patrón resuelve el problema
- Mostrar ventajas sobre alternativas
- Demostrar flexibilidad para cambios futuros

---

## 📋 CHECKLIST PRE-EXAMEN

### ✅ Principios SOLID
- [ ] Sé identificar violaciones de SRP
- [ ] Puedo rediseñar código para cumplir OCP
- [ ] Entiendo cómo aplicar LSP correctamente
- [ ] Sé crear interfaces segregadas (ISP)
- [ ] Puedo aplicar inyección de dependencias (DIP)

### ✅ UML
- [ ] Puedo crear diagramas de secuencia completos
- [ ] Conozco todos los elementos obligatorios
- [ ] Sé usar operadores alt, opt, loop
- [ ] Puedo dibujar diagramas de clases con relaciones correctas

### ✅ Patrones de Diseño
- [ ] Reconozco cuándo usar cada patrón creacional
- [ ] Sé implementar Builder para construcción compleja
- [ ] Puedo crear Adapters para interfaces incompatibles
- [ ] Entiendo cuándo aplicar patrones estructurales

### ✅ Gestión de Tiempo
- [ ] 35 minutos para Sección A
- [ ] 35 minutos para Sección B  
- [ ] 30 minutos para Sección C
- [ ] 10 minutos para revisión final

---

## 🚀 RECOMENDACIONES FINALES

1. **Practica con ejemplos reales** del examen proporcionado
2. **Dibuja rápido pero claro** - los diagramas deben ser legibles
3. **Justifica todas tus decisiones** de diseño
4. **Manten la calma** y gestiona tu tiempo
5. **Revisa que cumples todos los puntos** del enunciado

¡Tú puedes! 💪 Los conceptos están claros, ahora es momento de aplicarlos.