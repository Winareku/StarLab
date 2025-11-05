---
tags:
  - 🎨IHC
  - 📝TAR
cssclasses:
  - center-titles
---

# Proyecto de Sales-Bot

---
## 0. Detalles de la Entrevista
> [!note] Contexto
> - Se realizó la entrevista a un administrador del área de ventas de la empresa OMNISOFT para conocer los procesos que se realizan para administrar la información y ofrecer una solución digital (posiblemente basada en IA) que permita acelerar estos procesos o hacerlos más eficaces.
> - No se pretende llegar a completar e implementar la solución, simplemente llegar a un esquema final sin producir código realmente.

> [!example] Proyecto: SalesBot.
> - Administro el área de Ventas y llevo el control de toda la facturación y recaudación de la empresa.
> - Nuestra área está enfocada en dar información precisa del estado de cuenta de un cliente, tener la cartera de la empresa por edades, el monto recaudado en un año comparado con el anterior, la tasa mensual de incremento o decremento de cartera vencida, los datos de facturación y pagos para hacer una proyección de ingresos en el siguiente periodo.
> - Necesito una solución digital que nos permita tener esta información de forma rápida, eficaz, nos alerte con indicadores basados en criterios definidos previamente y me permita como área tener un seguimiento personalizado de los procesos que se llevan y son críticos

> [!info] Datos de la Entrevista
> **Entrevistado:** Marco Jarrín - Gerente de Soluciones Integrales OMNISOFT (Empresa especializada en el desarrollo de soluciones informáticas totalmente basadas en la tecnología de Internet.)
> **Propósito:** Explorar procesos actuales y viabilidad de un Sales-Bot para gestión de ventas, facturación y cartera

> [!check] Hallazgos Adicionales de Investigación
> **Problema en Ecuador:** Más del 40% de empresas en Ecuador tienen necesidades de automatización financiera. Las PYMES y startups son las más afectadas por falta de presupuesto y conocimiento técnico.
> **Barreras Identificadas:**
> - Económica: Alto costo de soluciones como Power BI
> - Conocimiento: Desconocimiento sobre herramientas digitales
> - Tecnológica: Dificultad para consolidar información dispersa
> **Soluciones Existentes:** Herramientas como ¡Conta, Contífico y Mónica ofrecen facturación básica pero carecen de inteligencia de ventas y alertas personalizadas

---

> [!bug] Herramientas y Procesos que utilizan
> - Todos los módulos de ventas, inventario, bancos, etc. están integrados a la parte contable.
> - El resto de módulos vienen a ser auxiliares del ERP.
> - La empresa usa servicios propios, no requieren elementos de terceros para garantizar que tienen la seguridad de proteger los datos de sus clientes.
> - Están interesados en utilizar agentes de IA para que los usuarios puedan administrar.

> [!tip] Proceso para crear ChatBot
> - El entrevistado nos enseñó una serie de pasos para la implementación de un ChatBot.
> 
> 1. **Definir objetivos**: Establecer la función principal del ChatBot. Lo que nos interesa es manejo y gestión de ventas y cobranzas con dos tipos de usuarios: Clientes de la empresa y Gente que toma decisiones (gerentes, director de ventas, tesorería, etc.). Deben tener diferentes preguntas por parte de la IA.
> 
> 2. **Elegir los canales**: Web, WhatsApp, Redes Sociales, Embebido, etc. Están interesados que sea parte de su sistema o por WhatsApp.
> 
> 3. **Seleccionar la tecnología**: (Nos ofreció como recomendación GitHub) + APIs de IA.
> 
> 4. **Diseñar el flujo**: Lo primordial es identificar quién es el usuario para identificar su perfíl (cliente o tomador de decisiones). Luego presentar una serie de opciones que el usuario pueda ingresar o, mediante lenguaje natural, solicitar consultas específicas.
> 
> 5. **Definir la personalidad**: Cómo va a tratar al usuario, si va a tener género, cómo se comunica (texto o voz).
> 
> 6. **Añadir la IA**: IA como Gemini, ChatGPT, DeepSeek, etc.
> 
> 7. **Pruebas y Ajustes**: Realizar una prueba con los usuarios para tener una retroalimentación y añadir elementos que no fueron incluidos. Añadir preguntas de satisfacción de uso.

> [!quote] Parte Gráfica
> - En una sola pantalla, alguien que toma decisiones debería poder ver cómo va evolucionando la cartera y otros datos con gráficos de barras o pasteles.
> - Esto ayudaría a ver rápidamente si se están incrementando o reduciendo las ventas, cartera, etc.
> - Es fundamental que la herramienta implemente gráficos.
> - Puede resultar conveniente conocer por qué canal los clientes realizan pagos.

> [!warning] Seguridad
> - Tienen cifrada toda la información que viaja con un algoritmo.
> - Prevención de ataques SQL Injection e intermediario.
> - Cumplimiento Ley de Protección de Datos.
> - Perfiles de usuario bien definidos.
> - Los clientes solo deben ser capaces de ver sus propios datos.

***
## 1. Journey Map
> [!success] Solicitud de Reporte  
> Un área de la empresa solicita un reporte financiero específico o se activa un proceso mensual de registro.

> [!failure] Extracción de Datos Contables  
> Se recopilan datos de diversas fuentes (bancos, facturas) para consolidarlos según el objetivo del reporte.

> [!success] Validación y Supervisión de Datos  
> Personal especializado verifica que la información sea correcta, confiable y cumpla con los estándares de calidad.

> [!failure] Envío de Datos  
> Los datos validados se envían a las áreas correspondientes (como contabilidad) para su procesamiento.

> [!success] Cálculo de Indicadores  
> Con software especializado (ej. Excel), se calculan índices, proyecciones, costos u otros indicadores numéricos.

> [!failure] Detección de Criticidad en Cartera  
> Según reglas de negocio, se identifican alertas (ej. saldos bajos) que requieren una acción o supervisión.

> [!failure] Creación de Gráfica e Informe  
> Se consolidan todos los datos en informes finales con gráficos, explicaciones del proceso y las alertas detectadas.

> [!success] Envío y Presentación de Documentos  
> Los reportes se presentan a los solicitantes y, si son documentos legales, se envían a entidades correspondientes (ej. SRI).

> [!note] Redefinición del Problema (Versión Grupal)
> Hemos notado que los encargados de áreas contables y los empleados de un negocio buscan tener visibilidad inmediata y proactiva sobre el estado de su cartera y proyecciones de ingresos. Sin embargo, el hecho de que tengan que extraer, validar y consolidar manualmente datos de muchas fuentes diferentes y buscar los puntos clave en reportes que no cambian, no permite tomar decisiones rápidas ni actuar a tiempo. Si esto continúa, se pueden perder oportunidades de mejorar las decisiones financieras, las proyecciones serán poco exactas y, al final, el crecimiento de la empresa se verá limitado por la lenta reacción al uso de nuevas tecnologías. ¿Cómo podemos lograr que las alertas sobre problemas financieros críticos sean automáticas, personalizadas y fáciles de usar para los negocios?

***

## 2. Diagrama de Afinidad

> [!example] Perfil del Usuario y Contexto Operativo
> 
> - Marco Jarrín es Gerente de Soluciones Integrales con 25 años de experiencia.
>     
> - La empresa desarrolla y utiliza un ERP propio con módulos integrados.
>     
> - Operan en un entorno de alta seguridad con sistemas cifrados.
>     
> - Evitan depender de servicios de terceros para proteger datos sensibles.
>     
> - Interactúan con clientes y tomadores de decisiones internos.
>     
> - Valoran la seguridad, el control interno y el cumplimiento legal (SRI, Ley de Datos).
>     

> [!example] Necesidades y Dolor Principal
> 
> - La información está centralizada, pero no es rápida de acceder ni en tiempo real.
>     
> - No todos los usuarios tienen acceso inmediato e intuitivo a indicadores.
>     
> - Falta una herramienta ágil para consultas rápidas de ventas y cartera.
>     
> - Dificultad para personalizar el seguimiento de procesos críticos.
>     
> - Los procesos de facturación y recaudación son lentos y poco visuales.
>     
> - Preocupación por la dependencia de procesos manuales para reportes.
>     

> [!example] Objetivos y Metas de IA
> 
> - Implementar un chatbot con IA para acelerar consultas de ventas y cartera.
>     
> - Reducir el tiempo de respuesta a menos de 30 segundos en consultas clave.
>     
> - Lograr que el 50% de las consultas se realicen por WhatsApp/IA en 6 meses.
>     
> - Mantener una tasa de éxito del 80% sin necesidad de escalamiento.
>     
> - Agilizar decisiones financieras con datos visuales en tiempo real.
>     
> - Ofrecer servicios más automatizados y modernos a instituciones educativas.
>     

> [!example] Características Deseadas en la Solución
> 
> - Chatbot con lenguaje natural, sin menús complejos.
>     
> - Integración con WhatsApp como canal principal.
>     
> - Segmentación de usuarios para respuestas personalizadas.
>     
> - Gráficos consolidados en una sola pantalla (barras, pasteles).
>     
> - Alertas automáticas basadas en criterios predefinidos.
>     
> - Reconocimiento de voz y reportes automáticos.
>     

> [!example] Requisitos de Seguridad y Personalización
> 
> - La IA debe adaptarse al perfil y rol del usuario.
>     
> - Los clientes solo pueden ver sus propios datos.
>     
> - Cumplimiento estricto de la Ley de Protección de Datos.
>     
> - Perfiles de usuario bien definidos y acceso segmentado.
>     
> - Prevención de ataques (SQL Injection, intermediario).
>     
> - Chatbot con personalidad profesional y adaptable.
>     

> [!example] Proceso de Implementación y Validación
> 
> - Realizar pruebas con usuarios para refinar herramientas.
>     
> - Definir procesos paso a paso para implementar chatbots.
>     
> - Validar flujo y usabilidad con prototipos.
>     
> - Añadir preguntas de satisfacción de uso post-implementación.
>     
> - Fase actual: exploración de IA, sin implementación real.
>     
> - Interés en probar el chatbot con usuarios antes de la implementación final.

***

## 3. Hallazgos y Principios de Diseño

### Hallazgos
> [!warning] Hallazgos Críticos
> - Acceso ineficiente a datos: La información está centralizada pero no es rápida ni intuitiva de acceder
> - Falta de visualización unificada: No existe una vista consolidada en tiempo real de indicadores clave
> - Procesos manuales lentos: La facturación y recaudación dependen de procesos manuales que consumen tiempo
> - Segmentación insuficiente: No hay personalización basada en perfiles de usuario (clientes vs tomadores de decisiones)
> - Barreras de usabilidad: La seguridad robusta dificulta la accesibilidad para algunos usuarios
> - Falta de automatización: No hay alertas automáticas ni proyecciones inteligentes

### Concepto de Diseño
> [!success] Concepto Central: "SalesBot Intelligence"
> **Visión**: Un asistente conversacional inteligente que democratiza el acceso a datos financieros críticos mediante interfaces naturales y seguras, transformando datos complejos en insights accionables para todos los perfiles de usuario.
> 
> **Elementos clave del concepto:**
> - Interacción natural: Chatbot con lenguaje natural que elimina barreras técnicas
> - Visualización unificada: Dashboard consolidado con gráficos claros y en tiempo real
> - Segmentación inteligente: Respuestas y vistas adaptadas al perfil del usuario
> - Seguridad transparente: Protección robusta sin comprometer la usabilidad
> - Multiplataforma: Acceso through canales familiares (WhatsApp, web, APIs)

### Principios de Diseño (Versión Grupal)
> [!example] Principios de Diseño para SalesBot
> 
> **PRINCIPIO 1**: La solución permite recibir alertas proactivas basadas en criterios predefinidos del negocio
> **PRINCIPIO 2**: La solución permite al usuario acceder a información crítica de ventas y cartera en tiempos cortos
> **PRINCIPIO 3**: La solución permite visualizar datos financieros mediante gráficos intuitivos para tomar decisiones
> ***
> **PRINCIPIO 4**: La solución permite adaptar las respuestas y funcionalidades según el perfil y rol del usuario
> **PRINCIPIO 5**: La solución permite interactuar mediante lenguaje natural sin requerir conocimientos técnicos
> **PRINCIPIO 6**: La solución permite mantener la seguridad y privacidad de datos sin comprometer la experiencia de usuario
> **PRINCIPIO 7**: La solución permite integrarse con canales existentes (WhatsApp, web) de forma transparente
> **PRINCIPIO 8**: La solución permite validar y refinar funcionalidades mediante pruebas iterativas con usuarios reales

***
## 4. Ideación y Concepto Final

> [!example] PRINCIPIO 1
> La solución permite al usuario acceder a información crítica de ventas y cartera en menos de 30 segundos.

> [!idea] IDEA 1: Mostrar acciones rápidas de texto
> Un sistema de atajos en la conversación, como cuando un chat de IA te da opciones cuando empiezas a chatear con él y cambie dinámicamente las opciones a medida que avanza la conversación.

> [!example] PRINCIPIO 2
> La solución permite recibir alertas proactivas basadas en criterios predefinidos del negocio.

> [!idea] IDEA 2: Un panel de alertas configurable
> Crear una sección dentro del sistema donde el administrador pueda definir y configurar las condiciones de sus alertas, por ejemplo: “Notificarme si la cartera vencida crece más de un 5% mensual”, “Alertar si un cliente supera su línea de crédito”.

> [!example] PRINCIPIO 3
> La solución permite validar y refinar funcionalidades mediante pruebas iterativas con usuarios reales.

> [!idea] IDEA 3: Integrar un Panel de Feedback
> Después de ciertas interacciones de manera periódica, el SalesBot pedirá una valoración con estrellas y un comentario opcional. Este feedback se recopilará en un panel para el equipo de diseño, permitiendo identificar puntos de dolor y oportunidades de mejora.

> [!example] PRINCIPIO 4
> La solución permite visualizar tendencias financieras mediante gráficos consolidados en una sola vista.

> [!idea] IDEA 4: Un dashboard personalizable
> Una pantalla de inicio que funcione como Dashboard. Este mostraría por defecto los gráficos clave, pero el usuario podrá personalizar esta vista arrastrando, añadiendo o eliminando Widgets gráficos según sus necesidades de monitoreo.

> [!success] PoliSales [Nombre Provisional]
> **Descripción**: Es una aplicación móvil que transforma la gestión financiera mediante tres pilares fundamentales:
> - **Dashboard de Widgets Inteligentes**: Pantalla principal con KPIs financieros personalizables que se cargan inmediatamente al iniciar la app
> - **Asistente Conversacional con IA**: Botón flotante permanente que activa un chatbot con comprensión de lenguaje natural
> - **Sistema de Alertas Proactivas**: Notificaciones push inteligentes categorizadas por urgencia (crítico/medio/bajo)
> 
> **Relación con Principios de Diseño:**
> - **Vista principal de widgets**: Cumple principio de acceso rápido a información crítica (<30 segundos)
> - **Chatbot integrado**: Permite interacción mediante lenguaje natural sin conocimientos técnicos
> - **Sistema de notificaciones**: Implementa alertas proactivas basadas en criterios del negocio

## 5. Iteración en cómo Representar un Concepto de Diseño